package com.jxd.jxd_core.alert

import android.app.Activity
import android.app.AlertDialog
import android.view.Gravity
import android.view.LayoutInflater
import androidx.annotation.LayoutRes

/**
 *  @author : JXD
 *  @date : 2019/8/28 星期三
 */
var loadingDialog: AlertDialog? = null

/**
 * 展示LoadingDialog
 * @param id 自定义展示View
 * @param width Loading宽度
 * @param height Loading高度
 */
fun Activity.showLoading(@LayoutRes id: Int, width: Int, height: Int) {
    if (loadingDialog != null) {
        loadingDialog?.apply { if (isShowing) dismiss() }
        loadingDialog = null
    }
    val context = this
    AlertDialog.Builder(context)
        .create()
        .apply {
            setCanceledOnTouchOutside(false)
            show()
            loadingDialog = this
        }
        .window
        ?.apply {
            setGravity(Gravity.CENTER)
            setLayout(width, height)
            setContentView(LayoutInflater.from(context).inflate(id, null))
        }
}

fun Activity.hideLoading() {
    if (null == loadingDialog) return
    loadingDialog?.apply { if (isShowing) dismiss() }
    loadingDialog = null
}