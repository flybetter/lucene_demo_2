package com.cn.company.domain;



import javax.persistence.*;

/**
 * Thread class
 *
 * @author bingyu wu
 * @Date: 2018/1/14
 * @Time: 上午12:15
 */
@Entity
@Table(name="thread")
public class Thread {

    @Id
    @GeneratedValue
    private int threadid;

    @Column
    private String postusername;

    @Column
    private String title;

    @Column
    private int forumid;


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
    

    @Override
    public String toString() {
        return "Thread{" +
                "threadid=" + threadid +
                ", postusername='" + postusername + '\'' +
                ", title='" + title + '\'' +
                ", forumid=" + forumid +
                '}';
    }
}
