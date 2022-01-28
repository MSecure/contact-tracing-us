package com.proudcrowd.exposure.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bugfender.sdk.Bugfender;

public class NetworkCheck {
    static Context context;
    private static NetworkCheck instance = new NetworkCheck();

    public static NetworkCheck getInstance(Context context2) {
        context = context2.getApplicationContext();
        return instance;
    }

    public boolean isOnline() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            Bugfender.e("CheckConnectivity", e.getMessage());
            Log.d("CheckConnectivity", e.toString());
            return false;
        }
    }
}
