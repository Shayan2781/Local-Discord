package com.example.discord;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignupController implements Initializable {

    public Text NumError;
    public Text UserError;
    public TextField NumBox;
    public TextField PassBox;
    public Button SignUpButton;
    public TextField UserBox;
    public Text PassError;
    public TextField EmailBox;
    public Text MailError;
    public Text goBack;
    public Text PassConfirmError;

    public static Client client;
    public TextField PassConfirm;
    public AnchorPane Info;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        PassError.setVisible(false);
        NumError.setVisible(false);
        MailError.setVisible(false);
        UserError.setVisible(false);
        PassConfirmError.setVisible(false);
        Info.setVisible(false);
    }

    public void setClient (Client client1){
        client = client1;
    }

    public void goToLogin(MouseEvent mouseEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        try {
            Parent root = loader.load();
            LoginController loginController = loader.getController();
            loginController.setClient(client);
            Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void AddShaddow(MouseEvent mouseEvent) {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(1.0);
        dropShadow.setOffsetY(1.0);
        dropShadow.setRadius(1);
        dropShadow.setColor(Color.rgb(0, 0, 0, .688));
        goBack.setEffect(dropShadow);
    }

    public void RemoveShaddow(MouseEvent mouseEvent) {
        goBack.setEffect(null);
    }

    public void SignUpMethod(MouseEvent mouseEvent) {
        User user = new User();

        if ( !user.setUsername(UserBox.getText())){
            UserError.setText("Invalid Input");
            UserError.setVisible(true);
            clearFields();
            return;
        }
        UserError.setVisible(false);
        if ( client.findUsername(UserBox.getText())){
            UserError.setText("Username exists");
            UserError.setVisible(true);
            clearFields();
            return;
        }
        UserError.setVisible(false);
        if ( !user.setNumber(NumBox.getText())){
            NumError.setText("Invalid number");
            NumError.setVisible(true);
            NumBox.clear();
            PassBox.clear();
            PassConfirm.clear();
            return;
        }
        NumError.setVisible(false);
        if ( !user.setPassword(PassBox.getText())){
            PassError.setText("Invalid Password Type");
            PassError.setVisible(true);
            PassBox.clear();
            PassConfirm.clear();
            return;
        }
        PassError.setVisible(false);
        if ( !PassBox.getText().equals(PassConfirm.getText())){
            PassConfirmError.setText("Passwords arent the same");
            PassConfirmError.setVisible(true);
            PassConfirm.clear();
            return;
        }
        PassConfirmError.setVisible(false);
        if ( !user.setEmail(EmailBox.getText())){
            MailError.setText("Email doesnt exist");
            MailError.setVisible(true);
            EmailBox.clear();
            return;
        }
        MailError.setVisible(false);
        user.setStatus(1);
        user.id = client.database.users.get(client.database.users.size() - 1).id + 1;
        user.setPic(null);
        user.setBg();
        client.user = user;
        client.sendId(user.id);
        client.signUp(user);
        clearFields();
        goToMainScreen(mouseEvent);
    }

    public void clearFields(){
        UserBox.clear();
        EmailBox.clear();
        PassBox.clear();
        PassConfirm.clear();
        NumBox.clear();
    }

    public void showInfo(MouseEvent mouseEvent) {
        Info.setVisible(true);
    }

    public void hideInfo(MouseEvent mouseEvent) {
        Info.setVisible(false);
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
