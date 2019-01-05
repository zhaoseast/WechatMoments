package com.example.zhaoseast.wechatmoments.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * @Description:时刻评论实体对象
 * @Createdtime:2019/1/3 18:13
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
@Entity
public class WechatComments implements Serializable {
    private static final long serialVersionUID =10l;
    @Id
    private String id;
    private String userid;
    private String contentid;
    private String content;//评论内容
    private String commentdate;
    @Generated(hash = 1478016916)
    public WechatComments(String id, String userid, String contentid,
            String content, String commentdate) {
        this.id = id;
        this.userid = userid;
        this.contentid = contentid;
        this.content = content;
        this.commentdate = commentdate;
    }
    @Generated(hash = 1148605497)
    public WechatComments() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserid() {
        return this.userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getContentid() {
        return this.contentid;
    }
    public void setContentid(String contentid) {
        this.contentid = contentid;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getCommentdate() {
        return this.commentdate;
    }
    public void setCommentdate(String commentdate) {
        this.commentdate = commentdate;
    }
}