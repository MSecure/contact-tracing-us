package com.google.android.gms.nearby.connection;

import androidx.annotation.RecentlyNonNull;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.f;
import c.b.a.a.d.k.i;
import com.google.android.gms.common.api.Status;
import java.util.List;

@Deprecated
public interface Connections {
    @Deprecated
    public static final long DURATION_INDEFINITE = 0;
    public static final int MAX_BYTES_DATA_SIZE = 32768;
    @Deprecated
    public static final int MAX_RELIABLE_MESSAGE_LEN = 4096;
    @Deprecated
    public static final int MAX_UNRELIABLE_MESSAGE_LEN = 1168;

    @Deprecated
    public static abstract class ConnectionRequestListener {
        public void onConnectionRequest(String str, String str2, byte[] bArr) {
        }
    }

    @Deprecated
    public interface ConnectionResponseCallback {
        void onConnectionResponse(String str, Status status, byte[] bArr);
    }

    @Deprecated
    public static abstract class EndpointDiscoveryListener {
        public void onEndpointFound(String str, String str2, String str3) {
        }

        public abstract void onEndpointLost(String str);
    }

    @Deprecated
    public interface MessageListener {
        @Deprecated
        void onDisconnected(String str);

        @Deprecated
        void onMessageReceived(String str, byte[] bArr, boolean z);
    }

    public interface StartAdvertisingResult extends i {
        String getLocalEndpointName();

        @Override // c.b.a.a.d.k.i
        @RecentlyNonNull
        /* synthetic */ Status getStatus();
    }

    f<Status> acceptConnection(e eVar, String str, PayloadCallback payloadCallback);

    @Deprecated
    f<Status> acceptConnectionRequest(e eVar, String str, byte[] bArr, MessageListener messageListener);

    f<Status> cancelPayload(e eVar, long j);

    void disconnectFromEndpoint(e eVar, String str);

    f<Status> rejectConnection(e eVar, String str);

    @Deprecated
    f<Status> rejectConnectionRequest(e eVar, String str);

    f<Status> requestConnection(e eVar, String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback);

    @Deprecated
    f<Status> sendConnectionRequest(e eVar, String str, String str2, byte[] bArr, ConnectionResponseCallback connectionResponseCallback, MessageListener messageListener);

    f<Status> sendPayload(e eVar, String str, Payload payload);

    f<Status> sendPayload(e eVar, List<String> list, Payload payload);

    @Deprecated
    void sendReliableMessage(e eVar, String str, byte[] bArr);

    @Deprecated
    void sendReliableMessage(e eVar, List<String> list, byte[] bArr);

    @Deprecated
    void sendUnreliableMessage(e eVar, String str, byte[] bArr);

    @Deprecated
    void sendUnreliableMessage(e eVar, List<String> list, byte[] bArr);

    @Deprecated
    f<StartAdvertisingResult> startAdvertising(e eVar, String str, AppMetadata appMetadata, long j, ConnectionRequestListener connectionRequestListener);

    f<StartAdvertisingResult> startAdvertising(e eVar, String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions);

    @Deprecated
    f<Status> startDiscovery(e eVar, String str, long j, EndpointDiscoveryListener endpointDiscoveryListener);

    f<Status> startDiscovery(e eVar, String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions);

    void stopAdvertising(e eVar);

    void stopAllEndpoints(e eVar);

    void stopDiscovery(e eVar);

    @Deprecated
    void stopDiscovery(e eVar, String str);
}
