package com.wms.warehouse.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskid")
    private Long id;
    @Column(name = "content")
    private String content;
    @Column(name = "time")
    private String time;
    public TaskEntity(String content, String time) {
        this.content = content;
        this.time = time;
    }
    public TaskEntity() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
