package com.example.discord;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public Text InvalidInput;
    public Text WrongPassword;
    public TextField EmailBox;
    public PasswordField PassBox;
    public TextField PassVisible;
    public Text signUpText;

    public static Client client;

    public static int cnt = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Socket socket = null;
        try {
            socket = new Socket("localhost", 2000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client = new Client(socket);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        InvalidInput.setVisible(false);
        WrongPassword.setVisible(false);
        PassVisible.setVisible(false);
    }

    public void AddShaddow(MouseEvent mouseEvent) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(1.0);
        dropShadow.setOffsetY(1.0);
        dropShadow.setRadius(1);
        dropShadow.setColor(Color.rgb(0, 0, 0, .688));
        signUpText.setEffect(dropShadow);
    }

    public void RemoveShaddow(MouseEvent mouseEvent) {
        signUpText.setEffect(null);
    }

    public void LoginAction(MouseEvent mouseEvent) {
        if ( client.findUsername(EmailBox.getText().toLowerCase(Locale.ROOT))){
            InvalidInput.setVisible(false);
            if ( client.checkPassword(EmailBox.getText().toLowerCase(Locale.ROOT), PassBox.getText())){
                WrongPassword.setVisible(false);
                client.user = client.getUser(EmailBox.getText().toLowerCase(Locale.ROOT));
                client.user.setStatus(1);
                client.sendId(client.user.id);
                client.sendUpdateUser();
                client.listenForMessage();
                goToMainScreen(mouseEvent);
            }
            else{
                WrongPassword.setVisible(true);
                PassBox.setText(null);
            }
        }
        else{
            InvalidInput.setVisible(true);
            EmailBox.setText(null);
            PassBox.setText(null);
        }
    }

    public void setClient (Client client1){
        client = client1;
    }

    public void goToSignup(MouseEvent mouseEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpPage.fxml"));
        try {
            Parent root = loader.load();
            SignupController signupController = loader.getController();
            signupController.setClient(client);
            Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void ViewPass(MouseEvent mouseEvent) {

        PassVisible.setText(PassBox.getText());
        PassBox.setText("");
        PassVisible.setVisible(true);
        PassBox.setVisible(false);
    }

    public void HidePass(MouseEvent mouseEvent) {
        PassBox.setText(PassVisible.getText());
        PassVisible.setText("");
        PassVisible.setVisible(false);
        PassBox.setVisible(true);
    }

    public void goToMainScreen (MouseEvent mouseEvent){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        try {
            Parent root = loader.load();
            MainScreen mainScreen = loader.getController();
            mainScreen.setClient(client);
            Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
