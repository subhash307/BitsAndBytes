package com.bnb.serialization;

import java.io.*;

public class ExternalizationExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person1 person = new Person1("John", 20, "M");
        FileOutputStream fos = new FileOutputStream("person1.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);

        //Deserialize
        FileInputStream fis = new FileInputStream("person1.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person1 person2 = (Person1) ois.readObject();
        System.out.println("person2:: name: "+person2.name
                +", age: "+person2.age + ", gender: "+person2.gender);
    }
}

class Person1 implements Externalizable {

    String name ;
    int age;
    String gender ;

    Person1(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person1() {
        System.out.println("Person no-arg constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeInt(this.age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }
}