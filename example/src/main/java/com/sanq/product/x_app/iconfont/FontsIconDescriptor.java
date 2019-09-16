package com.sanq.product.x_app.iconfont;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

public class FontsIconDescriptor implements IconFontDescriptor {


    //文件路径
    @Override
    public String ttfFileName() {
        return null;
    }

    @Override
    public Icon[] characters() {
        return FontsIcon.values();
    }
}
