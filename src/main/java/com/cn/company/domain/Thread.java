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
@Document(indexName = "thread",type = "thread",shards = 1,replicas = 0,refreshInterval = "-1")
@Entity
@Table(name="thread")
public class Thread {

    @Id
    @org.springframework.data.annotation.Id
    @SequenceGenerator(name = "PROJECT_ID_GENERATOR", sequenceName = "PROJECT_SEQ", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_ID_GENERATOR")
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
