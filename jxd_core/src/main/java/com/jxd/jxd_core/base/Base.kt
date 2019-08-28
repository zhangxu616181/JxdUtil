package com.jxd.jxd_core.base

import android.content.Context
import android.content.pm.PackageManager

/**
 *  @author : JXD
 *  @date : 2019/8/28 星期三
 */
/**
 * 检测相机是否可用
 */
fun checkCameraHardware(context: Context): Boolean {
    return context.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)
}
