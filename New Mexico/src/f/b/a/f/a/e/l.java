package f.b.a.f.a.e;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import f.b.a.f.a.h.a;
import f.b.a.f.a.h.e;
import f.b.a.f.a.h.g;
import f.b.a.f.a.h.n;
import f.b.a.f.a.h.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class l<T extends IInterface> {
    public static final Map<String, Handler> o = new HashMap();
    public final Context a;
    public final a b;
    public final String c;

    /* renamed from: g */
    public boolean f3361g;

    /* renamed from: h */
    public final Intent f3362h;

    /* renamed from: i */
    public final h<T> f3363i;
    public ServiceConnection m;
    public T n;

    /* renamed from: d */
    public final List<b> f3358d = new ArrayList();

    /* renamed from: e */
    public final Set<n<?>> f3359e = new HashSet();

    /* renamed from: f */
    public final Object f3360f = new Object();

    /* renamed from: k */
    public final IBinder.DeathRecipient f3365k = new IBinder.DeathRecipient() { // from class: f.b.a.f.a.e.c
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            l lVar = l.this;
            lVar.b.d("reportBinderDeath", new Object[0]);
            g gVar = lVar.f3364j.get();
            if (gVar != null) {
                lVar.b.d("calling onBinderDied", new Object[0]);
                gVar.a();
            } else {
                lVar.b.d("%s : Binder has died.", lVar.c);
                for (b bVar : lVar.f3358d) {
                    RemoteException remoteException = new RemoteException(String.valueOf(lVar.c).concat(" : Binder has died."));
                    n<?> nVar = bVar.b;
                    if (nVar != null) {
                        nVar.a(remoteException);
                    }
                }
                lVar.f3358d.clear();
            }
            lVar.d();
        }
    };

    /* renamed from: l */
    public final AtomicInteger f3366l = new AtomicInteger(0);

    /* renamed from: j */
    public final WeakReference<g> f3364j = new WeakReference<>(null);

    public l(Context context, a aVar, String str, Intent intent, h<T> hVar, g gVar) {
        this.a = context;
        this.b = aVar;
        this.c = str;
        this.f3362h = intent;
        this.f3363i = hVar;
    }

    public final Handler a() {
        Handler handler;
        Map<String, Handler> map = o;
        synchronized (map) {
            if (!map.containsKey(this.c)) {
                HandlerThread handlerThread = new HandlerThread(this.c, 10);
                handlerThread.start();
                map.put(this.c, new Handler(handlerThread.getLooper()));
            }
            handler = map.get(this.c);
        }
        return handler;
    }

    public final void b(b bVar, n<?> nVar) {
        synchronized (this.f3360f) {
            this.f3359e.add(nVar);
            r<?> rVar = nVar.a;
            d dVar = new a(nVar) { // from class: f.b.a.f.a.e.d
                public final /* synthetic */ n b;

                {
                    this.b = r2;
                }

                @Override // f.b.a.f.a.h.a
                public final void a(r rVar2) {
                    l lVar = l.this;
                    n nVar2 = this.b;
                    synchronized (lVar.f3360f) {
                        lVar.f3359e.remove(nVar2);
                    }
                }
            };
            Objects.requireNonNull(rVar);
            rVar.b.a(new g(e.a, dVar));
            rVar.h();
        }
        synchronized (this.f3360f) {
            if (this.f3366l.getAndIncrement() > 0) {
                this.b.a("Already connected to the service.", new Object[0]);
            }
        }
        a().post(new e(this, bVar.b, bVar));
    }

    public final void c(n<?> nVar) {
        synchronized (this.f3360f) {
            this.f3359e.remove(nVar);
        }
        synchronized (this.f3360f) {
            if (this.f3366l.decrementAndGet() > 0) {
                this.b.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            a().post(new f(this));
        }
    }

    public final void d() {
        synchronized (this.f3360f) {
            for (n<?> nVar : this.f3359e) {
                nVar.a(new RemoteException(String.valueOf(this.c).concat(" : Binder has died.")));
            }
            this.f3359e.clear();
        }
    }
}
