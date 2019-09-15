package com.sanq.product.x_app.app;

import android.app.Application;

import com.sanq.product.core.app.Core;
import com.sanq.product.x_app.event.AppEvent;

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
                .configure();
    }
}
