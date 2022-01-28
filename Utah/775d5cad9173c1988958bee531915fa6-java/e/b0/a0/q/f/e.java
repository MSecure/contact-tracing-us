package e.b0.a0.q.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import e.b0.n;

public class e extends d<e.b0.a0.q.b> {

    /* renamed from: j  reason: collision with root package name */
    public static final String f1094j = n.e("NetworkStateTracker");

    /* renamed from: g  reason: collision with root package name */
    public final ConnectivityManager f1095g = ((ConnectivityManager) this.b.getSystemService("connectivity"));

    /* renamed from: h  reason: collision with root package name */
    public b f1096h;

    /* renamed from: i  reason: collision with root package name */
    public a f1097i;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                n.c().a(e.f1094j, "Network broadcast received", new Throwable[0]);
                e eVar = e.this;
                eVar.c(eVar.f());
            }
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            n.c().a(e.f1094j, String.format("Network capabilities changed: %s", networkCapabilities), new Throwable[0]);
            e eVar = e.this;
            eVar.c(eVar.f());
        }

        public void onLost(Network network) {
            n.c().a(e.f1094j, "Network connection lost", new Throwable[0]);
            e eVar = e.this;
            eVar.c(eVar.f());
        }
    }

    public e(Context context, e.b0.a0.t.t.a aVar) {
        super(context, aVar);
        if (g()) {
            this.f1096h = new b();
        } else {
            this.f1097i = new a();
        }
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.b0.a0.q.f.d
    public e.b0.a0.q.b a() {
        return f();
    }

    @Override // e.b0.a0.q.f.d
    public void d() {
        if (g()) {
            try {
                n.c().a(f1094j, "Registering network callback", new Throwable[0]);
                this.f1095g.registerDefaultNetworkCallback(this.f1096h);
            } catch (IllegalArgumentException | SecurityException e2) {
                n.c().b(f1094j, "Received exception while registering network callback", e2);
            }
        } else {
            n.c().a(f1094j, "Registering broadcast receiver", new Throwable[0]);
            this.b.registerReceiver(this.f1097i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // e.b0.a0.q.f.d
    public void e() {
        if (g()) {
            try {
                n.c().a(f1094j, "Unregistering network callback", new Throwable[0]);
                this.f1095g.unregisterNetworkCallback(this.f1096h);
            } catch (IllegalArgumentException | SecurityException e2) {
                n.c().b(f1094j, "Received exception while unregistering network callback", e2);
            }
        } else {
            n.c().a(f1094j, "Unregistering broadcast receiver", new Throwable[0]);
            this.b.unregisterReceiver(this.f1097i);
        }
    }

    public e.b0.a0.q.b f() {
        boolean z;
        NetworkInfo activeNetworkInfo = this.f1095g.getActiveNetworkInfo();
        boolean z2 = false;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                NetworkCapabilities networkCapabilities = this.f1095g.getNetworkCapabilities(this.f1095g.getActiveNetwork());
                if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                    z = true;
                    boolean isActiveNetworkMetered = this.f1095g.isActiveNetworkMetered();
                    if (activeNetworkInfo != null && !activeNetworkInfo.isRoaming()) {
                        z2 = true;
                    }
                    return new e.b0.a0.q.b(z3, z, isActiveNetworkMetered, z2);
                }
            } catch (SecurityException e2) {
                n.c().b(f1094j, "Unable to validate active network", e2);
            }
        }
        z = false;
        boolean isActiveNetworkMetered2 = this.f1095g.isActiveNetworkMetered();
        z2 = true;
        return new e.b0.a0.q.b(z3, z, isActiveNetworkMetered2, z2);
    }
}
