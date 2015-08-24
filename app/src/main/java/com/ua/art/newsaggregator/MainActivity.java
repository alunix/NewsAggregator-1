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
import com.ua.art.newsaggregator.controller.SynchroDictionaryAS;
import com.ua.art.newsaggregator.controller.db.CountSelectCategory;
import com.ua.art.newsaggregator.service.Settings;
import com.ua.art.newsaggregator.smartDroid.CategoryStatus;
import com.ua.art.newsaggregator.view.LoginActivity;
import com.ua.art.newsaggregator.view.LoginActivityReg;

/*
* https://github.com/astuetz/PagerSlidingTabStrip
* https://guides.codepath.com/android/Sliding-Tabs-with-PagerSlidingTabStrip#setup-onpagechangelistener
* */
public class MainActivity extends ActionBarActivity {

    private static final int LOGIN_ACTIVITY = 0;

    final String LOG_TAG = "mainLogs";

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // Synchronization android server categories
        SynchroDictionaryAS synchroDictionaryAS = new SynchroDictionaryAS();

//        DbManager dbManager = new DbManager(this);

//        Intent intent = new Intent(this, BrowserNews.class);
//        startActivity(intent);


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

        CountSelectCategory countSelC = new CountSelectCategory();  // save Settings button select Category (default)

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
        pager.setAdapter(new MainAdapter(getSupportFragmentManager(), this));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
        tabs.setIndicatorColor(R.color.abc_secondary_text_material_light);
        tabs.setIndicatorHeight(7);

        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                Log.d(LOG_TAG, "onPageSelected, position - " + position);
                if (position == 0) Settings.updateNewsList = true;
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d(LOG_TAG, "onPageScrolled, position - " + position);
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
//                Log.d(LOG_TAG, "onPageScrollStateChanged, state - " + state);
            }
        });
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