package com.sparta.erasers;

public class Employee {
    // SIYU HERE
    private String emp_no;
    private String birth_date;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String hire_date;

    public Employee(String emp_no, String birth_date, String first_name, String last_name, String email, String gender, String hire_date) {
        this.emp_no = emp_no;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.gender = gender;
        this.hire_date = hire_date;
    }

    public String getEmp_no() {
        return emp_no;
    }

    public String getBirth_date() {
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

    public String getHire_date() {
        return hire_date;
    }
}

