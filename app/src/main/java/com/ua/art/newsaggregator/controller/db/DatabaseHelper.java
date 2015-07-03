package com.ua.art.newsaggregator.controller.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.ua.art.newsaggregator.model.entity.Category;
import com.ua.art.newsaggregator.model.entity.Item;
import com.ua.art.newsaggregator.model.entity.Module;
import com.ua.art.newsaggregator.model.entity.Source;

import java.sql.SQLException;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	// name of the database file for your application -- change to something appropriate for your app
	private static final String DATABASE_NAME = "DemoORM.db";
	// any time you make changes to your database objects, you may have to increase the database version
	private static final int DATABASE_VERSION = 2;

	public DatabaseHelper(final Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// the DAO object we use to access the SimpleData table
	private Dao<Module, Integer> moduleDao = null;
	private Dao<Category, Integer> categDao = null;
	private Dao<Source, Integer> srcDao = null;
	private Dao<Item, Integer> itemDao = null;

	@Override
	public void onCreate(final SQLiteDatabase db, final ConnectionSource connectionSource) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, Category.class);
			TableUtils.createTable(connectionSource, Module.class);
			TableUtils.createTable(connectionSource, Source.class);
			TableUtils.createTable(connectionSource, Item.class);
		}
		catch (final SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * This is called when your application is upgraded and it has a higher version number. This allows you to adjust the various data to
	 * match the new version number.
	 */
	@Override
	public void onUpgrade(final SQLiteDatabase db, final ConnectionSource connectionSource, final int oldVersion, final int newVersion) {
		try {
			Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connectionSource, Category.class, true);
			TableUtils.dropTable(connectionSource, Module.class, true);
			TableUtils.dropTable(connectionSource, Source.class, true);
			TableUtils.dropTable(connectionSource, Item.class, true);
			// after we drop the old databases, we create the new ones
			onCreate(db, connectionSource);
		}
		catch (final SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}



	public Dao<Module, Integer> getModuleDao() throws SQLException {
		if (this.moduleDao == null) {
			this.moduleDao = getDao(Module.class);
		}
		return this.moduleDao;
	}

	public Dao<Category, Integer> getCategoryDao() throws SQLException {
		if (this.categDao == null) {
			this.categDao = getDao(Category.class);
		}
		return this.categDao;
	}

	public Dao<Source, Integer> getSourceDao() throws SQLException {
		if (this.srcDao == null) {
			this.srcDao = getDao(Source.class);
		}
		return this.srcDao;
	}

	public Dao<Item, Integer> getItemDao() throws SQLException {
		if (this.itemDao == null) {
			this.itemDao = getDao(Item.class);
		}
		return this.itemDao;
	}

	/**
	 * Close the database connections and clear any cached DAOs.
	 */
	@Override
	public void close() {
		super.close();
		this.categDao = null;
		this.moduleDao = null;
		this.srcDao = null;
		this.itemDao = null;
	}

}
