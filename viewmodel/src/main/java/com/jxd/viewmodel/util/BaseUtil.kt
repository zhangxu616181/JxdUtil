package com.jxd.viewmodel.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 *  @author : JXD
 *  @date : 2019/4/19 星期五
 */

/**
 * Activity绑定ViewModel
 */
inline fun <reified T : ViewModel> FragmentActivity.bindViewModel() = ViewModelProviders.of(this).get(T::class.java)
/**
 * Fragment绑定ViewModel
 */
inline fun <reified T : ViewModel> Fragment.bindViewModel() = ViewModelProviders.of(this).get(T::class.java)