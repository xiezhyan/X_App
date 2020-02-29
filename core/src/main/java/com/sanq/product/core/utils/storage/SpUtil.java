package com.sanq.product.core.utils.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.blankj.utilcode.util.StringUtils;
import com.sanq.product.core.app.Core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpUtil {

    private SpUtil() {
    }

    private static SharedPreferences sp;
    private String spName = "preference";

    private static SpUtil instance;
    public static SpUtil getInstance() {
        if (null == instance) {
            synchronized (SpUtil.class) {
                if (null == instance) {
                    instance = new SpUtil();
                }
            }
        }
        return instance;
    }

    public SpUtil setSpName(String spName) {
        this.spName = spName;
        return instance;
    }

    /**
     * 保存数据到SharedPreferences
     *
     * @param map
     */
    public void saveDataToSp(Map<String, Object> map) {
        sp = Core.getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (map != null && map.size() > 0) {
            Object obj = null;
            String key = null;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                key = entry.getKey();
                obj = entry.getValue();

                if (!StringUtils.isEmpty(key) && obj != null)
                    save(key, obj, edit);
            }
            SharedPreferencesCompat.apply(edit);
        }
    }

    private void save(String key, Object obj, SharedPreferences.Editor edit) {
        if (obj instanceof Boolean)
            edit.putBoolean(key, (Boolean) obj);
        else if (obj instanceof String)
            edit.putString(key, (String) obj);
        else if (obj instanceof Integer)
            edit.putInt(key, (Integer) obj);
        else if (obj instanceof Float)
            edit.putFloat(key, (Float) obj);
        else if (obj instanceof Long)
            edit.putLong(key, (Long) obj);
        else if (obj instanceof Set)
            edit.putStringSet(key, (Set) obj);
    }

    public SpUtil saveToSp(String key, Object val) {
        sp = Core.getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();

        if (!StringUtils.isEmpty(key) && val != null)
            save(key, val, edit);

        SharedPreferencesCompat.apply(edit);

        return instance;
    }

    /**
     * 从SharedPreferences中得到所有的数据
     *
     * @return
     */
    public Map<String, ?> getAllDataToSp() {
        sp = Core.getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        return sp.getAll();
    }

    /**
     * 从SharedPreferences得到指定的数据
     *
     * @param key
     * @param defVal
     * @return
     */
    public Object getByKeyToSp(String key, Object defVal) {
        sp = Core.getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        if (defVal instanceof Boolean)
            return sp.getBoolean(key, (Boolean) defVal);
        else if (defVal instanceof String)
            return sp.getString(key, (String) defVal);
        else if (defVal instanceof Integer)
            return sp.getInt(key, (Integer) defVal);
        else if (defVal instanceof Float)
            return sp.getFloat(key, (Float) defVal);
        else if (defVal instanceof Long)
            return sp.getLong(key, (Long) defVal);
        else if (defVal instanceof Set)
            return sp.getStringSet(key, (Set<String>) defVal);

        return null;
    }

    public void removeDataToSp(String key) {
        sp = Core.getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(key);
        SharedPreferencesCompat.apply(edit);
    }

    public void removeDataToSp() {
        sp = Core.getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.clear();
        SharedPreferencesCompat.apply(edit);
    }
    /**
     * 删除SharedPreferences中的数据
     *
     * @param keys
     */
    public void removeDatasToSp(List<String> keys) {
        sp = Core.getApplication().getSharedPreferences(spName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if (keys != null && keys.size() > 0) {
            for (String key : keys)
                edit.remove(key);
        }

        SharedPreferencesCompat.apply(edit);
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     */
    private static class SharedPreferencesCompat {
        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         *
         * @return
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            editor.commit();
        }
    }
}
