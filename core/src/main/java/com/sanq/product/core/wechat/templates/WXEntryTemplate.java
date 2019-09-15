package com.sanq.product.core.wechat.templates;


import com.sanq.product.core.wechat.BaseWXEntryActivity;
import com.sanq.product.core.wechat.WeChat;

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
        finish();
        overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        WeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
