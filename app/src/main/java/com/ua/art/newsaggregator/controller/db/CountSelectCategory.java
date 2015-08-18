package com.ua.art.newsaggregator.controller.db;

import com.ua.art.newsaggregator.model.News;
import com.ua.art.newsaggregator.service.Settings;

public class CountSelectCategory {

    public CountSelectCategory() {
        addSelectCategory();
        countSumSelectCategory();
    }

    public void addSelectCategory(){    // save selectCategory to Settings.selectCategory
        Settings.nameSelectCategory.clear();
        for (News key : News.values()){
            if(String.valueOf(key.isClicked()) == "true"){  // if select Category - true
//                Settings.selectCategory.put(
//                        String.valueOf(key.getName()), String.valueOf(key.isClicked())
//                );
//                Settings.nameSelectCategory.put(
//                        String.valueOf(key.getName()), String.valueOf(key.getName())
//                );
                //Settings.selectCategory.add(String.valueOf(key.getName()));
                Settings.nameSelectCategory.add(String.valueOf(key.getName()));
            }
        }
    }

    public void countSumSelectCategory(){
        if (Settings.nameSelectCategory.size() != 0)
            Settings.sumItemOneCategory = Settings.maxNewsList/Settings.nameSelectCategory.size();
        else
            Settings.sumItemOneCategory = Settings.maxNewsList;
    }
}
