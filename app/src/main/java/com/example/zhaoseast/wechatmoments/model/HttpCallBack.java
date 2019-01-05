package com.example.zhaoseast.wechatmoments.model;

/**
 * @Description:网络请求回调
 * @Createdtime:2019/1/4 12:18
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public interface HttpCallBack {
    void onSucess(Object response);
    void onError(Object localData);
}
