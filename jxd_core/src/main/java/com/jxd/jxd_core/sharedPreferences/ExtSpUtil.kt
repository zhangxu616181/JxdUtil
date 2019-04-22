package com.jxd.jxd_core.sharedPreferences

import android.content.Context

/**
 *  @author : JXD
 *  @date : 2019/4/22 星期一
 */
fun Context.saveValue(key: String, value: String) =
    SpUtil.saveValue(context = this, key = key, value = value)

inline fun <reified T> Context.getValue(key: String, def: T? = null) =
    SpUtil.getValue(context = this, key = key, def = def)

fun Context.clear() {
    SpUtil.clear(context = this)
}

fun Context.remove(key: String) {
    SpUtil.remove(context = this, key = key)
}

