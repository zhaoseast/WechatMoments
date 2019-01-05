package com.example.zhaoseast.wechatmoments.view.imageframe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:图片加载实现
 * @Createdtime:2019/1/5 17:41
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class ImageLoader {
    //内存缓存
    ImageCache mImageCache = new DoubleCache();

    //线程池，线程的数量为CPU数，可以同时处理多个缓存线程
    //Runtime.getRuntime().availableProcessors() 得到的就是CPU数
    ExecutorService mExecutorService = Executors.newFixedThreadPool( Runtime.getRuntime().availableProcessors());

    public void displayImage(final String url, final ImageView imageView){
        Bitmap bitmap = mImageCache.get(url) ;
        if (bitmap != null){
            imageView.setImageBitmap(bitmap); return;
        }
        //图片还未缓存，开启线程从网上下载
        submitLoadRequest(url, imageView);
    }

    private void submitLoadRequest(final String imageUrl, final ImageView imageView){
        //需要开启新线程，用url唯一标识
        imageView.setTag(imageUrl);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(imageUrl);
                if (bitmap == null){
                    return;
                }
                if (imageView.getTag().equals(imageUrl)){
                    imageView.setImageBitmap(bitmap);
                }
                mImageCache.put(imageUrl, bitmap);
            }});
    }

    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 连接网络
            conn.connect();
            // 获取响应码
            int code = conn.getResponseCode();
            if (200==code){
                bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            }
            conn.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }

        return bitmap;
    }

}
