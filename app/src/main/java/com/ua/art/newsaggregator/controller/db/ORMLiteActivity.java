package com.ua.art.newsaggregator.controller.db;

import android.os.Bundle;
import android.view.Menu;

import com.j256.ormlite.android.apptools.OrmLiteBaseListActivity;
import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.model.entity.Module;

import java.util.List;

public class ORMLiteActivity extends OrmLiteBaseListActivity<DatabaseHelper> {

//	private ListView listView;
//	private ModuleAdaptor listAdapter;
	private Repository repository;

	private List<Module> modules;

	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.main t);

		this.repository = new Repository(getHelper());
		this.repository.clearData();
		this.modules = this.repository.getModules();







//		findAndCreateAllViews();
//
//		this.listAdapter = new ModuleAdaptor(this, R.layout.row_person_data, this.modules);
//
//		this.listView.setOnItemClickListener(new OnItemClickListener() {
//			@Override
//			public void onItemClick(final AdapterView<?> parent, final View view, final int position, final long duration) {
//				final Module module = ORMLiteActivity.this.listAdapter.getItem(position);
//				final ForeignCollection<Category> categories = module.getCategories();
//				final StringBuilder appList = new StringBuilder();
//				for (final Category category : categories) {
//					appList.append(category.getName())
//							.append("\n");
//				}
//				new AlertDialog.Builder(ORMLiteActivity.this).setTitle(
//						String.format("%s has a total of %s Apps", module.getName(), categories.size()))
//						.setMessage(appList.toString())
//						.show();
//			}
//		});
//
//		this.listView.setAdapter(this.listAdapter);
//		registerForContextMenu(this.listView);
	}

	private static final int MENU_ADD_APP = Menu.FIRST;
	private static final int MENU_DELETE_PERSON = Menu.FIRST + 1;
	private static final int MENU_EDIT_PERSON = Menu.FIRST + 2;

//	@Override
//	public void onCreateContextMenu(final ContextMenu menu, final View v, final ContextMenuInfo menuInfo) {
//		if (v.getId() == getListView().getId()) {
//			final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
//			final Module module = this.modules.get(info.position);
//			menu.setHeaderTitle(module.getId() + " | " + module.getName());
//			menu.add(Menu.NONE, MENU_ADD_APP, MENU_ADD_APP, "Add App");
//			menu.add(Menu.NONE, MENU_DELETE_PERSON, MENU_DELETE_PERSON, "Delete Person");
//			menu.add(Menu.NONE, MENU_EDIT_PERSON, MENU_EDIT_PERSON, "Edit Person");
//		}
//	}
//
//	@Override
//	public boolean onContextItemSelected(final MenuItem item) {
//		final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
//		final int menuItemIndex = item.getItemId();
//		final Module module = this.modules.get(info.position);
//
//		final LayoutInflater factory = LayoutInflater.from(this);
//		final View textEntryView = factory.inflate(R.layout.alert_dialog_text_entry, null);
//		final EditText editText = (EditText) textEntryView.findViewById(R.id.edit_text_dialog);
//
//		switch (menuItemIndex) {
//			case MENU_ADD_APP:
//				new AlertDialog.Builder(this).setTitle("Add App")
//						.setView(textEntryView)
//						.setPositiveButton("Add", new DialogInterface.OnClickListener() {
//							@Override
//							public void onClick(final DialogInterface dialog, final int whichButton) {
//								final Category category = new Category();
//								category.setModule(module);
//								category.setName(editText.getText()
//										.toString());
//								ORMLiteActivity.this.repository.saveOrUpdateCategory(category);
//								ORMLiteActivity.this.listAdapter.notifyDataSetChanged();
//							}
//						})
//						.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//							@Override
//							public void onClick(final DialogInterface dialog, final int whichButton) {
//							/* User clicked cancel so do some stuff */
//							}
//						})
//						.show();
//				break;
//			case MENU_DELETE_PERSON:
//				this.modules.remove(info.position);
//				this.repository.deleteModule(module);
//				this.listAdapter.notifyDataSetChanged();
//				break;
//			case MENU_EDIT_PERSON:
//				// Set name for editing
//				editText.setText(module.getName());
//
//				new AlertDialog.Builder(this).setTitle("Edit Person")
//						.setView(textEntryView)
//						.setPositiveButton("Update", new DialogInterface.OnClickListener() {
//							@Override
//							public void onClick(final DialogInterface dialog, final int whichButton) {
//								module.setName(editText.getText()
//										.toString());
//								ORMLiteActivity.this.repository.saveOrUpdateModule(module);
//								ORMLiteActivity.this.listAdapter.notifyDataSetChanged();
//							}
//						})
//						.show();
//				break;
//			default:
//				break;
//		}
//		return true;
//	}
	//TODO add table SQLitle
	//--------------------------------------------test-----------------------------
//	private void createFakeEntriesTEST() {
//		// Create Two test Module
//		final Module module = new Module();
//		module.setName("James");
//		this.repository.saveOrUpdateModule(module);
//
//		final Module module2 = new Module();
//		module2.setName("Jimmy");
//		this.repository.saveOrUpdateModule(module2);
//
//		// Create two test categors
//		final Category category = new Category();
//		category.setName("categoryName");
//		category.setModule(module);
//		this.repository.saveOrUpdateCategory(category);
//
//		final Category category2 = new Category();
//		category2.setName("category2Name");
//		category2.setModule(module2);
//		this.repository.saveOrUpdateCategory(category2);
//
//		final Category category3 = new Category();
//		category3.setName("category2Name");
//		category3.setModule(module2);
//		this.repository.saveOrUpdateCategory(category3);
//
//		// Create two test srcs
//		final Source sourceEntity = new Source();
//		sourceEntity.setName("sourceName");
//		sourceEntity.setUrl("www.android.com");
//		sourceEntity.setXml("http://");
//		sourceEntity.setTitle("NewsMy");
//		sourceEntity.setDescription("Description");
//		sourceEntity.setCategory(category);
//		this.repository.saveOrUpdateSourse(sourceEntity);
//	}
//	//--------------------------------------------test-----------------------------
//
//	public void findAndCreateAllViews() {
//		this.listView = getListView();
//		registerForContextMenu(this.listView);
//	}
}
