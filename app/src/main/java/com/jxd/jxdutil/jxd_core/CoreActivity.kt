package com.jxd.jxdutil.jxd_core

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jxd.jxd_core.sharedPreferences.getValue
import com.jxd.jxd_core.sharedPreferences.saveValue
import com.jxd.jxdutil.R
import kotlinx.android.synthetic.main.activity_core.*

class CoreActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_core)
        if (intent.hasExtra("p")) {
            mTvCore.text = mTvCore.text.toString().trim() + " \np ==> " + intent.getStringExtra("p")
        }
        if (intent.hasExtra("p2")) {
            mTvCore.text = mTvCore.text.toString().trim() + " \np2 ==> " + intent.getIntExtra("p2", 0)
        }
        if (intent.hasExtra("p3")) {
            mTvCore.text = mTvCore.text.toString().trim() + " \np3 ==> " + intent.getBooleanExtra("p3", false)
        }
        mBtnCore.setOnClickListener { saveValue("jxd_test","APP_NAME") }
        mBtnGetSp.setOnClickListener { mBtnGetSp.text = getValue<String>("jxd_test") }
    }
}
