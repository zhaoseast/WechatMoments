package com.example.zhaoseast.wechatmoments.bean;

/**
 * @Description:首页模拟对象
 * @Createdtime:2019/1/4 20:23
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WechatMainBean {

    private String titlename;

    private String imageid;

    private String context;

    private String time;

    public WechatMainBean(String titlename, String imageid, String context, String time) {
        this.titlename = titlename;
        this.imageid = imageid;
        this.context = context;
        this.time = time;
    }

    @Override
    public String toString() {
        return "WechatMainBean{" +
                "titlename='" + titlename + '\'' +
                ", imageid='" + imageid + '\'' +
                ", context='" + context + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitlename() {
        return titlename;
    }

    public void setTitlename(String titlename) {
        this.titlename = titlename;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
