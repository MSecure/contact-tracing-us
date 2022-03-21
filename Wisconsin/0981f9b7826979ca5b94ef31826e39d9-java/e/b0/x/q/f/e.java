package e.b0.x.q.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import e.b0.l;

public class e extends d<e.b0.x.q.b> {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1095j = l.e("NetworkStateTracker");

    /* renamed from: g  reason: collision with root package name */
    public final ConnectivityManager f1096g = ((ConnectivityManager) this.b.getSystemService("connectivity"));

    /* renamed from: h  reason: collision with root package name */
    public b f1097h;

    /* renamed from: i  reason: collision with root package name */
    public a f1098i;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                l.c().a(e.f1095j, "Network broadcast received", new Throwable[0]);
                e eVar = e.this;
                eVar.c(eVar.f());
            }
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            l.c().a(e.f1095j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            e eVar = e.this;
            eVar.c(eVar.f());
        }

        public void onLost(Network network) {
            l.c().a(e.f1095j, "Network connection lost", new Throwable[0]);
            e eVar = e.this;
            eVar.c(eVar.f());
        }
    }

    public e(Context context, e.b0.x.t.q.a aVar) {
        super(context, aVar);
        if (g()) {
            this.f1097h = new b();
        } else {
            this.f1098i = new a();
        }
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.b0.x.q.f.d
    public e.b0.x.q.b a() {
        return f();
    }

    @Override // e.b0.x.q.f.d
    public void d() {
        if (g()) {
            try {
                l.c().a(f1095j, "Registering network callback", new Throwable[0]);
                this.f1096g.registerDefaultNetworkCallback(this.f1097h);
            } catch (IllegalArgumentException | SecurityException e2) {
                l.c().b(f1095j, "Received exception while registering network callback", e2);
            }
        } else {
            l.c().a(f1095j, "Registering broadcast receiver", new Throwable[0]);
            this.b.registerReceiver(this.f1098i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // e.b0.x.q.f.d
    public void e() {
        if (g()) {
            try {
                l.c().a(f1095j, "Unregistering network callback", new Throwable[0]);
                this.f1096g.unregisterNetworkCallback(this.f1097h);
            } catch (IllegalArgumentException | SecurityException e2) {
                l.c().b(f1095j, "Received exception while unregistering network callback", e2);
            }
        } else {
            l.c().a(f1095j, "Unregistering broadcast receiver", new Throwable[0]);
            this.b.unregisterReceiver(this.f1098i);
        }
    }

    public e.b0.x.q.b f() {
        boolean z;
        NetworkInfo activeNetworkInfo = this.f1096g.getActiveNetworkInfo();
        boolean z2 = false;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                NetworkCapabilities networkCapabilities = this.f1096g.getNetworkCapabilities(this.f1096g.getActiveNetwork());
                if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                    z = true;
                    boolean isActiveNetworkMetered = this.f1096g.isActiveNetworkMetered();
                    if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
                        z2 = true;
                    }
                    return new e.b0.x.q.b(z3, z, isActiveNetworkMetered, z2);
                }
            } catch (SecurityException e2) {
                l.c().b(f1095j, "Unable to validate active network", e2);
            }
        }
        z = false;
        boolean isActiveNetworkMetered2 = this.f1096g.isActiveNetworkMetered();
        z2 = true;
        return new e.b0.x.q.b(z3, z, isActiveNetworkMetered2, z2);
    }
}
