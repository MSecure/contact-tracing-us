package c.b.a.a.d.m;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import b.x.t;
import c.b.a.a.d.m.g;
import c.b.a.a.d.n.a;
import c.b.a.a.g.c.d;
import java.util.HashMap;

public final class f0 extends g {

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<g.a, h0> f3110c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final Context f3111d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f3112e;

    /* renamed from: f  reason: collision with root package name */
    public final a f3113f;

    /* renamed from: g  reason: collision with root package name */
    public final long f3114g;
    public final long h;

    public f0(Context context) {
        this.f3111d = context.getApplicationContext();
        this.f3112e = new d(context.getMainLooper(), new g0(this, null));
        if (a.f3170c == null) {
            synchronized (a.f3169b) {
                if (a.f3170c == null) {
                    a.f3170c = new a();
                }
            }
        }
        a aVar = a.f3170c;
        t.C(aVar);
        this.f3113f = aVar;
        this.f3114g = 5000;
        this.h = 300000;
    }

    @Override // c.b.a.a.d.m.g
    public final boolean d(g.a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        t.D(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f3110c) {
            h0 h0Var = this.f3110c.get(aVar);
            if (h0Var == null) {
                h0Var = new h0(this, aVar);
                h0Var.f3124a.put(serviceConnection, serviceConnection);
                h0Var.a(str);
                this.f3110c.put(aVar, h0Var);
            } else {
                this.f3112e.removeMessages(0, aVar);
                if (!h0Var.f3124a.containsKey(serviceConnection)) {
                    h0Var.f3124a.put(serviceConnection, serviceConnection);
                    int i = h0Var.f3125b;
                    if (i == 1) {
                        serviceConnection.onServiceConnected(h0Var.f3129f, h0Var.f3127d);
                    } else if (i == 2) {
                        h0Var.a(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            z = h0Var.f3126c;
        }
        return z;
    }
}
