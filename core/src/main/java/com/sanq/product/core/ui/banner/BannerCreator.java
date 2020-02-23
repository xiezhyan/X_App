package com.sanq.product.core.ui.banner;

import android.support.v4.view.ViewPager;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.sanq.product.core.R;

import java.util.ArrayList;

public class BannerCreator<T> {

    public void showBanner(BannerBean<T> bean) {
        ConvenientBanner<T> banner = bean.getBanner();

        CBViewHolderCreator holderCreator = null;

        if (bean.getHolderCreator() != null)
            holderCreator = bean.getHolderCreator();
        else
            holderCreator = bean.getHolderType() == BannerBean.HoldType.RES_INT
                            ? new LauncherCreatorHolder() :     // 静态
                                new HolderCreator();            // URL加载

        if (bean.getOnItemClickListener() != null) {
            banner.setOnItemClickListener(bean.getOnItemClickListener());
        }
        if (bean.getOnPageChangeListener() != null) {
            banner.setOnPageChangeListener(bean.getOnPageChangeListener());
        }

        banner.setPages(holderCreator, bean.getDatas())
                .setPageTransformer(bean.getTransformer())
                .setPageIndicator(bean.getIndicators())
                .setPageIndicatorAlign(bean.getIndicatorAlign())
                .startTurning(bean.getStartTurning())
                .setCanLoop(bean.isCanLoop());

    }

    public void showBanner(ConvenientBanner<T> banner, ArrayList<T> datas, int type) {
        banner
                .setPages(type == BannerBean.HoldType.RES_INT ? new LauncherCreatorHolder() : new HolderCreator(), datas)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setPageTransformer(new DefaultTransformer())
                .startTurning(3000)
                .setCanLoop(true);
    }

    public void showBanner(ConvenientBanner<T> banner, ArrayList<T> datas, int type, OnItemClickListener listener) {
        banner
                .setPages(type == BannerBean.HoldType.RES_INT ? new LauncherCreatorHolder() : new HolderCreator(), datas)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setPageTransformer(new DefaultTransformer())
                .startTurning(3000)
                .setOnItemClickListener(listener)
                .setCanLoop(true);
    }

    public void showBanner(ConvenientBanner<T> banner, ArrayList<T> datas, int type, ViewPager.OnPageChangeListener listener) {
        banner
                .setPages(type == BannerBean.HoldType.RES_INT ? new LauncherCreatorHolder() : new HolderCreator(), datas)
                .setPageIndicator(new int[]{R.drawable.dot_normal, R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setPageTransformer(new DefaultTransformer())
                .startTurning(3000)
                .setOnPageChangeListener(listener)
                .setCanLoop(true);
    }
}
