package com.sanq.product.x_app.event;

import com.blankj.utilcode.util.ToastUtils;
import com.sanq.product.core.delegates.web.event.Event;

/**
 * com.sanq.product.x_app.event.AppEvent
 *
 * @author sanq.Yan
 * @date 2019/9/15
 */
public class AppEvent extends Event {
    
    /** 格式
        var json = {
            action: "test"
        };
        appEvent.event(JSON.stringify(json));
    */

    @Override
    public String execute(String params) {
        ToastUtils.showShort(params);

        // 执行js方法
        if(getAction().equals("test")) {
            final WebView webView = getWebView();
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall();", null);
                }
            });
        }
        
        return null;
    }
}
