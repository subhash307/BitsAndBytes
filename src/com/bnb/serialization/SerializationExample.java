package com.bnb.serialization;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        Employee emp = new Employee("John", 123, 'M');

        // Serialize the object to a file
        try {
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(emp);
            out.close();
            fileOut.close();
            System.out.println("Employee object serialized successfully.");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        // Deserialize from file to Object
        ObjectInputStream objectInputStream = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("employee.ser");
            objectInputStream = new ObjectInputStream(inputStream);
            Employee emp1 = (Employee) objectInputStream.readObject();
            System.out.println("Employee: " + emp1.toString());
            objectInputStream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());

        }

    }
}

class Employee implements Serializable {
    private String name;
    private int id;
    private char gender;

    public Employee(String name, int id, char gender) {
        this.name = name;
        this.id = id;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee { name: " + name + ", id: " + id + ", gender: "+gender+ " }";
    }
}
