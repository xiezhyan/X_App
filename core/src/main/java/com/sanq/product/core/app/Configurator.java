package com.sanq.product.core.app;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.Utils;
import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.sanq.product.core.delegates.web.event.Event;
import com.sanq.product.core.delegates.web.event.EventManager;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.Interceptor;

public class Configurator {

    private static final HashMap<Object , Object> CONFIGURATOR = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();
    private static final ArrayList<Interceptor> INTERCEPTORS  = new ArrayList<>();
    private static final Handler HANDLER = new Handler();

    public Configurator() {
        CONFIGURATOR.put(ConfigType.CONFIG_READY.name(), false);
        CONFIGURATOR.put(ConfigType.HANDLER.name(), new Handler());
    }

    /**
     * 静态内部类方式的 单例模式
     */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<Object , Object> getConfiguratorMap() {
        return CONFIGURATOR;
    }

    /**
     * 配置完成
     */
    public final void configure() {
        initIcons();
        Logger.addLogAdapter(new AndroidLogAdapter());
        CONFIGURATOR.put(ConfigType.CONFIG_READY.name(), true);
        //初始化工具类库
        Utils.init(Core.getApplication());
    }

    /**
     * 配置字体库
     */
    private void initIcons() {
        if(ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for(int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    /**
     * 配置API_HOST
     * @param apiHost
     * @return
     */
    public final Configurator withApiHost(String apiHost) {
        CONFIGURATOR.put(ConfigType.API_HOST.name(), apiHost);
        return this;
    }

    /**
     * 配置ICON
     * @param descriptor
     * @return
     */
    public final Configurator withIcons(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    /**
     * 配置拦截器
     * @param interceptor
     * @return
     */
    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        CONFIGURATOR.put(ConfigType.INTERCEPTOR.name(), INTERCEPTORS);
        return this;
    }

    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        CONFIGURATOR.put(ConfigType.INTERCEPTOR.name(), INTERCEPTORS);
        return this;
    }

    /**
     * 配置DBFLow数据库
     * @return
     */
    public final Configurator withDBFlow() {
//        FlowManager.init(new FlowConfig.Builder(Core.getApplication()).build());
        FlowManager.init(new FlowConfig.Builder(Core.getApplication())
                .openDatabasesOnInit(true) // 数据库初始化的时候就开始打开
                .build());
        return this;
    }

    /**
     * 微信AppID
     * @param appId
     * @return
     */
    public final Configurator withWxAppId(String appId) {
        CONFIGURATOR.put(ConfigType.WE_CHAT_APP_ID, appId);
        return this;
    }

    /**
     * 微信AppSecret
     * @param appSecret
     * @return
     */
    public final Configurator withWxAppSecret(String appSecret) {
        CONFIGURATOR.put(ConfigType.WE_CHAT_APP_SECRET, appSecret);
        return this;
    }

    /**
     * 配置activity
     * @param activity
     * @return
     */
    public final Configurator withActivity(Activity activity) {
        CONFIGURATOR.put(ConfigType.ACTIVITY, activity);
        return this;
    }

    /**
     * 配置html名称
     * @param name
     * @return
     */
    public final Configurator withJavascriptInterface(@Nullable String name) {
        CONFIGURATOR.put(ConfigType.JAVASCRIPT_INTERFACE, name);
        return this;
    }

    public final Configurator withWebEvent(@Nullable String name, @Nullable Event event) {
        EventManager.getInstance().addEvent(name, event);
        return this;
    }

    private void checkConfigrators() {
        //限制更改不需要修改的配置项
        final boolean isReady = (boolean) CONFIGURATOR.get(ConfigType.CONFIG_READY.name());
        if(!isReady)
            throw  new RuntimeException("configurator is not ready, call configurator");
    }

    final <T> T getConfigurator(Enum<ConfigType> key) {
        checkConfigrators();
        return (T) CONFIGURATOR.get(key.name());
    }
}
