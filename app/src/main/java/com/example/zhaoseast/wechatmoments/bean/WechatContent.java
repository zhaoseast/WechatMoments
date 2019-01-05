package com.example.zhaoseast.wechatmoments.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * @Description:用户主题表
 * @Createdtime:2019/1/4 11:13
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

@Entity
public class WechatContent implements Serializable{
    private static final long serialVersionUID =102;

    @Id
    private String id;

    private String senderid;

    private String title;

    private String likenumber;

    private String commentsnumber;

    private String creationdate;

    private String creationaddress;

    @Generated(hash = 568817811)
    public WechatContent(String id, String senderid, String title,
            String likenumber, String commentsnumber, String creationdate,
            String creationaddress) {
        this.id = id;
        this.senderid = senderid;
        this.title = title;
        this.likenumber = likenumber;
        this.commentsnumber = commentsnumber;
        this.creationdate = creationdate;
        this.creationaddress = creationaddress;
    }

    @Generated(hash = 1129668687)
    public WechatContent() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderid() {
        return this.senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLikenumber() {
        return this.likenumber;
    }

    public void setLikenumber(String likenumber) {
        this.likenumber = likenumber;
    }

    public String getCommentsnumber() {
        return this.commentsnumber;
    }

    public void setCommentsnumber(String commentsnumber) {
        this.commentsnumber = commentsnumber;
    }

    public String getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public String getCreationaddress() {
        return this.creationaddress;
    }

    public void setCreationaddress(String creationaddress) {
        this.creationaddress = creationaddress;
    }
}
