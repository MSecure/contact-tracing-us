package c.b.a.a.c.k;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import b.b.k.i;
import b.l.d.q;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.a.d;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.o.b;
import c.b.a.a.c.k.o.g;
import c.b.a.a.c.k.o.g0;
import c.b.a.a.c.k.o.h0;
import c.b.a.a.c.k.o.h1;
import c.b.a.a.c.k.o.i1;
import c.b.a.a.c.k.o.j;
import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.l0;
import c.b.a.a.c.k.o.m;
import c.b.a.a.c.k.o.n;
import c.b.a.a.c.k.o.p;
import c.b.a.a.c.k.o.r;
import c.b.a.a.c.k.o.u;
import c.b.a.a.c.k.o.x;
import c.b.a.a.c.k.o.x0;
import c.b.a.a.c.k.o.y0;
import c.b.a.a.c.k.o.z0;
import c.b.a.a.c.l.c;
import c.b.a.a.g.h;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Scope;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;

public class d<O extends a.d> {
    public final a<O> mApi;
    public final Context mContext;
    public final int mId;
    public final String zabj;
    public final O zabk;
    public final b<O> zabl;
    public final Looper zabm;
    public final e zabn;
    public final p zabo;
    public final g zabp;

    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final a f2305c = new C0057a().a();

        /* renamed from: a  reason: collision with root package name */
        public final p f2306a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f2307b;

        /* renamed from: c.b.a.a.c.k.d$a$a  reason: collision with other inner class name */
        public static class C0057a {

            /* renamed from: a  reason: collision with root package name */
            public p f2308a;

            /* renamed from: b  reason: collision with root package name */
            public Looper f2309b;

            public a a() {
                if (this.f2308a == null) {
                    this.f2308a = new c.b.a.a.c.k.o.a();
                }
                if (this.f2309b == null) {
                    this.f2309b = Looper.getMainLooper();
                }
                return new a(this.f2308a, null, this.f2309b);
            }
        }

