package com.sanq.product.x_app.recyclerList;

import android.support.v7.widget.GridLayoutManager;

import com.sanq.product.core.ui.recycler.MultipleFields;
import com.sanq.product.core.ui.recycler.MultipleItemEntity;
import com.sanq.product.core.ui.recycler.MultipleRecyclerAdapter;
import com.sanq.product.core.ui.recycler.MultipleViewHolder;
import com.sanq.product.x_app.R;

import java.util.List;

public class ExampleAdapter extends MultipleRecyclerAdapter {

    public ExampleAdapter(List<MultipleItemEntity> data) {
        super(data);
        initItemType();
    }

    private void initItemType() {
        //添加布局
//        addItemType();
    }

    @Override
    protected void convert(MultipleViewHolder helper, MultipleItemEntity item) {
    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return 0;
    }
}
