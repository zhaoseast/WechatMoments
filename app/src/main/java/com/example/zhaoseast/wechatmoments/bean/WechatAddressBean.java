package com.example.zhaoseast.wechatmoments.bean;

/**
 * @Description:通讯录模拟对象
 * @Createdtime:2019/1/4 21:14
 * @Author:Zhaohd
 * @Version: V.1.0.0
 */

public class WechatAddressBean {

    private String title;

    private String imageid;

    public WechatAddressBean(String title, String imageid) {
        this.title = title;
        this.imageid = imageid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }
}
