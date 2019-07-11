package com.imie.g7.edycem_android.database;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class TestInternetConectivity {

    public static boolean testConnexion (Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }
}
