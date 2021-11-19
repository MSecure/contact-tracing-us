package com.google.android.gms.nearby.connection;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class ConnectionLifecycleCallback {
    public abstract void onConnectionInitiated(String str, ConnectionInfo connectionInfo);

    public abstract void onConnectionResult(String str, ConnectionResolution connectionResolution);

    public abstract void onDisconnected(String str);
}
