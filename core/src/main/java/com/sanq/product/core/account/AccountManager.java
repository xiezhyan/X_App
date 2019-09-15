package com.sanq.product.core.account;

import com.sanq.product.core.utils.storage.Preference;

public class AccountManager {

    private enum SignTag {
        SIGN_TAG    //是否登录
    }

    //保存用户登录状态，登录后调用
    public static void setSignState(boolean state) {
        Preference.setAppFlag(SignTag.SIGN_TAG.name(), state);
    }

    private static boolean isSignIn() {
        return Preference.getAppFlag(SignTag.SIGN_TAG.name());
    }

    public static void checkAccount(IUserChecker checker) {
        if (isSignIn()) {
            checker.onSignIn();
        } else {
            checker.onNotSignIn();
        }
    }
}
