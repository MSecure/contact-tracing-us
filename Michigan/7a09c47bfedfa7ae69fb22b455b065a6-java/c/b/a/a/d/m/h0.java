package c.b.a.a.d.m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import c.b.a.a.d.m.g;
import c.b.a.a.d.n.a;
import c.b.a.a.d.p.b;
import java.util.HashMap;
import java.util.Map;

public final class h0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final Map<ServiceConnection, ServiceConnection> f3124a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public int f3125b = 2;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3126c;

    /* renamed from: d  reason: collision with root package name */
    public IBinder f3127d;

    /* renamed from: e  reason: collision with root package name */
    public final g.a f3128e;

    /* renamed from: f  reason: collision with root package name */
    public ComponentName f3129f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ f0 f3130g;

    public h0(f0 f0Var, g.a aVar) {
        this.f3130g = f0Var;
        this.f3128e = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7  */
    public final void a(String str) {
        Intent intent;
        boolean z;
        Bundle bundle;
        this.f3125b = 3;
        f0 f0Var = this.f3130g;
        a aVar = f0Var.f3113f;
        Context context = f0Var.f3111d;
        g.a aVar2 = this.f3128e;
        if (aVar2.f3118a != null) {
            if (aVar2.f3122e) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("serviceActionBundleKey", aVar2.f3118a);
                try {
                    bundle = context.getContentResolver().call(g.a.f3117f, "serviceIntentCall", (String) null, bundle2);
                } catch (IllegalArgumentException e2) {
                    String.valueOf(e2).length();
                    bundle = null;
                }
                intent = bundle == null ? null : (Intent) bundle.getParcelable("serviceResponseIntentKey");
                if (intent == null) {
                    String valueOf = String.valueOf(aVar2.f3118a);
                    if (valueOf.length() != 0) {
                        "Dynamic lookup for intent failed for action: ".concat(valueOf);
                    } else {
                        new String("Dynamic lookup for intent failed for action: ");
                    }
                }
            } else {
                intent = null;
            }
            if (intent == null) {
                intent = new Intent(aVar2.f3118a).setPackage(aVar2.f3119b);
            }
        } else {
            intent = new Intent().setComponent(aVar2.f3120c);
        }
        int i = this.f3128e.f3121d;
        if (aVar != null) {
            ComponentName component = intent.getComponent();
            boolean z2 = false;
            if (component != null) {
                String packageName = component.getPackageName();
                "com.google.android.gms".equals(packageName);
                try {
                    if ((b.a(context).f3180a.getPackageManager().getApplicationInfo(packageName, 0).flags & 2097152) != 0) {
                        z = true;
                        if (!z) {
                            z2 = context.bindService(intent, this, i);
                        }
                        this.f3126c = z2;
                        if (!z2) {
                            Message obtainMessage = this.f3130g.f3112e.obtainMessage(1, this.f3128e);
                            f0 f0Var2 = this.f3130g;
                            f0Var2.f3112e.sendMessageDelayed(obtainMessage, f0Var2.h);
                            return;
                        }
                        this.f3125b = 2;
                        try {
                            this.f3130g.f3113f.a(this.f3130g.f3111d, this);
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
            this.f3126c = z2;
            if (!z2) {
            }
        } else {
            throw null;
        }
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f3130g.f3110c) {
            this.f3130g.f3112e.removeMessages(1, this.f3128e);
            this.f3127d = iBinder;
            this.f3129f = componentName;
            for (ServiceConnection serviceConnection : this.f3124a.values()) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f3125b = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f3130g.f3110c) {
            this.f3130g.f3112e.removeMessages(1, this.f3128e);
            this.f3127d = null;
            this.f3129f = componentName;
            for (ServiceConnection serviceConnection : this.f3124a.values()) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f3125b = 2;
        }
    }
}
