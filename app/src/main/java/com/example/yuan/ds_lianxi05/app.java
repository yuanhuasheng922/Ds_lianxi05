package com.example.yuan.ds_lianxi05;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

public class app extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //537b7d01db0ef29406a6cda1
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }
}
