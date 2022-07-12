package com.example.discord;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;

public class RunApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Image image = new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/DiscordLogoCircle.png");
        Socket socket = null;
        int nullChecker = 0;
        try {
            socket = new Socket("localhost", 2000);
        } catch (IOException e){
            nullChecker = 1;
        }
        FXMLLoader fxmlLoader = null;
        if ( nullChecker == 1){
             fxmlLoader = new FXMLLoader(RunApp.class.getResource("Connecting.fxml"));
        }
        else {
            fxmlLoader = new FXMLLoader(RunApp.class.getResource("LoginPage.fxml"));
            socket.close();
        }

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Discord");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}