package com.sparta.erasers.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntParserUTILTest {

    @Test
    @DisplayName("check a string being parse to a int")
    void parseStringToInt() {
        int testInt = IntParserUTIL.parseStringToInt("198429");
        Assertions.assertEquals(198429, testInt);
    }
}