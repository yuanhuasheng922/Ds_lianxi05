package com.example.yuan.ds_lianxi05.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuan.ds_lianxi05.R;
import com.example.yuan.ds_lianxi05.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class LinewrAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;

    private boolean isshow;
    private List<UserBean.DataBean> mDatas;

    public LinewrAdapter(Context mContext, boolean isshow) {
        this.mContext = mContext;
        this.isshow = isshow;
        mDatas=new ArrayList<>();
    }

    //刷新
    public void setmDatas(List<UserBean.DataBean> datas) {
       mDatas.clear();
       mDatas.addAll(datas);
       notifyDataSetChanged();
    }
    //加载
    public void addmDatas(List<UserBean.DataBean> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolder holder=null;
        if (isshow)
        {
           View view = LayoutInflater.from(mContext).inflate(R.layout.linear_item,viewGroup,false);
            holder=new ViewHolder(view);
        }
        else
        {
            View view = LayoutInflater.from(mContext).inflate(R.layout.grid_item,viewGroup,false);
            holder=new ViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final ViewHolder holder= (ViewHolder) viewHolder;
        final UserBean.DataBean dataBean = mDatas.get(i);

        String[] split = dataBean.getImages().split("\\|");
        Glide.with(mContext).load(split[0]).into(holder.imageView);

        holder.title.setText(dataBean.getTitle());
        holder.price.setText(dataBean.getPrice() + "");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int layoutPosition = holder.getLayoutPosition();
                mDatas.remove(layoutPosition);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {

        private final ImageView imageView;
        private final TextView title;
        private final TextView price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.linearImage);
            title = itemView.findViewById(R.id.linearTitle);
            price = itemView.findViewById(R.id.linearPrice);

        }
    }
}
