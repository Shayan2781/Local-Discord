package com.example.discord;

import com.example.discord.*;

import java.io.*;
import java.net.Socket;
import java.util.Locale;

public class Client {
    public Socket socket;
    public ObjectInputStream objectInputStream;
    public ObjectOutputStream objectOutputStream;
    public User user;
    public Database database;
    public GroupServer groupServer;
    public TextChannel inTextChannel = null;
    public VoiceChannel inVoiceChannel = null;
    public DirectChat inDirectChat = null;


    public Client(Socket socket) throws IOException, ClassNotFoundException {
            this.socket =  socket;
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(socket.getInputStream());
            database = (Database) objectInputStream.readObject();
    }

    public void listenForMessage (){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Database newDatabase;
                while (socket.isConnected()){
                    try {
                        if ( objectInputStream != null){
                            newDatabase = (Database) objectInputStream.readObject();
                            updateDatabase(newDatabase);
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    public synchronized void updateDatabase (Database database){
        this.database = database;
        for ( User user1 : database.users){
            if ( user1.id == this.user.id){
                this.user = user1;
                break;
            }
        }
        if ( groupServer != null){
            for ( GroupServer groupServer1 : database.groupServers){
                if ( groupServer.id == groupServer1.id){
                    groupServer = groupServer1;
                    break;
                }
            }
        }
        if ( inTextChannel != null && groupServer != null){
            for ( TextChannel textChannel : groupServer.textChannels){
                if ( textChannel.name.equals(inTextChannel.name)){
                    inTextChannel = textChannel;
                    break;
                }
            }
        }
        if ( inDirectChat != null){
            for ( DirectChat directChat : database.directChats){
                if ( directChat.id == inDirectChat.id){
                    inDirectChat = directChat;
                    break;
                }
            }
        }
    }

    public User getUser (int id){
        for ( User user1 : database.users){
            if ( user1.id == id){
                return user1;
            }
        }
        return null;
    }


    public void closeEverything(Socket socket, ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream) {
        try {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addOtherFriendSide (int id1, int id2){
        for ( User user1 : database.users){
            if ( user1.id == id1){
                user1.friendList.add(id2);
                break;
            }
        }
    }
    public void removeOtherFriendSide (int id1, int id2){
        for ( User user1 : database.users){
            if ( user1.id == id1){
                user1.friendList.remove(id2);
                break;
            }
        }
    }

    public boolean findUsername (String username){
        for ( User user : this.database.users){
            if ( user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword (String username, String password){
        for ( User user : this.database.users){
            if ( user.getUsername().equals(username)){
                if ( user.getPassword().equals(password)){
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public synchronized void signUp (User user){
        this.database.users.add(user);
        sendUpdateUser();
    }

    public User getUser (String username){
        for ( User user : database.users){
            if ( user.getUsername().equals(username.toLowerCase(Locale.ROOT))){
                return user;
            }
        }
        return null;
    }
    public boolean canSetUsername (String username, int id){
        for ( User user1 : database.users){
            if ( user1.getUsername().equals(username) && user1.id != id){
                return false;
            }
        }
        return true;
    }
    public void localUpdate(User user1){
        int index = 0;
        for (User user : database.users){
            if ( user.id == user1.id){
                break;
            }
            index++;
        }
        database.users.set(index, user1);
    }

    public void sendId (int id){
        try {
            objectOutputStream.writeObject(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void localUpdate(GroupServer groupServer){
        int index = 0;
        for (GroupServer groupServer1 : database.groupServers ){
            if ( groupServer.id == groupServer1.id){
                break;
            }
            index++;
        }
        database.groupServers.set(index, groupServer);
    }
    public void localUpdate(DirectChat directChat){
        int index = 0;
        for (DirectChat directChat1 : database.directChats ){
            if ( inDirectChat.id == directChat1.id){
                break;
            }
            index++;
        }
        database.directChats.set(index, inDirectChat);
    }

    public void sendUpdates(){
        try {
            if ( this.user != null){
                localUpdate(this.user);
            }
            if ( this.groupServer != null){
                localUpdate(this.groupServer);
            }
            if ( this.inDirectChat != null){
                localUpdate(this.inDirectChat);
            }
            if ( socket.isConnected()){
                objectOutputStream.reset();
                objectOutputStream.writeUnshared(database);
            }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendOthergroupServerUpdate (){
        try {
            if ( socket.isConnected()){
                objectOutputStream.reset();
                objectOutputStream.writeUnshared(database);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendUpdateUser(){
        try {
            localUpdate(this.user);
            if ( socket.isConnected()){
                objectOutputStream.reset();
                objectOutputStream.writeUnshared(database);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void disconnect (){
        try {
            this.objectInputStream.close();
            this.objectOutputStream.close();
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getIndexBuyObject ( GroupServer groupServer){
        for ( GroupServer groupServer1 : database.groupServers){
            if ( groupServer1.id == groupServer.id){
                return database.groupServers.indexOf(groupServer1);
            }
        }
        return 0;
    }
    public int getIndexBuyObject ( User user){
        for ( User user1 : database.users){
            if ( user.id == user1.id){
                return database.users.indexOf(user1);
            }
        }
        return 0;
    }
}
