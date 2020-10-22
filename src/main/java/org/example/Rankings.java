package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rankings {
    List<Athlete> athletes = new ArrayList<>();

    public int calculateShooting(String line){
        int seconds = 0;
        String[] shootingValues = line.split("");
        for(int i =0 ; i <5 ; i++) {
            if (shootingValues[i].equals("o")) {
                seconds += 10;
            }
        }
        return seconds;
    }
    public void calculateTime(Athlete athlete){
                athlete.setSeconds(athlete.getSeconds()+
                calculateShooting(athlete.getFirstShooting())+
                calculateShooting(athlete.getSecondShooting())+
                calculateShooting(athlete.getThirdShooting()));

        if (athlete.getSeconds()>=60)
            while(athlete.getSeconds()>=60){
                athlete.setMinutes(athlete.getMinutes()+1);
                athlete.setSeconds(athlete.getSeconds()-60);
            }
    }
    static class TimeComparator implements Comparator<Athlete> {
        @Override
        public int compare(Athlete a1, Athlete a2) {
            if (a1.getMinutes()==a2.getMinutes()&&a1.getSeconds()==a2.getSeconds())
                return 0;
            if (a1.getMinutes()==a2.getMinutes()&&a1.getSeconds()>a2.getSeconds())
                return 1;
            if (a1.getMinutes()>a2.getMinutes())
                return 1;
            return -1;
        }
    }
    public void calculateResults(){
        for (Athlete athlete : athletes){
            calculateTime(athlete);
        }
        Collections.sort(athletes,new TimeComparator());

    }
    public void showResults(){
        calculateResults();
        System.out.println("======RANKINGS==========");
        System.out.println("The winner is -->> "+athletes.get(0).getAthleteName()+" "+athletes.get(0).getMinutes()+
                ":"+athletes.get(0).getSeconds());
        System.out.println("The Runner-up The Runner-up is -->>"+athletes.get(1).getAthleteName()+" "+athletes.get(1).getMinutes()+
                ":"+athletes.get(1).getSeconds());
        System.out.println("- Third Place The Runner-up is -->>"+athletes.get(2).getAthleteName()+" "+athletes.get(2).getMinutes()+
                ":"+athletes.get(2).getSeconds());
    }
}
