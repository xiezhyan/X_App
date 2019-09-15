package com.sanq.product.core.delegates.toolbar;

/**
 * com.sanq.product.core.delegates.toolbar.ToolbarGravity
 *
 * @author sanq.Yan
 * @date 2019/6/21
 */
public enum ToolbarGravity {
    LEFT(1),
    CENTER(2),
    RIGHT(3);

    private int index;
    ToolbarGravity(int i) {
        this.index = i;
    }

    public int getIndex() {
        return index;
    }
}
