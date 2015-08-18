package com.ua.art.newsaggregator.controller;

import android.os.AsyncTask;
import android.util.Log;

import com.ua.art.newsaggregator.controller.db.DbManager;
import com.ua.art.newsaggregator.model.TemplateServer;

import java.util.HashMap;

public class QueryServerPushRss {

    private static final String URL = "http://news.webstudia.dp.ua/index/request";
    private String rModuleId = "news";
    private String rCategoryId = "news_politics";
    private String rSourceId = "news_politics_liga";
    private String rId = "news_politics_liga";
    private String rQuantity = "news_politics_liga";
    private String rOlder = "news_politics_liga";

    public static final String LOG_TAG = "query";

    public QueryServerPushRss(){
    }

    public QueryServerPushRss(String rModuleId, String rCategoryId, String rSourceId) {
        this.rModuleId = rModuleId;
        this.rCategoryId = rCategoryId;
        this.rSourceId = rSourceId;
        new QueryServerTask(rModuleId, rCategoryId, rSourceId, rId, rQuantity, rOlder).execute();
    }

    private class QueryServerTask extends AsyncTask{

        private String moduleId = "news";
        private String categoryId = "news_politics";
        private String sourceId = "news_politics_liga";
        private String id = "";
        private String quantity = "";
        private String older = "";

        public QueryServerTask(String moduleId, String categoryId, String sourceId, String id, String quantity, String older) {
            this.moduleId = moduleId;
            this.categoryId = categoryId;
            this.sourceId = sourceId;
            this.id = "";
            this.quantity = "";
            this.older = "";
        }
        @Override
        protected Object doInBackground(Object[] objects) {
            HttpClient sh = new HttpClient();
            String jsonStr = sh.sendPost(URL, TemplateServer.requestJsonNews(
                    moduleId, categoryId, sourceId, id, quantity, older));
            Log.d("Response: ", "> " + jsonStr);

            return null;
        }
    }

    //public void queryServer_

//    public void autoAllQueryServer(){
//        for (HashMap<String, String> moduleKey : Dictionary.sourceList) {
//            new QueryServerTask(
//                    moduleKey.get(DbManager.TAG_ID_MODULE),
//                    moduleKey.get(DbManager.TAG_ID_CATEGORY),
//                    moduleKey.get(DbManager.TAG_ID_SOURCE)
//            );
//            Log.d(LOG_TAG, "autoAllQueryServer, TAG_ID_MODULE = " + DbManager.TAG_ID_MODULE +
//                            ", TAG_ID_CATEGORY = " + DbManager.TAG_ID_CATEGORY +
//                            ", TAG_ID_SOURCE = " + DbManager.TAG_ID_SOURCE);
//        }
//
//    }

}
