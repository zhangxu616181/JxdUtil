package com.jxd.jxd_core.base

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 *  @author : JXD
 *  @date : 2019/8/28 星期三
 */

//////////////////////////////////////////////////////
/****************************************************
 ****************************************************
 ****************************************************
 ****************************************************
 ****************************************************
 ******************以下为日期格式操作*****************
 ****************************************************
 ****************************************************
 ****************************************************
 ***************************************************/
/////////////////////////////////////////////////////

const val YMDHM = "yyyy-MM-dd HH:mm"
const val YMDHMS = "yyyy-MM-dd HH:mm:ss"
const val HM = "HH:mm"
const val Y_M_D = "yyyy-MM-dd"
const val WEEK = "EEEE"
const val YMD = "yyyyMMdd"
const val Y_M = "yyyy-MM"
const val HMS = "HH:mm:ss"
const val Y_Y = "yyyy"
const val M_M = "MM"

/**
 * long转String
 *
 * @param times
 * @param timeType
 * @return
 */
@SuppressLint("SimpleDateFormat")
fun longToString(times: Long, timeType: String): String {
    val sdf = SimpleDateFormat(timeType)
    return sdf.format(times)
}

fun dateFormat(date: String): String {
    val split = date.split("-")
    val year: String = split[0]
    val monthInt = split[1].toInt()
    val month: String = if (monthInt < 10) "0$monthInt" else "$monthInt"
    val dayInt = split[2].toInt()
    val day: String = if (dayInt < 10) "0$dayInt" else "$dayInt"
    return "$year-$month-$day"
}

/**
 * date类型转为Long
 */
fun dateToLong(date: Date): Long {
    return date.time
}


/**
 * String类型转Date类型
 */
@SuppressLint("SimpleDateFormat")
fun stringToDate(time: String, timeType: String): Date? {
    var date: Date? = null
    try {
        val format = SimpleDateFormat(timeType)
        date = format.parse(time)
    } catch (e: Exception) {
    }
    return date
}


/**
 * 日期 String  转 Long
 */
fun stringToLong(time: String, timeType: String): Long {
    val date = stringToDate(time, timeType)
    if (date == null) {
        return 0
    } else {
        return dateToLong(date)
    }

}


//////////////////////////////////////////////////////
/*****************************************************
 *****************************************************
 *****************************************************
 *****************************************************
 **************** 以上为日期格式操作*******************
 *****************************************************
 *****************************************************
 *****************************************************
 *****************************************************
 ****************************************************/
///////////////////////////////////////////////////////
