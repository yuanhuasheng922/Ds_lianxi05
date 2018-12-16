package com.example.yuan.ds_lianxi05.presenter;

import com.example.yuan.ds_lianxi05.callback.Callback;
import com.example.yuan.ds_lianxi05.imodel.IModelImple;
import com.example.yuan.ds_lianxi05.view.IView;

import java.util.Map;

public class IPresenterImple implements IPresenter {
    private IView mIView;
    private IModelImple mIModelImple;

    public IPresenterImple(IView mIView) {
        this.mIView = mIView;
        mIModelImple=new IModelImple();
    }

    @Override
    public void getRequest(String url, Class clazz, Map<String, String> params) {
        mIModelImple.getRequest(url, clazz, params, new Callback() {
            @Override
            public void getRequest(Object data) {
                mIView.getRequest(data);
            }
        });
    }
}
