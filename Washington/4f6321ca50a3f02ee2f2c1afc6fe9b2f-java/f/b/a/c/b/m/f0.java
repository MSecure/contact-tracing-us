package f.b.a.c.b.m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import f.b.a.c.b.m.g;
import f.b.a.c.b.n.a;
import f.b.a.c.b.p.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class f0 implements ServiceConnection {
    public final Map<ServiceConnection, ServiceConnection> a = new HashMap();
    public int b = 2;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public IBinder f2479d;

    /* renamed from: e  reason: collision with root package name */
    public final g.a f2480e;

    /* renamed from: f  reason: collision with root package name */
    public ComponentName f2481f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ d0 f2482g;

    public f0(d0 d0Var, g.a aVar) {
        this.f2482g = d0Var;
        this.f2480e = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e8  */
    public final void a(String str) {
        boolean z;
        Bundle bundle;
        this.b = 3;
        d0 d0Var = this.f2482g;
        a aVar = d0Var.f2467f;
        Context context = d0Var.f2465d;
        g.a aVar2 = this.f2480e;
        Intent intent = null;
        if (aVar2.a != null) {
            if (aVar2.f2484d) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", aVar2.a);
                try {
                    bundle = context.getContentResolver().call(g.a.f2483e, "serviceIntentCall", (String) null, bundle2);
                } catch (IllegalArgumentException e2) {
                    String valueOf = String.valueOf(e2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 34);
                    sb.append("Dynamic intent resolution failed: ");
                    sb.append(valueOf);
                    Log.w("ConnectionStatusConfig", sb.toString());
                    bundle = null;
                }
                if (bundle != null) {
                    intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                }
                if (intent == null) {
                    String valueOf2 = String.valueOf(aVar2.a);
                    Log.w("ConnectionStatusConfig", valueOf2.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf2) : new String("Dynamic lookup for intent failed for action: "));
                }
            }
            if (intent == null) {
                intent = new Intent(aVar2.a).setPackage(aVar2.b);
            }
        } else {
            intent = new Intent().setComponent(null);
        }
        int i2 = this.f2480e.c;
        Objects.requireNonNull(aVar);
        ComponentName component = intent.getComponent();
        boolean z2 = false;
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((b.a(context).a.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                    z = true;
                    if (!z) {
                        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    } else {
                        z2 = context.bindService(intent, this, i2);
                    }
                    this.c = z2;
                    if (!z2) {
                        Message obtainMessage = this.f2482g.f2466e.obtainMessage(1, this.f2480e);
                        d0 d0Var2 = this.f2482g;
                        d0Var2.f2466e.sendMessageDelayed(obtainMessage, d0Var2.f2469h);
                        return;
                    }
                    this.b = 2;
                    try {
                        d0 d0Var3 = this.f2482g;
                        d0Var3.f2467f.a(d0Var3.f2465d, this);
                        return;
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
        this.c = z2;
        if (!z2) {
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f2482g.c) {
            this.f2482g.f2466e.removeMessages(1, this.f2480e);
            this.f2479d = iBinder;
            this.f2481f = componentName;
            for (ServiceConnection serviceConnection : this.a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f2482g.c) {
            this.f2482g.f2466e.removeMessages(1, this.f2480e);
            this.f2479d = null;
            this.f2481f = componentName;
            for (ServiceConnection serviceConnection : this.a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.b = 2;
        }
    }
}
