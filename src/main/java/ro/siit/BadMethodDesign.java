package ro.siit;

class Client {
    public static void main(String[] args) {
        final Person person = new Person("Emil");
        final int number = read(person);
        System.out.println("Number: " + number);
        System.out.println("Person: " + person);
    }

    // very bad design
    public static int read(final Person p) {
        p.setName("Cosmin");
        return 1;
    }
}

class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
