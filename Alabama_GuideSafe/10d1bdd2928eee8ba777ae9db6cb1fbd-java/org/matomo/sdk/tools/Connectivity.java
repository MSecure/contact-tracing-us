package org.matomo.sdk.tools;

import android.content.Context;
import android.net.ConnectivityManager;

public class Connectivity {
    public final ConnectivityManager mConnectivityManager;

    public enum Type {
        NONE,
        MOBILE,
        WIFI
    }

    public Connectivity(Context context) {
        this.mConnectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
    }
}
