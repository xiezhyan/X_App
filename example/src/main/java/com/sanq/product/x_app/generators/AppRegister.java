package com.sanq.product.x_app.generators;

import com.sanq.product.annotations.generator.AppRegisterGenerator;
import com.sanq.product.core.wechat.templates.AppRegisterTemplate;

@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.sanq.product.x_app",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
