package com.ua.art.newsaggregator;

import java.util.ArrayList;

public class BaseSourse {

    public ArrayList<String[]> selectSourceArr = new ArrayList<>();

    public BaseSourse() {

        addBaseNews("news", "Новости", "ic_business_m150", "true");   // id, name, img-logo Source, pressed button
        addBaseNews("technologies", "Технологии", "img", "false");
        addBaseNews("RIA_news", "Дизайн", "img", "false");
        addBaseNews("kp", "Фото", "img", "false");
        addBaseNews("port", "Спорт", "img", "false");
        addBaseNews("business", "Бизнес", "img", "false");
        addBaseNews("style", "Стиль", "img", "false");
        addBaseNews("travelings", "Путешествия", "img", "false");
        addBaseNews("policy", "Политика", "img", "false");
        addBaseNews("meal", "Еда", "img", "false");
        addBaseNews("music", "Музыка", "img", "false");
        addBaseNews("cinema", "Кино", "img", "false");
//        addBaseNews("games", "Игры", "img", "false");
//        addBaseNews("cars", "Автомобили", "img", "false");
//        addBaseNews("science", "Наука", "img", "false");
//        addBaseNews("house", "Дом", "img", "false");
//        addBaseNews("secular", "Светская хронирка", "img", "false");
//        addBaseNews("weather", "Погода", "img", "false");
//        addBaseNews("fuel", "Топливо", "img", "false");
    }

    private void addBaseNews(String idSelectSource, String nameSelectSource, String imgSelectSource, String pressedBtn) {   //  id, name, img-logo Source

        selectSourceArr.add(new String[]{idSelectSource, nameSelectSource, imgSelectSource});
    }
}