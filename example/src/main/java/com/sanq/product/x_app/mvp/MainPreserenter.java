package com.sanq.product.x_app.mvp;

import com.sanq.product.core.mvp.listener.ResultCallbackListener;
import com.sanq.product.core.mvp.presenter.BasePresenter;

public class MainPreserenter extends BasePresenter<MainModel, MainContract.MainView> implements MainContract.MainPreserenter {

    @Override
    public void start() {

    }

    @Override
    public void login(String loginName, String loginPwd) {
        if (isViewAttached()) {
            getView().showLoading();

            ResultCallbackListener callback = new ResultCallbackListener.Builder().setSuccess(response -> {
                getView().dismissLoading();
                getView().onSuccess(response);
            }).setFailure(() -> {
                getView().dismissLoading();
                getView().onFailure();
            }).build();

            getModule().login(loginName, loginPwd, callback);
    }
    }
}
