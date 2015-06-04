package com.ua.art.newsaggregator;

import android.app.Activity;

import java.util.ArrayList;

public class BaseSourse extends Activity {

    public ArrayList<String[]> selectSourceArr = new ArrayList<>();

    public BaseSourse() {

        addBaseNews("news", "Новости", R.drawable.ic_news_m150, R.drawable.ic_news_m150_bw, "true");   // id, name, img-logo Source, pressed button
        addBaseNews("technologies", "Технологии", R.drawable.ic_tehnologis_m150, R.drawable.ic_tehnologis_m150_bw, "false");
        addBaseNews("design", "Дизайн", R.drawable.ic_design_m150, R.drawable.ic_design_m150_bw, "false");
        addBaseNews("foto", "Фото", R.drawable.ic_foto_m150, R.drawable.ic_foto_m150_bw, "false");
        addBaseNews("sport", "Спорт", R.drawable.ic_sport_2_m150, R.drawable.ic_sport_2_m150_bw, "false");
        addBaseNews("business", "Бизнес", R.drawable.ic_business_m150, R.drawable.ic_business_m150_bw, "false");
        addBaseNews("style", "Стиль", R.drawable.ic_style_m150, R.drawable.ic_style_m150_bw, "false");
        addBaseNews("travelings", "Путешествия", R.drawable.ic_travel_m150, R.drawable.ic_travel_m150_bw, "false");
        addBaseNews("policy", "Политика", R.drawable.ic_politics_m150, R.drawable.ic_politics_m150_bw, "false");
        addBaseNews("meal", "Еда", R.drawable.ic_food_m150, R.drawable.ic_food_m150_bw, "false");
        addBaseNews("music", "Музыка", R.drawable.ic_music_m150, R.drawable.ic_music_m150_bw, "false");
        addBaseNews("cinema", "Кино", R.drawable.ic_cinema_2_m150, R.drawable.ic_cinema_2_m150_bw, "false");

        addBaseNews("games", "Игры", R.drawable.ic_games_m150, R.drawable.ic_games_m150_bw, "false");
        addBaseNews("cars", "Автомобили", R.drawable.ic_cars_m150, R.drawable.ic_cars_m150_bw, "false");
        addBaseNews("science", "Наука", R.drawable.ic_science_m150, R.drawable.ic_science_m150_bw, "false");
        //addBaseNews("house", "Дом", R.drawable.ic_, R.drawable.ic_business_m150, "false");
        //addBaseNews("secular", "Светская хронирка", R.drawable.ic_, R.drawable.ic_business_m150, "false");
        addBaseNews("weather", "Погода", R.drawable.ic_weather_m150, R.drawable.ic_weather_m150_bw, "false");
        addBaseNews("fuel", "Топливо", R.drawable.ic_fuel_m150, R.drawable.ic_fuel_m150_bw, "false");
    }

//    private void addBaseNews(String idSelectSource, String nameSelectSource, String imgSelectSource, String pressedBtn) {   //  id, name, img-logo Source
//        //String imgSelectSrc = getResources().getResourceEntryName(R.drawable.ic_news_m150);
//        selectSourceArr.add(new String[]{idSelectSource, nameSelectSource, imgSelectSource, pressedBtn});
//    }

    private void addBaseNews(String idSelectSource, String nameSelectSource, int imgSelectSource, int imgSelectSource2, String pressedBtn) {   //  id, name, img-logo Source
        int imageResource = R.drawable.ic_food_m150;
        int imageResource2 = R.drawable.ic_food_m150;
        String imgSelectSrc = String.valueOf(imgSelectSource);
        String imgSelectSrc2 = String.valueOf(imgSelectSource2);

//        String imgSelectSrc = getResources().getResourceEntryName(imgSelectSource);
//        String imgSelectSrc2 = getResources().getResourceEntryName(imgSelectSource2);
        selectSourceArr.add(new String[]{idSelectSource, nameSelectSource, imgSelectSrc, imgSelectSrc2, pressedBtn});
    }


}