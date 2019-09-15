package com.sanq.product.core.utils.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.sanq.product.core.app.Core;

/**
 * 测量
 */
public class DimenUtil {
    public static int getScreenWidth() {
        final Resources resources = Core.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Core.getApplication().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
