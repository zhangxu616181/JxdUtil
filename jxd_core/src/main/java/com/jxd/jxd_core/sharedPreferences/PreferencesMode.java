package com.jxd.jxd_core.sharedPreferences;

import android.annotation.SuppressLint;
import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static android.content.Context.*;

/**
 * @author : JXD
 * @date : 2019/4/22 星期一
 */
@SuppressLint({"WorldReadableFiles", "WorldWriteableFiles"})
@IntDef(flag = true, value = {
        MODE_PRIVATE,
        MODE_WORLD_READABLE,
        MODE_WORLD_WRITEABLE,
        MODE_MULTI_PROCESS,
})
@Retention(RetentionPolicy.SOURCE)
public @interface PreferencesMode {}