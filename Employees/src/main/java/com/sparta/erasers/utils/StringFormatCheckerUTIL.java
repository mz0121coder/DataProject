package com.sparta.erasers.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFormatCheckerUTIL {
    public static Boolean isNameValid(String name) {
        Pattern firstNamePattern = Pattern.compile("^[A-Z][a-z]+$");
        Matcher firstNameMatcher = firstNamePattern.matcher(name);
        return firstNameMatcher.find();
    }

    public static Boolean isGenderValid(String gender) {
        Pattern genderPattern = Pattern.compile("^[MF]$");
        Matcher genderMatcher = genderPattern.matcher(gender);
        return genderMatcher.find();
    }

    public static Boolean isEmailValid(String email) {
        Pattern emailPattern = Pattern.compile("^[a-z]+[.][a-z]+@[a-z]+[.][c][o][a-z]{0,1}[.]?[a-z]*?$");
        Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.find();
    }

    public static Boolean isNamePrefixValid(String namePrefix) {
        Pattern namePrefixPattern = Pattern.compile("^[MDH][rons]{1,2}[.]$");
        Matcher namePrefixMatcher = namePrefixPattern.matcher(namePrefix);
        return namePrefixMatcher.find();
    }

    public static Boolean isMiddleInitialValid(String middleInitial) {
        Pattern middleInitialPattern = Pattern.compile("^[A-Z]$");
        Matcher middleInitialMatcher = middleInitialPattern.matcher(middleInitial);
        return middleInitialMatcher.find();
    }
}
