package com.example.discord;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Random;
import java.util.*;
public class User implements Serializable {
    public int id;
    public String username;
    public String password;
    public String number;
    public String email;
    public String status;
    public String picAddress;
    public String backGroundColor;
    public HashSet<Integer> friendList;
    public HashSet<Integer> requestList;
    public HashSet<Integer> blockedList;
    public User() {
        this.friendList = new HashSet<>();
        this.blockedList = new HashSet<>();
        this.requestList = new HashSet<>();
        this.number = "Not Linked";
    }


    public String getPicAddress() {
        return picAddress;
    }

    public void setPic(String picAddress) {
        if ( picAddress == null || picAddress.equals("")){
            Random random = new Random();
            int i = random.nextInt(6) + 1;
            picAddress = "C:/Users/user/Desktop/Desk/- Java - Intelij/Discord/src/main/resources/com/example/discord/Pics/Default" + i + ".png";
        }
        this.picAddress = picAddress;
    }

    public  void setBg() {
        Image bi = new Image(this.picAddress);
        double sumr = 0, sumg = 0, sumb = 0;
        for (int x = 0; x < bi.getWidth(); x++) {
            for (int y = 0; y < bi.getHeight(); y++) {
                Color pixel = bi.getPixelReader().getColor(x, y);
                sumr += pixel.getRed();
                sumg += pixel.getGreen();
                sumb += pixel.getBlue();
            }
        }
        int num = (int) (bi.getWidth() * bi.getHeight());
        this.backGroundColor =  Color.color(sumr / num, sumg / num, sumb / num).toString();
    }

    public boolean setEmail(String email) {
        if (this.checkEmail(email)) {
            this.email = email;
            return true;
        } else {
            return false;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(int n) {
        if (n == 1) {
            this.status = "ONLINE";
        } else if (n == 2) {
            this.status = "OFFLINE";
        } else if (n == 3) {
            this.status = "IDLE";
        }
        else if (n == 4) {
            this.status = "DO NOT DISTURB";
        }

    }

    public boolean setPassword(String password) {
        if (this.checkPassword(password)) {
            this.password = password;
            return true;
        } else {
            return false;
        }
    }

    public boolean setNumber(String number) {
        if ( number.equals("")){
            this.number = "Not Linked";
            return true;
        }
        else if (this.checkNumber(number)) {
            this.number = number;
            return true;
        } else {
            return false;
        }
    }

    public boolean setUsername(String username) {
        if (this.checkUsername(username)) {
            this.username = username.toLowerCase(Locale.ROOT);
            return true;
        } else {
            return false;
        }
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getNumber() {
        return this.number;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean checkEmail(String email) {
        if (email.contains("@") && (email.contains(".com") || email.contains(".ir"))){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsername(String username) {
        if (username.length() < 6) {
            return false;
        } else {
            char[] chars = username.toCharArray();
            char[] var3 = chars;
            int var4 = chars.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                char character = var3[var5];
                if (character > 'z' || character > 'Z' && character < 'a' || character > '9' && character < 'A' || character < '0') {
                    return false;
                }
            }

            return true;
        }
    }

    public boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        } else {
            int numCnt = 0;
            int smallCnt = 0;
            int bigCnt = 0;
            char[] chars = password.toCharArray();
            char[] var6 = chars;
            int var7 = chars.length;

            for(int var8 = 0; var8 < var7; ++var8) {
                char character = var6[var8];
                if (character <= 'z' && character >= 'a') {
                    ++smallCnt;
                } else if (character <= 'Z' && character >= 'A') {
                    ++bigCnt;
                } else if (character <= '9' && character >= '0') {
                    ++numCnt;
                }
            }

            if (numCnt != 0 && bigCnt != 0 && smallCnt != 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean checkNumber(String number) {
        if (number.length() != 11) {
            return false;
        } else {
            return true;
        }
    }

    public String toString() {
        return String.format(this.id + " : " + this.username + " " + this.password + " " + this.email + " " + this.number + " " + this.status);
    }


}
