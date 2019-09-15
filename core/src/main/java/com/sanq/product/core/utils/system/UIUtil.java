package com.sanq.product.core.utils.system;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.sanq.product.core.app.Core;


/**
 * version:获取
 * --------------------------
 * author:sijun
 * date:2017/6/11
 */

public class UIUtil {
    private UIUtil() {}

    /***********************************加载资源文件**************************************/

    /**
     * 返回字符串
     * @param id
     * @return
     */
    public static String getString(int id) {
        return Core.getApplication().getResources().getString(id);
    }

    /**
     * 返回字符串数组
     * @param id
     * @return
     */
    public static String[] getStrings(int id) {
        return Core.getApplication().getResources().getStringArray(id);
    }

    /**
     * 获取颜色
     * @param id
     * @return
     */
    public static int getColor(int id) {
        return ContextCompat.getColor(Core.getApplication(),id);
    }

    /**
     * 获取尺寸
     * @param id
     * @return 像素值
     */
    public static int getDimen(int id) {
        return Core.getApplication().getResources().getDimensionPixelSize(id);
    }

    public static Animation getAnim(Context context,int id) {
        return AnimationUtils.loadAnimation(context,id);
    }
}
