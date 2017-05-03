package optionals

import java.util.*

/**
 * Created by rux on 04/05/17.
 */

data class KPerson(val name: String, val address: KAddress? = null)
data class KAddress(val street: String?, val zip: String?, val updatedAt: Date)

fun display(person: KPerson) {
    println("${person.name} moved to "
        + "${person.address?.street ?: "unknown place"} "
        + "${person.address?.zip.orEmpty()} on "
        + "${person.address?.updatedAt?.toGMTString() ?: "unknown date"} ")
}

fun main(args: Array<String>) {
    val address = KAddress("22 New Street", "EC1 AB", Date(1995, 10, 1))
    val adam = KPerson("Adam", address)
    display(adam)

    val peter = KPerson("Peter", null)
    display(peter)
}