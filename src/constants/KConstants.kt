package constants

import org.json.JSONObject

/**
 * Created by rux on 03/05/17.
 */

data class KUser(val login: String, val password: String) {
    fun toJson() = JSONObject()
        .put(KUser::login.name, login)
        .put(KUser::password.name, password)
}

fun main(args: Array<String>) {
    val user = KUser("Bob", "123456")
    println(user.toJson())
}

