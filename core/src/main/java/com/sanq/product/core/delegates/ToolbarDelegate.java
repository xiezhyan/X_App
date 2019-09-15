package com.sanq.product.core.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.sanq.product.core.R;
import com.sanq.product.core.R2;
import com.sanq.product.core.delegates.toolbar.OnMenuItemClickListener;
import com.sanq.product.core.delegates.toolbar.ToolbarGravity;
import com.sanq.product.core.delegates.toolbar.ToolbarSetting;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * com.sanq.product.core.delegates.ToolbarDelegate
 *
 * @author sanq.Yan
 * @date 2019/6/20
 */
public abstract class ToolbarDelegate extends PermissionCheckerDelegate implements OnMenuItemClickListener {

    protected abstract ToolbarSetting getSetting();

    Toolbar mToolbar = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        mToolbar = view.findViewById(R.id.toolbar);

        setHasOptionsMenu(true);
        initToolbar();
        return view;
    }

    private void initToolbar() {
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        if(getSetting().getLogo() != 0)
            mToolbar.setLogo(getSetting().getLogo());
        if(!TextUtils.isEmpty(getSetting().getTitle()))
            mToolbar.setTitle(getSetting().getTitle());

        if(getSetting().getTextColor() != 0)
            mToolbar.setTitleTextColor(getSetting().getTextColor());

        if(getSetting().getBackgroundColor() != 0)
            mToolbar.setBackgroundColor(getSetting().getBackgroundColor());

        if(getSetting().getNavigationIcon() != 0)
            mToolbar.setNavigationIcon(getSetting().getNavigationIcon());

        if(getSetting().getClickListener() != null)
            mToolbar.setNavigationOnClickListener(getSetting().getClickListener());

        if(getSetting().getPopupTheme() != 0)
            mToolbar.setPopupTheme(getSetting().getPopupTheme());

        if(getSetting().getTextGravity() == ToolbarGravity.CENTER.getIndex()) {
            setTitleCenter(mToolbar);
        }

        if(getSetting().getMenu() != 0)
            mToolbar.inflateMenu(getSetting().getMenu());

        activity.setSupportActionBar(mToolbar);

        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(getSetting().isDisplayHomeAsUpEnabled());
        if(TextUtils.isEmpty(getSetting().getTitle())) {
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

    }

    public void setTitleCenter(Toolbar toolbar) {
        String title = getSetting().getTitle();
        final CharSequence originalTitle = toolbar.getTitle();
        toolbar.setTitle(title);
        for (int i = 0; i < toolbar.getChildCount(); i++) {
            View view = toolbar.getChildAt(i);
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (title.equals(textView.getText())) {
                    textView.setGravity(Gravity.CENTER);
                    Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.MATCH_PARENT);
                    params.gravity = Gravity.CENTER;
                    textView.setLayoutParams(params);
                }
            }
            toolbar.setTitle(originalTitle);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        if (getSetting().getMenu() != 0)
            inflater.inflate(getSetting().getMenu(), menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            pop();
        } else {
            menuItemClick(item);
        }
        return true;
    }
}
