package com.sanq.product.core.delegates.toolbar;

import android.support.v4.view.GravityCompat;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.sanq.product.core.R;
import com.sanq.product.core.utils.system.UIUtil;

import java.io.Serializable;

/**
 * com.sanq.product.core.delegates.toolbar.ToolbarSetting
 *
 * @author sanq.Yan
 * @date 2019/6/20
 */
public class ToolbarSetting implements Serializable {
    private int logo;
    private String title;
    private int textColor;
    private int textGravity = ToolbarGravity.LEFT.getIndex();
    private int navigationIcon;
    private int backgroundColor;
    private int popupTheme;
    private boolean displayHomeAsUpEnabled = true;
    private View.OnClickListener clickListener;
    private int menu;

    public int getLogo() {
        return logo;
    }

    public String getTitle() {
        return title;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getTextGravity() {
        return textGravity;
    }

    public int getNavigationIcon() {
        return navigationIcon;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getPopupTheme() {
        return popupTheme;
    }

    public boolean isDisplayHomeAsUpEnabled() {
        return displayHomeAsUpEnabled;
    }

    public View.OnClickListener getClickListener() {
        return clickListener;
    }

    public int getMenu() {
        return menu;
    }

    public ToolbarSetting(int logo, String title, int textColor, int textGravity, int navigationIcon, int backgroundColor, int popupTheme, boolean displayHomeAsUpEnabled, View.OnClickListener clickListener, int menu) {
        this.logo = logo;
        this.title = title;
        this.textColor = textColor;
        this.textGravity = textGravity;
        this.navigationIcon = navigationIcon;
        this.backgroundColor = backgroundColor;
        this.popupTheme = popupTheme;
        this.displayHomeAsUpEnabled = displayHomeAsUpEnabled;
        this.clickListener = clickListener;
        this.menu = menu;
    }

    public static class Builder {
        private int logo;
        private String title;
        private int textColor;
        private int textGravity = ToolbarGravity.LEFT.getIndex();
        private int navigationIcon;
        private int backgroundColor;
        private int popupTheme;
        private boolean displayHomeAsUpEnabled = true;
        private View.OnClickListener clickListener;
        private int menu;

        public Builder setLogo(int logo) {
            this.logo = logo;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTextColor(int textColor) {
            this.textColor = textColor;
            return this;
        }

        public Builder setTextGravity(int textGravity) {
            this.textGravity = textGravity;
            return this;
        }

        public Builder setNavigationIcon(int navigationIcon) {
            this.navigationIcon = navigationIcon;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setPopupTheme(int popupTheme) {
            this.popupTheme = popupTheme;
            return this;
        }

        public Builder setDisplayHomeAsUpEnabled(boolean displayHomeAsUpEnabled) {
            this.displayHomeAsUpEnabled = displayHomeAsUpEnabled;
            return this;
        }

        public Builder setClickListener(View.OnClickListener clickListener) {
            this.clickListener = clickListener;
            return this;
        }

        public Builder setMenu(int menu) {
            this.menu = menu;
            return this;
        }

        public ToolbarSetting build() {
            return new ToolbarSetting(
                    logo,
                    title,
                    textColor,
                    textGravity,
                    navigationIcon,
                    backgroundColor,
                    popupTheme,
                    displayHomeAsUpEnabled,
                    clickListener,
                    menu);
        }
    }

}
