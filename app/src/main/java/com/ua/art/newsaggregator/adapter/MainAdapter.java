package com.ua.art.newsaggregator.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.ua.art.newsaggregator.view.fragments.ChooseCategoryFragment;
import com.ua.art.newsaggregator.view.fragments.NewsListFragment;
import com.ua.art.newsaggregator.view.fragments.SettingsFragment;
import com.ua.art.newsaggregator.view.fragments.TopNFragment;
import com.ua.art.newsaggregator.view.fragments.WeatherFragment;

public class MainAdapter extends FragmentPagerAdapter {
    private Context context;
    private static final String LOG_TAG = "adapter";

    public MainAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Новости";
            case 2:
                return "Top-20";
            case 1:
                return "Категории";
//            case 3:
//                return "Droid News";
            case 3:
                return "Погода";
            case 4:
                return "Настройки";
             default:
                return "Новости";
        }
    }
    @Override
    public int getCount() {
        return 5;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: {
                Log.d(LOG_TAG, "onResume");
                return new NewsListFragment(context);  //return new NewsListFragment();
            }case 2:{
                return new TopNFragment();
            }case 1: {
                return new ChooseCategoryFragment();
//            }case 3:{
//                return new DroidNewsFragment();
            }case 3:{
                return new WeatherFragment();
            }case 4:{
                return new SettingsFragment();
            } default:
                Log.d(LOG_TAG, "default");
                return new NewsListFragment(context);
        }
    }

//    private Fragment NewsListFragm(){
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                return new NewsListFragment();
//            }
//        });
//    }
}
