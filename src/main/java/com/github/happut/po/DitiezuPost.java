package com.github.happut.po;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by bjwangfei3 on 2017/6/2.
 */
@Document(indexName = "ditiezuPost", type = "ditiezuPost")
public class DitiezuPost {
    private static final long serialVersionUID = -1L;

    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private String title;

    private String postTime;

    private Long click;

    private Long reply;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Long getClick() {
        return click;
    }

    public void setClick(Long click) {
        this.click = click;
    }

    public Long getReply() {
        return reply;
    }

    public void setReply(Long reply) {
        this.reply = reply;
    }
}
