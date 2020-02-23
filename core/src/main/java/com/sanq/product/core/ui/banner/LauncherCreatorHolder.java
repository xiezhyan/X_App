package com.sanq.product.core.ui.banner;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.sanq.product.core.ui.banner.LauncherHolder;

public class LauncherCreatorHolder implements CBViewHolderCreator<LauncherHolder> {
    @Override
    public LauncherHolder createHolder() {
        return new LauncherHolder();
    }
}
