package h.a.i1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import h.a.f;
import h.a.k0;
import h.a.l0;
import h.a.n;
import h.a.o0;
import h.a.w;

public final class a extends w<a> {
    public final l0<?> a;
    public Context b;

    public static final class b extends k0 {
        public final k0 a;
        public final Context b;
        public final ConnectivityManager c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f3638d = new Object();

        /* renamed from: e  reason: collision with root package name */
        public Runnable f3639e;

        /* renamed from: h.a.i1.a$b$a  reason: collision with other inner class name */
        public class RunnableC0142a implements Runnable {
            public final /* synthetic */ c b;

            public RunnableC0142a(c cVar) {
                this.b = cVar;
            }

            public void run() {
                b.this.c.unregisterNetworkCallback(this.b);
            }
        }

        /* renamed from: h.a.i1.a$b$b  reason: collision with other inner class name */
        public class RunnableC0143b implements Runnable {
            public final /* synthetic */ d b;

            public RunnableC0143b(d dVar) {
                this.b = dVar;
            }

            public void run() {
                b.this.b.unregisterReceiver(this.b);
            }
        }

        public class c extends ConnectivityManager.NetworkCallback {
            public boolean a = false;

            public c(C0141a aVar) {
            }

            public void onAvailable(Network network) {
                if (this.a) {
                    b.this.a.i();
                } else {
                    b.this.a.l();
                }
                this.a = true;
            }

            public void onLost(Network network) {
                this.a = false;
            }
        }

        public class d extends BroadcastReceiver {
            public boolean a = false;

            public d(C0141a aVar) {
            }

            public void onReceive(Context context, Intent intent) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                boolean z = this.a;
                boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
                this.a = z2;
                if (z2 && !z) {
                    b.this.a.l();
                }
            }
        }

        public b(k0 k0Var, Context context) {
            this.a = k0Var;
            this.b = context;
            if (context != null) {
                this.c = (ConnectivityManager) context.getSystemService("connectivity");
                try {
                    n();
                } catch (SecurityException e2) {
                    Log.w("AndroidChannelBuilder", "Failed to configure network monitoring. Does app have ACCESS_NETWORK_STATE permission?", e2);
                }
            } else {
                this.c = null;
            }
        }

        @Override // h.a.d
        public String b() {
            return this.a.b();
        }

        @Override // h.a.d
        public <RequestT, ResponseT> f<RequestT, ResponseT> h(o0<RequestT, ResponseT> o0Var, h.a.c cVar) {
            return this.a.h(o0Var, cVar);
        }

        @Override // h.a.k0
        public void i() {
            this.a.i();
        }

        @Override // h.a.k0
        public n j(boolean z) {
            return this.a.j(z);
        }

        @Override // h.a.k0
        public void k(n nVar, Runnable runnable) {
            this.a.k(nVar, runnable);
        }

        @Override // h.a.k0
        public void l() {
            this.a.l();
        }

        @Override // h.a.k0
        public k0 m() {
            synchronized (this.f3638d) {
                Runnable runnable = this.f3639e;
                if (runnable != null) {
                    runnable.run();
                    this.f3639e = null;
                }
            }
            return this.a.m();
        }

        public final void n() {
            Runnable runnable;
            if (Build.VERSION.SDK_INT < 24 || this.c == null) {
                d dVar = new d(null);
                this.b.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                runnable = new RunnableC0143b(dVar);
            } else {
                c cVar = new c(null);
                this.c.registerDefaultNetworkCallback(cVar);
                runnable = new RunnableC0142a(cVar);
            }
            this.f3639e = runnable;
        }
    }

    static {
        try {
            Class.forName("h.a.k1.d");
        } catch (ClassNotFoundException unused) {
        }
    }

    public a(l0<?> l0Var) {
        f.b.a.c.b.o.b.A(l0Var, "delegateBuilder");
        this.a = l0Var;
    }

    @Override // h.a.l0
    public k0 a() {
        return new b(this.a.a(), this.b);
    }
}
