package com.cn.company.domain;


import javax.persistence.*;

/**
 * Article class
 *
 * @author bingyu wu
 * @Date: 2018/1/12
 * @Time: 上午11:52
 */
@Entity
@Table(name="t_article")
public class Article {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int status;

    public Article() {
    }

    public Article(int id, String title, String content, int status) {
        this.id=id;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                '}';
    }
}
