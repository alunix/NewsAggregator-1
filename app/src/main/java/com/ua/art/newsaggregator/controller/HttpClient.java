package com.ua.art.newsaggregator.controller;

import com.ua.art.newsaggregator.MSslSocketFactoryNews;
import com.ua.art.newsaggregator.model.ResponseObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class HttpClient {
    private static HttpClient instance;

    public static HttpClient getInstance() {
        if (instance == null) {
            synchronized (HttpClient.class) {
                if (instance == null) {
                    instance = new HttpClient();
                }
            }
        }
        return instance;
    }

    public ResponseObject sendPost(String url, List<NameValuePair> params) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        ResponseObject result;
        DefaultHttpClient httpClient = returnHttpClient();
        try {
            HttpPost httppost = new HttpPost(url);
            httppost.setEntity(new UrlEncodedFormEntity(params));
            ResponseHandler<ResponseObject> responseHandler = new ResponseHandler<ResponseObject>() {

                public ResponseObject handleResponse(final HttpResponse response) throws IOException {
                    ResponseObject resp = new ResponseObject();
                    resp.setStatus(response.getStatusLine().getStatusCode());
                    resp.setResponse(null);
                    if (resp.getStatus()== 200) {
                        HttpEntity entity = response.getEntity();
                        resp.setResponse((entity != null) ? EntityUtils.toString(entity) : null);
                    }
                    return resp;
                }
            };
            result = httpClient.execute(httppost, responseHandler);
        } catch (Exception ex) {
            result = new ResponseObject();
            result.setResponse(ex.getMessage());
        }
        return result;
    }

    public String sendGet(String url){
        String response = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;
            HttpGet httpGet = new HttpGet(url);

            httpResponse = httpClient.execute(httpGet);
            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;

    }

    private static DefaultHttpClient returnHttpClient() {
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            SSLSocketFactory sf = new MSslSocketFactoryNews(trustStore);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", sf, 443));

            ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

            return new DefaultHttpClient(ccm, params);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }
}
