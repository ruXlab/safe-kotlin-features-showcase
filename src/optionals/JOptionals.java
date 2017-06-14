package optionals;

import java.util.Date;

/**
 * Created by rux on 02/05/17.
 */
public class JOptionals {
    public static void main(String[] args) {
        new JOptionals().run();
    }

    void run() {
        JAddress address = new JAddress("22 New Street", "EC1 AB", new Date(1995, 10, 1));
        JPerson adam = new JPerson("Adam", address);
        display(adam);

        JPerson peter = new JPerson("Peter", null);
        display(peter);
    }

    void display(JPerson person) {
        StringBuilder sb = new StringBuilder();
        sb.append(person.name).append(" moved to ");
        if (person.address != null && person.address.street != null)
            sb.append(person.address.street);
        else sb.append("unknown place");
        if (person.address != null && person.address.zip != null)
            sb.append(person.address.zip.toUpperCase());
        sb.append(" on ");
        if (person.address != null && person.address.updatedAt != null)
            sb.append(person.address.updatedAt.toGMTString());
        else sb.append("unknown date");
        System.out.println(sb.toString());
    }

}

class JPerson {
    String name;
    JAddress address;

    public JPerson(String name, JAddress address) {
        this.name = name;
        this.address = address;
    }
}

class JAddress {
    String street;
    String zip;
    Date updatedAt;

    public JAddress(String street, String zip, Date updatedAt) {
        this.street = street;
        this.zip = zip;
        this.updatedAt = updatedAt;
    }
}
