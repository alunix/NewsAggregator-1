package com.ua.art.newsaggregator;

import java.util.ArrayList;

public class BaseSourse {

    public ArrayList<String[]> selectSourceArr = new ArrayList<>();

    public BaseSourse() {

        addBaseNews("news", "�������", "ic_business_m150", "true");   // id, name, img-logo Source, pressed button
        addBaseNews("technologies", "����������", "img", "false");
        addBaseNews("RIA_news", "������", "img", "false");
        addBaseNews("kp", "����", "img", "false");
        addBaseNews("port", "�����", "img", "false");
        addBaseNews("business", "������", "img", "false");
        addBaseNews("style", "�����", "img", "false");
        addBaseNews("travelings", "�����������", "img", "false");
        addBaseNews("policy", "��������", "img", "false");
        addBaseNews("meal", "���", "img", "false");
        addBaseNews("music", "������", "img", "false");
        addBaseNews("cinema", "����", "img", "false");
//        addBaseNews("games", "����", "img", "false");
//        addBaseNews("cars", "����������", "img", "false");
//        addBaseNews("science", "�����", "img", "false");
//        addBaseNews("house", "���", "img", "false");
//        addBaseNews("secular", "�������� ��������", "img", "false");
//        addBaseNews("weather", "������", "img", "false");
//        addBaseNews("fuel", "�������", "img", "false");
    }

    private void addBaseNews(String idSelectSource, String nameSelectSource, String imgSelectSource, String pressedBtn) {   //  id, name, img-logo Source

        selectSourceArr.add(new String[]{idSelectSource, nameSelectSource, imgSelectSource});
    }
}