package com.sanq.product.core.ui.image_loader;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.sanq.product.core.activities.ProxyActivity;
import com.sanq.product.core.app.ConfigType;
import com.sanq.product.core.app.Core;

public class GlideLoader {

    private GlideLoader() {
    }

    public static GlideLoader getInstance() {
        return HOLDER.INSTANCE;
    }

    public static class HOLDER {
        public static final GlideLoader INSTANCE = new GlideLoader();
    }

    /**
     * Glide加载图片策略
     *
     * @return
     */
    private RequestOptions getImageLoaderOptions() {
        return new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate();
    }

    /**
     * 使用Glide加载图片
     *
     * @param imageView
     * @param url
     */
    public RequestBuilder<Drawable> imageLoader(ImageView imageView, String url) {
        ProxyActivity activity = Core.getConfiguration(ConfigType.ACTIVITY);

        return loadImage(activity, imageView, url, null);
    }

    public RequestBuilder<Drawable> imageLoader(ImageView imageView, String url, RequestListener listener) {
        ProxyActivity activity = Core.getConfiguration(ConfigType.ACTIVITY);

        return loadImage(activity, imageView, url, listener);
    }

    private RequestBuilder<Drawable> loadImage(ProxyActivity activity, ImageView imageView, String url, RequestListener listener) {
        RequestBuilder<Drawable> apply = Glide.with(activity)
                .load(url)
                .apply(getImageLoaderOptions());

        if (listener != null)
            apply.listener(listener);

        apply.into(imageView);

        return apply;
    }

}
