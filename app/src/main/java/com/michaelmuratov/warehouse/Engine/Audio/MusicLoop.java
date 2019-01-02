package com.michaelmuratov.warehouse.Engine.Audio;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicLoop {

    static Music music;

    public void makebackgroundloop(Context context, int musicId){
        if(music == null){
            MediaPlayer mp = MediaPlayer.create(context, musicId);
            mp.setLooping(true);
            music = new Music();
            music.execute(mp);
        }
    }

    public void stopLoop(){
        music.cancel(true);
    }
}
