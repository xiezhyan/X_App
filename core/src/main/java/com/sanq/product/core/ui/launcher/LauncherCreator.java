package com.sanq.product.core.ui.launcher;

import android.support.v4.view.ViewPager;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.sanq.product.core.R;

import java.util.ArrayList;

public class LauncherCreator {

    public static void setLauncher(ConvenientBanner<Integer> banner, ArrayList<Integer> datas, OnItemClickListener listener) {
        banner
                .setPages(new LauncherCreatorHolder(), datas)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(listener)
                .setPageTransformer(new DefaultTransformer())
                .setCanLoop(false);
    }

    public static void setLauncher(ConvenientBanner<Integer> banner, ArrayList<Integer> datas, ViewPager.OnPageChangeListener listener) {
        banner
                .setPages(new LauncherCreatorHolder(), datas)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnPageChangeListener(listener)
                .setPageTransformer(new DefaultTransformer())
                .setCanLoop(false);
    }
}
