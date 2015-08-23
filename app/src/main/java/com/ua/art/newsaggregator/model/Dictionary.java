package com.ua.art.newsaggregator.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Dictionary for android sync with the server
 * */
public class Dictionary {
    private static String moduleId = "moduleId";
    private static String categoryId = "categoryId";
    private static String sourceId = "sourceId";

    private static String moduleIdServer = "moduleId";
    private static String categoryIdServer = "categoryId";
    public static String sourceIdServer = "sourceId";

//    private static ArrayList<HashMap<String, String>> moduleList = new ArrayList<>();
//    private static ArrayList<HashMap<String, String>> categoryList = new ArrayList<>();
    // TODO проверить и удальть sourceList
    public static ArrayList<HashMap<String, String>> sourceList = new ArrayList<>();

    public static ArrayList<String> synCategory = new ArrayList<>();

    public Dictionary() {

    }

    public void requestServer(){

    }

    public void getServer(){

    }

    public void compare(){

    }

//


}
