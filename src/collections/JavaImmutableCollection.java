package collections;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;

/**
 * Created by rux on 02/05/17.
 */
public class JavaImmutableCollection {
    public static void main(String[] args) {
        new JavaImmutableCollection().run();
    }

    List<Integer> genList1() {
        return new ArrayList<>(
            asList(1,2,3,4)
        );
    }

    List<Integer> genList2() {
        return unmodifiableList(
            asList(1,2,3,4)
        );
    }


    void mutatorMethod(List<Integer> list) {
        list.add(5);
    }

    void run() {
        List<Integer> list1 = genList1();
        mutatorMethod(list1);

        List<Integer> list2 = genList2();
        mutatorMethod(list2);
    }

}
