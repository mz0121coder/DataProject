package com.sparta.erasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    //The JUnit test should validate that the Employee object contains the correct information
    Employee employee = new Employee(198429, "Mrs.", "Serafina","I", "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", LocalDate.of(1982,9,21), LocalDate.of(2008,2,1),69294);

    @Test
    @DisplayName("check first item of the employee object contains a No")
    void checkTheFirstItemOfTheEmployeeObjectContainsANo() {
        Assertions.assertEquals(employee.getEmp_no(), 198429);
    }

    @Test
    @DisplayName("check the method get dob in correct format")
    void getBirth_date() {
        Pattern dobPattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        Matcher dobMatcher = dobPattern.matcher(employee.getBirth_date().toString());
        Assertions.assertTrue(dobMatcher.find());
    }

    @Test
    @DisplayName("check if first name is returned")
    void getFirst_name() {
        Assertions.assertEquals(employee.getFirst_name(), "Serafina");
    }

    @Test
    @DisplayName("check if first name is not null")
    void checkFirstNameIsNotNull() {
        Assertions.assertNotNull(employee.getFirst_name());
    }

    @Test
    @DisplayName("check if second name is returned")
    void getLast_name() {
        Assertions.assertEquals(employee.getLast_name(), "Bumgarner");
    }

    @Test
    @DisplayName("check if second name is not null")
    void checkSecondNameIsNotNull() {
        Assertions.assertNotNull(employee.getLast_name());
    }

    @Test
    @DisplayName("checks if email is returned")
    void getEmail() {
        Assertions.assertEquals(employee.getEmail(), "serafina.bumgarner@exxonmobil.com");
    }

    @Test
    @DisplayName("Checks if Gender is returned")
    void getGender() {
        Assertions.assertEquals(employee.getGender(), "F");
    }

    @Test
    void getHire_date() {
        Assertions.assertEquals(employee.getHire_date(), LocalDate.of(2008,2,1));
    }

    @Test
    void getName_prefix() {
        Assertions.assertEquals(employee.getName_prefix(), "Mrs.");
    }

    @Test
    void getSalary() {
        Assertions.assertEquals(employee.getSalary(), 69294);
    }

    @Test
    @DisplayName("Check if returns correct Initial")
    void getMiddle_initial() {
        Assertions.assertEquals(employee.getMiddle_initial(), "I");
    }

    @Test
    @DisplayName("Check if Initial is only 1 character")
    void middleInitialIsOnlyOneChar() {
        Assertions.assertTrue(employee.getMiddle_initial().length() == 1);
    }
}