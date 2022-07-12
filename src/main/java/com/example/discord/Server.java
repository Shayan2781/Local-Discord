package com.example.discord;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;
    Database database = new Database();

    public Server() {
        try {
            serverSocket = new ServerSocket(2000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        ClientHandler.setDatabase(this.database);
        try {
            while(!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("new client has connected!");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException var7) {
            this.closeServerSocket();
        }

    }
    public void closeEverything(Socket socket, ObjectOutputStream objectOutputStream, ObjectInputStream objectInputStream) {
        database.saveDatabase();
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

    public void closeServerSocket() {
        database.saveDatabase();

        try {
            this.serverSocket.close();
        } catch (IOException var2) {
            var2.printStackTrace();
        }
    }
}
