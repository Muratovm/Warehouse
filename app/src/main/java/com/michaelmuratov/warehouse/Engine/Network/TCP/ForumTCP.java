package com.michaelmuratov.warehouse.Engine.Network.TCP;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.michaelmuratov.warehouse.Engine.Network.Messages.ChatMessage;
import com.michaelmuratov.warehouse.Engine.Network.Messages.CommonMethods;

import org.json.JSONObject;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

import static com.michaelmuratov.warehouse.Engine.Network.Messages.Chats.chatAdapter;

public class ForumTCP extends MyTCP{

    private Activity activity;
    private Random random;

    public ForumTCP(Activity activity) {
        this.activity = activity;
        random = new Random();
    }

    @Override
    protected String doInBackground(Object[] params) {
        return send((JSONObject) params[0]);
    }

    @Override
    protected void onPostExecute(String result) {

    }


    public String send(JSONObject message) {
        try {
            // Creating new socket connection to the IP (first parameter) and its opened port (second parameter)
            Socket s = new Socket("136.243.90.91", 7475);
            InputStream nis = s.getInputStream();
            OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
            out.write(message.toString());
            out.flush();

            final String data = listen(nis);

            // Use incomingMessage as required
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    sendTextMessage(data);
                }
            });
            // Close the socket connection
            s.close();
            Log.d("data",""+data);

            return "it worked!";
        } catch (Exception ex) {
            Log.d("Network Exception",""+ex.toString());
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(activity, "Could not send data to server", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return "didn't work";
    }

    public void sendTextMessage(String message) {
        final ChatMessage chatMessage = new ChatMessage("user1", "user2",
                message, "" + random.nextInt(1000), false);
        chatMessage.setMsgID();
        chatMessage.setBody(message);
        chatMessage.setDate(CommonMethods.getCurrentDate());
        chatMessage.setTime(CommonMethods.getCurrentTime());
        chatAdapter.add(chatMessage);
        chatAdapter.notifyDataSetChanged();
    }
}
