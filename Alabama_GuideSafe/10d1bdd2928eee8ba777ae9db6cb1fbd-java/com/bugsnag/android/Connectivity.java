package com.bugsnag.android;

/* compiled from: ConnectivityCompat.kt */
public interface Connectivity {
    boolean hasNetworkConnection();

    void registerForNetworkChanges();

    String retrieveNetworkAccessState();
}
