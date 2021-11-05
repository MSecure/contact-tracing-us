package c.b.a.a.c.k.o;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import b.b.k.i;
import c.b.a.a.c.d;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.n;
import c.b.a.a.c.k.o.k;
import c.b.a.a.c.l.b;
import c.b.a.a.c.l.i;
import c.b.a.a.c.l.j;
import c.b.a.a.c.l.o;
import c.b.a.a.c.l.r;
import c.b.a.a.f.f;
import c.b.a.a.g.h;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class g implements Handler.Callback {
    public static final Status n = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status o = new Status(4, "The user must be signed in to make this API call.");
    public static final Object p = new Object();
    public static g q;

    /* renamed from: a  reason: collision with root package name */
    public long f2336a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public long f2337b = 120000;

    /* renamed from: c  reason: collision with root package name */
    public long f2338c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public final Context f2339d;

    /* renamed from: e  reason: collision with root package name */
    public final d f2340e;
    public final i f;
    public final AtomicInteger g = new AtomicInteger(1);
    public final AtomicInteger h = new AtomicInteger(0);
    public final Map<b<?>, a<?>> i = new ConcurrentHashMap(5, 0.75f, 1);
    public u j = null;
    public final Set<b<?>> k = new b.e.c();
    public final Set<b<?>> l = new b.e.c();
    public final Handler m;

    public class a<O extends a.d> implements e.a, e.b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<y> f2341a = new LinkedList();

        /* renamed from: b  reason: collision with root package name */
        public final a.f f2342b;

        /* renamed from: c  reason: collision with root package name */
        public final a.b f2343c;

        /* renamed from: d  reason: collision with root package name */
        public final b<O> f2344d;

        /* renamed from: e  reason: collision with root package name */
        public final t f2345e;
        public final Set<a1> f = new HashSet();
        public final Map<k.a<?>, i0> g = new HashMap();
        public final int h;
        public final l0 i;
        public boolean j;
        public final List<b> k = new ArrayList();
        public c.b.a.a.c.a l = null;

        public a(c.b.a.a.c.k.d<O> dVar) {
            a.f zaa = dVar.zaa(g.this.m.getLooper(), this);
            this.f2342b = zaa;
            if (!(zaa instanceof r)) {
                this.f2343c = zaa;
            } else if (((r) zaa) != null) {
                this.f2343c = null;
            } else {
                throw null;
            }
            this.f2344d = dVar.getApiKey();
            this.f2345e = new t();
            this.h = dVar.getInstanceId();
            if (this.f2342b.requiresSignIn()) {
                this.i = dVar.zaa(g.this.f2339d, g.this.m);
            } else {
                this.i = null;
            }
        }

        public final void a() {
            c.b.a.a.c.a aVar;
            i.j.m(g.this.m);
            if (!this.f2342b.isConnected() && !this.f2342b.isConnecting()) {
                try {
                    int a2 = g.this.f.a(g.this.f2339d, this.f2342b);
                    if (a2 != 0) {
                        c.b.a.a.c.a aVar2 = new c.b.a.a.c.a(a2, null);
                        String name = this.f2343c.getClass().getName();
                        String valueOf = String.valueOf(aVar2);
                        name.length();
                        valueOf.length();
                        g(aVar2, null);
                        return;
                    }
                    c cVar = new c(this.f2342b, this.f2344d);
                    if (this.f2342b.requiresSignIn()) {
                        l0 l0Var = this.i;
                        f fVar = l0Var.f;
                        if (fVar != null) {
                            fVar.disconnect();
                        }
                        l0Var.f2385e.h = Integer.valueOf(System.identityHashCode(l0Var));
                        a.AbstractC0055a<? extends f, c.b.a.a.f.a> aVar3 = l0Var.f2383c;
                        Context context = l0Var.f2381a;
                        Looper looper = l0Var.f2382b.getLooper();
                        c.b.a.a.c.l.c cVar2 = l0Var.f2385e;
                        l0Var.f = (f) aVar3.buildClient(context, looper, cVar2, cVar2.g, (e.a) l0Var, (e.b) l0Var);
                        l0Var.g = cVar;
                        Set<Scope> set = l0Var.f2384d;
                        if (set == null || set.isEmpty()) {
                            l0Var.f2382b.post(new n0(l0Var));
                        } else {
                            l0Var.f.a();
                        }
                    }
                    try {
                        this.f2342b.connect(cVar);
                    } catch (SecurityException e2) {
                        e = e2;
                        aVar = new c.b.a.a.c.a(10);
                        g(aVar, e);
                    }
                } catch (IllegalStateException e3) {
                    e = e3;
                    aVar = new c.b.a.a.c.a(10);
                    g(aVar, e);
                }
            }
        }

        public final boolean b() {
            return this.f2342b.requiresSignIn();
        }

        @Override // c.b.a.a.c.k.o.l
        public final void c(c.b.a.a.c.a aVar) {
            g(aVar, null);
        }

        @Override // c.b.a.a.c.k.o.f
        public final void d(int i2) {
            if (Looper.myLooper() == g.this.m.getLooper()) {
                l();
            } else {
                g.this.m.post(new a0(this));
            }
        }

        @Override // c.b.a.a.c.k.o.f
        public final void e(Bundle bundle) {
            if (Looper.myLooper() == g.this.m.getLooper()) {
                k();
            } else {
                g.this.m.post(new b0(this));
            }
        }

        public final c.b.a.a.c.c f(c.b.a.a.c.c[] cVarArr) {
            if (cVarArr == null || cVarArr.length == 0) {
                return null;
            }
            c.b.a.a.c.c[] availableFeatures = this.f2342b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new c.b.a.a.c.c[0];
            }
            b.e.a aVar = new b.e.a(availableFeatures.length);
            for (c.b.a.a.c.c cVar : availableFeatures) {
                aVar.put(cVar.f2286b, Long.valueOf(cVar.p()));
            }
            for (c.b.a.a.c.c cVar2 : cVarArr) {
                if (!aVar.containsKey(cVar2.f2286b) || ((Long) aVar.get(cVar2.f2286b)).longValue() < cVar2.p()) {
                    return cVar2;
                }
            }
            return null;
        }

        public final void g(c.b.a.a.c.a aVar, Exception exc) {
            f fVar;
            i.j.m(g.this.m);
            l0 l0Var = this.i;
            if (!(l0Var == null || (fVar = l0Var.f) == null)) {
                fVar.disconnect();
            }
            o();
            g.this.f.f2469a.clear();
            v(aVar);
            if (aVar.f2281c == 4) {
                r(g.o);
            } else if (this.f2341a.isEmpty()) {
                this.l = aVar;
            } else if (exc != null) {
                i.j.m(g.this.m);
                h(null, exc, false);
            } else {
                h(w(aVar), null, true);
                if (!this.f2341a.isEmpty() && !u(aVar) && !g.this.f(aVar, this.h)) {
                    if (aVar.f2281c == 18) {
                        this.j = true;
                    }
                    if (this.j) {
                        Handler handler = g.this.m;
                        handler.sendMessageDelayed(Message.obtain(handler, 9, this.f2344d), g.this.f2336a);
                        return;
                    }
                    Status w = w(aVar);
                    i.j.m(g.this.m);
                    h(w, null, false);
                }
            }
        }

        public final void h(Status status, Exception exc, boolean z) {
            i.j.m(g.this.m);
            boolean z2 = true;
            boolean z3 = status == null;
            if (exc != null) {
                z2 = false;
            }
            if (z3 != z2) {
                Iterator<y> it = this.f2341a.iterator();
                while (it.hasNext()) {
                    y next = it.next();
                    if (!z || next.f2410a == 2) {
                        if (status != null) {
                            next.a(status);
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

        public final void i(y yVar) {
            i.j.m(g.this.m);
            if (!this.f2342b.isConnected()) {
                this.f2341a.add(yVar);
                c.b.a.a.c.a aVar = this.l;
                if (aVar == null || !aVar.p()) {
                    a();
                } else {
                    g(this.l, null);
                }
            } else if (j(yVar)) {
                q();
            } else {
                this.f2341a.add(yVar);
            }
        }

        public final boolean j(y yVar) {
            if (!(yVar instanceof v0)) {
                s(yVar);
                return true;
            }
            v0 v0Var = (v0) yVar;
            c.b.a.a.c.c f2 = f(v0Var.f(this));
            if (f2 == null) {
                s(yVar);
                return true;
            }
            String name = this.f2343c.getClass().getName();
            String str = f2.f2286b;
            name.length();
            String.valueOf(str).length();
            if (v0Var.g(this)) {
                b bVar = new b(this.f2344d, f2, null);
                int indexOf = this.k.indexOf(bVar);
                if (indexOf >= 0) {
                    b bVar2 = this.k.get(indexOf);
                    g.this.m.removeMessages(15, bVar2);
                    Handler handler = g.this.m;
                    handler.sendMessageDelayed(Message.obtain(handler, 15, bVar2), g.this.f2336a);
                    return false;
                }
                this.k.add(bVar);
                Handler handler2 = g.this.m;
                handler2.sendMessageDelayed(Message.obtain(handler2, 15, bVar), g.this.f2336a);
                Handler handler3 = g.this.m;
                handler3.sendMessageDelayed(Message.obtain(handler3, 16, bVar), g.this.f2337b);
                c.b.a.a.c.a aVar = new c.b.a.a.c.a(2, null);
                if (u(aVar)) {
                    return false;
                }
                g.this.f(aVar, this.h);
                return false;
            }
            v0Var.d(new n(f2));
            return true;
        }

        public final void k() {
            o();
            v(c.b.a.a.c.a.f);
            p();
            Iterator<i0> it = this.g.values().iterator();
            while (it.hasNext()) {
                i0 next = it.next();
                if (f(next.f2364a.getRequiredFeatures()) == null) {
                    try {
                        next.f2364a.registerListener(this.f2343c, new c.b.a.a.g.i<>());
                    } catch (DeadObjectException unused) {
                        d(1);
                        this.f2342b.disconnect();
                    } catch (RemoteException unused2) {
                    }
                }
                it.remove();
            }
            m();
            q();
        }

        public final void l() {
            o();
            this.j = true;
            t tVar = this.f2345e;
            if (tVar != null) {
                tVar.a(true, s0.f2400a);
                Handler handler = g.this.m;
                handler.sendMessageDelayed(Message.obtain(handler, 9, this.f2344d), g.this.f2336a);
                Handler handler2 = g.this.m;
                handler2.sendMessageDelayed(Message.obtain(handler2, 11, this.f2344d), g.this.f2337b);
                g.this.f.f2469a.clear();
                for (i0 i0Var : this.g.values()) {
                    i0Var.f2366c.run();
                }
                return;
            }
            throw null;
        }

        public final void m() {
            ArrayList arrayList = new ArrayList(this.f2341a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                y yVar = (y) obj;
                if (!this.f2342b.isConnected()) {
                    return;
                }
                if (j(yVar)) {
                    this.f2341a.remove(yVar);
                }
            }
        }

        public final void n() {
            i.j.m(g.this.m);
            r(g.n);
            t tVar = this.f2345e;
            if (tVar != null) {
                tVar.a(false, g.n);
                for (k.a aVar : (k.a[]) this.g.keySet().toArray(new k.a[this.g.size()])) {
                    i(new y0(aVar, new c.b.a.a.g.i()));
                }
                v(new c.b.a.a.c.a(4));
                if (this.f2342b.isConnected()) {
                    this.f2342b.onUserSignOut(new c0(this));
                    return;
                }
                return;
            }
            throw null;
        }

        public final void o() {
            i.j.m(g.this.m);
            this.l = null;
        }

        public final void p() {
            if (this.j) {
                g.this.m.removeMessages(11, this.f2344d);
                g.this.m.removeMessages(9, this.f2344d);
                this.j = false;
            }
        }

        public final void q() {
            g.this.m.removeMessages(12, this.f2344d);
            Handler handler = g.this.m;
            handler.sendMessageDelayed(handler.obtainMessage(12, this.f2344d), g.this.f2338c);
        }

        public final void r(Status status) {
            i.j.m(g.this.m);
            h(status, null, false);
        }

        public final void s(y yVar) {
            yVar.c(this.f2345e, b());
            try {
                yVar.b(this);
            } catch (DeadObjectException unused) {
                d(1);
                this.f2342b.disconnect();
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.f2343c.getClass().getName()), th);
            }
        }

        public final boolean t(boolean z) {
            i.j.m(g.this.m);
            if (!this.f2342b.isConnected() || this.g.size() != 0) {
                return false;
            }
            t tVar = this.f2345e;
            if (!tVar.f2401a.isEmpty() || !tVar.f2402b.isEmpty()) {
                if (z) {
                    q();
                }
                return false;
            }
            this.f2342b.disconnect();
            return true;
        }

        public final boolean u(c.b.a.a.c.a aVar) {
            synchronized (g.p) {
                if (g.this.j == null || !g.this.k.contains(this.f2344d)) {
                    return false;
                }
                u uVar = g.this.j;
                int i2 = this.h;
                if (uVar != null) {
                    b1 b1Var = new b1(aVar, i2);
                    if (uVar.f2325d.compareAndSet(null, b1Var)) {
                        uVar.f2326e.post(new e1(uVar, b1Var));
                    }
                    return true;
                }
                throw null;
            }
        }

        public final void v(c.b.a.a.c.a aVar) {
            Iterator<a1> it = this.f.iterator();
            if (it.hasNext()) {
                it.next();
                if (i.j.X(aVar, c.b.a.a.c.a.f)) {
                    this.f2342b.getEndpointPackageName();
                }
                throw null;
            }
            this.f.clear();
        }

        public final Status w(c.b.a.a.c.a aVar) {
            String str = this.f2344d.f2314c.f2303c;
            String valueOf = String.valueOf(aVar);
            StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(str).length() + 63);
            sb.append("API: ");
            sb.append(str);
            sb.append(" is not available on this device. Connection failed with: ");
            sb.append(valueOf);
            return new Status(17, sb.toString());
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final b<?> f2346a;

        /* renamed from: b  reason: collision with root package name */
        public final c.b.a.a.c.c f2347b;

        public b(b bVar, c.b.a.a.c.c cVar, z zVar) {
            this.f2346a = bVar;
            this.f2347b = cVar;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                return i.j.X(this.f2346a, bVar.f2346a) && i.j.X(this.f2347b, bVar.f2347b);
            }
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f2346a, this.f2347b});
        }

        public final String toString() {
            o j1 = i.j.j1(this);
            j1.a("key", this.f2346a);
            j1.a("feature", this.f2347b);
            return j1.toString();
        }
    }

    public class c implements o0, b.c {

        /* renamed from: a  reason: collision with root package name */
        public final a.f f2348a;

        /* renamed from: b  reason: collision with root package name */
        public final b<?> f2349b;

        /* renamed from: c  reason: collision with root package name */
        public j f2350c = null;

        /* renamed from: d  reason: collision with root package name */
        public Set<Scope> f2351d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2352e = false;

        public c(a.f fVar, b<?> bVar) {
            this.f2348a = fVar;
            this.f2349b = bVar;
        }

        @Override // c.b.a.a.c.l.b.c
        public final void a(c.b.a.a.c.a aVar) {
            g.this.m.post(new e0(this, aVar));
        }

        public final void b(c.b.a.a.c.a aVar) {
            a<?> aVar2 = g.this.i.get(this.f2349b);
            i.j.m(g.this.m);
            aVar2.f2342b.disconnect();
            aVar2.g(aVar, null);
        }
    }

    public g(Context context, Looper looper, d dVar) {
        this.f2339d = context;
        this.m = new c.b.a.a.e.a.d(looper, this);
        this.f2340e = dVar;
        this.f = new c.b.a.a.c.l.i(dVar);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static g c(Context context) {
        g gVar;
        synchronized (p) {
            if (q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                q = new g(context.getApplicationContext(), handlerThread.getLooper(), d.f2290d);
            }
            gVar = q;
        }
        return gVar;
    }

    public final <O extends a.d> h<Void> a(c.b.a.a.c.k.d<O> dVar, m<a.b, ?> mVar, r<a.b, ?> rVar, Runnable runnable) {
        c.b.a.a.g.i iVar = new c.b.a.a.g.i();
        w0 w0Var = new w0(new i0(mVar, rVar, runnable), iVar);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(8, new h0(w0Var, this.h.get(), dVar)));
        return iVar.f2856a;
    }

    public final void b(u uVar) {
        synchronized (p) {
            if (this.j != uVar) {
                this.j = uVar;
                this.k.clear();
            }
            this.k.addAll(uVar.g);
        }
    }

    public final void d(c.b.a.a.c.k.d<?> dVar) {
        b<?> apiKey = dVar.getApiKey();
        a<?> aVar = this.i.get(apiKey);
        if (aVar == null) {
            aVar = new a<>(dVar);
            this.i.put(apiKey, aVar);
        }
        if (aVar.b()) {
            this.l.add(apiKey);
        }
        aVar.a();
    }

    public final int e() {
        return this.g.getAndIncrement();
    }

    public final boolean f(c.b.a.a.c.a aVar, int i2) {
        d dVar = this.f2340e;
        Context context = this.f2339d;
        PendingIntent pendingIntent = null;
        if (dVar != null) {
            if (aVar.p()) {
                pendingIntent = aVar.f2282d;
            } else {
                Intent a2 = dVar.a(context, aVar.f2281c, null);
                if (a2 != null) {
                    pendingIntent = PendingIntent.getActivity(context, 0, a2, 134217728);
                }
            }
            if (pendingIntent == null) {
                return false;
            }
            dVar.h(context, aVar.f2281c, GoogleApiActivity.a(context, pendingIntent, i2));
            return true;
        }
        throw null;
    }

    public boolean handleMessage(Message message) {
        a<?> aVar;
        c.b.a.a.g.i<Boolean> iVar;
        TResult tresult;
        c.b.a.a.c.c[] f2;
        long j2 = 300000;
        int i2 = 0;
        switch (message.what) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.f2338c = j2;
                this.m.removeMessages(12);
                for (b<?> bVar : this.i.keySet()) {
                    Handler handler = this.m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.f2338c);
                }
                break;
            case 2:
                a1 a1Var = (a1) message.obj;
                throw null;
            case 3:
                for (a<?> aVar2 : this.i.values()) {
                    aVar2.o();
                    aVar2.a();
                }
                break;
            case 4:
            case 8:
            case 13:
                h0 h0Var = (h0) message.obj;
                a<?> aVar3 = this.i.get(h0Var.f2359c.getApiKey());
                if (aVar3 == null) {
                    d(h0Var.f2359c);
                    aVar3 = this.i.get(h0Var.f2359c.getApiKey());
                }
                if (!aVar3.b() || this.h.get() == h0Var.f2358b) {
                    aVar3.i(h0Var.f2357a);
                    break;
                } else {
                    h0Var.f2357a.a(n);
                    aVar3.n();
                    break;
                }
                break;
            case 5:
                int i3 = message.arg1;
                c.b.a.a.c.a aVar4 = (c.b.a.a.c.a) message.obj;
                Iterator<a<?>> it = this.i.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.h == i3) {
                        }
                    } else {
                        aVar = null;
                    }
                }
                if (aVar == null) {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i3);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb.toString(), new Exception());
                    break;
                } else {
                    d dVar = this.f2340e;
                    int i4 = aVar4.f2281c;
                    if (dVar != null) {
                        String a2 = c.b.a.a.c.g.a(i4);
                        String str = aVar4.f2283e;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + String.valueOf(a2).length() + 69);
                        sb2.append("Error resolution was canceled by the user, original error message: ");
                        sb2.append(a2);
                        sb2.append(": ");
                        sb2.append(str);
                        Status status = new Status(17, sb2.toString());
                        i.j.m(g.this.m);
                        aVar.h(status, null, false);
                        break;
                    } else {
                        throw null;
                    }
                }
            case 6:
                if (this.f2339d.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.f2339d.getApplicationContext();
                    synchronized (c.f) {
                        if (!c.f.f2322e) {
                            application.registerActivityLifecycleCallbacks(c.f);
                            application.registerComponentCallbacks(c.f);
                            c.f.f2322e = true;
                        }
                    }
                    c cVar = c.f;
                    z zVar = new z(this);
                    if (cVar != null) {
                        synchronized (c.f) {
                            cVar.f2321d.add(zVar);
                        }
                        c cVar2 = c.f;
                        if (!cVar2.f2320c.get()) {
                            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                            ActivityManager.getMyMemoryState(runningAppProcessInfo);
                            if (!cVar2.f2320c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                                cVar2.f2319b.set(true);
                            }
                        }
                        if (!cVar2.f2319b.get()) {
                            this.f2338c = 300000;
                            break;
                        }
                    } else {
                        throw null;
                    }
                }
                break;
            case 7:
                d((c.b.a.a.c.k.d) message.obj);
                break;
            case 9:
                if (this.i.containsKey(message.obj)) {
                    a<?> aVar5 = this.i.get(message.obj);
                    i.j.m(g.this.m);
                    if (aVar5.j) {
                        aVar5.a();
                        break;
                    }
                }
                break;
            case 10:
                for (b<?> bVar2 : this.l) {
                    this.i.remove(bVar2).n();
                }
                this.l.clear();
                break;
            case 11:
                if (this.i.containsKey(message.obj)) {
                    a<?> aVar6 = this.i.get(message.obj);
                    i.j.m(g.this.m);
                    if (aVar6.j) {
                        aVar6.p();
                        g gVar = g.this;
                        Status status2 = gVar.f2340e.c(gVar.f2339d) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error.");
                        i.j.m(g.this.m);
                        aVar6.h(status2, null, false);
                        aVar6.f2342b.disconnect();
                        break;
                    }
                }
                break;
            case 12:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).t(true);
                    break;
                }
                break;
            case 14:
                x xVar = (x) message.obj;
                b<?> bVar3 = xVar.f2407a;
                if (!this.i.containsKey(bVar3)) {
                    iVar = xVar.f2408b;
                    tresult = (TResult) Boolean.FALSE;
                } else {
                    boolean t = this.i.get(bVar3).t(false);
                    iVar = xVar.f2408b;
                    tresult = (TResult) Boolean.valueOf(t);
                }
                iVar.f2856a.i(tresult);
                break;
            case 15:
                b bVar4 = (b) message.obj;
                if (this.i.containsKey(bVar4.f2346a)) {
                    a<?> aVar7 = this.i.get(bVar4.f2346a);
                    if (aVar7.k.contains(bVar4) && !aVar7.j) {
                        if (!aVar7.f2342b.isConnected()) {
                            aVar7.a();
                            break;
                        } else {
                            aVar7.m();
                            break;
                        }
                    }
                }
                break;
            case 16:
                b bVar5 = (b) message.obj;
                if (this.i.containsKey(bVar5.f2346a)) {
                    a<?> aVar8 = this.i.get(bVar5.f2346a);
                    if (aVar8.k.remove(bVar5)) {
                        g.this.m.removeMessages(15, bVar5);
                        g.this.m.removeMessages(16, bVar5);
                        c.b.a.a.c.c cVar3 = bVar5.f2347b;
                        ArrayList arrayList = new ArrayList(aVar8.f2341a.size());
                        for (y yVar : aVar8.f2341a) {
                            if ((yVar instanceof v0) && (f2 = ((v0) yVar).f(aVar8)) != null) {
                                int length = f2.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        i5 = -1;
                                    } else if (!i.j.X(f2[i5], cVar3)) {
                                        i5++;
                                    }
                                }
                                if (i5 >= 0) {
                                    arrayList.add(yVar);
                                }
                            }
                        }
                        int size = arrayList.size();
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            y yVar2 = (y) obj;
                            aVar8.f2341a.remove(yVar2);
                            yVar2.d(new n(cVar3));
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
