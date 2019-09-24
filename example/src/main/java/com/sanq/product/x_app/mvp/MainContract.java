package com.sanq.product.x_app.mvp;

import com.sanq.product.core.mvp.listener.ResultCallbackListener;
import com.sanq.product.core.mvp.model.IBaseModel;
import com.sanq.product.core.mvp.view.IBaseView;

public class MainContract {

    interface MainModel extends IBaseModel {
        void login(String loginName, String loginPwd, ResultCallbackListener callback);
    }

    public interface MainView extends IBaseView<String> {

    }

    public interface MainPreserenter {
        void login(String loginName, String loginPwd);
    }
}
