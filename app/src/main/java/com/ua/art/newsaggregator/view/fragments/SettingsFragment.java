package com.ua.art.newsaggregator.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.ua.art.newsaggregator.Preferences;
import com.ua.art.newsaggregator.R;

public class SettingsFragment extends Fragment {
    public static final String TAG = "MyLogS";
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
}
