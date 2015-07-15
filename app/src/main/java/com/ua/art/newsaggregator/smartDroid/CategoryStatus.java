package com.ua.art.newsaggregator.smartDroid;

import com.ua.art.newsaggregator.model.News;

import java.util.HashMap;
import java.util.Map;

public class CategoryStatus {

    private Map<String, String> statusButton;
    private Map<String, String> likeCategoryStats;
    private Map<String, String> notLikeCategoryStats;
    private String statusBtnStr = null;
    private String likeCategoryString = null;
    private String notLikeCategoryString = null;

    public CategoryStatus() {
        likeCategoryStats = new HashMap<>();
        notLikeCategoryStats = new HashMap<>();
        defaultAdd();
    }

    private void defaultAdd(){
        for (int i = 0; i < News.values().length; i++) {
            likeCategoryStats.put(News.values()[i].toString(), "0");
            notLikeCategoryStats.put(News.values()[i].toString(), "0");
            convertToStringLike();
        }
    }

    public void saveStatusButton(){

    }

    private String convertToStringLike(){
        return likeCategoryStats.toString();
    }

    private Map convertToMapLike(){
        likeCategoryString = likeCategoryString.substring(1, likeCategoryString.length()-1);
        String[] keyValuePairs = likeCategoryString.split(",");
        Map<String, String> mapLike = new HashMap<>();
        for(String pair : keyValuePairs)
        {
            String[] entry = pair.split("=");
            mapLike.put(entry[0].trim(), entry[1].trim());
        }
        return mapLike;
    }

    private String convertToStringNotLike(){
        return notLikeCategoryStats.toString();
    }

    private Map convertToMapNotLike(){
        notLikeCategoryString = notLikeCategoryString.substring(1, notLikeCategoryString.length()-1);
        String[] keyValuePairs = notLikeCategoryString.split(",");
        Map<String, String> mapNotLike = new HashMap<>();
        for(String pair : keyValuePairs)
        {
            String[] entry = pair.split("=");
            mapNotLike.put(entry[0].trim(), entry[1].trim());
        }
        return mapNotLike;
    }






}
