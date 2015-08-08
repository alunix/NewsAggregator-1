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

    final String LOG_TAG = "dbLogs";

    public DbManager(Context context) {
        // создаем объект для создания и управления версиями БД
        dbHelper = new DBHelper(context);
        // создаем объект для данных
        ContentValues cv = new ContentValues();
        // подключаемся к БД
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "--- Insert in mytable: ---");
        // подготовим данные для вставки в виде пар: наименование столбца - значение

        String name = "name_test",
                url = "url_test",
                xml = "xml_test",
                title = "title_test",
                description = "description_test",
                moduleId = "moduleId_test",
                categoryId = "categoryId_test";



        cv.put(DBHelper.SOURCE_NAME, name);
        cv.put(DBHelper.SOURCE_URL, url);
        cv.put(DBHelper.SOURCE_XML, xml);
        cv.put(DBHelper.SOURCE_TITLE, title);
        cv.put(DBHelper.SOURCE_DESCRIPTION, description);
        cv.put(DBHelper.SOURCE_MODULEID, moduleId);
        cv.put(DBHelper.SOURCE_CATEGORYID, categoryId);
        // вставляем запись и получаем ее ID
        long rowID = db.insert(DBHelper.SOURCE_TABLENAME, null, cv);

        Log.d(LOG_TAG, "row inserted, ID = " + rowID);

        // закрываем подключение к БД
        dbHelper.close();

    }

    public void saveDbNews(ArrayList newsArr){
        // create an object to create and manage database versions
        dbHelper = new DBHelper(context);
        // create an object data
        ContentValues cv = new ContentValues();
        // connect to the database
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "--- Insert in mytable: ---");

        // prepare the data to be inserted in the form of steam: the name of the column - value

//        for (int i = 0; i < newsArr.size(); i++) {
//            for (int j = 0; j < newsArr.get(i); j++) {
//
//            }
//            newsArr.get(i)
//        }
//

        for (HashMap newsKey : newsArr) {
            HashMap dasd = newsKey;
        }


        for (HashMap newsKey : newsArr){

            cv.put(DBHelper.ITEM_NAME, String.valueOf(newsKey.get("name")));
            cv.put(DBHelper.ITEM_LINK, String.valueOf(newsKey.get("link")));
            cv.put(DBHelper.ITEM_DESCRIPTION, (String) newsKey.get("description"));
            cv.put(DBHelper.ITEM_IMAGE, (String) newsKey.get("image"));
            cv.put(DBHelper.ITEM_TEXT, String.valueOf(newsKey.get("text")));
            cv.put(DBHelper.ITEM_MODULEID, String.valueOf(newsKey.get("moduleId")));
            cv.put(DBHelper.ITEM_CATEGORYID, String.valueOf(newsKey.get("categoryId")));
            cv.put(DBHelper.ITEM_SOURCEID, String.valueOf(newsKey.get("sourceId")));
            // вставляем запись и получаем ее ID
            long rowID = db.insert(DBHelper.SOURCE_TABLENAME, null, cv);

            Log.d(LOG_TAG, "row inserted, ID = " + rowID);
        }



        // закрываем подключение к БД
        dbHelper.close();

    }
}
