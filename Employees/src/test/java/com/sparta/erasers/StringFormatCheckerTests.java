package com.sparta.erasers;

import com.sparta.erasers.utils.StringFormatCheckerUTIL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringFormatCheckerTests {
    @ParameterizedTest
    @ValueSource(strings = {"123456", "982365", "081643"})
    @DisplayName("Given a valid employee number, isEmployeeNumberValid method returns true")
    void givenAValidEmployeeNumber_IsEmployeeNumberValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isEmployeeIDValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "1234567", "letter", "", "123agg"})
    @DisplayName("Given an invalid employee number, isEmployeeNumberValid method returns false")
    void givenAnInvalidEmployeeNumber_IsEmployeeNumberValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isEmployeeIDValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Mrs.", "Mr.", "Dr.", "Hon."})
    @DisplayName("Given a valid name prefix, isNamePrefixValid method returns true")
    void givenAValidNamePrefix_IsNamePrefixValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isNamePrefixValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Mrsss.", "mr.", "Dar.", "n.", "", "dr."})
    @DisplayName("Given a invalid name prefix, isNamePrefixValid method returns false")
    void givenAInvalidNamePrefix_IsNamePrefixValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isNamePrefixValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tom", "Alex"})
    @DisplayName("Given a valid name, isNameValid method returns true")
    void givenAValidName_IsNameValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isNameValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tom1", "Alex Blunt", ""})
    @DisplayName("Given an invalid name, isNameValid method returns false")
    void givenAnInvalidName_IsNameValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isNameValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"rhett.wan@hotmail.com", "bibi.paddock@yahoo.co.in", "juliette.rojo@yahoo.co.uk"})
    @DisplayName("Given a valid email, isEmailValid method returns true")
    void givenAValidEmail_IsEmailValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isEmailValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "rhett.wanAthotmail.com", "paddock@yahoo.co.in", "juliette.rojo@yahoo.co.uk.gov.something", "yahoo.co.uk", "abc@gmail", "rhett.wan1@hotmail.com"})
    @DisplayName("Given an invalid email, isEmailValid method returns false")
    void givenAnInvalidEmail_IsEmailValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isEmailValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"M", "F"})
    @DisplayName("Given a valid gender, isGenderValid method returns true")
    void givenAValidGender_IsGenderValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isGenderValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Male", "Female", "D", "1", "",})
    @DisplayName("Given an invalid gender, isGenderValid method returns false")
    void givenAnInvalidGender_IsGenderValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isGenderValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"M", "F", "D", "A", "Q"})
    @DisplayName("Given a valid middle initial, isMiddleInitialValid method returns true")
    void givenAValidMiddleInitial_IsMiddleInitialValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isMiddleInitialValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"m", "F1", "Dan", "", "@"})
    @DisplayName("Given an invalid middle initial, isMiddleInitialValid method returns false")
    void givenAnInvalidMiddleInitial_IsMiddleInitialValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isMiddleInitialValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"8/13/1991", "11/02/2016"})
    @DisplayName("Given a valid date, isDateValid method returns true")
    void givenAValidDate_IsDateValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isDateValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1991/8/13", "", "8-13-1991", "Date"})
    @DisplayName("Given an invalid date, isDateValid method returns false")
    void givenAnInvalidDate_IsDateValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isDateValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"987654", "123456"})
    @DisplayName("Given a valid employee number, isEmployeeIDValid method returns true")
    void givenAValidEmployeeID_IsEmployeeIDValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isEmployeeIDValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"9876543", "1234567", "", "12345", "abcdef"})
    @DisplayName("Given an invalid employee number, isEmployeeIDValid method returns false")
    void givenAnInvalidEmployeeID_IsEmployeeIDValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isEmployeeIDValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"987654", "12345", "1234", "1234567"})
    @DisplayName("Given a valid salary, isSalaryValid method returns true")
    void givenAValidSalary_IsSalaryValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isSalaryValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "12345a", "", "12345678", "50Thousand"})
    @DisplayName("Given an invalid salary, isSalaryValid method returns false")
    void givenAnInvalidSalary_IsSalaryValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isSalaryValid(string));
    }
}
