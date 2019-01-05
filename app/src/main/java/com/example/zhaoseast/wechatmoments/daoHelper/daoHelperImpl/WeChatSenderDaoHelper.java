package com.example.zhaoseast.wechatmoments.daoHelper.daoHelperImpl;

import android.text.TextUtils;

import com.example.zhaoseast.wechatmoments.bean.WechatContent;
import com.example.zhaoseast.wechatmoments.bean.WechatImages;
import com.example.zhaoseast.wechatmoments.bean.WechatSender;
import com.example.zhaoseast.wechatmoments.daoHelper.BaseDaoHelper;
import com.example.zhaoseast.wechatmoments.greendao.gen.WechatImagesDao;
import com.example.zhaoseast.wechatmoments.greendao.gen.WechatSenderDao;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

/**
 * @Description:WechatDao逻辑实现类
 * @Createdtime:2019/1/4 11:47
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WeChatSenderDaoHelper extends BaseDaoHelper<WechatSender> {

    private WechatSenderDao wechatSenderDao;

    @Override
    public AbstractDao getDao() {
        wechatSenderDao = daoSession.getWechatSenderDao();
        return wechatSenderDao;
    }

    /**
     * 通过用户ID获取当前用户信息
     * @param userid
     * @return
     */
    public List<WechatSender> getSenderByuserID(String userid){
        if (TextUtils.isEmpty(userid)) return null;
        return  wechatSenderDao.queryBuilder().where(WechatSenderDao.Properties.Id.eq(userid)).list();
    }
    /**
     * 获取当前登录人的关联用户信息
     * @return
     */
    public List<WechatSender> getAllSender(){
        return  wechatSenderDao.queryBuilder().where(WechatSenderDao.Properties.Usertype.notEq("A")).list();
    }

    /**
     * 分页加载用户信息
     * @param offset
     * @param number
     * @return
     */
    public List<WechatSender> getSenderList(int offset, int number) {
        List<WechatSender> wechatSenderList  = wechatSenderDao.queryBuilder().where(WechatSenderDao.Properties.Usertype.eq("T"))
                .offset((offset-1)*number).limit(number).list();
        return wechatSenderList;
    }
}
