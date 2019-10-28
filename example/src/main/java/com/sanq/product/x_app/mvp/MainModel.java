package com.sanq.product.x_app.mvp;

import com.blankj.utilcode.util.LogUtils;
import com.sanq.product.core.mvp.listener.ResultCallbackListener;
import com.sanq.product.core.net.RestClient;
import com.sanq.product.core.utils.system.SystemUtil;

public class MainModel implements MainContract.MainModel {

    @Override
    public void login(String loginName, String loginPwd, ResultCallbackListener callback) {
        LogUtils.i(MainModel.class.getName(), "start loading");

        callback.getSuccess().onSuccess(String.format("%s:%s:%s:%s",
                    SystemUtil.getPackageName(),
                    SystemUtil.getApplicationMetadata("md"),
                    SystemUtil.getVersionName(),
                    SystemUtil.getVersionCode()));
    }
}
