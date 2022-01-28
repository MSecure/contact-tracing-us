package com.google.android.gms.nearby.connection;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class EndpointDiscoveryCallback {
    public void onEndpointDistanceChanged(String str, DistanceInfo distanceInfo) {
    }

    public abstract void onEndpointFound(String str, DiscoveredEndpointInfo discoveredEndpointInfo);

    public abstract void onEndpointLost(String str);
}
