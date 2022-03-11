package f.b.a.c.b.l;

import android.accounts.Account;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import e.b.a.m;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.a.c;
import f.b.a.c.b.l.l.b;
import f.b.a.c.b.l.l.e;
import f.b.a.c.b.l.l.e0;
import f.b.a.c.b.l.l.l;
import f.b.a.c.b.l.l.u;
import f.b.a.c.b.m.c;
import f.b.a.c.i.h;
import f.b.a.c.i.i;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class c<O extends a.c> {
    public final Context a;
    public final a<O> b;
    public final O c;

    /* renamed from: d */
    public final b<O> f2671d;

    /* renamed from: e */
    public final int f2672e;

    /* renamed from: f */
    public final f.b.a.c.b.l.l.a f2673f;

    /* renamed from: g */
    public final e f2674g;

    /* loaded from: classes.dex */
    public static class a {
        @RecentlyNonNull
        public static final a c = new a(new f.b.a.c.b.l.l.a(), null, Looper.getMainLooper());
        @RecentlyNonNull
        public final f.b.a.c.b.l.l.a a;
        @RecentlyNonNull
        public final Looper b;

        public a(f.b.a.c.b.l.l.a aVar, Account account, Looper looper) {
            this.a = aVar;
            this.b = looper;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public c(@RecentlyNonNull Context context, @RecentlyNonNull a<O> aVar, @RecentlyNonNull O o, @RecentlyNonNull a aVar2) {
        m.e.r(context, "Null context is not permitted.");
        m.e.r(aVar, "Api must not be null.");
        m.e.r(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.a = context.getApplicationContext();
        int i2 = Build.VERSION.SDK_INT;
        boolean z = true;
        if (i2 >= 29) {
            if (i2 < 30 || !Build.VERSION.CODENAME.equals("REL")) {
                String str = Build.VERSION.CODENAME;
                if (str.length() == 1 && str.charAt(0) >= 'R' && str.charAt(0) <= 'Z') {
                    Boolean bool = f.b.a.c.b.o.b.f2760e;
                    if (bool == null) {
                        try {
                            if (!"google".equals(Build.BRAND) || Build.ID.startsWith("RPP1") || Build.ID.startsWith("RPP2") || Integer.parseInt(Build.VERSION.INCREMENTAL) < 6301457) {
                                z = false;
                            }
                            f.b.a.c.b.o.b.f2760e = Boolean.valueOf(z);
                        } catch (NumberFormatException unused) {
                            f.b.a.c.b.o.b.f2760e = Boolean.TRUE;
                        }
                        f.b.a.c.b.o.b.f2760e.booleanValue();
                        bool = f.b.a.c.b.o.b.f2760e;
                    }
                    z = bool.booleanValue();
                }
            }
            if (z) {
                try {
                    String str2 = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                }
            }
            this.b = aVar;
            this.c = null;
            this.f2671d = new b<>(aVar, null);
            e a2 = e.a(this.a);
            this.f2674g = a2;
            this.f2672e = a2.f2680e.getAndIncrement();
            this.f2673f = aVar2.a;
            Handler handler = a2.f2685j;
            handler.sendMessage(handler.obtainMessage(7, this));
        }
        z = false;
        if (z) {
        }
        this.b = aVar;
        this.c = null;
        this.f2671d = new b<>(aVar, null);
        e a22 = e.a(this.a);
        this.f2674g = a22;
        this.f2672e = a22.f2680e.getAndIncrement();
        this.f2673f = aVar2.a;
        Handler handler2 = a22.f2685j;
        handler2.sendMessage(handler2.obtainMessage(7, this));
    }

    @RecentlyNonNull
    public c.a k() {
        GoogleSignInAccount b;
        GoogleSignInAccount b2;
        c.a aVar = new c.a();
        O o = this.c;
        Account account = null;
        if (!(o instanceof a.c.b) || (b2 = ((a.c.b) o).b()) == null) {
            O o2 = this.c;
            if (o2 instanceof a.c.AbstractC0083a) {
                account = ((a.c.AbstractC0083a) o2).a();
            }
        } else if (b2.f450e != null) {
            account = new Account(b2.f450e, "com.google");
        }
        aVar.a = account;
        O o3 = this.c;
        Set<Scope> emptySet = (!(o3 instanceof a.c.b) || (b = ((a.c.b) o3).b()) == null) ? Collections.emptySet() : b.d();
        if (aVar.b == null) {
            aVar.b = new e.f.c<>(0);
        }
        aVar.b.addAll(emptySet);
        aVar.f2725d = this.a.getClass().getName();
        aVar.c = this.a.getPackageName();
        return aVar;
    }

    public final <TResult, A> h<TResult> l(int i2, l<A, TResult> lVar) {
        i iVar = new i();
        e eVar = this.f2674g;
        f.b.a.c.b.l.l.a aVar = this.f2673f;
        Objects.requireNonNull(eVar);
        e0 e0Var = new e0(i2, lVar, iVar, aVar);
        Handler handler = eVar.f2685j;
        handler.sendMessage(handler.obtainMessage(4, new u(e0Var, eVar.f2681f.get(), this)));
        return iVar.a;
    }
}
