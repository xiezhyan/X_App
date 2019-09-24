package com.sanq.product.core.mvp.proxy.impl;

import com.sanq.product.annotations.generator.mvp.InjectPresenter;
import com.sanq.product.core.mvp.presenter.BasePresenter;
import com.sanq.product.core.mvp.proxy.IProxy;
import com.sanq.product.core.mvp.view.IBaseView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ProxyImpl<P extends BasePresenter> implements IProxy {

    private List<P> mInjectPresenters;

    private IBaseView mView;

    public ProxyImpl(IBaseView view) {
        this.mView = view;
        mInjectPresenters = new ArrayList<>();
    }

    @Override
    public void bindPreserent() {
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
                    mInjectPresenter.attachView(this.mView);
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
    public void unBindPreserent() {
        for (P presenter : mInjectPresenters) {
            presenter.detachView();
        }
        mInjectPresenters.clear();
        mInjectPresenters = null;
    }
}
