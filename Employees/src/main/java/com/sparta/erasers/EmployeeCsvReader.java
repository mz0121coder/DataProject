package com.sparta.erasers;

import com.sparta.erasers.utils.DateParserUTIL;
import com.sparta.erasers.utils.LoggerUTIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeCsvReader {
    private static final Logger LOGGER = Logger.getLogger("EmployeeCsvReaderLogger");
    public static void main(String[] args) {
        //LOGGER
        LoggerUTIL.setUpHandlers(LOGGER);
        LoggerUTIL.setLoggerLevel(LOGGER, Level.ALL);
        LoggerUTIL.addFileHandler(LOGGER);
        LoggerUTIL.addConsoleHandler(LOGGER);


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

        ArrayList<Employee> empArrList = new ArrayList<>();
        empArrList = csvReader.readEmployees("employees_short.csv");
        System.out.println(empArrList.get(1).getEmp_no());
        System.out.println(empArrList.size());


    }

    public Employee createEmployee(String line) {

        String[] attributes;
        attributes = line.split(",");

        //Slightly unneeded variables (Could parse in constructor)
        LocalDate employeeBirthDate = DateParserUTIL.parseDate(attributes[7]);
        LocalDate employeeHireDate = DateParserUTIL.parseDate(attributes[8]);

        int employeeNumber1 = Integer.parseInt(attributes[0]);
        int employeeSalary1 = Integer.parseInt(attributes[9]);



        Employee employee = new Employee(employeeNumber1, attributes[1], attributes[2], attributes[3], attributes[4], attributes[5], attributes[6], employeeBirthDate, employeeHireDate, employeeSalary1);
        //LOGGER.log(Level.INFO, "👔Created employee No: " + employee.getEmp_no());
        LOGGER.log(Level.INFO, String.format("👔Created employee - \nNo: %s \nTitle: %s\nFirst Name: %s\nMiddle Initial: %s\nLast Name: %s\nGender: %s\nEmail: %s\nBirth Date: %s\nHire date: %s\nSalary: %s", employee.getEmp_no(), employee.getName_prefix(), employee.getFirst_name(), employee.getMiddle_initial(), employee.getLast_name(), employee.getGender(), employee.getEmail(), employee.getBirth_date(), employee.getHire_date(), employee.getSalary()));
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
            LOGGER.log(Level.INFO, "🟢Started reading lines from file...");
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                LOGGER.log(Level.FINE, "👀Read Line - " + line);
                fileLines.add(line);
            }
            LOGGER.log(Level.INFO, "🔴Finished Reading.");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return fileLines;
    }


    // creates an ArrayList of Employee objects from information stored in a .csv file.
    public ArrayList<Employee> readEmployees(String fileName) {
        ArrayList<Employee> empArrList = new ArrayList<>();
        ArrayList<String> lineArrList = new ArrayList<>();
        lineArrList = readFileLines(fileName);
        LOGGER.log(Level.INFO, "🟢Starting adding employees to employee list...");
        for(String s : lineArrList) {
            Employee e = createEmployee(s);
            empArrList.add(e);
            LOGGER.log(Level.FINE, "👷‍♂️Added Employee: " + e.getEmp_no());
        }
        LOGGER.log(Level.INFO, "🔴Done with adding employees to employee list.");
        return empArrList;
    }

    // Logger

}
