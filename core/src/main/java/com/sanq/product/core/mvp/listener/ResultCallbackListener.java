package com.sanq.product.core.mvp.listener;

import com.sanq.product.core.net.callback.IError;
import com.sanq.product.core.net.callback.IFailure;
import com.sanq.product.core.net.callback.ISuccess;

public class ResultCallbackListener {

    private final ISuccess SUCCESS;

    private final IError ERROR;

    private final IFailure FAILURE;

    public ResultCallbackListener(ISuccess SUCCESS, IError ERROR, IFailure FAILURE) {
        this.SUCCESS = SUCCESS;
        this.ERROR = ERROR;
        this.FAILURE = FAILURE;
    }

    public static class Builder {
        private ISuccess SUCCESS;

        private IError ERROR;

        private IFailure FAILURE;

        public Builder setSuccess(ISuccess SUCCESS) {
            this.SUCCESS = SUCCESS;
            return this;
        }

        public Builder setError(IError ERROR) {
            this.ERROR = ERROR;
            return this;
        }

        public Builder setFailure(IFailure FAILURE) {
            this.FAILURE = FAILURE;
            return this;
        }

        public ResultCallbackListener build() {
            return new ResultCallbackListener(SUCCESS, ERROR, FAILURE);
        }
    }

    public ISuccess getSuccess() {
        return SUCCESS;
    }

    public IError getError() {
        return ERROR;
    }

    public IFailure getFailure() {
        return FAILURE;
    }
}
