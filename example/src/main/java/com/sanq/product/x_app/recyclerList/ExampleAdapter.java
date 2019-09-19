package com.sanq.product.x_app.recyclerList;

import android.support.v7.widget.GridLayoutManager;

import com.sanq.product.core.ui.recycler.ItemType;
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
    public void onItemClick(int position) {

    }

    @Override
    protected void convert(MultipleViewHolder helper, MultipleItemEntity item) {
        switch (helper.getItemViewType()) {
            case ItemType.TEXT:
                final int id = item.getField(MultipleFields.ID);

                helper.setText(R.id.bottom_view, id + "");
                break;
        }
    }

    @Override
    public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
        return 0;
    }
}
