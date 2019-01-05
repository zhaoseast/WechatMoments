package com.example.zhaoseast.wechatmoments.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @Description:Toast封装类
 * @Createdtime:2019/1/4 12:04
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class ToastUtil {

    private static Toast toast;

    //显示toast提示
    public  static  void  showShortToast(Context context, String msg){
        if(toast==null){
            toast = Toast.makeText(context,msg, Toast.LENGTH_SHORT);
        }else{
            toast.setText(msg);   //防止toast排队
        }
          toast.show();
      }

    public  static  void  showLongToast(Context context, String msg){
        if(toast==null){
            toast = Toast.makeText(context,msg, Toast.LENGTH_LONG);
        }else{
            toast.setText(msg);   //防止toast排队
        }
          toast.show();
      }

    public static void cancle(){
        toast.cancel();
    }

    public static void destroy(){
        toast = null;
    }
}
