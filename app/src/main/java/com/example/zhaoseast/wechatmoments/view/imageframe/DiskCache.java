package com.example.zhaoseast.wechatmoments.view.imageframe;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.example.zhaoseast.wechatmoments.application.MyApplication;
import com.example.zhaoseast.wechatmoments.common.Globals;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description:磁盘缓存
 * @Createdtime:2019/1/5 17:47
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class DiskCache implements ImageCache {
    //缓存路径
    static String cacheDir = "sdcard/momentsImagecache/";

    @Override
    public Bitmap get(String url){
        Bitmap bitmap = null;
        File file = new File(getCacheDir(), "test.jpg");
        if (file.exists()) {
            bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bmp){
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(getCacheDir());
            fileOutputStream = new FileOutputStream(file+"/"+System.currentTimeMillis()+".png");
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    private String getCacheDir() {

        String state = Environment.getExternalStorageState();//外置sd卡路径
        File dir;
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            // 有sd卡
            dir = new File(Environment.getExternalStorageDirectory(), Globals.IMAGE_URLS);
        } else {
            // 没有sd卡
            dir = new File(MyApplication.getContext().getCacheDir(), "/ImageCache");

        }
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return dir.getAbsolutePath();
    }

}
