package ro.siit.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PersonInOut {

    public static void main(String[] args) {
        final Person p = new Person("Ionut", 25);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialized-object.out"))) {
            oos.writeObject(p);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
