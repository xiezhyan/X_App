package com.sanq.product.core.net;

import android.content.Context;

import com.sanq.product.core.net.callback.IError;
import com.sanq.product.core.net.callback.IFailure;
import com.sanq.product.core.net.callback.IRequest;
import com.sanq.product.core.net.callback.ISuccess;
import com.sanq.product.core.ui.loading.LoadStyle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RestClientBuilder {
    private String mUrl = null;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private RequestBody mBody = null;

    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;

    private Context mContext = null;
    private LoadStyle mLoadStyle = null;

    private File mFile = null;

    private List<File> files = null;

    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

    RestClientBuilder() {
    }

    public final RestClientBuilder loader(Context context, LoadStyle style) {
        this.mContext = context;
        this.mLoadStyle = style;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoadStyle = LoadStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }


    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }


    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder file(List<File> files) {
        this.files = files;
        return this;
    }

    public final RestClientBuilder files(List<String> files) {
        final List<File> f = new ArrayList<>(files.size());
        for(String path : files)
            f.add(new File(path));

        this.files = f;
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }


    public final RestClientBuilder params(String key, String value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder request(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }


    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }


    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }


    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }


    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl,
                PARAMS,
                mIRequest,
                mISuccess,
                mIFailure,
                mIError,
                mBody,
                mLoadStyle,
                mContext,
                mFile,
                mDownloadDir,
                mExtension,
                mName,
                files);
    }
}
