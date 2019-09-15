package com.sanq.product.core.ui.nine_layout;

import android.content.Context;
import android.util.AttributeSet;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sanq.product.core.ui.image_loader.GlideLoader;

import java.util.List;

public class NineGridLayout extends INineGridLayout {

    public NineGridLayout(Context context) {
        super(context);
    }

    public NineGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean displayOneImage(RatioImageView imageView, String url, int parentWidth) {

        return true;
    }

    @Override
    protected void displayImage(RatioImageView imageView, String url) {
        GlideLoader.getInstance().imageLoader(imageView, url);
    }

    @Override
    protected void onClickImage(int position, String url, List<String> urlList) {
        LogUtils.d("nine", position + "::" + url + "::" + urlList.size());
    }
}
