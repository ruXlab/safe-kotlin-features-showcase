/**
 * Part 3 of type-safe units manipulation
 */
package units_conversion._2

open class DistanceUnit(val multiplier: Double, val unitAbbr: String)

object Meters : DistanceUnit(1.0, "m")
object Kilometers : DistanceUnit(1e3, "km")
object Millimeters : DistanceUnit(1e-3, "mm")
object Centimetres : DistanceUnit(1e-2, "cm")
object Miles : DistanceUnit(1609.34, "mi")
object Yards : DistanceUnit(0.9144, "yd")

data class Distance(val distance: Double, val unit: DistanceUnit) {
    fun to(otherUnit: DistanceUnit) =
        Distance(distance * unit.multiplier / otherUnit.multiplier, otherUnit)

    operator fun plus(that: Distance)
        = Distance(this.distance + that.to(unit).distance, unit)

    operator fun minus(that: Distance)
        = Distance(this.distance - that.to(unit).distance, unit)

    val asMeters get() = to(Meters)
    val asKilometers get() = to(Kilometers)
    val asMillimeters get() = to(Millimeters)
    val asCentimetres get() = to(Centimetres)
    val asMiles get() = to(Miles)
    val asYards get() = to(Yards)

    override fun toString() = "${distance}${unit.unitAbbr}"
}

fun Number.to(unit: DistanceUnit) = Distance(this.toDouble(), unit)
val Number.asMeters get() = to(Meters)
val Number.asKilometers get() = to(Kilometers)
val Number.asMillimeters get() = to(Millimeters)
val Number.asCentimetres get() = to(Centimetres)
val Number.asMiles get() = to(Miles)
val Number.asYards get() = to(Yards)


fun main(args: Array<String>) {
    val twoKm = 2.asKilometers
    val `5m` = 5.asMeters
    val `42mm` = 42.asMillimeters
    println("$twoKm = ${twoKm.asMeters} = ${twoKm.asMiles}")
    // 2.0km = 2000.0m = 1.2427454732996135mi
    println(twoKm - `5m`)
    // 1.995km
    println(10.asMeters - `5m` + `42mm`)
    // 5.042m
                          
    val snake = (10.asCentimetres + 1.asMeters).asMeters
    println("snake is $snake(${snake.asYards}) long")
    // snake is 1.1m(1.2029746281714786yd) long
}


