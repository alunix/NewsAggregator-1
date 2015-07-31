package com.ua.art.newsaggregator.view.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ua.art.newsaggregator.Preferences;
import com.ua.art.newsaggregator.R;

import java.util.Arrays;

public class SettingsFragment extends Fragment {

    public static final String TAG = "MyLogS";

    //private ListView settingsListView;
    //private ArrayList<HashMap<String, String>> settingsList;
    private String[] settingsItemName;
    ListView settingsListView;

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
        settingsItemName = getResources().getStringArray(R.array.setings);
        Arrays.sort(settingsItemName);

        settingsListView = (ListView)view.findViewById(R.id.settingsListView);
//        ingsList.add("Обновление", "30мин.");
        listAdapter();
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

    private void listAdapter(){
        Log.d(TAG, "settingsItemName" + settingsItemName.toString());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, settingsItemName);
        settingsListView.setAdapter(adapter);
        registerForContextMenu(settingsListView);

        settingsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "itemClick = " + position + ", id = " + id);
                switch (position){
                    case 1:
                    showDialog();
                }
            }
        });
    }

    private void showDialog(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
        builder1.setMessage("Write your message here.");
        builder1.setCancelable(true);
        builder1.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder1.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }



}
