package com.bnb.serialization;

import java.io.*;
import java.util.Base64;

public class CustomizedSerializationDemo {
    public static void main(String[] args) {
        UserSession session = new UserSession("user1", "mypassword");

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sessionData.ser"))) {
            out.writeObject(session);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        UserSession loadedSession = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("sessionData.ser"))) {
            loadedSession = (UserSession) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(loadedSession);
    }
}

class UserSession implements Serializable {
    private String username;
    private transient String password; // Marked transient to avoid default serialization

    public UserSession(String username, String password) {
        this.username = username;
        this.password = password;
    }


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject(); // Serialize all non-transient fields
        // Encrypt or handle the password before writing it to the stream.
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        System.out.println("encodedPassword:"+encodedPassword);
        out.writeObject(encodedPassword); // Write the handled password manually
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Deserialize all non-transient fields
        // Read the encoded password and decode it
        String encodedPassword = (String) in.readObject();
        password = new String(Base64.getDecoder().decode(encodedPassword));
        System.out.println("password:"+password);
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}