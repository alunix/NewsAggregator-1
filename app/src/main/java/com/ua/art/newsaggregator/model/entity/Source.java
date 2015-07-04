package com.ua.art.newsaggregator.model.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "source")
public class Source {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = true)
    private String name;

    @DatabaseField(canBeNull = true)
    private String url;

    @DatabaseField(canBeNull = true)
    private String xml;

    @DatabaseField(canBeNull = true)
    private String title;

    @DatabaseField(canBeNull = true)
    private String description;

    //<-------------<-------------<---------------<---------------<
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "category_id")
    private Category category;
    //<-------------<-------------<---------------<---------------<

    //>------------->------------->--------------->--------------->
    @ForeignCollectionField
    private ForeignCollection<Item> item;

    public ForeignCollection<Item> getItem() {
        return this.item;
    }
    //>------------->------------->--------------->--------------->

    public Source() {
        // all persisted classes must define a no-arg constructor with at least package visibility
    }

    public Source(final String name, final String url, final String xml, final String title, final String description, final Category category) {
        this.name = name;
        this.url = url;
        this.xml = xml;
        this.title = title;
        this.description = description;
        this.category = category;
    }


    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getXml() {
        return this.xml;
    }

    public void setXml(final String xml) {
        this.xml = xml;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(final Category category) {
        this.category = category;
    }

    public final boolean hasId(){
        return 0 != this.id;
    }
}