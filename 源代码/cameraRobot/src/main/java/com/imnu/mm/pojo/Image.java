package com.imnu.mm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Image {
    private Integer imgid;

    private String imgname;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date imgdatetime;

    private Integer userid;

    private String username;

    private String imgaddress;

    public Integer getImgid() {
        return imgid;
    }

    public void setImgid(Integer imgid) {
        this.imgid = imgid;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname == null ? null : imgname.trim();
    }

    public Date getImgdatetime() {
        return imgdatetime;
    }

    public void setImgdatetime(Date imgdatetime) {
        this.imgdatetime = imgdatetime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getImgaddress() {
        return imgaddress;
    }

    public void setImgaddress(String imgaddress) {
        this.imgaddress = imgaddress == null ? null : imgaddress.trim();
    }
}