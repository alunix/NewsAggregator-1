package com.ua.art.newsaggregator.controller.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DbManager {
    private DBHelper dbHelper;
    private Context context;
    //private ContentValues cv;

    final String LOG_TAG = "dbLogs";

    public DbManager(Context context) {

        // создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(context);
        // создаем объект для данных
        ContentValues cvModule = new ContentValues();
        ContentValues cvCategory = new ContentValues();
        ContentValues cvSource = new ContentValues();
        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "--- Insert in mytable: ---");
        // подготовим данные для вставки в виде пар: наименование столбца - значение

        String name = "name_test",
                id_test = "1",
                url = "url_test",
                xml = "xml_test",
                title = "title_test",
                description = "description_test",
                moduleId = "moduleId_test",
                categoryId = "categoryId_test";

        // start table Module
        cvModule.put(DBHelper.MODULE_ID, id_test);
        cvModule.put(DBHelper.MODULE_NAME, title);
        long rowIDm = db.insert(DBHelper.MODULE_TABLENAME, null, cvModule);
        Log.d(LOG_TAG, "row inserted," + DBHelper.MODULE_TABLENAME + " ID = " + rowIDm);

        // start table Category
        cvCategory.put(DBHelper.CATEGORY_ID, id_test);
        cvCategory.put(DBHelper.CATEGORY_NAME, title);
        cvCategory.put(DBHelper.CATEGORY_MODULEID, moduleId);
        long rowIDc = db.insert(DBHelper.CATEGORY_TABLENAME, null, cvCategory);
        Log.d(LOG_TAG, "row inserted," + DBHelper.CATEGORY_TABLENAME + " ID = " + rowIDc);

        // start table Source
        cvSource.put(DBHelper.SOURCE_ID, id_test);
        cvSource.put(DBHelper.SOURCE_NAME, name);
        cvSource.put(DBHelper.SOURCE_URL, url);
        cvSource.put(DBHelper.SOURCE_XML, xml);
        cvSource.put(DBHelper.SOURCE_TITLE, title);
        cvSource.put(DBHelper.SOURCE_DESCRIPTION, description);
        cvSource.put(DBHelper.SOURCE_MODULEID, moduleId);
        cvSource.put(DBHelper.SOURCE_CATEGORYID, categoryId);
        // вставляем запись и получаем ее ID
        long rowIDs = db.insert(DBHelper.SOURCE_TABLENAME, null, cvSource);
        Log.d(LOG_TAG, "row inserted," + DBHelper.SOURCE_TABLENAME + " ID = " + rowIDs);


//        String name = "name_test",
//                id = "113",
//                url = "url_test",
//                xml = "xml_test",
//                title = "title_test",
//                description = "description_test",
//                image = "description_test",
//                pubDate = "description_test",
//                text = "description_test",
//                moduleId = "2",
//                categoryId = "1",
//                sourceId = "1";
//
//        cv.put(DBHelper.ITEM_ID, id);
//        cv.put(DBHelper.ITEM_NAME, name);
//        cv.put(DBHelper.ITEM_LINK, url);
//        cv.put(DBHelper.ITEM_DESCRIPTION, description);
//        cv.put(DBHelper.ITEM_IMAGE, image);
//        cv.put(DBHelper.ITEM_PUBDATE, pubDate);
//        cv.put(DBHelper.ITEM_TEXT, text);
//        cv.put(DBHelper.ITEM_MODULEID, moduleId);
//        cv.put(DBHelper.ITEM_CATEGORYID, categoryId);
//        cv.put(DBHelper.ITEM_SOURCEID, sourceId);
//        // вставляем запись и получаем ее ID
//        long rowIDi = db.insert(DBHelper.ITEM_TABLENAME, null, cv);
//        Log.d(LOG_TAG, "row inserted," + DBHelper.ITEM_TABLENAME + " ID = " + rowIDi);


        // закрываем подключение к БД
        dbHelper.close();

    }

    public void saveDbNews(ArrayList<HashMap<String, String>> newsArr){
//        // create an object to create and manage database versions
//        dbHelper = new DBHelper(context);
//        // create an object data
        ContentValues cv = new ContentValues();

        // connect to the database
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "--- Insert in mytable: ---");



        //        String name = "name_test",
//                id = "116",
//                url = "url_test",
//                xml = "xml_test",
//                title = "title_test",
//                description = "description_test",
//                image = "description_test",
//                pubDate = "description_test",
//                text = "description_test",
//                moduleId = "1",
//                categoryId = "1",
//                sourceId = "1";
//
//            cv.put(DBHelper.ITEM_ID, id);
//            cv.put(DBHelper.ITEM_NAME, name);
//            cv.put(DBHelper.ITEM_LINK, url);
//            cv.put(DBHelper.ITEM_DESCRIPTION, description);
//            cv.put(DBHelper.ITEM_IMAGE, image);
//            cv.put(DBHelper.ITEM_PUBDATE, pubDate);
//            cv.put(DBHelper.ITEM_TEXT, text);
//            cv.put(DBHelper.ITEM_MODULEID, moduleId);
//            cv.put(DBHelper.ITEM_CATEGORYID, categoryId);
//            cv.put(DBHelper.ITEM_SOURCEID, sourceId);
//        long rowIDi = db.insert(DBHelper.ITEM_TABLENAME, null, cv);
//        Log.d(LOG_TAG, "row inserted," + DBHelper.ITEM_TABLENAME + " ID = " + rowIDi);


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
}
