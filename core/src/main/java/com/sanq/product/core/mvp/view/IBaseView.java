package com.sanq.product.core.mvp.view;

public interface IBaseView<T> {
    /**
     * 显示加载框
     */
    void showLoading();

    /**
     * 隐藏加载框
     */
    void dismissLoading();

    /**
     * 返回请求到的数据
     * @param result
     */
    void onSuccess(T result);

    /**
     * 请求出现异常
     */
    void onFailure();

}
