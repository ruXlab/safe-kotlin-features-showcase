/**
 * Part 1 of type-safe units manipulation
 */
package units_conversion._1


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

    override fun toString() = "${distance}${unit.unitAbbr}"
    
    operator fun plus(that: Distance)
        = Distance(this.distance + that.to(unit).distance, unit)

    operator fun minus(that: Distance)
        = Distance(this.distance - that.to(unit).distance, unit)
}


fun main(args: Array<String>) {
    val twoKm = Distance(2.0, Kilometers)
    val `5m` = Distance(5.0, Meters)
    val `42mm` = Distance(42.0, Millimeters)
    println(twoKm)
    // 2km
    println("$`42mm` = ${`42mm`.to(Centimetres)}")
    // 42.0mm = 4.2cm
    println("$twoKm = ${twoKm.to(Meters)} = ${twoKm.to(Miles)}")
    // 2.0km = 2000.0m = 1.2427454732996135mi
    println(twoKm - `5m`)
    // 1.995km
    println(Distance(10.0, Meters) - `5m` + `42mm`)
    // 5.042m
}


