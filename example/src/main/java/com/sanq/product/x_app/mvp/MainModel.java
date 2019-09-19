package com.sanq.product.x_app.mvp;

import com.sanq.product.core.mvp.listener.ResultCallbackListener;
import com.sanq.product.core.net.RestClient;
import com.sanq.product.core.net.callback.ISuccess;

public class MainModel implements MainContract.MainModel {

    @Override
    public void login(String loginName, String loginPwd, ResultCallbackListener callback) {
        RestClient.builder()
                .url("")
                .params("loginName", loginName)
                .params("loginPwd", loginPwd)
                .success(callback.getSuccess())
                .failure(callback.getFailure())
                .build().get();
    }
}
