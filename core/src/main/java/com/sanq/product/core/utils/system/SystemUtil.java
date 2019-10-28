package com.sanq.product.core.utils.system;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.sanq.product.core.app.Core;

import java.util.Locale;

public class SystemUtil {

    /**
     * 获取application中指定key的meta-data值
     * @param name
     * @return
     */
    public static String getApplicationMetadata(String name) {
        ApplicationInfo info = null;
        try {
            PackageManager pm = Core.getApplication().getPackageManager();

            info = pm.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);

            return String.valueOf(info.metaData.get(name));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取包名
     * @return
     */
    public static String getPackageName() {
        return Core.getApplication().getPackageName();
    }

    /**
     * 获取版本名称
     * @return
     */
    public static String getVersionName(){
        try {
            PackageManager manager = Core.getApplication().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0.0";
    }

    /**
     * 获取版本号
     * @return
     */
    public static int getVersionCode(){
        try {
            PackageManager manager = Core.getApplication().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 获取当前手机系统语言。
     *
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return  语言列表
     */
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return  系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return  手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return  手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机IMEI(需要“android.permission.READ_PHONE_STATE”权限)
     *
     * @return  手机IMEI
     */
//    public static String getIMEI(Context ctx) {
//        TelephonyManager tm = (TelephonyManager) ctx.getSystemService(Activity.TELEPHONY_SERVICE);
//        if (tm != null) {
//            return tm.getDeviceId();
//        }
//        return null;
//    }


}
