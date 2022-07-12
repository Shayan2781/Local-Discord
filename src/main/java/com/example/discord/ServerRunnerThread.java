package com.example.discord;

public class ServerRunnerThread implements Runnable{
    Server server;
    public void getServer (Server server){
        this.server = server;
    }
    @Override
    public void run() {
        server.startServer();
    }
}
