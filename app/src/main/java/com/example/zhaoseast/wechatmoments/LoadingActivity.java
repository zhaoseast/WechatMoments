package com.example.zhaoseast.wechatmoments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.zhaoseast.wechatmoments.activity.baseActivity.WeChatBaseActivity;

/**
 * @Description:欢迎页载入
 * @Createdtime:2019/1/3 17:46
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public class LoadingActivity extends WeChatBaseActivity {
    //延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 1600;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goHome();
            }
        },SPLASH_DELAY_MILLIS);
    }

    private void goHome() {
        Intent intent = new Intent(LoadingActivity.this, WelcomeActivity.class);
        LoadingActivity.this.startActivity(intent);
        LoadingActivity.this.finish();
    }


}
