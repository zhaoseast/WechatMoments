package com.example.zhaoseast.wechatmoments.activity.baseActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * @Description:Activity基本类
 * @Createdtime:2019/1/3 16:19
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WeChatBaseActivity extends AppCompatActivity {

    private SystemBarTintManager tintManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        tintManager = new SystemBarTintManager(this);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        // enable navigation bar tint
        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setStatusBarTintColor(Color.parseColor("#E4351C"));//#FF4285F4  #00695C
        tintManager.setNavigationBarTintColor(Color.BLACK);
    }

}
