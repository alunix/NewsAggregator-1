package com.ua.art.newsaggregator.controller;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.ua.art.newsaggregator.Preferences;
import com.ua.art.newsaggregator.R;
import com.ua.art.newsaggregator.model.ResponseObject;

import org.apache.http.HttpEntity;

import java.io.IOException;

public abstract class RequestController {

    private Activity mActivity;
    private ProgressDialog mProgressDialog;
    private HttpClient mHttpClient;
    private String mUrl;
    private HttpEntity mHttpEntity;

    public RequestController(Activity activity, String url, HttpEntity httpEntity) throws IOException {
        this.mActivity = activity;
        mHttpClient = new HttpClient().getInstance();
        this.mUrl = url;
        this.mHttpEntity = httpEntity;
        new Preferences(activity);
    }

    public class SendDataTask extends AsyncTask<Void, Void, ResponseObject> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(mActivity);
            try {
                mProgressDialog.setMessage(mActivity.getString(R.string.please_wait));
                mProgressDialog.setIndeterminate(true);
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
            } catch (Exception e) {
                e.printStackTrace();
                System.gc();
            }
        }

        @Override
        protected ResponseObject doInBackground(Void... params) {
//            try {
//                return mHttpClient.sendPost(mUrl, mHttpEntity);
//            } catch (NoSuchAlgorithmException | KeyManagementException | IOException e) {
//                e.printStackTrace();
//            }
            return null;
        }

        @Override
        protected void onPostExecute(ResponseObject responseObject) {
            super.onPostExecute(responseObject);
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
            }
            parseAnswer(responseObject);
        }
    }

    protected abstract void parseAnswer(ResponseObject responseObject);
}
