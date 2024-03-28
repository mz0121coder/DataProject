package com.sparta.erasers;

import java.time.LocalDate;

public class Employee {
    private int emp_no;
    private LocalDate birth_date;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private LocalDate hire_date;
    private int salary;
    private String middle_initial;
    private String name_prefix;

    public Employee(int emp_no, String name_prefix, String first_name, String middle_initial, String last_name, String gender, String email, LocalDate birth_date, LocalDate hire_date, int salary) {
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.hire_date = hire_date;
        this.name_prefix = name_prefix;
        this.middle_initial = middle_initial;
        this.salary = salary;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public String getName_prefix() {
        return name_prefix;
    }

    public int getSalary() {
        return salary;
    }

    public String getMiddle_initial() {
        return middle_initial;
    }

}