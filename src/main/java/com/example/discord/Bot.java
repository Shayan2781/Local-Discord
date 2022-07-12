package com.example.discord;

import com.example.discord.GroupServer;
import com.example.discord.Message;
import com.example.discord.TextChannel;
import com.example.discord.User;

import java.util.*;
import java.util.stream.Collectors;

public abstract class Bot {
    public static String getInfo (GroupServer groupServer, ArrayList<User> users){
        String creator = null;

        for ( User user : users){
            if ( user.id == groupServer.owner){
                creator = user.getUsername();
            }
        }
        int totalMessage = 0, totalChannels = groupServer.textChannels.size() + groupServer.voiceChannels.size();

        for ( TextChannel textChannel : groupServer.textChannels){
            totalMessage += textChannel.messages.size();
        }
        return String.format("- Server status -\nServer name: " + groupServer.name + "\nCreator: " + creator + "\nNO. Members: " + groupServer.users.size() + "\nNO. Admins: " + groupServer.admins.size() + "\nTotal Messages: " + totalMessage + "\nTotal Channels: " + totalChannels);
    }
    public static String getRanks (GroupServer groupServer, ArrayList<User> users){
        HashMap<Integer, Integer> map = new HashMap<>();
        for ( TextChannel textChannel : groupServer.textChannels){
            for ( Message message : textChannel.messages){
                if ( map.containsKey(message.sender)){
                    map.put(message.sender, map.get(message.sender) + 1);
                }
                else{
                    map.put(message.sender, 1);
                }
            }
        }
        map = sortByValue(map);
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        Collections.reverse(keys);
        String returnString = new String("- Most active members -\n" );
        int counter = 1;
        for ( Integer integer : keys){
            if ( counter > 5){
                return returnString;
            }
            returnString += counter + ": " + getUsername(integer, users) + " (" + map.get(integer) + "messages)\n";
            counter++;
        }
        return returnString;
    }

    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
        HashMap<Integer, Integer> temp
                = hm.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i1.getValue().compareTo(
                        i2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        return temp;
    }

    public static String getUsername ( int i, ArrayList<User> users){
        for ( User user : users){
            if ( user.id == i){
                 return user.getUsername();
            }
        }
        return null;
    }
}
