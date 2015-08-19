package com.ua.art.newsaggregator.view;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.ua.art.newsaggregator.R;

public class BrowserNews extends ActionBarActivity {

    private WebView wv;
    private String LASTURL = "";
    Menu myMenu = null;
    private static final String PREFS_NAME = "MyPrefs";
    private Boolean imgOn;

    private String urlNews;

//    private String url;
//
//    public BrowserNews(String url) {
//        this.url = url;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_browser_news);

        wv = (WebView) findViewById(R.id.wv);

        //wv.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки
//        wv.loadUrl("http://developer.alexanderklimov.ru/android");

//        wv = (WebView) findViewById(R.id.wv);
//
        WebSettings webSettings = wv.getSettings();
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setJavaScriptEnabled(true);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        imgOn = settings.getBoolean("IMGMODE", false);
        webSettings.setLoadsImagesAutomatically(imgOn);

        final Activity activity = this;

        wv.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress)
            {
                activity.setTitle(" "+LASTURL);
                activity.setProgress(progress * 100);

                if(progress == 100)
                    activity.setTitle(" "+LASTURL);
            }
        });
        wv.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "Error: " + description+ " " + failingUrl, Toast.LENGTH_LONG).show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView  view, String  url)
            {
//                if (url.indexOf("habrahabr")<=0) {
//                    // the link is not for a page on my site, so launch another Activity that handles URLs
//                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                    startActivity(intent);
//                    return true;
//                }
//                return false;
                view.loadUrl(url);
                return true;
            }

            public void onPageStarted (WebView view, String url, Bitmap favicon) {
                LASTURL = url;
                view.getSettings().setLoadsImagesAutomatically(false);
            }

            public void onPageFinished  (WebView view, String url) {
                view.loadUrl("javascript:(function() { " +
                        "hide('sidebar');"+
                        //"var parent = document.getElementsByClassName('page-navigation')[0];"+
                        //"var panel = document.getElementsByClassName('panel-tools')[0];"+
                        //"var div = document.createElement('div');"+
                        //"div.innerHTML = panel.innerHTML;"+
                        //"parent.appendChild(div);"+
                        //"panel.innerHTML = '';"+
                        //"div.style['margin-left'] = '31px';"+
                        "var panel = document.getElementById('search');"+
                        "panel.style['width'] = '55px';"+

                        //"var imgs=document.getElementsByTagName('IMG');for(var i=0;i<imgs.length;i++){if (imgs[i].height=60) {imgs[i].src='';imgs[i].width=0;} }"+
                        //"var urls=document.getElementsByTagName('li');for(var i=0;i<urls.length;i++){if (urls[i].style='margin: -14px 0pt 0pt;'){urls[i].style['display'] = 'none';}}"+
                        //"hideByClass('panel-tools');"+
                        "function hide(id){if (document.getElementById(id)){document.getElementById(id).style['display'] = 'none';}}"+
                        //"function hideByClass(c){var e=document.getElementsByClassName(c);for(var i=0;i<e.length;i++){e[i].style['display'] = 'none';}}"+
                        "})()");
                if (imgOn) view.getSettings().setLoadsImagesAutomatically(true);
            }
        });

        Intent intent = getIntent();
        urlNews = intent.getStringExtra("urlNews");
        wv.loadUrl(urlNews);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && wv.canGoBack()) {
            wv.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);

        this.myMenu = menu;
        MenuItem item = menu.add(0, 1, 0, "MAIN PAGE");
        item.setIcon(R.drawable.home);
        MenuItem item2 = menu.add(0, 2, 0, "BACK");
        item2.setIcon(R.drawable.arrowleft);
        MenuItem item3 = menu.add(0, 3, 0, "F5");
        item3.setIcon(R.drawable.s);
        MenuItem item4 = menu.add(0, 4, 0, "CLEAR CACHE");
        item4.setIcon(R.drawable.trash);
        MenuItem item5 = menu.add(0, 5, 0, "VOID");
        item5.setIcon(R.drawable.vote);
        menu.add(0, 6, 0, "IMG ON");
        menu.add(0, 7, 0, "IMG OFF");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)   {
        switch (item.getItemId())
        {
            case 1:
                wv.loadUrl("http://habrahabr.ru");
                break;
            case 2:
                if (wv.canGoBack()) {
                    wv.goBack();
                }
                break;
            case 3:
                wv.loadUrl(LASTURL);
                break;
            case 4:
                wv.clearCache(true);
                break;
            case 5:
                Intent marketIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "http://market.android.com/details?id=" + getPackageName()));
                startActivity(marketIntent2);
                break;
            case 6:
                saveSettings(true);
                break;
            case 7:
                saveSettings(false);
                break;
        }

        return true;
    }

    private void saveSettings(Boolean val)
    {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("IMGMODE", val);
        editor.commit();
    }
}