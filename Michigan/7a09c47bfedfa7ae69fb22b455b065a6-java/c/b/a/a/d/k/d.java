package c.b.a.a.d.k;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.fragment.app.Fragment;
import b.l.d.m;
import b.l.d.z;
import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.a.d;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.o.b;
import c.b.a.a.d.k.o.c0;
import c.b.a.a.d.k.o.d0;
import c.b.a.a.d.k.o.f1;
import c.b.a.a.d.k.o.g;
import c.b.a.a.d.k.o.i0;
import c.b.a.a.d.k.o.j;
import c.b.a.a.d.k.o.j1;
import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.k1;
import c.b.a.a.d.k.o.n;
import c.b.a.a.d.k.o.p;
import c.b.a.a.d.k.o.r;
import c.b.a.a.d.k.o.s;
import c.b.a.a.d.k.o.s0;
import c.b.a.a.d.k.o.u0;
import c.b.a.a.d.k.o.w0;
import c.b.a.a.d.m.c;
import c.b.a.a.j.i;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

public class d<O extends a.d> {
    public final Context zaa;
    public final String zab;
    public final a<O> zac;
    public final O zad;
    public final b<O> zae;
    public final Looper zaf;
    public final int zag;
    @NotOnlyInitialized
    public final e zah;
    public final p zai;
    public final g zaj;

    public static class a {
        @RecentlyNonNull

        /* renamed from: c  reason: collision with root package name */
        public static final a f2942c = new C0064a().a();
        @RecentlyNonNull

        /* renamed from: a  reason: collision with root package name */
        public final p f2943a;
        @RecentlyNonNull

        /* renamed from: b  reason: collision with root package name */
        public final Looper f2944b;

        /* renamed from: c.b.a.a.d.k.d$a$a  reason: collision with other inner class name */
        public static class C0064a {

            /* renamed from: a  reason: collision with root package name */
            public p f2945a;

            /* renamed from: b  reason: collision with root package name */
            public Looper f2946b;

            @RecentlyNonNull
            public a a() {
                if (this.f2945a == null) {
                    this.f2945a = new c.b.a.a.d.k.o.a();
                }
                if (this.f2946b == null) {
                    this.f2946b = Looper.getMainLooper();
                }
                return new a(this.f2945a, null, this.f2946b);
            }
        }

