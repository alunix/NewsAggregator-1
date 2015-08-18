package com.ua.art.newsaggregator.model;


import com.ua.art.newsaggregator.R;

public enum News {

    NEWS(0, "news", R.string.news_en, R.string.news_ru, R.drawable.ic_news_m150, R.drawable.ic_news_m150_bw, true),   // id, name, img-logo Source, pressed button
    //TECHNOLOGIES(1, R.string.technologies_en, R.string.technologies_ru, R.drawable.ic_tehnologis_m150, R.drawable.ic_tehnologis_m150_bw, false),
    DESIGN(2, "culture", R.string.design_en, R.string.culture_ru, R.drawable.ic_design_m150, R.drawable.ic_design_m150_bw, false),
    PHOTO(3, "foto", R.string.foto_en, R.string.foto_ru, R.drawable.ic_foto_m150, R.drawable.ic_foto_m150_bw, false),
    SPORT(4, "sport", R.string.sport_en, R.string.sport_ru, R.drawable.ic_sport_2_m150, R.drawable.ic_sport_2_m150_bw, false),
    BUSINESS(5, "economics", R.string.business_en, R.string.economics_ru, R.drawable.ic_business_m150, R.drawable.ic_business_m150_bw, false),
    STYLE(6, "interview", R.string.style_en, R.string.interview_ru, R.drawable.ic_style_m150, R.drawable.ic_style_m150_bw, false),
    TRAVEL(7, "world", R.string.travelings_en, R.string.world_ru, R.drawable.ic_travel_m150, R.drawable.ic_travel_m150_bw, false),
    POLICTICS(8, "politics", R.string.politics_en, R.string.politics_ru, R.drawable.ic_politics_m150, R.drawable.ic_politics_m150_bw, true),
    FILMS(11, "video", R.string.cinema_en, R.string.video_ru, R.drawable.ic_cinema_2_m150, R.drawable.ic_cinema_2_m150_bw, false);
//    MEAL(9, R.string.meal_en, R.string.meal, R.drawable.ic_food_m150, R.drawable.ic_food_m150_bw, false),
//    MUSIC(10, R.string.music_en, R.string.music_ru, R.drawable.ic_music_m150, R.drawable.ic_music_m150_bw, false),
//    GAMES(12, R.string.games_en, R.string.games_ru, R.drawable.ic_games_m150, R.drawable.ic_games_m150_bw, false),
//    CARS(13, R.string.cars_en, R.string.cars_ru, R.drawable.ic_cars_m150, R.drawable.ic_cars_m150_bw, false);
//    SCIENCE(14, "science", "Наука", R.drawable.ic_science_m150, R.drawable.ic_science_m150_bw, false),
//    //addBaseNews("house", "Дом", R.drawable.ic_, R.drawable.ic_business_m150, "false");
//    //addBaseNews("secular", "Светская хронирка", R.drawable.ic_, R.drawable.ic_business_m150, "false");
//    WEATHER(15, "weather", "Погода", R.drawable.ic_weather_m150, R.drawable.ic_weather_m150_bw, false),
//    FUEL(16, "fuel", "Топливо", R.drawable.ic_fuel_m150, R.drawable.ic_fuel_m150_bw, false);

    private int id;
    private String name;
    private int enResource;
    private int ruResource;
    private int imgResourceClicked;
    private int imgResourceUnclicked;
    private boolean isClicked;

    News(int id, String name, int enResource, int rusResource, int imgResourceUnclicked, int imgResourceClicked, boolean isClicked) {
        this.id = id;
        this.name = name;
        this.enResource = enResource;
        this.ruResource = rusResource;
        this.imgResourceClicked = imgResourceClicked;
        this.imgResourceUnclicked = imgResourceUnclicked;
        this.isClicked = isClicked;
    }

    public int getId() { return this.id; }

    public String getName() {
        return this.name;
    }

    public int getEnResource() {
        return this.enResource;
    }

    public int getRuResource() {
        return this.ruResource;
    }

    public int getImgResourceClicked() {
        return this.imgResourceClicked;
    }

    public int getImgResourceUnclicked() {
        return this.imgResourceUnclicked;
    }

    public boolean isClicked() {
        return this.isClicked;
    }

    public void setClicked(boolean isClicked){
        this.isClicked = isClicked;
    }
}











//    NEWS(0, R.string.news_en, R.string.news_ru, R.drawable.ic_news_m150, R.drawable.ic_news_m150_bw, true),   // id, name, img-logo Source, pressed button
//    TECHNOLOGIES(1, R.string.technologies_en, R.string.technologies_ru, R.drawable.ic_tehnologis_m150, R.drawable.ic_tehnologis_m150_bw, false),
//    DESIGN(2, R.string.design_en, R.string.design_ru, R.drawable.ic_design_m150, R.drawable.ic_design_m150_bw, false),
//    PHOTO(3, R.string.foto_en, R.string.foto_ru, R.drawable.ic_foto_m150, R.drawable.ic_foto_m150_bw, false),
//    SPORT(4, R.string.sport_en, R.string.sport_ru, R.drawable.ic_sport_2_m150, R.drawable.ic_sport_2_m150_bw, false),
//    BUSINESS(5, R.string.business_en, R.string.business_ru, R.drawable.ic_business_m150, R.drawable.ic_business_m150_bw, false),
//    STYLE(6, R.string.style_en, R.string.style_ru, R.drawable.ic_style_m150, R.drawable.ic_style_m150_bw, false),
//    TRAVEL(7, R.string.travelings_en, R.string.travelings_ru, R.drawable.ic_travel_m150, R.drawable.ic_travel_m150_bw, false),
//    POLICTICS(8, R.string.politics_en, R.string.politics_ru, R.drawable.ic_politics_m150, R.drawable.ic_politics_m150_bw, false),
//    MEAL(9, R.string.meal_en, R.string.meal, R.drawable.ic_food_m150, R.drawable.ic_food_m150_bw, false),
//    MUSIC(10, R.string.music_en, R.string.music_ru, R.drawable.ic_music_m150, R.drawable.ic_music_m150_bw, false),
//    FILMS(11, R.string.cinema_en, R.string.cinema_ru, R.drawable.ic_cinema_2_m150, R.drawable.ic_cinema_2_m150_bw, false),
//    GAMES(12, R.string.games_en, R.string.games_ru, R.drawable.ic_games_m150, R.drawable.ic_games_m150_bw, false),
//    CARS(13, R.string.cars_en, R.string.cars_ru, R.drawable.ic_cars_m150, R.drawable.ic_cars_m150_bw, false);