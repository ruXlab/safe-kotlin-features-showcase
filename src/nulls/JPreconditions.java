package nulls;

import java.util.Objects;

/**
 * Created by rux on 02/05/17.
 */
public class JPreconditions {
    public static void main(String[] args) {
        new JPreconditions().run();
    }

    private void run() {
        display("Java", 22);
        display(null, 100);
    }

    private void display(String lang, Integer age) {
        Objects.requireNonNull(lang, "Language should be non-null");
        Objects.requireNonNull(age, "Age should be non-null");

        System.out.println(lang.toUpperCase() + " is " + age + "years old");
    }

}