        public a(p pVar, Account account, Looper looper) {
            this.f2943a = pVar;
            this.f2944b = looper;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008b, code lost:
        if (r1 != false) goto L_0x008d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cd, code lost:
        if (r0 != null) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e0, code lost:
        if (r1 != false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0077, code lost:
        if (r0 != null) goto L_0x0100;
     */
    public d(@RecentlyNonNull Activity activity, @RecentlyNonNull a<O> aVar, @RecentlyNonNull O o, @RecentlyNonNull a aVar2) {
        k1 k1Var;
        j jVar;
        Fragment fragment;
        t.D(activity, "Null activity is not permitted.");
        t.D(aVar, "Api must not be null.");
        t.D(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zaa = activity.getApplicationContext();
        this.zab = zaa(activity);
        this.zac = aVar;
        this.zad = o;
        this.zaf = aVar2.f2944b;
        this.zae = new b<>(aVar, o);
        this.zah = new c0(this);
        g a2 = g.a(this.zaa);
        this.zaj = a2;
        this.zag = a2.f2982g.getAndIncrement();
        this.zai = aVar2.f2943a;
        if (!(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            g gVar = this.zaj;
            b<O> bVar = this.zae;
            t.D(activity, "Activity must not be null");
            if (activity instanceof m) {
                m mVar = (m) activity;
                WeakReference<k1> weakReference = k1.f3025e.get(mVar);
                if (weakReference != null) {
                    j jVar2 = (k1) weakReference.get();
                    k1Var = jVar2;
                }
                try {
                    Fragment fragment2 = (k1) mVar.getSupportFragmentManager().J("SupportLifecycleFragmentImpl");
                    if (fragment2 != null) {
                        boolean isRemoving = fragment2.isRemoving();
                        fragment = fragment2;
                    }
                    Fragment k1Var2 = new k1();
                    z supportFragmentManager = mVar.getSupportFragmentManager();
                    if (supportFragmentManager != null) {
                        b.l.d.a aVar3 = new b.l.d.a(supportFragmentManager);
                        aVar3.g(0, k1Var2, "SupportLifecycleFragmentImpl", 1);
                        aVar3.l(true);
                        fragment = k1Var2;
                        k1.f3025e.put(mVar, new WeakReference<>(fragment));
                        k1Var = fragment;
                    } else {
                        throw null;
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
                }
            } else {
                WeakReference<j1> weakReference2 = j1.f3014e.get(activity);
                if (weakReference2 != null) {
                    j jVar3 = (j1) weakReference2.get();
                    k1Var = jVar3;
                }
                try {
                    j1 j1Var = (j1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                    if (j1Var != null) {
                        boolean isRemoving2 = j1Var.isRemoving();
                        jVar = j1Var;
                    }
                    j1 j1Var2 = new j1();
                    activity.getFragmentManager().beginTransaction().add(j1Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                    jVar = j1Var2;
                    j1.f3014e.put(activity, new WeakReference<>(jVar));
                    k1Var = jVar;
                } catch (ClassCastException e3) {
                    throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e3);
                }
            }
            f1 f1Var = (f1) k1Var.b("ConnectionlessLifecycleHelper", f1.class);
            f1Var = f1Var == null ? new f1(k1Var, gVar) : f1Var;
            t.D(bVar, "ApiKey cannot be null");
            f1Var.f2975g.add(bVar);
            gVar.c(f1Var);
        }
        Handler handler = this.zaj.m;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    @RecentlyNonNull
    public e asGoogleApiClient() {
        return this.zah;
    }

    @RecentlyNonNull
    public c.a createClientSettingsBuilder() {
        GoogleSignInAccount b2;
        GoogleSignInAccount b3;
        c.a aVar = new c.a();
        O o = this.zad;
        Account account = null;
        if (!(o instanceof a.d.b) || (b3 = ((a.d.b) o).b()) == null) {
            O o2 = this.zad;
            if (o2 instanceof a.d.AbstractC0063a) {
                account = ((a.d.AbstractC0063a) o2).a();
            }
        } else if (b3.f5973e != null) {
            account = new Account(b3.f5973e, "com.google");
        }
        aVar.f3093a = account;
        O o3 = this.zad;
        Set<Scope> emptySet = (!(o3 instanceof a.d.b) || (b2 = ((a.d.b) o3).b()) == null) ? Collections.emptySet() : b2.t();
        if (aVar.f3094b == null) {
            aVar.f3094b = new b.e.c<>();
        }
        aVar.f3094b.addAll(emptySet);
        aVar.f3096d = this.zaa.getClass().getName();
        aVar.f3095c = this.zaa.getPackageName();
        return aVar;
    }

    @RecentlyNonNull
    public i<Boolean> disconnectService() {
        g gVar = this.zaj;
        if (gVar != null) {
            c.b.a.a.d.k.o.t tVar = new c.b.a.a.d.k.o.t(getApiKey());
            Handler handler = gVar.m;
            handler.sendMessage(handler.obtainMessage(14, tVar));
            return tVar.f3049b.f4109a;
        }
        throw null;
    }

    @RecentlyNonNull
    public <A extends a.b, T extends c.b.a.a.d.k.o.d<? extends i, A>> T doBestEffortWrite(@RecentlyNonNull T t) {
        return (T) zaa(2, t);
    }

    @RecentlyNonNull
    public <TResult, A extends a.b> i<TResult> doBestEffortWrite(@RecentlyNonNull r<A, TResult> rVar) {
        return zaa(2, rVar);
    }

    @RecentlyNonNull
    public <A extends a.b, T extends c.b.a.a.d.k.o.d<? extends i, A>> T doRead(@RecentlyNonNull T t) {
        return (T) zaa(0, t);
    }

    @RecentlyNonNull
    public <TResult, A extends a.b> i<TResult> doRead(@RecentlyNonNull r<A, TResult> rVar) {
        return zaa(0, rVar);
    }

    @RecentlyNonNull
    @Deprecated
    public <A extends a.b, T extends c.b.a.a.d.k.o.m<A, ?>, U extends s<A, ?>> i<Void> doRegisterEventListener(@RecentlyNonNull T t, @RecentlyNonNull U u) {
        t.C(t);
        t.C(u);
        t.D(t.getListenerKey(), "Listener has already been released.");
        t.D(u.getListenerKey(), "Listener has already been released.");
        t.r(t.j1(t.getListenerKey(), u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaj.b(this, t, u, p.f3068b);
    }

    @RecentlyNonNull
    public <A extends a.b> i<Void> doRegisterEventListener(@RecentlyNonNull n<A, ?> nVar) {
        t.C(nVar);
        throw null;
    }

    @RecentlyNonNull
    public i<Boolean> doUnregisterEventListener(@RecentlyNonNull k.a<?> aVar) {
        t.D(aVar, "Listener key cannot be null.");
        g gVar = this.zaj;
        if (gVar != null) {
            c.b.a.a.j.j jVar = new c.b.a.a.j.j();
            w0 w0Var = new w0(aVar, jVar);
            Handler handler = gVar.m;
            handler.sendMessage(handler.obtainMessage(13, new d0(w0Var, gVar.h.get(), this)));
            return jVar.f4109a;
        }
        throw null;
    }

    @RecentlyNonNull
    public <A extends a.b, T extends c.b.a.a.d.k.o.d<? extends i, A>> T doWrite(@RecentlyNonNull T t) {
        return (T) zaa(1, t);
    }

    @RecentlyNonNull
    public <TResult, A extends a.b> i<TResult> doWrite(@RecentlyNonNull r<A, TResult> rVar) {
        return zaa(1, rVar);
    }

    @RecentlyNonNull
    public b<O> getApiKey() {
        return this.zae;
    }

    @RecentlyNonNull
    public O getApiOptions() {
        return this.zad;
    }

    @RecentlyNonNull
    public Context getApplicationContext() {
        return this.zaa;
    }

    @RecentlyNullable
    public String getContextAttributionTag() {
        return this.zab;
    }

    @RecentlyNullable
    @Deprecated
    public String getContextFeatureId() {
        return this.zab;
    }

    @RecentlyNonNull
    public Looper getLooper() {
        return this.zaf;
    }

    @RecentlyNonNull
    public <L> k<L> registerListener(@RecentlyNonNull L l, @RecentlyNonNull String str) {
        Looper looper = this.zaf;
        t.D(l, "Listener must not be null");
        t.D(looper, "Looper must not be null");
        t.D(str, "Listener type must not be null");
        return new k<>(looper, l, str);
    }

    @RecentlyNonNull
    public final int zaa() {
        return this.zag;
    }

    public final a.f zaa(Looper looper, g.a<O> aVar) {
        c a2 = createClientSettingsBuilder().a();
        a.AbstractC0062a<?, O> aVar2 = this.zac.f2938a;
        t.C(aVar2);
        return aVar2.buildClient(this.zaa, looper, a2, this.zad, (e.a) aVar, (e.b) aVar);
    }

    public final i0 zaa(Context context, Handler handler) {
        return new i0(context, handler, createClientSettingsBuilder().a());
    }

    private final <A extends a.b, T extends c.b.a.a.d.k.o.d<? extends i, A>> T zaa(int i, T t) {
        t.zab();
        g gVar = this.zaj;
        if (gVar != null) {
            s0 s0Var = new s0(i, t);
            Handler handler = gVar.m;
            handler.sendMessage(handler.obtainMessage(4, new d0(s0Var, gVar.h.get(), this)));
            return t;
        }
        throw null;
    }

    private final <TResult, A extends a.b> i<TResult> zaa(int i, r<A, TResult> rVar) {
        c.b.a.a.j.j jVar = new c.b.a.a.j.j();
        g gVar = this.zaj;
        p pVar = this.zai;
        if (gVar != null) {
            u0 u0Var = new u0(i, rVar, jVar, pVar);
            Handler handler = gVar.m;
            handler.sendMessage(handler.obtainMessage(4, new d0(u0Var, gVar.h.get(), this)));
            return jVar.f4109a;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    public static String zaa(Object obj) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 29) {
            if (Build.VERSION.SDK_INT < 30 || !Build.VERSION.CODENAME.equals("REL")) {
                if (Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'R' && Build.VERSION.CODENAME.charAt(0) <= 'Z') {
                    Boolean bool = t.f2724e;
                    if (bool == null) {
                        try {
                            if (!"google".equals(Build.BRAND) || Build.ID.startsWith("RPP1") || Build.ID.startsWith("RPP2") || Integer.parseInt(Build.VERSION.INCREMENTAL) < 6301457) {
                                z = false;
                            }
                            t.f2724e = Boolean.valueOf(z);
                        } catch (NumberFormatException unused) {
                            t.f2724e = Boolean.TRUE;
                        }
                        t.f2724e.booleanValue();
                        bool = t.f2724e;
                    }
                    z = bool.booleanValue();
                }
            }
            if (z) {
                return null;
            }
            try {
                return (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return null;
            }
        }
        z = false;
        if (z) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @Deprecated
    public d(@RecentlyNonNull Activity activity, @RecentlyNonNull a<O> aVar, @RecentlyNonNull O o, @RecentlyNonNull p pVar) {
        this(activity, (a) aVar, (a.d) o, new a(pVar, null, r0));
        t.D(pVar, "StatusExceptionMapper must not be null.");
        Looper mainLooper = activity.getMainLooper();
        t.D(mainLooper, "Looper must not be null.");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public d(@RecentlyNonNull Context context, @RecentlyNonNull a<O> aVar, @RecentlyNonNull O o, @RecentlyNonNull Looper looper, @RecentlyNonNull p pVar) {
        this(context, aVar, o, new a(pVar, null, looper));
        t.D(looper, "Looper must not be null.");
        t.D(pVar, "StatusExceptionMapper must not be null.");
    }

    public d(@RecentlyNonNull Context context, @RecentlyNonNull a<O> aVar, @RecentlyNonNull O o, @RecentlyNonNull a aVar2) {
        t.D(context, "Null context is not permitted.");
        t.D(aVar, "Api must not be null.");
        t.D(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.zaa = context.getApplicationContext();
        this.zab = zaa(context);
        this.zac = aVar;
        this.zad = o;
        this.zaf = aVar2.f2944b;
        this.zae = new b<>(aVar, o);
        this.zah = new c0(this);
        g a2 = g.a(this.zaa);
        this.zaj = a2;
        this.zag = a2.f2982g.getAndIncrement();
        this.zai = aVar2.f2943a;
        Handler handler = this.zaj.m;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public d(@RecentlyNonNull Context context, @RecentlyNonNull a<O> aVar, @RecentlyNonNull O o, @RecentlyNonNull p pVar) {
        this(context, aVar, o, new a(pVar == null ? new c.b.a.a.d.k.o.a() : pVar, null, Looper.getMainLooper()));
        t.D(pVar, "StatusExceptionMapper must not be null.");
    }
}
