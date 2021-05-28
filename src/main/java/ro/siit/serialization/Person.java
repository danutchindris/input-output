package ro.siit.serialization;

import java.io.Serializable;

public class Person implements Serializable {

    public static final long serialVersionUID = 1L;

    private final String name;
    private final Integer age;

    public Person(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
