/**
 * Part 3 of type-safe units manipulation
 */
package units_conversion._3


/**
 * Distance
 */

open class DistanceUnit(val multiplier: Double, val unitAbbr: String) {
    operator fun div(timeUnit: TimeUnit) = SpeedUnit(this, timeUnit)
}

object Meters      : DistanceUnit(1.0, "m")
object Kilometers  : DistanceUnit(1e3, "km")
object Millimeters : DistanceUnit(1e-3, "mm")
object Centimetres : DistanceUnit(1e-2, "cm")
object Miles       : DistanceUnit(1609.34, "mi")
object Yards       : DistanceUnit(0.9144, "yd")

data class Distance(val distance: Double, val unit: DistanceUnit) {
    fun to(otherUnit: DistanceUnit) =
        Distance(distance * unit.multiplier / otherUnit.multiplier, otherUnit)

    operator fun plus(that: Distance)
        = Distance(this.distance + that.to(unit).distance, unit)

    operator fun minus(that: Distance)
        = Distance(this.distance - that.to(unit).distance, unit)

    operator fun div(time: Time) = Speed(this.distance / time.time, this.unit / time.unit)

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


/**
 * Time
 */

open class TimeUnit(val multiplier: Double, val unitAbbr: String)

object Seconds : TimeUnit(1.0, "s")
object Minutes : TimeUnit(60.0, "min")
object Hours   : TimeUnit(60*60.0, "h")
object Days    : TimeUnit(24*60*60.0, "d")

data class Time(val time: Double, val unit: TimeUnit) {
    fun to(otherUnit: TimeUnit)
        = Time(time * unit.multiplier / otherUnit.multiplier, otherUnit)

    operator fun plus(that: Time)
        = Time(this.time + that.to(unit).time, unit)

    operator fun minus(that: Time)
        = Time(this.time - that.to(unit).time, unit)

    val asSeconds get() = to(Seconds)
    val asMinutes get() = to(Minutes)
    val asHours get() = to(Hours)
    val asDays get() = to(Days)

    override fun toString() = "${time}${unit.unitAbbr}"
}


fun Number.to(unit: TimeUnit) = Time(this.toDouble(), unit)
val Number.asSeconds get() = to(Seconds)
val Number.asMinutes get() = to(Minutes)
val Number.asHours get() = to(Hours)
val Number.asDays get() = to(Days)


class SpeedUnit(val distanceUnit: DistanceUnit, val timeUnit: TimeUnit) 

data class Speed(val speed: Double, val unit: SpeedUnit) {

    fun to(speedUnit: SpeedUnit): Speed {
        val dd = unit.distanceUnit.multiplier / speedUnit.distanceUnit.multiplier
        val dt = unit.timeUnit.multiplier / speedUnit.timeUnit.multiplier
        val s = speed * (dd / dt)
        return Speed(s, speedUnit)
    }

    override fun toString() = "$speed${unit.distanceUnit.unitAbbr}/${unit.timeUnit.unitAbbr}"
}



fun main(args: Array<String>) {
    println(10.asSeconds + 5.asMinutes)
    // 310.0s

    val speed = 10.asKilometers / 5.asHours
    val speedInMPerSecond = speed.to(Meters / Seconds)
    println("$speed = $speedInMPerSecond")
    // 2.0km/h = 0.556m/s

    val speedInMPerHour = speed.to(Miles / Hours)
    println("$speed = $speedInMPerHour")
    // 2.0km/h = 1.2427454732996135mi/h

    val `50mph` = 50.asMiles / 1.asHours
    println("$`50mph` = ${`50mph`.to(Kilometers / Hours)}")
    // 50.0mi/h = 80.467km/h
}


