package org.example;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(TasksInfo.class)
public @interface TaskInfo {
    int hour();
    int priority();
    String description();
}
