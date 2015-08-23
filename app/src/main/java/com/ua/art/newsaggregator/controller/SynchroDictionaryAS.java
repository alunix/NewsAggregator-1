package com.ua.art.newsaggregator.controller;

import android.os.AsyncTask;
import android.util.Log;

import com.ua.art.newsaggregator.controller.db.DBHelper;
import com.ua.art.newsaggregator.model.Dictionary;
import com.ua.art.newsaggregator.model.News;
import com.ua.art.newsaggregator.model.TemplateServer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Synchro Dictionary source, category, module
 * */
public class SynchroDictionaryAS {

    private static final String TAG_ID = "id";

    private DBHelper dbHelper;
    public static final String MODULE = "module";
    public static final String CATEGORY = "category";
    public static final String SOURCE = "sourse";
    public static final String URL_MODULE = "http://news.webstudia.dp.ua/index/exchangeModule";
    public static final String URL_CATEGORY = "http://news.webstudia.dp.ua/index/exchangeCategory";
    public static final String URL_SOURCE = "http://news.webstudia.dp.ua/index/exchangeSource";

    //ArrayList<String> nameSyn = new ArrayList<>();

    final String LOG_TAG = "synLogs";

    public SynchroDictionaryAS() {
        synchroDic();
    }

    // synchro
    private ArrayList<String> synchroDic() {
        new GetNews(CATEGORY).execute();
        return null;
    }
    //------------------------------ AsyncTask ------------------------------------
    private class GetNews extends AsyncTask<Void, Void, Void> {
        private String url;
        private String table;

        public GetNews(String table) {
            switch (table){
                case MODULE:
                    this.table = table;
                    url = URL_MODULE;
                    break;
                case CATEGORY:
                    this.table = table;
                    url = URL_CATEGORY;
                    Dictionary.synCategory.clear();
                    break;
                case SOURCE:
                    this.table = table;
                    url = URL_SOURCE;
                    break;
            }
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Log.d(LOG_TAG, "--- Insert in mytable: ---");
            HttpClient httpClient = new HttpClient();
            String jsonStr = httpClient.sendPost(url, TemplateServer.requestJsonNews());

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                if (jsonStr.charAt(0) != '[')
                    jsonStr = (String) jsonStr.subSequence(jsonStr.indexOf("["), jsonStr.lastIndexOf("]")+1);
                try {
                    JSONArray newsArray = new JSONArray(jsonStr);
                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject jObject = newsArray.getJSONObject(i);

                        for (News key : News.values()){
                            if(String.valueOf(key.getIdName()).equals(jObject.getString(TAG_ID))){
                                Dictionary.synCategory.add(jObject.getString(TAG_ID));          // synchronization
                            }
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
            return null;
        }
    }
}
