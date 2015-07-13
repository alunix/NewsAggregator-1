package com.ua.art.newsaggregator.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "accounts")
public class Account {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = true)
    private String name;

    @DatabaseField(canBeNull = true)
    private String password;

    @DatabaseField(canBeNull = true)
    private String sourse;

    @DatabaseField(canBeNull = true)
    private String category;            //id-category:id-category:id-category


    @DatabaseField(canBeNull = true)
    private String factorCategory;


    public Account() {
        // all persisted classes must define a no-arg constructor with at least package visibility
    }

    public Account(final String name, final String password, final String sourse, final String category, final String factorCategory) {
        this.name = name;
        this.password = password;
        this.sourse = sourse;
        this.category = category;
        this.factorCategory = factorCategory;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSourse() {
        return sourse;
    }

    public void setSourse(String sourse) {
        this.sourse = sourse;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFactorCategory() {
        return factorCategory;
    }

    public void setFactorCategory(String factorCategory) {
        this.factorCategory = factorCategory;
    }

    public final boolean hasId() {
        return 0 != this.id;
    }
}
