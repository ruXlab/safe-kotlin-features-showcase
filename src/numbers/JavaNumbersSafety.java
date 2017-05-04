package numbres;

/**
 * Created by rux on 02/05/17.
 */
public class JavaNumbersSafety {
    public static void main(String[] args) {
        int n = 2_000_000_000;
        long b = n + n;
        System.out.println(b);
    }
}
