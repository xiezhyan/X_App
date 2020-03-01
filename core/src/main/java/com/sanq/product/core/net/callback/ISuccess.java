package com.sanq.product.core.net.callback;

import org.json.JSONObject;

public interface ISuccess {
    void onSuccess(String response);

    void onSuccess(JSONObject response);
}
