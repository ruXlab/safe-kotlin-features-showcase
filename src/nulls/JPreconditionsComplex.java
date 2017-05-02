package nulls;

import java.util.Date;

/**
 * Created by rux on 02/05/17.
 */
public class JPreconditionsComplex {
    public static void main(String[] args) {
        new JPreconditionsComplex().run();
    }

    void run() {
        Address address = new Address("22 New Street", "EC1 AB", new Date(1995, 10, 1));
        Person adam = new Person("Adam", address);
        display(adam);

        Person person = new Person("Adam", null);
        display(person);
    }

    void display(Person person) {
        System.out.println(person.name + " moved to " + person.address.zip
            + " " + person.address.street
            + " on " + person.address.updatedAt.toGMTString());
    }

}

class Person {
    String name;
    Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

class Address {
    String street;
    String zip;
    Date updatedAt;

    public Address(String street, String zip, Date updatedAt) {
        this.street = street;
        this.zip = zip;
        this.updatedAt = updatedAt;
    }
}
