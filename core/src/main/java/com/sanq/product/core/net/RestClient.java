package com.sanq.product.core.net;


import android.content.Context;

import com.sanq.product.core.net.callback.IError;
import com.sanq.product.core.net.callback.IFailure;
import com.sanq.product.core.net.callback.IRequest;
import com.sanq.product.core.net.callback.ISuccess;
import com.sanq.product.core.net.callback.RequestCallback;
import com.sanq.product.core.net.download.DownloadHandler;
import com.sanq.product.core.ui.loading.LoadStyle;
import com.sanq.product.core.ui.loading.Loading;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class RestClient {

    private final String URL;
    //参数
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private final RequestBody BODY;

    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;
    private final IFailure IFAILURE;
    private final IError IERROR;
    //加载框
    private final LoadStyle LOAD_STYLE;
    private final Context CONTEXT;
    //上传
    private final File FILE;

    private final List<File> FILES;

    //下载
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;

    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest iRequest,
                      ISuccess iSuccess,
                      IFailure iFailure,
                      IError iError,
                      RequestBody body,
                      LoadStyle loadStyle,
                      Context context,
                      File file,
                      String downloadDir,
                      String extension,
                      String name,
                      List<File> files) {
        this.URL = url;
        PARAMS.putAll(params);
        this.IREQUEST = iRequest;
        this.ISUCCESS = iSuccess;
        this.IFAILURE = iFailure;
        this.IERROR = iError;
        this.BODY = body;
        this.LOAD_STYLE = loadStyle;
        this.CONTEXT = context;
        this.FILE = file;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.FILES = files;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService restService = RestCreator.getRestService();

        Call<String> call = null;

        if (IREQUEST != null) {
            IREQUEST.onRequestStart();
        }

        if (LOAD_STYLE != null) {
            Loading.showLoading(CONTEXT, LOAD_STYLE);
        }

        switch (method) {
            case GET:
                call = restService.get(URL, PARAMS);
                break;
            case POST:
                call = restService.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = restService.postRaw(URL, BODY);
                break;
            case PUT:
                call = restService.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = restService.putRaw(URL, BODY);
                break;
            case DELETE:
                call = restService.delete(URL, PARAMS);
                break;
            case UPLOAD:
                if(FILE != null) {
                    final RequestBody requestBody =
                            RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                    final MultipartBody.Part body =
                            MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                    call = restService.upload(URL, body, PARAMS);
                } else {
                    //多文件
                    Map<String, RequestBody> parts = new HashMap<>(FILES.size());
                    RequestBody requestBody;
                    for (int i = 0; i < FILES.size(); i++) {
                        File f = FILES.get(i);
                        requestBody = RequestBody.create(MediaType.parse(new MimetypesFileTypeMap().getContentType(f)), FILES.get(i));
                        parts.put("file\"; filename=\"" + FILES.get(i).getName(), requestBody);
                    }
                    call = restService.upload(URL, parts, PARAMS);
                }
                break;
            default:
                break;
        }

        if (call != null)
            call.enqueue(getResultCallback());
    }

    private Callback<String> getResultCallback() {
        return new RequestCallback(IREQUEST, ISUCCESS, IFAILURE, IERROR, LOAD_STYLE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        if (BODY == null) request(HttpMethod.POST);
        else {
            PARAMS.clear();
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null");
            }
            request(HttpMethod.POST_RAW);
        }
    }

    public final void put() {
        if (BODY == null) request(HttpMethod.PUT);
        else {
            PARAMS.clear();
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null");
            }
            request(HttpMethod.PUT_RAW);
        }
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }

    public final void upload() {
        request(HttpMethod.UPLOAD);
    }

    public final void download() {
        new DownloadHandler(URL, IREQUEST, DOWNLOAD_DIR, EXTENSION, NAME, ISUCCESS, IFAILURE, IERROR)
                .handleDownload();
    }
}
