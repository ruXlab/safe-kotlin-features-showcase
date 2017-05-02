package named_params

/**
 * Created by rux on 02/05/17.
 */

data class Parcel(
    val id: Long,
    val width: Double,
    val height: Double,
    val length: Double,
    val weight: Double,
    val price: Double,
    val value: Double
)

fun main(args: Array<String>) {
    val p = Parcel(542342342, weight = 10.5,
            width = 40.0, height = 215.0, length = 40.5,
            price = 49.99, value = 100.0)
    println(p)
}