package com.ua.art.newsaggregator.smartDroid;

import com.ua.art.newsaggregator.model.News;

import java.util.HashMap;
import java.util.Map;

public class CategoryStatus {

    public static Map<String, String> statusButton;
    public static Map<String, String> likeCategoryStats;
    public static Map<String, String> notLikeCategoryStats;
    public static String statusBtnStr = null;
    public static String likeCategoryString = null;
    public static String notLikeCategoryString = null;

    public CategoryStatus() {
        likeCategoryStats = new HashMap<>();
        notLikeCategoryStats = new HashMap<>();
        statusButton = new HashMap<>();
        defaultAdd();
    }

    private static void defaultAdd(){
        for (int i = 0; i < News.values().length; i++) {
            likeCategoryStats.put(News.values()[i].toString(), "0");
            notLikeCategoryStats.put(News.values()[i].toString(), "0");
            statusButton.put(News.values()[i].toString(), "0");
        }
    }

//    public static void saveStatus(){
//        convertToStr(likeCategoryStats);
//        convertToStr(notLikeCategoryStats);
//        convertToStr(statusButton);
//
//    }

    public static String convertToStr(Map map){
        return map.toString();
    }
    public static Map convertToMap(String string){
        string = string.substring(1, string.length()-1);
        String[] keyValuePairs = string.split(",");
        Map<String, String> map = new HashMap<>();
        for(String pair : keyValuePairs)
        {
            String[] entry = pair.split("=");
            map.put(entry[0].trim(), entry[1].trim());
        }
        return map;
    }

//
//    private String convertToStringLike(){
//        return likeCategoryStats.toString();
//    }
//    private Map convertToMapLike(){
//        likeCategoryString = likeCategoryString.substring(1, likeCategoryString.length()-1);
//        String[] keyValuePairs = likeCategoryString.split(",");
//        Map<String, String> mapLike = new HashMap<>();
//        for(String pair : keyValuePairs)
//        {
//            String[] entry = pair.split("=");
//            mapLike.put(entry[0].trim(), entry[1].trim());
//        }
//        return mapLike;
//    }
//
//    private String convertToStringNotLike(){
//        return notLikeCategoryStats.toString();
//    }
//    private Map convertToMapNotLike(){
//        notLikeCategoryString = notLikeCategoryString.substring(1, notLikeCategoryString.length()-1);
//        String[] keyValuePairs = notLikeCategoryString.split(",");
//        Map<String, String> mapNotLike = new HashMap<>();
//        for(String pair : keyValuePairs)
//        {
//            String[] entry = pair.split("=");
//            mapNotLike.put(entry[0].trim(), entry[1].trim());
//        }
//        return mapNotLike;
//    }
//
//    private String convertToStrStatus(){
//        return statusButton.toString();
//    }
//    private Map convertToMapStatus(){
//        statusBtnStr = statusBtnStr.substring(1, statusBtnStr.length()-1);
//        String[] keyValuePairs = statusBtnStr.split(",");
//        Map<String, String> mapStatusBtn = new HashMap<>();
//        for(String pair : keyValuePairs)
//        {
//            String[] entry = pair.split("=");
//            mapStatusBtn.put(entry[0].trim(), entry[1].trim());
//        }
//        return mapStatusBtn;
//    }






}
