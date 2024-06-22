package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskProcessorTest {

    @Test
    void processTasks() {
        DataContainer data = new DataContainer("first data test", 10, 29.11);
        TaskProcessor processor = new TaskProcessor();
        assertEquals(new DataContainer("first data test", 10, 79.11), processor.processTasks(10, 12, data));
    }
}