package com.michaelmuratov.warehouse.Engine.Database;

import android.arch.persistence.room.TypeConverter;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Converters {
    @TypeConverter
    public static String[] fromStringToList(String string) {
        ArrayList<String> strings = new ArrayList<>();
        try{
            JSONObject jObject = new JSONObject(string.trim());
            Iterator<?> keys = jObject.keys();
            while( keys.hasNext() ) {
                String key = (String)keys.next();
                strings.add(key);
            }
        }catch (Exception e){
            Log.d("JSON",e.toString());
        }
        return (String[]) strings.toArray();
    }

    public static String fromListToString(String[] strings){
        org.json.simple.JSONObject jsonObject=new org.json.simple.JSONObject();
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, strings);
        jsonObject.put("List",list);
        return jsonObject.toJSONString();
    }

}