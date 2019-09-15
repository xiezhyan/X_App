package com.sanq.product.core.net.callback;

import android.os.Handler;

import com.sanq.product.core.ui.loading.LoadStyle;
import com.sanq.product.core.ui.loading.Loading;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestCallback implements Callback<String> {
    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;
    private final IFailure IFAILURE;
    private final IError IERROR;
    private final LoadStyle LOAD_STYLE;
    private static final Handler HANDLER = new Handler();

    public RequestCallback(IRequest iRequest, ISuccess iSuccess, IFailure iFailure, IError iError, LoadStyle loadStyle) {
        this.IREQUEST = iRequest;
        this.ISUCCESS = iSuccess;
        this.IFAILURE = iFailure;
        this.IERROR = iError;
        this.LOAD_STYLE = loadStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if(response.isSuccessful()) {
            if(call.isExecuted()) {
                if(ISUCCESS != null) {
                    ISUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if(IERROR != null) {
                IERROR.onError(response.code(), response.message());
            }
        }

        stopLoading();
    }

    private void stopLoading() {
        if(LOAD_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Loading.stopLoading();
                }
            }, 1000);
        }
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if(IFAILURE != null) {
            IFAILURE.onFailure();
        }

        if(IREQUEST != null)
            IREQUEST.onRequestEnd();

        stopLoading();
    }
}
