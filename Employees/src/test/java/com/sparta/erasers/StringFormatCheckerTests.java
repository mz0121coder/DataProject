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
    @ValueSource(strings = {"Mrss.", "mr.", "Dar.", "n.", "", "dr."})
    @DisplayName("Given a invalid name prefix, isNamePrefixValid method returns false")
    void givenAInvalidNamePrefix_IsNamePrefixValid_ReturnsFalse(String string) {
        Assertions.assertFalse(StringFormatCheckerUTIL.isNamePrefixValid(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tom", "Alex"})
    @DisplayName("Given a valid first name, isFirstNameValid method returns true")
    void givenAValidName_IsNameValid_ReturnsTrue(String string) {
        Assertions.assertTrue(StringFormatCheckerUTIL.isNameValid(string));
    }


}
