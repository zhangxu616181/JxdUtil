package com.jxd.jxdutil.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jxd.viewmodel.bean.Data

/**
 *  @author : JXD
 *  @date : 2019/4/19 星期五
 */
class MyViewModel : ViewModel() {
    val mData = MutableLiveData<Data<VmBean>>()
    fun refresh(tmp: Int) {
        if (tmp % 2 == 0) {
            mData.value = Data(VmBean("Name$tmp", tmp))
        } else {
            mData.value = Data(msg = "数据错误")
        }
    }
}