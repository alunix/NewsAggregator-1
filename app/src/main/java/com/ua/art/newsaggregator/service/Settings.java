package com.ua.art.newsaggregator.service;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;

public class Settings extends Activity {
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_LOGIN = "login";
    public static final String APP_PREFERENCES_PASSWORD = "password";

//    public static HashMap<String, String> selectCategory = new HashMap<>();
//    public static HashMap<String, String> nameSelectCategory = new HashMap<>();
    //public static ArrayList<String> selectCategory = new ArrayList<>();
    public static ArrayList<String> nameSelectCategory = new ArrayList<>();

    public static int maxNewsList = 20;
    public static int sumItemOneCategory = 10;

    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);
    }

//    public void o(){
//        mSettings = getSharedPreferences()
//    }

}
