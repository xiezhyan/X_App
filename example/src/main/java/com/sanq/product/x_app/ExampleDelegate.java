package com.sanq.product.x_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.sanq.product.core.delegates.CoreDelegate;
import com.sanq.product.core.ui.recycler.MultipleFields;
import com.sanq.product.core.ui.recycler.MultipleItemEntity;
import com.sanq.product.core.ui.recycler.MultipleRecyclerAdapter;
import com.sanq.product.core.ui.recycler.MultipleViewHolder;
import com.sanq.product.core.ui.refresh.RefreshHandler;
import com.sanq.product.core.wechat.WeChat;
import com.sanq.product.x_app.recyclerList.DataConvert;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * com.sanq.product.x_app.ExampleDelegate
 *
 * @author sanq.Yan
 * @date 2019/9/15
 */
public class ExampleDelegate extends CoreDelegate {


    @Override
    public Object getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        initRecyclerList();
    }

    //加载更多
    private void initRefresh() {

        new RefreshHandler.Builder()
                .setRefreshLayout(new SwipeRefreshLayout(_mActivity))
                .setRefresh(refreshLayout -> {
                    refreshLayout.setRefreshing(false);
                })
                .build();
    }

    //RecyclerView 解析数据
    private void initRecyclerList() {
        ArrayList<MultipleItemEntity> multipleItemEntities = new DataConvert().setJsonData("json data").convert();

    }

    /**
     * 微信登录
     */
    void onClickWeChat() {
        WeChat
                .getInstance()
                .onSignSuccess((userInfo) -> ToastUtils.showShort(userInfo))
                .signIn();
    }
}
