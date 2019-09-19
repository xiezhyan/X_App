package com.sanq.product.x_app.app;

import android.app.Application;
import android.support.annotation.Nullable;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.sanq.product.core.app.Core;
import com.sanq.product.core.utils.callback.CallbackManager;
import com.sanq.product.core.utils.callback.CallbackType;
import com.sanq.product.core.utils.callback.IGlobalCallback;
import com.sanq.product.x_app.event.AppEvent;
import com.sanq.product.x_app.iconfont.FontsIconDescriptor;

/**
 * com.sanq.product.x_app.app.App
 *
 * @author sanq.Yan
 * @date 2019/9/15
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Core.init(this)
                .withDBFlow()
                .withApiHost("")
                .withJavascriptInterface("app")
                .withWebEvent("appEvent", new AppEvent())
                .withIcons(new FontsIconDescriptor())
                .configure();

        CallbackManager.getInstance()
                .addCallback(CallbackType.TAG_OPEN_PUSH, args -> {
                    //开启推送
                })
                .addCallback(CallbackType.TAG_STOP_PUSH, args -> {
                    //停止推送
                });
    }
}
