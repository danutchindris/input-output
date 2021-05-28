package ro.siit.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OtherProgram {

    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialized-object.out"))) {
            Object o = ois.readObject();
            if (o instanceof Person p) {
                System.out.println(p.getName() + " " + p.getAge());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
