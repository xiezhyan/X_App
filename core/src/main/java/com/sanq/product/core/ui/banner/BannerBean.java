package com.sanq.product.core.ui.banner;

import android.support.v4.view.ViewPager;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.sanq.product.core.R;

import java.util.ArrayList;

/**
 * com.sanq.product.core.ui.banner.BannerBean
 *
 * @author sanq.Yan
 * @date 2020/2/23
 */
public class BannerBean<T> {

    private ConvenientBanner<T> banner;

    private ArrayList<T> datas;

    private int[] indicators = new int[] {R.drawable.dot_normal, R.drawable.dot_focus};

    private ConvenientBanner.PageIndicatorAlign align = ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL;

    private OnItemClickListener onItemClickListener;

    private ViewPager.PageTransformer transformer = new DefaultTransformer();

    private int startTurning = 3000;

    private boolean canLoop = false;

    private int holderType;
    
    private CBViewHolderCreator holderCreator;

    private ViewPager.OnPageChangeListener onPageChangeListener;

    BannerBean(ConvenientBanner<T> banner,
                       ArrayList<T> datas,
                       int[] indicators,
                       ConvenientBanner.PageIndicatorAlign align,
                       OnItemClickListener onItemClickListener,
                       ViewPager.PageTransformer transformer,
                       int startTurning,
                       boolean canLoop,
                       CBViewHolderCreator holderCreator,
                       ViewPager.OnPageChangeListener onPageChangeListener,
                        int holderType) {
        this.banner = banner;
        this.datas = datas;
        this.indicators = indicators;
        this.align = align;
        this.onItemClickListener = onItemClickListener;
        this.transformer = transformer;
        this.startTurning = startTurning;
        this.canLoop = canLoop;
        this.holderCreator = holderCreator;
        this.onPageChangeListener = onPageChangeListener;
        this.holderType = holderType;
    }

    public ConvenientBanner<T> getBanner() {
        return banner;
    }

    public ArrayList<T> getDatas() {
        return datas;
    }

    public int[] getIndicators() {
        return indicators;
    }

    public ConvenientBanner.PageIndicatorAlign getIndicatorAlign() {
        return align;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public ViewPager.PageTransformer getTransformer() {
        return transformer;
    }

    public int getStartTurning() {
        return startTurning;
    }

    public boolean isCanLoop() {
        return canLoop;
    }

    public CBViewHolderCreator getHolderCreator() {
        return holderCreator;
    }

    public ViewPager.OnPageChangeListener getOnPageChangeListener() {
        return onPageChangeListener;
    }

    public int getHolderType() {
        return holderType;
    }

    public static class Builder<T> {
        private ConvenientBanner<T> banner;

        private ArrayList<T> datas;

        private int[] indicators;

        private ConvenientBanner.PageIndicatorAlign align;

        private OnItemClickListener onItemClickListener;

        private ViewPager.PageTransformer transformer;

        private int startTurning;

        private boolean canLoop;

        private CBViewHolderCreator holderCreator;

        private ViewPager.OnPageChangeListener onPageChangeListener;
        
        private int holdType;

        public Builder setBanner(ConvenientBanner<T> banner) {
            this.banner = banner;
            return this;
        }

        public Builder setDatas(ArrayList<T> datas) {
            this.datas = datas;
            return this;
        }

        public Builder setIndicators(int... indicators) {
            this.indicators = indicators;
            return this;
        }

        public Builder setIndicatorAlign(ConvenientBanner.PageIndicatorAlign align) {
            this.align = align;
            return this;
        }

        public Builder setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.onItemClickListener = onItemClickListener;
            return this;
        }

        public Builder setTransformer(ViewPager.PageTransformer transformer) {
            this.transformer = transformer;
            return this;
        }

        public Builder setStartTurning(int startTurning) {
            this.startTurning = startTurning;
            return this;
        }

        public Builder setCanLoop(boolean canLoop) {
            this.canLoop = canLoop;
            return this;
        }

        public Builder setHolderCreator(CBViewHolderCreator holderCreator) {
            this.holderCreator = holderCreator;
            return this;
        }

        public Builder setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
            this.onPageChangeListener = onPageChangeListener;
            return this;
        }

        public Builder setHoldType(int holdType) {
            this.holdType = holdType;
            return this;
        }

        public BannerBean build() {
            return new BannerBean<T>(banner,
                    datas,
                    indicators,
                    align,
                    onItemClickListener,
                    transformer,
                    startTurning,
                    canLoop,
                    holderCreator,
                    onPageChangeListener,
                    holdType);
        }
    }
    
    public static class HoldType {
        public static final Integer RES_INT = 1;
        public static final Integer RES_URL = 2;
    }
}
