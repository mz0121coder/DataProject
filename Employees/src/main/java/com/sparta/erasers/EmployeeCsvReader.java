package com.sparta.erasers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class EmployeeCsvReader {
    public static void main(String[] args) {

    // parses a String of Employee information, and constructs and returns an Employee object from it

        Path input = Paths.get("src/main/java/com/sparta/erasers/employees_short.csv");
        Path output = Paths.get("src/main/java/com/sparta/erasers/output.txt");
        EmployeeCsvReader csvReader = new EmployeeCsvReader();
        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(input);
            //System.out.println(reader.readLine());
            System.out.println(reader.readLine());

            csvReader.createEmployee(reader.readLine());
            System.out.println(csvReader.createEmployee(reader.readLine()).getEmail());
        } catch (IOException e) {
            System.out.println("Not found.");
        }
        System.out.println(csvReader.readFileLines("employees_short.csv").size());


    }

    public Employee createEmployee(String line) {

        String[] attributes;
        attributes = line.split(",");

        Employee employee = new Employee(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4], attributes[5], attributes[6], attributes[7], attributes[8], attributes[9]);
        return employee;
    }
    // The JUnit test should validate that the Employee object contains the correct information


    // opens and reads a file and returns a ArrayList of Strings, one for each line
    public ArrayList<String>  readFileLines(String fileName) {
        ArrayList<String> fileLines = new ArrayList<>();
        String filePath = "src/main/java/com/sparta/erasers/" + fileName;
        Path input = Paths.get(filePath);
        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(input);
            reader.skip(107);
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                fileLines.add(line);
            }
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return fileLines;
    }


    // creates an ArrayList of Employee objects from information stored in a .csv file.
//    public ArrayList<Employee> readEmployees(String fileName) {...}

}
