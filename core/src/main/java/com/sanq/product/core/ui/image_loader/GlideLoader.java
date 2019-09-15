package com.sanq.product.core.ui.image_loader;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.sanq.product.core.activities.ProxyActivity;
import com.sanq.product.core.app.ConfigType;
import com.sanq.product.core.app.Core;

public class GlideLoader {

    private GlideLoader() {}

    public static GlideLoader getInstance() {
        return HOLDER.INSTANCE;
    }

    public static class HOLDER {
        public static final GlideLoader INSTANCE = new GlideLoader();
    }

    /**
     * Glide加载图片策略
     * @return
     */
    private RequestOptions getImageLoaderOptions() {
        return  new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate();
    }

    /**
     * 使用Glide加载图片
     * @param imageView
     * @param url
     */
    public void imageLoader ( ImageView imageView, String url) {
        ProxyActivity activity = Core.getConfiguration(ConfigType.ACTIVITY);
        Glide.with(activity)
                .load(url)
                .apply(getImageLoaderOptions())
                .into(imageView);
    }

}
