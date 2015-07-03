package com.ua.art.newsaggregator.model.entity;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "categotys")
public class Category {

	@DatabaseField(generatedId = true)
	private int id;

	@DatabaseField(canBeNull = true)
	private String name;

	//<-------------<-------------<---------------<---------------<
	@DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = "module_id")
	private Module module;
	//<-------------<-------------<---------------<---------------<

	//>------------->------------->--------------->--------------->
	@ForeignCollectionField
	private ForeignCollection<Source> sources;

	public ForeignCollection<Source> getSources() {
		return this.sources;
	}
	//>------------->------------->--------------->--------------->

	public Category() {
		// all persisted classes must define a no-arg constructor with at least package visibility
	}

	public Category(final String name, final Module module) {
		this.module = module;
		this.name = name;
	}



	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setModule(final Module module) {
		this.module = module;
	}

	public Module getModule() {
		return this.module;
	}

	public final boolean hasId() {
		return 0 != this.id;
	}
}
