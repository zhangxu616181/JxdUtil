package com.jxd.jxdutil.view_model

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.jxd.jxdutil.R
import com.jxd.viewmodel.bean.Data
import com.jxd.viewmodel.util.bindViewModel
import kotlinx.android.synthetic.main.activity_vmtest.*

class VMTestActivity : AppCompatActivity() {

    private lateinit var mViewModel: MyViewModel
    private var _count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vmtest)
        mViewModel = bindViewModel()
        mViewModel.mData.observe(this, Observer<Data<VmBean>> {
            it?.data?.let { bean -> toast(bean.toString()) }
            it?.msg?.let { m -> toast(m) }
        })

        initListener()
    }

    private fun initListener() {
        mVmRefresh.setOnClickListener {
            val timeMillis = System.currentTimeMillis()
            val ot = timeMillis % 1000
            mViewModel.refresh(ot.toInt())
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
