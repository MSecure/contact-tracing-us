package c.b.a.a.g.e;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Pair;
import b.e.c;
import b.x.t;
import c.b.a.a.d.g;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.o.k;
import c.b.a.a.d.m.f;
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

public final class v3 extends f<j7> {

    /* renamed from: a  reason: collision with root package name */
    public final long f3769a = ((long) hashCode());

    /* renamed from: b  reason: collision with root package name */
    public final String f3770b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<g4> f3771c = new c();

    /* renamed from: d  reason: collision with root package name */
    public final Set<m4> f3772d = new c();

    /* renamed from: e  reason: collision with root package name */
    public final Set<x3> f3773e = new c();

    /* renamed from: f  reason: collision with root package name */
    public u8 f3774f;

    public v3(Context context, Looper looper, c.b.a.a.d.m.c cVar, ConnectionsOptions connectionsOptions, e.a aVar, e.b bVar) {
        super(context, looper, 54, cVar, aVar, bVar);
        this.f3770b = connectionsOptions == null ? null : connectionsOptions.getZeroPartyIdentifier();
    }

    public static Status c(int i) {
        return new Status(i, ConnectionsStatusCodes.getStatusCodeString(i));
    }

    @Override // c.b.a.a.d.m.b
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
        return queryLocalInterface instanceof j7 ? (j7) queryLocalInterface : new i7(iBinder);
    }

    public final void d() {
        ((j7) getService()).Z(new n9());
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final void disconnect() {
        if (isConnected()) {
            try {
                ((j7) getService()).j(new u3());
            } catch (RemoteException unused) {
            }
        }
        l();
        super.disconnect();
    }

    public final void e(c.b.a.a.d.k.o.e<Status> eVar, long j) {
        s3 s3Var = new s3(null);
        s3Var.f3705b = new p4(eVar);
        s3Var.f3706c = j;
        ((j7) getService()).b(s3Var);
    }

    public final void f(c.b.a.a.d.k.o.e<Status> eVar, String str) {
        y8 y8Var = new y8(null);
        y8Var.f3819b = new p4(eVar);
        y8Var.f3820c = str;
        ((j7) getService()).A(y8Var);
    }

    public final void g(c.b.a.a.d.k.o.e<Status> eVar, String str, k<PayloadCallback> kVar) {
        m4 m4Var = new m4(getContext(), kVar);
        this.f3772d.add(m4Var);
        p3 p3Var = new p3(null);
        p3Var.f3679b = new p4(eVar);
        p3Var.f3681d = str;
        p3Var.f3683f = m4Var;
        ((j7) getService()).b0(p3Var);
    }

    @Override // c.b.a.a.d.m.b
    public final c.b.a.a.d.c[] getApiFeatures() {
        return new c.b.a.a.d.c[]{zza.zza};
    }

    @Override // c.b.a.a.d.m.b
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.f3769a);
        String str = this.f3770b;
        if (str != null) {
            bundle.putString("zeroPartyIdentifier", str);
        }
        return bundle;
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final int getMinApkVersion() {
        return g.f2932a;
    }

    @Override // c.b.a.a.d.m.b
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    @Override // c.b.a.a.d.m.b
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    public final void h(c.b.a.a.d.k.o.e<Status> eVar, String str, k<EndpointDiscoveryCallback> kVar, DiscoveryOptions discoveryOptions) {
        g4 g4Var = new g4(kVar);
        this.f3771c.add(g4Var);
        k9 k9Var = new k9(null);
        k9Var.f3626b = new p4(eVar);
        k9Var.f3628d = str;
        k9Var.f3630f = discoveryOptions;
        k9Var.f3631g = g4Var;
        ((j7) getService()).Q(k9Var);
    }

    public final void i(c.b.a.a.d.k.o.e<Status> eVar, String str, String str2, k<ConnectionLifecycleCallback> kVar) {
        x3 x3Var = new x3(kVar);
        this.f3773e.add(x3Var);
        a9 a9Var = new a9(null);
        a9Var.f3503b = new p4(eVar);
        a9Var.f3506e = str;
        a9Var.f3507f = str2;
        a9Var.h = x3Var;
        ((j7) getService()).M(a9Var);
    }

    public final void j(c.b.a.a.d.k.o.e<Connections.StartAdvertisingResult> eVar, String str, String str2, k<ConnectionLifecycleCallback> kVar, AdvertisingOptions advertisingOptions) {
        x3 x3Var = new x3(kVar);
        this.f3773e.add(x3Var);
        h9 h9Var = new h9(null);
        h9Var.f3594b = new r4(eVar);
        h9Var.f3596d = str;
        h9Var.f3597e = str2;
        h9Var.f3599g = advertisingOptions;
        h9Var.h = x3Var;
        ((j7) getService()).E(h9Var);
    }

    /* JADX WARN: Incorrect args count in method signature: (Lc/b/a/a/d/k/o/e<Lcom/google/android/gms/common/api/Status;>;[Ljava/lang/String;Lcom/google/android/gms/nearby/connection/Payload;Z)V */
    public final void k(c.b.a.a.d.k.o.e eVar, String[] strArr, Payload payload) {
        try {
            Pair<w8, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> Y3 = t.Y3(payload);
            d9 d9Var = new d9(null);
            d9Var.f3537b = new p4(eVar);
            d9Var.f3538c = strArr;
            d9Var.f3539d = (w8) Y3.first;
            ((j7) getService()).V(d9Var);
            Object obj = Y3.second;
            if (obj != null) {
                Pair pair = (Pair) obj;
                u8 u8Var = this.f3774f;
                InputStream asInputStream = payload.asStream().asInputStream();
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.first);
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream2 = new ParcelFileDescriptor.AutoCloseOutputStream((ParcelFileDescriptor) pair.second);
                u8Var.f3755a.execute(new t8(u8Var, asInputStream, autoCloseOutputStream, payload.getId(), autoCloseOutputStream2));
            }
        } catch (IOException unused) {
            eVar.setResult(new Status(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR, ConnectionsStatusCodes.getStatusCodeString(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR)));
        }
    }

    public final void l() {
        for (g4 g4Var : this.f3771c) {
            synchronized (g4Var) {
                for (String str : g4Var.f3577b) {
                    g4Var.f3576a.a(new j4(str));
                }
                g4Var.f3577b.clear();
            }
        }
        for (m4 m4Var : this.f3772d) {
            synchronized (m4Var) {
                for (Map.Entry<q4, PayloadTransferUpdate> entry : m4Var.f3657c.entrySet()) {
                    m4Var.f3656b.a(new n4(entry.getKey().f3692a, entry.getValue()));
                }
                m4Var.f3657c.clear();
            }
        }
        for (x3 x3Var : this.f3773e) {
            synchronized (x3Var) {
                for (String str2 : x3Var.f3808b) {
                    x3Var.f3807a.a(new e4(str2));
                }
                x3Var.f3808b.clear();
                for (String str3 : x3Var.f3809c) {
                    x3Var.f3807a.a(new d4(str3));
                }
                x3Var.f3809c.clear();
            }
        }
        this.f3771c.clear();
        this.f3772d.clear();
        this.f3773e.clear();
        u8 u8Var = this.f3774f;
        if (u8Var != null) {
            u8Var.f3757c = true;
            u8Var.f3755a.shutdownNow();
            InputStream inputStream = u8Var.f3756b;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            this.f3774f = null;
        }
    }

    @Override // c.b.a.a.d.m.b
    public final /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        super.onConnectedLocked((j7) iInterface);
        this.f3774f = new u8();
    }

    @Override // c.b.a.a.d.m.b
    public final void onConnectionSuspended(int i) {
        if (i == 1) {
            l();
        }
        super.onConnectionSuspended(i);
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    @Override // c.b.a.a.d.m.b
    public final boolean usesClientTelemetry() {
        return true;
    }
}
