package com.example.discord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;

public class TextChannel extends Channel implements Serializable {
    public ArrayList<Message> messages;
    public Message pinMessage = null;

    public TextChannel(String name) {
        super("# " + name.toLowerCase(Locale.ROOT));
        this.messages = new ArrayList<>();
    }
}