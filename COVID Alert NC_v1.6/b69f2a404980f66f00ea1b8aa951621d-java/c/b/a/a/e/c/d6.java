package c.b.a.a.e.c;

import c.b.a.a.c.k.a;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import java.util.List;

public final class d6 implements Connections {

    /* renamed from: a  reason: collision with root package name */
    public static final a.g<v3> f2549a = new a.g<>();

    /* renamed from: b  reason: collision with root package name */
    public static final a.AbstractC0055a<v3, ConnectionsOptions> f2550b = new c6();

    @Override // com.google.android.gms.nearby.connection.Connections
    public final f<Status> acceptConnection(e eVar, String str, PayloadCallback payloadCallback) {
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final f<Status> acceptConnectionRequest(e eVar, String str, byte[] bArr, Connections.MessageListener messageListener) {
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final f<Status> cancelPayload(e eVar, long j) {
        return eVar.a(new h6(eVar, j));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void disconnectFromEndpoint(e eVar, String str) {
        eVar.a(new g6(eVar, str));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final f<Status> rejectConnection(e eVar, String str) {
        return eVar.a(new p6(eVar, str));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final f<Status> rejectConnectionRequest(e eVar, String str) {
        return eVar.a(new j6(eVar, str));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final f<Status> requestConnection(e eVar, String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final f<Status> sendConnectionRequest(e eVar, String str, String str2, byte[] bArr, Connections.ConnectionResponseCallback connectionResponseCallback, Connections.MessageListener messageListener) {
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final f<Status> sendPayload(e eVar, String str, Payload payload) {
        return eVar.a(new f6(eVar, str, payload));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final f<Status> sendPayload(e eVar, List<String> list, Payload payload) {
        return eVar.a(new e6(eVar, list, payload));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendReliableMessage(e eVar, String str, byte[] bArr) {
        eVar.a(new l6(eVar, str, bArr));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendReliableMessage(e eVar, List<String> list, byte[] bArr) {
        eVar.a(new k6(eVar, list, bArr));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendUnreliableMessage(e eVar, String str, byte[] bArr) {
        eVar.a(new f6(eVar, str, Payload.fromBytes(bArr)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final f<Connections.StartAdvertisingResult> startAdvertising(e eVar, String str, AppMetadata appMetadata, long j, Connections.ConnectionRequestListener connectionRequestListener) {
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final f<Status> startDiscovery(e eVar, String str, long j, Connections.EndpointDiscoveryListener endpointDiscoveryListener) {
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopAdvertising(e eVar) {
        eVar.a(new m6(eVar));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopAllEndpoints(e eVar) {
        eVar.a(new i6(eVar));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final void stopDiscovery(e eVar) {
        eVar.a(new n6(eVar));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void stopDiscovery(e eVar, String str) {
        eVar.a(new n6(eVar));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendUnreliableMessage(e eVar, List<String> list, byte[] bArr) {
        eVar.a(new e6(eVar, list, Payload.fromBytes(bArr)));
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final f<Connections.StartAdvertisingResult> startAdvertising(e eVar, String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.Connections
    public final f<Status> startDiscovery(e eVar, String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions) {
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }
}
