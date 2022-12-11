package com.example.discord;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    public ArrayList<User> users;
    public ArrayList<GroupServer> groupServers;
    public ArrayList<DirectChat> directChats;

    public Database() {
        this.directChats = new ArrayList<>();
        this.users = new ArrayList<>();
        this.groupServers = new ArrayList<>();
        User user0 = new User();
        user0.username = "mee6";
        user0.setPic("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/Mee6.png");
        user0.backGroundColor = "#469db9";
        user0.id = 0;
        user0.setPassword("K976425j");
        user0.setStatus(1);
        users.add(user0);
        User user = new User();
        User user2 = new User();
        user2.id = 2;
        user2.setUsername("Sara1382");
        user2.setStatus(2);
        user2.setEmail("sara@aut.ac.ir");
        user2.setPassword("Sara1234");
        user2.setPic(null);
        user2.friendList.add(1);
        user2.backGroundColor = "#a5c2f2";
        user.friendList.add(2);
        user.id = 1;
        user.setNumber("09365024646");
        user.setUsername("shayan2781");
        user.setEmail("shahmadizad278114@gmail.com");
        user.setPassword("Shayan1234");
        user.setStatus(1);
        user.setPic("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/ProfileTest.jpg");
        user.backGroundColor = "#000000";
        users.add(user);
        users.add(user2);
        DirectChat directChat = new DirectChat(1, 2);
        directChat.id = 1;
        this.directChats.add(directChat);
        this.groupServers = new ArrayList<>();
        GroupServer groupServer = new GroupServer("Friends");
        groupServer.owner = 1;
        groupServer.id = 1;
        groupServer.setPicAddress("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/FriendsPFP.jpg");
        groupServer.users.add(1);
        groupServer.users.add(2);
        groupServer.admins.add(1);
        TextChannel textChannel = new TextChannel("general");
        VoiceChannel voiceChannel = new VoiceChannel("Call");
        groupServer.textChannels.add(textChannel);
        groupServer.voiceChannels.add(voiceChannel);
        groupServers.add(groupServer);
        this.saveDatabase();
        this.loadDatabase();
    }

    public void loadDatabase() {
        try {
            FileInputStream fileReaderUsers = new FileInputStream("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/Datas/Users.bin");
            ObjectInputStream objectInputStreamUsers = new ObjectInputStream(fileReaderUsers);
            this.users = (ArrayList<User>) objectInputStreamUsers.readObject();
            FileInputStream fileReaderGroups = new FileInputStream("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/Datas/GroupServers.bin");
            ObjectInputStream objectInputStreamGroups = new ObjectInputStream(fileReaderGroups);
            this.groupServers = (ArrayList<GroupServer>)objectInputStreamGroups.readObject();
            FileInputStream fileReaderDirects = new FileInputStream("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/Datas/DirectMessages.bin");
            ObjectInputStream objectInputStreamDirects = new ObjectInputStream(fileReaderDirects);
            this.directChats = (ArrayList<DirectChat>)objectInputStreamDirects.readObject();
            fileReaderGroups.close();
            fileReaderUsers.close();
            fileReaderDirects.close();
            objectInputStreamDirects.close();
            objectInputStreamGroups.close();
            objectInputStreamUsers.close();

        } catch (IOException | ClassNotFoundException var5) {
            var5.printStackTrace();
        }
    }

    public void saveDatabase() {
        try {
            FileOutputStream fileWriterUsers = new FileOutputStream("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/Datas/Users.bin");
            ObjectOutputStream objectOutputStreamUsers = new ObjectOutputStream(fileWriterUsers);
            objectOutputStreamUsers.writeObject(this.users);
            FileOutputStream fileWriterGroups = new FileOutputStream("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/Datas/GroupServers.bin");
            ObjectOutputStream objectOutputStreamGroups = new ObjectOutputStream(fileWriterGroups);
            objectOutputStreamGroups.writeObject(this.groupServers);
            FileOutputStream fileWriterDirects = new FileOutputStream("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/Datas/DirectMessages.bin");
            ObjectOutputStream objectOutputStreamDirects = new ObjectOutputStream(fileWriterDirects);
            objectOutputStreamDirects.writeObject(this.directChats);
            fileWriterGroups.close();
            fileWriterUsers.close();
            fileWriterDirects.close();
            objectOutputStreamDirects.close();
            objectOutputStreamGroups.close();
            objectOutputStreamUsers.close();
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }
    }
}

