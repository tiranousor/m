
package org.example;
public class Main {
    public static void main(String[] args) {
        DataContainer data = new DataContainer("first data test", 10, 29.11);

        ExtendsClass1 extendsClass1 = new ExtendsClass1();
        ExtendsClass2 extendsClass2 = new ExtendsClass2();
        extendsClass1.DataInfo(data);
        extendsClass2.DataInfo(data);
    }

}