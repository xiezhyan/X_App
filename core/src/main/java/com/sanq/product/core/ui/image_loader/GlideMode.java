package com.sanq.product.core.ui.image_loader;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * com.sanq.product.core.ui.image_loader.GlideMode
 *
 * @author sanq.Yan
 * @date 2020/2/28
 */
@GlideModule
public class GlideMode extends AppGlideModule {
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
