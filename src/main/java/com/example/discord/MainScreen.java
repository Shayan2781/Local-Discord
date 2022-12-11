package com.example.discord;


import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.*;

public class MainScreen implements Initializable {
    public Circle PfpHolder;
    public static Client client;
    public Button AllFriends;
    public Button FriendRequests;
    public Button OnlineFriends;
    public ImageView MuteIcon;
    public static int MuteCounter = 1;
    public AnchorPane SetStatus;
    public Circle StatusShape;
    public Circle EditCircle;
    public Text EditPic;
    public Circle SettingPfp;
    public Rectangle BackGroundUser;
    public javafx.scene.control.ColorPicker ColorPicker;
    public AnchorPane SettingTab;
    public Text UsernameTxt;
    public Text UserPass;
    public Text UserEmail;
    public Text UserNumber;
    public Text UserUsername;
    public Button EditPassButton;
    public Button EditMailButton;
    public Button EditNumButton;
    public Button EditUserButton;
    public TextField UserField;
    public TextField PassField;
    public TextField NumberField;
    public TextField EmailField;
    public Text UserError;
    public Text PasswordError;
    public Text EmailError;
    public Text NumberError;
    public Button FriendBlocked;
    public Rectangle PrivateMessages;
    public VBox ListServers;
    public Rectangle AddServer;
    public VBox ListFriend;
    public AnchorPane FriendsTab;
    public AnchorPane NoFriendsTab;
    public Text NoFriendsText;
    public Text FriendTitle;
    public Text ChatSectionTitle;
    public Text AddChat;
    public VBox ChatNames;
    public Text ThereAreNoChats;
    public ImageView ColorMode;
    public VBox ChatOnlines;
    public AnchorPane NewServerTab;
    public TextField NewServerName;
    public Circle EditCircle1;
    public Circle NewServerPfp;
    public Text SetNewServerPic;
    public AnchorPane ServerOptions;
    public AnchorPane ServerDetailsForMember;
    public Circle ServerDetailsPic;
    public Text ServerDetailsName;
    public VBox ServerSearchResult;
    public ScrollPane ServerSearchScroll;
    public ImageView NoResultServerPic;
    public Text NoResultServerText;
    public TextField SearchServerField;
    public AnchorPane JoinServerTab;
    public Text EditServerPicText;
    public Circle EditCircle2;
    public TextField EditServerNameField;
    public Button EditServerNameButton;
    public Text EditServerNameDisplayer;
    public Circle EditServerPic;
    public AnchorPane ServerEditTab;
    public Circle SearchedUserPic;
    public AnchorPane SearchUsernameResult;
    public Text SearchedUserUsername;
    public TextField SearchUserInEditServerField;
    public Button DemoteMemberButton;
    public Button PromoteMemberButton;
    public Button KickMemberButton;
    public Button BlockButton;
    public Button FriendRequestButton;
    public Text NoResultUserText;
    public ImageView NoResultUserPic;
    public HBox AddFriendResult;
    public Button AddFriendSearchButton;
    public Circle UserSearchResultPic;
    public Text UserSearchResultName;
    public AnchorPane SearchUserTab;
    public TextField SearchUserField;
    public Button DeleteServerButton;
    public TextField SearchToAddMemberField;
    public AnchorPane AddMemberSearchResult1;
    public Circle AddMemberPic1;
    public Text AddMemberName1;
    public TextField AddUserField;
    public Circle AddMemberPic;
    public Text AddMemberName;
    public AnchorPane AddMemberSearchResult;
    public TextField AddTextChannelField;
    public TextField AddVoiceChannelField;
    public AnchorPane AddChannelTab;
    public Circle AttachFile;
    public AnchorPane MessageSection;
    public VBox MessageVBox;
    public AnchorPane Pinbar;
    public Circle PinPic;
    public Text PinUsername;
    public Text PinContent;
    public TextField SendMessageField;
    public ScrollPane MessageSP;
    public Button EditChannelNameButton;
    public TextField SearchChannelInEditServer;
    public Text ChannelSearchResult;
    public TextField NewChannelNamefield;
    public AnchorPane ChannelSearchResulttab;
    public ImageView CallIcon;
    public Text ChannelName;
    public ImageView RefreshButton;
    public Text RefreshText;
    public Text SongName;
    public ProgressBar songProgress;
    public ImageView SongPlayPause;
    public AnchorPane SongTab;
    public Text AddDirectChat;
    public AnchorPane AddDirectResult;
    public Circle NewDirectUserPic;
    public Text NewDirectUserName;
    public AnchorPane AddDirectTab;
    public TextField AddDirectField;

    Timer timer;
    TimerTask timerTask;
    boolean running;
    Media songs;
    MediaPlayer songPlayer;
    int songNumber = 0;
    List<File> list;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SetStatus.setVisible(false);
        changeStatusColor(1);
        EditCircle.setVisible(false);
        EditPic.setVisible(false);
        SettingTab.setVisible(false);
        UserField.setVisible(false);
        PassField.setVisible(false);
        NumberField.setVisible(false);
        EmailField.setVisible(false);
        UserError.setVisible(false);
        NumberError.setVisible(false);
        PasswordError.setVisible(false);
        EmailError.setVisible(false);
        Image image = new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/MessageIcon.png");
        PrivateMessages.setFill(new ImagePattern(image));
        AttachFile.setFill(new ImagePattern(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/AttachIcon.png")));
        AddServer.setFill(new ImagePattern(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/Cross.png")));
        MessageVBox.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                MessageSP.setVvalue((Double) newValue);
            }
        });
    }

    public void setClient(Client client1){
        client = client1;
        updatePics();
        setupGroupServersList();
        showDirectMessages();
        NotifSoundSender();
        //chatUpdateChecker();
    }


    public void updatePics (){
        if ( client.user.getPicAddress() != null){
            Image image = new Image(client.user.getPicAddress());
            PfpHolder.setFill(new ImagePattern(image));
            SettingPfp.setFill(new ImagePattern(image));
        }
        else{
            Image image = new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/Default.jpg");
            PfpHolder.setFill(new ImagePattern(image));
            SettingPfp.setFill(new ImagePattern(image));
        }
        if ( client.user.backGroundColor != null){
            BackGroundUser.setFill(Color.valueOf(client.user.backGroundColor));
            ColorPicker.setValue(Color.valueOf(client.user.backGroundColor));
        }
        else{
            BackGroundUser.setFill(Color.BLUE);
            ColorPicker.setValue(Color.BLUE);
        }
    }

    public void MouseEnteredFriendButton(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-radius: 5;" + "-fx-background-color: #36393e;");
    }

    public void MouseExitedFriendButton(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-radius: 5;" + "-fx-background-color: transparent;");
    }


