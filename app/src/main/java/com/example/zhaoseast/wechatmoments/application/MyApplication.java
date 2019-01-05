package com.example.zhaoseast.wechatmoments.application;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.zhaoseast.wechatmoments.R;
import com.example.zhaoseast.wechatmoments.greendao.gen.DaoMaster;
import com.example.zhaoseast.wechatmoments.greendao.gen.DaoSession;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreater;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreater;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * @Description:全局初始化
 * @Createdtime:2019/1/4 13:12
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class MyApplication extends Application {
    public static final String TAG = "BaseApplication";
    private boolean isDebug = true;
    private static Context context;
    public static Context getContext(){
        return context;
    }
    public static String loginName;

    /**
     * greenDao相关
     */
    private static SQLiteDatabase database;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private DaoMaster.DevOpenHelper openHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //初始化grenndao
        initGreenDao();
        //初始化SmartRefreshLayout
        initRefresh();
    }


    public static DaoSession getDaoSession() {
        return daoSession;
    }
    public static SQLiteDatabase getDb() {
        return database;
    }

    private void initGreenDao() {
        openHelper = new DaoMaster.DevOpenHelper(getContext(),"DB_WECHATMOMENT",null);   //数据库名
        database = openHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(database);
        daoSession = daoMaster.newSession();
    }

    private void initRefresh() {
        //static 代码段可以防止内存泄露
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreater(new DefaultRefreshHeaderCreater() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.gray, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreater(new DefaultRefreshFooterCreater() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }
}
