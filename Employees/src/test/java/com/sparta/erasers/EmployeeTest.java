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
    void getFirst_name() {
    }

    @Test
    void getLast_name() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void getGender() {
    }

    @Test
    void getHire_date() {
    }

    @Test
    void getName_prefix() {
    }

    @Test
    void getSalary() {
    }

    @Test
    void getMiddle_initial() {
    }
}