package com.example.zhaoseast.wechatmoments.daoHelper;

import android.content.Context;


import com.example.zhaoseast.wechatmoments.application.MyApplication;
import com.example.zhaoseast.wechatmoments.greendao.gen.DaoSession;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

/**
 * @Description:grenndao 的基类 封装了dao的基本增删改查
 * @Createdtime:2019/1/4 11:50
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public abstract class BaseDaoHelper<T> {
    private AbstractDao daoHelper;
    public DaoSession daoSession;
    private Context context;
    public BaseDaoHelper() {
        context = MyApplication.getContext();
        daoSession = MyApplication.getDaoSession();
        daoHelper = getDao();
    }
    public abstract AbstractDao getDao();

    public T queryObjById(Object id){
        return (T) daoHelper.load(id);
    }

    public List<T> queryAll(){
      return  daoHelper.loadAll();
    }

    public void insertObj(T t){
        daoHelper.insertOrReplace(t);
    }

    public void insertList(List<T> ts){
        daoHelper.insertOrReplaceInTx(ts);
    }

    public void  deleteObj(T t){
        daoHelper.delete(t);
    }

    public void deleteList(List<T> ts){
        daoHelper.deleteInTx(ts);
    }

    public void deleteById(Object id){
        daoHelper.deleteByKey(id);
    }

    public void deleteAll(){
        daoHelper.deleteAll();
    }
}
