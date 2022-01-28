package c.b.a.a.c.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import b.b.k.i;
import c.b.a.a.c.l.h;
import c.b.a.a.c.m.a;
import c.b.a.a.e.b.d;
import java.util.HashMap;

public final class d0 extends h implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    public final HashMap<h.a, c0> f2448c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public final Context f2449d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f2450e;
    public final a f;
    public final long g;
    public final long h;

    public d0(Context context) {
        this.f2449d = context.getApplicationContext();
        this.f2450e = new d(context.getMainLooper(), this);
        if (a.f2491b == null) {
            synchronized (a.f2490a) {
                if (a.f2491b == null) {
                    a.f2491b = new a();
                }
            }
        }
        this.f = a.f2491b;
        this.g = 5000;
        this.h = 300000;
    }

    @Override // c.b.a.a.c.l.h
    public final boolean d(h.a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        i.j.t(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f2448c) {
            c0 c0Var = this.f2448c.get(aVar);
            if (c0Var == null) {
                c0Var = new c0(this, aVar);
                d0 d0Var = c0Var.g;
                a aVar2 = d0Var.f;
                c0Var.f2446e.a(d0Var.f2449d);
                c0Var.f2442a.put(serviceConnection, serviceConnection);
                c0Var.a(str);
                this.f2448c.put(aVar, c0Var);
            } else {
                this.f2450e.removeMessages(0, aVar);
                if (!c0Var.f2442a.containsKey(serviceConnection)) {
                    d0 d0Var2 = c0Var.g;
                    a aVar3 = d0Var2.f;
                    c0Var.f2446e.a(d0Var2.f2449d);
                    c0Var.f2442a.put(serviceConnection, serviceConnection);
                    int i = c0Var.f2443b;
                    if (i == 1) {
                        serviceConnection.onServiceConnected(c0Var.f, c0Var.f2445d);
                    } else if (i == 2) {
                        c0Var.a(str);
                    }
                } else {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            z = c0Var.f2444c;
        }
        return z;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f2448c) {
                h.a aVar = (h.a) message.obj;
                c0 c0Var = this.f2448c.get(aVar);
                if (c0Var != null && c0Var.f2442a.isEmpty()) {
                    if (c0Var.f2444c) {
                        c0Var.g.f2450e.removeMessages(1, c0Var.f2446e);
                        d0 d0Var = c0Var.g;
                        a aVar2 = d0Var.f;
                        Context context = d0Var.f2449d;
                        if (aVar2 != null) {
                            context.unbindService(c0Var);
                            c0Var.f2444c = false;
                            c0Var.f2443b = 2;
                        } else {
                            throw null;
                        }
                    }
                    this.f2448c.remove(aVar);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f2448c) {
                h.a aVar3 = (h.a) message.obj;
                c0 c0Var2 = this.f2448c.get(aVar3);
                if (c0Var2 != null && c0Var2.f2443b == 3) {
                    String.valueOf(aVar3).length();
                    new Exception();
                    ComponentName componentName = c0Var2.f;
                    if (componentName == null) {
                        componentName = aVar3.f2463c;
                    }
                    if (componentName == null) {
                        componentName = new ComponentName(aVar3.f2462b, "unknown");
                    }
                    c0Var2.onServiceDisconnected(componentName);
                }
            }
            return true;
        }
    }
}
