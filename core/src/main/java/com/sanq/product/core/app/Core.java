package com.sanq.product.core.app;

import android.content.Context;
import android.os.Handler;

import java.util.HashMap;

public final class Core {

    public static HashMap<Object, Object> getConfigurations() {
        return getConfigurator().getConfiguratorMap();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    /**
     * 进行相应的配置
     * @param context
     * @return
     */
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return getConfigurator();
    }

    /**
     * 获取全局上下文
     * @return
     */
    public static Context getApplication() {
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }

    public static Handler getHandler() {
        return getConfiguration(ConfigType.HANDLER.name());
    }


    public static <T> T getConfiguration(Object key) {
        return (T) getConfigurations().get(key);
    }
}








