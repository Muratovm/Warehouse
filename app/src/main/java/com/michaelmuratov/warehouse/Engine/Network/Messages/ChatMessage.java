package com.michaelmuratov.warehouse.Engine.Network.Messages;

import java.util.Locale;
import java.util.Random;

public class ChatMessage {

    private String body, sender, receiver;
    static String userType;
    private String date, time;
    private String ID;
    private boolean isMine;// Did I send the message.

    public ChatMessage(String Sender, String Receiver, String messageString,
                       String ID, boolean isMINE) {
        sender = Sender;
        receiver = Receiver;
        body = messageString;
        this.ID = ID;
        isMine = isMINE;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }

    public String getMsgId(){
        return ID;
    }

    public void setMsgID() {
        ID += "-" + String.format(Locale.CANADA,"%02d", new Random().nextInt(100));
    }

    boolean isMine() {
        return isMine;
    }

    String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSender(){
        return sender;
    }

    public String getReciever(){
        return receiver;
    }
}
