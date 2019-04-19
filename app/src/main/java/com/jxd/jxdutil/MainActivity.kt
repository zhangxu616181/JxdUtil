package com.jxd.jxdutil

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jxd.jxdutil.view_model.VMTestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mContext:Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mContext = this
        initListener()
    }

    private fun initListener() {
        mViewModel.setOnClickListener { startActivity(Intent(mContext,VMTestActivity::class.java)) }
    }
}
