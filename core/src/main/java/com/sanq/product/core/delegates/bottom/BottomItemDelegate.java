package com.sanq.product.core.delegates.bottom;


import com.blankj.utilcode.util.ToastUtils;
import com.sanq.product.core.delegates.CoreDelegate;

public abstract class BottomItemDelegate extends CoreDelegate {
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Override
    public boolean onBackPressedSupport() {
        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            ToastUtils.showShort("再按一次退出");
        }
        return true;
    }
}
