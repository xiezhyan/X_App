package com.sanq.product.core.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sanq.product.annotations.generator.mvp.InjectPresenter;
import com.sanq.product.core.mvp.presenter.BasePresenter;
import com.sanq.product.core.mvp.view.IBaseView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public abstract class CoreMvpDelegate<P extends BasePresenter, T> extends CoreDelegate implements IBaseView<T> {

    private List<P> mInjectPresenters;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        mInjectPresenters = new ArrayList<>();

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
