package com.sanq.product.core.ui.camera;

import android.net.Uri;

import com.sanq.product.core.delegates.PermissionCheckerDelegate;
import com.sanq.product.core.utils.file.FileUtil;

/**
 * 照相机调用类
 */

public class Camera {

    public static Uri createCropFile() {
        return Uri.parse
                (FileUtil.createFile("crop_image",
                        FileUtil.getFileNameByTime("IMG", "jpg")).getPath());
    }

    public static void start(PermissionCheckerDelegate delegate) {
        new CameraHandler(delegate).beginCameraDialog();
    }
}
