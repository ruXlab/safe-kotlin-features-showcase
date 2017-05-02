package numbres

/**
 * Created by rux on 02/05/17.
 */

fun main(args: Array<String>) {
    val n: Int = 2_000_000_000
//    val b: Long = n + n
//    ^^^ Will not compile, try to uncomment
    val b: Long = n.toLong() + n
    println(b)
}