package com.sanq.product.x_app.generators;

import com.sanq.product.annotations.generator.EntryGenerator;
import com.sanq.product.core.wechat.templates.WXEntryTemplate;

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.sanq.product.x_app",
        entryTemplate = WXEntryTemplate.class
)
public interface WeChatEntry {
}
