package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AppTest {

    @Test
    public void testFileReader(){
        List<String> list = new ArrayList<>();
        list.add("11,Umar Jorgson,SK,30,27,xxxox,xxxxx,xxoxo");
        list.add("1,Jimmy Smiles,UK,29,15,xxoox,xooxo,xxxxo");
        list.add("27,Piotr Smitzer,CZ,30,10,xxxxx,xxxxx,xxxxx");
        CSVReader csvReader = new CSVReader();
        String csvFile = "/Volumes/MacOs - Data/Programare/Input_Output/HOMEWORK-I-O/src/main/java/org/example/file/CSVFile.csv";
        csvReader.readFiles(csvFile);
        Assert.assertEquals(list,csvReader.getLines());
    }
    @Test
    public void testConvertFiles(){
        String str = "11,Umar Jorgson,SK,30,27,xxxox,xxxxx,xxoxo";
        String[] splittedStr = str.split(",");
        CSVReader csvReader = new CSVReader();
        Assert.assertEquals(splittedStr,csvReader.lineSeparator(str));
     }

     @Test
    public void testShooting(){
        String str = "xxxox";
        Rankings rank = new Rankings();
        Assert.assertEquals(10,rank.calculateShooting(str));

     }
    @Test
    public void testShootingAllZero(){
        String str = "ooooo";
        Rankings rank = new Rankings();
        Assert.assertEquals(50,rank.calculateShooting(str));
    }

    @Test
    public void calculateTime(){
        Athlete athlete = new Athlete(11, "Umar Jorgson","SK",0,
                0,"xxxox","xxxxx","xxxxx");
        Rankings rank = new Rankings();
        rank.calculateTime(athlete);
        Assert.assertEquals(10,athlete.getSeconds());

    }


}
