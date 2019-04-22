package com.jxd.jxdutil

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jxd.jxd_core.intent.openActivity
import com.jxd.jxdutil.jxd_core.CoreActivity
import com.jxd.jxdutil.view_model.VMTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        initListener()
    }

    private fun initListener() {
        mViewModel.setOnClickListener { startActivity(Intent(mContext, VMTestActivity::class.java)) }
        mJxdCore.setOnClickListener { openActivity<CoreActivity>("p" to "data", "p2" to 30, "p3" to true) }
    }
}
