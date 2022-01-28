package b.r;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.room.MultiInstanceInvalidationService;
import b.c.a.b.b;
import b.r.c;
import b.r.d;
import b.r.f;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1623a;

    /* renamed from: b  reason: collision with root package name */
    public final String f1624b;

    /* renamed from: c  reason: collision with root package name */
    public int f1625c;

    /* renamed from: d  reason: collision with root package name */
    public final f f1626d;

    /* renamed from: e  reason: collision with root package name */
    public final f.c f1627e;
    public d f;
    public final Executor g;
    public final c h = new a();
    public final AtomicBoolean i = new AtomicBoolean(false);
    public final ServiceConnection j = new b();
    public final Runnable k = new c();
    public final Runnable l = new d();
    public final Runnable m = new e();

    public class a extends c.a {

        /* renamed from: b.r.g$a$a  reason: collision with other inner class name */
        public class RunnableC0038a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String[] f1629b;

            public RunnableC0038a(String[] strArr) {
                this.f1629b = strArr;
            }

            public void run() {
                f fVar = g.this.f1626d;
                String[] strArr = this.f1629b;
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

        @Override // b.r.c
        public void M(String[] strArr) {
            g.this.g.execute(new RunnableC0038a(strArr));
        }
    }

    public class b implements ServiceConnection {
        public b() {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            g.this.f = d.a.c(iBinder);
            g gVar = g.this;
            gVar.g.execute(gVar.k);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            g gVar = g.this;
            gVar.g.execute(gVar.l);
            g.this.f = null;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                d dVar = g.this.f;
                if (dVar != null) {
                    g.this.f1625c = dVar.j(g.this.h, g.this.f1624b);
                    g.this.f1626d.a(g.this.f1627e);
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
            gVar.f1626d.d(gVar.f1627e);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void run() {
            g gVar = g.this;
            gVar.f1626d.d(gVar.f1627e);
            try {
                d dVar = g.this.f;
                if (dVar != null) {
                    dVar.a0(g.this.h, g.this.f1625c);
                }
            } catch (RemoteException unused) {
            }
            g gVar2 = g.this;
            gVar2.f1623a.unbindService(gVar2.j);
        }
    }

    public class f extends f.c {
        public f(String[] strArr) {
            super(strArr);
        }

        @Override // b.r.f.c
        public boolean a() {
            return true;
        }

        @Override // b.r.f.c
        public void b(Set<String> set) {
            if (!g.this.i.get()) {
                try {
                    d dVar = g.this.f;
                    if (dVar != null) {
                        dVar.G(g.this.f1625c, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public g(Context context, String str, f fVar, Executor executor) {
        this.f1623a = context.getApplicationContext();
        this.f1624b = str;
        this.f1626d = fVar;
        this.g = executor;
        this.f1627e = new f((String[]) fVar.f1605a.keySet().toArray(new String[0]));
        this.f1623a.bindService(new Intent(this.f1623a, MultiInstanceInvalidationService.class), this.j, 1);
    }
}
