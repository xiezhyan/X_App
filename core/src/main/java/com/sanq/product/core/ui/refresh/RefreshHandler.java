package com.sanq.product.core.ui.refresh;

import android.support.annotation.ColorRes;
import android.support.v4.widget.SwipeRefreshLayout;

import com.sanq.product.core.app.Core;

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;
    private IRefresh mIRefresh;

    private RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT, IRefresh iRefresh) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        this.mIRefresh = iRefresh;

        REFRESH_LAYOUT.setOnRefreshListener(this);
    }

    public static class Builder {
        private SwipeRefreshLayout refreshLayout;
        private IRefresh iRefresh;

        public Builder setRefreshLayout(SwipeRefreshLayout refreshLayout) {
            this.refreshLayout = refreshLayout;
            return this;
        }

        public Builder setRefresh(IRefresh iRefresh) {
            this.iRefresh = iRefresh;
            return this;
        }

        public Builder setProgressViewOffset(int start, int end) {
            this.refreshLayout.setProgressViewOffset(true, start, end);
            return this;
        }
        /**
         * 设置颜色
         */
        public Builder setColorSchemeResources(@ColorRes int... colorResIds) {
            this.refreshLayout.setColorSchemeResources(colorResIds);
            return this;
        }

        public RefreshHandler build() {
            return new RefreshHandler(refreshLayout, iRefresh);
        }
    }

    private void refresh() {
        REFRESH_LAYOUT.setRefreshing(true);

        Core.getHandler().postDelayed(() -> {
            mIRefresh.onRefresh(REFRESH_LAYOUT);
        }, 100);
    }

    @Override
    public void onRefresh() {
        refresh();
    }
}
