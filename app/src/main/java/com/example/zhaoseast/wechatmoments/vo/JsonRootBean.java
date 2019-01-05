/**
  * Copyright 2019 bejson.com 
  */
package com.example.zhaoseast.wechatmoments.vo;
import java.util.List;

/**
 * Auto-generated: 2019-01-03 18:11:10
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class JsonRootBean {

    private String content;
    private List<Images> images;
    private Sender sender;
    private List<Comments> comments;
    public void setContent(String content) {
         this.content = content;
     }
     public String getContent() {
         return content;
     }

    public void setImages(List<Images> images) {
         this.images = images;
     }
     public List<Images> getImages() {
         return images;
     }

    public void setSender(Sender sender) {
         this.sender = sender;
     }
     public Sender getSender() {
         return sender;
     }

    public void setComments(List<Comments> comments) {
         this.comments = comments;
     }
     public List<Comments> getComments() {
         return comments;
     }

}