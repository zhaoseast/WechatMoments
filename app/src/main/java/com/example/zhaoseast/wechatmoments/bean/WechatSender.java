package com.example.zhaoseast.wechatmoments.bean;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * @Description:发送着实体对象
 * @Createdtime:2019/1/3 18:15
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
@Entity
public class WechatSender implements Serializable {
    private static final long serialVersionUID =104;

    @Id
    private String id;//用户ID
    private String username;//用户名
    private String nick;//用户昵称
    private String avatar;//用户背景
    @SerializedName("profile-image")
    private String profile_image;//用户头像
    private String usertype;//用户类型
    @Generated(hash = 1569487276)
    public WechatSender(String id, String username, String nick, String avatar,
            String profile_image, String usertype) {
        this.id = id;
        this.username = username;
        this.nick = nick;
        this.avatar = avatar;
        this.profile_image = profile_image;
        this.usertype = usertype;
    }
    @Generated(hash = 867588106)
    public WechatSender() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNick() {
        return this.nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }
    public String getAvatar() {
        return this.avatar;
    }
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getProfile_image() {
        return this.profile_image;
    }
    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }
    public String getUsertype() {
        return this.usertype;
    }
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}