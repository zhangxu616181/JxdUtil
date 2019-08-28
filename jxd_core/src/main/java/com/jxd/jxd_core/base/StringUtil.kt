package com.jxd.jxd_core.base

/**
 *  @author : JXD
 *  @date : 2019/8/28 星期三
 */

infix fun String.isEmpty(block: () -> Unit): String {
    if (isEmpty()) block()
    return this
}

infix fun String.orNotEmpty(block: String.() -> Unit){
    if (isNotEmpty()){
        block()
    }
}

//
//
//infix fun String.isPhoneNumber(block: String.() -> Unit):String{
//    if (true) block()
//    return this
//}
//
//infix fun String.orNotPhoneNumber(block: String.() -> Unit){
//    if ()
//}