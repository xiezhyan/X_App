package com.sanq.product.core.account;

public interface IUserChecker {

    //已经登录
    void onSignIn();
    //未登录
    void onNotSignIn();
}
