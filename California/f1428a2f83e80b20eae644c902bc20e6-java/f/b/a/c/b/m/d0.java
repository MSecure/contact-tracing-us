package f.b.a.c.b.m;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import e.b.a.m;
import f.b.a.c.b.m.b;
import f.b.a.c.b.m.g;
import f.b.a.c.b.n.a;
import f.b.a.c.e.b.d;
import java.util.HashMap;
import java.util.Objects;

public final class d0 extends g {
    public final HashMap<g.a, f0> c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final Context f2457d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f2458e;

    /* renamed from: f  reason: collision with root package name */
    public final a f2459f;

    /* renamed from: g  reason: collision with root package name */
    public final long f2460g;

    /* renamed from: h  reason: collision with root package name */
    public final long f2461h;

    public d0(Context context) {
        this.f2457d = context.getApplicationContext();
        this.f2458e = new d(context.getMainLooper(), new e0(this, null));
        if (a.c == null) {
            synchronized (a.b) {
                if (a.c == null) {
                    a.c = new a();
                }
            }
        }
        a aVar = a.c;
        Objects.requireNonNull(aVar, "null reference");
        this.f2459f = aVar;
        this.f2460g = 5000;
        this.f2461h = 300000;
    }

    @Override // f.b.a.c.b.m.g
    public final boolean a(g.a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        m.h.p(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.c) {
            f0 f0Var = this.c.get(aVar);
            if (f0Var == null) {
                f0Var = new f0(this, aVar);
                f0Var.a.put(serviceConnection, serviceConnection);
                f0Var.a(str);
                this.c.put(aVar, f0Var);
            } else {
                this.f2458e.removeMessages(0, aVar);
                if (!f0Var.a.containsKey(serviceConnection)) {
                    f0Var.a.put(serviceConnection, serviceConnection);
                    int i2 = f0Var.b;
                    if (i2 == 1) {
                        ((b.i) serviceConnection).onServiceConnected(f0Var.f2473f, f0Var.f2471d);
                    } else if (i2 == 2) {
                        f0Var.a(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            z = f0Var.c;
        }
        return z;
    }

    @Override // f.b.a.c.b.m.g
    public final void b(g.a aVar, ServiceConnection serviceConnection, String str) {
        m.h.p(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.c) {
            f0 f0Var = this.c.get(aVar);
            if (f0Var == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (f0Var.a.containsKey(serviceConnection)) {
                f0Var.a.remove(serviceConnection);
                if (f0Var.a.isEmpty()) {
                    this.f2458e.sendMessageDelayed(this.f2458e.obtainMessage(0, aVar), this.f2460g);
                }
            } else {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }
}
