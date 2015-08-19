package com.ua.art.newsaggregator.view.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
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
import android.widget.TextView;

import com.ua.art.newsaggregator.Preferences;
import com.ua.art.newsaggregator.R;

import java.util.Arrays;

public class SettingsFragment extends Fragment {

    public static final String TAG = "MyLogS";

    private static final int SAVENEWS_DIALOG_SETTINGS = 1;
    private static final int AUTOUPDATE_DIALOG_SETTINGS = 2;

    //private ListView settingsListView;
    //private ArrayList<HashMap<String, String>> settingsList;
    private TextView loginText;
    private String[] settingsItemName;
    private String[] settingsSaveNews;
    private String[] settingsAutoupdate;
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
        loginText = (TextView)view.findViewById(R.id.loginText);
        //settingsList = new ArrayList<>();
        settingsItemName = getResources().getStringArray(R.array.setings);
        Arrays.sort(settingsItemName);
        settingsSaveNews = getResources().getStringArray(R.array.settings_saveNews);
        Arrays.sort(settingsSaveNews);
        settingsAutoupdate = getResources().getStringArray(R.array.settings_autoupdate);
        Arrays.sort(settingsAutoupdate);

        settingsListView = (ListView)view.findViewById(R.id.settingsListView);
//        ingsList.add("Обновление", "30мин.");
        listAdapter();
        getLoginTextView();
    }

    private void getLoginTextView(){
        loginText.setText(Preferences.getLogin());
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
                switch (position) {
                    case 0:
                        showDialog(AUTOUPDATE_DIALOG_SETTINGS);
                        break;
                    case 1:
                        showDialog(SAVENEWS_DIALOG_SETTINGS);
                        break;
                }
            }
        });
    }




    private void showDialog(int id){
        AlertDialog.Builder builderDialog = new AlertDialog.Builder(getActivity());
        switch(id){
            case SAVENEWS_DIALOG_SETTINGS:
                builderDialog.setTitle(R.string.title_settings_saveNews)
                        .setCancelable(true)
                                // add switches
                        .setSingleChoiceItems(settingsSaveNews, 1,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int item) {
                                        Log.d(TAG, "Items = " + item);
                                        dialog.cancel();
                                    }
                                });
                break;
            case AUTOUPDATE_DIALOG_SETTINGS:
                builderDialog.setTitle(R.string.title_settings_autoupdate)
                        .setCancelable(true)
                        // add switches
                        .setSingleChoiceItems(settingsAutoupdate, 1,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog,
                                                        int item) {
                                        Log.d(TAG, "Items = " + item);
                                        dialog.cancel();
                                    }
                                });
                break;
        }

        AlertDialog alertDialog = builderDialog.create();
        alertDialog.show();
    }

    // обработчик нажатия на пункт списка диалога или кнопку
    OnClickListener myClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            //onClick(alertDialog, );
        }

        public void onClick(DialogInterface dialog, int which) {
            ListView lv = ((AlertDialog) dialog).getListView();
            if (which == Dialog.BUTTON_POSITIVE)
                // выводим в лог позицию выбранного элемента
                Log.d(TAG, "pos = " + lv.getCheckedItemPosition());
            else
                // выводим в лог позицию нажатого элемента
                Log.d(TAG, "which = " + which);
        }
    };

}
