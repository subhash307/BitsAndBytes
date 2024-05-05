package com.bnb.serialization;

import java.io.*;

public class InheritanceSerializationExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.i =1000;
        rectangle.j=2000;
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("shape.ser"))) {
            oos.writeObject(rectangle);
            System.out.println("De Serialized started..");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("shape.ser"))) {
            Rectangle rectangle1 = (Rectangle) ois.readObject();
            System.out.println("i: "+rectangle1.i +", j: "+rectangle1.j);
        } catch(IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}

class Shape {
    int i = 100;
    public Shape(){
        System.out.println("Shape constructor called!");
    }
}
class Rectangle extends Shape implements Serializable {
    int j = 200;
    Rectangle(){
        System.out.println("Rectangle Constructor called!");
    }
}