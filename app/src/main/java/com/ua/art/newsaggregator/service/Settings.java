package com.ua.art.newsaggregator.service;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * User Preferences
 * */
public class Settings extends Activity {
    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_LOGIN = "login";
    public static final String APP_PREFERENCES_PASSWORD = "password";

//    public static HashMap<String, String> selectCategory = new HashMap<>();
//    public static HashMap<String, String> nameSelectCategory = new HashMap<>();
    //public static ArrayList<String> selectCategory = new ArrayList<>();
    public static ArrayList<String> nameSelectCategory = new ArrayList<>();

    public static final int PRIORITY_CATEGORY_SELECT = 2;
    public static final int PRIORITY_ITEM_INPUT = 1;

    public static ArrayList<HashMap<String, int[]>> selectCountCategory = new ArrayList<>();

    public static ArrayList<HashMap<String, String>> gravityCategory = new ArrayList<>();

    public static ArrayList<HashMap<String, String>> newsList = new ArrayList<>();  // news Item

    public static int maxNewsList = 20;
    public static int sumItemOneCategory = 10;
    public static int nameSelectAllCategory;   // сколько все новостей загрузится за рас
    public static int maxIdItem = 0;
    public static int minIdItem = 0;
    public static boolean updateNewsList = false;

    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        super.onCreate(savedInstanceState);

        //TODO Сохранение инфи о нажатых категорий
        HashMap<String, int[]> fds = new HashMap<>();
        int[] a = new int[4];
        fds.put("", a);
        selectCountCategory.add(fds);
    }

//    public void o(){
//        mSettings = getSharedPreferences()
//    }

}
