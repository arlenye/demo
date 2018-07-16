package com.example.designpartten.prototype;

import java.io.Serializable;

/**
 * Created by wb-yejian on 2018/7/13.
 */
public class Email implements Serializable{
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
