package com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.RCInterface.OnRecyclerViewItemClickListener;
import com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.RCInterface.OnRecyclerViewItemLongClickListener;

import java.util.List;


/**
 * @Description:适配器封装
 * @Createdtime:2019/1/5 13:12
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<CommonViewHolder>
        implements View.OnClickListener,View.OnLongClickListener{
    protected String tag;
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected OnRecyclerViewItemClickListener onItemClickListner;//单击事件
    protected OnRecyclerViewItemLongClickListener onItemLongClickListner = null;//长按单击事件

    public CommonAdapter(Context mContext, List<T> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onClick(View view) {
        if(onItemClickListner!=null ){
            onItemClickListner.onItemClick(view,view.getTag(R.id.tag_first),(Integer) view.getTag());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if(onItemLongClickListner!=null){
            onItemLongClickListner.onItemLongClick(view, (Integer) view.getTag());
        }
        return true;  //执行完毕后不再执行单击事件
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       CommonViewHolder holder = CommonViewHolder.get(mContext,parent,getLayoutId(viewType));
        return holder;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, final int position) {
        holder.itemView.setTag(position);
        holder.itemView.setTag(R.id.tag_first,mDatas.get(position));
        holder.itemView.setOnClickListener(this);
        holder.itemView.setOnLongClickListener(this);
        bindData(holder, mDatas.get(position), position);
    }

    @Override
    public int getItemCount() {
            return mDatas==null ? 0 : mDatas.size();
    }


    public abstract void bindData(CommonViewHolder holder, T data, int position);
    public abstract int getLayoutId(int viewType);

    public void setOnItemClickListner(OnRecyclerViewItemClickListener onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public void setOnItemLongClickListner(OnRecyclerViewItemLongClickListener onItemLongClickListner) {
        this.onItemLongClickListner = onItemLongClickListner;
    }

    public void addData(int position,T t){
        mDatas.add(position,t);
        notifyItemInserted(position);
        notifyItemRangeChanged(position,mDatas.size());
    }
    public void removeData(int position){
        mDatas.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mDatas.size());
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
