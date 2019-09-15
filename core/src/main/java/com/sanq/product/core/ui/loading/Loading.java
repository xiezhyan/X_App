package com.sanq.product.core.ui.loading;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.sanq.product.core.R;
import com.sanq.product.core.utils.dimen.DimenUtil;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 *
 */

public class Loading {
    private static final int LOAD_SIZE_SCALE = 8;
    private static final int LOAD_OFFSET_SCALE = 10;
    private static final ArrayList<AppCompatDialog> LOADS = new ArrayList<>();
    private static final String DEFAULT_LOADING = LoadStyle.BallClipRotatePulseIndicator.name();

    public static void showLoading(Context context, Enum<LoadStyle> loadStyleEnum) {
        showLoading(context, loadStyleEnum.name());
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADING);
    }

    /**
     * 显示Loading
     * @param context
     * @param type
     */
    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        AVLoadingIndicatorView avLoadingIndicatorView = LoadCreator.create(type, context);

        dialog.setContentView(avLoadingIndicatorView);

        int deviceWidth = DimenUtil.getScreenWidth();
        int deviceHeight = DimenUtil.getScreenHeight();

        final Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOAD_SIZE_SCALE;
            lp.height = deviceHeight / LOAD_SIZE_SCALE;
            lp.height = lp.height + deviceHeight / LOAD_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADS.add(dialog);
        dialog.show();
    }

    /**
     * 停止Loading
     */
    public static void stopLoading() {
        for (AppCompatDialog dialog: LOADS) {
            if(dialog != null && dialog.isShowing()) {
                dialog.cancel();
            }
        }
    }
}
