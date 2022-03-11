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
/* loaded from: classes.dex */
public class e implements Handler.Callback {
    @RecentlyNonNull

    /* renamed from: l */
    public static final Status f2678l = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status m = new Status(4, "The user must be signed in to make this API call.");
    public static final Object n = new Object();
    public static e o;
    public final Context b;
    public final d c;

    /* renamed from: d */
    public final t f2679d;
    @NotOnlyInitialized

    /* renamed from: j */
    public final Handler f2685j;

    /* renamed from: k */
    public volatile boolean f2686k;
    public long a = 10000;

    /* renamed from: e */
    public final AtomicInteger f2680e = new AtomicInteger(1);

    /* renamed from: f */
    public final AtomicInteger f2681f = new AtomicInteger(0);

    /* renamed from: g */
    public final Map<b<?>, a<?>> f2682g = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: h */
    public final Set<b<?>> f2683h = new e.f.c(0);

    /* renamed from: i */
    public final Set<b<?>> f2684i = new e.f.c(0);

    /* loaded from: classes.dex */
    public class a<O extends a.c> implements f.b.a.c.b.l.d, f.b.a.c.b.l.e {
        @NotOnlyInitialized
        public final a.e b;
        public final b<O> c;

        /* renamed from: g */
        public final int f2690g;

        /* renamed from: h */
        public final x f2691h;

        /* renamed from: i */
        public boolean f2692i;
        public final Queue<w> a = new LinkedList();

        /* renamed from: e */
        public final Set<g0> f2688e = new HashSet();

        /* renamed from: f */
        public final Map<i<?>, v> f2689f = new HashMap();

        /* renamed from: j */
        public final List<b> f2693j = new ArrayList();

        /* renamed from: k */
        public f.b.a.c.b.a f2694k = null;

        /* renamed from: d */
        public final i0 f2687d = new i0();

        public a(f.b.a.c.b.l.c<O> cVar) {
            e.this = r10;
            Looper looper = r10.f2685j.getLooper();
            f.b.a.c.b.m.c a = cVar.k().a();
            a.AbstractC0082a<?, O> aVar = cVar.b.a;
            Objects.requireNonNull(aVar, "null reference");
            a.e a2 = aVar.a(cVar.a, looper, a, cVar.c, this, this);
            this.b = a2;
            this.c = cVar.f2671d;
            this.f2690g = cVar.f2672e;
            if (a2.l()) {
                this.f2691h = new x(r10.b, r10.f2685j, cVar.k().a());
            } else {
                this.f2691h = null;
            }
        }

        @Override // f.b.a.c.b.l.l.d
        public final void Q(Bundle bundle) {
            if (Looper.myLooper() == e.this.f2685j.getLooper()) {
                o();
            } else {
                e.this.f2685j.post(new q(this));
            }
        }

