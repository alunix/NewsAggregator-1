package com.ua.art.newsaggregator.controller.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.ua.art.newsaggregator.controller.HttpClient;
import com.ua.art.newsaggregator.model.Dictionary;
import com.ua.art.newsaggregator.model.TemplateServer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DbManager {
    private DBHelper dbHelper;
    private Context context;
    //private ContentValues cv;

    public static final String TAG_ID_MODULE = "id";
    public static final String TAG_NAME_MODULE = "name";

    public static final String TAG_ID_CATEGORY = "id";
    public static final String TAG_NAME_CATEGORY = "name";
    public static final String TAG_MODULEID_CATEGORY = "moduleId";

    public static final String TAG_ID_SOURCE = "id";
    public static final String TAG_NAME_SOURCE = "name";
    public static final String TAG_URL_SOURCE = "url";
    public static final String TAG_XML_SOURCE = "xml";
    public static final String TAG_TITLE_SOURCE = "title";
    public static final String TAG_DESCRIPTION_SOURCE = "description";
    public static final String TAG_MODULEID_SOURCE = "moduleId";
    public static final String TAG_CATEGORYID_SOURCE = "categoryId";

    public static final String MODULE = "module";
    public static final String CATEGORY = "category";
    public static final String SOURCE = "sourse";
    public static final String URL_MODULE = "http://news.webstudia.dp.ua/index/exchangeModule";
    public static final String URL_CATEGORY = "http://news.webstudia.dp.ua/index/exchangeCategory";
    public static final String URL_SOURCE = "http://news.webstudia.dp.ua/index/exchangeSource";

//    private ListView lv;
//    private JSONArray news = null;
    private ArrayList<HashMap<String, String>> moduleList;
    private ArrayList<HashMap<String, String>> categoryList;
    private ArrayList<HashMap<String, String>> sourceList;

    final String LOG_TAG = "dbLogs";

    public DbManager(Context context) {

        moduleList = new ArrayList<>();
        categoryList = new ArrayList<>();
        sourceList = new ArrayList<>();
        // создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(context);

        // подготовим данные для вставки в виде пар: наименование столбца - значение
        new GetNews(MODULE).execute();
        new GetNews(CATEGORY).execute();
        new GetNews(SOURCE).execute();

        // закрываем подключение к БД
        dbHelper.close();

    }

    public void saveDbNews(ArrayList<HashMap<String, String>> newsArr){
//        // create an object data
        ContentValues cv = new ContentValues();

        // connect to the database
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "--- Insert in mytable: ---");

        // prepare the data to be inserted in the form of steam: the name of the column - value
        for (HashMap<String, String> newsKey : newsArr){
            cv.put(DBHelper.ITEM_ID, newsKey.get("id"));
            cv.put(DBHelper.ITEM_NAME, newsKey.get("name"));
            cv.put(DBHelper.ITEM_LINK, newsKey.get("link"));
            cv.put(DBHelper.ITEM_DESCRIPTION, newsKey.get("description"));
            cv.put(DBHelper.ITEM_IMAGE, newsKey.get("image"));
            cv.put(DBHelper.ITEM_PUBDATE, newsKey.get("pubDate"));
            cv.put(DBHelper.ITEM_TEXT, newsKey.get("text"));
            cv.put(DBHelper.ITEM_MODULEID, newsKey.get("moduleId"));
            cv.put(DBHelper.ITEM_CATEGORYID, newsKey.get("categoryId"));
            cv.put(DBHelper.ITEM_SOURCEID, newsKey.get("sourceId"));
            // insert a record and get her ID / вставляем запись и получаем ее ID
            long rowIDi = db.insert(DBHelper.ITEM_TABLENAME, null, cv);
            Log.d(LOG_TAG, "row inserted," + DBHelper.ITEM_TABLENAME + " ID = " + rowIDi);
        }
        // закрываем подключение к БД
        dbHelper.close();
    }

    public void selectDbNews(ArrayList<HashMap<String, String>> newsArr){
        // create an object data
        ContentValues cv = new ContentValues();

        // connect to the database
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "--- select in mytable: ---");

        // делаем запрос всех данных из таблицы mytable, получаем Cursor
        Cursor c = db.query("mytable", null, null, null, null, null, null);
        // ставим позицию курсора на первую строку выборки
        // если в выборке нет строк, вернется false
        if (c.moveToFirst()) {

            // определяем номера столбцов по имени в выборке
            int idColIndex = c.getColumnIndex("id");
            int nameColIndex = c.getColumnIndex("name");
            int linkColIndex = c.getColumnIndex("link");
            int descriptionColIndex = c.getColumnIndex("description");
            int imageColIndex = c.getColumnIndex("image");
            int pubDateColIndex = c.getColumnIndex("pubDate");
            int textColIndex = c.getColumnIndex("text");
            int moduleIdColIndex = c.getColumnIndex("moduleId");
            int categoryIdColIndex = c.getColumnIndex("categoryId");
            int sourceIdIdColIndex = c.getColumnIndex("sourceId");

            do {
                // получаем значения по номерам столбцов и пишем все в лог
                Log.d(LOG_TAG,
                        "id = " + c.getInt(idColIndex) +
                        ", name = " + c.getString(nameColIndex) +
                        ", link = " + c.getString(linkColIndex) +
                        ", description = " + c.getString(descriptionColIndex) +
                        ", image = " + c.getString(imageColIndex) +
                        ", pubDate = " + c.getString(pubDateColIndex) +
                        ", text = " + c.getString(textColIndex) +
                        ", moduleId = " + c.getString(moduleIdColIndex) +
                        ", categoryId = " + c.getString(categoryIdColIndex) +
                        ", sourceId = " + c.getString(sourceIdIdColIndex));
                // переход на следующую строку
                // а если следующей нет (текущая - последняя), то false - выходим из цикла
            } while (c.moveToNext());
        } else
            Log.d(LOG_TAG, "0 rows");
        c.close();
        // close the database connection
        dbHelper.close();
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
                    break;
                case SOURCE:
                    this.table = table;
                    url = URL_SOURCE;
                    break;
            }
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            // подключаемся к БД
            SQLiteDatabase db = dbHelper.getWritableDatabase();
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
                        HashMap<String, String> contact = new HashMap<>();

                        switch (table){
                            case MODULE:
                                contact.clear();
                                String idM = jObject.getString(TAG_ID_MODULE);
                                String nameM = checkString(jObject.getString(TAG_NAME_MODULE));
                                contact.put(TAG_ID_MODULE, checkString(idM));
                                contact.put(TAG_NAME_MODULE, checkString(nameM));
                                moduleList.add(contact);

                                // создаем объект для данных
                                ContentValues cvModule = new ContentValues();
                                // start table Module
                                for (HashMap<String, String> moduleKey : moduleList) {
                                    cvModule.put(DBHelper.MODULE_ID, moduleKey.get(TAG_ID_MODULE));
                                    cvModule.put(DBHelper.MODULE_NAME, moduleKey.get(TAG_NAME_MODULE));
                                    long rowIDm = db.insert(DBHelper.MODULE_TABLENAME, null, cvModule);
                                    Log.d(LOG_TAG, "row inserted," + DBHelper.MODULE_TABLENAME + " ID = " + rowIDm);
                                }
                                break;
                            case CATEGORY:
                                contact.clear();
                                String idC = jObject.getString(TAG_ID_CATEGORY);
                                String nameC = checkString(jObject.getString(TAG_NAME_CATEGORY));
                                String moduleIdC = checkString(jObject.getString(TAG_MODULEID_CATEGORY));
                                contact.put(TAG_ID_CATEGORY, checkString(idC));
                                contact.put(TAG_NAME_CATEGORY, checkString(nameC));
                                contact.put(TAG_MODULEID_CATEGORY, checkString(moduleIdC));
                                categoryList.add(contact);

                                ContentValues cvCategory = new ContentValues();
                                // start table Category
                                for (HashMap<String, String> categoryKey : categoryList) {
                                    cvCategory.put(DBHelper.CATEGORY_ID, categoryKey.get(TAG_ID_CATEGORY));
                                    cvCategory.put(DBHelper.CATEGORY_NAME, categoryKey.get(TAG_NAME_CATEGORY));
                                    cvCategory.put(DBHelper.CATEGORY_MODULEID, categoryKey.get(TAG_MODULEID_CATEGORY));
                                    long rowIDc = db.insert(DBHelper.CATEGORY_TABLENAME, null, cvCategory);
                                    Log.d(LOG_TAG, "row inserted," + DBHelper.CATEGORY_TABLENAME + " ID = " + rowIDc);
                                }
                                break;
                            case SOURCE:
                                contact.clear();
                                String idS = jObject.getString(TAG_ID_SOURCE);
                                String nameS = checkString(jObject.getString(TAG_NAME_SOURCE));
                                String urlS = checkString(jObject.getString(TAG_URL_SOURCE));
                                String xmlS = checkString(jObject.getString(TAG_XML_SOURCE));
                                String titleS = checkString(jObject.getString(TAG_TITLE_SOURCE));
                                String descriptionS = checkString(jObject.getString(TAG_DESCRIPTION_SOURCE));
                                String moduleIdS = checkString(jObject.getString(TAG_MODULEID_SOURCE));
                                String categoryIdS = checkString(jObject.getString(TAG_CATEGORYID_SOURCE));
                                contact.put(TAG_ID_SOURCE, checkString(idS));
                                contact.put(TAG_NAME_SOURCE, checkString(nameS));
                                contact.put(TAG_URL_SOURCE, checkString(urlS));
                                contact.put(TAG_XML_SOURCE, checkString(xmlS));
                                contact.put(TAG_TITLE_SOURCE, checkString(titleS));
                                contact.put(TAG_DESCRIPTION_SOURCE, checkString(descriptionS));
                                contact.put(TAG_MODULEID_SOURCE, checkString(moduleIdS));
                                contact.put(TAG_CATEGORYID_SOURCE, checkString(categoryIdS));
                                sourceList.add(contact);
                                //Dictionary.sourceList = sourceList;

                                Collections.copy(Dictionary.sourceList, sourceList);    // copy to Dictionary (Settings)

                                ContentValues cvSource = new ContentValues();
                                // start table Source
                                for (HashMap<String, String> sourceKey : sourceList) {
                                    cvSource.put(DBHelper.SOURCE_ID, sourceKey.get(TAG_ID_SOURCE));
                                    cvSource.put(DBHelper.SOURCE_NAME, sourceKey.get(TAG_NAME_SOURCE));
                                    cvSource.put(DBHelper.SOURCE_URL, sourceKey.get(TAG_URL_SOURCE));
                                    cvSource.put(DBHelper.SOURCE_XML, sourceKey.get(TAG_XML_SOURCE));
                                    cvSource.put(DBHelper.SOURCE_TITLE, sourceKey.get(TAG_TITLE_SOURCE));
                                    cvSource.put(DBHelper.SOURCE_DESCRIPTION, sourceKey.get(TAG_DESCRIPTION_SOURCE));
                                    cvSource.put(DBHelper.SOURCE_MODULEID, sourceKey.get(TAG_MODULEID_SOURCE));
                                    cvSource.put(DBHelper.SOURCE_CATEGORYID, sourceKey.get(TAG_CATEGORYID_SOURCE));
                                    // вставляем запись и получаем ее ID
                                    long rowIDs = db.insert(DBHelper.SOURCE_TABLENAME, null, cvSource);
                                    Log.d(LOG_TAG, "row inserted," + DBHelper.SOURCE_TABLENAME + " ID = " + rowIDs);
                                }
                                break;
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            // закрываем подключение к БД
            dbHelper.close();
            return null;
        }

        private String checkString(String sTag){
            if (sTag.equals("null"))
                return "";
            else
                return sTag;
        }
    }
}
