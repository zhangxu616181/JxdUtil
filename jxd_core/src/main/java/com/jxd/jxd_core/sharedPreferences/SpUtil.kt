@file:Suppress("IMPLICIT_CAST_TO_ANY")

package com.jxd.jxd_core.sharedPreferences

import android.content.Context
import android.content.SharedPreferences

/**
 *  @author : JXD
 *  @date : 2019/4/22 星期一
 */
object SpUtil {
    private var CONFIG_NAME = "App_Config"
    private var MODE = Context.MODE_PRIVATE
    lateinit var prefs: SharedPreferences

    fun init(context: Context, configName: String = CONFIG_NAME, @PreferencesMode mode: Int = MODE) {
        prefs = context.getSharedPreferences(configName, mode)
    }

    fun saveValue(context: Context, key: String, value: Any) {
        initDefault(context)
        with(prefs.edit()) {
            when (value) {
                is Long -> putLong(key, value)
                is Int -> putInt(key, value)
                is String -> putString(key, value)
                is Float -> putFloat(key, value)
                is Boolean -> putBoolean(key, value)
                else -> throw IllegalArgumentException("SharedPreferences 类型错误")
            }.apply()
        }
    }

    inline fun <reified T> getValue(context: Context,key: String,def:T ?= null):T{
        initDefault(context)
        with(prefs){
            return when (T::class) {
                Int::class -> getInt(key,if (def is Int) def else 0)
                String::class -> getString(key,if (def is String) def else "")
                Long::class -> getLong(key,if (def is Long ) def else 0L)
                Float::class -> getFloat(key,if (def is Float) def else 0.0f)
                Boolean::class -> getBoolean(key,if (def is Boolean) def else false)
                else -> throw IllegalArgumentException("SharedPreferences 类型错误")
            } as T
        }
    }


    fun clear(context: Context) {
        initDefault(context)
        prefs.edit().clear().apply()
    }

    fun remove(context: Context, key: String) {
        initDefault(context)
        prefs.edit().remove(key).apply()
    }

    fun getSharedPreferences(context: Context):SharedPreferences{
        initDefault(context)
        return prefs
    }

    fun contains(context: Context, key: String): Boolean {
        initDefault(context)
        return prefs.contains(key)
    }

    fun initDefault(context: Context) {
        if (!::prefs.isInitialized) {
            prefs = context.getSharedPreferences(CONFIG_NAME, MODE)
        }
    }
}

