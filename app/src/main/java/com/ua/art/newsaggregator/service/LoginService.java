package com.ua.art.newsaggregator.service;

import android.app.Activity;

import com.ua.art.newsaggregator.Preferences;
import com.ua.art.newsaggregator.controller.RequestController;
import com.ua.art.newsaggregator.model.ResponseObject;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class LoginService  extends RequestController {

    private static final String LOGIN = "login";
    private static final String PASS = "pass";
    private Activity mActivity;
    private String mPassword;

    public LoginService(Activity activity, String url, String login, String password)
            throws IOException, NoSuchAlgorithmException, JSONException {
        super(activity, url, createHttpEntity(login, password));
        this.mActivity = activity;
        this.mPassword = password;
    }

    public void authorization() {
        new SendDataTask().execute();
    }

    private static HttpEntity createHttpEntity(String login, String password)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, JSONException {
        Preferences.saveLogin(login);
        JSONObject jsonObject = new JSONObject()
                .put(LOGIN, login)
                .put(PASS, password);
        List<NameValuePair> params = new ArrayList<NameValuePair>(1);
        params.add(new BasicNameValuePair("auth", jsonObject.toString()));

        return new UrlEncodedFormEntity(params, "UTF-8");
    }

    @Override
    protected void parseAnswer(ResponseObject responseObject) {
        if (responseObject != null &&
                (responseObject.getStatus() == 200 || responseObject.getStatus() == 0)){
            mActivity.setResult(Activity.RESULT_OK);
            mActivity.finish();
        } else {
            Preferences.clearAll();
        }
    }


}
