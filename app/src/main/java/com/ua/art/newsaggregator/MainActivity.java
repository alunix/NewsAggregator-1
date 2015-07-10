package com.ua.art.newsaggregator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.astuetz.PagerSlidingTabStrip;
import com.ua.art.newsaggregator.adapter.MainAdapter;
import com.ua.art.newsaggregator.view.LoginActivity;


public class MainActivity extends ActionBarActivity {

    private static final int LOGIN_ACTIVITY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new Preferences(this);

        if (!isLogin()) {
            startApp();
        } else {
            loginUser();
        }
    }

    private boolean isLogin() {
        return Preferences.getLogin().equals("");
    }

    private void loginUser() {
        startActivityForResult(new Intent(this, LoginActivity.class), LOGIN_ACTIVITY);
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