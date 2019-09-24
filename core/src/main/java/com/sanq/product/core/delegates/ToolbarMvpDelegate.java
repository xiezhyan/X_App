package com.sanq.product.core.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sanq.product.annotations.generator.mvp.InjectPresenter;
import com.sanq.product.core.R;
import com.sanq.product.core.delegates.toolbar.OnMenuItemClickListener;
import com.sanq.product.core.delegates.toolbar.ToolbarGravity;
import com.sanq.product.core.delegates.toolbar.ToolbarSetting;
import com.sanq.product.core.mvp.presenter.BasePresenter;
import com.sanq.product.core.mvp.view.IBaseView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * com.sanq.product.core.delegates.ToolbarDelegate
 *
 * @author sanq.Yan
 * @date 2019/6/20
 */
public abstract class ToolbarMvpDelegate<P extends BasePresenter, T>  extends ToolbarDelegate implements IBaseView<T> {

    /**
     * 保存使用注解的 Presenter ，用于解绑
     */
    private List<P> mInjectPresenters;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        super.onBindView(savedInstanceState, rootView);

        mInjectPresenters = new ArrayList<>();

        //获得已经申明的变量，包括私有的
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            //获取变量上面的注解类型
            InjectPresenter injectPresenter = field.getAnnotation(InjectPresenter.class);
            if (injectPresenter != null) {
                try {
                    Class<P> type = (Class<P>) field.getType();
                    P mInjectPresenter = null;
                    mInjectPresenter = type.newInstance();
                    mInjectPresenter.attachView(this);
                    field.setAccessible(true);
                    field.set(this, mInjectPresenter);
                    mInjectPresenters.add(mInjectPresenter);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("SubClass must extends Class:BasePresenter");
                }
            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();

        for (P presenter : mInjectPresenters) {
            presenter.detachView();
        }
        mInjectPresenters.clear();
        mInjectPresenters = null;
    }

}
