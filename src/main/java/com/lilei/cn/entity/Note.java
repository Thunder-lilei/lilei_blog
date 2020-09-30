package com.lilei.cn.entity;

import java.util.Date;

public class Note {
    private Integer noteid;

    private String title;

    private Date time;

    private String author;

    private String content;

    private String introduction;

    private byte[] image;
    
    public void setAll(String title,String content,String introduction,Date time) 
    {
    	this.title = title == null ? null : title.trim();
    	this.content = content == null ? null : content.trim();
    	this.introduction = introduction == null ? null : introduction.trim();
    	this.time = time;
    }

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}