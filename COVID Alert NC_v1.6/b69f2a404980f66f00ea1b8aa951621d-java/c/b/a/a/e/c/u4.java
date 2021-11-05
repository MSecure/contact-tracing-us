package c.b.a.a.e.c;

import android.app.Activity;
import android.content.Context;
import b.b.k.i;
import c.b.a.a.c.c;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.d;
import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.q;
import c.b.a.a.g.a0;
import c.b.a.a.g.h;
import c.b.a.a.g.j;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.zza;
import java.util.List;

public final class u4 extends ConnectionsClient {

    /* renamed from: c  reason: collision with root package name */
    public static final a.g<v3> f2747c = new a.g<>();

    /* renamed from: d  reason: collision with root package name */
    public static final a.AbstractC0055a<v3, ConnectionsOptions> f2748d;

    /* renamed from: e  reason: collision with root package name */
    public static final a<ConnectionsOptions> f2749e;

    /* renamed from: a  reason: collision with root package name */
    public final l3 f2750a;

    /* renamed from: b  reason: collision with root package name */
    public final s7 f2751b;

    static {
        j5 j5Var = new j5();
        f2748d = j5Var;
        f2749e = new a<>("Nearby.CONNECTIONS_API", j5Var, f2747c);
    }

    public u4(Activity activity) {
        super(activity, f2749e, (ConnectionsOptions) null, d.a.f2305c);
        this.f2750a = l3.b(this);
        this.f2751b = s7.a(activity);
    }

    public u4(Context context) {
        super(context, f2749e, (ConnectionsOptions) null, d.a.f2305c);
        this.f2750a = l3.b(this);
        this.f2751b = null;
    }

    public static final void c(v3 v3Var) {
        ((j7) v3Var.getService()).B(new q9());
    }

    public final h<Void> a(y5 y5Var) {
        q.a methodKey = q.builder().setMethodKey(1229);
        methodKey.f2389a = new c5(this, y5Var);
        return doWrite(methodKey.a());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> acceptConnection(String str, PayloadCallback payloadCallback) {
        k registerListener = registerListener(payloadCallback, PayloadCallback.class.getName());
        q.a builder = q.builder();
        builder.f2389a = new i5(this, str, registerListener);
        return doWrite(builder.setMethodKey(1227).a());
    }

    public final h<Void> b(z5 z5Var) {
        q.a methodKey = q.builder().setMethodKey(1229);
        methodKey.f2389a = new b5(z5Var);
        return doWrite(methodKey.a());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> cancelPayload(long j) {
        return a(new y4(j));
    }

    public final void d(String str) {
        k a2;
        l3 l3Var = this.f2750a;
        synchronized (l3Var) {
            a2 = l3Var.a(this, l3Var.f(str), "connection");
        }
        k.a<L> aVar = a2.f2377c;
        i.j.t(aVar, "Key must not be null");
        this.f2750a.d(this, new o5(a2), new n5(aVar));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void disconnectFromEndpoint(String str) {
        b(new x4(str));
        e(str);
    }

    public final void e(String str) {
        k.a<?> L;
        l3 l3Var = this.f2750a;
        synchronized (l3Var) {
            L = i.j.L(l3Var.f(str), "connection");
        }
        l3Var.c(this, L);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> rejectConnection(String str) {
        return a(new h5(str));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        d(str2);
        q.a builder = q.builder();
        builder.f2389a = new f5(this, str, str2, registerListener);
        h doWrite = doWrite(builder.setMethodKey(1226).a());
        l5 l5Var = new l5(this, str2);
        a0 a0Var = (a0) doWrite;
        if (a0Var != null) {
            a0Var.c(j.f2857a, l5Var);
            return a0Var;
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> sendPayload(String str, Payload payload) {
        q.a builder = q.builder();
        builder.f2389a = new k5(this, str, payload);
        return doWrite(builder.setMethodKey(1228).a());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        k a2 = this.f2750a.a(this, new Object(), "advertising");
        k.a<L> aVar = a2.f2377c;
        i.j.t(aVar, "Key must not be null");
        return this.f2750a.d(this, new t5(this, a2, str, str2, registerListener, advertisingOptions), new w5(aVar));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions) {
        k a2 = this.f2750a.a(this, endpointDiscoveryCallback, "discovery");
        k.a<L> aVar = a2.f2377c;
        i.j.t(aVar, "Key must not be null");
        h<Void> d2 = this.f2750a.d(this, new v5(this, a2, str, a2, discoveryOptions), new m5(aVar));
        a0 a0Var = (a0) d2;
        a0Var.d(j.f2857a, new d5(this, discoveryOptions));
        return a0Var;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAdvertising() {
        this.f2750a.e(this, "advertising");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAllEndpoints() {
        this.f2750a.e(this, "advertising");
        h<Void> e2 = this.f2750a.e(this, "discovery");
        ((a0) e2).d(j.f2857a, new g5(this));
        b(a5.f2518a).b(new z4(this));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopDiscovery() {
        h<Void> e2 = this.f2750a.e(this, "discovery");
        ((a0) e2).d(j.f2857a, new g5(this));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> sendPayload(List<String> list, Payload payload) {
        q.a builder = q.builder();
        builder.f2389a = new v4(this, list, payload);
        return doWrite(builder.setMethodKey(1228).a());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> startAdvertising(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        k a2 = this.f2750a.a(this, new Object(), "advertising");
        k.a<L> aVar = a2.f2377c;
        i.j.t(aVar, "Key must not be null");
        return this.f2750a.d(this, new s5(this, a2, new c[]{zza.zza}, bArr, str, registerListener, advertisingOptions), new r5(aVar));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        d(str2);
        q.a builder = q.builder();
        builder.f2391c = new c[]{zza.zza};
        builder.f2389a = new t4(this, str, str2, registerListener, connectionOptions);
        h doWrite = doWrite(builder.setMethodKey(1226).a());
        q5 q5Var = new q5(this, str2);
        a0 a0Var = (a0) doWrite;
        if (a0Var != null) {
            a0Var.c(j.f2857a, q5Var);
            return a0Var;
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        d(str);
        q.a builder = q.builder();
        builder.f2391c = new c[]{zza.zza};
        builder.f2389a = new e5(this, bArr, str, registerListener);
        h doWrite = doWrite(builder.setMethodKey(1226).a());
        u5 u5Var = new u5(this, str);
        a0 a0Var = (a0) doWrite;
        if (a0Var != null) {
            a0Var.c(j.f2857a, u5Var);
            return a0Var;
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final h<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        d(str);
        q.a builder = q.builder();
        builder.f2391c = new c[]{zza.zza};
        builder.f2389a = new w4(this, bArr, str, registerListener, connectionOptions);
        h doWrite = doWrite(builder.setMethodKey(1226).a());
        p5 p5Var = new p5(this, str);
        a0 a0Var = (a0) doWrite;
        if (a0Var != null) {
            a0Var.c(j.f2857a, p5Var);
            return a0Var;
        }
        throw null;
    }
}
