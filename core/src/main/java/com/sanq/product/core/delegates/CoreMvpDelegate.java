package com.sanq.product.core.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.sanq.product.core.mvp.presenter.BasePresenter;
import com.sanq.product.core.mvp.view.IBaseView;

public abstract class CoreMvpDelegate<P extends BasePresenter, T> extends CoreDelegate implements IBaseView<T> {

    protected P presenter;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }

    /**
     * 创建Presenter
     */
    protected abstract P createPresenter();
}
