package com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Description:适配器封装
 * @Createdtime:2019/1/5 13:15
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public  class CommonViewHolder<T> extends RecyclerView.ViewHolder {

    private SparseArray<View> views;

    public CommonViewHolder(View view) {
        super(view);
        this.views = new SparseArray<>();
    }

    public static CommonViewHolder get(Context context, ViewGroup parent, int layoutId) {

        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        CommonViewHolder holder = new CommonViewHolder(itemView);
        return holder;
    }

    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

}
