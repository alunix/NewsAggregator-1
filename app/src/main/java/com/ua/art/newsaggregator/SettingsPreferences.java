package com.ua.art.newsaggregator;

import android.content.Context;

public class SettingsPreferences {

    private static final String SETINGS_PREFERENCES = "setingsPreferences";
    private static final String LANGUAGE = "language";
    private static final String STORE_NEWS = "storeNews";
    private static final String AUTO_UPDATE = "autoUpdate";
    private static final String AUTO_SCREEN_ROTATION = "autoScreenRotation";
    private static final String FONT_SIZE = "fontSize";
    private static final String DELETE_SAVE_NEWS = "deleteSaveNews";

    private static Context contextPrefSave;

    public SettingsPreferences(Context context) {
        contextPrefSave = context;
    }


    public static String getLanguage() {
        return contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE).getString(LANGUAGE, "");
    }
    public static void saveLanguage(String language) {
        contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(LANGUAGE, language.trim())
                .commit();
    }

    public static String getStoreNews() {
        return contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE).getString(STORE_NEWS, "");
    }
    public static void saveStoreNews(String storeNews) {
        contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(STORE_NEWS, storeNews.trim())
                .commit();
    }

    public static String getAutoUpdate() {
        return contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE).getString(AUTO_UPDATE, "");
    }
    public static void saveAutoUpdate(String autoUpdate) {
        contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(AUTO_UPDATE, autoUpdate.trim())
                .commit();
    }

    public static String getAutoScreenRotation() {
        return contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE).getString(AUTO_SCREEN_ROTATION, "");
    }
    public static void saveAutoScreenRotation(String autoScreenRotation) {
        contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(AUTO_SCREEN_ROTATION, autoScreenRotation.trim())
                .commit();
    }

    public static String getFontSize() {
        return contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE).getString(FONT_SIZE, "");
    }
    public static void saveFontSize(String fontSize) {
        contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(FONT_SIZE, fontSize.trim())
                .commit();
    }

    public static String getDeleteSaveNews() {
        return contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE).getString(DELETE_SAVE_NEWS, "");
    }
    public static void saveDeleteSaveNews(String deleteSaveNews) {
        contextPrefSave.getSharedPreferences(SETINGS_PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(DELETE_SAVE_NEWS, deleteSaveNews.trim())
                .commit();
    }



}
