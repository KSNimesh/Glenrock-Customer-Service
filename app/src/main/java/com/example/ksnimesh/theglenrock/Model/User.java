package com.example.ksnimesh.theglenrock.Model;

public class User {
    private String Room_NO;
    private String Password;
    private String Roompack;

    public User()  {
    }

    public User(String room_NO, String password) {
        Room_NO = room_NO;
        Password = password;
    }

    public String getRoompack() {
        return Roompack;
    }

    public void setRoompack(String roompack) {
        Roompack = roompack;
    }

    public String getRoom_NO() {
        return Room_NO;
    }

    public void setRoom_NO(String room_NO) {
        Room_NO = room_NO;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
