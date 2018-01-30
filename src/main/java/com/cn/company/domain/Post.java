package com.cn.company.domain;


import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;


/**
 * Post class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 上午12:15
 */
@Document(indexName = "post",type = "post",shards = 1,replicas = 0,refreshInterval = "-1")
@Entity
@Table(name = "post")
public class Post {

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue
    private int postid;

    @Column
    private String pagetext;

    @Column
    private String username;

    @Column
    private int threadid;

    @Column
    private long dateline;

    @Column
    private int visible;

    public int getPostid() {
        return postid;
    }

    public void setPostid(int postid) {
        this.postid = postid;
    }

    public String getPagetext() {
        return pagetext;
    }

    public void setPagetext(String pagetext) {
        this.pagetext = pagetext;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getThreadid() {
        return threadid;
    }

    public void setThreadid(int threadid) {
        this.threadid = threadid;
    }

    public long getDateline() {
        return dateline;
    }

    public void setDateline(long dateline) {
        this.dateline = dateline;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", pagetext='" + pagetext + '\'' +
                ", username='" + username + '\'' +
                ", threadid=" + threadid +
                ", dateline=" + dateline +
                ", visible=" + visible +
                '}';
    }
}
