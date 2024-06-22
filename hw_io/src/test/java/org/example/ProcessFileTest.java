package org.example;

import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProcessFileTest {
    private static final String LOG_DIR = "log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    private static final String LOG_FILE = LocalDateTime.now().format(formatter) + ".txt";

    @Test
    public void saveToFile() {
        DataContainer data = new DataContainer("first data test", 10, 29.11);

        ProcessFile processFile = new ProcessFile();
        processFile.saveToFile(data);


        String logFileName = LOG_DIR + "/" + LOG_FILE;
        String s = processFile.readFile(logFileName);


        String expected = " - ID: " + data.getId() + ", Name: " + data.getName() + ", Value: " + data.getValue() + "\r\n";
        assertEquals(expected, s);

    }
}