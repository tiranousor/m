package org.example;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskProcessor {
    public DataContainer processTasks(int day, int time, DataContainer data) {
        // Создание экземпляров классов
        List<ClassForTask4> instances = new ArrayList<>();
        instances.add(new ExtendsClass1());
        instances.add(new ExtendsClass2());
        //Сортирова в зависимости от day
        List<ClassForTask4> filtredInstances = instances.stream()
                .filter(instance -> {
                    DaysOfWeek annotation = instance.getClass().getAnnotation(DaysOfWeek.class);
                    return annotation != null && annotation.value() == day;
                })
                .toList();

        //Сортирова методов в зависимости от time(потно)
        for (ClassForTask4 instance : filtredInstances) {
            Method[] methods = instance.getClass().getDeclaredMethods();
            List<Method> taskMethods = new ArrayList<>();
            taskMethods.addAll(Arrays.asList(methods));
            List<Method> filtredMethod = new ArrayList<>(taskMethods.stream()
                    .filter(m -> {
                        TaskInfo annotation = m.getAnnotation(TaskInfo.class);
                        return annotation != null && annotation.hour() == time;
                    })
                    .sorted(Comparator.comparingInt(method -> method.getAnnotation(TaskInfo.class).priority()))
                    .toList());

            // Выполнение методов и проверка изменений
            for (Method method : taskMethods) {
                try {
                    method.invoke(instance, data);
                    checkDataContainerState(data);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return data;
    }

    private void checkDataContainerState(DataContainer data) {
        try {
            System.out.println("DataContainer state:");
            for (Method method : DataContainer.class.getMethods()) {
                if (method.getName().startsWith("get")) {
                    System.out.println(method.getName() + ": " + method.invoke(data));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
