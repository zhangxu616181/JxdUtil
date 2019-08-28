package com.jxd.jxd_core.base

import android.content.Context
import android.widget.Toast

/**
 *  @author : JXD
 *  @date : 2019/8/28 星期三
 */

fun Context.toast(msg: String) {
    Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
}

