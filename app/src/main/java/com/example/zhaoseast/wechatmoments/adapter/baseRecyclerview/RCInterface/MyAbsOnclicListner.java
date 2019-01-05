package com.example.zhaoseast.wechatmoments.adapter.baseRecyclerview.RCInterface;

import android.view.View;

/**
 * @Createdtime:2019/1/5 12:50
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public abstract class MyAbsOnclicListner<T> implements View.OnClickListener {
    public int position;
    public T data;
    public MyAbsOnclicListner(int position, T data) {
        this.position = position;
        this.data = data;
    }
}
