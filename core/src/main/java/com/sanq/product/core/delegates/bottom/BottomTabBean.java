package com.sanq.product.core.delegates.bottom;

public final class BottomTabBean {

    private final CharSequence ICON;
    private final CharSequence ICON_ACTIVE;
    private final CharSequence TITLE;

    public BottomTabBean(CharSequence ICON, CharSequence ICON_ACTIVE, CharSequence TITLE) {
        this.ICON = ICON;
        this.ICON_ACTIVE = ICON_ACTIVE;
        this.TITLE = TITLE;
    }

    public BottomTabBean(CharSequence icon, CharSequence title) {
        this.ICON = icon;
        this.TITLE = title;
        this.ICON_ACTIVE = null;
    }

    public CharSequence getIcon() {
        return ICON;
    }

    public CharSequence getTitle() {
        return TITLE;
    }

    public CharSequence getIconActive() {
        return ICON_ACTIVE;
    }
}
