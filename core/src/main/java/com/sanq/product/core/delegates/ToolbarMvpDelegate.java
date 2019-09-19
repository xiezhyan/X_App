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

import com.sanq.product.core.R;
import com.sanq.product.core.delegates.toolbar.OnMenuItemClickListener;
import com.sanq.product.core.delegates.toolbar.ToolbarGravity;
import com.sanq.product.core.delegates.toolbar.ToolbarSetting;
import com.sanq.product.core.mvp.presenter.BasePresenter;
import com.sanq.product.core.mvp.view.IBaseView;

/**
 * com.sanq.product.core.delegates.ToolbarDelegate
 *
 * @author sanq.Yan
 * @date 2019/6/20
 */
public abstract class ToolbarMvpDelegate<P extends BasePresenter, T>  extends ToolbarDelegate implements IBaseView<T> {

    protected P presenter;

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        super.onBindView(savedInstanceState, rootView);

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
