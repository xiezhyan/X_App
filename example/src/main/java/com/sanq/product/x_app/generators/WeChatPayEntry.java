package com.sanq.product.x_app.generators;

import com.sanq.product.annotations.generator.PayEntryGenerator;
import com.sanq.product.core.wechat.templates.WXPayEntryTemplate;

@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.sanq.product.x_app",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
