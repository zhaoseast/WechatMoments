package com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.RCInterface;

import android.view.View;

/**
 * @Createdtime:2019/1/5 12:50
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public interface OnRecyclerViewItemClickListener<K> {
    void onItemClick(View v, K k, int position);
}
