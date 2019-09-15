package com.sanq.product.core.delegates.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.sanq.product.core.delegates.web.event.Event;
import com.sanq.product.core.delegates.web.event.EventManager;


final class WebInterface {
    private final WebDelegate DELEGATE;

    private WebInterface(WebDelegate delegate) {
        this.DELEGATE = delegate;
    }

    static WebInterface create(WebDelegate delegate) {
        return new WebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params) {

        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        LogUtils.d("WEB_EVENT",params);
        if (event != null) {
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }
}
