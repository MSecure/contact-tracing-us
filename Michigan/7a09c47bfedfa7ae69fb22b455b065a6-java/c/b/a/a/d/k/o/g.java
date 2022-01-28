package c.b.a.a.d.k.o;

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
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.d;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.n;
import c.b.a.a.d.k.o.k;
import c.b.a.a.d.m.b;
import c.b.a.a.d.m.h;
import c.b.a.a.d.m.m;
import c.b.a.a.d.m.v;
import c.b.a.a.i.f;
import c.b.a.a.j.i;
import c.b.a.a.j.j;
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
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public class g implements Handler.Callback {
    @RecentlyNonNull
    public static final Status o = new Status(4, "Sign-out occurred while this API call was in progress.");
    public static final Status p = new Status(4, "The user must be signed in to make this API call.");
    public static final Object q = new Object();
    public static g r;

    /* renamed from: a  reason: collision with root package name */
    public long f2976a = 5000;

    /* renamed from: b  reason: collision with root package name */
    public long f2977b = 120000;

    /* renamed from: c  reason: collision with root package name */
    public long f2978c = 10000;

    /* renamed from: d  reason: collision with root package name */
    public final Context f2979d;

    /* renamed from: e  reason: collision with root package name */
    public final d f2980e;

    /* renamed from: f  reason: collision with root package name */
    public final v f2981f;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicInteger f2982g;
    public final AtomicInteger h;
    public final Map<b<?>, a<?>> i;
    public f1 j;
    public final Set<b<?>> k;
    public final Set<b<?>> l;
    @NotOnlyInitialized
    public final Handler m;
    public volatile boolean n;

    public class a<O extends a.d> implements e.a, e.b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<g0> f2983a = new LinkedList();
        @NotOnlyInitialized

        /* renamed from: b  reason: collision with root package name */
        public final a.f f2984b;

        /* renamed from: c  reason: collision with root package name */
        public final b<O> f2985c;

        /* renamed from: d  reason: collision with root package name */
        public final e1 f2986d;

        /* renamed from: e  reason: collision with root package name */
        public final Set<x0> f2987e = new HashSet();

        /* renamed from: f  reason: collision with root package name */
        public final Map<k.a<?>, e0> f2988f = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        public final int f2989g;
        public final i0 h;
        public boolean i;
        public final List<b> j = new ArrayList();
        public c.b.a.a.d.a k = null;

        public a(c.b.a.a.d.k.d<O> dVar) {
            this.f2984b = dVar.zaa(g.this.m.getLooper(), this);
            this.f2985c = dVar.getApiKey();
            this.f2986d = new e1();
            this.f2989g = dVar.zaa();
            if (this.f2984b.requiresSignIn()) {
                this.h = dVar.zaa(g.this.f2979d, g.this.m);
            } else {
                this.h = null;
            }
        }

        public final c.b.a.a.d.c a(c.b.a.a.d.c[] cVarArr) {
            if (cVarArr == null || cVarArr.length == 0) {
                return null;
            }
            c.b.a.a.d.c[] availableFeatures = this.f2984b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new c.b.a.a.d.c[0];
            }
            b.e.a aVar = new b.e.a(availableFeatures.length);
            for (c.b.a.a.d.c cVar : availableFeatures) {
                aVar.put(cVar.f2923b, Long.valueOf(cVar.t()));
            }
            for (c.b.a.a.d.c cVar2 : cVarArr) {
                Long l2 = (Long) aVar.get(cVar2.f2923b);
                if (l2 == null || l2.longValue() < cVar2.t()) {
                    return cVar2;
                }
            }
            return null;
        }

        public final void b() {
            t.x(g.this.m);
            e(g.o);
            e1 e1Var = this.f2986d;
            if (e1Var != null) {
                e1Var.a(false, g.o);
                for (k.a aVar : (k.a[]) this.f2988f.keySet().toArray(new k.a[0])) {
                    g(new w0(aVar, new j()));
                }
                k(new c.b.a.a.d.a(4));
                if (this.f2984b.isConnected()) {
                    this.f2984b.onUserSignOut(new y(this));
                    return;
                }
                return;
            }
            throw null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0026  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x007b A[LOOP:0: B:12:0x0075->B:14:0x007b, LOOP_END] */
        public final void c(int i2) {
            String str;
            m();
            this.i = true;
            e1 e1Var = this.f2986d;
            String lastDisconnectMessage = this.f2984b.getLastDisconnectMessage();
            if (e1Var != null) {
                StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
                if (i2 == 1) {
                    str = " due to service disconnection.";
                } else {
                    if (i2 == 3) {
                        str = " due to dead object exception.";
                    }
                    if (lastDisconnectMessage != null) {
                        sb.append(" Last reason for disconnect: ");
                        sb.append(lastDisconnectMessage);
                    }
                    e1Var.a(true, new Status(20, sb.toString()));
                    Handler handler = g.this.m;
                    handler.sendMessageDelayed(Message.obtain(handler, 9, this.f2985c), g.this.f2976a);
                    Handler handler2 = g.this.m;
                    handler2.sendMessageDelayed(Message.obtain(handler2, 11, this.f2985c), g.this.f2977b);
                    g.this.f2981f.f3158a.clear();
                    for (e0 e0Var : this.f2988f.values()) {
                        e0Var.f2972c.run();
                    }
                    return;
                }
                sb.append(str);
                if (lastDisconnectMessage != null) {
                }
                e1Var.a(true, new Status(20, sb.toString()));
                Handler handler3 = g.this.m;
                handler3.sendMessageDelayed(Message.obtain(handler3, 9, this.f2985c), g.this.f2976a);
                Handler handler22 = g.this.m;
                handler22.sendMessageDelayed(Message.obtain(handler22, 11, this.f2985c), g.this.f2977b);
                g.this.f2981f.f3158a.clear();
                while (r6.hasNext()) {
                }
                return;
            }
            throw null;
        }

        public final void d(c.b.a.a.d.a aVar, Exception exc) {
            f fVar;
            t.x(g.this.m);
            i0 i0Var = this.h;
            if (!(i0Var == null || (fVar = i0Var.f3007f) == null)) {
                fVar.disconnect();
            }
            m();
            g.this.f2981f.f3158a.clear();
            k(aVar);
            if (aVar.f2918c == 4) {
                e(g.p);
            } else if (this.f2983a.isEmpty()) {
                this.k = aVar;
            } else if (exc != null) {
                t.x(g.this.m);
                f(null, exc, false);
            } else if (!g.this.n) {
                Status e2 = g.e(this.f2985c, aVar);
                t.x(g.this.m);
                f(e2, null, false);
            } else {
                f(g.e(this.f2985c, aVar), null, true);
                if (!this.f2983a.isEmpty() && !i(aVar) && !g.this.d(aVar, this.f2989g)) {
                    if (aVar.f2918c == 18) {
                        this.i = true;
                    }
                    if (this.i) {
                        Handler handler = g.this.m;
                        handler.sendMessageDelayed(Message.obtain(handler, 9, this.f2985c), g.this.f2976a);
                        return;
                    }
                    Status e3 = g.e(this.f2985c, aVar);
                    t.x(g.this.m);
                    f(e3, null, false);
                }
            }
        }

        public final void e(Status status) {
            t.x(g.this.m);
            f(status, null, false);
        }

        public final void f(Status status, Exception exc, boolean z) {
            t.x(g.this.m);
            boolean z2 = true;
            boolean z3 = status == null;
            if (exc != null) {
                z2 = false;
            }
            if (z3 != z2) {
                Iterator<g0> it = this.f2983a.iterator();
                while (it.hasNext()) {
                    g0 next = it.next();
                    if (!z || next.f2998a == 2) {
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

        public final void g(g0 g0Var) {
            t.x(g.this.m);
            if (!this.f2984b.isConnected()) {
                this.f2983a.add(g0Var);
                c.b.a.a.d.a aVar = this.k;
                if (aVar == null || !aVar.t()) {
                    n();
                } else {
                    d(this.k, null);
                }
            } else if (j(g0Var)) {
                s();
            } else {
                this.f2983a.add(g0Var);
            }
        }

        public final boolean h(boolean z) {
            t.x(g.this.m);
            if (!this.f2984b.isConnected() || this.f2988f.size() != 0) {
                return false;
            }
            e1 e1Var = this.f2986d;
            if (!e1Var.f2973a.isEmpty() || !e1Var.f2974b.isEmpty()) {
                if (z) {
                    s();
                }
                return false;
            }
            this.f2984b.disconnect("Timing out service connection.");
            return true;
        }

        public final boolean i(c.b.a.a.d.a aVar) {
            synchronized (g.q) {
                if (g.this.j == null || !g.this.k.contains(this.f2985c)) {
                    return false;
                }
                f1 f1Var = g.this.j;
                int i2 = this.f2989g;
                if (f1Var != null) {
                    a1 a1Var = new a1(aVar, i2);
                    if (f1Var.f3062d.compareAndSet(null, a1Var)) {
                        f1Var.f3063e.post(new z0(f1Var, a1Var));
                    }
                    return true;
                }
                throw null;
            }
        }

        public final boolean j(g0 g0Var) {
            if (!(g0Var instanceof u)) {
                l(g0Var);
                return true;
            }
            u uVar = (u) g0Var;
            c.b.a.a.d.c a2 = a(uVar.f(this));
            if (a2 == null) {
                l(g0Var);
                return true;
            }
            String name = this.f2984b.getClass().getName();
            String str = a2.f2923b;
            name.length();
            String.valueOf(str).length();
            if (!g.this.n || !uVar.g(this)) {
                uVar.d(new n(a2));
                return true;
            }
            b bVar = new b(this.f2985c, a2, null);
            int indexOf = this.j.indexOf(bVar);
            if (indexOf >= 0) {
                b bVar2 = this.j.get(indexOf);
                g.this.m.removeMessages(15, bVar2);
                Handler handler = g.this.m;
                handler.sendMessageDelayed(Message.obtain(handler, 15, bVar2), g.this.f2976a);
                return false;
            }
            this.j.add(bVar);
            Handler handler2 = g.this.m;
            handler2.sendMessageDelayed(Message.obtain(handler2, 15, bVar), g.this.f2976a);
            Handler handler3 = g.this.m;
            handler3.sendMessageDelayed(Message.obtain(handler3, 16, bVar), g.this.f2977b);
            c.b.a.a.d.a aVar = new c.b.a.a.d.a(2, null);
            if (i(aVar)) {
                return false;
            }
            g.this.d(aVar, this.f2989g);
            return false;
        }

        public final void k(c.b.a.a.d.a aVar) {
            Iterator<x0> it = this.f2987e.iterator();
            if (it.hasNext()) {
                it.next();
                if (t.j1(aVar, c.b.a.a.d.a.f2916f)) {
                    this.f2984b.getEndpointPackageName();
                }
                throw null;
            }
            this.f2987e.clear();
        }

        public final void l(g0 g0Var) {
            g0Var.c(this.f2986d, o());
            try {
                g0Var.e(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.f2984b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.f2984b.getClass().getName()), th);
            }
        }

        public final void m() {
            t.x(g.this.m);
            this.k = null;
        }

        public final void n() {
            c.b.a.a.d.a aVar;
            t.x(g.this.m);
            if (!this.f2984b.isConnected() && !this.f2984b.isConnecting()) {
                try {
                    int a2 = g.this.f2981f.a(g.this.f2979d, this.f2984b);
                    if (a2 != 0) {
                        c.b.a.a.d.a aVar2 = new c.b.a.a.d.a(a2, null);
                        String name = this.f2984b.getClass().getName();
                        String valueOf = String.valueOf(aVar2);
                        name.length();
                        valueOf.length();
                        d(aVar2, null);
                        return;
                    }
                    c cVar = new c(this.f2984b, this.f2985c);
                    if (this.f2984b.requiresSignIn()) {
                        i0 i0Var = this.h;
                        t.C(i0Var);
                        i0 i0Var2 = i0Var;
                        f fVar = i0Var2.f3007f;
                        if (fVar != null) {
                            fVar.disconnect();
                        }
                        i0Var2.f3006e.h = Integer.valueOf(System.identityHashCode(i0Var2));
                        a.AbstractC0062a<? extends f, c.b.a.a.i.a> aVar3 = i0Var2.f3004c;
                        Context context = i0Var2.f3002a;
                        Looper looper = i0Var2.f3003b.getLooper();
                        c.b.a.a.d.m.c cVar2 = i0Var2.f3006e;
                        i0Var2.f3007f = (f) aVar3.buildClient(context, looper, cVar2, cVar2.f3092g, (e.a) i0Var2, (e.b) i0Var2);
                        i0Var2.f3008g = cVar;
                        Set<Scope> set = i0Var2.f3005d;
                        if (set == null || set.isEmpty()) {
                            i0Var2.f3003b.post(new k0(i0Var2));
                        } else {
                            i0Var2.f3007f.b();
                        }
                    }
                    try {
                        this.f2984b.connect(cVar);
                    } catch (SecurityException e2) {
                        e = e2;
                        aVar = new c.b.a.a.d.a(10);
                        d(aVar, e);
                    }
                } catch (IllegalStateException e3) {
                    e = e3;
                    aVar = new c.b.a.a.d.a(10);
                    d(aVar, e);
                }
            }
        }

        public final boolean o() {
            return this.f2984b.requiresSignIn();
        }

        @Override // c.b.a.a.d.k.o.f
        public final void onConnected(Bundle bundle) {
            if (Looper.myLooper() == g.this.m.getLooper()) {
                p();
            } else {
                g.this.m.post(new x(this));
            }
        }

        @Override // c.b.a.a.d.k.o.l
        public final void onConnectionFailed(c.b.a.a.d.a aVar) {
            d(aVar, null);
        }

        @Override // c.b.a.a.d.k.o.f
        public final void onConnectionSuspended(int i2) {
            if (Looper.myLooper() == g.this.m.getLooper()) {
                c(i2);
            } else {
                g.this.m.post(new w(this, i2));
            }
        }

        public final void p() {
            m();
            k(c.b.a.a.d.a.f2916f);
            r();
            Iterator<e0> it = this.f2988f.values().iterator();
            while (it.hasNext()) {
                e0 next = it.next();
                if (a(next.f2970a.getRequiredFeatures()) == null) {
                    try {
                        next.f2970a.registerListener(this.f2984b, new j<>());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(3);
                        this.f2984b.disconnect("DeadObjectException thrown while calling register listener method.");
                    } catch (RemoteException unused2) {
                    }
                }
                it.remove();
            }
            q();
            s();
        }

        public final void q() {
            ArrayList arrayList = new ArrayList(this.f2983a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                g0 g0Var = (g0) obj;
                if (!this.f2984b.isConnected()) {
                    return;
                }
                if (j(g0Var)) {
                    this.f2983a.remove(g0Var);
                }
            }
        }

        public final void r() {
            if (this.i) {
                g.this.m.removeMessages(11, this.f2985c);
                g.this.m.removeMessages(9, this.f2985c);
                this.i = false;
            }
        }

        public final void s() {
            g.this.m.removeMessages(12, this.f2985c);
            Handler handler = g.this.m;
            handler.sendMessageDelayed(handler.obtainMessage(12, this.f2985c), g.this.f2978c);
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final b<?> f2990a;

        /* renamed from: b  reason: collision with root package name */
        public final c.b.a.a.d.c f2991b;

        public b(b bVar, c.b.a.a.d.c cVar, v vVar) {
            this.f2990a = bVar;
            this.f2991b = cVar;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof b)) {
                b bVar = (b) obj;
                return t.j1(this.f2990a, bVar.f2990a) && t.j1(this.f2991b, bVar.f2991b);
            }
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f2990a, this.f2991b});
        }

        public final String toString() {
            m a3 = t.a3(this);
            a3.a("key", this.f2990a);
            a3.a("feature", this.f2991b);
            return a3.toString();
        }
    }

    public class c implements l0, b.c {

        /* renamed from: a  reason: collision with root package name */
        public final a.f f2992a;

        /* renamed from: b  reason: collision with root package name */
        public final b<?> f2993b;

        /* renamed from: c  reason: collision with root package name */
        public h f2994c = null;

        /* renamed from: d  reason: collision with root package name */
        public Set<Scope> f2995d = null;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2996e = false;

        public c(a.f fVar, b<?> bVar) {
            this.f2992a = fVar;
            this.f2993b = bVar;
        }

        @Override // c.b.a.a.d.m.b.c
        public final void a(c.b.a.a.d.a aVar) {
            g.this.m.post(new a0(this, aVar));
        }

        public final void b(c.b.a.a.d.a aVar) {
            a<?> aVar2 = g.this.i.get(this.f2993b);
            if (aVar2 != null) {
                t.x(g.this.m);
                a.f fVar = aVar2.f2984b;
                String name = fVar.getClass().getName();
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + name.length() + 25);
                sb.append("onSignInFailed for ");
                sb.append(name);
                sb.append(" with ");
                sb.append(valueOf);
                fVar.disconnect(sb.toString());
                aVar2.d(aVar, null);
            }
        }
    }

    public g(Context context, Looper looper, d dVar) {
        boolean z = true;
        this.f2982g = new AtomicInteger(1);
        this.h = new AtomicInteger(0);
        this.i = new ConcurrentHashMap(5, 0.75f, 1);
        this.j = null;
        this.k = new b.e.c();
        this.l = new b.e.c();
        this.n = true;
        this.f2979d = context;
        this.m = new c.b.a.a.g.a.d(looper, this);
        this.f2980e = dVar;
        this.f2981f = new v(dVar);
        PackageManager packageManager = context.getPackageManager();
        if (t.f2723d == null) {
            t.f2723d = Boolean.valueOf((!t.T1() || !packageManager.hasSystemFeature("android.hardware.type.automotive")) ? false : z);
        }
        if (t.f2723d.booleanValue()) {
            this.n = false;
        }
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(6));
    }

    @RecentlyNonNull
    public static g a(@RecentlyNonNull Context context) {
        g gVar;
        synchronized (q) {
            if (r == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                r = new g(context.getApplicationContext(), handlerThread.getLooper(), d.f2927d);
            }
            gVar = r;
        }
        return gVar;
    }

    public static Status e(b<?> bVar, c.b.a.a.d.a aVar) {
        String str = bVar.f2953b.f2940c;
        String valueOf = String.valueOf(aVar);
        StringBuilder sb = new StringBuilder(valueOf.length() + String.valueOf(str).length() + 63);
        sb.append("API: ");
        sb.append(str);
        sb.append(" is not available on this device. Connection failed with: ");
        sb.append(valueOf);
        return new Status(1, 17, sb.toString(), aVar.f2919d, aVar);
    }

    @RecentlyNonNull
    public final <O extends a.d> i<Void> b(@RecentlyNonNull c.b.a.a.d.k.d<O> dVar, @RecentlyNonNull m<a.b, ?> mVar, @RecentlyNonNull s<a.b, ?> sVar, @RecentlyNonNull Runnable runnable) {
        j jVar = new j();
        v0 v0Var = new v0(new e0(mVar, sVar, runnable), jVar);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(8, new d0(v0Var, this.h.get(), dVar)));
        return jVar.f4109a;
    }

    public final void c(f1 f1Var) {
        synchronized (q) {
            if (this.j != f1Var) {
                this.j = f1Var;
                this.k.clear();
            }
            this.k.addAll(f1Var.f2975g);
        }
    }

    public final boolean d(c.b.a.a.d.a aVar, int i2) {
        d dVar = this.f2980e;
        Context context = this.f2979d;
        PendingIntent pendingIntent = null;
        if (dVar != null) {
            if (aVar.t()) {
                pendingIntent = aVar.f2919d;
            } else {
                Intent a2 = dVar.a(context, aVar.f2918c, null);
                if (a2 != null) {
                    pendingIntent = PendingIntent.getActivity(context, 0, a2, 134217728);
                }
            }
            if (pendingIntent == null) {
                return false;
            }
            dVar.g(context, aVar.f2918c, GoogleApiActivity.a(context, pendingIntent, i2));
            return true;
        }
        throw null;
    }

    public final void f(@RecentlyNonNull c.b.a.a.d.a aVar, @RecentlyNonNull int i2) {
        if (!d(aVar, i2)) {
            Handler handler = this.m;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, aVar));
        }
    }

    public final a<?> g(c.b.a.a.d.k.d<?> dVar) {
        b<?> apiKey = dVar.getApiKey();
        a<?> aVar = this.i.get(apiKey);
        if (aVar == null) {
            aVar = new a<>(dVar);
            this.i.put(apiKey, aVar);
        }
        if (aVar.o()) {
            this.l.add(apiKey);
        }
        aVar.n();
        return aVar;
    }

    @RecentlyNonNull
    public boolean handleMessage(@RecentlyNonNull Message message) {
        a<?> aVar;
        j<Boolean> jVar;
        TResult tresult;
        c.b.a.a.d.c[] f2;
        long j2 = 300000;
        int i2 = 0;
        switch (message.what) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.f2978c = j2;
                this.m.removeMessages(12);
                for (b<?> bVar : this.i.keySet()) {
                    Handler handler = this.m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.f2978c);
                }
                break;
            case 2:
                x0 x0Var = (x0) message.obj;
                throw null;
            case 3:
                for (a<?> aVar2 : this.i.values()) {
                    aVar2.m();
                    aVar2.n();
                }
                break;
            case 4:
            case 8:
            case 13:
                d0 d0Var = (d0) message.obj;
                a<?> aVar3 = this.i.get(d0Var.f2967c.getApiKey());
                if (aVar3 == null) {
                    aVar3 = g(d0Var.f2967c);
                }
                if (!aVar3.o() || this.h.get() == d0Var.f2966b) {
                    aVar3.g(d0Var.f2965a);
                    break;
                } else {
                    d0Var.f2965a.b(o);
                    aVar3.b();
                    break;
                }
                break;
            case 5:
                int i3 = message.arg1;
                c.b.a.a.d.a aVar4 = (c.b.a.a.d.a) message.obj;
                Iterator<a<?>> it = this.i.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        aVar = it.next();
                        if (aVar.f2989g == i3) {
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
                } else if (aVar4.f2918c != 13) {
                    Status e2 = e(aVar.f2985c, aVar4);
                    t.x(g.this.m);
                    aVar.f(e2, null, false);
                    break;
                } else {
                    d dVar = this.f2980e;
                    int i4 = aVar4.f2918c;
                    if (dVar != null) {
                        String a2 = c.b.a.a.d.g.a(i4);
                        String str = aVar4.f2920e;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + String.valueOf(a2).length() + 69);
                        sb2.append("Error resolution was canceled by the user, original error message: ");
                        sb2.append(a2);
                        sb2.append(": ");
                        sb2.append(str);
                        Status status = new Status(17, sb2.toString());
                        t.x(g.this.m);
                        aVar.f(status, null, false);
                        break;
                    } else {
                        throw null;
                    }
                }
            case 6:
                if (this.f2979d.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.f2979d.getApplicationContext();
                    synchronized (c.f2959f) {
                        if (!c.f2959f.f2963e) {
                            application.registerActivityLifecycleCallbacks(c.f2959f);
                            application.registerComponentCallbacks(c.f2959f);
                            c.f2959f.f2963e = true;
                        }
                    }
                    c cVar = c.f2959f;
                    v vVar = new v(this);
                    if (cVar != null) {
                        synchronized (c.f2959f) {
                            cVar.f2962d.add(vVar);
                        }
                        c cVar2 = c.f2959f;
                        if (!cVar2.f2961c.get()) {
                            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                            ActivityManager.getMyMemoryState(runningAppProcessInfo);
                            if (!cVar2.f2961c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                                cVar2.f2960b.set(true);
                            }
                        }
                        if (!cVar2.f2960b.get()) {
                            this.f2978c = 300000;
                            break;
                        }
                    } else {
                        throw null;
                    }
                }
                break;
            case 7:
                g((c.b.a.a.d.k.d) message.obj);
                break;
            case 9:
                if (this.i.containsKey(message.obj)) {
                    a<?> aVar5 = this.i.get(message.obj);
                    t.x(g.this.m);
                    if (aVar5.i) {
                        aVar5.n();
                        break;
                    }
                }
                break;
            case 10:
                for (b<?> bVar2 : this.l) {
                    a<?> remove = this.i.remove(bVar2);
                    if (remove != null) {
                        remove.b();
                    }
                }
                this.l.clear();
                break;
            case 11:
                if (this.i.containsKey(message.obj)) {
                    a<?> aVar6 = this.i.get(message.obj);
                    t.x(g.this.m);
                    if (aVar6.i) {
                        aVar6.r();
                        g gVar = g.this;
                        Status status2 = gVar.f2980e.c(gVar.f2979d) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error.");
                        t.x(g.this.m);
                        aVar6.f(status2, null, false);
                        aVar6.f2984b.disconnect("Timing out connection while resuming.");
                        break;
                    }
                }
                break;
            case 12:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).h(true);
                    break;
                }
                break;
            case 14:
                t tVar = (t) message.obj;
                b<?> bVar3 = tVar.f3048a;
                if (!this.i.containsKey(bVar3)) {
                    jVar = tVar.f3049b;
                    tresult = (TResult) Boolean.FALSE;
                } else {
                    boolean h2 = this.i.get(bVar3).h(false);
                    jVar = tVar.f3049b;
                    tresult = (TResult) Boolean.valueOf(h2);
                }
                jVar.f4109a.i(tresult);
                break;
            case 15:
                b bVar4 = (b) message.obj;
                if (this.i.containsKey(bVar4.f2990a)) {
                    a<?> aVar7 = this.i.get(bVar4.f2990a);
                    if (aVar7.j.contains(bVar4) && !aVar7.i) {
                        if (!aVar7.f2984b.isConnected()) {
                            aVar7.n();
                            break;
                        } else {
                            aVar7.q();
                            break;
                        }
                    }
                }
                break;
            case 16:
                b bVar5 = (b) message.obj;
                if (this.i.containsKey(bVar5.f2990a)) {
                    a<?> aVar8 = this.i.get(bVar5.f2990a);
                    if (aVar8.j.remove(bVar5)) {
                        g.this.m.removeMessages(15, bVar5);
                        g.this.m.removeMessages(16, bVar5);
                        c.b.a.a.d.c cVar3 = bVar5.f2991b;
                        ArrayList arrayList = new ArrayList(aVar8.f2983a.size());
                        for (g0 g0Var : aVar8.f2983a) {
                            if ((g0Var instanceof u) && (f2 = ((u) g0Var).f(aVar8)) != null) {
                                int length = f2.length;
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        i5 = -1;
                                    } else if (!t.j1(f2[i5], cVar3)) {
                                        i5++;
                                    }
                                }
                                if (i5 >= 0) {
                                    arrayList.add(g0Var);
                                }
                            }
                        }
                        int size = arrayList.size();
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            g0 g0Var2 = (g0) obj;
                            aVar8.f2983a.remove(g0Var2);
                            g0Var2.d(new n(cVar3));
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
