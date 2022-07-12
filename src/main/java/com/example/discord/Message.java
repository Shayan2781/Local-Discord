package com.example.discord;

import java.io.Serializable;
import java.util.HashSet;

public class Message implements Serializable{
    public String content;
    public int sender;
    public HashSet<Integer> likes;
    public HashSet<Integer> dislikes;
    public HashSet<Integer> heart;

    public Message(String content, int sender) {
        this.content = content;
        this.sender = sender;
        this.likes = new HashSet<>();
        this.dislikes = new HashSet<>();
        this.heart = new HashSet<>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
