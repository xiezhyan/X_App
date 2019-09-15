package com.sanq.product.core.ui.launcher;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

public class LauncherCreatorHolder implements CBViewHolderCreator<LauncherHolder> {
    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
