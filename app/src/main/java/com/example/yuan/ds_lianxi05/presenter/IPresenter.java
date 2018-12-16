package com.example.yuan.ds_lianxi05.presenter;

import com.example.yuan.ds_lianxi05.callback.Callback;

import java.util.Map;

public interface IPresenter {
    void getRequest(String url, Class clazz, Map<String,String> params);
}
