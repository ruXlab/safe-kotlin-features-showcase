package sealed_classes

import java.util.*

/**
 * Created by rux on 03/05/17.
 */

fun main(args: Array<String>) {
    val events = listOf(
        KMouseClick(42, 200, 1),
        KMouseMove(46, 203),
        KMouseMove(50, 210),
        KMouseClick(40, 210, 3),
        KKeyPressed('j')
    )

    events.forEach(::process)
}

fun process(event: KEventBase) {
    val log = when(event) {
        is KMouseClick -> "Mouse clicked button #${event.btn}  at ${event.x}, ${event.y}"
        is KMouseMove -> "Mouse moved to ${event.x}, ${event.y}"
        is KKeyPressed -> "Key '${event.key}' pressed"
    }
    println("${event::class.java.simpleName}> $log")
}

sealed class KEventBase

data class KMouseMove(val x: Int, val y: Int) : KEventBase()
data class KMouseClick(val x: Int, val y: Int, val btn: Int) : KEventBase()
data class KKeyPressed(val key: Char) : KEventBase()