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
    private static final String URL = "http://www.webstudia.dp.ua/n/test";  // http://api.androidhive.info/contacts/


    private static final String TAG_NEWS = "news";
    private static final String TAG_CATEGORY = "category";
    private static final String TAG_SOURCE = "source";
    private static final String TAG_ID_ITEM = "id_item";
    private static final String TAG_TITLE = "title";
    private static final String TAG_LINK = "link";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_IMG = "img";
    private static final String TAG_DATE = "date";

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
            String jsonStr = sh.sendGet(URL);
            Log.d("Response: ", "> " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    news = jsonObj.getJSONArray(TAG_NEWS);
                    for (int i = 0; i < news.length(); i++) {
                        JSONObject c = news.getJSONObject(i);

                        String category = c.getString(TAG_CATEGORY);
                        String source = c.getString(TAG_SOURCE);
                        String id_item = c.getString(TAG_ID_ITEM);
                        String title = c.getString(TAG_TITLE);
                        String link = c.getString(TAG_LINK);
                        String description = c.getString(TAG_DESCRIPTION);
                        String img = c.getString(TAG_IMG);
                        String date = c.getString(TAG_DATE);

                        HashMap<String, String> contact = new HashMap<>();
                        contact.put(TAG_CATEGORY, category);
                        contact.put(TAG_SOURCE, source);
                        contact.put(TAG_TITLE, title);
                        contact.put(TAG_ID_ITEM, id_item);
                        contact.put(TAG_DESCRIPTION, description);
                        contact.put(TAG_IMG, img);
                        contact.put(TAG_DATE, date);
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
                    R.layout.item_list_news, new String[]{TAG_TITLE, TAG_DESCRIPTION,
                    TAG_SOURCE, TAG_DATE}, new int[]{R.id.titleItemText,
                    R.id.deskripItemText, R.id.sourseItemText, R.id.dateItemText});

            lv.setAdapter(adapter);
        }
    }

}
