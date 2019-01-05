package com.example.zhaoseast.wechatmoments.model;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

import com.example.zhaoseast.wechatmoments.bean.WechatComments;
import com.example.zhaoseast.wechatmoments.bean.WechatContent;
import com.example.zhaoseast.wechatmoments.bean.WechatImages;
import com.example.zhaoseast.wechatmoments.bean.WechatSender;
import com.example.zhaoseast.wechatmoments.common.Globals;
import com.example.zhaoseast.wechatmoments.daoHelper.daoHelperImpl.WeChatImagesDaoHelper;
import com.example.zhaoseast.wechatmoments.daoHelper.daoHelperImpl.WeChatSenderDaoHelper;
import com.example.zhaoseast.wechatmoments.daoHelper.daoHelperImpl.WechatCommnetsDaoHelper;
import com.example.zhaoseast.wechatmoments.daoHelper.daoHelperImpl.WechatContentDaoHelper;
import com.example.zhaoseast.wechatmoments.utils.GsonTools;
import com.example.zhaoseast.wechatmoments.vo.Comments;
import com.example.zhaoseast.wechatmoments.vo.Images;
import com.example.zhaoseast.wechatmoments.vo.JsonRootBean;
import com.example.zhaoseast.wechatmoments.vo.Sender;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;
import java.util.UUID;

import okhttp3.Call;

