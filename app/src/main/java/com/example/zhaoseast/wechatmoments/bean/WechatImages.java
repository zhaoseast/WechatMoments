package com.example.zhaoseast.wechatmoments.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * @Description:图片集合实体对象
 * @Createdtime:2019/1/3 18:17
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */
@Entity
public class WechatImages implements Serializable {
    private static final long serialVersionUID =103;
    @Id
    private String id;//图片ID
    private String contentid;//用户ID
    private String url;//图片路径
    private String filetype;
    private String orderby;
    private String creationdate;
    @Generated(hash = 1992615844)
    public WechatImages(String id, String contentid, String url, String filetype,
            String orderby, String creationdate) {
        this.id = id;
        this.contentid = contentid;
        this.url = url;
        this.filetype = filetype;
        this.orderby = orderby;
        this.creationdate = creationdate;
    }
    @Generated(hash = 550894546)
    public WechatImages() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getContentid() {
        return this.contentid;
    }
    public void setContentid(String contentid) {
        this.contentid = contentid;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getFiletype() {
        return this.filetype;
    }
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
    public String getOrderby() {
        return this.orderby;
    }
    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }
    public String getCreationdate() {
        return this.creationdate;
    }
    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }
}