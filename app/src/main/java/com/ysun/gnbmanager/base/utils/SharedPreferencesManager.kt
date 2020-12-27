package com.ysun.gnbmanager.base.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ysun.gnbmanager.Application
import java.lang.reflect.Type

object SharedPreferencesManager {

    lateinit var preferences: SharedPreferences

    private const val PREFERENCES_FILENAME = "GNBManagerSharedPreferences"

    fun with(application: Application) {
        preferences = application.getSharedPreferences(PREFERENCES_FILENAME, Context.MODE_PRIVATE)
    }

    fun <T> put(obj: T, key: String) {
        val jsonString = GsonBuilder().create().toJson(obj)
        preferences.edit().putString(key, jsonString).apply()
    }

    inline fun <reified T> get(key: String, typeToken: Type): T {
        val value = preferences.getString(key, null)
        return Gson().fromJson(value, typeToken)
    }

}