package ir.huma.notificationlibrary.utils.extension

import com.google.gson.Gson



object GenericExtension {
    fun <T> T.toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    inline fun <reified T> String.toObject(): T {
        val gson = Gson()
        return gson.fromJson(this, T::class.java)

    }
}