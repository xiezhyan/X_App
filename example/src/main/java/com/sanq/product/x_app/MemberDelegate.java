package com.sanq.product.x_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.sanq.product.core.delegates.CoreMvpDelegate;
import com.sanq.product.core.net.RestClientBuilder;
import com.sanq.product.core.ui.loading.Loading;
import com.sanq.product.core.utils.callback.CallbackManager;
import com.sanq.product.core.utils.callback.CallbackType;
import com.sanq.product.x_app.mvp.MainPreserenter;

public class MemberDelegate extends CoreMvpDelegate<MainPreserenter, String> {


    @Override
    public Object getContentView() {
        return null;
    }

    RestClientBuilder builder;

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        super.onBindView(savedInstanceState, rootView);

        presenter.login("", "");

    }

    @Override
    protected MainPreserenter createPresenter() {
        return new MainPreserenter();
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
        Logger.i("result", result);
    }

    @Override
    public void onFailure() {
        Logger.i("failed");
    }
}
