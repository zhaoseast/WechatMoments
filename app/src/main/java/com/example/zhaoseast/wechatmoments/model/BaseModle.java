package com.example.zhaoseast.wechatmoments.model;

import android.app.Activity;
import com.example.zhaoseast.wechatmoments.daoHelper.daoHelperImpl.WeChatSenderDaoHelper;


/**
 * @Description:MODEL基类
 * @Createdtime:2019/1/4 13:08
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class BaseModle {
    public static int MAX_PHOTO = 5;
    public Activity context;
    public String LOADING = "正在加载...";
    public String ERRO_LOAD = "加载失败!";
    public String ERRO_COMMITE = "提交失败!";
    public String ERRO_MSG = "提交失败!";

    public BaseModle(Activity context) {
        this.context = context;
    }





}
