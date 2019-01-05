package com.example.zhaoseast.wechatmoments.view.imageframe;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * @Description:缓存到内存中
 * @Createdtime:2019/1/5 17:32
 * @Author:Zhaohd(参考风信子丶)
 * @Version: V.1.0.0
 */

public class MemoryCache implements ImageCache {
    //用来缓存的工具类对象，通过类声明可以看出这个类也是通过key-value来存储对象的
    private LruCache<String, Bitmap> mImageCache;

    public MemoryCache(){
        initImageCache();
    }
    private void initImageCache() {
        //计算当前应用可使用内存
        final int maxMemory = (int)(Runtime.getRuntime().maxMemory() / 1024);

        //分配作为缓存的内存大小，官方推荐为当前应用可使用内存的1/8
        final int cacheSize = maxMemory / 4;

        //初始化缓存类
        mImageCache = new LruCache<String, Bitmap>(cacheSize){

            /*sizeof()方法。这个方法默认返回的是你缓存的item数目，如果你想要自定义size的大小，直接重写这个方法，返回自定义的值即可*/
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024; } };
    }

    //将资源加入内存缓存
    @Override
    public void put(String url, Bitmap bitmap){
        mImageCache.put(url, bitmap);
    }

    //从内存缓存通过url标识来获取资源
    @Override
    public Bitmap get(String url){
        return mImageCache.get(url);
    }
}
