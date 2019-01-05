package com.example.zhaoseast.wechatmoments.daoHelper.daoHelperImpl;

import android.text.TextUtils;

import com.example.zhaoseast.wechatmoments.bean.WechatContent;
import com.example.zhaoseast.wechatmoments.bean.WechatImages;
import com.example.zhaoseast.wechatmoments.daoHelper.BaseDaoHelper;
import com.example.zhaoseast.wechatmoments.greendao.gen.WechatContentDao;
import com.example.zhaoseast.wechatmoments.greendao.gen.WechatImagesDao;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

/**
 * @Description:图片信息处理DAO
 * @Createdtime:2019/1/4 14:30
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WeChatImagesDaoHelper extends BaseDaoHelper<WechatImages> {
    private WechatImagesDao wechatImagesDao;

    @Override
    public AbstractDao getDao() {
        wechatImagesDao = daoSession.getWechatImagesDao();
        return wechatImagesDao;
    }
    /**
     * 通过主题ID获取主题图片信息
     * @param contentid
     * @return
     */
    public List<WechatImages> getImagesByContentID(String contentid){
        if (TextUtils.isEmpty(contentid)) return null;
        return  wechatImagesDao.queryBuilder().where(WechatImagesDao.Properties.Contentid.eq(contentid)).list();
    }
}
