package org.example;

public class App {
    public static void main( String[] args ) {
        CSVReader csvReader = new CSVReader();
        Rankings rank = new Rankings();
        String csvFile = "/Volumes/MacOs - Data/Programare/Input_Output/HOMEWORK-I-O/src/main/java/org/example/file/CSVFile.csv";
        csvReader.readFiles(csvFile);
        rank.athletes = csvReader.convertFile();
        rank.showResults();
    }
}
