package named_params;

/**
 * Created by rux on 02/05/17.
 */
public class JavaArgumentsList {
    public static void main(String[] args) {
        new JavaArgumentsList().run();
    }

    void run() {
        checkParcelSize(439394234, 23, 21, 10,3.5, 7.8, 200);
    }

    boolean checkParcelSize(long id, double width, double height, double length, double weight, double price, double value) {
        return true; // pretends we checked something
    }
}
