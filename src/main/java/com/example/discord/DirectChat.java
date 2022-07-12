package com.example.discord;

import java.io.Serializable;
import java.util.ArrayList;

public class DirectChat implements Serializable {
    public int id;
    public int user1;
    public int user2;
    public ArrayList<Message> messages;

    public DirectChat(int user1, int user2) {
        this.user1 = user1;
        this.user2 = user2;
        this.messages = new ArrayList<>();
    }
}
