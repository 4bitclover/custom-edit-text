package com.example.customedittext;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.Map;

class IconManager {

    static class Colors {
        static final String GREEN = "green";
        static final String BLACK = "black";
        static final String RED = "red";
    }

    private static Map<String, Integer> atIcons = new HashMap<String, Integer>(){
        {
            put("red", R.drawable.red_at);
            put("black", R.drawable.black_at);
            put("green", R.drawable.green_at);
        }
    };

    private static Map<String, Integer> profileIcons = new HashMap<String, Integer>(){
        {
            put("red", R.drawable.red_user);
            put("black", R.drawable.black_user);
            put("green", R.drawable.green_user);
        }
    };

    public static Drawable getEmailIcon(Context context, String color){
        Drawable drawable = context.getResources().getDrawable(atIcons.get(color));
        drawable.setBounds(0, 0, 80, 80);
        return  drawable;
    }

    public static Drawable getProfileIcon(Context context, String color){
        Drawable drawable = context.getResources().getDrawable(profileIcons.get(color));
        drawable.setBounds(0, 0, 80, 80);
        return  drawable;
    }
}
