package org.example;
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TasksInfo {
    TaskInfo[] value();
}
