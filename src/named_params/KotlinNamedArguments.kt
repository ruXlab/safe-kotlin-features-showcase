package named_params

/**
 * Created by rux on 02/05/17.
 */

fun main(args: Array<String>) {
    run()
}

fun run() {
    checkParcelSize(id = 439394234, weight = 3.5,
        width = 23.0, height = 21.0, length = 10.0,
        price = 7.8, value = 200.0
    )
}

fun checkParcelSize(id: Long, width: Double, height: Double, length: Double, weight: Double, price: Double, value: Double): Boolean {
    return true // pretends we checked something
}
