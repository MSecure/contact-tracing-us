package com.google.android.gms.nearby.connection;

import android.app.Activity;
import android.content.Context;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.d;
import c.b.a.a.g.h;
import java.util.List;

public abstract class ConnectionsClient extends d<ConnectionsOptions> {
    public static final int MAX_BYTES_DATA_SIZE = 32768;

    public ConnectionsClient(Activity activity, a<ConnectionsOptions> aVar, ConnectionsOptions connectionsOptions, d.a aVar2) {
        super(activity, (a) aVar, (a.d) null, aVar2);
    }

    public ConnectionsClient(Context context, a<ConnectionsOptions> aVar, ConnectionsOptions connectionsOptions, d.a aVar2) {
        super(context, aVar, (a.d) null, aVar2);
    }

    public abstract h<Void> acceptConnection(String str, PayloadCallback payloadCallback);

    public abstract h<Void> cancelPayload(long j);

    public abstract void disconnectFromEndpoint(String str);

    public abstract h<Void> rejectConnection(String str);

    public abstract h<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback);

    public abstract h<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions);

    public abstract h<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback);

    public abstract h<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions);

    public abstract h<Void> sendPayload(String str, Payload payload);

    public abstract h<Void> sendPayload(List<String> list, Payload payload);

    public abstract h<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions);

    public abstract h<Void> startAdvertising(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions);

    public abstract h<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions);

    public abstract void stopAdvertising();

    public abstract void stopAllEndpoints();

    public abstract void stopDiscovery();
}
