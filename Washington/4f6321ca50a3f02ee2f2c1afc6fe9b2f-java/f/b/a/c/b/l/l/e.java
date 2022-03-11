package f.b.a.c.b.l.l;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.b.d;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.k;
import f.b.a.c.b.m.b;
import f.b.a.c.b.m.h;
import f.b.a.c.b.m.l;
import f.b.a.c.b.m.t;
import f.b.a.c.h.f;
import f.b.a.c.i.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public class e implements Handler.Callback {
    @RecentlyNonNull

    /* renamed from: l  reason: collision with root package name */
    public static final Status f2414l = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status m = new Status(4, "The user must be signed in to make this API call.");
    public static final Object n = new Object();
    public static e o;
    public long a = 10000;
    public final Context b;
    public final d c;

    /* renamed from: d  reason: collision with root package name */
    public final t f2415d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f2416e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f2417f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<b<?>, a<?>> f2418g;

    /* renamed from: h  reason: collision with root package name */
    public final Set<b<?>> f2419h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<b<?>> f2420i;
    @NotOnlyInitialized

    /* renamed from: j  reason: collision with root package name */
    public final Handler f2421j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f2422k;

    public class a<O extends a.c> implements f.b.a.c.b.l.d, f.b.a.c.b.l.e {
        public final Queue<w> a = new LinkedList();
        @NotOnlyInitialized
        public final a.e b;
        public final b<O> c;

        /* renamed from: d  reason: collision with root package name */
        public final i0 f2423d;

        /* renamed from: e  reason: collision with root package name */
        public final Set<g0> f2424e = new HashSet();

        /* renamed from: f  reason: collision with root package name */
        public final Map<i<?>, v> f2425f = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        public final int f2426g;

        /* renamed from: h  reason: collision with root package name */
        public final x f2427h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2428i;

        /* renamed from: j  reason: collision with root package name */
        public final List<b> f2429j = new ArrayList();

        /* renamed from: k  reason: collision with root package name */
        public f.b.a.c.b.a f2430k = null;

        public a(f.b.a.c.b.l.c<O> cVar) {
            Looper looper = e.this.f2421j.getLooper();
            f.b.a.c.b.m.c a2 = cVar.j().a();
            a.AbstractC0080a<?, O> aVar = cVar.b.a;
            Objects.requireNonNull(aVar, "null reference");
            a.e a3 = aVar.a(cVar.a, looper, a2, cVar.c, this, this);
            this.b = a3;
            this.c = cVar.f2407d;
            this.f2423d = new i0();
            this.f2426g = cVar.f2408e;
            if (a3.l()) {
                this.f2427h = new x(e.this.b, e.this.f2421j, cVar.j().a());
            } else {
                this.f2427h = null;
            }
        }

        @Override // f.b.a.c.b.l.l.d
        public final void C(Bundle bundle) {
            if (Looper.myLooper() == e.this.f2421j.getLooper()) {
                q();
            } else {
                e.this.f2421j.post(new q(this));
            }
        }

        public final f.b.a.c.b.c a(f.b.a.c.b.c[] cVarArr) {
            if (cVarArr == null || cVarArr.length == 0) {
                return null;
            }
            f.b.a.c.b.c[] c2 = this.b.c();
            if (c2 == null) {
                c2 = new f.b.a.c.b.c[0];
            }
            e.e.a aVar = new e.e.a(c2.length);
            for (f.b.a.c.b.c cVar : c2) {
                aVar.put(cVar.b, Long.valueOf(cVar.d()));
            }
            for (f.b.a.c.b.c cVar2 : cVarArr) {
                Long l2 = (Long) aVar.get(cVar2.b);
                if (l2 == null || l2.longValue() < cVar2.d()) {
                    return cVar2;
                }
            }
            return null;
        }

        public final void b() {
            m.h.l(e.this.f2421j);
            Status status = e.f2414l;
            m.h.l(e.this.f2421j);
            e(status, null, false);
            i0 i0Var = this.f2423d;
            Objects.requireNonNull(i0Var);
            i0Var.a(false, status);
            for (i iVar : (i[]) this.f2425f.keySet().toArray(new i[0])) {
                f(new f0(iVar, new i()));
            }
            j(new f.b.a.c.b.a(4));
            if (this.b.d()) {
                this.b.a(new r(this));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0083 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
        public final void c(int i2) {
            Iterator<v> it;
            String str;
            m();
            this.f2428i = true;
            i0 i0Var = this.f2423d;
            String f2 = this.b.f();
            Objects.requireNonNull(i0Var);
            StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
            if (i2 == 1) {
                str = " due to service disconnection.";
            } else {
                if (i2 == 3) {
                    str = " due to dead object exception.";
                }
                if (f2 != null) {
                    sb.append(" Last reason for disconnect: ");
                    sb.append(f2);
                }
                i0Var.a(true, new Status(20, sb.toString()));
                Handler handler = e.this.f2421j;
                Message obtain = Message.obtain(handler, 9, this.c);
                Objects.requireNonNull(e.this);
                handler.sendMessageDelayed(obtain, 5000);
                Handler handler2 = e.this.f2421j;
                Message obtain2 = Message.obtain(handler2, 11, this.c);
                Objects.requireNonNull(e.this);
                handler2.sendMessageDelayed(obtain2, 120000);
                e.this.f2415d.a.clear();
                it = this.f2425f.values().iterator();
                if (!it.hasNext()) {
                    Objects.requireNonNull(it.next());
                    throw null;
                }
                return;
            }
            sb.append(str);
            if (f2 != null) {
            }
            i0Var.a(true, new Status(20, sb.toString()));
            Handler handler3 = e.this.f2421j;
            Message obtain3 = Message.obtain(handler3, 9, this.c);
            Objects.requireNonNull(e.this);
            handler3.sendMessageDelayed(obtain3, 5000);
            Handler handler22 = e.this.f2421j;
            Message obtain22 = Message.obtain(handler22, 11, this.c);
            Objects.requireNonNull(e.this);
            handler22.sendMessageDelayed(obtain22, 120000);
            e.this.f2415d.a.clear();
            it = this.f2425f.values().iterator();
            if (!it.hasNext()) {
            }
        }

        public final void d(f.b.a.c.b.a aVar, Exception exc) {
            f fVar;
            m.h.l(e.this.f2421j);
            x xVar = this.f2427h;
            if (!(xVar == null || (fVar = xVar.f2439f) == null)) {
                fVar.j();
            }
            m();
            e.this.f2415d.a.clear();
            j(aVar);
            if (aVar.c == 4) {
                Status status = e.f2414l;
                Status status2 = e.m;
                m.h.l(e.this.f2421j);
                e(status2, null, false);
            } else if (this.a.isEmpty()) {
                this.f2430k = aVar;
            } else if (exc != null) {
                m.h.l(e.this.f2421j);
                e(null, exc, false);
            } else if (!e.this.f2422k) {
                Status c2 = e.c(this.c, aVar);
                m.h.l(e.this.f2421j);
                e(c2, null, false);
            } else {
                e(e.c(this.c, aVar), null, true);
                if (!this.a.isEmpty()) {
                    h(aVar);
                    if (!e.this.b(aVar, this.f2426g)) {
                        if (aVar.c == 18) {
                            this.f2428i = true;
                        }
                        if (this.f2428i) {
                            Handler handler = e.this.f2421j;
                            Message obtain = Message.obtain(handler, 9, this.c);
                            Objects.requireNonNull(e.this);
                            handler.sendMessageDelayed(obtain, 5000);
                            return;
                        }
                        Status c3 = e.c(this.c, aVar);
                        m.h.l(e.this.f2421j);
                        e(c3, null, false);
                    }
                }
            }
        }

        public final void e(Status status, Exception exc, boolean z) {
            m.h.l(e.this.f2421j);
            boolean z2 = true;
            boolean z3 = status == null;
            if (exc != null) {
                z2 = false;
            }
            if (z3 != z2) {
                Iterator<w> it = this.a.iterator();
                while (it.hasNext()) {
                    w next = it.next();
                    if (!z || next.a == 2) {
                        if (status != null) {
                            next.b(status);
                        } else {
                            next.d(exc);
                        }
                        it.remove();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Status XOR exception should be null");
        }

        public final void f(w wVar) {
            m.h.l(e.this.f2421j);
            if (!this.b.d()) {
                this.a.add(wVar);
                f.b.a.c.b.a aVar = this.f2430k;
                if (aVar != null) {
                    if ((aVar.c == 0 || aVar.f2403d == null) ? false : true) {
                        d(aVar, null);
                        return;
                    }
                }
                o();
            } else if (i(wVar)) {
                t();
            } else {
                this.a.add(wVar);
            }
        }

        public final boolean g(boolean z) {
            m.h.l(e.this.f2421j);
            if (!this.b.d() || this.f2425f.size() != 0) {
                return false;
            }
            i0 i0Var = this.f2423d;
            if (!i0Var.a.isEmpty() || !i0Var.b.isEmpty()) {
                if (z) {
                    t();
                }
                return false;
            }
            this.b.k("Timing out service connection.");
            return true;
        }

        public final boolean h(f.b.a.c.b.a aVar) {
            Status status = e.f2414l;
            synchronized (e.n) {
                Objects.requireNonNull(e.this);
            }
            return false;
        }

        public final boolean i(w wVar) {
            if (!(wVar instanceof n)) {
                k(wVar);
                return true;
            }
            n nVar = (n) wVar;
            f.b.a.c.b.c a2 = a(nVar.f(this));
            if (a2 == null) {
                k(wVar);
                return true;
            }
            String name = this.b.getClass().getName();
            String str = a2.b;
            long d2 = a2.d();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + name.length() + 77);
            sb.append(name);
            sb.append(" could not execute call because it requires feature (");
            sb.append(str);
            sb.append(", ");
            sb.append(d2);
            sb.append(").");
            Log.w("GoogleApiManager", sb.toString());
            if (!e.this.f2422k || !nVar.g(this)) {
                nVar.d(new k(a2));
                return true;
            }
            PendingIntent pendingIntent = null;
            b bVar = new b(this.c, a2, null);
            int indexOf = this.f2429j.indexOf(bVar);
            if (indexOf >= 0) {
                b bVar2 = this.f2429j.get(indexOf);
                e.this.f2421j.removeMessages(15, bVar2);
                Handler handler = e.this.f2421j;
                Message obtain = Message.obtain(handler, 15, bVar2);
                Objects.requireNonNull(e.this);
                handler.sendMessageDelayed(obtain, 5000);
            } else {
                this.f2429j.add(bVar);
                Handler handler2 = e.this.f2421j;
                Message obtain2 = Message.obtain(handler2, 15, bVar);
                Objects.requireNonNull(e.this);
                handler2.sendMessageDelayed(obtain2, 5000);
                Handler handler3 = e.this.f2421j;
                Message obtain3 = Message.obtain(handler3, 16, bVar);
                Objects.requireNonNull(e.this);
                handler3.sendMessageDelayed(obtain3, 120000);
                Status status = e.f2414l;
                synchronized (e.n) {
                    Objects.requireNonNull(e.this);
                }
                e eVar = e.this;
                int i2 = this.f2426g;
                d dVar = eVar.c;
                Context context = eVar.b;
                Objects.requireNonNull(dVar);
                Intent a3 = dVar.a(context, 2, null);
                if (a3 != null) {
                    pendingIntent = PendingIntent.getActivity(context, 0, a3, 134217728);
                }
                if (pendingIntent != null) {
                    int i3 = GoogleApiActivity.c;
                    Intent intent = new Intent(context, GoogleApiActivity.class);
                    intent.putExtra("pending_intent", pendingIntent);
                    intent.putExtra("failing_client_id", i2);
                    intent.putExtra("notify_manager", true);
                    dVar.d(context, 2, PendingIntent.getActivity(context, 0, intent, 134217728));
                }
            }
            return false;
        }

        public final void j(f.b.a.c.b.a aVar) {
            Iterator<g0> it = this.f2424e.iterator();
            if (it.hasNext()) {
                g0 next = it.next();
                if (m.h.U(aVar, f.b.a.c.b.a.f2402f)) {
                    this.b.e();
                }
                Objects.requireNonNull(next);
                throw null;
            }
            this.f2424e.clear();
        }

        public final void k(w wVar) {
            wVar.c(this.f2423d, p());
            try {
                wVar.e(this);
            } catch (DeadObjectException unused) {
                n(1);
                this.b.k("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.b.getClass().getName()), th);
            }
        }

        @Override // f.b.a.c.b.l.l.j
        public final void l(f.b.a.c.b.a aVar) {
            d(aVar, null);
        }

        public final void m() {
            m.h.l(e.this.f2421j);
            this.f2430k = null;
        }

        @Override // f.b.a.c.b.l.l.d
        public final void n(int i2) {
            if (Looper.myLooper() == e.this.f2421j.getLooper()) {
                c(i2);
            } else {
                e.this.f2421j.post(new p(this, i2));
            }
        }

        public final void o() {
            f.b.a.c.b.a aVar;
            m.h.l(e.this.f2421j);
            if (!this.b.d() && !this.b.b()) {
                try {
                    e eVar = e.this;
                    int a2 = eVar.f2415d.a(eVar.b, this.b);
                    if (a2 != 0) {
                        f.b.a.c.b.a aVar2 = new f.b.a.c.b.a(a2, null);
                        String name = this.b.getClass().getName();
                        String valueOf = String.valueOf(aVar2);
                        StringBuilder sb = new StringBuilder(name.length() + 35 + valueOf.length());
                        sb.append("The service for ");
                        sb.append(name);
                        sb.append(" is not available: ");
                        sb.append(valueOf);
                        Log.w("GoogleApiManager", sb.toString());
                        d(aVar2, null);
                        return;
                    }
                    e eVar2 = e.this;
                    a.e eVar3 = this.b;
                    c cVar = new c(eVar3, this.c);
                    if (eVar3.l()) {
                        x xVar = this.f2427h;
                        Objects.requireNonNull(xVar, "null reference");
                        f fVar = xVar.f2439f;
                        if (fVar != null) {
                            fVar.j();
                        }
                        xVar.f2438e.f2460h = Integer.valueOf(System.identityHashCode(xVar));
                        a.AbstractC0080a<? extends f, f.b.a.c.h.a> aVar3 = xVar.c;
                        Context context = xVar.a;
                        Looper looper = xVar.b.getLooper();
                        f.b.a.c.b.m.c cVar2 = xVar.f2438e;
                        xVar.f2439f = (f) aVar3.a(context, looper, cVar2, cVar2.f2459g, xVar, xVar);
                        xVar.f2440g = cVar;
                        Set<Scope> set = xVar.f2437d;
                        if (set == null || set.isEmpty()) {
                            xVar.b.post(new z(xVar));
                        } else {
                            xVar.f2439f.n();
                        }
                    }
                    try {
                        this.b.i(cVar);
                    } catch (SecurityException e2) {
                        e = e2;
                        aVar = new f.b.a.c.b.a(10);
                        d(aVar, e);
                    }
                } catch (IllegalStateException e3) {
                    e = e3;
                    aVar = new f.b.a.c.b.a(10);
                    d(aVar, e);
                }
            }
        }

        public final boolean p() {
            return this.b.l();
        }

        public final void q() {
            m();
            j(f.b.a.c.b.a.f2402f);
            s();
            Iterator<v> it = this.f2425f.values().iterator();
            if (!it.hasNext()) {
                r();
                t();
                return;
            }
            Objects.requireNonNull(it.next());
            throw null;
        }

        public final void r() {
            ArrayList arrayList = new ArrayList(this.a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                w wVar = (w) obj;
                if (!this.b.d()) {
                    return;
                }
                if (i(wVar)) {
                    this.a.remove(wVar);
                }
            }
        }

        public final void s() {
            if (this.f2428i) {
                e.this.f2421j.removeMessages(11, this.c);
                e.this.f2421j.removeMessages(9, this.c);
                this.f2428i = false;
            }
        }

        public final void t() {
            e.this.f2421j.removeMessages(12, this.c);
            Handler handler = e.this.f2421j;
            handler.sendMessageDelayed(handler.obtainMessage(12, this.c), e.this.a);
        }
    }

    public static class b {
        public final b<?> a;
        public final f.b.a.c.b.c b;

        public b(b bVar, f.b.a.c.b.c cVar, o oVar) {
            this.a = bVar;
            this.b = cVar;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                return m.h.U(this.a, bVar.a) && m.h.U(this.b, bVar.b);
            }
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b});
        }

        public final String toString() {
            l lVar = new l(this, null);
            lVar.a("key", this.a);
            lVar.a("feature", this.b);
            return lVar.toString();
        }
    }

    public class c implements a0, b.c {
        public final a.e a;
        public final b<?> b;
        public h c = null;

        /* renamed from: d  reason: collision with root package name */
        public Set<Scope> f2432d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2433e = false;

        public c(a.e eVar, b<?> bVar) {
            this.a = eVar;
            this.b = bVar;
        }

        @Override // f.b.a.c.b.m.b.c
        public final void a(f.b.a.c.b.a aVar) {
            e.this.f2421j.post(new t(this, aVar));
        }

        public final void b(f.b.a.c.b.a aVar) {
            a<?> aVar2 = e.this.f2418g.get(this.b);
            if (aVar2 != null) {
                m.h.l(e.this.f2421j);
                a.e eVar = aVar2.b;
                String name = eVar.getClass().getName();
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + name.length() + 25);
                sb.append("onSignInFailed for ");
                sb.append(name);
                sb.append(" with ");
                sb.append(valueOf);
                eVar.k(sb.toString());
                aVar2.d(aVar, null);
            }
        }
    }

    public e(Context context, Looper looper, d dVar) {
        boolean z = true;
        this.f2416e = new AtomicInteger(1);
        this.f2417f = new AtomicInteger(0);
        this.f2418g = new ConcurrentHashMap(5, 0.75f, 1);
        this.f2419h = new e.e.c(0);
        this.f2420i = new e.e.c(0);
        this.f2422k = true;
        this.b = context;
        f.b.a.c.e.a.d dVar2 = new f.b.a.c.e.a.d(looper, this);
        this.f2421j = dVar2;
        this.c = dVar;
        this.f2415d = new t(dVar);
        PackageManager packageManager = context.getPackageManager();
        if (f.b.a.c.b.o.b.f2495d == null) {
            f.b.a.c.b.o.b.f2495d = Boolean.valueOf((!f.b.a.c.b.o.b.d1() || !packageManager.hasSystemFeature("android.hardware.type.automotive")) ? false : z);
        }
        if (f.b.a.c.b.o.b.f2495d.booleanValue()) {
            this.f2422k = false;
        }
        dVar2.sendMessage(dVar2.obtainMessage(6));
    }

    @RecentlyNonNull
    public static e a(@RecentlyNonNull Context context) {
        e eVar;
        synchronized (n) {
            if (o == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = d.c;
                o = new e(applicationContext, looper, d.f2406d);
            }
            eVar = o;
        }
        return eVar;
    }

    public static Status c(b<?> bVar, f.b.a.c.b.a aVar) {
        String str = bVar.b.b;
        String valueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(str).length() + 63);
        sb.append("API: ");
        sb.append(str);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(1, 17, sb.toString(), aVar.f2403d, aVar);
    }

    public final boolean b(f.b.a.c.b.a aVar, int i2) {
        PendingIntent pendingIntent;
        d dVar = this.c;
        Context context = this.b;
        Objects.requireNonNull(dVar);
        int i3 = aVar.c;
        if ((i3 == 0 || aVar.f2403d == null) ? false : true) {
            pendingIntent = aVar.f2403d;
        } else {
            Intent a2 = dVar.a(context, i3, null);
            pendingIntent = a2 == null ? null : PendingIntent.getActivity(context, 0, a2, 134217728);
        }
        if (pendingIntent == null) {
            return false;
        }
        int i4 = aVar.c;
        int i5 = GoogleApiActivity.c;
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i2);
        intent.putExtra("notify_manager", true);
        dVar.d(context, i4, PendingIntent.getActivity(context, 0, intent, 134217728));
        return true;
    }

    public final a<?> d(f.b.a.c.b.l.c<?> cVar) {
        b<O> bVar = cVar.f2407d;
        a<?> aVar = this.f2418g.get(bVar);
        if (aVar == null) {
            aVar = new a<>(cVar);
            this.f2418g.put(bVar, aVar);
        }
        if (aVar.p()) {
            this.f2420i.add(bVar);
        }
        aVar.o();
        return aVar;
    }

    @RecentlyNonNull
    public boolean handleMessage(@RecentlyNonNull Message message) {
        a<?> aVar;
        f.b.a.c.b.c[] f2;
        int i2 = message.what;
        int i3 = 0;
        long j2 = 300000;
        switch (i2) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.a = j2;
                this.f2421j.removeMessages(12);
                for (b<?> bVar : this.f2418g.keySet()) {
                    Handler handler = this.f2421j;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.a);
                }
                break;
            case 2:
                Objects.requireNonNull((g0) message.obj);
                throw null;
            case 3:
                for (a<?> aVar2 : this.f2418g.values()) {
                    aVar2.m();
                    aVar2.o();
                }
                break;
            case 4:
            case 8:
            case 13:
                u uVar = (u) message.obj;
                a<?> aVar3 = this.f2418g.get(uVar.c.f2407d);
                if (aVar3 == null) {
                    aVar3 = d(uVar.c);
                }
                if (!aVar3.p() || this.f2417f.get() == uVar.b) {
                    aVar3.f(uVar.a);
                    break;
                } else {
                    uVar.a.b(f2414l);
                    aVar3.b();
                    break;
                }
                break;
            case 5:
                int i4 = message.arg1;
                f.b.a.c.b.a aVar4 = (f.b.a.c.b.a) message.obj;
                Iterator<a<?>> it = this.f2418g.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.f2426g == i4) {
                        }
                    } else {
                        aVar = null;
                    }
                }
                if (aVar != null) {
                    int i5 = aVar4.c;
                    if (i5 == 13) {
                        Objects.requireNonNull(this.c);
                        AtomicBoolean atomicBoolean = f.b.a.c.b.i.a;
                        String g2 = f.b.a.c.b.a.g(i5);
                        String str = aVar4.f2404e;
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + String.valueOf(g2).length() + 69);
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(g2);
                        sb.append(": ");
                        sb.append(str);
                        Status status = new Status(17, sb.toString());
                        m.h.l(e.this.f2421j);
                        aVar.e(status, null, false);
                        break;
                    } else {
                        Status c2 = c(aVar.c, aVar4);
                        m.h.l(e.this.f2421j);
                        aVar.e(c2, null, false);
                        break;
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i4);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (this.b.getApplicationContext() instanceof Application) {
                    c.a((Application) this.b.getApplicationContext());
                    c cVar = c.f2411f;
                    o oVar = new o(this);
                    Objects.requireNonNull(cVar);
                    synchronized (cVar) {
                        cVar.f2412d.add(oVar);
                    }
                    if (!cVar.c.get()) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!cVar.c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            cVar.b.set(true);
                        }
                    }
                    if (!cVar.b.get()) {
                        this.a = 300000;
                        break;
                    }
                }
                break;
            case 7:
                d((f.b.a.c.b.l.c) message.obj);
                break;
            case 9:
                if (this.f2418g.containsKey(message.obj)) {
                    a<?> aVar5 = this.f2418g.get(message.obj);
                    m.h.l(e.this.f2421j);
                    if (aVar5.f2428i) {
                        aVar5.o();
                        break;
                    }
                }
                break;
            case 10:
                for (b<?> bVar2 : this.f2420i) {
                    a<?> remove = this.f2418g.remove(bVar2);
                    if (remove != null) {
                        remove.b();
                    }
                }
                this.f2420i.clear();
                break;
            case 11:
                if (this.f2418g.containsKey(message.obj)) {
                    a<?> aVar6 = this.f2418g.get(message.obj);
                    m.h.l(e.this.f2421j);
                    if (aVar6.f2428i) {
                        aVar6.s();
                        e eVar = e.this;
                        Status status2 = eVar.c.b(eVar.b, f.b.a.c.b.e.a) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error.");
                        m.h.l(e.this.f2421j);
                        aVar6.e(status2, null, false);
                        aVar6.b.k("Timing out connection while resuming.");
                        break;
                    }
                }
                break;
            case 12:
                if (this.f2418g.containsKey(message.obj)) {
                    this.f2418g.get(message.obj).g(true);
                    break;
                }
                break;
            case 14:
                Objects.requireNonNull((m) message.obj);
                if (!this.f2418g.containsKey(null)) {
                    throw null;
                }
                this.f2418g.get(null).g(false);
                throw null;
            case 15:
                b bVar3 = (b) message.obj;
                if (this.f2418g.containsKey(bVar3.a)) {
                    a<?> aVar7 = this.f2418g.get(bVar3.a);
                    if (aVar7.f2429j.contains(bVar3) && !aVar7.f2428i) {
                        if (!aVar7.b.d()) {
                            aVar7.o();
                            break;
                        } else {
                            aVar7.r();
                            break;
                        }
                    }
                }
                break;
            case 16:
                b bVar4 = (b) message.obj;
                if (this.f2418g.containsKey(bVar4.a)) {
                    a<?> aVar8 = this.f2418g.get(bVar4.a);
                    if (aVar8.f2429j.remove(bVar4)) {
                        e.this.f2421j.removeMessages(15, bVar4);
                        e.this.f2421j.removeMessages(16, bVar4);
                        f.b.a.c.b.c cVar2 = bVar4.b;
                        ArrayList arrayList = new ArrayList(aVar8.a.size());
                        for (w wVar : aVar8.a) {
                            if ((wVar instanceof n) && (f2 = ((n) wVar).f(aVar8)) != null) {
                                int length = f2.length;
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= length) {
                                        i6 = -1;
                                    } else if (!m.h.U(f2[i6], cVar2)) {
                                        i6++;
                                    }
                                }
                                if (i6 >= 0) {
                                    arrayList.add(wVar);
                                }
                            }
                        }
                        int size = arrayList.size();
                        while (i3 < size) {
                            Object obj = arrayList.get(i3);
                            i3++;
                            w wVar2 = (w) obj;
                            aVar8.a.remove(wVar2);
                            wVar2.d(new k(cVar2));
                        }
                        break;
                    }
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }
}
