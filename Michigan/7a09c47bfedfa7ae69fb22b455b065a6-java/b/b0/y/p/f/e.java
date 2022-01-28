package b.b0.y.p.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import b.b0.m;

public class e extends d<b.b0.y.p.b> {
    public static final String j = m.e("NetworkStateTracker");

    /* renamed from: g  reason: collision with root package name */
    public final ConnectivityManager f1189g = ((ConnectivityManager) this.f1183b.getSystemService("connectivity"));
    public b h;
    public a i;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                m.c().a(e.j, "Network broadcast received", new Throwable[0]);
                e eVar = e.this;
                eVar.c(eVar.f());
            }
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            m.c().a(e.j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            e eVar = e.this;
            eVar.c(eVar.f());
        }

        public void onLost(Network network) {
            m.c().a(e.j, "Network connection lost", new Throwable[0]);
            e eVar = e.this;
            eVar.c(eVar.f());
        }
    }

    public e(Context context, b.b0.y.s.s.a aVar) {
        super(context, aVar);
        if (g()) {
            this.h = new b();
        } else {
            this.i = new a();
        }
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // b.b0.y.p.f.d
    public b.b0.y.p.b a() {
        return f();
    }

    @Override // b.b0.y.p.f.d
    public void d() {
        if (g()) {
            try {
                m.c().a(j, "Registering network callback", new Throwable[0]);
                this.f1189g.registerDefaultNetworkCallback(this.h);
            } catch (IllegalArgumentException | SecurityException e2) {
                m.c().b(j, "Received exception while registering network callback", e2);
            }
        } else {
            m.c().a(j, "Registering broadcast receiver", new Throwable[0]);
            this.f1183b.registerReceiver(this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // b.b0.y.p.f.d
    public void e() {
        if (g()) {
            try {
                m.c().a(j, "Unregistering network callback", new Throwable[0]);
                this.f1189g.unregisterNetworkCallback(this.h);
            } catch (IllegalArgumentException | SecurityException e2) {
                m.c().b(j, "Received exception while unregistering network callback", e2);
            }
        } else {
            m.c().a(j, "Unregistering broadcast receiver", new Throwable[0]);
            this.f1183b.unregisterReceiver(this.i);
        }
    }

    public b.b0.y.p.b f() {
        boolean z;
        NetworkInfo activeNetworkInfo = this.f1189g.getActiveNetworkInfo();
        boolean z2 = true;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            NetworkCapabilities networkCapabilities = this.f1189g.getNetworkCapabilities(this.f1189g.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                z = true;
                boolean isActiveNetworkMetered = this.f1189g.isActiveNetworkMetered();
                if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
                    z2 = false;
                }
                return new b.b0.y.p.b(z3, z, isActiveNetworkMetered, z2);
            }
        } catch (SecurityException e2) {
            m.c().b(j, "Unable to validate active network", e2);
        }
        z = false;
        boolean isActiveNetworkMetered2 = this.f1189g.isActiveNetworkMetered();
        z2 = false;
        return new b.b0.y.p.b(z3, z, isActiveNetworkMetered2, z2);
    }
}
