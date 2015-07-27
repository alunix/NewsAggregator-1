package com.ua.art.newsaggregator.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ua.art.newsaggregator.Preferences;
import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.model.News;
import com.ua.art.newsaggregator.model.SettingsNews;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingsFragment extends Fragment {
    public static final String TAG = "MyLogS";
    //private ListView settingsListView;
    //private ArrayList<HashMap<String, String>> settingsList;
    private static final int COLUMNS = 3;
    private int counter = 0;

    private static final String TAG_TITLE_SETTINGS = "title";
    private static final String TAG_DESCRIPTION_SETTINGS = "description";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_settings,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnExit = (Button)view.findViewById(R.id.btnExitLogin);
        btnExit.setOnClickListener(pressBtn);
        Button colorBtn = (Button)view.findViewById(R.id.colorButton);
        colorBtn.setOnClickListener(pressBtn);
        //settingsList = new ArrayList<>();
        ListView settingsListView = (ListView)view.findViewById(R.id.settingsListView);
//        settingsList.add("Обновление", "15мин.");
//        settingsList.add("Обновление", "30мин.");
        for (SettingsNews keySNews : SettingsNews.values()){
            String fdf = keySNews.getStoreNews();
        }
            String fd = SettingsNews.STORE_NEWS.getStoreNews();
        //listAdapter();


//        for (int j = 0; j < COLUMNS; j++, counter++) {
//            if (counter < News.values().length) {
//                //row.setPadding(0, 0, 10, 0);
//                String[] sdd = (SettingsNews.values()[counter]);
//            }
//        }

        String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
                "Костя", "Игорь", "Анна", "Денис", "Андрей" };
        //listAdapter(names);

    }


    private void addItemMenuSettings(){

    }

    private OnClickListener pressBtn = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnExitLogin:
                    Preferences.saveLogin("");
                    Preferences.savePassword("");
                    //Toast.makeText(context, "text", Toast.LENGTH_SHORT).show();
                    Log.v(TAG, "Exit");
                    break;
                case R.id.colorButton:
                    //R.color.window_background_news =
                default:
                    Log.v(TAG, "No exit");
                    break;
            }
        }
    };

//    private void listAdapter(String names){
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, names);
//    }



//    private void listAdapter(String title, String description){
//        ListAdapter adapter = new SimpleAdapter(
//                getActivity(), settingsList,
//                R.layout.item_settings,
//                new String[]{title, description},
//                new int[]{R.id.titleSettingsItemText, R.id.descripSettingsItemText});
//    }
}
