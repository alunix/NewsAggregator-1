package com.ua.art.newsaggregator;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionController {
    private static Context sContext;

    public static boolean isConnectingToInternet(Context context) {
        ConnectionController.sContext = context;
        return isConnectingToInternet();
    }

    public static boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) sContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        return false;
    }
}
