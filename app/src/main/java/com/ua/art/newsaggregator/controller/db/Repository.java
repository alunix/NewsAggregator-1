package com.ua.art.newsaggregator.controller.db;

import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.ForeignCollection;
import com.ua.art.newsaggregator.model.entity.Category;
import com.ua.art.newsaggregator.model.entity.Item;
import com.ua.art.newsaggregator.model.entity.Module;
import com.ua.art.newsaggregator.model.entity.Source;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Repository {
    private final static String LOG_TAG = "DemoRepository";

    private Dao<Module, Integer> moduleDao;
    private Dao<Category, Integer> categDao;
    private Dao<Source, Integer> srcDao;
    private Dao<Item, Integer> itemDao;

    public Repository(final DatabaseHelper databaseHelper) {
        this.moduleDao = getModuleDao(databaseHelper);
        this.categDao = getAppDao(databaseHelper);
        this.srcDao = getSrcDao(databaseHelper);
        this.itemDao = getItemDao(databaseHelper);
    }

    public void clearData() {
        final List<Module> modules = getModules();
        for (final Module module : modules) {
            deleteModule(module);
        }
        final List<Category> categorys = getCategorys();
        for (final Category category : categorys) {
            deleteCategory(category);
        }
        final List<Source> sources = getSources();
        for (final Source source : sources) {
            deleteSource(source);
        }
    }

    public List<Module> getModules() {
        try {
            return this.moduleDao.queryForAll();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Module>();
    }

    public List<Category> getCategorys() {
        try {
            return this.categDao.queryForAll();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Category>();
    }

    public List<Source> getSources() {
        try {
            return this.srcDao.queryForAll();
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Source>();
    }


    public void saveOrUpdateModule(final Module module) {
        try {
            this.moduleDao.createOrUpdate(module);
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveOrUpdateCategory(final Category category) {
        try {
            this.categDao.createOrUpdate(category);
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveOrUpdateSourse(final Source source) {
        try {
            this.srcDao.createOrUpdate(source);
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteModule(final Module module) {
        try {
            final ForeignCollection<Category> categories = module.getCategories();
            for (final Category category : categories) {
                this.categDao.delete(category);
            }
            this.moduleDao.delete(module);
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategory(final Category category) {
        try {
            final ForeignCollection<Source> sources = category.getSources();
            for (final Source source : sources) {
                this.srcDao.delete(source);
            }
            this.categDao.delete(category);
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSource(final Source source) {
        try {
            final ForeignCollection<Item> items = source.getItem();
            for (final Item item : items) {
                this.itemDao.delete(item);
            }
            this.srcDao.delete(source);
        }
        catch (final SQLException e) {
            e.printStackTrace();
        }
    }



    private Dao<Module, Integer> getModuleDao(final DatabaseHelper databaseHelper) {
        if (null == this.moduleDao) {
            try {
                this.moduleDao = databaseHelper.getModuleDao();
            }
            catch (final SQLException e) {
                Log.e(LOG_TAG, "Unable to load DAO: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return this.moduleDao;
    }

    private Dao<Category, Integer> getAppDao(final DatabaseHelper databaseHelper) {
        if (null == this.categDao) {
            try {
                this.categDao = databaseHelper.getCategoryDao();
            }
            catch (final SQLException e) {
                Log.e(LOG_TAG, "Unable to load DAO: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return this.categDao;
    }

    private Dao<Source, Integer> getSrcDao(final DatabaseHelper databaseHelper) {
        if (null == this.srcDao) {
            try {
                this.srcDao = databaseHelper.getSourceDao();
            }
            catch (final SQLException e) {
                Log.e(LOG_TAG, "Unable to load DAO: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return this.srcDao;
    }

    private Dao<Item, Integer> getItemDao(final DatabaseHelper databaseHelper) {
        if (null == this.itemDao) {
            try {
                this.itemDao = databaseHelper.getItemDao();
            }
            catch (final SQLException e) {
                Log.e(LOG_TAG, "Unable to load DAO: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return this.itemDao;
    }
}
