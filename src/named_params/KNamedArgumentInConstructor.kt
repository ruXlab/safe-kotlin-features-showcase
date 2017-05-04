package named_params

import java.io.File

/**
 * Created by rux on 02/05/17.
 */

class Parcel(
    val id: Long,
    val width: Double,
    val height: Double,
    val length: Double,
    val weight: Double,
    val price: Double,
    val value: Double
)

class MyService(
    val config: Map<String, String>,
    val input: File,
    val output: File,
    val offsetX: Int,
    val offsetY: Int,
    val items: List<String>
)

fun main(args: Array<String>) {
    val items = listOf("one", "two", "three")

    val service = MyService(
        config = loadConfig(), items = items,
        input = File("input.txt"), output = File("output.txt"),
        offsetX = 42, offsetY = 64
    )

}

fun loadConfig() = mapOf("test" to "true")
