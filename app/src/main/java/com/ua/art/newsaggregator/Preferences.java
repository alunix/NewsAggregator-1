package com.ua.art.newsaggregator;

import android.content.Context;

import com.ua.art.newsaggregator.smartDroid.CategoryStatus;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Preferences {

    private static final String PREFERENCES = "preferences";
    private static final String PASSWORD = "password";
    private static final String PUBLIC_KEY = "publicKey";
    private static final String LOGIN = "login";
    private static final String CATEGORY = "category";
    private static final String CATEGORY_LIKE = "categoryLike";
    private static final String CATEGORY_NOTLIKE = "categoryNotLike";


    private static Context sContext;

    public Preferences(Context context) {
        Preferences.sContext = context;
        new CategoryStatus();
    }


    public static void savePublicKey(String key)
            throws NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException,
            IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        sContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(PUBLIC_KEY, key)
                .commit();
    }

    public static String getLogin() {
        return sContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).getString(LOGIN, "");
    }

    public static void saveLogin(String login) {
        sContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(LOGIN, login.trim())
                .commit();
    }

    public static String getPassword() {
        return sContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).getString(PASSWORD, "");
    }

    public static void savePassword(String password) {
        sContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(PASSWORD, password)
                .commit();
    }

    public static void saveCategory() {
        sContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(CATEGORY, CategoryStatus.convertToStr(CategoryStatus.statusButton))
                .commit();
    }

    public static void saveCategoryLike() {
        sContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(CATEGORY_LIKE, CategoryStatus.convertToStr(CategoryStatus.likeCategoryStats))
                .commit();
    }

    public static void saveCategoryNotLike() {
        sContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
                .edit()
                .putString(CATEGORY_NOTLIKE, CategoryStatus.convertToStr(CategoryStatus.notLikeCategoryStats))
                .commit();
    }

    public static String getPublicKey() {
        return sContext.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE).getString(PUBLIC_KEY, "");
    }

    public static void clearAll() {
    }
}
