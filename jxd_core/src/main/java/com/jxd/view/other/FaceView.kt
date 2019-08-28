package com.jxd.view.other

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt

/**
 *  @author:JinXuDong
 *  @date:2018/8/9
 *
 *  FaceView主要是用来展示人脸识别后的方框
 */
class FaceView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val mPaint: Paint by lazy {
        Paint(Paint.ANTI_ALIAS_FLAG)
    }

    init {
        mPaint.color = Color.WHITE
        mPaint.style = Paint.Style.STROKE
    }

    var mFaceList: MutableList<Face>? = null


    override fun onDraw(canvas: Canvas?) {
        if (mFaceList != null){
            mFaceList?.forEach {
                canvas?.drawRect(it.rect, mPaint)
            }
            mFaceList?.clear()
        }
    }

    fun drawFace() {
        invalidate()
    }

    fun setColor(@ColorInt color: Int) {
        mPaint.color = color
    }

    fun setStrokeWidth(width: Float) {
        mPaint.strokeWidth = width
    }

    fun setAlpha(a: Int) {
        mPaint.alpha = a
    }

    fun setTextSize(textSize: Float) {
        mPaint.textSize = textSize
    }

    data class Face(var text: String, var rect: Rect)
}

