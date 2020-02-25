package com.sanq.product.core.ui.recycler;

import java.util.ArrayList;

public abstract class DataConverter<T> {

    protected final ArrayList<MultipleItemEntity> ENTITIES = new ArrayList<>();
    private T mJsonData = null;

    public abstract ArrayList<MultipleItemEntity> convert();

    public DataConverter setJsonData(T json) {
        this.mJsonData = json;
        return this;
    }

    protected T getJsonData() {
        if (mJsonData == null) {
            throw new NullPointerException("DATA IS NULL!");
        }
        return mJsonData;
    }

    public void clearData(){
        ENTITIES.clear();
    }
}
