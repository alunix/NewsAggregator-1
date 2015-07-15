package com.ua.art.newsaggregator.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ua.art.newsaggregator.view.fragments.ChooseCategoryFragment;
import com.ua.art.newsaggregator.view.fragments.DroidNewsFragment;
import com.ua.art.newsaggregator.view.fragments.NewsListFragment;
import com.ua.art.newsaggregator.view.fragments.SettingsFragment;
import com.ua.art.newsaggregator.view.fragments.TopNFragment;
import com.ua.art.newsaggregator.view.fragments.WeatherFragment;

public class MainAdapter extends FragmentPagerAdapter {

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "News list";
            case 1:
                return "Choose category";
            case 2:
                return "Top20";
            case 3:
                return "Droid News";
            case 4:
                return "Weather";
            case 5:
                return "Settings";
             default:
                return "News list";
        }
    }
    @Override
    public int getCount() {
        return 6;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: {
                return new ChooseCategoryFragment();  //return new NewsListFragment();
            }case 1: {
                return new ChooseCategoryFragment();
            }case 2:{
                return new TopNFragment();
            }case 3:{
                return new DroidNewsFragment();
            }case 4:{
                return new WeatherFragment();
            }case 5:{
                return new SettingsFragment();
            } default:
                return new NewsListFragment();
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
