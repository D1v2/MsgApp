package com.example.appnetustest;

public class User {
    private String sender;
    private String reciever;
    private String message;

    public User(String sender, String message) {
        this.sender = sender;
        this.reciever = reciever;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
