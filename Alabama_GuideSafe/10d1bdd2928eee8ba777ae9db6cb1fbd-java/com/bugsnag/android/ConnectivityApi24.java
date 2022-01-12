package com.bugsnag.android;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectivityCompat.kt */
public final class ConnectivityApi24 implements Connectivity {
    public volatile Network activeNetwork;
    public final ConnectivityManager cm;
    public final ConnectivityTrackerCallback networkCallback;

    /* compiled from: ConnectivityCompat.kt */
    public final class ConnectivityTrackerCallback extends ConnectivityManager.NetworkCallback {
        public final Function2<Boolean, String, Unit> cb;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public ConnectivityTrackerCallback(Function2<? super Boolean, ? super String, Unit> function2) {
            this.cb = function2;
        }

        public void onAvailable(Network network) {
            super.onAvailable(network);
            ConnectivityApi24.this.activeNetwork = network;
            Function2<Boolean, String, Unit> function2 = this.cb;
            if (function2 != null) {
                function2.invoke(Boolean.TRUE, ConnectivityApi24.this.retrieveNetworkAccessState());
            }
        }

        public void onUnavailable() {
            super.onUnavailable();
            ConnectivityApi24.this.activeNetwork = null;
            Function2<Boolean, String, Unit> function2 = this.cb;
            if (function2 != null) {
                function2.invoke(Boolean.FALSE, ConnectivityApi24.this.retrieveNetworkAccessState());
            }
        }
    }

    public ConnectivityApi24(ConnectivityManager connectivityManager, Function2<? super Boolean, ? super String, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(connectivityManager, "cm");
        this.cm = connectivityManager;
        this.networkCallback = new ConnectivityTrackerCallback(function2);
    }

    @Override // com.bugsnag.android.Connectivity
    public boolean hasNetworkConnection() {
        return this.activeNetwork != null;
    }

    @Override // com.bugsnag.android.Connectivity
    public void registerForNetworkChanges() {
        this.cm.registerDefaultNetworkCallback(this.networkCallback);
    }

    @Override // com.bugsnag.android.Connectivity
    public String retrieveNetworkAccessState() {
        Network activeNetwork2 = this.cm.getActiveNetwork();
        NetworkCapabilities networkCapabilities = activeNetwork2 != null ? this.cm.getNetworkCapabilities(activeNetwork2) : null;
        if (networkCapabilities == null) {
            return "none";
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        return networkCapabilities.hasTransport(0) ? "cellular" : "unknown";
    }
}
