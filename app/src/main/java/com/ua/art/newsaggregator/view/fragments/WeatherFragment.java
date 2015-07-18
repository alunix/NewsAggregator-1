package com.ua.art.newsaggregator.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.controller.HandleXML;

public class WeatherFragment extends Fragment {
    private String finalUrl="http://export.yandex.ru/weather-ng/forecasts/34504.xml";        //"http://tutorialspoint.com/android/sampleXML.xml";
    //private String finalUrl="http://tutorialspoint.com/android/sampleXML.xml";
    private HandleXML obj;
    private TextView factTemperatureText;
    private TextView sunText;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        factTemperatureText = (TextView)getActivity().findViewById(R.id.factTemperatureText);
        sunText = (TextView)getActivity().findViewById(R.id.sunText);
        button = (Button)getActivity().findViewById(R.id.wearherBtn);

        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.wearherBtn){
                    fetch();
                }
            }
        };

        // присвоим обработчик кнопке OK (btnOk)
        button.setOnClickListener(oclBtnOk);
    }

    public void fetch(){
        obj = new HandleXML(finalUrl);
        obj.fetchXML();
        while(obj.parsingComplete);
        factTemperatureText.setText(obj.getTitle());
        sunText.setText(obj.getSun());
//        description.setText(obj.getDescription());
    }


}
