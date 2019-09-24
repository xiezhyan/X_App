package com.sanq.product.x_app;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.sanq.product.core.account.ISignListener;
import com.sanq.product.core.activities.ProxyActivity;
import com.sanq.product.core.app.Core;
import com.sanq.product.core.delegates.CoreDelegate;
import com.sanq.product.core.launcher.ILauncherListener;
import com.sanq.product.core.launcher.OnLauncherFinishTag;

public class MainActivity extends ProxyActivity implements
        ISignListener,
        ILauncherListener {

    @Override
    protected CoreDelegate setRootDelegate() {
        return new MemberDelegate();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Core.getConfigurator().withActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onSignInSuccess() {
        //登录成功
    }

    @Override
    public void onSignUpSuccess() {
        //注册成功

    }

    @Override
    public void onLauncherFinish(OnLauncherFinishTag state) {
        switch (state) {
            case SIGNED:
                // 用户已登录
                break;
            case NOT_SIGNED:
                //用户未注册
                break;
            default:
                break;
        }
    }
}
