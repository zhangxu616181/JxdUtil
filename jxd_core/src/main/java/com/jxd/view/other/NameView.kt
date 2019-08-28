package com.jxd.view.other

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import java.util.*

/**
 *  @author:JinXuDong
 *  @date:2018/8/9
 *
 *  根据人脸框移动
 *  3秒后自动消失
 */
class NameView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val mNames: MutableList<NameText> = mutableListOf()
    private var mKeepALiveTime: Long = 3000L
    private val mPaint: Paint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG)
    }

    init {
        mPaint.color = Color.WHITE
        mPaint.style = Paint.Style.STROKE
        mPaint.textSize = 60f
        mPaint.strokeWidth = 4f
    }

    fun setColor(@ColorInt color: Int) {
        mPaint.color = color
    }

    fun setTextSize(textSize: Float) {
        mPaint.textSize = textSize
    }

    fun setStrokeWidth(width: Float) {
        mPaint.strokeWidth = width
    }

    fun setKeepTime(time: Long) {
        mKeepALiveTime = time
    }


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        mNames.forEach {
            val showTime = System.currentTimeMillis() - it.time - (mKeepALiveTime * 2 / 3)
            mPaint.alpha = if (showTime > 0) {
                val alOffset = mKeepALiveTime / 3 - showTime
                if (alOffset > 0) {
                    (255 * alOffset / (mKeepALiveTime / 3)).toInt()
                } else {
                    0
                }
            } else {
                255
            }
            mPaint.textAlign = Paint.Align.CENTER
            val rect = Rect()
            mPaint.getTextBounds(it.text, 0, it.text.length, rect)

            val txtWidth = rect.width()
            val txtHeight = rect.height()
            val tX =
                if (it.x + txtWidth > width) (width - txtWidth).toFloat()
                else it.x
            val tY =
                when {
                    it.y + txtHeight > height -> (height - txtHeight).toFloat()
                    it.y < txtHeight -> txtHeight.toFloat()
                    else -> it.y
                }
            canvas?.drawText(it.text, tX, tY, mPaint)
        }
    }

    fun drawName(nt: NameText) {
        val find = mNames.find { it.text == nt.text }
        if (find != null) {
            Collections.replaceAll(mNames, find, nt)
        } else {
            mNames.add(nt)
        }
        mHandler.sendEmptyMessage(0xA)
    }

    @SuppressLint("HandlerLeak")
    private val mHandler: Handler = object : Handler() {
        override fun handleMessage(msg: Message?) {
            when (msg?.what) {
                0xA -> {
                    mNames.removeAll(mNames.filter { System.currentTimeMillis() - it.time > mKeepALiveTime })
                    invalidate()
                    removeMessages(0xA)
                    sendEmptyMessageDelayed(0xA, 10)
                }
            }
        }
    }

    data class NameText(var text: String, var time: Long = System.currentTimeMillis(), var x: Float, var y: Float)
}