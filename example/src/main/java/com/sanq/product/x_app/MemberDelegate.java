package com.sanq.product.x_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.sanq.product.core.delegates.PermissionCheckerDelegate;
import com.sanq.product.core.utils.callback.CallbackManager;
import com.sanq.product.core.utils.callback.CallbackType;

public class MemberDelegate extends PermissionCheckerDelegate {


    @Override
    public Object getContentView() {
        return null;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

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
}
