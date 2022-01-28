package b.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.room.MultiInstanceInvalidationService;
import b.c.a.b.b;
import b.s.c;
import b.s.d;
import b.s.f;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2483a;

    /* renamed from: b  reason: collision with root package name */
    public final String f2484b;

    /* renamed from: c  reason: collision with root package name */
    public int f2485c;

    /* renamed from: d  reason: collision with root package name */
    public final f f2486d;

    /* renamed from: e  reason: collision with root package name */
    public final f.c f2487e;

    /* renamed from: f  reason: collision with root package name */
    public d f2488f;

    /* renamed from: g  reason: collision with root package name */
    public final Executor f2489g;
    public final c h = new a();
    public final AtomicBoolean i = new AtomicBoolean(false);
    public final ServiceConnection j = new b();
    public final Runnable k = new c();
    public final Runnable l = new d();
    public final Runnable m = new e();

    public class a extends c.a {

        /* renamed from: b.s.g$a$a  reason: collision with other inner class name */
        public class RunnableC0048a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String[] f2491b;

            public RunnableC0048a(String[] strArr) {
                this.f2491b = strArr;
            }

            public void run() {
                f fVar = g.this.f2486d;
                String[] strArr = this.f2491b;
                synchronized (fVar.j) {
                    Iterator<Map.Entry<f.c, f.d>> it = fVar.j.iterator();
                    while (true) {
                        b.e eVar = (b.e) it;
                        if (eVar.hasNext()) {
                            Map.Entry entry = (Map.Entry) eVar.next();
                            if (!((f.c) entry.getKey()).a()) {
                                ((f.d) entry.getValue()).a(strArr);
                            }
                        }
                    }
                }
            }
        }

        public a() {
        }

        @Override // b.s.c
        public void J(String[] strArr) {
            g.this.f2489g.execute(new RunnableC0048a(strArr));
        }
    }

    public class b implements ServiceConnection {
        public b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.f2488f = d.a.e0(iBinder);
            g gVar = g.this;
            gVar.f2489g.execute(gVar.k);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            g gVar = g.this;
            gVar.f2489g.execute(gVar.l);
            g.this.f2488f = null;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                d dVar = g.this.f2488f;
                if (dVar != null) {
                    g.this.f2485c = dVar.g(g.this.h, g.this.f2484b);
                    g.this.f2486d.a(g.this.f2487e);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            g gVar = g.this;
            gVar.f2486d.d(gVar.f2487e);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            g gVar = g.this;
            gVar.f2486d.d(gVar.f2487e);
            try {
                d dVar = g.this.f2488f;
                if (dVar != null) {
                    dVar.X(g.this.h, g.this.f2485c);
                }
            } catch (RemoteException unused) {
            }
            g gVar2 = g.this;
            gVar2.f2483a.unbindService(gVar2.j);
        }
    }

    public class f extends f.c {
        public f(String[] strArr) {
            super(strArr);
        }

        @Override // b.s.f.c
        public boolean a() {
            return true;
        }

        @Override // b.s.f.c
        public void b(Set<String> set) {
            if (!g.this.i.get()) {
                try {
                    d dVar = g.this.f2488f;
                    if (dVar != null) {
                        dVar.D(g.this.f2485c, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public g(Context context, String str, f fVar, Executor executor) {
        this.f2483a = context.getApplicationContext();
        this.f2484b = str;
        this.f2486d = fVar;
        this.f2489g = executor;
        this.f2487e = new f((String[]) fVar.f2463a.keySet().toArray(new String[0]));
        this.f2483a.bindService(new Intent(this.f2483a, MultiInstanceInvalidationService.class), this.j, 1);
    }
}