    public void MuteUnmute(MouseEvent mouseEvent) {
        if ( songPlayer != null){
            if ( MuteCounter % 2 == 0){
                MuteIcon.setImage(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/Mute.png"));
                songPlayer.setVolume(100);
            }
            else{
                MuteIcon.setImage(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/Unmute.png"));
                songPlayer.setVolume(0);
            }
            MuteCounter++;
        }
    }

    public void SetStatusVisible(MouseEvent mouseEvent) {
        SetStatus.setVisible(true);
    }

    public void SetStatusOnline(MouseEvent mouseEvent) {
        client.user.setStatus(1);
        changeStatusColor(1);
        SetStatus.setVisible(false);
        client.sendUpdates();
    }

    public void SetStatusOffline(MouseEvent mouseEvent) {
        client.user.setStatus(2);
        changeStatusColor(2);
        SetStatus.setVisible(false);
        client.sendUpdates();
    }

    public void SetStatusIdle(MouseEvent mouseEvent) {
        client.user.setStatus(3);
        changeStatusColor(3);
        SetStatus.setVisible(false);
        client.sendUpdates();
    }
    public void SetStatusDisturb(MouseEvent mouseEvent) {
        client.user.setStatus(4);
        changeStatusColor(4);
        SetStatus.setVisible(false);
        client.sendUpdates();
    }

    public void changeStatusColor (int n){
        if ( n == 1){
            StatusShape.setFill(Color.rgb(19, 217, 49));
        }
        else if ( n == 2){
            StatusShape.setFill(Color.rgb(125, 139, 153));
        }
        else if ( n == 3){
            StatusShape.setFill(Color.rgb(255, 210, 0));
        }
        else {
            StatusShape.setFill(Color.valueOf("#ec0202"));
        }
    }

    public void EditVisible(MouseEvent mouseEvent) {
        EditPic.setVisible(true);
        EditCircle.setVisible(true);
    }

    public void EditInvisible(MouseEvent mouseEvent) {
        EditPic.setVisible(false);
        EditCircle.setVisible(false);
    }

    public void ChangeBackground(ActionEvent actionEvent) {
        client.user.backGroundColor = ColorPicker.getValue().toString();
        BackGroundUser.setFill(Color.valueOf(client.user.backGroundColor));

    }

    public void ChangeProfilePic(MouseEvent mouseEvent) {
        List<String> list = new ArrayList<>();
        list.add("*.jpg");
        list.add("*.JPG");
        list.add("*.png");
        list.add("*.PNG");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Picutres", list));
        File file = fileChooser.showOpenDialog(null);
        if ( file != null){
            String path = file.getAbsolutePath();
            client.user.setPic(path);
            client.user.setBg();
            updatePics();
            client.sendUpdateUser();
        }
    }

    public void OpenSetting(MouseEvent mouseEvent) {
        SettingTab.setVisible(true);
        UsernameTxt.setText(client.user.getUsername());
        UserEmail.setText(client.user.getEmail());
        UserNumber.setText(client.user.getNumber());
        UserPass.setText(client.user.getPassword());
        UserUsername.setText(client.user.getUsername());
    }

    public void CloseSettingOnClick(MouseEvent mouseEvent) {
        SettingTab.setVisible(false);
        client.sendUpdateUser();
    }

    public void EditUsername(MouseEvent mouseEvent) {
        Client target;
        if ( EditUserButton.getText().equals("Edit")){
            UserField.setVisible(true);
            EditUserButton.setText("Save");
        }
        else{
            if (!client.canSetUsername(UserField.getText().toLowerCase(Locale.ROOT), client.user.id)){
                UserError.setText("Username Already Exists");
                UserError.setVisible(true);
                return;
            }
            else if ( !client.user.setUsername(UserField.getText().toLowerCase(Locale.ROOT))){
                UserError.setText("Invalid Username");
                UserError.setVisible(true);
                return;
            }
            UserError.setVisible(false);
            EditUserButton.setText("Edit");
            UserField.clear();
            UserField.setVisible(false);
            refreshSetting();
        }
    }

    public void EditNumber(MouseEvent mouseEvent) {
        if ( EditNumButton.getText().equals("Edit")){
            NumberField.setVisible(true);
            EditNumButton.setText("Save");
        }
        else{
            if ( !client.user.setNumber(NumberField.getText())){
                NumberError.setText("Invalid number");
                NumberError.setVisible(true);
                return;
            }
            NumberError.setVisible(false);
            EditNumButton.setText("Edit");
            NumberField.clear();
            NumberField.setVisible(false);
            refreshSetting();
        }
    }

    public void EditEmail(MouseEvent mouseEvent) {
        if ( EditMailButton.getText().equals("Edit")){
            EmailField.setVisible(true);
            EditMailButton.setText("Save");
        }
        else{
            if ( !client.user.setEmail(EmailField.getText())){
                EmailError.setText("Invalid email");
                EmailError.setVisible(true);
                return;
            }
            EmailError.setVisible(false);
            EditMailButton.setText("Edit");
            EmailField.clear();
            EmailField.setVisible(false);
            refreshSetting();
        }

    }

    public void EditPassword(MouseEvent mouseEvent) {
        if ( EditPassButton.getText().equals("Edit")){
            PassField.setVisible(true);
            EditPassButton.setText("Save");
        }
        else{
            if ( !client.user.setPassword(PassField.getText())){
                PasswordError.setText("Invalid password");
                PasswordError.setVisible(true);
                return;
            }
            PasswordError.setVisible(false);
            EditPassButton.setText("Edit");
            PassField.clear();
            PassField.setVisible(false);
            refreshSetting();
        }
    }

    public void refreshSetting (){
        SettingTab.setVisible(false);
        UsernameTxt.setText(client.user.getUsername());
        UserEmail.setText(client.user.getEmail());
        UserNumber.setText(client.user.getNumber());
        UserPass.setText(client.user.getPassword());
        UserUsername.setText(client.user.getUsername());
        SettingTab.setVisible(true);
        client.sendUpdateUser();
    }

    public void LogOutClicked(MouseEvent mouseEvent) {
        client.user.setStatus(2);
        client.sendUpdateUser();
        System.exit(1);
    }


    public void makePicSquare(MouseEvent mouseEvent) {
        ((Rectangle)mouseEvent.getSource()).setArcHeight(32);
        ((Rectangle)mouseEvent.getSource()).setArcWidth(32);

    }

    public void makePicCircle(MouseEvent mouseEvent) {
        ((Rectangle)mouseEvent.getSource()).setArcHeight(50);
        ((Rectangle)mouseEvent.getSource()).setArcWidth(50);
    }

    public void showAllFriends (MouseEvent mouseEvent){
        ListFriend.getChildren().clear();
        FriendTitle.setText("All Friends");
        FriendsTab.setVisible(true);
        CloseSettingOnClick(mouseEvent);
        if ( client.user.friendList == null || client.user.friendList.isEmpty()){
            NoFriendsText.setText("You dont have any friends yet");
            NoFriendsTab.setVisible(true);
            return;
        }
        NoFriendsTab.setVisible(false);
        for( Integer id : client.user.friendList){
            User user = client.getUser(id);
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(15);
            hBox.setPadding(new Insets(0, 0, 0, 10));
            Circle circle = new Circle(20);
            circle.setFill(new ImagePattern(new Image(user.getPicAddress())));
            hBox.getChildren().add(circle);
            Circle circle1 = new Circle(7);
            HBox.setMargin(circle1, new Insets(25, 0, 0, -28));
            circle1.setStroke(Color.valueOf("#424549"));
            circle1.setStrokeWidth(3);
            if ( user.getStatus().equals("ONLINE")){
                circle1.setFill(Color.valueOf("#13d931"));
            }
            else if (user.getStatus().equals("OFFLINE")){
                circle1.setFill(Color.valueOf("#7d8b99"));
            }
            else if (user.getStatus().equals("IDLE")) {
                circle1.setFill(Color.valueOf("#ffd300"));
            }
            else{
                circle1.setFill(Color.DARKRED);
            }
            hBox.getChildren().add(circle1);
            Text text = new Text(user.getUsername());
            text.setFont(Font.font("arial", 15));
            text.setFill(Color.WHITE);
            hBox.getChildren().add(text);
            Button button = new Button("Remove");
            button.setStyle("-fx-background-color: #2f3136");
            button.setTextFill(Color.WHITE);
            button.setCursor(Cursor.HAND);
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    client.user.friendList.remove(id);
                    client.removeOtherFriendSide(id, client.user.id);
                    client.sendUpdateUser();
                    showAllFriends(mouseEvent);
                }
            });
            hBox.getChildren().add(button);
            ListFriend.getChildren().add(hBox);
        }
    }

    public void ShowOnlineFriends (MouseEvent mouseEvent){
        ListFriend.getChildren().clear();
        FriendTitle.setText("Online Friends");
        CloseSettingOnClick(mouseEvent);
        FriendsTab.setVisible(true);
        if ( client.user.friendList == null || client.user.friendList.isEmpty()){
            NoFriendsText.setText("You dont have any friends yet");
            NoFriendsTab.setVisible(true);
            return;
        }
        NoFriendsTab.setVisible(false);
        int counter = 0;
        for ( Integer id : client.user.friendList){
            User user = client.getUser(id);
            if ( !user.getStatus().equals("OFFLINE")){
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER_LEFT);
                hBox.setSpacing(15);
                hBox.setPadding(new Insets(0, 0, 0, 10));
                Circle circle = new Circle(20);
                circle.setFill(new ImagePattern(new Image(user.getPicAddress())));
                hBox.getChildren().add(circle);
                Circle circle1 = new Circle(7);
                HBox.setMargin(circle1, new Insets(25, 0, 0, -28));
                circle1.setStroke(Color.valueOf("#424549"));
                circle1.setStrokeWidth(3);
                if ( user.getStatus().equals("ONLINE")){
                    circle1.setFill(Color.valueOf("#13d931"));
                }
                else if (user.getStatus().equals("OFFLINE")){
                    circle1.setFill(Color.valueOf("#7d8b991"));
                }
                else if (user.getStatus().equals("IDLE")) {
                    circle1.setFill(Color.valueOf("#ffd300"));
                }
                else{
                    circle1.setFill(Color.DARKRED);
                }
                hBox.getChildren().add(circle1);
                Text text = new Text(user.getUsername());
                text.setFont(Font.font("arial", 15));
                text.setFill(Color.WHITE);
                hBox.getChildren().add(text);
                ListFriend.getChildren().add(hBox);
                counter++;
            }
        }
        if ( counter == 0){
            NoFriendsText.setText("No friends are online");
            NoFriendsTab.setVisible(true);
        }
    }

    public void CloseFriendsTabOnCLick(MouseEvent mouseEvent) {
        FriendsTab.setVisible(false);
    }

    public void setupGroupServersList(){
        ListServers.getChildren().clear();
        ListServers.setSpacing(10);
        for ( GroupServer groupServer : client.database.groupServers){
            if ( groupServer.isInServer(client.user.id)){
                Rectangle rectangle = new Rectangle(44, 44);
                rectangle.setCursor(Cursor.HAND);
                rectangle.setFill(new ImagePattern(new Image(groupServer.picAddress)));
                rectangle.setArcWidth(50);
                rectangle.setArcHeight(50);
                rectangle.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        ((Rectangle) mouseEvent.getSource()).setArcWidth(32);
                        ((Rectangle) mouseEvent.getSource()).setArcHeight(32);
                    }
                });
                rectangle.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        ((Rectangle) mouseEvent.getSource()).setArcWidth(50);
                        ((Rectangle) mouseEvent.getSource()).setArcHeight(50);
                    }
                });
                rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        MessageSection.setVisible(false);
                        client.groupServer = groupServer;
                        client.inTextChannel = null;
                        AddDirectChat.setVisible(false);
                        client.inDirectChat = null;
                        if ( client.user.id == groupServer.owner || groupServer.admins.contains(client.user.id)){
                            AddChat.setVisible(true);
                        }
                        showGroupServerChats(groupServer);
                        rectangle.setStroke(Color.WHITE);
                        rectangle.setStrokeWidth(1);
                        PrivateMessages.setStrokeWidth(0);
                        ThereAreNoChats.setVisible(false);
                        for ( Node node : ListServers.getChildren()){
                            if (((Rectangle) node) != rectangle){
                                ((Rectangle) node).setStrokeWidth(0);
                            }
                        }
                        showGroupServersOnlines(groupServer);
                    }
                });
                ListServers.getChildren().add(rectangle);
            }
        }
    }

    public void showGroupServersOnlines (GroupServer groupServer){
        ChatOnlines.getChildren().clear();
        ChatOnlines.setSpacing(10);
        ChatOnlines.setPadding(new Insets(7, 0, 0, 0));
        int onlineCnt = 0;
        for ( Integer id : groupServer.users){
            if ( !client.getUser(id).getStatus().equals("OFFLINE")){
                onlineCnt++;
                break;
            }
        }
        int offlineCnt = 0;
        for ( Integer id : groupServer.users){
            if ( client.getUser(id).getStatus().equals("OFFLINE")){
                offlineCnt++;
                break;
            }
        }

        if ( onlineCnt != 0){
            HBox onlineMembers = new HBox();
            Text onlineMembersTxt = new Text("Online members");
            onlineMembersTxt.setUnderline(true);
            onlineMembersTxt.setFill(Color.WHITE);
            onlineMembersTxt.setFont(Font.font("arial", 12));
            onlineMembers.setAlignment(Pos.CENTER);
            onlineMembers.getChildren().add(onlineMembersTxt);
            ChatOnlines.getChildren().add(onlineMembers);
            for ( Integer id : groupServer.users){
                if ( !client.getUser(id).getStatus().equals("OFFLINE")){
                    User user = client.getUser(id);
                    HBox hBox = new HBox();
                    hBox.setPadding(new Insets(0, 0, 0, 4));
                    hBox.setSpacing(6);
                    hBox.setAlignment(Pos.CENTER);
                    Circle circle = new Circle(14);
                    if ( !user.blockedList.contains(client.user.id)){
                        circle.setFill(new ImagePattern(new Image(user.getPicAddress())));
                    }
                    else{
                        circle.setFill(new ImagePattern(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/BlockedPFP.jpg")));
                    }
                    hBox.getChildren().add(circle);
                    Text text = new Text(user.getUsername());
                    text.setFont(Font.font("arial", 11));
                    text.setFill(Color.WHITE);
                    text.setWrappingWidth(74.1);
                    hBox.getChildren().add(text);
                    ChatOnlines.getChildren().add(hBox);
                }
            }
        }
        if ( offlineCnt != 0){
            HBox offlineMembers = new HBox();
            Text offlineMembersTxt = new Text("Offline members");
            offlineMembersTxt.setUnderline(true);
            offlineMembersTxt.setFill(Color.WHITE);
            offlineMembersTxt.setFont(Font.font("arial", 12));
            offlineMembers.setAlignment(Pos.CENTER);
            offlineMembers.getChildren().add(offlineMembersTxt);
            VBox.setMargin(offlineMembers, new Insets(10, 0, 0, 0));
            ChatOnlines.getChildren().add(offlineMembers);
            for ( Integer id : groupServer.users){
                if ( client.getUser(id).getStatus().equals("OFFLINE")){
                    User user = client.getUser(id);
                    HBox hBox = new HBox();
                    hBox.setPadding(new Insets(0, 0, 0, 4));
                    hBox.setSpacing(6);
                    hBox.setAlignment(Pos.CENTER);
                    Circle circle = new Circle(14);
                    if ( !user.blockedList.contains(client.user.id)){
                        circle.setFill(new ImagePattern(new Image(user.getPicAddress())));
                    }
                    else{
                        circle.setFill(new ImagePattern(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/BlockedPFP.jpg")));
                    }
                    hBox.getChildren().add(circle);
                    Text text = new Text(user.getUsername());
                    text.setFont(Font.font("arial", 11));
                    text.setFill(Color.valueOf("#a9a9a9"));
                    text.setWrappingWidth(74.1);
                    hBox.getChildren().add(text);
                    ChatOnlines.getChildren().add(hBox);
                }
            }
        }

    }

    public void showGroupServerChats (GroupServer groupServer){
        ChatSectionTitle.setText(groupServer.name);
        ChatNames.getChildren().clear();
        HBox hBox = new HBox();
        Text textChannelHeader = new Text("Text Channels");
        textChannelHeader.setUnderline(true);
        textChannelHeader.setFill(Color.WHITE);
        hBox.setPadding(new Insets(0, 0, 0, 8));
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().add(textChannelHeader);
        ChatNames.getChildren().add(hBox);
        for ( TextChannel textChannel : groupServer.textChannels){
            Button button = new Button(textChannel.name);
            button.setTextFill(Color.WHITE);
            button.setPrefWidth(140);
            button.setPrefHeight(30);
            button.setCursor(Cursor.HAND);
            button.setStyle("-fx-background-color :  #2f3136");
            button.setAlignment(Pos.BASELINE_LEFT);
            button.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    button.setStyle("-fx-background-color :  #36393f");
                }
            });
            button.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    button.setStyle("-fx-background-color:  #2f3136");
                }
            });
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    MessageSection.setVisible(true);
                    ChannelName.setText(textChannel.name);
                    client.inTextChannel = textChannel;
                    client.inDirectChat = null;
                    showChatsMessages(client.inTextChannel);
                    SongTab.setVisible(false);
                }
            });
            ChatNames.getChildren().add(button);
        }


        HBox hBox2 = new HBox();
        Text voiceChannelHeader = new Text("Voice Channels");
        voiceChannelHeader.setUnderline(true);
        voiceChannelHeader.setFill(Color.WHITE);
        hBox2.setPadding(new Insets(0, 0, 0, 8));
        hBox2.setAlignment(Pos.CENTER_LEFT);
        hBox2.getChildren().add(voiceChannelHeader);
        ChatNames.getChildren().add(hBox2);
        for ( VoiceChannel voiceChannel : groupServer.voiceChannels){
            VBox VoiceChannelBox = new VBox();
            Button button2 = new Button(voiceChannel.name);
            button2.setTextFill(Color.WHITE);
            button2.setPrefWidth(140);
            button2.setPrefHeight(30);
            button2.setStyle("-fx-background-color: transparent");
            button2.setCursor(Cursor.HAND);
            button2.setAlignment(Pos.BASELINE_LEFT);
            button2.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    button2.setStyle("-fx-background-color:  #36393f");
                }
            });
            button2.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    button2.setStyle("-fx-background-color: transparent");
                }
            });
            button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for ( GroupServer groupServer1 : client.database.groupServers){
                        for ( VoiceChannel voiceChannel1 : groupServer1.voiceChannels){
                            voiceChannel1.onlineUsers.remove(client.user.id);
                        }
                    }
                    CallIcon.setImage(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/RedPhoneIcon.png"));
                    voiceChannel.onlineUsers.add(client.user.id);
                    client.inTextChannel = null;
                    client.sendUpdates();
                    client.inVoiceChannel = voiceChannel;
                    showGroupServerChats(client.groupServer);
                    SongTab.setVisible(true);
                }
            });
            if ( !voiceChannel.onlineUsers.isEmpty()){
                VoiceChannelBox.setSpacing(10);
                VoiceChannelBox.getChildren().add(button2);
                for ( Integer ids : voiceChannel.onlineUsers){
                    HBox hBox1 = new HBox();
                    hBox1.setSpacing(6);
                    hBox1.setAlignment(Pos.CENTER_LEFT);
                    hBox1.setPadding(new Insets(0, 0, 0, 10));
                    Circle circle = new Circle(12);
                    if ( client.getUser(ids).blockedList.contains(client.user.id)){
                        circle.setFill(new ImagePattern(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/BlockedPFP.jpg")));
                    }
                    else{
                        circle.setFill(new ImagePattern(new Image(client.getUser(ids).getPicAddress())));
                    }
                    Text text = new Text(client.getUser(ids).getUsername());
                    text.setFont(Font.font("system", 10));
                    text.setFill(Color.WHITE);
                    hBox1.getChildren().add(circle);
                    hBox1.getChildren().add(text);
                    VoiceChannelBox.getChildren().add(hBox1);
                }
                ChatNames.getChildren().add(VoiceChannelBox);
            }
            else{
                ChatNames.getChildren().add(button2);
            }
        }
    }

    public void DirectMessagesClicked(MouseEvent mouseEvent) {
        ChatOnlines.getChildren().clear();
        showDirectMessages();
        setupGroupServersList();
        MessageSection.setVisible(false);
        AddChat.setVisible(false);
        AddDirectChat.setVisible(true);
        SongTab.setVisible(false);
        client.groupServer = null;
        client.inTextChannel = null;
    }

    public void showDirectMessages (){
        ChatNames.getChildren().clear();
        AddDirectChat.setVisible(true);
        ChatSectionTitle.setText("Direct Messages");
        PrivateMessages.setStrokeWidth(1);
        PrivateMessages.setStroke(Color.WHITE);
        for ( Node node : ListServers.getChildren()){
            ((Rectangle) node).setStrokeWidth(0);
        }
        int counter = 0;
        for ( DirectChat directChat : client.database.directChats){
            if ( directChat.user1 == client.user.id){
                counter++;
                break;
            }
            else if ( directChat.user2 == client.user.id){
                counter++;
                break;
            }
        }
        if ( counter == 0){
            ThereAreNoChats.setVisible(true);
            return;
        }
        ThereAreNoChats.setVisible(false);
        ChatNames.getChildren().clear();
        for ( DirectChat directChat : client.database.directChats){
            if ( directChat.user1 == client.user.id){
                HBox hBox = new HBox();
                hBox.setPadding(new Insets(0, 0, 0, 5));
                hBox.setSpacing(7);
                hBox.setPrefWidth(140);
                hBox.setPrefHeight(43);
                hBox.setAlignment(Pos.CENTER_LEFT);
                hBox.setCursor(Cursor.HAND);
                hBox.setStyle("-fx-background-color :  #2f3136");
                Circle circle = new Circle(15);
                circle.setFill(new ImagePattern( new Image(client.getUser(directChat.user2).getPicAddress())));
                hBox.getChildren().add(circle);
                Text text = new Text(client.getUser(directChat.user2).getUsername());
                text.setFill(Color.WHITE);
                hBox.getChildren().add(text);
                hBox.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        hBox.setStyle("-fx-background-color :  #36393f");
                    }
                });
                hBox.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        hBox.setStyle("-fx-background-color :  #2f3136");
                    }
                });
                hBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        client.inDirectChat = directChat;
                        showDirectMessages(directChat);

                    }
                });
                ChatNames.getChildren().add(hBox);
            }
            else if ( directChat.user2 == client.user.id){
                HBox hBox = new HBox();
                hBox.setPrefWidth(140);
                hBox.setPrefHeight(43);
                hBox.setPadding(new Insets(0, 0, 0, 5));
                hBox.setSpacing(7);
                hBox.setStyle("-fx-background-color :  #2f3136");
                hBox.setAlignment(Pos.CENTER_LEFT);
                hBox.setCursor(Cursor.HAND);
                Circle circle = new Circle(17);
                circle.setFill(new ImagePattern( new Image(client.getUser(directChat.user1).getPicAddress())));
                hBox.getChildren().add(circle);
                Text text = new Text(client.getUser(directChat.user1).getUsername());
                text.setFill(Color.WHITE);
                hBox.getChildren().add(text);
                hBox.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        hBox.setStyle("-fx-background-color :  #36393f");
                    }
                });
                hBox.setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        hBox.setStyle("-fx-background-color :  #2f3136");
                    }
                });
                hBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        client.inDirectChat = directChat;
                        showDirectMessages(directChat);

                    }
                });
                ChatNames.getChildren().add(hBox);

            }
        }

    }
    int modeCounter = 0;
    public void ChangeColorMode(MouseEvent mouseEvent) {
        if ( modeCounter % 2 == 1){
            ColorMode.setImage(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/DarkMode.png"));
        }
        else{
            ColorMode.setImage(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/LightMode.png"));
        }
        modeCounter += 1;
    }

    public void showDirectMessages(DirectChat directChat) {
        MessageVBox.getChildren().clear();
        if ( directChat.user1 == client.user.id){
            ChannelName.setText(client.getUser(directChat.user2).getUsername());
        }
        else{
            ChannelName.setText(client.getUser(directChat.user1).getUsername());
        }
        for (Message message : directChat.messages) {
            HBox hBox = new HBox();
            hBox.setPrefHeight(54);
            hBox.setPrefWidth(530);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setPadding(new Insets(0, 0, 0, 6));
            hBox.setSpacing(5);
            Rectangle rectangle = new Rectangle(3, 46);
            rectangle.setStrokeWidth(0);
            rectangle.setFill(Color.valueOf(client.getUser(message.sender).backGroundColor));
            hBox.getChildren().add(rectangle);
            Circle circle = new Circle(19);
            circle.setStrokeWidth(1);
            circle.setStroke(Color.valueOf(client.getUser(message.sender).backGroundColor));
            circle.setFill(new ImagePattern(new Image(client.getUser(message.sender).getPicAddress())));
            hBox.getChildren().add(circle);
            Text sender = new Text(client.getUser(message.sender).getUsername());

            sender.setFill(Color.WHITE);
            sender.setFont(Font.font("system", FontWeight.BOLD, 12));
            Text content = new Text(message.getContent());
            content.setWrappingWidth(275);
            content.setFill(Color.WHITE);
            VBox vBox = new VBox();
            vBox.setPadding(new Insets(6, 0, 0, 0));
            vBox.setSpacing(4);
            vBox.getChildren().add(sender);
            vBox.getChildren().add(content);
            hBox.getChildren().add(vBox);
            MessageVBox.getChildren().add(hBox);
        }
        MessageSection.setVisible(true);
    }

    public void EditVisible1(MouseEvent mouseEvent) {
        SetNewServerPic.setVisible(true);
        EditCircle1.setVisible(true);
    }

    public void EditInvisible1(MouseEvent mouseEvent) {
        SetNewServerPic.setVisible(false);
        EditCircle1.setVisible(false);
    }

    String newServerPfpAddress = "C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/DefaultServer.jpg";
    public void ChangeServerProfilePic(MouseEvent mouseEvent) {
        List<String> list = new ArrayList<>();
        list.add("*.jpg");
        list.add("*.JPG");
        list.add("*.png");
        list.add("*.PNG");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Picutres", list));
        File file = fileChooser.showOpenDialog(null);
        if ( file != null){
            newServerPfpAddress = file.getAbsolutePath();
            NewServerPfp.setFill(new ImagePattern(new Image(newServerPfpAddress)));
        }
    }


    public void CancelServerMaking(MouseEvent mouseEvent) {
        NewServerName.clear();
        NewServerPfp.setFill(new ImagePattern( new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/DefaultServer.jpg")));
        NewServerTab.setVisible(false);
    }

    public void SaveServerMaking(MouseEvent mouseEvent) {
        GroupServer groupServer = new GroupServer(NewServerName.getText());
        groupServer.id = client.database.groupServers.get(client.database.groupServers.size() - 1).id + 1;
        groupServer.users.add(client.user.id);
        groupServer.owner = client.user.id;
        groupServer.setPicAddress(newServerPfpAddress);
        groupServer.admins.add(client.user.id);
        groupServer.textChannels.add(new TextChannel("general"));
        groupServer.voiceChannels.add(new VoiceChannel("Call"));
        client.database.groupServers.add(groupServer);
        setupGroupServersList();
        client.sendOthergroupServerUpdate();
        CancelServerMaking(mouseEvent);
    }

    public void ShowServerOptions(MouseEvent mouseEvent) {
        ServerOptions.setVisible(true);
    }

    public void MouseEnteredServerAddButton(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-radius: 5;" + "-fx-background-color:  #202225;");
    }

    public void MouseExitedServerAddButton(MouseEvent mouseEvent) {
        ((Button)mouseEvent.getSource()).setStyle("-fx-background-radius: 5;" + "-fx-background-color: transparent;");
    }

    public void CreateServer(MouseEvent mouseEvent) {
        SetNewServerPic.setVisible(false);
        EditCircle1.setVisible(false);
        NewServerPfp.setFill(new ImagePattern( new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/DefaultServer.jpg")));
        NewServerTab.setVisible(true);
        ServerOptions.setVisible(false);
    }

    public void ShowServerDetails(MouseEvent mouseEvent) {
        if ( !ChatSectionTitle.getText().equals("Direct Messages")){
            for ( GroupServer groupServer : client.database.groupServers){
                if ( groupServer.name.equals(ChatSectionTitle.getText()) && !groupServer.isAdmin(client.user.id)){
                    ServerDetailsPic.setFill(new ImagePattern(new Image(groupServer.picAddress)));
                    ServerDetailsName.setText(groupServer.name);
                    ServerDetailsForMember.setVisible(true);
                    break;
                }
                else if (groupServer.name.equals(ChatSectionTitle.getText()) && (groupServer.isAdmin(client.user.id)) && (groupServer.owner != client.user.id)){
                    client.groupServer = groupServer;
                    showServerEditForAdmin(client.groupServer);
                }
                else if (groupServer.name.equals(ChatSectionTitle.getText()) && (groupServer.owner == client.user.id)){
                    client.groupServer = groupServer;
                    showServerEditForOwner(client.groupServer);
                }
            }
        }
    }

    public void CloseServerDetailForMember(MouseEvent mouseEvent) {
        ServerDetailsForMember.setVisible(false);
        SearchToAddMemberField.clear();
        AddMemberSearchResult1.setVisible(false);
        client.sendOthergroupServerUpdate();
        setupGroupServersList();
        DirectMessagesClicked(mouseEvent);
    }

    public void SearchServerButtonClicked(MouseEvent mouseEvent) {
        int cnt = 0;
        ServerSearchResult.getChildren().clear();
        NoResultServerPic.setVisible(false);
        NoResultServerText.setVisible(false);
        for ( GroupServer groupServer : client.database.groupServers){
            if ( SearchServerField.getText().toLowerCase(Locale.ROOT).equals(groupServer.name.toLowerCase(Locale.ROOT)) && !groupServer.isInServer(client.user.id)){
                HBox hBox = new HBox();
                hBox.setPadding(new Insets(0, 0, 0, 10));
                hBox.setAlignment(Pos.CENTER_LEFT);
                hBox.setSpacing(10);
                Circle circle = new Circle(24);
                circle.setFill(new ImagePattern(new Image(groupServer.picAddress)));
                Text text = new Text(groupServer.name);
                text.setFont(Font.font("arial", 16));
                text.setFill(Color.WHITE);
                Button button = new Button("Join");
                button.setTextFill(Color.WHITE);
                button.setStyle("-fx-background-color:  #7289da");
                button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        groupServer.users.add(client.user.id);
                        if ( groupServer.users.contains(0)){
                            Message message = new Message("Welcome " + client.user.getUsername() + "!", 0);
                            if ( !groupServer.textChannels.isEmpty()){
                                groupServer.textChannels.get(0).messages.add(message);
                            }
                        }
                        ServerSearchScroll.setVisible(false);
                        client.sendOthergroupServerUpdate();
                        setupGroupServersList();
                    }
                });
                button.setCursor(Cursor.HAND);
                hBox.getChildren().add(circle);
                hBox.getChildren().add(text);
                hBox.getChildren().add(button);
                ServerSearchResult.getChildren().add(hBox);
                cnt++;
            }
        }
        if ( cnt == 0){
            ServerSearchScroll.setVisible(false);
            NoResultServerPic.setVisible(true);
            NoResultServerText.setVisible(true);
            return;
        }
        ServerSearchScroll.setVisible(true);
    }

    public void CloseJoinServer(MouseEvent mouseEvent) {
        SearchServerField.clear();
        JoinServerTab.setVisible(false);
        ServerSearchScroll.setVisible(false);
        NoResultServerPic.setVisible(false);
        NoResultServerText.setVisible(false);
    }

    public void OpenJoinServer(MouseEvent mouseEvent) {
        JoinServerTab.setVisible(true);
        ServerOptions.setVisible(false);
    }

    public void EditVisible2(MouseEvent mouseEvent) {
        EditCircle2.setVisible(true);
        EditServerPicText.setVisible(true);
    }

    public void EditInvisible2(MouseEvent mouseEvent) {
        EditCircle2.setVisible(false);
        EditServerPicText.setVisible(false);
    }
    int ServerNameEditButtonCounter = 0;
    public void EditServerNameButtonClicked(MouseEvent mouseEvent) {
        if ( ServerNameEditButtonCounter % 2 == 0){
            EditServerNameField.setVisible(true);
            EditServerNameButton.setText("Ok");
            EditServerNameButton.setStyle("-fx-background-color: #7289da;");
            ServerNameEditButtonCounter++;
        }
        //Server Name Change Saved
        else{
            EditServerNameField.setVisible(false);
            EditServerNameButton.setText("Edit");
            EditServerNameButton.setStyle("-fx-background-color:  #555a63;");
            ServerNameEditButtonCounter++;
            EditServerNameDisplayer.setText(EditServerNameField.getText());
            client.groupServer.name = EditServerNameDisplayer.getText();
            client.sendUpdates();
            EditServerNameField.clear();
        }
    }

    public void showServerEditForAdmin(GroupServer groupServer){
        ServerEditTab.setVisible(false);
        EditServerNameField.clear();
        EditServerNameDisplayer.setText(groupServer.name);
        EditServerPic.setFill(new ImagePattern(new Image(groupServer.picAddress)));
        ServerEditTab.setVisible(true);
    }
    public void showServerEditForOwner(GroupServer groupServer){
        ServerEditTab.setVisible(false);
        EditServerNameField.clear();
        EditServerNameDisplayer.setText(groupServer.name);
        EditServerPic.setFill(new ImagePattern(new Image(groupServer.picAddress)));
        ServerEditTab.setVisible(true);
        DeleteServerButton.setVisible(true);
    }

    public void CloseServerEditTab(MouseEvent mouseEvent) {
        ServerEditTab.setVisible(false);
        SearchUserInEditServerField.clear();
        setupGroupServersList();
        SearchUsernameResult.setVisible(false);
        AddUserField.clear();
        AddMemberSearchResult.setVisible(false);
        SearchUserInEditServerField.clear();
        SearchChannelInEditServer.clear();
        DirectMessagesClicked(mouseEvent);

    }

    String editedServerProfilePic = null;
    public void EditServerProfilePic(MouseEvent mouseEvent) {
        List<String> list = new ArrayList<>();
        list.add("*.jpg");
        list.add("*.JPG");
        list.add("*.png");
        list.add("*.PNG");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Picutres", list));
        File file = fileChooser.showOpenDialog(null);
        if ( file != null){
            editedServerProfilePic = file.getAbsolutePath();
            EditServerPic.setFill(new ImagePattern( new Image(editedServerProfilePic)));
        }
    }

    public void SaveServerEdit(MouseEvent mouseEvent) {
        if (editedServerProfilePic != null) {
            client.groupServer.picAddress = editedServerProfilePic;
        }
        client.groupServer.name = EditServerNameDisplayer.getText();
        SearchUsernameResult.setVisible(false);
        SearchUserInEditServerField.clear();
        CloseServerEditTab(mouseEvent);
        setupGroupServersList();
    }

    public void SearchUsernameInServerEditbuttonClicked(MouseEvent mouseEvent) {
        String targetUsername = SearchUserInEditServerField.getText().toLowerCase(Locale.ROOT);
        for ( Integer integer : client.groupServer.users){
            User user = client.getUser(integer);
            if ( user.getUsername().equals(targetUsername)){
                SearchedUserUsername.setText(targetUsername);
                SearchedUserPic.setFill(new ImagePattern(new Image(user.getPicAddress())));
                SearchUsernameResult.setVisible(true);
                if ( client.user.id == client.groupServer.owner){
                    if ( client.groupServer.isAdmin(user.id)){
                        PromoteMemberButton.setVisible(false);
                        DemoteMemberButton.setVisible(true);
                        KickMemberButton.setVisible(true);
                    }
                    else{
                        PromoteMemberButton.setVisible(true);
                        DemoteMemberButton.setVisible(true);
                        KickMemberButton.setVisible(true);
                    }
                }
                else{
                    if ( client.groupServer.isAdmin(user.id) || user.id == client.groupServer.owner){
                        PromoteMemberButton.setVisible(false);
                        DemoteMemberButton.setVisible(false);
                        KickMemberButton.setVisible(false);
                    }
                    else{
                        PromoteMemberButton.setVisible(true);
                        DemoteMemberButton.setVisible(true);
                        KickMemberButton.setVisible(true);
                    }
                }
                break;
            }
        }
    }

    public void SearchChannelInServerEditbuttonClicked(MouseEvent mouseEvent) {
        for ( TextChannel textChannel : client.groupServer.textChannels){
            if ( String.format("# " + SearchChannelInEditServer.getText().toLowerCase(Locale.ROOT)).equals(textChannel.name)){
                ChannelSearchResult.setText("# " + SearchChannelInEditServer.getText());
                ChannelSearchResulttab.setVisible(true);
                SearchChannelInEditServer.clear();
                return;
            }
        }
        for ( VoiceChannel voiceChannel : client.groupServer.voiceChannels){
            if ( SearchChannelInEditServer.getText().toLowerCase(Locale.ROOT).equals(voiceChannel.name.toLowerCase(Locale.ROOT))){
                ChannelSearchResult.setText(SearchChannelInEditServer.getText());
                ChannelSearchResulttab.setVisible(true);
                SearchChannelInEditServer.clear();
                return;
            }
        }

    }

    public void KickMemberButtonClicked(MouseEvent mouseEvent) {
        int resultId = 0;
        for ( User user : client.database.users){
            if ( user.getUsername().equals(SearchedUserUsername.getText())){
                resultId = user.id;
            }
        }
        client.groupServer.admins.remove(resultId);
        client.groupServer.users.remove(resultId);
        SearchUsernameResult.setVisible(false);
        SearchUserInEditServerField.clear();
        client.sendUpdates();
    }

    public void DemoteMemberButtonClicked(MouseEvent mouseEvent) {
        int resultId = 0;
        for ( User user : client.database.users){
            if ( user.getUsername().equals(SearchedUserUsername.getText())){
                resultId = user.id;
            }
        }
        client.groupServer.admins.remove(resultId);
        client.sendUpdates();
        SearchUsernameResult.setVisible(false);
        SearchUserInEditServerField.clear();
    }

    public void PromoteMemberButtonClicked(MouseEvent mouseEvent) {
        int resultId = 0;
        int index = 0;
        for ( User user : client.database.users){
            if ( user.getUsername().equals(SearchedUserUsername.getText())){
                resultId = user.id;
            }
        }
        client.groupServer.admins.add(resultId);
        client.sendUpdates();
        SearchUsernameResult.setVisible(false);
        SearchUserInEditServerField.clear();
    }

    public void ShowFriendRequests(MouseEvent mouseEvent) {
        ListFriend.getChildren().clear();
        FriendTitle.setText("Friend Request");
        FriendsTab.setVisible(true);
        CloseSettingOnClick(mouseEvent);
        if ( client.user.requestList == null || client.user.requestList.isEmpty()){
            NoFriendsText.setText("You dont have any friend requests yet");
            NoFriendsTab.setVisible(true);
            return;
        }
        NoFriendsTab.setVisible(false);
        for ( Integer id : client.user.requestList){
            User user = client.getUser(id);
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(15);
            hBox.setPadding(new Insets(0, 0, 0, 10));
            Circle circle = new Circle(20);
            circle.setFill(new ImagePattern(new Image(user.getPicAddress())));
            hBox.getChildren().add(circle);
            Circle circle1 = new Circle(7);
            HBox.setMargin(circle1, new Insets(25, 0, 0, -28));
            circle1.setStroke(Color.valueOf("#424549"));
            circle1.setStrokeWidth(3);
            if ( user.getStatus().equals("ONLINE")){
                circle1.setFill(Color.valueOf("#13d931"));
            }
            else if (user.getStatus().equals("OFFLINE")){
                circle1.setFill(Color.valueOf("#7d8b99"));
            }
            else {
                circle1.setFill(Color.valueOf("#ffd300"));
            }
            hBox.getChildren().add(circle1);
            Text text = new Text(user.getUsername());
            text.setFont(Font.font("arial", 15));
            text.setFill(Color.WHITE);
            hBox.getChildren().add(text);
            Button button = new Button("Accept");
            button.setStyle("-fx-background-color: #0da125");
            button.setTextFill(Color.WHITE);
            button.setCursor(Cursor.HAND);
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    client.user.requestList.remove(id);
                    client.user.friendList.add(id);
                    if ( client.user.blockedList.contains(id)){
                        client.user.blockedList.remove(id);
                    }
                    client.addOtherFriendSide(id, client.user.id);
                    client.sendUpdateUser();
                    ShowFriendRequests(mouseEvent);

                }
            });
            hBox.getChildren().add(button);
            Button button2 = new Button("Decline");
            button2.setStyle("-fx-background-color:      #df0303");
            button2.setTextFill(Color.WHITE);
            button2.setCursor(Cursor.HAND);
            button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    client.user.requestList.remove(id);
                    client.sendUpdateUser();
                    ShowFriendRequests(mouseEvent);
                }
            });
            hBox.getChildren().add(button2);
            ListFriend.getChildren().add(hBox);
        }
    }

    public void OpenAddFriendTab(MouseEvent mouseEvent) {
        SearchUserTab.setVisible(true);
    }

    public void BlockUser(MouseEvent mouseEvent) {
        int index = -1;
        for ( User user : client.database.users){
            if ( user.getUsername().equals(SearchUserField.getText().toLowerCase(Locale.ROOT))){
                client.user.blockedList.add(user.id);
                client.user.friendList.remove(user.id);
                client.removeOtherFriendSide(user.id, client.user.id);
                for ( DirectChat directChat : client.database.directChats){
                    if ( directChat.user1 == user.id && directChat.user2 == client.user.id || directChat.user2 == user.id && directChat.user1 == client.user.id){
                        index = client.database.directChats.indexOf(directChat);
                        break;
                    }
                }
                if ( index != -1){
                    client.database.directChats.remove(index);
                }
            }
        }
        client.sendUpdates();
        AddFriendResult.setVisible(false);
        BlockButton.setVisible(false);
        FriendRequestButton.setVisible(false);
    }

    public void SendFriendReq(MouseEvent mouseEvent) {
        for ( User user : client.database.users){
            if ( user.getUsername().equals(SearchUserField.getText().toLowerCase(Locale.ROOT))){
                if ( !user.blockedList.contains(client.user.id)){
                    user.requestList.add(client.user.id);
                }
                break;
            }
        }
        client.sendUpdateUser();
        AddFriendResult.setVisible(false);
        BlockButton.setVisible(false);
        FriendRequestButton.setVisible(false);
    }

    public void CloseSearchUserTab(MouseEvent mouseEvent) {
        SearchUserTab.setVisible(false);
        SearchUserField.clear();
        SearchUsernameResult.setVisible(false);
        NoResultUserPic.setVisible(false);
        NoResultUserText.setVisible(false);
        AddFriendResult.setVisible(false);
        BlockButton.setVisible(false);
        FriendRequestButton.setVisible(false);
    }

    public void UserSearchButtonClicked(MouseEvent mouseEvent) {
        User target = null;
        int id = 0;
        int found = 0;
        for (User user : client.database.users){
            if ( user.getUsername().equals(SearchUserField.getText().toLowerCase(Locale.ROOT)) && !user.blockedList.contains(client.user.id)){
                target = user;
                id = user.id;
                found++;
                break;
            }
        }
        if ( found == 1){
            NoResultUserText.setVisible(false);
            NoResultUserPic.setVisible(false);
            AddFriendResult.setVisible(true);
            UserSearchResultPic.setFill(new ImagePattern(new Image(target.getPicAddress())));
            UserSearchResultName.setText(target.getUsername());
            if ( !client.user.friendList.contains(id)){
                FriendRequestButton.setVisible(true);
            }
            if ( !client.user.blockedList.contains(id)){
                BlockButton.setVisible(true);
            }
        }
        else {
            AddFriendResult.setVisible(false);
            BlockButton.setVisible(false);
            FriendRequestButton.setVisible(false);
            NoResultUserText.setVisible(true);
            NoResultUserPic.setVisible(true);
        }

    }

    public void LeaveServer(MouseEvent mouseEvent) {
        for ( GroupServer groupServer : client.database.groupServers){
            if ( groupServer.id == client.groupServer.id){
                groupServer.users.remove(client.user.id);
                break;
            }
        }
        client.groupServer = null;
        client.sendOthergroupServerUpdate();
        DirectMessagesClicked(mouseEvent);
        ServerDetailsForMember.setVisible(false);
        setupGroupServersList();
    }

    public void DeleteServer (MouseEvent mouseEvent){
        GroupServer target = null;
        for ( GroupServer groupServer : client.database.groupServers){
            if ( groupServer.id == client.groupServer.id){
                target = groupServer;
                break;
            }
        }
        client.database.groupServers.remove(client.getIndexBuyObject(target));
        client.sendOthergroupServerUpdate();
        ServerEditTab.setVisible(false);
        DirectMessagesClicked(mouseEvent);
        setupGroupServersList();
    }


    public void ShowBlocked(MouseEvent mouseEvent) {
        ListFriend.getChildren().clear();
        FriendTitle.setText("Blocked");
        FriendsTab.setVisible(true);
        CloseSettingOnClick(mouseEvent);
        if ( client.user.blockedList == null || client.user.blockedList.isEmpty()){
            NoFriendsText.setText("You havent blocked anyone yet");
            NoFriendsTab.setVisible(true);
            return;
        }
        NoFriendsTab.setVisible(false);
        for ( Integer id : client.user.blockedList){
            User user = client.getUser(id);
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setSpacing(15);
            hBox.setPadding(new Insets(0, 0, 0, 10));
            Circle circle = new Circle(20);
            circle.setFill(new ImagePattern(new Image(user.getPicAddress())));
            hBox.getChildren().add(circle);
            Text text = new Text(user.getUsername());
            text.setFont(Font.font("arial", 15));
            text.setFill(Color.WHITE);
            hBox.getChildren().add(text);
            Button button = new Button("Unblock");
            button.setStyle("-fx-background-color:    #2f3136");
            button.setTextFill(Color.WHITE);
            button.setCursor(Cursor.HAND);
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    client.user.blockedList.remove(id);
                    client.sendUpdateUser();
                    ShowBlocked(mouseEvent);
                }
            });
            hBox.getChildren().add(button);
            ListFriend.getChildren().add(hBox);
        }
    }

    public void AddMemberToServer(MouseEvent mouseEvent) {
        client.groupServer.users.add(idForAdding);
        AddMemberSearchResult1.setVisible(false);
        SearchToAddMemberField.clear();
        client.sendOthergroupServerUpdate();
    }


    int idForAdding;
    public void AddMemberSearchButtonClicked(MouseEvent mouseEvent) {
        User target = null;

        int found = 0;
        for (User user : client.database.users){
            if ( user.getUsername().equals(SearchToAddMemberField.getText().toLowerCase(Locale.ROOT)) && !user.blockedList.contains(client.user.id)){
                target = user;
                idForAdding = user.id;
                found++;
                break;
            }
        }
        if ( found == 1){
            AddMemberName1.setText(target.getUsername());
            AddMemberPic1.setFill(new ImagePattern(new Image(target.getPicAddress())));
            AddMemberSearchResult1.setVisible(true);
        }
    }

    public void AddMemberToServerEdit(MouseEvent mouseEvent) {
        client.groupServer.users.add(AddUserId);
        client.sendUpdates();
        AddMemberSearchResult.setVisible(false);
        AddUserField.clear();
    }

    int AddUserId;
    public void SearchUsernameInServerEditbuttonClickedForAdd(MouseEvent mouseEvent) {
        int found = 0;
        
        User target = null;
            for ( User user1 : client.database.users){
                if ( user1.getUsername().equals(AddUserField.getText().toLowerCase(Locale.ROOT)) && !client.groupServer.users.contains(user1.id)){
                    if ( user1.blockedList.contains(client.user.id)){
                        break;
                    }
                    AddUserId = user1.id;
                    target = user1;
                    found = 1;
                }
            }
            if ( found == 1){
                AddMemberPic.setFill(new ImagePattern(new Image(target.getPicAddress())));
                AddMemberName.setText(target.getUsername());
                AddMemberSearchResult.setVisible(true);
            }
    }


    public void AddChatClicked(MouseEvent mouseEvent) {
        AddChannelTab.setVisible(true);
        AddTextChannelField.clear();
        AddVoiceChannelField.clear();
    }
    public void CloseAddChannelTab(MouseEvent mouseEvent) {
        AddChannelTab.setVisible(false);
    }

    public void AddTextChannel(MouseEvent mouseEvent) {
        client.groupServer.textChannels.add(new TextChannel(AddTextChannelField.getText().toLowerCase(Locale.ROOT)));
        AddTextChannelField.clear();
        client.sendUpdates();
        showGroupServerChats(client.groupServer);
    }

    public void AddVoiceChannel(MouseEvent mouseEvent) {
        client.groupServer.voiceChannels.add(new VoiceChannel(AddVoiceChannelField.getText()));
        AddVoiceChannelField.clear();
        client.sendUpdates();
        showGroupServerChats(client.groupServer);
    }

    public void showChatsMessages(TextChannel textChannel){
        MessageVBox.getChildren().clear();
        if ( textChannel.pinMessage != null){
            PinPic.setFill(new ImagePattern(new Image(client.getUser(textChannel.pinMessage.sender).getPicAddress())));
            PinContent.setText(textChannel.pinMessage.getContent());
            PinUsername.setText(client.getUser(textChannel.pinMessage.sender).getUsername());
            Pinbar.setVisible(true);
        }
        for ( Message message : textChannel.messages){
            HBox hBox = new HBox();
            hBox.setPrefHeight(54);
            hBox.setPrefWidth(530);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setPadding(new Insets(0, 0, 0, 6));
            hBox.setSpacing(7);
            Rectangle rectangle = new Rectangle(3, 46);
            rectangle.setStrokeWidth(0);
            Circle circle = new Circle(19);
            circle.setStrokeWidth(1);
            if (!client.getUser(message.sender).blockedList.contains(client.user.id)){
                circle.setStroke(Color.valueOf(client.getUser(message.sender).backGroundColor));
                circle.setFill(new ImagePattern(new Image(client.getUser(message.sender).getPicAddress())));
                rectangle.setFill(Color.valueOf(client.getUser(message.sender).backGroundColor));
            }
            else{
                circle.setStroke(Color.valueOf("#9c9c9c"));
                circle.setFill(new ImagePattern(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/BlockedPFP.jpg")));
                rectangle.setFill(Color.valueOf("#9c9c9c"));
            }
            hBox.getChildren().add(rectangle);
            hBox.getChildren().add(circle);
            Text sender = new Text(client.getUser(message.sender).getUsername());

            sender.setFill(Color.WHITE);
            sender.setFont(Font.font("system", FontWeight.BOLD, 12));
            Text content = new Text(message.getContent());
            content.setCursor(Cursor.HAND);
            content.setWrappingWidth(275);
            content.setFill(Color.WHITE);
            VBox vBox = new VBox();
            vBox.setPadding(new Insets(6, 0, 0, 0));
            vBox.setSpacing(4);
            vBox.getChildren().add(sender);
            vBox.getChildren().add(content);
            hBox.getChildren().add(vBox);
            VBox Like = new VBox();
            Like.setSpacing(3);
            Like.setAlignment(Pos.CENTER);
            ImageView likeImage = new ImageView(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/LikeEmoji.png"));
            likeImage.setFitHeight(12);
            likeImage.setFitWidth(12);
            likeImage.setCursor(Cursor.HAND);
            likeImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if ( message.likes.contains(client.user.id)){
                        message.likes.remove(client.user.id);
                    }
                    else{
                        message.likes.add(client.user.id);
                    }
                    client.sendOthergroupServerUpdate();
                    showChatsMessages(client.inTextChannel);
                }
            });
            Like.getChildren().add(likeImage);
            Text text = new Text(String.valueOf(message.likes.size()));
            text.setFill(Color.WHITE);
            Like.getChildren().add(text);
            hBox.getChildren().add(Like);
            VBox DisLike = new VBox();
            DisLike.setSpacing(3);
            DisLike.setAlignment(Pos.CENTER);
            ImageView disLikeImage = new ImageView(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/DisLikeEmoji.png"));
            disLikeImage.setFitHeight(12);
            disLikeImage.setFitWidth(12);
            disLikeImage.setCursor(Cursor.HAND);
            disLikeImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if ( message.dislikes.contains(client.user.id)){
                        message.dislikes.remove(client.user.id);
                    }
                    else {
                        message.dislikes.add(client.user.id);
                    }
                    client.sendOthergroupServerUpdate();
                    showChatsMessages(client.inTextChannel);
                }
            });
            DisLike.getChildren().add(disLikeImage);
            Text textDis = new Text(String.valueOf(message.dislikes.size()));
            textDis.setFill(Color.WHITE);
            DisLike.getChildren().add(textDis);
            hBox.getChildren().add(DisLike);
            VBox Heart = new VBox();
            Heart.setSpacing(3);
            Heart.setAlignment(Pos.CENTER);
            ImageView heartImage = new ImageView(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/HeartEmoji.png"));
            heartImage.setFitHeight(12);
            heartImage.setFitWidth(12);
            heartImage.setCursor(Cursor.HAND);
            heartImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    if ( message.heart.contains(client.user.id)){
                        message.heart.remove(client.user.id);
                    }
                    else{
                        message.heart.add(client.user.id);
                    }
                    client.sendOthergroupServerUpdate();
                    showChatsMessages(client.inTextChannel);
                }
            });
            Heart.getChildren().add(heartImage);
            Text textHeart = new Text(String.valueOf(message.heart.size()));
            textHeart.setFill(Color.WHITE);
            Heart.getChildren().add(textHeart);
            hBox.getChildren().add(Heart);
            if ( client.user.id == client.groupServer.owner || client.groupServer.admins.contains(client.user.id)){
                Circle circle1 = new Circle(8);
                HBox.setMargin(circle1, new Insets(0, 0, 0, 6));
                circle1.setFill(new ImagePattern(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/PinIcon.png")));
                circle1.setCursor(Cursor.HAND);
                circle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        PinPic.setFill(new ImagePattern(new Image(client.getUser(message.sender).getPicAddress())));
                        PinContent.setText(message.getContent());
                        PinUsername.setText(client.getUser(message.sender).getUsername());
                        Pinbar.setVisible(true);
                        for ( TextChannel textChannel1 : client.groupServer.textChannels){
                            if ( textChannel1.name == client.inTextChannel.name){
                                textChannel1.pinMessage = message;
                                client.sendUpdates();
                            }
                        }
                    }
                });
                hBox.getChildren().add(circle1);
            }
            MessageVBox.getChildren().add(hBox);
        }
        MessageSection.setVisible(true);

    }

    public void SelectFileToSend(MouseEvent mouseEvent) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if ( file != null){
            SendMessageField.setText(file.getAbsolutePath());
        }
    }

    int timesCLicked = 0;
    public void EditChannelName(MouseEvent mouseEvent) {
        if ( timesCLicked % 2 == 0){
            ((Button) mouseEvent.getSource()).setText("Save");
            ((Button) mouseEvent.getSource()).setStyle("-fx-background-color:  #0da125");
            NewChannelNamefield.setVisible(true);
            timesCLicked++;
        }
        else{
            ((Button) mouseEvent.getSource()).setText("Edit");
            ((Button) mouseEvent.getSource()).setStyle("-fx-background-color:  #555a63");

            for ( TextChannel textChannel : client.groupServer.textChannels){
                if (ChannelSearchResult.getText().equals(textChannel.name)){
                    textChannel.name = "# " + NewChannelNamefield.getText();
                    if ( client.inTextChannel != null && client.inTextChannel.name.equals(ChannelSearchResult.getText().toLowerCase(Locale.ROOT))){
                        client.inTextChannel.name = "# " + NewChannelNamefield.getText();
                    }
                    client.sendUpdates();
                    NewChannelNamefield.setVisible(false);
                }
            }
            for ( VoiceChannel voiceChannel : client.groupServer.voiceChannels){
                if ( ChannelSearchResult.getText().equals(voiceChannel.name)){
                    voiceChannel.name = NewChannelNamefield.getText();
                    if ( client.inVoiceChannel != null && client.inVoiceChannel.name.equals(ChannelSearchResult.getText())){
                        client.inVoiceChannel.name = NewChannelNamefield.getText();
                    }
                    client.sendUpdates();
                    NewChannelNamefield.setVisible(false);
                }
            }
            ChannelSearchResulttab.setVisible(false);

        }
    }

    public void DeleteChannel(MouseEvent mouseEvent) {
        int index = -1;
        for ( TextChannel textChannel : client.groupServer.textChannels){
            if (ChannelSearchResult.getText().equals(textChannel.name)){
                index = client.groupServer.textChannels.indexOf(textChannel);
                System.out.println("Found");
            }
        }
        if ( index != -1){
            client.groupServer.textChannels.remove(index);
            System.out.println("Deleted");
            client.sendUpdates();
            ChannelSearchResulttab.setVisible(false);
            return;
        }
        for ( VoiceChannel voiceChannel : client.groupServer.voiceChannels){
            if ( ChannelSearchResult.getText().equals(voiceChannel.name)){
                index = client.groupServer.voiceChannels.indexOf(voiceChannel);
            }
        }
        if ( index != -1){
            client.groupServer.voiceChannels.remove(index);
            client.sendUpdates();
            ChannelSearchResulttab.setVisible(false);
            return;
        }
        ChannelSearchResulttab.setVisible(false);
    }

    public void PhoneClicked(MouseEvent mouseEvent) {
        CallIcon.setImage(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/PhoneIcon.png"));
        for ( GroupServer groupServer : client.database.groupServers){
            for ( VoiceChannel voiceChannel : groupServer.voiceChannels){
                voiceChannel.onlineUsers.remove(client.user.id);
            }
        }
        client.sendOthergroupServerUpdate();
        client.inVoiceChannel = null;
        if ( songPlayer != null){
            songPlayer.stop();
        }
        if ( timer != null){
            endTimer();
        }
        songPlayer = null;
        songs = null;
        list = null;
        SongName.setText("Song name");
        MuteIcon.setImage(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/Mute.png"));
        SongTab.setVisible(false);
        showGroupServerChats(client.groupServer);
    }

    public void SendMessage(MouseEvent mouseEvent) {
        if ( SendMessageField.getText().equals("") || SendMessageField.getText() == null){
            return;
        }
        Message message = new Message(SendMessageField.getText(), client.user.id);
        if ( client.inTextChannel != null){
            for ( TextChannel textChannel : client.groupServer.textChannels){
                if ( textChannel.name.equals(client.inTextChannel.name)){
                     textChannel.messages.add(message);
                     if ( message.getContent().toLowerCase(Locale.ROOT).equals("!status") && client.groupServer.users.contains(0)){
                         Message message1 = new Message(Bot.getInfo(client.groupServer, client.database.users), 0);
                         textChannel.messages.add(message1);
                     }
                     else if ( message.getContent().toLowerCase(Locale.ROOT).equals("!rank") && client.groupServer.users.contains(0)){
                         Message message1 = new Message(Bot.getRanks(client.groupServer, client.database.users), 0);
                         textChannel.messages.add(message1);
                     }
                     break;
                }
            }
            client.sendUpdates();
            showChatsMessages(client.inTextChannel);
            SendMessageField.clear();
        }
        else {
            for ( DirectChat directChat : client.database.directChats){
                if ( client.inDirectChat.id == directChat.id){
                    directChat.messages.add(message);
                    break;
                }
            }
            client.sendUpdates();
            showDirectMessages(client.inDirectChat);
            SendMessageField.clear();
        }

    }

    public void Unpin(MouseEvent mouseEvent) {
        if ( client.inTextChannel.pinMessage != null && (client.groupServer.isAdmin(client.user.id) || client.user.id == client.groupServer.owner)){
            for ( TextChannel textChannel : client.groupServer.textChannels){
                if ( textChannel.name.equals(client.inTextChannel.name)){
                    textChannel.pinMessage = null;
                    Pinbar.setVisible(false);
                    client.sendUpdates();
                    showChatsMessages(client.inTextChannel);
                    return;
                }
            }
        }
    }
    int tagCount = 0;
    AudioClip audioClip = new AudioClip(Paths.get("C:/Users/user/Desktop/notif.mp3").toUri().toString());

    public void NotifSoundSender(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for ( GroupServer groupServer : client.database.groupServers){
                    for ( TextChannel textChannel : groupServer.textChannels){
                        for ( Message message : textChannel.messages){
                            if ( message.getContent().contains("@" + client.user.getUsername())){
                                tagCount++;
                            }
                        }
                    }
                }
                while (true){
                    try {
                        int counter = 0;
                        for ( GroupServer groupServer : client.database.groupServers){
                            for ( TextChannel textChannel : groupServer.textChannels){
                                for ( Message message : textChannel.messages){
                                    if ( message.getContent().contains("@" + client.user.getUsername())){
                                        counter++;
                                    }
                                }
                            }
                        }
                        if ( counter != tagCount && !client.user.getStatus().equals("DO NOT DISTURB")){
                            audioClip.play();
                            tagCount = counter;
                        }
                    }catch (Exception ignored){
                    }

                }
            }
        }).start();
    }

    public void EnterToSend(KeyEvent keyEvent) {
        if ( keyEvent.getCode().equals(KeyCode.ENTER)){
            if ( SendMessageField.getText().equals("") || SendMessageField.getText() == null){
                return;
            }
            Message message = new Message(SendMessageField.getText(), client.user.id);
            if ( client.inTextChannel != null){
                for ( TextChannel textChannel : client.groupServer.textChannels){
                    if ( textChannel.name.equals(client.inTextChannel.name)){
                        textChannel.messages.add(message);
                        if ( message.getContent().toLowerCase(Locale.ROOT).equals("!status") && client.groupServer.users.contains(0)){
                            Message message1 = new Message(Bot.getInfo(client.groupServer, client.database.users), 0);
                            textChannel.messages.add(message1);
                        }
                        else if ( message.getContent().toLowerCase(Locale.ROOT).equals("!rank") && client.groupServer.users.contains(0)){
                            Message message1 = new Message(Bot.getRanks(client.groupServer, client.database.users), 0);
                            textChannel.messages.add(message1);
                        }
                    }
                }
                client.sendUpdates();
                showChatsMessages(client.inTextChannel);
                SendMessageField.clear();
            }
            else {
                for ( DirectChat directChat1 : client.database.directChats){
                    if ( directChat1.id == client.inDirectChat.id){
                        directChat1.messages.add(message);
                    }
                }
                client.sendUpdates();
                showDirectMessages(client.inDirectChat);
                SendMessageField.clear();
            }

        }
    }

    public void RefreshEverything(MouseEvent mouseEvent) {
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(750) , RefreshButton);
        rotateTransition.setByAngle(360);
        rotateTransition.setInterpolator(Interpolator.EASE_BOTH);
        rotateTransition.play();
        if ( client.inTextChannel != null){
            showChatsMessages(client.inTextChannel);
        }
        if ( client.inDirectChat != null){
            showDirectMessages(client.inDirectChat);
        }
        if ( client.groupServer != null){
            showGroupServersOnlines(client.groupServer);
            showGroupServerChats(client.groupServer);
        }


    }

    public void showName(MouseEvent mouseEvent) {
        RefreshText.setVisible(true);
    }

    public void dontShowName(MouseEvent mouseEvent) {
        RefreshText.setVisible(false);
    }
    public void SelectSong(MouseEvent mouseEvent) {
        songNumber = 0;
        if ( list != null){
            pauseSong();
            songPlayer.stop();
            SongName.setText("Song name");
            list = null;
        }
        List<String> listFilter = new ArrayList<>();
        listFilter.add("*.mp3");
        listFilter.add("*.MP3");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Picutres", listFilter));
        list = fileChooser.showOpenMultipleDialog(null);
        if ( list != null){
            songs = new Media(list.get(songNumber).toURI().toString());
            songPlayer = new MediaPlayer(songs);
            SongName.setText(list.get(songNumber).getName().replace(".mp3", ""));
        }

    }

    public void NextSong(MouseEvent mouseEvent) {
        if ( songNumber < list.size() - 1){
            songNumber++;
            songPlayer.stop();
            if ( running){
                endTimer();
            }
            songs = new Media(list.get(songNumber).toURI().toString());
            songPlayer = new MediaPlayer(songs);
            SongName.setText(list.get(songNumber).getName().replace(".mp3", ""));
            playSong();
        }
        else{
            songNumber = 0;
            songPlayer.stop();
            if ( running){
                endTimer();
            }
            songs = new Media(list.get(songNumber).toURI().toString());
            songPlayer = new MediaPlayer(songs);
            SongName.setText(list.get(songNumber).getName().replace(".mp3", ""));
            playSong();
        }
    }

    public void PreviousSong(MouseEvent mouseEvent) {
        if ( songNumber > 0){
            songNumber--;
            songPlayer.stop();
            if ( running){
                endTimer();
            }
            songs = new Media(list.get(songNumber).toURI().toString());
            songPlayer = new MediaPlayer(songs);
            SongName.setText(list.get(songNumber).getName().replace(".mp3", ""));
            playSong();
        }
        else{
            songNumber = list.size() - 1;
            songPlayer.stop();
            if ( running){
                endTimer();
            }
            songs = new Media(list.get(songNumber).toURI().toString());
            songPlayer = new MediaPlayer(songs);
            SongName.setText(list.get(songNumber).getName().replace(".mp3", ""));
            playSong();
        }
    }

    int SongPlayCounter = 0;
    public void PlayPauseSong(MouseEvent mouseEvent) {
        if ( songPlayer != null){
            if ( SongPlayCounter % 2 == 1){
                pauseSong();
                SongPlayCounter++;
            }
            else{
                playSong();
                SongPlayCounter++;
            }
        }

    }
    public void playSong (){
        SongPlayPause.setImage(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/Pause.png"));
        songPlayer.play();
        startTimer();

    }
    public void pauseSong (){
        SongPlayPause.setImage(new Image("C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/Play.png"));
        songPlayer.pause();
        endTimer();
    }
    public void startTimer (){
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = songPlayer.getCurrentTime().toSeconds();
                double end = songs.getDuration().toSeconds();
                songProgress.setProgress(current/end);
                if ( current/end == 1){
                    endTimer();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 500, 500);

    }
    public void endTimer (){
        running = false;
        timer.cancel();
    }

    public void AddDirectChatsClicked(MouseEvent mouseEvent) {
        AddDirectTab.setVisible(true);
    }

    public void SearchDirectChatClicked(ActionEvent actionEvent) {
        for ( User user : client.database.users){
            if ( user.getUsername().equals(AddDirectField.getText().toLowerCase(Locale.ROOT)) && !user.blockedList.contains(client.user.id)){
                NewDirectUserPic.setFill(new ImagePattern(new Image(user.getPicAddress())));
                NewDirectUserName.setText(user.getUsername());
                AddDirectResult.setVisible(true);
                return;
            }
        }
        AddDirectResult.setVisible(false);
    }

    public void NewDirectChat(ActionEvent actionEvent) {
        try {
            for ( DirectChat directChat : client.database.directChats){
                if ( directChat.user1 == client.user.id && directChat.user2 == client.getUser(NewDirectUserName.getText()).id || directChat.user2 == client.user.id && directChat.user1 == client.getUser(NewDirectUserName.getText()).id){
                    client.inDirectChat = directChat;
                    client.groupServer = null;
                    client.inTextChannel = null;
                    client.sendUpdates();
                    CloseNewDirectChat(actionEvent);
                    showDirectMessages(directChat);
                }
                else {
                    DirectChat directChat1 = new DirectChat(client.user.id, client.getUser(NewDirectUserName.getText()).id);
                    directChat1.id = client.database.directChats.get(client.database.directChats.size() - 1).id + 1;
                    client.database.directChats.add(directChat1);
                    client.inDirectChat = directChat1;
                    client.groupServer = null;
                    client.inTextChannel = null;
                    client.sendUpdates();
                    CloseNewDirectChat(actionEvent);
                    showDirectMessages(directChat1);
                    showDirectMessages();
                }
            }
        }catch (Exception ignored){

        }
    }

    public void CloseNewDirectChat(ActionEvent actionEvent) {
        AddDirectTab.setVisible(false);
        AddDirectResult.setVisible(false);
        AddDirectField.clear();
    }
}
