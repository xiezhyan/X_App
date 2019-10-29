package com.sanq.product.x_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.sanq.product.core.account.AccountManager;
import com.sanq.product.core.account.ISignListener;
import com.sanq.product.core.account.IUserChecker;
import com.sanq.product.core.delegates.CoreDelegate;
import com.sanq.product.core.delegates.web.WebDelegateImpl;
import com.sanq.product.core.launcher.ILauncherListener;
import com.sanq.product.core.launcher.OnLauncherFinishTag;
import com.sanq.product.core.ui.recycler.MultipleItemEntity;
import com.sanq.product.core.ui.refresh.RefreshHandler;
import com.sanq.product.core.wechat.WeChat;
import com.sanq.product.x_app.recyclerList.DataConvert;
import com.sanq.product.x_app.recyclerList.ExampleAdapter;

import java.util.ArrayList;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * com.sanq.product.x_app.ExampleDelegate
 *
 * @author sanq.Yan
 * @date 2019/9/15
 */
public class LoginDelegate extends CoreDelegate {

    ILauncherListener mILauncherListener;
    ISignListener mISignListener;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        mILauncherListener = (ILauncherListener) activity;
        mISignListener = (ISignListener) activity;

    }

    @Override
    public Object getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

       

    }
    
    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        
        webview();
    }
    
    private void webview() {
        final WebDelegateImpl delegate = WebDelegateImpl.create("index.html");
        delegate.setTopDelegate(this.getParentDelegate());
        // R.id.web_discovery_container 容器
        getSupportDelegate().loadRootFragment(R.id.web_discovery_container, delegate);
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return new DefaultHorizontalAnimator();
    }
    
    private void loginAndreg() {
        //将信息存入，标记已经登录
        AccountManager.setSignState(true);
        mISignListener.onSignInSuccess();
        mISignListener.onSignUpSuccess();
    }


    private void isLogin() {
        //验证是否登录
        AccountManager.checkAccount(new IUserChecker() {
            @Override
            public void onSignIn() {
                if (mILauncherListener != null) {
                    mILauncherListener.onLauncherFinish(OnLauncherFinishTag.SIGNED);
                }
            }

            @Override
            public void onNotSignIn() {
                if (mILauncherListener != null) {
                    mILauncherListener.onLauncherFinish(OnLauncherFinishTag.NOT_SIGNED);
                }
            }
        });
    }

}
