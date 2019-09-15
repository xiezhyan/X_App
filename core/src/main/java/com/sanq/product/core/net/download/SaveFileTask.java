package com.sanq.product.core.net.download;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.sanq.product.core.app.Core;
import com.sanq.product.core.net.callback.IRequest;
import com.sanq.product.core.net.callback.ISuccess;
import com.sanq.product.core.utils.file.FileUtil;

import java.io.File;
import java.io.InputStream;

import okhttp3.ResponseBody;

public class SaveFileTask extends AsyncTask<Object, Void, File> {
    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;

    public SaveFileTask(IRequest IREQUEST, ISuccess ISUCCESS) {
        this.IREQUEST = IREQUEST;
        this.ISUCCESS = ISUCCESS;
    }

    @Override
    protected File doInBackground(Object... params) {
        String downloadDir = (String) params[0];
        String extension = (String) params[1];
        final ResponseBody body = (ResponseBody) params[2];
        final String name = (String) params[3];

        final InputStream is = body.byteStream();
        if (downloadDir == null || downloadDir.equals("")) {
            downloadDir = "down_loads";
        }
        if (extension == null || extension.equals("")) {
            extension = "";
        }
        if (name == null) {
            return FileUtil.writeToDisk(is, downloadDir, extension.toUpperCase(), extension);
        } else {
            return FileUtil.writeToDisk(is, downloadDir, name);
        }
    }

    @Override
    protected void onPostExecute(File file) {
        super.onPostExecute(file);
        if (ISUCCESS != null) {
            ISUCCESS.onSuccess(file.getPath());
        }
        if (IREQUEST != null) {
            IREQUEST.onRequestEnd();
        }
        autoInstallApk(file);
    }

    private void autoInstallApk(File file) {
        if (FileUtil.getExtension(file.getPath()).equals("apk")) {
            final Intent install = new Intent();
            install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            install.setAction(Intent.ACTION_VIEW);
            install.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            Core.getApplication().startActivity(install);
        }
    }
}
