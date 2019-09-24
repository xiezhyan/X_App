package com.sanq.product.x_app.mvp;

import com.blankj.utilcode.util.LogUtils;
import com.sanq.product.core.mvp.listener.ResultCallbackListener;
import com.sanq.product.core.net.RestClient;

public class MainModel implements MainContract.MainModel {

    @Override
    public void login(String loginName, String loginPwd, ResultCallbackListener callback) {
        LogUtils.i(MainModel.class.getName(), "start loading");

        callback.getSuccess().onSuccess("success");
    }
}
