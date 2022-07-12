package com.example.discord;

import java.io.Serializable;

public class Channel implements Serializable {
    public String name;

    public Channel(String name) {
        this.name = name;
    }
}