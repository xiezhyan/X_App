package com.sanq.product.core.delegates;

public abstract class CoreDelegate extends PermissionCheckerDelegate{

    public <T extends BaseDelegates> T getParentDelegate() {
        return (T) getParentFragment();
    }

}
