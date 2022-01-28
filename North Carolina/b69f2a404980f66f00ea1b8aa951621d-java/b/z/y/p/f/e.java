package b.z.y.p.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import b.z.m;

public class e extends d<b.z.y.p.b> {
    public static final String j = m.e("NetworkStateTracker");
    public final ConnectivityManager g = ((ConnectivityManager) this.f2043b.getSystemService("connectivity"));
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

    public e(Context context, b.z.y.s.s.a aVar) {
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
    @Override // b.z.y.p.f.d
    public b.z.y.p.b a() {
        return f();
    }

    @Override // b.z.y.p.f.d
    public void d() {
        if (g()) {
            try {
                m.c().a(j, "Registering network callback", new Throwable[0]);
                this.g.registerDefaultNetworkCallback(this.h);
            } catch (IllegalArgumentException | SecurityException e2) {
                m.c().b(j, "Received exception while registering network callback", e2);
            }
        } else {
            m.c().a(j, "Registering broadcast receiver", new Throwable[0]);
            this.f2043b.registerReceiver(this.i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // b.z.y.p.f.d
    public void e() {
        if (g()) {
            try {
                m.c().a(j, "Unregistering network callback", new Throwable[0]);
                this.g.unregisterNetworkCallback(this.h);
            } catch (IllegalArgumentException | SecurityException e2) {
                m.c().b(j, "Received exception while unregistering network callback", e2);
            }
        } else {
            m.c().a(j, "Unregistering broadcast receiver", new Throwable[0]);
            this.f2043b.unregisterReceiver(this.i);
        }
    }

    public b.z.y.p.b f() {
        boolean z;
        NetworkInfo activeNetworkInfo = this.g.getActiveNetworkInfo();
        boolean z2 = true;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        try {
            NetworkCapabilities networkCapabilities = this.g.getNetworkCapabilities(this.g.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                z = true;
                boolean isActiveNetworkMetered = this.g.isActiveNetworkMetered();
                if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
                    z2 = false;
                }
                return new b.z.y.p.b(z3, z, isActiveNetworkMetered, z2);
            }
        } catch (SecurityException e2) {
            m.c().b(j, "Unable to validate active network", e2);
        }
        z = false;
        boolean isActiveNetworkMetered2 = this.g.isActiveNetworkMetered();
        z2 = false;
        return new b.z.y.p.b(z3, z, isActiveNetworkMetered2, z2);
    }
}
