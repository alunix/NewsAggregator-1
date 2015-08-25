package com.ua.art.newsaggregator.view.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.controller.HttpClient;
import com.ua.art.newsaggregator.controller.QueryServerPushRss;
import com.ua.art.newsaggregator.controller.db.DbManager;
import com.ua.art.newsaggregator.model.TemplateServer;
import com.ua.art.newsaggregator.service.Settings;
import com.ua.art.newsaggregator.view.BrowserNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Activiti fragment to display a list of news server
 * */
public class NewsListFragment extends Fragment {

    private ProgressDialog progressDialog;
    //protected static final String URL = "http://news.webstudia.dp.ua/index/exchangeAll";  // http://api.androidhive.info/contacts/
    protected static final String URL_REQUEST = "http://news.webstudia.dp.ua/index/request";  // http://api.androidhive.info/contacts/

    private Context context;

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

    private static String requestModuleId = "news";
    private static String requestCategoryId = "news_politics";
    private static String requestSourceId = "news_politics_liga";
    private static String requestidItem = "20150818061733993";
    private static String requestQuantity = "30";
    private static String requestOlder = "true";

    private static final String LOG_TAG = "date";

    static String srcId;

    private ListView lv;
//    ImageView imgLike;
    private JSONArray news = null;
    private ArrayList<HashMap<String, String>> newsList;
    private boolean flagAdapterListGo = false;

    public NewsListFragment(Context context) {
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_list,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        newsList = new ArrayList<>();
        lv = (ListView) getActivity().findViewById(R.id.news_list);
//        new GetNews().execute();
//        imgLike = (ImageView)getActivity().findViewById(R.id.btnLike);
//        imgLike.setOnClickListener(pressBtn);

        downloadNews();
    }

//    private View.OnClickListener pressBtn = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()){
//                case R.id.btnLike:
//                    //Toast.makeText(context, "text", Toast.LENGTH_SHORT).show();
//                    Log.v(LOG_TAG, "setOnClick ImageView");
//                    break;
//                default:
//                    Log.v(LOG_TAG, "No press");
//                    break;
//            }
//        }
//    };

    @Override
    public void onStart() {
        super.onStart();
//        newsList.clear();

//        downloadNews();
        Log.d(LOG_TAG, "onStart");
    }

    //TODO неправильно работает
    public void downloadNews(){
        if (newsList.isEmpty()){
            for (String category : Settings.nameSelectCategory){
                new QueryServerPushRss(
                        requestModuleId,
                        category,
                        category + "_liga");
                new GetNews(requestModuleId, category,
                        category + "_liga",
                        "-1", String.valueOf(Settings.sumItemOneCategory), requestOlder).execute();
            }
            //Collections.shuffle(newsList);
            flagAdapterListGo = true;
        }
    }

    private void pullSQLiteNews(){
        DbManager dbManager = new DbManager(context);
        dbManager.selectDbNews(newsList);
    }

    private class GetNews extends AsyncTask<Void, Void, Void> {

        String requestModuleId, requestCategoryId, requestSourceId,
                requestidItem, requestQuantity, requestOlder;


        public GetNews(String requestModuleId, String requestCategoryId, String requestSourceId,
                       String requestidItem, String requestQuantity, String requestOlder){
            this.requestModuleId = requestModuleId;
            this.requestCategoryId = requestCategoryId;
            this.requestSourceId = requestSourceId;
            this.requestidItem = requestidItem;
            this.requestQuantity = requestQuantity;
            this.requestOlder = requestOlder;
        }

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
            //String jsonStr = sh.sendPost(URL, param);
            String jsonStr = sh.sendPost(URL_REQUEST, TemplateServer.requestJsonNews(
                    requestModuleId, requestCategoryId, requestSourceId,
                    requestidItem, requestQuantity, requestOlder));

