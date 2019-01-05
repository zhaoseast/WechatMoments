package com.example.zhaoseast.wechatmoments.daoHelper.daoHelperImpl;

import android.text.TextUtils;

import com.example.zhaoseast.wechatmoments.bean.WechatContent;
import com.example.zhaoseast.wechatmoments.daoHelper.BaseDaoHelper;
import com.example.zhaoseast.wechatmoments.greendao.gen.WechatContentDao;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

/**
 * @Description:主题实体DAO
 * @Createdtime:2019/1/4 14:33
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WechatContentDaoHelper extends BaseDaoHelper<WechatContent> {
    private WechatContentDao wechatContentDao;

    @Override
    public AbstractDao getDao() {
        wechatContentDao = daoSession.getWechatContentDao();
        return wechatContentDao;
    }
    /**
     * 通过人员ID获取主题信息
     * @param senderid
     * @return
     */
    public WechatContent getContentByUserID(String senderid){
        if (TextUtils.isEmpty(senderid)) return null;
        return  wechatContentDao.queryBuilder().where(WechatContentDao.Properties.Senderid.eq(senderid)).unique();
    }

}
