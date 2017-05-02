package nulls

/**
 * Created by rux on 02/05/17.
 */

fun main(args: Array<String>) {
    run()
}

fun run() {
    display("kotlin", 6)
//    display(null, 6)
//    ^^^ try to uncomment, you won't able to compile code
}

fun display(lang: String, age: Int) {
    println("${lang.toUpperCase()} is $age years old")
}
