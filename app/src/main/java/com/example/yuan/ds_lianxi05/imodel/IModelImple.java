package com.example.yuan.ds_lianxi05.imodel;

import com.example.yuan.ds_lianxi05.callback.Callback;
import com.example.yuan.ds_lianxi05.callback.ICallback;
import com.example.yuan.ds_lianxi05.okhttps.OkHttp;

import java.util.Map;

public class IModelImple implements IModel {
    @Override
    public void getRequest(String url, Class clazz, Map<String, String> params, final Callback callback) {
        OkHttp.getInstance().postEnqueue(url, clazz, params, new ICallback() {
            @Override
            public void onsucess(Object obj) {
                callback.getRequest(obj);
            }

            @Override
            public void onfail(Exception e) {
                callback.getRequest(e);
            }
        });
    }
}
