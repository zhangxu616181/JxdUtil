package com.jxd.view.other;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;

/**
 *  @author:JinXuDong
 *  @date:2018/8/9
 *
 */
@SuppressLint("AppCompatCustomView")
public class TimeView extends TextView {
    private static final int WHAT_TIME_CHANGED = 0x1;
    private TimeHandler mHandler;
    private int mLastVisibleState = -1;
    private boolean isReady = false;
    private long mDelayed = 100;


    public TimeView(Context context) {
        super(context);
        init();
    }

    public TimeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    /**
     * 初始化TextView
     */
    private void init() {
        mHandler = new TimeHandler();
        onStart();
    }

    private void onStart() {
        isReady = true;
        if (mHandler != null) {
            mHandler.sendEmptyMessage(WHAT_TIME_CHANGED);
        }
    }

    private void onStop() {
        isReady = false;
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }

    /**
     * 设置更新间隔时间
     *
     * @param mDelayed
     */
    public void setDelayed(long mDelayed) {
        this.mDelayed = mDelayed;
        restart();
    }

    /**
     * 重新开始
     */
    private void restart() {
        onStop();
        onStart();
    }

    private void onRelease() {
        onStop();
        mHandler = null;
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (mLastVisibleState == View.INVISIBLE || mLastVisibleState == View.GONE) {
            if (visibility == View.VISIBLE) {
                onStart();
            }
        }
        if (mLastVisibleState == View.VISIBLE) {
            if (visibility != View.VISIBLE) {
                onStop();
            }
        }
        mLastVisibleState = visibility;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        onRelease();
    }

    @SuppressLint("HandlerLeak")
    private class TimeHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_TIME_CHANGED:
                    if (isReady) {
                        TimeView.this.setText(getTimeString());
                        mHandler.sendEmptyMessageDelayed(WHAT_TIME_CHANGED, mDelayed);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private String getTimeString() {
        return new SimpleDateFormat("HH:mm:ss").format(System.currentTimeMillis());
    }


}
