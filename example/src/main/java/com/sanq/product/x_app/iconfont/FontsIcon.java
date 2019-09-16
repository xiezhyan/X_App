package com.sanq.product.x_app.iconfont;

import com.joanzapata.iconify.Icon;

public enum FontsIcon implements Icon {

    //{icon-scan}
    icon_scan('\ue606');

    private char character;

    FontsIcon(char character) {
        this.character = character;
    }


    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