        public a(p pVar, Account account, Looper looper) {
            this.f2306a = pVar;
            this.f2307b = looper;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007f, code lost:
        if (r1 != false) goto L_0x0081;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c1, code lost:
        if (r0 != null) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d4, code lost:
        if (r1 != false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x006b, code lost:
        if (r0 != null) goto L_0x00f4;
     */
    public d(Activity activity, a<O> aVar, O o, a aVar2) {
        i1 i1Var;
        j jVar;
        Fragment fragment;
        i.j.t(activity, "Null activity is not permitted.");
        i.j.t(aVar, "Api must not be null.");
        i.j.t(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = activity.getApplicationContext();
        this.zabj = zaa(activity);
        this.mApi = aVar;
        this.zabk = o;
        this.zabm = aVar2.f2307b;
        this.zabl = new b<>(aVar, o);
        this.zabn = new g0(this);
        g c2 = g.c(this.mContext);
        this.zabp = c2;
        this.mId = c2.e();
        this.zabo = aVar2.f2306a;
        if (!(activity instanceof GoogleApiActivity)) {
            g gVar = this.zabp;
            b<O> bVar = this.zabl;
            i.j.t(activity, "Activity must not be null");
            if (activity instanceof b.l.d.d) {
                b.l.d.d dVar = (b.l.d.d) activity;
                WeakReference<i1> weakReference = i1.f2367e.get(dVar);
                if (weakReference != null) {
                    j jVar2 = (i1) weakReference.get();
                    i1Var = jVar2;
                }
                try {
                    Fragment fragment2 = (i1) dVar.getSupportFragmentManager().J("SupportLifecycleFragmentImpl");
                    if (fragment2 != null) {
                        boolean isRemoving = fragment2.isRemoving();
                        fragment = fragment2;
                    }
                    Fragment i1Var2 = new i1();
                    q supportFragmentManager = dVar.getSupportFragmentManager();
                    if (supportFragmentManager != null) {
                        b.l.d.a aVar3 = new b.l.d.a(supportFragmentManager);
                        aVar3.g(0, i1Var2, "SupportLifecycleFragmentImpl", 1);
                        aVar3.m(true);
                        fragment = i1Var2;
                        i1.f2367e.put(dVar, new WeakReference<>(fragment));
                        i1Var = fragment;
                    } else {
                        throw null;
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
                }
            } else {
                WeakReference<h1> weakReference2 = h1.f2360e.get(activity);
                if (weakReference2 != null) {
                    j jVar3 = (h1) weakReference2.get();
                    i1Var = jVar3;
                }
                try {
                    h1 h1Var = (h1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                    if (h1Var != null) {
                        boolean isRemoving2 = h1Var.isRemoving();
                        jVar = h1Var;
                    }
                    h1 h1Var2 = new h1();
                    activity.getFragmentManager().beginTransaction().add(h1Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                    jVar = h1Var2;
                    h1.f2360e.put(activity, new WeakReference<>(jVar));
                    i1Var = jVar;
                } catch (ClassCastException e3) {
                    throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e3);
                }
            }
            u uVar = (u) i1Var.b("ConnectionlessLifecycleHelper", u.class);
            uVar = uVar == null ? new u(i1Var) : uVar;
            uVar.h = gVar;
            i.j.t(bVar, "ApiKey cannot be null");
            uVar.g.add(bVar);
            gVar.b(uVar);
        }
        Handler handler = this.zabp.m;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    public e asGoogleApiClient() {
        return this.zabn;
    }

    public c.a createClientSettingsBuilder() {
        GoogleSignInAccount a2;
        GoogleSignInAccount a3;
        c.a aVar = new c.a();
        O o = this.zabk;
        Account account = null;
        if (!(o instanceof a.d.b) || (a3 = ((a.d.b) o).a()) == null) {
            O o2 = this.zabk;
            if (o2 instanceof a.d.AbstractC0056a) {
                account = ((a.d.AbstractC0056a) o2).b();
            }
        } else if (a3.f4427e != null) {
            account = new Account(a3.f4427e, "com.google");
        }
        aVar.f2436a = account;
        O o3 = this.zabk;
        Set<Scope> emptySet = (!(o3 instanceof a.d.b) || (a2 = ((a.d.b) o3).a()) == null) ? Collections.emptySet() : a2.p();
        if (aVar.f2437b == null) {
            aVar.f2437b = new b.e.c<>();
        }
        aVar.f2437b.addAll(emptySet);
        aVar.f2440e = this.mContext.getClass().getName();
        aVar.f2439d = this.mContext.getPackageName();
        return aVar;
    }

    public h<Boolean> disconnectService() {
        g gVar = this.zabp;
        if (gVar != null) {
            x xVar = new x(getApiKey());
            Handler handler = gVar.m;
            handler.sendMessage(handler.obtainMessage(14, xVar));
            return xVar.f2408b.f2856a;
        }
        throw null;
    }

    public <A extends a.b, T extends c.b.a.a.c.k.o.d<? extends i, A>> T doBestEffortWrite(T t) {
        return (T) zaa(2, t);
    }

    public <TResult, A extends a.b> h<TResult> doBestEffortWrite(c.b.a.a.c.k.o.q<A, TResult> qVar) {
        return zaa(2, qVar);
    }

    public <A extends a.b, T extends c.b.a.a.c.k.o.d<? extends i, A>> T doRead(T t) {
        return (T) zaa(0, t);
    }

    public <TResult, A extends a.b> h<TResult> doRead(c.b.a.a.c.k.o.q<A, TResult> qVar) {
        return zaa(0, qVar);
    }

    @Deprecated
    public <A extends a.b, T extends m<A, ?>, U extends r<A, ?>> h<Void> doRegisterEventListener(T t, U u) {
        i.j.s(t);
        i.j.s(u);
        i.j.t(t.getListenerKey(), "Listener has already been released.");
        i.j.t(u.getListenerKey(), "Listener has already been released.");
        i.j.k(t.getListenerKey().equals(u.getListenerKey()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zabp.a(this, t, u, p.f2416b);
    }

    public <A extends a.b> h<Void> doRegisterEventListener(n<A, ?> nVar) {
        i.j.s(nVar);
        throw null;
    }

    public h<Boolean> doUnregisterEventListener(k.a<?> aVar) {
        i.j.t(aVar, "Listener key cannot be null.");
        g gVar = this.zabp;
        if (gVar != null) {
            c.b.a.a.g.i iVar = new c.b.a.a.g.i();
            y0 y0Var = new y0(aVar, iVar);
            Handler handler = gVar.m;
            handler.sendMessage(handler.obtainMessage(13, new h0(y0Var, gVar.h.get(), this)));
            return iVar.f2856a;
        }
        throw null;
    }

    public <A extends a.b, T extends c.b.a.a.c.k.o.d<? extends i, A>> T doWrite(T t) {
        return (T) zaa(1, t);
    }

    public <TResult, A extends a.b> h<TResult> doWrite(c.b.a.a.c.k.o.q<A, TResult> qVar) {
        return zaa(1, qVar);
    }

    public final a<O> getApi() {
        return this.mApi;
    }

    public b<O> getApiKey() {
        return this.zabl;
    }

    public O getApiOptions() {
        return this.zabk;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public String getContextFeatureId() {
        return this.zabj;
    }

    public final int getInstanceId() {
        return this.mId;
    }

    public Looper getLooper() {
        return this.zabm;
    }

    public <L> k<L> registerListener(L l, String str) {
        Looper looper = this.zabm;
        i.j.t(l, "Listener must not be null");
        i.j.t(looper, "Looper must not be null");
        i.j.t(str, "Listener type must not be null");
        return new k<>(looper, l, str);
    }

    public a.f zaa(Looper looper, g.a<O> aVar) {
        c a2 = createClientSettingsBuilder().a();
        a<O> aVar2 = this.mApi;
        i.j.v(aVar2.f2301a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return aVar2.f2301a.buildClient(this.mContext, looper, a2, this.zabk, (e.a) aVar, (e.b) aVar);
    }

    public l0 zaa(Context context, Handler handler) {
        return new l0(context, handler, createClientSettingsBuilder().a());
    }

    private final <A extends a.b, T extends c.b.a.a.c.k.o.d<? extends i, A>> T zaa(int i, T t) {
        t.zas();
        g gVar = this.zabp;
        x0 x0Var = new x0(i, t);
        Handler handler = gVar.m;
        handler.sendMessage(handler.obtainMessage(4, new h0(x0Var, gVar.h.get(), this)));
        return t;
    }

    private final <TResult, A extends a.b> h<TResult> zaa(int i, c.b.a.a.c.k.o.q<A, TResult> qVar) {
        c.b.a.a.g.i iVar = new c.b.a.a.g.i();
        g gVar = this.zabp;
        p pVar = this.zabo;
        if (gVar != null) {
            z0 z0Var = new z0(i, qVar, iVar, pVar);
            Handler handler = gVar.m;
            handler.sendMessage(handler.obtainMessage(4, new h0(z0Var, gVar.h.get(), this)));
            return iVar.f2856a;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    public static String zaa(Object obj) {
        boolean z;
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 29) {
            if ((Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'R' && Build.VERSION.CODENAME.charAt(0) <= 'Z') || (Build.VERSION.CODENAME.equals("REL") && Build.VERSION.SDK_INT >= 30) || (Build.VERSION.CODENAME.length() == 1 && Build.VERSION.CODENAME.charAt(0) >= 'R' && Build.VERSION.CODENAME.charAt(0) <= 'Z')) {
                Boolean bool = c.b.a.a.c.n.c.f2496d;
                if (bool == null) {
                    try {
                        if (!"google".equals(Build.BRAND) || Integer.parseInt(Build.VERSION.INCREMENTAL) < 5954562) {
                            z2 = false;
                        }
                        c.b.a.a.c.n.c.f2496d = Boolean.valueOf(z2);
                    } catch (NumberFormatException unused) {
                        c.b.a.a.c.n.c.f2496d = Boolean.TRUE;
                    }
                    c.b.a.a.c.n.c.f2496d.booleanValue();
                    bool = c.b.a.a.c.n.c.f2496d;
                }
                z = bool.booleanValue();
                if (z) {
                    return null;
                }
                try {
                    return (String) Context.class.getMethod("getFeatureId", new Class[0]).invoke(obj, new Object[0]);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return null;
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @Deprecated
    public d(Activity activity, a<O> aVar, O o, p pVar) {
        this(activity, (a) aVar, (a.d) o, new a(pVar, null, r0));
        i.j.t(pVar, "StatusExceptionMapper must not be null.");
        Looper mainLooper = activity.getMainLooper();
        i.j.t(mainLooper, "Looper must not be null.");
    }

    public d(Context context, a<O> aVar, Looper looper) {
        i.j.t(context, "Null context is not permitted.");
        i.j.t(aVar, "Api must not be null.");
        i.j.t(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.zabj = zaa(context);
        this.mApi = aVar;
        this.zabk = null;
        this.zabm = looper;
        this.zabl = new b<>(aVar);
        this.zabn = new g0(this);
        g c2 = g.c(this.mContext);
        this.zabp = c2;
        this.mId = c2.e();
        this.zabo = new c.b.a.a.c.k.o.a();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public d(Context context, a<O> aVar, O o, Looper looper, p pVar) {
        this(context, aVar, o, new a(pVar, null, looper));
        i.j.t(looper, "Looper must not be null.");
        i.j.t(pVar, "StatusExceptionMapper must not be null.");
    }

    public d(Context context, a<O> aVar, O o, a aVar2) {
        i.j.t(context, "Null context is not permitted.");
        i.j.t(aVar, "Api must not be null.");
        i.j.t(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.mContext = context.getApplicationContext();
        this.zabj = zaa(context);
        this.mApi = aVar;
        this.zabk = o;
        this.zabm = aVar2.f2307b;
        this.zabl = new b<>(aVar, o);
        this.zabn = new g0(this);
        g c2 = g.c(this.mContext);
        this.zabp = c2;
        this.mId = c2.e();
        this.zabo = aVar2.f2306a;
        Handler handler = this.zabp.m;
        handler.sendMessage(handler.obtainMessage(7, this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public d(Context context, a<O> aVar, O o, p pVar) {
        this(context, aVar, o, new a(pVar == null ? new c.b.a.a.c.k.o.a() : pVar, null, Looper.getMainLooper()));
        i.j.t(pVar, "StatusExceptionMapper must not be null.");
    }
}
