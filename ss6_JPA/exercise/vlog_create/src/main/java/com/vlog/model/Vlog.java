package com.vlog.model;

import javax.persistence.*;

@Entity
public class Vlog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String writer;
    private String createdDate;
    @Column(columnDefinition = "TEXT")
    private String content;

    public Vlog() {
    }

    public Vlog(int id, String title, String writer, String createdDate, String content) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.createdDate = createdDate;
        this.content = content;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}