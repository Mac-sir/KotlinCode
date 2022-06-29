package com.example.kotlincode.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.kotlincode.Constant
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class SPUtil<T>(private val name: String, val defaultValue: T) : ReadWriteProperty<Any?, T> {

    companion object {
        lateinit var spUtil: SharedPreferences

        @SuppressLint("WrongConstant")
        fun setContext(context: Context) {
            spUtil = context.getSharedPreferences(
                context.packageName + Constant.KOTLIN_NAME, Context.MODE_PRIVATE
            )
        }

        fun clear() {
            spUtil.edit().clear().apply()
        }
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T = findSharedPreference(name, defaultValue)

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = putSharedPreference(name, value)

    @Suppress("UNCHECKED_CAST")
    private fun <U> findSharedPreference(name: String, default: U): U = with(spUtil) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> throw IllegalArgumentException("This type can be saved into SharedPreference")
        }!!
        res as U
    }

    @SuppressLint("CommitPrefEdits")
    private fun <U> putSharedPreference(name: String, value: U) = with(spUtil.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> throw IllegalArgumentException("This type can be saved into SharedPreference")
        }.apply()
    }
}