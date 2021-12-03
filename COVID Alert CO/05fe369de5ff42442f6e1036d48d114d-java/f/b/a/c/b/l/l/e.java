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
    public static final Status f2583l = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status m = new Status(4, "The user must be signed in to make this API call.");
    public static final Object n = new Object();
    public static e o;
    public long a = 10000;
    public final Context b;
    public final d c;

    /* renamed from: d  reason: collision with root package name */
    public final t f2584d;

    /* renamed from: e  reason: collision with root package name */
    public final AtomicInteger f2585e;

    /* renamed from: f  reason: collision with root package name */
    public final AtomicInteger f2586f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<b<?>, a<?>> f2587g;

    /* renamed from: h  reason: collision with root package name */
    public final Set<b<?>> f2588h;

    /* renamed from: i  reason: collision with root package name */
    public final Set<b<?>> f2589i;
    @NotOnlyInitialized

    /* renamed from: j  reason: collision with root package name */
    public final Handler f2590j;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f2591k;

    public class a<O extends a.c> implements f.b.a.c.b.l.d, f.b.a.c.b.l.e {
        public final Queue<w> a = new LinkedList();
        @NotOnlyInitialized
        public final a.e b;
        public final b<O> c;

        /* renamed from: d  reason: collision with root package name */
        public final i0 f2592d;

        /* renamed from: e  reason: collision with root package name */
        public final Set<g0> f2593e = new HashSet();

        /* renamed from: f  reason: collision with root package name */
        public final Map<i<?>, v> f2594f = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        public final int f2595g;

        /* renamed from: h  reason: collision with root package name */
        public final x f2596h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f2597i;

        /* renamed from: j  reason: collision with root package name */
        public final List<b> f2598j = new ArrayList();

        /* renamed from: k  reason: collision with root package name */
        public f.b.a.c.b.a f2599k = null;

        public a(f.b.a.c.b.l.c<O> cVar) {
            Looper looper = e.this.f2590j.getLooper();
            f.b.a.c.b.m.c a2 = cVar.k().a();
            a.AbstractC0082a<?, O> aVar = cVar.b.a;
            Objects.requireNonNull(aVar, "null reference");
            a.e a3 = aVar.a(cVar.a, looper, a2, cVar.c, this, this);
            this.b = a3;
            this.c = cVar.f2576d;
            this.f2592d = new i0();
            this.f2595g = cVar.f2577e;
            if (a3.l()) {
                this.f2596h = new x(e.this.b, e.this.f2590j, cVar.k().a());
            } else {
                this.f2596h = null;
            }
        }

        @Override // f.b.a.c.b.l.l.d
        public final void E(Bundle bundle) {
            if (Looper.myLooper() == e.this.f2590j.getLooper()) {
                p();
            } else {
                e.this.f2590j.post(new q(this));
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
            m.h.l(e.this.f2590j);
            Status status = e.f2583l;
            m.h.l(e.this.f2590j);
            e(status, null, false);
            i0 i0Var = this.f2592d;
            Objects.requireNonNull(i0Var);
            i0Var.a(false, status);
            for (i iVar : (i[]) this.f2594f.keySet().toArray(new i[0])) {
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
            this.f2597i = true;
            i0 i0Var = this.f2592d;
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
                Handler handler = e.this.f2590j;
                Message obtain = Message.obtain(handler, 9, this.c);
                Objects.requireNonNull(e.this);
                handler.sendMessageDelayed(obtain, 5000);
                Handler handler2 = e.this.f2590j;
                Message obtain2 = Message.obtain(handler2, 11, this.c);
                Objects.requireNonNull(e.this);
                handler2.sendMessageDelayed(obtain2, 120000);
                e.this.f2584d.a.clear();
                it = this.f2594f.values().iterator();
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
            Handler handler3 = e.this.f2590j;
            Message obtain3 = Message.obtain(handler3, 9, this.c);
            Objects.requireNonNull(e.this);
            handler3.sendMessageDelayed(obtain3, 5000);
            Handler handler22 = e.this.f2590j;
            Message obtain22 = Message.obtain(handler22, 11, this.c);
            Objects.requireNonNull(e.this);
            handler22.sendMessageDelayed(obtain22, 120000);
            e.this.f2584d.a.clear();
            it = this.f2594f.values().iterator();
            if (!it.hasNext()) {
            }
        }

        public final void d(f.b.a.c.b.a aVar, Exception exc) {
            f fVar;
            m.h.l(e.this.f2590j);
            x xVar = this.f2596h;
            if (!(xVar == null || (fVar = xVar.f2608f) == null)) {
                fVar.j();
            }
            m();
            e.this.f2584d.a.clear();
            j(aVar);
            if (aVar.c == 4) {
                Status status = e.f2583l;
                Status status2 = e.m;
                m.h.l(e.this.f2590j);
                e(status2, null, false);
            } else if (this.a.isEmpty()) {
                this.f2599k = aVar;
            } else if (exc != null) {
                m.h.l(e.this.f2590j);
                e(null, exc, false);
            } else if (!e.this.f2591k) {
                Status c2 = e.c(this.c, aVar);
                m.h.l(e.this.f2590j);
                e(c2, null, false);
            } else {
                e(e.c(this.c, aVar), null, true);
                if (!this.a.isEmpty()) {
                    h(aVar);
                    if (!e.this.b(aVar, this.f2595g)) {
                        if (aVar.c == 18) {
                            this.f2597i = true;
                        }
                        if (this.f2597i) {
                            Handler handler = e.this.f2590j;
                            Message obtain = Message.obtain(handler, 9, this.c);
                            Objects.requireNonNull(e.this);
                            handler.sendMessageDelayed(obtain, 5000);
                            return;
                        }
                        Status c3 = e.c(this.c, aVar);
                        m.h.l(e.this.f2590j);
                        e(c3, null, false);
                    }
                }
            }
        }

        public final void e(Status status, Exception exc, boolean z) {
            m.h.l(e.this.f2590j);
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
            m.h.l(e.this.f2590j);
            if (!this.b.d()) {
                this.a.add(wVar);
                f.b.a.c.b.a aVar = this.f2599k;
                if (aVar != null) {
                    if ((aVar.c == 0 || aVar.f2572d == null) ? false : true) {
                        d(aVar, null);
                        return;
                    }
                }
                n();
            } else if (i(wVar)) {
                t();
            } else {
                this.a.add(wVar);
            }
        }

        public final boolean g(boolean z) {
            m.h.l(e.this.f2590j);
            if (!this.b.d() || this.f2594f.size() != 0) {
                return false;
            }
            i0 i0Var = this.f2592d;
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
            Status status = e.f2583l;
            synchronized (e.n) {
                Objects.requireNonNull(e.this);
            }
            return false;
        }

        public final boolean i(w wVar) {
            if (!(wVar instanceof n)) {
                l(wVar);
                return true;
            }
            n nVar = (n) wVar;
            f.b.a.c.b.c a2 = a(nVar.f(this));
            if (a2 == null) {
                l(wVar);
                return true;
            }
            String name = this.b.getClass().getName();
            String str = a2.b;
            name.length();
            String.valueOf(str).length();
            if (!e.this.f2591k || !nVar.g(this)) {
                nVar.d(new k(a2));
                return true;
            }
            PendingIntent pendingIntent = null;
            b bVar = new b(this.c, a2, null);
            int indexOf = this.f2598j.indexOf(bVar);
            if (indexOf >= 0) {
                b bVar2 = this.f2598j.get(indexOf);
                e.this.f2590j.removeMessages(15, bVar2);
                Handler handler = e.this.f2590j;
                Message obtain = Message.obtain(handler, 15, bVar2);
                Objects.requireNonNull(e.this);
                handler.sendMessageDelayed(obtain, 5000);
            } else {
                this.f2598j.add(bVar);
                Handler handler2 = e.this.f2590j;
                Message obtain2 = Message.obtain(handler2, 15, bVar);
                Objects.requireNonNull(e.this);
                handler2.sendMessageDelayed(obtain2, 5000);
                Handler handler3 = e.this.f2590j;
                Message obtain3 = Message.obtain(handler3, 16, bVar);
                Objects.requireNonNull(e.this);
                handler3.sendMessageDelayed(obtain3, 120000);
                Status status = e.f2583l;
                synchronized (e.n) {
                    Objects.requireNonNull(e.this);
                }
                e eVar = e.this;
                int i2 = this.f2595g;
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
            Iterator<g0> it = this.f2593e.iterator();
            if (it.hasNext()) {
                g0 next = it.next();
                if (m.h.U(aVar, f.b.a.c.b.a.f2571f)) {
                    this.b.e();
                }
                Objects.requireNonNull(next);
                throw null;
            }
            this.f2593e.clear();
        }

        @Override // f.b.a.c.b.l.l.j
        public final void k(f.b.a.c.b.a aVar) {
            d(aVar, null);
        }

        public final void l(w wVar) {
            wVar.c(this.f2592d, o());
            try {
                wVar.e(this);
            } catch (DeadObjectException unused) {
                q(1);
                this.b.k("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.b.getClass().getName()), th);
            }
        }

        public final void m() {
            m.h.l(e.this.f2590j);
            this.f2599k = null;
        }

        public final void n() {
            f.b.a.c.b.a aVar;
            m.h.l(e.this.f2590j);
            if (!this.b.d() && !this.b.b()) {
                try {
                    e eVar = e.this;
                    int a2 = eVar.f2584d.a(eVar.b, this.b);
                    if (a2 != 0) {
                        f.b.a.c.b.a aVar2 = new f.b.a.c.b.a(a2, null);
                        String name = this.b.getClass().getName();
                        String valueOf = String.valueOf(aVar2);
                        name.length();
                        valueOf.length();
                        d(aVar2, null);
                        return;
                    }
                    e eVar2 = e.this;
                    a.e eVar3 = this.b;
                    c cVar = new c(eVar3, this.c);
                    if (eVar3.l()) {
                        x xVar = this.f2596h;
                        Objects.requireNonNull(xVar, "null reference");
                        f fVar = xVar.f2608f;
                        if (fVar != null) {
                            fVar.j();
                        }
                        xVar.f2607e.f2629h = Integer.valueOf(System.identityHashCode(xVar));
                        a.AbstractC0082a<? extends f, f.b.a.c.h.a> aVar3 = xVar.c;
                        Context context = xVar.a;
                        Looper looper = xVar.b.getLooper();
                        f.b.a.c.b.m.c cVar2 = xVar.f2607e;
                        xVar.f2608f = (f) aVar3.a(context, looper, cVar2, cVar2.f2628g, xVar, xVar);
                        xVar.f2609g = cVar;
                        Set<Scope> set = xVar.f2606d;
                        if (set == null || set.isEmpty()) {
                            xVar.b.post(new z(xVar));
                        } else {
                            xVar.f2608f.n();
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

        public final boolean o() {
            return this.b.l();
        }

        public final void p() {
            m();
            j(f.b.a.c.b.a.f2571f);
            s();
            Iterator<v> it = this.f2594f.values().iterator();
            if (!it.hasNext()) {
                r();
                t();
                return;
            }
            Objects.requireNonNull(it.next());
            throw null;
        }

        @Override // f.b.a.c.b.l.l.d
        public final void q(int i2) {
            if (Looper.myLooper() == e.this.f2590j.getLooper()) {
                c(i2);
            } else {
                e.this.f2590j.post(new p(this, i2));
            }
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
            if (this.f2597i) {
                e.this.f2590j.removeMessages(11, this.c);
                e.this.f2590j.removeMessages(9, this.c);
                this.f2597i = false;
            }
        }

        public final void t() {
            e.this.f2590j.removeMessages(12, this.c);
            Handler handler = e.this.f2590j;
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
        public Set<Scope> f2601d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2602e = false;

        public c(a.e eVar, b<?> bVar) {
            this.a = eVar;
            this.b = bVar;
        }

        @Override // f.b.a.c.b.m.b.c
        public final void a(f.b.a.c.b.a aVar) {
            e.this.f2590j.post(new t(this, aVar));
        }

        public final void b(f.b.a.c.b.a aVar) {
            a<?> aVar2 = e.this.f2587g.get(this.b);
            if (aVar2 != null) {
                m.h.l(e.this.f2590j);
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
        this.f2585e = new AtomicInteger(1);
        this.f2586f = new AtomicInteger(0);
        this.f2587g = new ConcurrentHashMap(5, 0.75f, 1);
        this.f2588h = new e.e.c(0);
        this.f2589i = new e.e.c(0);
        this.f2591k = true;
        this.b = context;
        f.b.a.c.e.a.d dVar2 = new f.b.a.c.e.a.d(looper, this);
        this.f2590j = dVar2;
        this.c = dVar;
        this.f2584d = new t(dVar);
        PackageManager packageManager = context.getPackageManager();
        if (f.b.a.c.b.o.b.f2664d == null) {
            f.b.a.c.b.o.b.f2664d = Boolean.valueOf((!f.b.a.c.b.o.b.P0() || !packageManager.hasSystemFeature("android.hardware.type.automotive")) ? false : z);
        }
        if (f.b.a.c.b.o.b.f2664d.booleanValue()) {
            this.f2591k = false;
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
                o = new e(applicationContext, looper, d.f2575d);
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
        return new Status(1, 17, sb.toString(), aVar.f2572d, aVar);
    }

    public final boolean b(f.b.a.c.b.a aVar, int i2) {
        PendingIntent pendingIntent;
        d dVar = this.c;
        Context context = this.b;
        Objects.requireNonNull(dVar);
        int i3 = aVar.c;
        if ((i3 == 0 || aVar.f2572d == null) ? false : true) {
            pendingIntent = aVar.f2572d;
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
        b<O> bVar = cVar.f2576d;
        a<?> aVar = this.f2587g.get(bVar);
        if (aVar == null) {
            aVar = new a<>(cVar);
            this.f2587g.put(bVar, aVar);
        }
        if (aVar.o()) {
            this.f2589i.add(bVar);
        }
        aVar.n();
        return aVar;
    }

    @RecentlyNonNull
    public boolean handleMessage(@RecentlyNonNull Message message) {
        a<?> aVar;
        f.b.a.c.b.c[] f2;
        int i2 = 0;
        long j2 = 300000;
        switch (message.what) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.a = j2;
                this.f2590j.removeMessages(12);
                for (b<?> bVar : this.f2587g.keySet()) {
                    Handler handler = this.f2590j;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.a);
                }
                break;
            case 2:
                Objects.requireNonNull((g0) message.obj);
                throw null;
            case 3:
                for (a<?> aVar2 : this.f2587g.values()) {
                    aVar2.m();
                    aVar2.n();
                }
                break;
            case 4:
            case 8:
            case 13:
                u uVar = (u) message.obj;
                a<?> aVar3 = this.f2587g.get(uVar.c.f2576d);
                if (aVar3 == null) {
                    aVar3 = d(uVar.c);
                }
                if (!aVar3.o() || this.f2586f.get() == uVar.b) {
                    aVar3.f(uVar.a);
                    break;
                } else {
                    uVar.a.b(f2583l);
                    aVar3.b();
                    break;
                }
            case 5:
                int i3 = message.arg1;
                f.b.a.c.b.a aVar4 = (f.b.a.c.b.a) message.obj;
                Iterator<a<?>> it = this.f2587g.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.f2595g == i3) {
                        }
                    } else {
                        aVar = null;
                    }
                }
                if (aVar != null) {
                    int i4 = aVar4.c;
                    if (i4 == 13) {
                        Objects.requireNonNull(this.c);
                        AtomicBoolean atomicBoolean = f.b.a.c.b.i.a;
                        String g2 = f.b.a.c.b.a.g(i4);
                        String str = aVar4.f2573e;
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + String.valueOf(g2).length() + 69);
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(g2);
                        sb.append(": ");
                        sb.append(str);
                        Status status = new Status(17, sb.toString());
                        m.h.l(e.this.f2590j);
                        aVar.e(status, null, false);
                        break;
                    } else {
                        Status c2 = c(aVar.c, aVar4);
                        m.h.l(e.this.f2590j);
                        aVar.e(c2, null, false);
                        break;
                    }
                } else {
                    new Exception();
                    break;
                }
            case 6:
                if (this.b.getApplicationContext() instanceof Application) {
                    c.a((Application) this.b.getApplicationContext());
                    c cVar = c.f2580f;
                    o oVar = new o(this);
                    Objects.requireNonNull(cVar);
                    synchronized (cVar) {
                        cVar.f2581d.add(oVar);
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
                if (this.f2587g.containsKey(message.obj)) {
                    a<?> aVar5 = this.f2587g.get(message.obj);
                    m.h.l(e.this.f2590j);
                    if (aVar5.f2597i) {
                        aVar5.n();
                        break;
                    }
                }
                break;
            case 10:
                for (b<?> bVar2 : this.f2589i) {
                    a<?> remove = this.f2587g.remove(bVar2);
                    if (remove != null) {
                        remove.b();
                    }
                }
                this.f2589i.clear();
                break;
            case 11:
                if (this.f2587g.containsKey(message.obj)) {
                    a<?> aVar6 = this.f2587g.get(message.obj);
                    m.h.l(e.this.f2590j);
                    if (aVar6.f2597i) {
                        aVar6.s();
                        e eVar = e.this;
                        Status status2 = eVar.c.b(eVar.b, f.b.a.c.b.e.a) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error.");
                        m.h.l(e.this.f2590j);
                        aVar6.e(status2, null, false);
                        aVar6.b.k("Timing out connection while resuming.");
                        break;
                    }
                }
                break;
            case 12:
                if (this.f2587g.containsKey(message.obj)) {
                    this.f2587g.get(message.obj).g(true);
                    break;
                }
                break;
            case 14:
                Objects.requireNonNull((m) message.obj);
                if (!this.f2587g.containsKey(null)) {
                    throw null;
                }
                this.f2587g.get(null).g(false);
                throw null;
            case 15:
                b bVar3 = (b) message.obj;
                if (this.f2587g.containsKey(bVar3.a)) {
                    a<?> aVar7 = this.f2587g.get(bVar3.a);
                    if (aVar7.f2598j.contains(bVar3) && !aVar7.f2597i) {
                        if (!aVar7.b.d()) {
                            aVar7.n();
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
                if (this.f2587g.containsKey(bVar4.a)) {
                    a<?> aVar8 = this.f2587g.get(bVar4.a);
                    if (aVar8.f2598j.remove(bVar4)) {
                        e.this.f2590j.removeMessages(15, bVar4);
                        e.this.f2590j.removeMessages(16, bVar4);
                        f.b.a.c.b.c cVar2 = bVar4.b;
                        ArrayList arrayList = new ArrayList(aVar8.a.size());
                        for (w wVar : aVar8.a) {
                            if ((wVar instanceof n) && (f2 = ((n) wVar).f(aVar8)) != null) {
                                int length = f2.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        i5 = -1;
                                    } else if (!m.h.U(f2[i5], cVar2)) {
                                        i5++;
                                    }
                                }
                                if (i5 >= 0) {
                                    arrayList.add(wVar);
                                }
                            }
                        }
                        int size = arrayList.size();
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            w wVar2 = (w) obj;
                            aVar8.a.remove(wVar2);
                            wVar2.d(new k(cVar2));
                        }
                        break;
                    }
                }
                break;
            default:
                return false;
        }
        return true;
    }
}