        public final f.b.a.c.b.c a(f.b.a.c.b.c[] cVarArr) {
            if (cVarArr == null || cVarArr.length == 0) {
                return null;
            }
            f.b.a.c.b.c[] c = this.b.c();
            if (c == null) {
                c = new f.b.a.c.b.c[0];
            }
            e.f.a aVar = new e.f.a(c.length);
            for (f.b.a.c.b.c cVar : c) {
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
            m.e.n(e.this.f2685j);
            Status status = e.f2678l;
            m.e.n(e.this.f2685j);
            e(status, null, false);
            i0 i0Var = this.f2687d;
            Objects.requireNonNull(i0Var);
            i0Var.a(false, status);
            for (i iVar : (i[]) this.f2689f.keySet().toArray(new i[0])) {
                f(new f0(iVar, new i()));
            }
            j(new f.b.a.c.b.a(4));
            if (this.b.d()) {
                this.b.a(new r(this));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0083 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public final void c(int i2) {
            Iterator<v> it;
            String str;
            l();
            this.f2692i = true;
            i0 i0Var = this.f2687d;
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
                Handler handler = e.this.f2685j;
                Message obtain = Message.obtain(handler, 9, this.c);
                Objects.requireNonNull(e.this);
                handler.sendMessageDelayed(obtain, 5000);
                Handler handler2 = e.this.f2685j;
                Message obtain2 = Message.obtain(handler2, 11, this.c);
                Objects.requireNonNull(e.this);
                handler2.sendMessageDelayed(obtain2, 120000);
                e.this.f2679d.a.clear();
                it = this.f2689f.values().iterator();
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
            Handler handler3 = e.this.f2685j;
            Message obtain3 = Message.obtain(handler3, 9, this.c);
            Objects.requireNonNull(e.this);
            handler3.sendMessageDelayed(obtain3, 5000);
            Handler handler22 = e.this.f2685j;
            Message obtain22 = Message.obtain(handler22, 11, this.c);
            Objects.requireNonNull(e.this);
            handler22.sendMessageDelayed(obtain22, 120000);
            e.this.f2679d.a.clear();
            it = this.f2689f.values().iterator();
            if (!it.hasNext()) {
            }
        }

        public final void d(f.b.a.c.b.a aVar, Exception exc) {
            f fVar;
            m.e.n(e.this.f2685j);
            x xVar = this.f2691h;
            if (!(xVar == null || (fVar = xVar.f2703f) == null)) {
                fVar.j();
            }
            l();
            e.this.f2679d.a.clear();
            j(aVar);
            if (aVar.c == 4) {
                Status status = e.f2678l;
                Status status2 = e.m;
                m.e.n(e.this.f2685j);
                e(status2, null, false);
            } else if (this.a.isEmpty()) {
                this.f2694k = aVar;
            } else if (exc != null) {
                m.e.n(e.this.f2685j);
                e(null, exc, false);
            } else if (!e.this.f2686k) {
                Status c = e.c(this.c, aVar);
                m.e.n(e.this.f2685j);
                e(c, null, false);
            } else {
                e(e.c(this.c, aVar), null, true);
                if (!this.a.isEmpty()) {
                    h(aVar);
                    if (!e.this.b(aVar, this.f2690g)) {
                        if (aVar.c == 18) {
                            this.f2692i = true;
                        }
                        if (this.f2692i) {
                            Handler handler = e.this.f2685j;
                            Message obtain = Message.obtain(handler, 9, this.c);
                            Objects.requireNonNull(e.this);
                            handler.sendMessageDelayed(obtain, 5000);
                            return;
                        }
                        Status c2 = e.c(this.c, aVar);
                        m.e.n(e.this.f2685j);
                        e(c2, null, false);
                    }
                }
            }
        }

        public final void e(Status status, Exception exc, boolean z) {
            m.e.n(e.this.f2685j);
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
            m.e.n(e.this.f2685j);
            if (!this.b.d()) {
                this.a.add(wVar);
                f.b.a.c.b.a aVar = this.f2694k;
                if (aVar != null) {
                    if ((aVar.c == 0 || aVar.f2667d == null) ? false : true) {
                        d(aVar, null);
                        return;
                    }
                }
                m();
            } else if (i(wVar)) {
                s();
            } else {
                this.a.add(wVar);
            }
        }

        public final boolean g(boolean z) {
            m.e.n(e.this.f2685j);
            if (!this.b.d() || this.f2689f.size() != 0) {
                return false;
            }
            i0 i0Var = this.f2687d;
            if (!i0Var.a.isEmpty() || !i0Var.b.isEmpty()) {
                if (z) {
                    s();
                }
                return false;
            }
            this.b.k("Timing out service connection.");
            return true;
        }

        public final boolean h(f.b.a.c.b.a aVar) {
            Status status = e.f2678l;
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
            f.b.a.c.b.c a = a(nVar.f(this));
            if (a == null) {
                k(wVar);
                return true;
            }
            String name = this.b.getClass().getName();
            String str = a.b;
            name.length();
            String.valueOf(str).length();
            if (!e.this.f2686k || !nVar.g(this)) {
                nVar.d(new k(a));
                return true;
            }
            PendingIntent pendingIntent = null;
            b bVar = new b(this.c, a, null);
            int indexOf = this.f2693j.indexOf(bVar);
            if (indexOf >= 0) {
                b bVar2 = this.f2693j.get(indexOf);
                e.this.f2685j.removeMessages(15, bVar2);
                Handler handler = e.this.f2685j;
                Message obtain = Message.obtain(handler, 15, bVar2);
                Objects.requireNonNull(e.this);
                handler.sendMessageDelayed(obtain, 5000);
            } else {
                this.f2693j.add(bVar);
                Handler handler2 = e.this.f2685j;
                Message obtain2 = Message.obtain(handler2, 15, bVar);
                Objects.requireNonNull(e.this);
                handler2.sendMessageDelayed(obtain2, 5000);
                Handler handler3 = e.this.f2685j;
                Message obtain3 = Message.obtain(handler3, 16, bVar);
                Objects.requireNonNull(e.this);
                handler3.sendMessageDelayed(obtain3, 120000);
                Status status = e.f2678l;
                synchronized (e.n) {
                    Objects.requireNonNull(e.this);
                }
                e eVar = e.this;
                int i2 = this.f2690g;
                d dVar = eVar.c;
                Context context = eVar.b;
                Objects.requireNonNull(dVar);
                Intent a2 = dVar.a(context, 2, null);
                if (a2 != null) {
                    pendingIntent = PendingIntent.getActivity(context, 0, a2, 134217728);
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
            Iterator<g0> it = this.f2688e.iterator();
            if (it.hasNext()) {
                g0 next = it.next();
                if (m.e.X(aVar, f.b.a.c.b.a.f2666f)) {
                    this.b.e();
                }
                Objects.requireNonNull(next);
                throw null;
            }
            this.f2688e.clear();
        }

        public final void k(w wVar) {
            wVar.c(this.f2687d, n());
            try {
                wVar.e(this);
            } catch (DeadObjectException unused) {
                z(1);
                this.b.k("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.b.getClass().getName()), th);
            }
        }

        public final void l() {
            m.e.n(e.this.f2685j);
            this.f2694k = null;
        }

        public final void m() {
            f.b.a.c.b.a aVar;
            m.e.n(e.this.f2685j);
            if (!this.b.d() && !this.b.b()) {
                try {
                    e eVar = e.this;
                    int a = eVar.f2679d.a(eVar.b, this.b);
                    if (a != 0) {
                        f.b.a.c.b.a aVar2 = new f.b.a.c.b.a(a, null);
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
                        x xVar = this.f2691h;
                        Objects.requireNonNull(xVar, "null reference");
                        f fVar = xVar.f2703f;
                        if (fVar != null) {
                            fVar.j();
                        }
                        xVar.f2702e.f2724h = Integer.valueOf(System.identityHashCode(xVar));
                        a.AbstractC0082a<? extends f, f.b.a.c.h.a> aVar3 = xVar.c;
                        Context context = xVar.a;
                        Looper looper = xVar.b.getLooper();
                        f.b.a.c.b.m.c cVar2 = xVar.f2702e;
                        xVar.f2703f = (f) aVar3.a(context, looper, cVar2, cVar2.f2723g, xVar, xVar);
                        xVar.f2704g = cVar;
                        Set<Scope> set = xVar.f2701d;
                        if (set == null || set.isEmpty()) {
                            xVar.b.post(new z(xVar));
                        } else {
                            xVar.f2703f.n();
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
                }
            }
        }

        public final boolean n() {
            return this.b.l();
        }

        public final void o() {
            l();
            j(f.b.a.c.b.a.f2666f);
            r();
            Iterator<v> it = this.f2689f.values().iterator();
            if (!it.hasNext()) {
                q();
                s();
                return;
            }
            Objects.requireNonNull(it.next());
            throw null;
        }

        @Override // f.b.a.c.b.l.l.j
        public final void p(f.b.a.c.b.a aVar) {
            d(aVar, null);
        }

        public final void q() {
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

        public final void r() {
            if (this.f2692i) {
                e.this.f2685j.removeMessages(11, this.c);
                e.this.f2685j.removeMessages(9, this.c);
                this.f2692i = false;
            }
        }

        public final void s() {
            e.this.f2685j.removeMessages(12, this.c);
            Handler handler = e.this.f2685j;
            handler.sendMessageDelayed(handler.obtainMessage(12, this.c), e.this.a);
        }

        @Override // f.b.a.c.b.l.l.d
        public final void z(int i2) {
            if (Looper.myLooper() == e.this.f2685j.getLooper()) {
                c(i2);
            } else {
                e.this.f2685j.post(new p(this, i2));
            }
        }
    }

    /* loaded from: classes.dex */
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
                if (m.e.X(this.a, bVar.a) && m.e.X(this.b, bVar.b)) {
                    return true;
                }
            }
            return false;
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

    /* loaded from: classes.dex */
    public class c implements a0, b.c {
        public final a.e a;
        public final b<?> b;
        public h c = null;

        /* renamed from: d */
        public Set<Scope> f2696d = null;

        /* renamed from: e */
        public boolean f2697e = false;

        public c(a.e eVar, b<?> bVar) {
            e.this = r1;
            this.a = eVar;
            this.b = bVar;
        }

        @Override // f.b.a.c.b.m.b.c
        public final void a(f.b.a.c.b.a aVar) {
            e.this.f2685j.post(new t(this, aVar));
        }

        public final void b(f.b.a.c.b.a aVar) {
            a<?> aVar2 = e.this.f2682g.get(this.b);
            if (aVar2 != null) {
                m.e.n(e.this.f2685j);
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
        this.f2686k = true;
        this.b = context;
        f.b.a.c.e.a.d dVar2 = new f.b.a.c.e.a.d(looper, this);
        this.f2685j = dVar2;
        this.c = dVar;
        this.f2679d = new t(dVar);
        PackageManager packageManager = context.getPackageManager();
        if (f.b.a.c.b.o.b.f2759d == null) {
            f.b.a.c.b.o.b.f2759d = Boolean.valueOf((!f.b.a.c.b.o.b.S0() || !packageManager.hasSystemFeature("android.hardware.type.automotive")) ? false : z);
        }
        if (f.b.a.c.b.o.b.f2759d.booleanValue()) {
            this.f2686k = false;
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
                o = new e(applicationContext, looper, d.f2670d);
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
        return new Status(1, 17, sb.toString(), aVar.f2667d, aVar);
    }

    public final boolean b(f.b.a.c.b.a aVar, int i2) {
        PendingIntent pendingIntent;
        d dVar = this.c;
        Context context = this.b;
        Objects.requireNonNull(dVar);
        int i3 = aVar.c;
        if ((i3 == 0 || aVar.f2667d == null) ? false : true) {
            pendingIntent = aVar.f2667d;
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
        b<?> bVar = cVar.f2671d;
        a<?> aVar = this.f2682g.get(bVar);
        if (aVar == null) {
            aVar = new a<>(cVar);
            this.f2682g.put(bVar, aVar);
        }
        if (aVar.n()) {
            this.f2684i.add(bVar);
        }
        aVar.m();
        return aVar;
    }

    @Override // android.os.Handler.Callback
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
                this.f2685j.removeMessages(12);
                for (b<?> bVar : this.f2682g.keySet()) {
                    Handler handler = this.f2685j;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.a);
                }
                break;
            case 2:
                Objects.requireNonNull((g0) message.obj);
                throw null;
            case 3:
                for (a<?> aVar2 : this.f2682g.values()) {
                    aVar2.l();
                    aVar2.m();
                }
                break;
            case 4:
            case 8:
            case 13:
                u uVar = (u) message.obj;
                a<?> aVar3 = this.f2682g.get(uVar.c.f2671d);
                if (aVar3 == null) {
                    aVar3 = d(uVar.c);
                }
                if (!aVar3.n() || this.f2681f.get() == uVar.b) {
                    aVar3.f(uVar.a);
                    break;
                } else {
                    uVar.a.b(f2678l);
                    aVar3.b();
                    break;
                }
            case 5:
                int i3 = message.arg1;
                f.b.a.c.b.a aVar4 = (f.b.a.c.b.a) message.obj;
                Iterator<a<?>> it = this.f2682g.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.f2690g == i3) {
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
                        String str = aVar4.f2668e;
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + String.valueOf(g2).length() + 69);
                        sb.append("Error resolution was canceled by the user, original error message: ");
                        sb.append(g2);
                        sb.append(": ");
                        sb.append(str);
                        Status status = new Status(17, sb.toString());
                        m.e.n(e.this.f2685j);
                        aVar.e(status, null, false);
                        break;
                    } else {
                        Status c2 = c(aVar.c, aVar4);
                        m.e.n(e.this.f2685j);
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
                    c cVar = c.f2675f;
                    o oVar = new o(this);
                    Objects.requireNonNull(cVar);
                    synchronized (cVar) {
                        cVar.f2676d.add(oVar);
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
                if (this.f2682g.containsKey(message.obj)) {
                    a<?> aVar5 = this.f2682g.get(message.obj);
                    m.e.n(e.this.f2685j);
                    if (aVar5.f2692i) {
                        aVar5.m();
                        break;
                    }
                }
                break;
            case 10:
                for (b<?> bVar2 : this.f2684i) {
                    a<?> remove = this.f2682g.remove(bVar2);
                    if (remove != null) {
                        remove.b();
                    }
                }
                this.f2684i.clear();
                break;
            case 11:
                if (this.f2682g.containsKey(message.obj)) {
                    a<?> aVar6 = this.f2682g.get(message.obj);
                    m.e.n(e.this.f2685j);
                    if (aVar6.f2692i) {
                        aVar6.r();
                        e eVar = e.this;
                        Status status2 = eVar.c.b(eVar.b, f.b.a.c.b.e.a) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error.");
                        m.e.n(e.this.f2685j);
                        aVar6.e(status2, null, false);
                        aVar6.b.k("Timing out connection while resuming.");
                        break;
                    }
                }
                break;
            case 12:
                if (this.f2682g.containsKey(message.obj)) {
                    this.f2682g.get(message.obj).g(true);
                    break;
                }
                break;
            case 14:
                Objects.requireNonNull((m) message.obj);
                if (!this.f2682g.containsKey(null)) {
                    throw null;
                }
                this.f2682g.get(null).g(false);
                throw null;
            case 15:
                b bVar3 = (b) message.obj;
                if (this.f2682g.containsKey(bVar3.a)) {
                    a<?> aVar7 = this.f2682g.get(bVar3.a);
                    if (aVar7.f2693j.contains(bVar3) && !aVar7.f2692i) {
                        if (!aVar7.b.d()) {
                            aVar7.m();
                            break;
                        } else {
                            aVar7.q();
                            break;
                        }
                    }
                }
                break;
            case 16:
                b bVar4 = (b) message.obj;
                if (this.f2682g.containsKey(bVar4.a)) {
                    a<?> aVar8 = this.f2682g.get(bVar4.a);
                    if (aVar8.f2693j.remove(bVar4)) {
                        e.this.f2685j.removeMessages(15, bVar4);
                        e.this.f2685j.removeMessages(16, bVar4);
                        f.b.a.c.b.c cVar2 = bVar4.b;
                        ArrayList arrayList = new ArrayList(aVar8.a.size());
                        for (w wVar : aVar8.a) {
                            if ((wVar instanceof n) && (f2 = ((n) wVar).f(aVar8)) != null) {
                                int length = f2.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        i5 = -1;
                                    } else if (!m.e.X(f2[i5], cVar2)) {
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
