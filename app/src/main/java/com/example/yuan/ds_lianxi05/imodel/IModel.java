package com.example.yuan.ds_lianxi05.imodel;

import com.example.yuan.ds_lianxi05.callback.Callback;

import java.util.Map;

public interface IModel {
    void getRequest(String url, Class clazz, Map<String,String> params, Callback callback);
}
