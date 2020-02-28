package com.sanq.product.x_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.orhanobut.logger.Logger;
import com.sanq.product.annotations.generator.mvp.InjectPresenter;
import com.sanq.product.core.delegates.CoreMvpDelegate;
import com.sanq.product.core.ui.image_loader.GlideLoader;
import com.sanq.product.core.ui.loading.Loading;
import com.sanq.product.core.utils.callback.CallbackManager;
import com.sanq.product.core.utils.callback.CallbackType;
import com.sanq.product.x_app.mvp.MainContract;
import com.sanq.product.x_app.mvp.MainPreserenter;

public class MemberDelegate extends CoreMvpDelegate<MainPreserenter, String> implements MainContract.MainView{

    @InjectPresenter
    private MainPreserenter mainPreserenter;

    @Override
    public Object getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        super.onBindView(savedInstanceState, rootView);

        mainPreserenter.login("", "");

        rootView.findViewById(R.id.fab).setOnClickListener((v) -> {
            start(new DiscoverDelegate());
        });

        GlideLoader.getInstance().imageLoader(rootView.findViewById(R.id.iv),
                "https://cdn.static.17k.com/book/189x272/58/13/3031358.jpg-180x240?v=1567222961000");
    }

    /**
     * 获取图片
     */
    void startCamera() {
        CallbackManager.getInstance().addCallback(CallbackType.ON_CROP, (uri) -> {
            Logger.i("on_crop", uri);
        });
        startCameraWithCheck();
    }

    @Override
    public void showLoading() {
        Loading.showLoading(getContext());
    }

    @Override
    public void dismissLoading() {
        Loading.stopLoading();
    }

    @Override
    public void onSuccess(String result) {
        LogUtils.i(getClass().getName(), result);
    }

    @Override
    public void onFailure() {
        Logger.i("failed");
    }

}
