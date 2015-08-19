package com.ua.art.newsaggregator.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.controller.HandleXML;

public class WeatherFragment extends Fragment {
    private String finalUrl="http://export.yandex.ru/weather-ng/forecasts/34504.xml";        //"http://tutorialspoint.com/android/sampleXML.xml";
    //private String finalUrl="http://tutorialspoint.com/android/sampleXML.xml";
    private HandleXML obj;
    private TextView factTemperatureText;
    private TextView weatherText;
    private ImageView weatherTypeImage;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        factTemperatureText = (TextView)getActivity().findViewById(R.id.factTemperatureText);
        weatherText = (TextView)getActivity().findViewById(R.id.sunText);
        button = (Button)getActivity().findViewById(R.id.wearherBtn);
        weatherTypeImage = (ImageView)getActivity().findViewById(R.id.weatherTypeImage);

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
        viewImgWeather(obj.getWeather_type());
        weatherText.setText(obj.getWeather_type());
//        description.setText(obj.getDescription());
    }

    private void viewImgWeather(String weather_type){
        if (weather_type.equals("ясно"))
            weatherTypeImage.setImageResource(R.drawable.sunny);
        else if (weather_type.equals("малооблачно"))
            weatherTypeImage.setImageResource(R.drawable.partly_cloudy);
        else if (weather_type.equals("переменная облачность"))
            weatherTypeImage.setImageResource(R.drawable.partly_cloudy);
        else if (weather_type.equals("облачно"))
            weatherTypeImage.setImageResource(R.drawable.cloudy);
        else if (weather_type.equals("облачно, дождь, гроза"))
            weatherTypeImage.setImageResource(R.drawable.rain_storm);
        else if (weather_type.equals("облачно, дождь"))
            weatherTypeImage.setImageResource(R.drawable.rain);
        else if (weather_type.equals("дождь"))
            weatherTypeImage.setImageResource(R.drawable.rain);
    }


}