/**
 * @Description:微信时刻数据处理层MODEL
 * @Createdtime:2019/1/4 13:08
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WechatMomentsModel extends BaseModle {
    private final WechatCommnetsDaoHelper wechatCommnetsDaoHelper;
    private  WeChatSenderDaoHelper weChatSenderDaoHelper;
    private  WeChatImagesDaoHelper imagesDaoHelper;
    private  WechatContentDaoHelper wechatContentDaoHelper;

    public WechatMomentsModel(Activity context) {
        super(context);
        weChatSenderDaoHelper = new WeChatSenderDaoHelper();
        imagesDaoHelper = new WeChatImagesDaoHelper();
        wechatContentDaoHelper = new WechatContentDaoHelper();
        wechatCommnetsDaoHelper = new WechatCommnetsDaoHelper();
    }

    /**
     * 获取当前用户信息
     * @param callBack
     */
    public void getUserDatasToWeb(final HttpCallBack callBack){
        OkHttpUtils.get().url(Globals.USER_URLS).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callBack.onError("");
            }

            @Override
            public void onResponse(String response, int id) {
                WechatSender wechatSender = new Gson().fromJson(response, WechatSender.class);
                if (wechatSender!=null ){
                    wechatSender.setId(UUID.randomUUID().toString());
                    wechatSender.setUsertype("A");
                    weChatSenderDaoHelper.insertObj(wechatSender);
                    callBack.onSucess(wechatSender);
                }
            }
        });
    }

    /**
     * 获取用户信息获取推文信息
     * @param callBack
     */
    public void getTeetstoWeb(final int offset, final int number, final HttpCallBack callBack){
        OkHttpUtils.get().url(Globals.SWEETS_URLS).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callBack.onSucess(getLocalSendersByLimit(offset,number));
            }

            @Override
            public void onResponse(String response, int id) {
                if (!TextUtils.isEmpty(response)){
                    List<JsonRootBean> comBaseResultValue =  GsonTools.getObjectList(response, JsonRootBean.class);
                    if (comBaseResultValue!=null && comBaseResultValue.size()>0){
                        for (int i=0;i<comBaseResultValue.size();i++){
                            String user_id = null;
                            String wc_id = null;
                            //获取当前发送主题人员信息并存入数据库
                            Sender sender = comBaseResultValue.get(i).getSender();
                            if (sender!=null){
                                WechatSender wechatSender = new WechatSender();
                                user_id = UUID.randomUUID().toString();
                                wechatSender.setId(user_id);
                                wechatSender.setUsername(sender.getUsername());
                                wechatSender.setNick(sender.getNick());
                                wechatSender.setAvatar(sender.getAvatar());
                                wechatSender.setUsertype("T");
                                weChatSenderDaoHelper.insertObj(wechatSender);
                            }
                            //获取当前主题内容并存入数据库
                            String context= comBaseResultValue.get(i).getContent();
                            if (context!=null){
                                WechatContent wechatContent = new WechatContent();
                                wc_id = UUID.randomUUID().toString();
                                wechatContent.setId(wc_id);
                                wechatContent.setTitle(context);
                                wechatContent.setSenderid(user_id);
                                wechatContentDaoHelper.insertObj(wechatContent);
                            }else if (sender!=null){//防止有人员信息而无主题时无法入库处理
                                WechatContent wechatContent = new WechatContent();
                                wc_id = UUID.randomUUID().toString();
                                wechatContent.setId(wc_id);
                                wechatContent.setTitle("");
                                wechatContent.setSenderid(user_id);
                                wechatContentDaoHelper.insertObj(wechatContent);
                            }
                            //获取当前图片信息并存入数据库
                            List<Images> images = comBaseResultValue.get(i).getImages();
                            if ( images!=null && images.size()>0 ){
                                for (int a=0;a<images.size();a++){
                                    WechatImages wechatImages = new WechatImages();
                                    wechatImages.setId(UUID.randomUUID().toString());
                                    wechatImages.setUrl(images.get(a).getUrl());
                                    wechatImages.setContentid(wc_id);
                                    imagesDaoHelper.insertObj(wechatImages);
                                }
                            }
                            //获取当前评论内容并存入数据库
                            List<Comments> comments = comBaseResultValue.get(i).getComments();
                            if (comments!=null && comments.size()>0){
                                for (int b=0;b<comments.size();b++){
                                    String cmuser_id = null;
                                    Sender sender1 = comments.get(b).getSender();
                                    if (sender1!=null){
                                        WechatSender wechatSender = new WechatSender();
                                        cmuser_id = UUID.randomUUID().toString();
                                        wechatSender.setId(cmuser_id);
                                        wechatSender.setUsername(sender1.getUsername());
                                        wechatSender.setNick(sender1.getNick());
                                        wechatSender.setAvatar(sender1.getAvatar());
                                        wechatSender.setUsertype("H");
                                        weChatSenderDaoHelper.insertObj(wechatSender);

                                    }
                                    String title = comments.get(b).getContent();
                                    if (title!=null){
                                        WechatComments wechatComments = new WechatComments();
                                        wechatComments.setId(UUID.randomUUID().toString());
                                        wechatComments.setContent(title);
                                        wechatComments.setContentid(wc_id);
                                        wechatComments.setUserid(cmuser_id);
                                        wechatCommnetsDaoHelper.insertObj(wechatComments);
                                    }
                                }
                            }
                        }
                    }else {
                        callBack.onSucess(getLocalSendersByLimit(offset,number));
                    }
                    //第一次全部加载完成 获取前5条用户朋友圈
                    callBack.onSucess(getLocalSendersByLimit(offset,number));
                }else {
                    callBack.onSucess(getLocalSendersByLimit(offset,number));
                }
            }
        });
    }

    /**
     * 获取所有用户信息
     * @return
     */
    public List<WechatSender> getLocalSenders(){
        return weChatSenderDaoHelper.queryAll();
    }
    /**
     * 获取所有用户信息
     * @return
     */
    public WechatSender getSenderInfo(String id){
        if (TextUtils.isEmpty(id)) return null;
        return weChatSenderDaoHelper.queryObjById(id);
    }

    /**
     * 获取关联用户信息
     * @return
     */
    public List<WechatSender> getAllSenders(){
        return weChatSenderDaoHelper.getAllSender();
    }
    /**
     * 分页加载获取5条用户信息
     * @return
     */
    public List<WechatSender> getLocalSendersByLimit(int offset,int number){
        return weChatSenderDaoHelper.getSenderList(offset,number);
    }
    /**
     * 通过用户ID获取文章信息
     * @param userid
     * @return
     */
    public WechatContent getLocalContents(String userid){
        return wechatContentDaoHelper.getContentByUserID(userid);
    }

    /**
     * 通过文章ID获取图片信息
     * @param contentid
     * @return
     */
    public List<WechatImages> getLocalImages(String contentid){
        return imagesDaoHelper.getImagesByContentID(contentid);
    }
    /**
     * 通过文章ID获取评论信息
     * @param contentid
     * @return
     */
    public List<WechatComments> getLocalMoments(String contentid){
        return wechatCommnetsDaoHelper.getCommentsByContentID(contentid);
    }

}
