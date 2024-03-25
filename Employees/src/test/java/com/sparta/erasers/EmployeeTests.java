package com.sparta.erasers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeTests {
    @Test
    @DisplayName("Given valid string of employee details, createEmployee method returns correctly constructed employee object")
    void givenValidString_CreateEmployee_ReturnsCorrectlyConstructedEmployeeObject() {
        String data = "784160,Dr.,Corey,A,Jackman,M,corey.jackman@gmail.com,04/12/1959,6/29/1984,57616";
        EmployeeCsvReader csvReader = new EmployeeCsvReader();
        Employee employee = csvReader.createEmployee(data);

        Assertions.assertEquals(employee.getEmp_no(), "784160");
    }
}
