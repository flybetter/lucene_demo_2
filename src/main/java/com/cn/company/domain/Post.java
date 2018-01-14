package com.cn.company.domain;


import javax.persistence.*;

/**
 * Post class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 上午12:15
 */
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue
    private int postid;

    @Column
    private String pagetext;

    @Column
    private String username;

    @Column
    private int threadid;

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

    @Override
    public String toString() {
        return "Post{" +
                "postid=" + postid +
                ", pagetext='" + pagetext + '\'' +
                ", username='" + username + '\'' +
                ", threadid=" + threadid +
                '}';
    }
}
