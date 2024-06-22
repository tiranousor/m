package org.example;
import lombok.NonNull;
@DaysOfWeek(1)
public class ClassForTask4 {
}
@DaysOfWeek(1)
class ExtendsClass1 extends ClassForTask4{
    @TaskInfo(hour = 10, priority = 1, description = "task 1")
    public void DataInfo (@NonNull DataContainer data){

        System.out.println(" data id: " + data.getId() + " data name: " + data.getName() + " data value: " + data.getValue());

    }
}
@DaysOfWeek(value = 4)
class ExtendsClass2 extends ClassForTask4{
    @TaskInfo(hour = 1, priority = 3, description = "task 2")
    public void DataInfo (@NonNull DataContainer data){
        System.out.println(" data id: " + data.getId() + " data name: " + data.getName() + " data value: " + data.getValue());
    }
}
