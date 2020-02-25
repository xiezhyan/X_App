package com.sanq.product.x_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.sanq.product.core.delegates.ToolbarDelegate;
import com.sanq.product.core.delegates.toolbar.ToolbarGravity;
import com.sanq.product.core.delegates.toolbar.ToolbarSetting;
import com.sanq.product.core.delegates.web.IPageLoadListener;
import com.sanq.product.core.delegates.web.WebDelegateImpl;
import com.sanq.product.core.ui.loading.LoadStyle;
import com.sanq.product.core.ui.loading.Loading;
import com.sanq.product.core.utils.system.UIUtil;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class DiscoverDelegate extends ToolbarDelegate {

    @Override
    protected ToolbarSetting getSetting() {
        return new ToolbarSetting.Builder()
                .setTitle("webview加载")
                .setTextColor(UIUtil.getColor(R.color.colorAccent))
                .setTextGravity(ToolbarGravity.CENTER.getIndex())
                .build();
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        webview();

    }

    private void webview() {
        final WebDelegateImpl delegate = WebDelegateImpl.create("index.html");
        delegate.setTopDelegate(this.getParentDelegate());

        //加载进度条
        delegate.setPageLoadListener(new IPageLoadListener() {
            @Override
            public void onLoadStart() {
                Loading.showLoading(getContext(), LoadStyle.BallGridPulseIndicator);
            }

            @Override
            public void onLoadEnd() {
                Loading.stopLoading();
            }
        });
        // R.id.web_discovery_container 容器
        getSupportDelegate().loadRootFragment(R.id.web_discovery_container, delegate);
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }

    @Override
    public Object getContentView() {
        return R.layout.delegate_discover;
    }

    @Override
    public void onMenuItemClick(MenuItem item) {

    }
}
