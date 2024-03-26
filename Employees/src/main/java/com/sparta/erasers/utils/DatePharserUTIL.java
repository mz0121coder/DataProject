package com.sparta.erasers.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePharserUTIL {
    public static LocalDate pharseDate(String stringDate) {
        String[] splitStringDate = stringDate.split("/");
        if(splitStringDate[0].length() <= 1) {
            splitStringDate[0] = "0" + splitStringDate[0];
        }
        String newStringDate = splitStringDate[2] + "-" + splitStringDate[0] + "-" + splitStringDate[1];

        LocalDate newDate = LocalDate.parse(newStringDate);

        return newDate;
    }
}
