package e.c0.a0.q.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import e.c0.n;
/* loaded from: classes.dex */
public class e extends d<e.c0.a0.q.b> {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1173j = n.e("NetworkStateTracker");

    /* renamed from: g  reason: collision with root package name */
    public final ConnectivityManager f1174g = (ConnectivityManager) this.b.getSystemService("connectivity");

    /* renamed from: h  reason: collision with root package name */
    public b f1175h;

    /* renamed from: i  reason: collision with root package name */
    public a f1176i;

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                n.c().a(e.f1173j, "Network broadcast received", new Throwable[0]);
                e eVar = e.this;
                eVar.c(eVar.f());
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            n.c().a(e.f1173j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            e eVar = e.this;
            eVar.c(eVar.f());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            n.c().a(e.f1173j, "Network connection lost", new Throwable[0]);
            e eVar = e.this;
            eVar.c(eVar.f());
        }
    }

    public e(Context context, e.c0.a0.t.t.a aVar) {
        super(context, aVar);
        if (g()) {
            this.f1175h = new b();
        } else {
            this.f1176i = new a();
        }
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Override // e.c0.a0.q.f.d
    public e.c0.a0.q.b a() {
        return f();
    }

    @Override // e.c0.a0.q.f.d
    public void d() {
        if (g()) {
            try {
                n.c().a(f1173j, "Registering network callback", new Throwable[0]);
                this.f1174g.registerDefaultNetworkCallback(this.f1175h);
            } catch (IllegalArgumentException | SecurityException e2) {
                n.c().b(f1173j, "Received exception while registering network callback", e2);
            }
        } else {
            n.c().a(f1173j, "Registering broadcast receiver", new Throwable[0]);
            this.b.registerReceiver(this.f1176i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // e.c0.a0.q.f.d
    public void e() {
        if (g()) {
            try {
                n.c().a(f1173j, "Unregistering network callback", new Throwable[0]);
                this.f1174g.unregisterNetworkCallback(this.f1175h);
            } catch (IllegalArgumentException | SecurityException e2) {
                n.c().b(f1173j, "Received exception while unregistering network callback", e2);
            }
        } else {
            n.c().a(f1173j, "Unregistering broadcast receiver", new Throwable[0]);
            this.b.unregisterReceiver(this.f1176i);
        }
    }

    public e.c0.a0.q.b f() {
        NetworkCapabilities networkCapabilities;
        boolean z;
        NetworkInfo activeNetworkInfo = this.f1174g.getActiveNetworkInfo();
        boolean z2 = false;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                networkCapabilities = this.f1174g.getNetworkCapabilities(this.f1174g.getActiveNetwork());
            } catch (SecurityException e2) {
                n.c().b(f1173j, "Unable to validate active network", e2);
            }
            if (networkCapabilities != null) {
                if (networkCapabilities.hasCapability(16)) {
                    z = true;
                    boolean isActiveNetworkMetered = this.f1174g.isActiveNetworkMetered();
                    if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
                        z2 = true;
                    }
                    return new e.c0.a0.q.b(z3, z, isActiveNetworkMetered, z2);
                }
            }
        }
        z = false;
        boolean isActiveNetworkMetered2 = this.f1174g.isActiveNetworkMetered();
        if (activeNetworkInfo != null) {
            z2 = true;
        }
        return new e.c0.a0.q.b(z3, z, isActiveNetworkMetered2, z2);
    }
}
