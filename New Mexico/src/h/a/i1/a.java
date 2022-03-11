package h.a.i1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import h.a.f;
import h.a.k0;
import h.a.l0;
import h.a.n;
import h.a.o0;
import h.a.w;
/* loaded from: classes.dex */
public final class a extends w<a> {
    public final l0<?> a;
    public Context b;

    /* loaded from: classes.dex */
    public static final class b extends k0 {
        public final k0 a;
        public final Context b;
        public final ConnectivityManager c;

        /* renamed from: d */
        public final Object f4112d = new Object();

        /* renamed from: e */
        public Runnable f4113e;

        /* renamed from: h.a.i1.a$b$a */
        /* loaded from: classes.dex */
        public class RunnableC0144a implements Runnable {
            public final /* synthetic */ c b;

            public RunnableC0144a(c cVar) {
                b.this = r1;
                this.b = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c.unregisterNetworkCallback(this.b);
            }
        }

        /* renamed from: h.a.i1.a$b$b */
        /* loaded from: classes.dex */
        public class RunnableC0145b implements Runnable {
            public final /* synthetic */ d b;

            public RunnableC0145b(d dVar) {
                b.this = r1;
                this.b = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b.unregisterReceiver(this.b);
            }
        }

        /* loaded from: classes.dex */
        public class c extends ConnectivityManager.NetworkCallback {
            public boolean a = false;

            public c(C0143a aVar) {
                b.this = r1;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                if (this.a) {
                    b.this.a.i();
                } else {
                    b.this.a.l();
                }
                this.a = true;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                this.a = false;
            }
        }

        /* loaded from: classes.dex */
        public class d extends BroadcastReceiver {
            public boolean a = false;

            public d(C0143a aVar) {
                b.this = r1;
            }

            @Override // android.content.BroadcastReceiver
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
                } catch (SecurityException unused) {
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
            synchronized (this.f4112d) {
                Runnable runnable = this.f4113e;
                if (runnable != null) {
                    runnable.run();
                    this.f4113e = null;
                }
            }
            return this.a.m();
        }

        public final void n() {
            Runnable runnable;
            if (Build.VERSION.SDK_INT < 24 || this.c == null) {
                d dVar = new d(null);
                this.b.registerReceiver(dVar, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                runnable = new RunnableC0145b(dVar);
            } else {
                c cVar = new c(null);
                this.c.registerDefaultNetworkCallback(cVar);
                runnable = new RunnableC0144a(cVar);
            }
            this.f4113e = runnable;
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
