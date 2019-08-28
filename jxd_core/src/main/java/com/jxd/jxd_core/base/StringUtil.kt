package com.jxd.jxd_core.base

import java.util.regex.Pattern

/**
 *  @author : JXD
 *  @date : 2019/8/28 星期三
 */

infix fun String.isEmpty(block: () -> Unit): String {
    if (isEmpty()) block()
    return this
}

infix fun String.orNotEmpty(block: String.() -> Unit) {
    if (isNotEmpty()) {
        block()
    }
}


infix fun String.isRex(reg: String) = Pattern.compile(reg).matcher(this).matches()

fun isPhoneNumber(str: String): Boolean {
    if (str.isEmpty()) {
        return false
    }
    return str isRex FILTER_PHONE_NUMBER
}

fun isEmail(email: String): Boolean {
    if (email.isEmpty()) return false
    return email isRex FILTER_EMAIL
}


const val filter_string = "[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+"
const val FILTER_EN_NUMBER = "[A-Za-z0-9_\\-]+"
const val FILTER_PHONE_NUMBER =
    "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$"
const val FILTER_EMAIL =
    "^([a-zA-Z0-9_\\-.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(]?)$"
