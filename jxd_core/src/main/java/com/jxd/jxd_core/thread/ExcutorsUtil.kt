package com.jxd.jxd_core.thread

import java.util.concurrent.Executors

/**
 *  @author : JXD
 *  @date : 2019/8/28 星期三
 */

private val DB_EXECUTOR = Executors.newSingleThreadExecutor()

fun dbThread(f: () -> Unit) {
    DB_EXECUTOR.execute(f)
}
