package com.ua.art.newsaggregator.model.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "item")
public class Item {

    @DatabaseField(canBeNull = true, generatedId = true)
    private int id;

    @DatabaseField(canBeNull = true)
    private String name;

    @DatabaseField(canBeNull = true)
    private String link;

    @DatabaseField(canBeNull = true)
    private String description;

    @DatabaseField(canBeNull = true)
    private String image;

    @DatabaseField(canBeNull = true)
    private String pubDate;

    @DatabaseField(canBeNull = true)
    private String text;

    //<-------------<-------------<---------------<---------------<
    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "source_id")
    private Source source;
    //<-------------<-------------<---------------<---------------<

    public Item() {
        // all persisted classes must define a no-arg constructor with at least package visibility
    }

    public Item(final String name, final String link, final String description, final String image, final String pubDate, final String text, final Source source) {
        this.name = name;
        this.link = link;
        this.description = description;
        this.image = image;
        this.pubDate = pubDate;
        this.text = text;
        this.source = source;
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

    public String getLink() {
        return this.link;
    }

    public void setLink(final String link) {
        this.link = link;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getPubDate() {
        return this.pubDate;
    }

    public void setPubDate(final String pubDate) {
        this.pubDate = pubDate;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public Source getSource() {
        return this.source;
    }

    public void setSource(final Source source) {
        this.source = source;
    }

    public final boolean hasId(){
        return 0 != this.id;
    }
}
