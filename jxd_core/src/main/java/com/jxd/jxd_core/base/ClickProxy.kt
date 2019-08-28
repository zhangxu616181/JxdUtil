package com.jxd.jxd_core.base

import android.view.View

/**
 *  @author:JinXuDong
 *  @date:2018/5/29
 *  点击代理  防止快速重复点击
 */
class ClickProxy() : View.OnClickListener {
    private var mLastClick = 0L
    private val mTimeDelay = 500L

    private var l: ((View) -> Unit)? = null

    constructor(l: ((View) -> Unit)) : this() {
        this.l = l
    }

    override fun onClick(v: View) {
        val mCurrentTime = System.currentTimeMillis()
        if (mCurrentTime - mLastClick >= mTimeDelay) {
            l?.invoke(v)
            mLastClick = mCurrentTime
        }
    }

}