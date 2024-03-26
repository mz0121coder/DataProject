package com.sparta.erasers.utils;

import java.time.LocalDate;

public class DateParserUTIL {
    public static LocalDate parseDate(String stringDate) {
        String[] splitStringDate = stringDate.split("/");
        if(splitStringDate[0].length() <= 1) {
            splitStringDate[0] = "0" + splitStringDate[0];
        }
        String newStringDate = splitStringDate[2] + "-" + splitStringDate[0] + "-" + splitStringDate[1];

        LocalDate newDate = LocalDate.parse(newStringDate);

        return newDate;
    }
}
