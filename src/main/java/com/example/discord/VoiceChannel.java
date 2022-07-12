package com.example.discord;

import java.io.Serializable;
import java.util.HashSet;

public class VoiceChannel extends Channel implements Serializable {

    public HashSet<Integer> onlineUsers;

    public VoiceChannel(String name) {
        super(name);
        this.onlineUsers = new HashSet<>();
    }

    public boolean joinCall (User user){
        if ( onlineUsers.contains(user.id)){
            System.out.println("You are already in the call");
            return false;
        }
        else {
            onlineUsers.add(user.id);
        }
        return true;
    }

}
