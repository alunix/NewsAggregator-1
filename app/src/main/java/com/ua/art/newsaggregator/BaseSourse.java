package com.ua.art.newsaggregator;

import java.util.ArrayList;

public class BaseSourse {

    public ArrayList<String[]> selectSourceArr = new ArrayList<>();

//    public static ArrayList<String> idSelectSourceArr = new ArrayList<>();       // id Source
//    public static ArrayList<String> nameSelectSourceArr = new ArrayList<>();       // name Source
//    public static ArrayList<String> imgSelectSourceArr = new ArrayList<>();    // img-logo Source

    public BaseSourse() {
        addBaseNews("rian", "ua.rian.ru", "img");   // id, name, img-logo Source
        addBaseNews("ZAXID", "ZAXID.NET", "img");
        addBaseNews("RIA_news", "rian.com.ua", "img");
        addBaseNews("kp", "kp.ua", "img");
        addBaseNews("kp2", "kp2.ua", "img");
    }

    private void addBaseNews(String idSelectSource, String nameSelectSource, String imgSelectSource) {   //  id, name, img-logo Source
        selectSourceArr.add(new String[]{idSelectSource, nameSelectSource, imgSelectSource});
    }
}