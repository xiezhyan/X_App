package com.sanq.product.core.delegates.web.event;


import com.blankj.utilcode.util.LogUtils;

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        LogUtils.e("UndefineEvent", params);
        return null;
    }
}
