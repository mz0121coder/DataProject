package com.sparta.erasers.utils;

import com.sparta.erasers.CustomFormatter;

import java.io.IOException;
import java.text.Format;
import java.text.Normalizer;
import java.util.logging.*;

public class LoggerUTIL {
    static Handler consoleHandler = new ConsoleHandler();
    static Handler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("src/main/java/com/sparta/erasers/logFile.log", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setLoggerLevel(Logger LOGGER, Level level){
        LOGGER.setLevel(level);
    }

    public static void setConsoleHandlerFormatter(Formatter format){
        consoleHandler.setFormatter(format);
    }

    public static void setFileHandlerFormatter(Formatter format){
        fileHandler.setFormatter(format);
    }


    public static void setFileHandlerLevel(Level level){
        fileHandler.setLevel(level);
    }

    public static void setConsoleHandlerLevel(Level level){
        consoleHandler.setLevel(level);
    }

    public static void addConsoleHandler(Logger logger){
        logger.addHandler(consoleHandler);
    }

    public static void addFileHandler(Logger logger){
        logger.addHandler(fileHandler);
    }

    public static void setUpHandlers(Logger logger){
        setConsoleHandlerLevel(Level.ALL);
        setFileHandlerLevel(Level.ALL);
        setFileHandlerFormatter(new SimpleFormatter());
        setConsoleHandlerFormatter(new CustomFormatter());

    }
}
