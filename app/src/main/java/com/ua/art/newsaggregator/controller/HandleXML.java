package com.ua.art.newsaggregator.controller;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HandleXML {

    private String title = "title";
    private String weather_type = "weather_type";
    private String description = "description";

    private String urlString = null;
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;
    public HandleXML(String url){
        this.urlString = url;
    }
    public String getTitle(){
        return title;
    }
    public String getWeather_type(){
        return weather_type;
    }
    public String getDescription(){
        return description;
    }
    public void parseXMLAndStoreIt(XmlPullParser myParser) {
        int event;
        String text=null;
        try {
            event = myParser.getEventType();
            String name=null;
            boolean flagFactTag = false;
            while (event != XmlPullParser.END_DOCUMENT) {
                name=myParser.getName();
                //int depth;
                switch (event){
                    case XmlPullParser.START_TAG:
                        name=myParser.getName();
                        if(name.equals("fact"))
                            flagFactTag = true;
                        break;
                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(name.equals("fact"))
                            flagFactTag = false;
                        if (flagFactTag==true) {
                            if (name.equals("temperature")) {
                                title = text;
                                flagFactTag = false;
                            }
                        }
                        else if(name.equals("weather_type_short")){
                            weather_type = text;
                            //viewImgWeather(weather_type);
                        }
//                        else if(name.equals("description")){
//                            description = text;
//                        }
//                        else{
//                        }
                        break;
                }
                event = myParser.next();
            }
            parsingComplete = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void fetchXML(){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    URL url = new URL(urlString);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    // Starts the query
                    conn.connect();
                    InputStream stream = conn.getInputStream();
                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser = xmlFactoryObject.newPullParser();
                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(stream, null);
                    parseXMLAndStoreIt(myparser);
                    stream.close();
                } catch (Exception e) {
                }
            }
        });
        thread.start();
    }
}