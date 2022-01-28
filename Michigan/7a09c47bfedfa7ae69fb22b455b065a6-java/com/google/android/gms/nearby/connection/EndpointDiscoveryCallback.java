package com.google.android.gms.nearby.connection;

public abstract class EndpointDiscoveryCallback {
    public void onEndpointDistanceChanged(String str, DistanceInfo distanceInfo) {
    }

    public abstract void onEndpointFound(String str, DiscoveredEndpointInfo discoveredEndpointInfo);

    public abstract void onEndpointLost(String str);
}
