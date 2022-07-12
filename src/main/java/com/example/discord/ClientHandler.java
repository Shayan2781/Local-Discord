package com.example.discord;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    static Database database;
    static ArrayList<ClientHandler> clientHandlers;
    int clientId;
    public Socket socket = null;
    public ObjectInputStream objectInputStream;
    public ObjectOutputStream objectOutputStream;


    public ClientHandler(Socket socket) {
        System.out.println(socket);
        this.socket = socket;
        try {
            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream.writeObject(database);
            clientHandlers.add(this);
        } catch (IOException e) {
            closeEverything(socket, objectOutputStream, objectInputStream);
        }
    }

    public static void setDatabase (Database database1){
        database = database1;
        clientHandlers = new ArrayList<>();
    }


    @Override
    public void run() {
        try {
            if ( objectInputStream != null){
                clientId = (Integer) objectInputStream.readObject();
            }
            while (socket.isConnected()){
                if ( objectInputStream != null){
                    Database newDatabase = (Database) objectInputStream.readUnshared();
                    updateDataBase(newDatabase);
                    sendUpdates();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            closeEverything(socket, objectOutputStream, objectInputStream);
        }


    }
    public void removeClientHandler() {
        clientHandlers.remove(this);
        for ( User user : database.users){
            if ( clientId == user.id){
                user.setStatus(2);
            }
        }
    }

    public void closeEverything(Socket socket, ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream) {
        removeClientHandler();
        try {
            if (socket != null) {
                socket.close();
            }
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
        } catch (IOException ignored) {
        }
    }

    public synchronized void updateDataBase(Database newDatabase){
        database = newDatabase;
        database.saveDatabase();
    }


    public void sendUpdates(){
        if ( !clientHandlers.isEmpty()){
            for ( ClientHandler clientHandler : clientHandlers){
                if ( clientHandler.clientId != clientId){
                    try {
                        objectOutputStream.reset();
                        clientHandler.objectOutputStream.writeUnshared(database);
                    } catch (IOException e) {
                        closeEverything(clientHandler.socket, clientHandler.objectOutputStream, clientHandler.objectInputStream);
                    }
                }
            }
        }
    }

}

