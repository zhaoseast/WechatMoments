package com.example.zhaoseast.wechatmoments.view.imageframe;

import android.graphics.Bitmap;

/**
 * @Description:获取读方式
 * @Createdtime:2019/1/5 17:48
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class DoubleCache implements ImageCache {
    DiskCache mDiskCache = new DiskCache();
//    MemoryCache mMemoryCache = new MemoryCache();
    @Override
    public void put(String url, Bitmap bitmap) {
//        mMemoryCache.put(url, bitmap);
        mDiskCache.put(url, bitmap);
    }

    //我们可以在从网络加载图片的时候同时缓存在内存和SD卡中，当需要使用图片资源的时候就先从内存查找，没有的话再从SD卡中查找，也没有就从网络加载再缓存到本地（同时缓存到内存和SD卡）
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mDiskCache.get(url);
//        if (bitmap == null){
//            bitmap = mMemoryCache.get(url);
//        }
        return bitmap;
    }
}
