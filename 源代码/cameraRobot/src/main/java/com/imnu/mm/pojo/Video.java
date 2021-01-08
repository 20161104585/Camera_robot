package com.imnu.mm.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Video {
    private Integer videoid;

    private String videoname;

    private String videosize;

    private String videotype;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date videodatetime;

    private Integer userid;

    private String username;

    public Integer getVideoid() {
        return videoid;
    }

    public void setVideoid(Integer videoid) {
        this.videoid = videoid;
    }

    public String getVideoname() {
        return videoname;
    }

    public void setVideoname(String videoname) {
        this.videoname = videoname == null ? null : videoname.trim();
    }

    public String getVideosize() {
        return videosize;
    }

    public void setVideosize(String videosize) {
        this.videosize = videosize == null ? null : videosize.trim();
    }

    public String getVideotype() {
        return videotype;
    }

    public void setVideotype(String videotype) {
        this.videotype = videotype == null ? null : videotype.trim();
    }

    public Date getVideodatetime() {
        return videodatetime;
    }

    public void setVideodatetime(Date videodatetime) {
        this.videodatetime = videodatetime;
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
}