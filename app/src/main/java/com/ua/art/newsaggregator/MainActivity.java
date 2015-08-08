package com.ua.art.newsaggregator;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import com.astuetz.PagerSlidingTabStrip;
import com.ua.art.newsaggregator.adapter.MainAdapter;
import com.ua.art.newsaggregator.controller.db.DbManager;
import com.ua.art.newsaggregator.smartDroid.CategoryStatus;
import com.ua.art.newsaggregator.view.LoginActivity;
import com.ua.art.newsaggregator.view.LoginActivityReg;


public class MainActivity extends ActionBarActivity {

    private static final int LOGIN_ACTIVITY = 0;

    final String LOG_TAG = "dbLogs";

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DbManager dbManager = new DbManager(this);




        //requestWindowFeature(Window.FEATURE_NO_TITLE); // << not top-panel

        //new DbManager(this).execute();

//        dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
//        RuntimeExceptionDao<Note, Integer> noteDao = dbHelper.getNote

//        Intent intent = new Intent(this, ORMLiteActivity.class);
//        startActivity(intent);

        setContentView(R.layout.main);
        new Preferences(this);

        if (!isLogin()) {
            startApp();
        } else {
            loginUser();
            //loginUserReg();
        }
        Log.v(LOG_TAG, "isLogin() = " + isLogin());



        CategoryStatus categoryStatus = new CategoryStatus();

    }

    private boolean isLogin() {
        return Preferences.getLogin().equals("");
    }

    private void loginUser() {
        startActivityForResult(new Intent(this, LoginActivity.class), LOGIN_ACTIVITY);
    }

    private void loginUserReg() {
        startActivityForResult(new Intent(this, LoginActivityReg.class), LOGIN_ACTIVITY);
    }

    private void startApp() {
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case LOGIN_ACTIVITY:{
                if(resultCode == RESULT_OK){
                    startApp();
                } else {
                    //ERROR dialog, redirect to login
                }
            }
        }
    }
}