package com.ua.art.newsaggregator.model;

import com.ua.art.newsaggregator.R;

public enum SettingsNews {

    STORE_NEWS("storeNews", "Хранить новости", R.layout.selection_modules, 1),
    AUTOUPDATING("autoupdating", "Автообновление", R.layout.selection_modules, 1);

    private final String storeNews;
    private final String name;
    private final int selection_modules;
    private final int parameter;

    SettingsNews(String storeNews, String name, int selection_modules, int parameter) {
        this.storeNews = storeNews;
        this.name = name;
        this.selection_modules = selection_modules;
        this.parameter = parameter;
    }

    public String getStoreNews() {
        return storeNews;
    }

    public String getName() {
        return name;
    }

    public int getSelectionModules() {
        return selection_modules;
    }

    public int getParameter() {
        return parameter;
    }

}
