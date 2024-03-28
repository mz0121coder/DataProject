package com.sparta.erasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeCsvReaderTest {
    @Test
    void createEmployee() {
        EmployeeCsvReader reader = new EmployeeCsvReader();
        Assertions.assertNotNull(reader.createEmployee("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294"));
    }

    @Test
    void testReadFileLines() {
        EmployeeCsvReader reader = new EmployeeCsvReader();
        Assertions.assertEquals(reader.readFileLines("employees_short.csv").size(), 10);
    }

    @Test
    void testReadFirstFileLineObject() {
        EmployeeCsvReader reader = new EmployeeCsvReader();
        Assertions.assertEquals(reader.readFileLines("employees_short.csv").get(0), "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,02/01/2008,69294");
    }

    @Test
    void testReadLastFileLineObject() {
        EmployeeCsvReader reader = new EmployeeCsvReader();
        Assertions.assertEquals(reader.readFileLines("employees_short.csv").get(reader.readEmployees("employees_short.csv").size()-1), "744723,Hon.,Bibi,H,Paddock,F,bibi.paddock@yahoo.co.in,10/20/1991,11/02/2016,87148");

    }

    @Test
    void testReadEmployees() {
        EmployeeCsvReader reader = new EmployeeCsvReader();
        Assertions.assertEquals(reader.readEmployees("employees_short.csv").size(), 10);
    }

    @Test
    void testReadFirstEmployeeObject() {
        EmployeeCsvReader reader = new EmployeeCsvReader();
        Assertions.assertEquals(reader.readEmployees("employees_short.csv").get(0).getEmp_no(), 198429);
    }

    @Test
    void testReadLastEmployeeObject() {
        EmployeeCsvReader reader = new EmployeeCsvReader();
        Assertions.assertEquals(reader.readEmployees("employees_short.csv").get(reader.readEmployees("employees_short.csv").size()-1).getEmp_no(), 744723);
    }
}