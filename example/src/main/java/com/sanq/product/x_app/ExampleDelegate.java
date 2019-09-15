package com.sanq.product.x_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.sanq.product.core.delegates.CoreDelegate;
import com.sanq.product.core.wechat.WeChat;

import butterknife.BindView;

/**
 * com.sanq.product.x_app.ExampleDelegate
 *
 * @author sanq.Yan
 * @date 2019/9/15
 */
public class ExampleDelegate extends CoreDelegate {


    @Override
    public Object getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    /**
     * 微信登录
     */
    void onClickWeChat() {
        WeChat
                .getInstance()
                .onSignSuccess((userInfo) -> ToastUtils.showShort(userInfo))
                .signIn();
    }
}
