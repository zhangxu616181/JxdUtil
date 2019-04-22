package com.jxd.jxd_core.intent

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 *  @author : JXD
 *  @date : 2019/4/22 星期一
 */

inline fun <reified T : Activity> Activity.openActivity(vararg pair: Pair<String, Any>) {
    gotoActivity<T>(false, *pair)
}

inline fun <reified T : Activity> Activity.openActivityFinish(vararg pair: Pair<String, Any>) {
    gotoActivity<T>(false, *pair)
    finish()
}

inline fun <reified T : Activity> Context.toActivity(vararg pair: Pair<String, Any>) {
    gotoActivity<T>(false, *pair)
}

inline fun <reified T : Activity> Context.startActivity(vararg pair: Pair<String, Any>) {
    gotoActivity<T>(false, *pair)
}

inline fun <reified T : Activity> Context.newActivity(vararg pair: Pair<String, Any>) {
    gotoActivity<T>(true, *pair)
}

inline fun <reified T> Context.gotoActivity(isNew: Boolean, vararg pair: Pair<String, Any>) {
    val intent = Intent(this, T::class.java)
    if (isNew) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    pair.forEach { intent.putExt(it.first, it.second) }
    startActivity(intent)
}

fun Intent.putExt(key: String, value: Any) {
    when (value) {
        is Int -> putExtra(key, value)
        is Long -> putExtra(key, value)
        is CharSequence -> putExtra(key, value)
        is String -> putExtra(key, value)
        is Float -> putExtra(key, value)
        is Double -> putExtra(key, value)
        is Char -> putExtra(key, value)
        is Short -> putExtra(key, value)
        is Boolean -> putExtra(key, value)
        is Serializable -> putExtra(key, value)
        is Bundle -> putExtra(key, value)
        is Parcelable -> putExtra(key, value)
        is IntArray -> putExtra(key, value)
        is LongArray -> putExtra(key, value)
        is FloatArray -> putExtra(key, value)
        is DoubleArray -> putExtra(key, value)
        is CharArray -> putExtra(key, value)
        is ShortArray -> putExtra(key, value)
        is BooleanArray -> putExtra(key, value)
        is Array<*> -> when {
            value.isArrayOf<CharSequence>() -> putExtra(key, value)
            value.isArrayOf<String>() -> putExtra(key, value)
            value.isArrayOf<Parcelable>() -> putExtra(key, value)
            else -> throw IllegalArgumentException(" $key ==> ${value.javaClass.name} 的值类型错误")
        }
        else -> throw IllegalArgumentException(" $key ==> ${value.javaClass.name} 的值类型错误")
    }
}