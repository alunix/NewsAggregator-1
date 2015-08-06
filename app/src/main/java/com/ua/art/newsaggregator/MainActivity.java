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
import com.ua.art.newsaggregator.smartDroid.CategoryStatus;
import com.ua.art.newsaggregator.view.LoginActivity;
import com.ua.art.newsaggregator.view.LoginActivityReg;


public class MainActivity extends ActionBarActivity {

    private static final int LOGIN_ACTIVITY = 0;
    public static final String TAG = "MyLog";

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE); // << not top-panel
        setContentView(R.layout.main);
        new Preferences(this);

        if (!isLogin()) {
            startApp();
        } else {
            loginUser();
            //loginUserReg();
        }
        Log.v(TAG, "isLogin() = " + isLogin());

//        Intent intent = new Intent(this, ORMLiteActivity.class);
//        startActivity(intent);

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