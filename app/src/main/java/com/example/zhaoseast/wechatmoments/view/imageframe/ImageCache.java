package com.example.zhaoseast.wechatmoments.view.imageframe;

import android.graphics.Bitmap;

/**
 * @Description:Android自定义简单的图片加载器（ImageLoader）
 * @Createdtime:2019/1/5 17:30
 * @Author:Zhaohd(参考风信子丶)
 * @Version: V.1.0.0
 */

public interface ImageCache {
    //用url来唯一标识bitmap
     void put(String url, Bitmap bitmap);
     Bitmap get(String url);
}
