package com.cn.company.domain;


import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

/**
 * Thread class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 上午12:15
 */
@Document(indexName = "thread", type = "thread", shards = 1, replicas = 0, refreshInterval = "-1")
@Entity
@Table(name = "thread")
public class Thread {

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue
    private int threadid;

    @Column
    private String postusername;

    @Column
    private String title;

    @Column
    private int forumid;

    @Column
    private long dateline;

    @Column
    private int visible;

    public int getThreadid() {
        return threadid;
    }

    public void setThreadid(int threadid) {
        this.threadid = threadid;
    }

    public String getPostusername() {
        return postusername;
    }

    public void setPostusername(String postusrname) {
        this.postusername = postusrname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getForumid() {
        return forumid;
    }

    public void setForumid(int forumid) {
        this.forumid = forumid;
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
        return "Thread{" +
                "threadid=" + threadid +
                ", postusername='" + postusername + '\'' +
                ", title='" + title + '\'' +
                ", forumid=" + forumid +
                ", dateline=" + dateline +
                ", visible=" + visible +
                '}';
    }

}
