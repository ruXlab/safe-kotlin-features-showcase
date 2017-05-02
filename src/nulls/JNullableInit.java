package nulls;

/**
 * Created by rux on 02/05/17.
 */
public class JNullableInit {


    public static void main(String[] args) {
        new JNullableInit().run();
    }




    public JNullableInit() {


    }

    void run() {


    }


}

class Resource1 {
    public String getString() {
        return "R1";
    }
}

class Resource2 {
    public String getString() {
        return null;
    }
}

class Resource3 {
    public String getString() {
        return "R1";
    }
}