package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    List<String> lines = new ArrayList<>();

    public List<String> getLines() {
        return lines;
    }

    public void readFiles(String csvFile){
        String line = null;
        BufferedReader br = null;
        try {
             br = new BufferedReader(new FileReader(csvFile));
             line = br.readLine();
            while(line != null){
                lines.add(line);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String[] lineSeparator(String line){
        String[] values = line.split(",");
        return values;
    }

    public List<Athlete> convertFile() {
        List<Athlete> athletes = new ArrayList<Athlete>();
        String[] variables = null;

        for (String line : lines) {

            variables = lineSeparator(line);

            athletes.add(new Athlete(Integer.parseInt(variables[0]), variables[1], variables[2],
                    Integer.parseInt(variables[3]), Integer.parseInt(variables[4]),
                    variables[5], variables[6], variables[7]));
        }
        return athletes;
    }
}
