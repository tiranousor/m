package org.example;

public interface FileManipulation {
    public void createLogDirectory();
    public void saveToFile(DataContainer data);
    public void cleanLogDirectory();
    public String readFile(String name);
}

