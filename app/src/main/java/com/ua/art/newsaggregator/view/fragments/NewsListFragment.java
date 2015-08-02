package com.ua.art.newsaggregator.view.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.controller.HttpClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class NewsListFragment extends Fragment {

    //private ProgressDialog progressDialog;
    protected static final String URL = "http://news.webstudia.dp.ua/index/test";  // http://api.androidhive.info/contacts/


//    private static final String TAG_NEWS = "news";
//    private static final String TAG_CATEGORY = "category";
//    private static final String TAG_SOURCE = "source";
//    private static final String TAG_ID_ITEM = "id_item";
//    private static final String TAG_TITLE = "title";
//    private static final String TAG_LINK = "link";
//    private static final String TAG_DESCRIPTION = "description";
//    private static final String TAG_IMG = "img";

    private static final String TAG_NEWS = "news";
    private static final String TAG_ID = "id";
    private static final String TAG_NAME = "name";
    private static final String TAG_LINK = "link";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_IMAGE = "image";
    private static final String TAG_PUBDATE = "pubDate";
    private static final String TAG_TEXT = "text";
    private static final String TAG_MODULEID = "moduleId";
    private static final String TAG_CATEGORYID = "categoryId";
    private static final String TAG_SOURCEID = "sourceId";


    //private static final String TAG_DATE = "date";

    private ListView lv;
    private JSONArray news = null;
    private ArrayList<HashMap<String, String>> newsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_list,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsList = new ArrayList<>();
        lv = (ListView) getActivity().findViewById(R.id.news_list);
        new GetNews().execute();
    }


    private class GetNews extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            progressDialog = new ProgressDialog(getActivity());
//            progressDialog.setMessage(getString(R.string.please_wait));
//            progressDialog.setCancelable(false);
//            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpClient sh = new HttpClient();
            String param = "{" +
                    "\"moduleId\" : \"1\"," +
                    "\"categoryId\" : \"1\"," +
                    "\"sourceId\" : \"1\"," +
                    "\"pubDate\" : \"thu, 30 jul 2015 12:46:43 +0300\"," +
                    "\"quantity\" : \"10\"," +
                    "\"older\" : \"true\"" +
                    "}";
            String jsonStr = sh.sendPost(URL, param);
            //jsonStr = jsonStr.indexOf("}");

//            byte[] utf8 = new byte[0];
//            try {
//                utf8 = jsonStr.getBytes("UTF-8");
//                jsonStr = new String(utf8, "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }



            Log.d("Response: ", "> " + jsonStr);
            if (jsonStr != null) {
                try {
                    //JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    //JSONObject jsonObj = new JSONObject("{\"phonetype\":\"N95\",\"cat\":\"WP\"}");
                    news = jsonObj.getJSONArray(TAG_NEWS);
                    for (int i = 0; i < news.length(); i++) {
                        JSONObject c = news.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);
                        String link = c.getString(TAG_LINK);
                        String description = c.getString(TAG_DESCRIPTION);
                        String image = c.getString(TAG_IMAGE);
                        String pubDate = c.getString(TAG_PUBDATE);
                        String text = c.getString(TAG_TEXT);
                        String moduleId = c.getString(TAG_MODULEID);
                        String categoryId = c.getString(TAG_CATEGORYID);
                        String sourceId = c.getString(TAG_SOURCEID);

                        HashMap<String, String> contact = new HashMap<>();
                        contact.put(TAG_ID, id);
                        contact.put(TAG_NAME, name);
                        contact.put(TAG_LINK, link);
                        contact.put(TAG_DESCRIPTION, description);
                        contact.put(TAG_IMAGE, image);
                        contact.put(TAG_PUBDATE, pubDate);
                        contact.put(TAG_TEXT, text);
                        contact.put(TAG_MODULEID, moduleId);
                        contact.put(TAG_CATEGORYID, categoryId);
                        contact.put(TAG_SOURCEID, sourceId);
                        newsList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
//            if (progressDialog.isShowing()){
//                progressDialog.dismiss();
//            }
            ListAdapter adapter = new SimpleAdapter(
                    getActivity(), newsList,
                    R.layout.item_list_news, new String[]{TAG_NAME, TAG_DESCRIPTION,
                    TAG_SOURCEID, TAG_PUBDATE}, new int[]{R.id.titleItemText,
                    R.id.deskripItemText, R.id.sourseItemText, R.id.dateItemText});

            lv.setAdapter(adapter);
        }
    }

}
