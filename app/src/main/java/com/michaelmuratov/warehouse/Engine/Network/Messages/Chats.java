package com.michaelmuratov.warehouse.Engine.Network.Messages;

import android.app.Activity;
import android.widget.EditText;

import com.michaelmuratov.warehouse.Engine.Network.TCP.Sender;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class Chats {

    public final Activity activity;
    private EditText msg_edit_text;
    private Random random;
    public static ChatAdapter chatAdapter;
    private Sender sender;

    public Chats(final Activity activity){
        this.activity = activity;
        random = new Random();
        sender = new Sender(activity);
        //msg_edit_text =  activity.findViewById(R.id.messageEditText);
        //ImageButton sendButton = activity.findViewById(R.id.sendMessageButton);
        setupListView();
        /*
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTextMessage();
            }
        });
        */
    }

    
    private void setupListView(){
        //ListView msgListView = activity.findViewById(R.id.msgListView);
        //msgListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL); //scrolls down with new message
        //msgListView.setStackFromBottom(true); //adds items to the bottom
        ArrayList chat_list = new ArrayList();
        chatAdapter = new ChatAdapter(activity, chat_list);
        //msgListView.setAdapter(chatAdapter);
    }

    private void sendTextMessage() {
        String message = msg_edit_text.getEditableText().toString();
        if (!message.equalsIgnoreCase("")) {
            final ChatMessage chatMessage = new ChatMessage("user1", "user2",
                    message, "" + random.nextInt(1000), true);
            chatMessage.setMsgID();
            chatMessage.setBody(message);
            chatMessage.setDate(CommonMethods.getCurrentDate());
            chatMessage.setTime(CommonMethods.getCurrentTime());
            msg_edit_text.setText("");
            try {
                sender.sendTCP("Message",constructMessage(message));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            chatAdapter.add(chatMessage);
            chatAdapter.notifyDataSetChanged();
        }
    }

    private JSONObject constructMessage(String message) throws JSONException {

        JSONObject object = new JSONObject();
        object.put("ACTION","MESSAGE");
        object.put("Message",message);
        object.put("Date", CommonMethods.getCurrentDate());
        object.put("Time", CommonMethods.getCurrentTime());
        object.put("Sender", "Michael");
        return object;

    }


}