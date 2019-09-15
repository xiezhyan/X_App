package com.sanq.product.core.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import com.sanq.product.core.app.Core;

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;

    private IRefresh mIRefresh;

    public RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    public void setRefresh(IRefresh iRefresh) {
        this.mIRefresh = iRefresh;
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);

        Core.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mIRefresh.onRefresh(REFRESH_LAYOUT);
            }
        }, 100);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
