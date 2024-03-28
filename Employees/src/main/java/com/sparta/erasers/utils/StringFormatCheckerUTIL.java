package com.sparta.erasers.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatCheckerUTIL {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Z][a-z]+$");
    private static final Pattern GENDER_PATTERN = Pattern.compile("^[MF]$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z]+[.][a-z]+@[a-z]+[.][c][o][a-z]{0,1}[.]?[a-z]*?$");
    private static final Pattern NAME_PREFIX_PATTERN = Pattern.compile("^[MDH][rons]{1,2}[.]$");
    private static final Pattern MIDDLE_INITIAL_PATTERN = Pattern.compile("^[A-Z]$");
    private static final Pattern DATE_PATTERN = Pattern.compile("^[0-9]{1,2}/[0-3]{1}[0-9]/[0-9]{4}$");
    private static final Pattern EMPLOYEE_ID_PATTERN = Pattern.compile("^[0-9]{6}$");
    private static final Pattern SALARY_PATTERN = Pattern.compile("^[0-9]{4,7}$");

    public static Boolean isNameValid(String name) {
        Matcher nameMatcher = NAME_PATTERN.matcher(name);
        return nameMatcher.find();
    }

    public static Boolean isGenderValid(String gender) {
        Matcher genderMatcher = GENDER_PATTERN.matcher(gender);
        return genderMatcher.find();
    }

    public static Boolean isEmailValid(String email) {
        Matcher emailMatcher = EMAIL_PATTERN.matcher(email);
        return emailMatcher.find();
    }

    public static Boolean isNamePrefixValid(String namePrefix) {
        Matcher namePrefixMatcher = NAME_PREFIX_PATTERN.matcher(namePrefix);
        return namePrefixMatcher.find();
    }

    public static Boolean isMiddleInitialValid(String middleInitial) {
        Matcher middleInitialMatcher = MIDDLE_INITIAL_PATTERN.matcher(middleInitial);
        return middleInitialMatcher.find();
    }

    public static Boolean isDateValid(String date) {
        Matcher dateMatcher = DATE_PATTERN.matcher(date);
        return dateMatcher.find();
    }

    public static Boolean isSalaryValid(String salary) {
        Matcher salaryMatcher = SALARY_PATTERN.matcher(salary);
        return salaryMatcher.find();
    }

    public static Boolean isEmployeeIDValid(String EmployeeID) {
        Matcher EmployeeIDMatcher = EMPLOYEE_ID_PATTERN.matcher(EmployeeID);
        return EmployeeIDMatcher.find();
    }
}
