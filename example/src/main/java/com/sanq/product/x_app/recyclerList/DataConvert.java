package com.sanq.product.x_app.recyclerList;

import com.sanq.product.core.ui.recycler.DataConverter;
import com.sanq.product.core.ui.recycler.MultipleEntityBuilder;
import com.sanq.product.core.ui.recycler.MultipleFields;
import com.sanq.product.core.ui.recycler.MultipleItemEntity;

import java.util.ArrayList;

public class DataConvert extends DataConverter<String> {


    @Override
    public ArrayList<MultipleItemEntity> convert() {
        String data = getJsonData();


        MultipleItemEntity entity = MultipleItemEntity.builder()
                .setField(MultipleFields.ID, 1)
                .build();

        ENTITIES.add(entity);
        return ENTITIES;
    }
}
