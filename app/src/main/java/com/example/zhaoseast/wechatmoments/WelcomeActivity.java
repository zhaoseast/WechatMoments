package com.example.zhaoseast.wechatmoments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * @Description:欢迎界面
 * @Createdtime:2019/1/3 17:46
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
public class WelcomeActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(AppIntroFragment.newInstance("Welcome to the WeChat moments of the world", "版权著作：WeChatMoments小赵@20190103", R.drawable.wechat_logo, getResources().getColor(R.color.color_after)));
        addSlide(AppIntroFragment.newInstance("Let's share the good times", "版权著作：WeChatMoments小赵@20190103", R.drawable.moments_logo, getResources().getColor(R.color.color_after)));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#1296db"));
        setSeparatorColor(Color.parseColor("#1296db"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);
        setSkipText("跳过");
        setDoneText("进入微信时刻");
        setImageNextButton(getResources().getDrawable(R.drawable.right_logo));
        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(false);
        setVibrateIntensity(30);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(this,MainActivity.class));
        this.finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        startActivity(new Intent(this,MainActivity.class));
        this.finish();
    }
}
