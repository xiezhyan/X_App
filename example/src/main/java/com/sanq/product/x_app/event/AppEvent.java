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
    */

    @Override
    public String execute(String params) {
        ToastUtils.showShort(params);

        return null;
    }
}
