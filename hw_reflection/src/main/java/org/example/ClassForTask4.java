package org.example;
import java.sql.SQLOutput;
import lombok.NonNull;
@DaysOfWeek(10)
public class ClassForTask4 {
    public void DataInfo(@NonNull DataContainer data) {}

}
@DaysOfWeek(2)
class ExtendsClass1 extends ClassForTask4{
    @TaskInfo(hour = 12, priority = 2, description = "Task 1 for ExtendsClass1")
    @TaskInfo(hour = 10, priority = 0, description = "Task 2 for ExtendsClass1")
    @Override
    public void DataInfo (@NonNull DataContainer data){
        data.setId(44);
//        System.out.println(" data id: " + data.getId() + "; data name: " + data.getName() + "; data value: " + data.getValue());

    }
}
@DaysOfWeek(10)
class ExtendsClass2 extends ClassForTask4{
    @Override
    @TaskInfo(hour = 11, priority = 1, description = "Task 1 for ExtendsClass2")
    @TaskInfo(hour = 12, priority = 2, description = "Task 2 for ExtendsClass2")
    public void DataInfo (@NonNull DataContainer data){
        String s = data.getName();
        data.setValue(data.getValue() + 50);

        System.out.println();
//        data.setName("New name for <<" + s + ">> is <<good job>>");
//        System.out.println(" data id: " + data.getId() + "; data name: " + data.getName() + "; data value: " + data.getValue());
    }
}
