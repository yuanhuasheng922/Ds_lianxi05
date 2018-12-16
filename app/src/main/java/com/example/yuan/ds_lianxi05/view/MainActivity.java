package com.example.yuan.ds_lianxi05.view;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.ImageView;

import com.example.yuan.ds_lianxi05.R;
import com.example.yuan.ds_lianxi05.adapter.LinewrAdapter;
import com.example.yuan.ds_lianxi05.apis.Apis;
import com.example.yuan.ds_lianxi05.bean.UserBean;
import com.example.yuan.ds_lianxi05.presenter.IPresenterImple;
import com.example.yuan.ds_lianxi05.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView,View.OnClickListener {

    private XRecyclerView recyclerView;
    private ImageView imageViewChange;
    private IPresenterImple presenterImple;
    private boolean isShow=true;
    private int mPage=1;
    private LinewrAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        panduan();
        showView();
    }

    private void initView() {
        imageViewChange = findViewById(R.id.ImageChange);
        recyclerView = findViewById(R.id.xrecyclerview);
        imageViewChange.setOnClickListener(this);

        presenterImple = new IPresenterImple(this);

        recyclerView.setPullRefreshEnabled(true);
        recyclerView.setLoadingMoreEnabled(true);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mPage=1;
                showView();
            }

            @Override
            public void onLoadMore() {
                showView();
            }
        });
        showView();
    }

    private void panduan() {
        if (isShow)
        {
            LinearLayoutManager layoutManager=new LinearLayoutManager(this);
            layoutManager.setOrientation(OrientationHelper.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);

        }
        else
        {
            GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
            gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            recyclerView.setLayoutManager(gridLayoutManager);

        }
        adapter=new LinewrAdapter(this,isShow);
        recyclerView.setAdapter(adapter);
        isShow=!isShow;
        mPage=1;
        showView();
    }

    private void showView() {
        Map<String , String> params= new HashMap<>();
        params.put("keywords","手机");
        params.put("page",mPage + "");
        presenterImple.getRequest(Apis.TYOE_TEXT,UserBean.class,params);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ImageChange:
                initView();
                panduan();
                showView();
                break;
        }
    }

    @Override
    public void getRequest(Object data) {
        if (data instanceof  UserBean)
        {
            UserBean userBean= (UserBean) data;
            if (mPage==1)
            {
                adapter.setmDatas(userBean.getData());
            }
            else
            {
                adapter.addmDatas(userBean.getData());
            }
            mPage++;
            recyclerView.refreshComplete();
            recyclerView.loadMoreComplete();
        }
    }
}
