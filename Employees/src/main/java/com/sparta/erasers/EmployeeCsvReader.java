package com.sparta.erasers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class EmployeeCsvReader {
    public static void main(String[] args) {

    // parses a String of Employee information, and constructs and returns an Employee object from it
//    public Employee createEmployee(String line) {
        Path input = Paths.get("src/main/java/com/sparta/erasers/employees_short.csv");
        Path output = Paths.get("src/main/java/com/sparta/erasers/output.txt");

        BufferedReader reader = null;
        try {
            reader = Files.newBufferedReader(input);
            System.out.println(reader.readLine());
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Not found.");
        }

//;    }
    }
    // The JUnit test should validate that the Employee object contains the correct information


    // opens and reads a file and returns a ArrayList of Strings, one for each line
//    public ArrayList<String>  readFileLines(String fileName) {...}


    // creates an ArrayList of Employee objects from information stored in a .csv file.
//    public ArrayList<Employee> readEmployees(String fileName) {...}

}
