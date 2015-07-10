package com.ua.art.newsaggregator.controller.db;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.model.entity.Module;

import java.util.List;


public class ModuleAdaptor extends ArrayAdapter<Module> {

	private final String LOG_TAG = "PersonAdapter";

	private List<Module> modules = null;
	private Activity context = null;

	public ModuleAdaptor(final Activity context, final int textViewResourceId, final List<Module> modules) {
		super(context, textViewResourceId, modules);
		this.context = context;
		this.modules = modules;
	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			final LayoutInflater vi = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = vi.inflate(R.layout.row_person_data, null);

			holder = new ViewHolder();
			holder.name = (TextView) view.findViewById(R.id.name);
			holder.numberOfApps = (TextView) view.findViewById(R.id.number_of_apps);
			view.setTag(holder);
		}
		else {
			holder = (ViewHolder) view.getTag();
		}

		final Module module = this.modules.get(position);
		Log.d(this.LOG_TAG, module.getName());

		if (module != null) {
			final TextView name = (TextView) view.findViewById(R.id.name);
			name.setText(module.getName());

			final TextView numOfApps = (TextView) view.findViewById(R.id.number_of_apps);
			numOfApps.setText(Integer.toString(module.getCategories()
					.size()));
		}

		return view;
	}

	class ViewHolder {
		TextView name;
		TextView numberOfApps;
	}

}
