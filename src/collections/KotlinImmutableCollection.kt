package collections

import java.util.Arrays.asList
import java.util.Collections.unmodifiableList

fun main(args: Array<String>) {
    run()
}

fun genList1() : MutableList<Int> {
    return ArrayList(asList(1, 2, 3, 4))
}

fun genList2() : List<Int> {
    return asList(1, 2, 3, 4)
}

fun mutatorMethod(list: MutableList<Int>) {
    list.add(5)
}

fun run() {
    val list1 = genList1()
    mutatorMethod(list1)

    val list2 = genList2()
    // mutatorMethod(list2)
    //  ^^^ compiler does check itself
    //  ^^^ code won't compile
}
