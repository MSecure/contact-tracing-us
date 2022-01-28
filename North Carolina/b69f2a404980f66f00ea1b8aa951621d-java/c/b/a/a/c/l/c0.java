package c.b.a.a.c.l;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.Message;
import c.b.a.a.c.l.h;
import c.b.a.a.c.m.a;
import c.b.a.a.c.o.b;
import java.util.HashMap;
import java.util.Map;

public final class c0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Map<ServiceConnection, ServiceConnection> f2442a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public int f2443b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2444c;

    /* renamed from: d  reason: collision with root package name */
    public IBinder f2445d;

    /* renamed from: e  reason: collision with root package name */
    public final h.a f2446e;
    public ComponentName f;
    public final /* synthetic */ d0 g;

    public c0(d0 d0Var, h.a aVar) {
        this.g = d0Var;
        this.f2446e = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    public final void a(String str) {
        boolean z;
        this.f2443b = 3;
        d0 d0Var = this.g;
        a aVar = d0Var.f;
        Context context = d0Var.f2449d;
        Intent a2 = this.f2446e.a(context);
        int i = this.f2446e.f2464d;
        if (aVar != null) {
            ComponentName component = a2.getComponent();
            boolean z2 = false;
            if (component != null) {
                String packageName = component.getPackageName();
                "com.google.android.gms".equals(packageName);
                try {
                    if ((b.a(context).f2499a.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                        z = true;
                        if (!z) {
                            z2 = context.bindService(a2, this, i);
                        }
                        this.f2444c = z2;
                        if (!z2) {
                            Message obtainMessage = this.g.f2450e.obtainMessage(1, this.f2446e);
                            d0 d0Var2 = this.g;
                            d0Var2.f2450e.sendMessageDelayed(obtainMessage, d0Var2.h);
                            return;
                        }
                        this.f2443b = 2;
                        try {
                            a aVar2 = this.g.f;
                            Context context2 = this.g.f2449d;
                            if (aVar2 != null) {
                                context2.unbindService(this);
                                return;
                            }
                            throw null;
                        } catch (IllegalArgumentException unused) {
                            return;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                }
            }
            z = false;
            if (!z) {
            }
            this.f2444c = z2;
            if (!z2) {
            }
        } else {
            throw null;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.g.f2448c) {
            this.g.f2450e.removeMessages(1, this.f2446e);
            this.f2445d = iBinder;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.f2442a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f2443b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.g.f2448c) {
            this.g.f2450e.removeMessages(1, this.f2446e);
            this.f2445d = null;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.f2442a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f2443b = 2;
        }
    }
}
