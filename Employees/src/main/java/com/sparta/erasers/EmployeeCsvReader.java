package com.sparta.erasers;

import com.sparta.erasers.utils.DateParserUTIL;
import com.sparta.erasers.utils.IntParserUTIL;
import com.sparta.erasers.utils.LoggerUTIL;
import com.sparta.erasers.utils.StringFormatCheckerUTIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeCsvReader {
    private static final Logger LOGGER = Logger.getLogger("EmployeeCsvReaderLogger");
    public static void main(String[] args) {
        //LOGGER
        setUpLogger();

        // parses a String of Employee information, and constructs and returns an Employee object from it

        EmployeeCsvReader csvReader = new EmployeeCsvReader();
        ArrayList<Employee> employeeObjectList = new ArrayList<>();
        employeeObjectList = csvReader.readEmployees("employees_short.csv");
        System.out.println(employeeObjectList);
    }

    private static void setUpLogger() {
        LoggerUTIL.setUpHandlers(LOGGER);
        LoggerUTIL.setLoggerLevel(LOGGER, Level.ALL);
    }

    public Employee createEmployee(String line) {
        String[] attributes;
        attributes = line.split(",");

        ArrayList<LocalDate> parsedDateAttributes = parseDateAttributes(attributes[7], attributes[8]);
        int[] parsedIntAttributes = parseIntAttributes(attributes[0], attributes[9]);

        Employee employee = new Employee(parsedIntAttributes[0], attributes[1], attributes[2], attributes[3], attributes[4], attributes[5], attributes[6], parsedDateAttributes.get(0), parsedDateAttributes.get(1), parsedIntAttributes[1]);

        //LOGGER.log(Level.INFO, "👔Created employee No: " + employee.getEmp_no());
        LOGGER.log(Level.INFO, String.format("👔Created employee object - {No: %s, Title: %s, First Name: %s, Middle Initial: %s, Last Name: %s, Gender: %s, Email: %s, Birth Date: %s, Hire date: %s, Salary: %s}", employee.getEmp_no(), employee.getName_prefix(), employee.getFirst_name(), employee.getMiddle_initial(), employee.getLast_name(), employee.getGender(), employee.getEmail(), employee.getBirth_date(), employee.getHire_date(), employee.getSalary()));
        return employee;
    }

    private int[] parseIntAttributes(String employeeID, String salary) {
        return new int[]{IntParserUTIL.parseStringToInt(employeeID), IntParserUTIL.parseStringToInt(salary)};
    }

    private ArrayList<LocalDate> parseDateAttributes(String birthDate, String hireDate) {
        return new ArrayList<>(Arrays.asList(DateParserUTIL.parseDate(birthDate), DateParserUTIL.parseDate(hireDate)));
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
                if(validateLine(line)) {
                    fileLines.add(line);
                } else {
                    writeInvalidLineToFile(line);

                }
            }
            LOGGER.log(Level.INFO, "🔴Finished Reading.");
        } catch (IOException e) {
            System.out.println("File not found.");
        }
        return fileLines;
    }

    private void writeInvalidLineToFile(String line) {
        Path output = Paths.get("src/main/java/com/sparta/erasers/invalidLines");
        try {
            Files.write(output, (line + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validateLine(String line) {
        String[] attributes = line.split(",");
        if (!StringFormatCheckerUTIL.isEmployeeIDValid(attributes[0])) {
            logInvalidLine(attributes[0], "Employee ID", line, LOGGER);
            return false;
        }
        if (!StringFormatCheckerUTIL.isNamePrefixValid(attributes[1])) {
            logInvalidLine(attributes[1], "Name Prefix", line, LOGGER);
            return false;
        }
        if (!StringFormatCheckerUTIL.isNameValid(attributes[2])) {
            logInvalidLine(attributes[2], "First Name", line, LOGGER);
            return false;
        }
        if (!StringFormatCheckerUTIL.isMiddleInitialValid(attributes[3])) {
            logInvalidLine(attributes[3], "Middle Initial", line, LOGGER);
            return false;
        }
        if (!StringFormatCheckerUTIL.isNameValid(attributes[4])) {
            logInvalidLine(attributes[4], "Last Name", line, LOGGER);
            return false;
        }
        if (!StringFormatCheckerUTIL.isGenderValid(attributes[5])) {
            logInvalidLine(attributes[5], "Gender", line, LOGGER);
            return false;
        }
        if (!StringFormatCheckerUTIL.isEmailValid(attributes[6])) {
            logInvalidLine(attributes[6], "Email", line, LOGGER);
            return false;
        }
        if (!StringFormatCheckerUTIL.isDateValid(attributes[7])) {
            logInvalidLine(attributes[7], "Birth Date", line, LOGGER);
            return false;
        }
        if (!StringFormatCheckerUTIL.isDateValid(attributes[8])) {
            logInvalidLine(attributes[8], "Hire Date", line, LOGGER);
            return false;
        }
        if (!StringFormatCheckerUTIL.isSalaryValid(attributes[9])) {
            logInvalidLine(attributes[9], "Salary", line, LOGGER);
            return false;
        }

        return true;
    }

    public void logInvalidLine (String attribute, String attributeName, String line, Logger LOGGER) {
        LOGGER.log(Level.WARNING, "🤦‍♂️ " + attributeName + " invalid - " + attribute + " - line has been skipped \nLine skipped - \"" + line + "\"");
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
            LOGGER.log(Level.FINE, "👷‍♂️Added Employee to employee list: " + e.getEmp_no());
        }
        LOGGER.log(Level.INFO, "🔴Done with adding employees to employee list.");
        return empArrList;
    }

    // Logger

}