            Log.d("Response: ", "> " + jsonStr);
            if (jsonStr != null) {
                if (jsonStr.charAt(0) != '[')
                    jsonStr = (String) jsonStr.subSequence(jsonStr.indexOf("["), jsonStr.lastIndexOf("]")+1);
                try {
                    JSONArray newsArray = new JSONArray(jsonStr);
                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject c = newsArray.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = checkString(c.getString(TAG_NAME));
                        String link = checkString(c.getString(TAG_LINK));
                        String description = checkString(c.getString(TAG_DESCRIPTION));
                        String image = checkString(c.getString(TAG_IMAGE));
                        String pubDate = checkString(c.getString(TAG_PUBDATE));
                        String text = checkString(c.getString(TAG_TEXT));
                        String moduleId = checkString(c.getString(TAG_MODULEID));
                        String categoryId = checkString(c.getString(TAG_CATEGORYID));
                        String sourceId = checkString(c.getString(TAG_SOURCEID));

                        if ((name == null)||(description == null)||(link == null)
                                ||(name == "")||(description == "")||(link == "")
                                ||(name == " ")||(description == " ")||(link == " "))
                            continue;

                        //String date = filterString(newsList.get(TAG_PUBDATE), " ", " ");
                        HashMap<String, String> contact = new HashMap<>();
                        contact.put(TAG_ID, checkString(id));
                        contact.put(TAG_NAME, name);
                        contact.put(TAG_LINK, link);
                        contact.put(TAG_DESCRIPTION, description);
                        contact.put(TAG_IMAGE, image);
                        contact.put(TAG_PUBDATE, filterString(pubDate, " ", " "));
                        contact.put(TAG_TEXT, text);
                        contact.put(TAG_MODULEID, moduleId);
                        contact.put(TAG_CATEGORYID, categoryId);
                        contact.put(TAG_SOURCEID, (sourceId.indexOf("liga") != -1) ? "www.liga.net" : sourceId);
                        newsList.add(contact);
                        //checkingMatch(contact);
                    }
                    //new DbManager(context).saveDbNews(newsList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }
            return null;
        }

        // проверка на совпадение и добавление в БД и в ArrayList
//        private void checkingMatch(HashMap<String, String> contact){
//            for (HashMap<String, String> nList : Settings.newsList){
//                if(nList.get(TAG_ID) == contact.get(TAG_ID)){
//                    return;
//                }
//            }
//            Settings.newsList.add(contact);             // add newsList news Item (Settings)
//            newsList.add(contact);
//        }

        private String checkString(String sTag){
            if (sTag.equals("null"))
                return "";
            else
                return sTag;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
//            if (progressDialog.isShowing()){
//                progressDialog.dismiss();
//            }
            //TODO переделать фильтр
//            if (flagAdapterListGo == false)
//                return;
//            else
//                flagAdapterListGo = false;
//             Collections.shuffle(newsList);



//            if (TAG_SOURCEID.indexOf("liga") != -1)
//            {
//                srcId = "www.liga.net";
//            }
//            else srcId = TAG_SOURCEID;

                    ListAdapter adapter = new SimpleAdapter(
                    getActivity(), newsList,
                    R.layout.item_list_news,
                    new String[]{
                            TAG_NAME,
                            TAG_DESCRIPTION,
                            TAG_SOURCEID,
                            TAG_PUBDATE
                    },
                    new int[]{
                            R.id.titleItemText,
                            R.id.deskripItemText,
                            R.id.sourseItemText,
                            R.id.dateItemText
                    });

            lv.setAdapter(adapter);

            // Click Item
            lv.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Log.d(LOG_TAG, "itemClick: position = " + position + ", id = " + id);

                    String urlNews = newsList.get(position).get(TAG_LINK).toString();

                    Intent intentNews = new Intent(context,  BrowserNews.class);
                    intentNews.putExtra("urlNews", urlNews);
                    startActivity(intentNews);
                }
            });

            // Events for selection --------------------------------------------------------------
            lv.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    Log.d(LOG_TAG, "itemSelect: position = " + position + ", id = "
                            + id);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    Log.d(LOG_TAG, "itemSelect: nothing");
                }
            });
            // Events for croll
            lv.setOnScrollListener(new OnScrollListener() {
                int a =0;
                @Override
                public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                    Log.d(LOG_TAG, "scrollState = " + scrollState);
                    a = scrollState;
                }

                @Override
                public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                    Log.d(LOG_TAG, "scroll: firstVisibleItem = " + firstVisibleItem
                            + ", visibleItemCount" + visibleItemCount
                            + ", totalItemCount" + totalItemCount);
//                    if (firstVisibleItem == totalItemCount - visibleItemCount){
//
//                        if (newsList.isEmpty()){
//                            for (String category : Settings.nameSelectCategory){
//                                new QueryServerPushRss(
//                                        requestModuleId,
//                                        category,
//                                        category + "_liga");
//                                new GetNews(requestModuleId, category,
//                                        category + "_liga",
//                                        "-1", String.valueOf(Settings.sumItemOneCategory), requestOlder).execute();
//                            }
//                        }
//                    }
                }
            });
        }
    }

    private String filterString(String strValue, String indexOf, String  lastIndexOf) {
        if (strValue != null) {
            if (strValue.charAt(0) != indexOf.charAt(0))
                return (String) strValue.subSequence(
                        strValue.indexOf(indexOf), strValue.lastIndexOf(lastIndexOf) + 1);
        }
        return strValue;
    }
}
