package com.bugsnag.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectivityCompat.kt */
public final class ConnectivityLegacy implements Connectivity {
    public final ConnectivityChangeReceiver changeReceiver;
    public final ConnectivityManager cm;
    public final Context context;

    /* compiled from: ConnectivityCompat.kt */
    public final class ConnectivityChangeReceiver extends BroadcastReceiver {
        public final Function2<Boolean, String, Unit> cb;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public ConnectivityChangeReceiver(Function2<? super Boolean, ? super String, Unit> function2) {
            this.cb = function2;
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            Function2<Boolean, String, Unit> function2 = this.cb;
            if (function2 != null) {
                function2.invoke(Boolean.valueOf(ConnectivityLegacy.this.hasNetworkConnection()), ConnectivityLegacy.this.retrieveNetworkAccessState());
            }
        }
    }

    public ConnectivityLegacy(Context context2, ConnectivityManager connectivityManager, Function2<? super Boolean, ? super String, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(connectivityManager, "cm");
        this.context = context2;
        this.cm = connectivityManager;
        this.changeReceiver = new ConnectivityChangeReceiver(function2);
    }

    @Override // com.bugsnag.android.Connectivity
    public boolean hasNetworkConnection() {
        NetworkInfo activeNetworkInfo = this.cm.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnectedOrConnecting();
        }
        return false;
    }

    @Override // com.bugsnag.android.Connectivity
    public void registerForNetworkChanges() {
        this.context.registerReceiver(this.changeReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // com.bugsnag.android.Connectivity
    public String retrieveNetworkAccessState() {
        NetworkInfo activeNetworkInfo = this.cm.getActiveNetworkInfo();
        Integer valueOf = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getType()) : null;
        if (valueOf == null) {
            return "none";
        }
        if (valueOf.intValue() == 1) {
            return "wifi";
        }
        return valueOf.intValue() == 9 ? "ethernet" : "cellular";
    }
}
