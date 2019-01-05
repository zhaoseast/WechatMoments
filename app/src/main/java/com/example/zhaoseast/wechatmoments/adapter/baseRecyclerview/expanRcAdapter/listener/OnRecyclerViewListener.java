package com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.expanRcAdapter.listener;

import android.view.View;

/**
 * @Description:RC接口
 * @Createdtime:2019/1/5 12:50
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public interface OnRecyclerViewListener {

    /**
     * 单击事件
     */
    interface OnItemClickListener {
        /** position 当前在列表中的position*/
        void onGroupItemClick(int position, int groupPosition, View view);

        void onChildItemClick(int position, int groupPosition, int childPosition, View view);
    }

    /**
     * 双击事件
     */
    interface OnItemLongClickListener {
        void onGroupItemLongClick(int position, int groupPosition, View view);

        void onChildItemLongClick(int position, int groupPosition, int childPosition, View view);
    }


}
