package com.google.android.gms.nearby.connection;

import android.app.Activity;
import android.content.Context;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.d;
import c.b.a.a.j.i;
import java.util.List;

public abstract class ConnectionsClient extends d<ConnectionsOptions> {
    public static final int MAX_BYTES_DATA_SIZE = 32768;

    public ConnectionsClient(Activity activity, a<ConnectionsOptions> aVar, ConnectionsOptions connectionsOptions, d.a aVar2) {
        super(activity, (a) aVar, (a.d) null, aVar2);
    }

    public ConnectionsClient(Context context, a<ConnectionsOptions> aVar, ConnectionsOptions connectionsOptions, d.a aVar2) {
        super(context, aVar, (a.d) null, aVar2);
    }

    public abstract i<Void> acceptConnection(String str, PayloadCallback payloadCallback);

    public abstract i<Void> cancelPayload(long j);

    public abstract void disconnectFromEndpoint(String str);

    public abstract i<Void> rejectConnection(String str);

    public abstract i<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback);

    public abstract i<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions);

    public abstract i<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback);

    public abstract i<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions);

    public abstract i<Void> sendPayload(String str, Payload payload);

    public abstract i<Void> sendPayload(List<String> list, Payload payload);

    public abstract i<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions);

    public abstract i<Void> startAdvertising(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions);

    public abstract i<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions);

    public abstract void stopAdvertising();

    public abstract void stopAllEndpoints();

    public abstract void stopDiscovery();
}
