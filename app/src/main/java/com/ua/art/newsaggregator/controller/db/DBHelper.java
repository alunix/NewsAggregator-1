package com.ua.art.newsaggregator.controller.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public static final String MODULE_TABLENAME = "Module";
    public static final String MODULE_ID = "id_module";
    public static final String MODULE_NAME = "name_module";

    public static final String SOURCE_TABLENAME = "Source";
    public static final String SOURCE_ID = "id_source";
    public static final String SOURCE_NAME = "name_source";
    public static final String SOURCE_URL = "url_source";
    public static final String SOURCE_XML = "xml_source";
    public static final String SOURCE_TITLE = "title_source";
    public static final String SOURCE_DESCRIPTION = "description_source";
    public static final String SOURCE_MODULEID = "moduleId_source";
    public static final String SOURCE_CATEGORYID = "categoryId_source";

    public static final String CATEGORY_TABLENAME = "Category";
    public static final String CATEGORY_ID = "id_category";
    public static final String CATEGORY_NAME = "name_category";
    public static final String CATEGORY_MODULEID = "moduleId_category";

    public static final String ITEM_TABLENAME = "Item";
    public static final String ITEM_ID = "id_item";
    public static final String ITEM_LINK = "link_item";
    public static final String ITEM_NAME = "name_item";
    public static final String ITEM_DESCRIPTION = "description_item";
    public static final String ITEM_IMAGE = "image_item";
    public static final String ITEM_PUBDATE = "pubDate_item";
    public static final String ITEM_TEXT = "text_item";
    public static final String ITEM_MODULEID = "moduleId_item";
    public static final String ITEM_CATEGORYID = "categoryId_item";
    public static final String ITEM_SOURCEID = "sourceId_item";

    private static final String DB_NAME = "newsDB";
    private static final int VERSION = 1;

    final String LOG_TAG = "dbLogs";

    public DBHelper(Context context) {
        // конструктор суперкласса
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // -------------------------- create tables ---------------------
        db.execSQL("CREATE TABLE " + MODULE_TABLENAME + " ("
                + MODULE_ID + " text primary key,"         // " integer primary key autoincrement,"
                + MODULE_NAME + " text"
                + ");");
        Log.d(LOG_TAG, "--- onCreate database /Module/ ---");

        db.execSQL("CREATE TABLE " + SOURCE_TABLENAME + " ("
                + SOURCE_ID + " text primary key,"
                + SOURCE_NAME + " text,"
                + SOURCE_URL + " text,"
                + SOURCE_XML + " text,"
                + SOURCE_TITLE + " text,"
                + SOURCE_DESCRIPTION + " text,"
                + SOURCE_MODULEID + " text,"
                + SOURCE_CATEGORYID + " text,"
                + "FOREIGN KEY (" + SOURCE_MODULEID + ") REFERENCES " + MODULE_TABLENAME + "(" + MODULE_ID + "),"
                + "FOREIGN KEY (" + SOURCE_CATEGORYID + ") REFERENCES " + CATEGORY_TABLENAME + "(" + CATEGORY_ID + ")"
                + ");");
        Log.d(LOG_TAG, "--- onCreate database /Source/ ---");

        db.execSQL("CREATE TABLE " + CATEGORY_TABLENAME + " ("
                + CATEGORY_ID + " text primary key,"
                + CATEGORY_NAME + " text,"
                + CATEGORY_MODULEID + " text"
                + ");");
        Log.d(LOG_TAG, "--- onCreate database /Category/ ---");

        db.execSQL("CREATE TABLE " + ITEM_TABLENAME +" ("
                + ITEM_ID + " text primary key,"
                + ITEM_NAME + " text,"
                + ITEM_LINK + " text,"
                + ITEM_DESCRIPTION + " text,"
                + ITEM_IMAGE + " text,"
                + ITEM_PUBDATE + " text,"
                + ITEM_TEXT + " text,"
                + ITEM_MODULEID + " text,"
                + ITEM_CATEGORYID + " text,"
                + ITEM_SOURCEID + " text,"
                + "FOREIGN KEY (" + ITEM_MODULEID + ") REFERENCES " + MODULE_TABLENAME + "(" + MODULE_ID + "),"
                + "FOREIGN KEY (" + ITEM_CATEGORYID + ") REFERENCES " + CATEGORY_TABLENAME + "(" + CATEGORY_ID + "),"
                + "FOREIGN KEY (" + ITEM_SOURCEID + ") REFERENCES " + SOURCE_TABLENAME + "(" + SOURCE_ID + ")"
                + ");");
        Log.d(LOG_TAG, "--- onCreate database /Item/ ---");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Здесь реализуются изменения схемы и преобразования данных
        // при обновлении схемы
    }
}
