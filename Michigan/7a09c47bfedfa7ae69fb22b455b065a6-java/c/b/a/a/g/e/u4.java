package c.b.a.a.g.e;

import android.app.Activity;
import android.content.Context;
import b.x.t;
import c.b.a.a.d.c;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.d;
import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.r;
import c.b.a.a.j.b0;
import c.b.a.a.j.i;
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
    public static final a.g<v3> f3746c = new a.g<>();

    /* renamed from: d  reason: collision with root package name */
    public static final a.AbstractC0062a<v3, ConnectionsOptions> f3747d;

    /* renamed from: e  reason: collision with root package name */
    public static final a<ConnectionsOptions> f3748e;

    /* renamed from: a  reason: collision with root package name */
    public final l3 f3749a;

    /* renamed from: b  reason: collision with root package name */
    public final s7 f3750b;

    static {
        j5 j5Var = new j5();
        f3747d = j5Var;
        f3748e = new a<>("Nearby.CONNECTIONS_API", j5Var, f3746c);
    }

    public u4(Activity activity) {
        super(activity, f3748e, (ConnectionsOptions) null, d.a.f2942c);
        this.f3749a = l3.b(this);
        this.f3750b = s7.a(activity);
    }

    public u4(Context context) {
        super(context, f3748e, (ConnectionsOptions) null, d.a.f2942c);
        this.f3749a = l3.b(this);
        this.f3750b = null;
    }

    public static final void c(v3 v3Var) {
        ((j7) v3Var.getService()).y(new q9());
    }

    public final i<Void> a(y5 y5Var) {
        r.a builder = r.builder();
        builder.b(1229);
        builder.f3043a = new c5(this, y5Var);
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> acceptConnection(String str, PayloadCallback payloadCallback) {
        k registerListener = registerListener(payloadCallback, PayloadCallback.class.getName());
        r.a builder = r.builder();
        builder.f3043a = new i5(this, str, registerListener);
        builder.b(1227);
        return doWrite(builder.a());
    }

    public final i<Void> b(z5 z5Var) {
        r.a builder = r.builder();
        builder.b(1229);
        builder.f3043a = new b5(z5Var);
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> cancelPayload(long j) {
        return a(new y4(j));
    }

    public final void d(String str) {
        k a2;
        l3 l3Var = this.f3749a;
        synchronized (l3Var) {
            a2 = l3Var.a(this, l3Var.f(str), "connection");
        }
        k.a<L> aVar = a2.f3020c;
        t.D(aVar, "Key must not be null");
        this.f3749a.d(this, new o5(a2), new n5(aVar));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void disconnectFromEndpoint(String str) {
        b(new x4(str));
        e(str);
    }

    public final void e(String str) {
        k.a<?> Y;
        l3 l3Var = this.f3749a;
        synchronized (l3Var) {
            Y = t.Y(l3Var.f(str), "connection");
        }
        l3Var.c(this, Y);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> rejectConnection(String str) {
        return a(new h5(str));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        d(str2);
        r.a builder = r.builder();
        builder.f3043a = new f5(this, str, str2, registerListener);
        builder.b(1226);
        i doWrite = doWrite(builder.a());
        l5 l5Var = new l5(this, str2);
        b0 b0Var = (b0) doWrite;
        if (b0Var != null) {
            b0Var.c(c.b.a.a.j.k.f4110a, l5Var);
            return b0Var;
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> sendPayload(String str, Payload payload) {
        r.a builder = r.builder();
        builder.f3043a = new k5(this, str, payload);
        builder.b(1228);
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> startAdvertising(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        k a2 = this.f3749a.a(this, new Object(), "advertising");
        k.a<L> aVar = a2.f3020c;
        t.D(aVar, "Key must not be null");
        return this.f3749a.d(this, new t5(this, a2, str, str2, registerListener, advertisingOptions), new w5(aVar));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> startDiscovery(String str, EndpointDiscoveryCallback endpointDiscoveryCallback, DiscoveryOptions discoveryOptions) {
        k a2 = this.f3749a.a(this, endpointDiscoveryCallback, "discovery");
        k.a<L> aVar = a2.f3020c;
        t.D(aVar, "Key must not be null");
        i<Void> d2 = this.f3749a.d(this, new v5(this, a2, str, a2, discoveryOptions), new m5(aVar));
        b0 b0Var = (b0) d2;
        b0Var.d(c.b.a.a.j.k.f4110a, new d5(this, discoveryOptions));
        return b0Var;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAdvertising() {
        this.f3749a.e(this, "advertising");
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAllEndpoints() {
        this.f3749a.e(this, "advertising");
        i<Void> e2 = this.f3749a.e(this, "discovery");
        ((b0) e2).d(c.b.a.a.j.k.f4110a, new g5(this));
        b(a5.f3501a).b(new z4(this));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopDiscovery() {
        i<Void> e2 = this.f3749a.e(this, "discovery");
        ((b0) e2).d(c.b.a.a.j.k.f4110a, new g5(this));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> sendPayload(List<String> list, Payload payload) {
        r.a builder = r.builder();
        builder.f3043a = new v4(this, list, payload);
        builder.b(1228);
        return doWrite(builder.a());
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> startAdvertising(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, AdvertisingOptions advertisingOptions) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        k a2 = this.f3749a.a(this, new Object(), "advertising");
        k.a<L> aVar = a2.f3020c;
        t.D(aVar, "Key must not be null");
        return this.f3749a.d(this, new s5(this, a2, new c[]{zza.zza}, bArr, str, registerListener, advertisingOptions), new r5(aVar));
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> requestConnection(String str, String str2, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        d(str2);
        r.a builder = r.builder();
        builder.f3045c = new c[]{zza.zza};
        builder.f3043a = new t4(this, str, str2, registerListener, connectionOptions);
        builder.b(1226);
        i doWrite = doWrite(builder.a());
        q5 q5Var = new q5(this, str2);
        b0 b0Var = (b0) doWrite;
        if (b0Var != null) {
            b0Var.c(c.b.a.a.j.k.f4110a, q5Var);
            return b0Var;
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        d(str);
        r.a builder = r.builder();
        builder.f3045c = new c[]{zza.zza};
        builder.f3043a = new e5(this, bArr, str, registerListener);
        builder.b(1226);
        i doWrite = doWrite(builder.a());
        u5 u5Var = new u5(this, str);
        b0 b0Var = (b0) doWrite;
        if (b0Var != null) {
            b0Var.c(c.b.a.a.j.k.f4110a, u5Var);
            return b0Var;
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionsClient
    public final i<Void> requestConnection(byte[] bArr, String str, ConnectionLifecycleCallback connectionLifecycleCallback, ConnectionOptions connectionOptions) {
        k registerListener = registerListener(new x5(this, connectionLifecycleCallback), ConnectionLifecycleCallback.class.getName());
        d(str);
        r.a builder = r.builder();
        builder.f3045c = new c[]{zza.zza};
        builder.f3043a = new w4(this, bArr, str, registerListener, connectionOptions);
        builder.b(1226);
        i doWrite = doWrite(builder.a());
        p5 p5Var = new p5(this, str);
        b0 b0Var = (b0) doWrite;
        if (b0Var != null) {
            b0Var.c(c.b.a.a.j.k.f4110a, p5Var);
            return b0Var;
        }
        throw null;
    }
}
