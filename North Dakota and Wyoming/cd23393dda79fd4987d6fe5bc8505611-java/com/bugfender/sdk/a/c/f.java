package com.bugfender.sdk.a.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bugfender.sdk.a.a.e.c;
import com.bugfender.sdk.a.a.e.h.a;

public class f implements a {
    private final Context a;

    public f(Context context) {
        c.a(context, "Context must be not null");
        this.a = context;
    }

    @Override // com.bugfender.sdk.a.a.e.h.a
    public boolean a() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
