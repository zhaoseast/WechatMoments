package com.example.zhaoseast.wechatmoments.daoHelper.daoHelperImpl;

import android.text.TextUtils;

import com.example.zhaoseast.wechatmoments.bean.WechatComments;
import com.example.zhaoseast.wechatmoments.bean.WechatContent;
import com.example.zhaoseast.wechatmoments.daoHelper.BaseDaoHelper;
import com.example.zhaoseast.wechatmoments.greendao.gen.WechatCommentsDao;
import com.example.zhaoseast.wechatmoments.greendao.gen.WechatContentDao;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

/**
 * @Description:评论表
 * @Createdtime:2019/1/4 14:36
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WechatCommnetsDaoHelper extends BaseDaoHelper<WechatComments> {
    private WechatCommentsDao wechatCommentsDao;

    @Override
    public AbstractDao getDao() {
        wechatCommentsDao = daoSession.getWechatCommentsDao();
        return wechatCommentsDao;
    }

    /**
     * 通过主题ID获取评论信息
     * @param contentid
     * @return
     */
    public List<WechatComments> getCommentsByContentID(String contentid){
        if (TextUtils.isEmpty(contentid)) return null;
        return  wechatCommentsDao.queryBuilder().where(WechatCommentsDao.Properties.Contentid.eq(contentid)).list();
    }
}
