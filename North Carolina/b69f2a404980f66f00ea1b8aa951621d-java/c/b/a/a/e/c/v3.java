package c.b.a.a.e.c;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Pair;
import b.e.c;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.o.k;
import c.b.a.a.c.l.g;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.zza;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

public final class v3 extends g<j7> {

    /* renamed from: a  reason: collision with root package name */
    public final long f2767a = ((long) hashCode());

    /* renamed from: b  reason: collision with root package name */
    public final String f2768b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<g4> f2769c = new c();

    /* renamed from: d  reason: collision with root package name */
    public final Set<m4> f2770d = new c();

    /* renamed from: e  reason: collision with root package name */
    public final Set<x3> f2771e = new c();
    public u8 f;

    public v3(Context context, Looper looper, c.b.a.a.c.l.c cVar, ConnectionsOptions connectionsOptions, e.a aVar, e.b bVar) {
        super(context, looper, 54, cVar, aVar, bVar);
        this.f2768b = connectionsOptions == null ? null : connectionsOptions.getZeroPartyIdentifier();
    }

    public static Status c(int i) {
        return new Status(1, i, ConnectionsStatusCodes.getStatusCodeString(i), null);
    }

    @Override // c.b.a.a.c.l.b
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        return queryLocalInterface instanceof j7 ? (j7) queryLocalInterface : new i7(iBinder);
    }

    public final void d() {
        ((j7) getService()).c0(new n9());
    }

    @Override // c.b.a.a.c.l.b, c.b.a.a.c.k.a.f
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((j7) getService()).m(new u3());
            } catch (RemoteException unused) {
            }
        }
        l();
        super.disconnect();
    }

    public final void e(c.b.a.a.c.k.o.e<Status> eVar, long j) {
        s3 s3Var = new s3(null);
        s3Var.f2711b = new p4(eVar);
        s3Var.f2712c = j;
        ((j7) getService()).f(s3Var);
    }

    public final void f(c.b.a.a.c.k.o.e<Status> eVar, String str) {
        y8 y8Var = new y8(null);
        y8Var.f2812b = new p4(eVar);
        y8Var.f2813c = str;
        ((j7) getService()).D(y8Var);
    }

    public final void g(c.b.a.a.c.k.o.e<Status> eVar, String str, k<PayloadCallback> kVar) {
        m4 m4Var = new m4(getContext(), kVar);
        this.f2770d.add(m4Var);
        p3 p3Var = new p3(null);
        p3Var.f2686b = new p4(eVar);
        p3Var.f2688d = str;
        p3Var.f = m4Var;
        ((j7) getService()).e0(p3Var);
    }

    @Override // c.b.a.a.c.l.b
    public final c.b.a.a.c.c[] getApiFeatures() {
        return new c.b.a.a.c.c[]{zza.zza};
    }

    @Override // c.b.a.a.c.l.b
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.f2767a);
        String str = this.f2768b;
        if (str != null) {
            bundle.putString("zeroPartyIdentifier", str);
        }
        return bundle;
    }

    @Override // c.b.a.a.c.l.g, c.b.a.a.c.l.b, c.b.a.a.c.k.a.f
    public final int getMinApkVersion() {
        return c.b.a.a.c.g.f2295a;
    }

    @Override // c.b.a.a.c.l.b
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    @Override // c.b.a.a.c.l.b
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    public final void h(c.b.a.a.c.k.o.e<Status> eVar, String str, k<EndpointDiscoveryCallback> kVar, DiscoveryOptions discoveryOptions) {
        g4 g4Var = new g4(kVar);
        this.f2769c.add(g4Var);
        k9 k9Var = new k9(null);
        k9Var.f2638b = new p4(eVar);
        k9Var.f2640d = str;
        k9Var.f = discoveryOptions;
        k9Var.g = g4Var;
        ((j7) getService()).T(k9Var);
    }

    public final void i(c.b.a.a.c.k.o.e<Status> eVar, String str, String str2, k<ConnectionLifecycleCallback> kVar) {
        x3 x3Var = new x3(kVar);
        this.f2771e.add(x3Var);
        a9 a9Var = new a9(null);
        a9Var.f2520b = new p4(eVar);
        a9Var.f2523e = str;
        a9Var.f = str2;
        a9Var.h = x3Var;
        ((j7) getService()).P(a9Var);
    }

    public final void j(c.b.a.a.c.k.o.e<Connections.StartAdvertisingResult> eVar, String str, String str2, k<ConnectionLifecycleCallback> kVar, AdvertisingOptions advertisingOptions) {
        x3 x3Var = new x3(kVar);
        this.f2771e.add(x3Var);
        h9 h9Var = new h9(null);
        h9Var.f2608b = new r4(eVar);
        h9Var.f2610d = str;
        h9Var.f2611e = str2;
        h9Var.g = advertisingOptions;
        h9Var.h = x3Var;
        ((j7) getService()).H(h9Var);
    }

    /* JADX WARN: Incorrect args count in method signature: (Lc/b/a/a/c/k/o/e<Lcom/google/android/gms/common/api/Status;>;[Ljava/lang/String;Lcom/google/android/gms/nearby/connection/Payload;Z)V */
    public final void k(c.b.a.a.c.k.o.e eVar, String[] strArr, Payload payload) {
        try {
            Pair<w8, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> G2 = c.b.a.a.c.n.c.G2(payload);
            d9 d9Var = new d9(null);
            d9Var.f2552b = new p4(eVar);
            d9Var.f2553c = strArr;
            d9Var.f2554d = (w8) G2.first;
            ((j7) getService()).Y(d9Var);
            Object obj = G2.second;
            if (obj != null) {
                Pair pair = (Pair) obj;
                u8 u8Var = this.f;
                InputStream asInputStream = payload.asStream().asInputStream();
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.first);
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.second);
                u8Var.f2756a.execute(new t8(u8Var, asInputStream, autoCloseOutputStream, payload.getId(), autoCloseOutputStream2));
            }
        } catch (IOException unused) {
            eVar.setResult(new Status(1, ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR, ConnectionsStatusCodes.getStatusCodeString(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR), null));
        }
    }

    public final void l() {
        for (g4 g4Var : this.f2769c) {
            synchronized (g4Var) {
                for (String str : g4Var.f2592b) {
                    g4Var.f2591a.a(new j4(str));
                }
                g4Var.f2592b.clear();
            }
        }
        for (m4 m4Var : this.f2770d) {
            synchronized (m4Var) {
                for (Map.Entry<q4, PayloadTransferUpdate> entry : m4Var.f2665c.entrySet()) {
                    m4Var.f2664b.a(new n4(entry.getKey().f2698a, entry.getValue()));
                }
                m4Var.f2665c.clear();
            }
        }
        for (x3 x3Var : this.f2771e) {
            synchronized (x3Var) {
                for (String str2 : x3Var.f2801b) {
                    x3Var.f2800a.a(new e4(str2));
                }
                x3Var.f2801b.clear();
                for (String str3 : x3Var.f2802c) {
                    x3Var.f2800a.a(new d4(str3));
                }
                x3Var.f2802c.clear();
            }
        }
        this.f2769c.clear();
        this.f2770d.clear();
        this.f2771e.clear();
        u8 u8Var = this.f;
        if (u8Var != null) {
            u8Var.f2758c = true;
            u8Var.f2756a.shutdownNow();
            InputStream inputStream = u8Var.f2757b;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            this.f = null;
        }
    }

    @Override // c.b.a.a.c.l.b
    public final /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        super.onConnectedLocked((j7) iInterface);
        this.f = new u8();
    }

    @Override // c.b.a.a.c.l.b
    public final void onConnectionSuspended(int i) {
        if (i == 1) {
            l();
        }
        super.onConnectionSuspended(i);
    }

    @Override // c.b.a.a.c.l.b, c.b.a.a.c.k.a.f
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }
}
