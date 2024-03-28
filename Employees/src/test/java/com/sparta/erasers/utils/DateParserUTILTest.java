package com.sparta.erasers.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateParserUTILTest {

    @Test
    @DisplayName("check if the string dates been parsed matches correct Local date format")
    void parseDate() {
        //expect: 2008-02-01
        //current 02/01/2008
        LocalDate testDate = DateParserUTIL.parseDate("02/01/2008");
        Assertions.assertEquals(LocalDate.of(2008, 02, 01), testDate);
    }
}