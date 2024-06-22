package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ProcessFile implements FileManipulation {
    private static final String LOG_DIR = "log";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    private static final String LOG_FILE = LocalDateTime.now().format(formatter) + ".txt";

    @Override
    public void createLogDirectory() {

        File log = new File(LOG_DIR);
        if (!log.exists()) {
            log.mkdir();
        }
        System.out.println("Log directory created or already exists");
    }

    @Override
    public void saveToFile(DataContainer data) {
        createLogDirectory();
        File logFile = new File(LOG_DIR, LOG_FILE);
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(
                    " - ID: " + data.getId() + ", Name: " + data.getName() +
                    ", Value: " + data.getValue() + "\r\n");
            System.out.println("Data written to log file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cleanLogDirectory();
    }

    @Override
    public void cleanLogDirectory() {
        File logDir = new File(LOG_DIR);
        File[] files = logDir.listFiles();
        if (files != null && files.length > 1) {
            Arrays.stream(files)
                    .sorted((f1, f2) -> Long.compare(f2.lastModified(), f1.lastModified()))
                    .skip(1)
                    .forEach(File::delete);
        }
    }


    @Override
    public String readFile(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(name);
            int ch ;
            while ((ch = fileReader.read()) != -1) {
                stringBuilder.append((char) ch);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
