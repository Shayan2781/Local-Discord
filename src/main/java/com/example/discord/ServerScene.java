package com.example.discord;

import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ServerScene implements Initializable {
    public VBox Container;
    public ScrollPane ResultSP;
    public static Server server = new Server();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Container.setSpacing(10);
        ResultSP.setVisible(false);
        ServerRunnerThread serverRunnerThread = new ServerRunnerThread();
        serverRunnerThread.getServer(server);
        Thread thread = new Thread(serverRunnerThread);
        thread.start();
    }
    public void ButtonEntered(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-color:  #23272a");
    }

    public void ButtonExited(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-color:  transparent");
    }

    public void ShowUsers(MouseEvent mouseEvent) {
        server.database.loadDatabase();
        Container.getChildren().clear();
        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(0, 0, 0, 8));
        hbox1.setAlignment(Pos.CENTER_LEFT);
        Text text1 = new Text("<ID> <USERNAME> <PASSWORD> <EMAIL> <NUMBER> <STATUS>");
        text1.setFill(Color.WHITE);
        hbox1.getChildren().add(text1);
        Container.getChildren().add(hbox1);
        for ( User user : server.database.users){
            if ( user.id != 0){
                HBox hBox = new HBox();
                hBox.setPadding(new Insets(0, 0, 0, 8));
                hBox.setAlignment(Pos.CENTER_LEFT);
                Text text = new Text(user.toString());
                text.setFill(Color.WHITE);
                hBox.getChildren().add(text);
                Container.getChildren().add(hBox);
            }
        }
        ResultSP.setVisible(true);
    }

    public void ShowServers(MouseEvent mouseEvent) {
        server.database.loadDatabase();
        Container.getChildren().clear();
        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(0, 0, 0, 8));
        hbox1.setAlignment(Pos.CENTER_LEFT);
        Text text1 = new Text("<ID> <NAME> <USERS> <CHANNELS> <ADMINS>");
        text1.setFill(Color.WHITE);
        hbox1.getChildren().add(text1);
        Container.getChildren().add(hbox1);
        for (GroupServer groupServer : server.database.groupServers){
            HBox hBox = new HBox();
            hBox.setPadding(new Insets(0, 0, 0, 8));
            hBox.setAlignment(Pos.CENTER_LEFT);
            Text text = new Text(groupServer.id +" : " + groupServer.name +  " " + groupServer.users.size() + " " + (groupServer.voiceChannels.size() + groupServer.textChannels.size()) + " " + groupServer.admins.size());
            text.setFill(Color.WHITE);
            hBox.getChildren().add(text);
            Container.getChildren().add(hBox);
        }
        ResultSP.setVisible(true);
    }

    public void ShowDirectChats(MouseEvent mouseEvent) {
        server.database.loadDatabase();
        Container.getChildren().clear();
        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(0, 0, 0, 8));
        hbox1.setAlignment(Pos.CENTER_LEFT);
        Text text1 = new Text("<ID> <USER1> <USER2>");
        text1.setFill(Color.WHITE);
        hbox1.getChildren().add(text1);
        Container.getChildren().add(hbox1);
        for ( DirectChat directChat : server.database.directChats){
            HBox hBox = new HBox();
            hBox.setPadding(new Insets(0, 0, 0, 8));
            hBox.setAlignment(Pos.CENTER_LEFT);
            Text text = new Text(directChat.id + " : " + getUsernameById(directChat.user1) + " " + getUsernameById(directChat.user2));
            text.setFill(Color.WHITE);
            hBox.getChildren().add(text);
            Container.getChildren().add(hBox);
        }
        ResultSP.setVisible(true);
    }
    public String getUsernameById ( int i){
        for ( User user : server.database.users){
            if ( user.id == i){
                return user.username;
            }
        }
        return null;
    }
}
