package com.ua.art.newsaggregator.model;


import com.ua.art.newsaggregator.R;

/**
 * Data for the category buttons
 * */
public enum News {

    //nameCategory(№, IdCategory, nameEn, nameRu, imgColor, imgBw, clicked)

    NEWS_ALL(20, "news_all", R.string.news_all_en, R.string.news_all_ru, R.drawable.ic_news_all, R.drawable.ic_news_all_bw, true),
    NEWS_ARTICLES(21, "news_articles", R.string.news_articles_en, R.string.news_articles_ru, R.drawable.ic_news_articles, R.drawable.ic_news_articles_bw, true),
    NEWS_CAPITAL(22, "news_capital", R.string.news_capital_en, R.string.news_capital_ru, R.drawable.ic_news_capital, R.drawable.ic_news_capital_bw, true),
    NEWS_CULTURE(23, "news_culture", R.string.news_culture_en, R.string.news_culture_ru, R.drawable.ic_news_culture, R.drawable.ic_news_culture_bw, true),
    NEWS_ECONOMICS(24, "news_economics", R.string.news_economics_en, R.string.news_economics_ru, R.drawable.ic_news_economics, R.drawable.ic_news_economics_bw, true),
    NEWS_INTERVIEW(25, "news_interview", R.string.news_interview_en, R.string.news_interview_ru, R.drawable.ic_news_interview, R.drawable.ic_news_interview_bw, true),
    NEWS_NEWS(26, "news_news", R.string.news_news_en, R.string.news_news_ru, R.drawable.ic_news_news, R.drawable.ic_news_news_bw, true),
    NEWS_PHOTO(27, "news_photo", R.string.news_photo_en, R.string.news_photo_ru, R.drawable.ic_news_photo, R.drawable.ic_news_photo_bw, true),
    NEWS_politics(28, "news_politics", R.string.news_politics_en, R.string.news_politics_ru, R.drawable.ic_news_politics, R.drawable.ic_news_politics_bw, true),
    NEWS_smi(29, "news_smi", R.string.news_smi_en, R.string.news_smi_ru, R.drawable.ic_news_smi, R.drawable.ic_news_smi_bw, true),
    NEWS_SOCIETY(30, "news_society", R.string.news_society_en, R.string.news_society_ru, R.drawable.ic_news_society, R.drawable.ic_news_society_bw, true),
    NEWS_SPORT(31, "news_sport", R.string.news_sport_en, R.string.news_sport_ru, R.drawable.ic_news_sport, R.drawable.ic_news_sport_bw, true),
    NEWS_TOP(32, "news_top", R.string.news_top_en, R.string.news_top_ru, R.drawable.ic_news_top, R.drawable.ic_news_top_bw, true),
    NEWS_UA_ALL(33, "news_ua_all", R.string.news_ua_all_en, R.string.news_ua_all_ru, R.drawable.ic_news_ua_all, R.drawable.ic_news_ua_all_bw, true),
    NEWS_UA_TOP(34, "news_ua_top", R.string.news_ua_top_en, R.string.news_ua_top_ru, R.drawable.ic_news_ua_top, R.drawable.ic_news_ua_top_bw, true);
//    NEWS_VIDEO(35, "news_video", R.string.news_video_en, R.string.news_video_ru, R.drawable.ic_news_video_2, R.drawable.ic_news_video_2_bw, true);

//    NEWS(0, "news", R.string.news_en, R.string.news_ru, R.drawable.ic_news_m150, R.drawable.ic_news_m150_bw, true),   // id, name, img-logo Source, pressed button
//    //TECHNOLOGIES(1, R.string.technologies_en, R.string.technologies_ru, R.drawable.ic_tehnologis_m150, R.drawable.ic_tehnologis_m150_bw, false),
//    DESIGN(2, "culture", R.string.design_en, R.string.culture_ru, R.drawable.ic_design_m150, R.drawable.ic_design_m150_bw, false),
//    PHOTO(3, "foto", R.string.foto_en, R.string.foto_ru, R.drawable.ic_foto_m150, R.drawable.ic_foto_m150_bw, false),
//    SPORT(4, "sport", R.string.sport_en, R.string.sport_ru, R.drawable.ic_sport_2_m150, R.drawable.ic_sport_2_m150_bw, false),
//    BUSINESS(5, "economics", R.string.business_en, R.string.economics_ru, R.drawable.ic_business_m150, R.drawable.ic_business_m150_bw, false),
//    STYLE(6, "interview", R.string.style_en, R.string.interview_ru, R.drawable.ic_style_m150, R.drawable.ic_style_m150_bw, false),
//    TRAVEL(7, "world", R.string.travelings_en, R.string.world_ru, R.drawable.ic_travel_m150, R.drawable.ic_travel_m150_bw, false),
//    POLICTICS(8, "politics", R.string.politics_en, R.string.politics_ru, R.drawable.ic_politics_m150, R.drawable.ic_politics_m150_bw, true),
//    FILMS(11, "video", R.string.cinema_en, R.string.video_ru, R.drawable.ic_cinema_2_m150, R.drawable.ic_cinema_2_m150_bw, false);
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
    private String idName;
    private int enResource;
    private int ruResource;
    private int imgResourceClicked;
    private int imgResourceUnclicked;
    private boolean isClicked;

    News(int id, String idName, int enResource, int rusResource, int imgResourceUnclicked, int imgResourceClicked, boolean isClicked) {
        this.id = id;
        this.idName = idName;
        this.enResource = enResource;
        this.ruResource = rusResource;
        this.imgResourceClicked = imgResourceClicked;
        this.imgResourceUnclicked = imgResourceUnclicked;
        this.isClicked = isClicked;
    }

    public int getId() { return this.id; }

    public String getIdName() {
        return this.idName;
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