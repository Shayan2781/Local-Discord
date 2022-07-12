package com.example.discord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class GroupServer implements Serializable {
    public String name;
    public String picAddress;
    public int id;
    public int owner;
    public ArrayList<TextChannel> textChannels;
    public ArrayList<VoiceChannel> voiceChannels;
    public HashSet<Integer> users;
    public HashSet<Integer> banList;
    public HashSet<Integer> admins;

    public GroupServer(String name) {
        this.name = name;
        this.textChannels = new ArrayList<>();
        this.voiceChannels = new ArrayList<>();
        this.users = new HashSet<>();
        this.banList = new HashSet<>();
        this.admins = new HashSet<>();
    }
    public boolean isInServer (int id){
        for ( Integer user : users){
            if (user == id){
                return true;
            }
        }
        return false;
    }
    public void setPicAddress (String picAddress){
        this.picAddress = picAddress;
    }

    public boolean isAdmin (int id){
        for ( Integer user : admins){
            if ( user == id){
                return true;
            }
        }
        return false;
    }


}
