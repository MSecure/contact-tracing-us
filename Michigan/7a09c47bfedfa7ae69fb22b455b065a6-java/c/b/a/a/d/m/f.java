package c.b.a.a.d.m;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.x.t;
import c.b.a.a.d.c;
import c.b.a.a.d.d;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.o.l;
import c.b.a.a.d.m.b;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;

public abstract class f<T extends IInterface> extends b<T> implements a.f {
    public final c zaa;
    public final Set<Scope> zab;
    public final Account zac;

    public f(@RecentlyNonNull Context context, @RecentlyNonNull Handler handler, @RecentlyNonNull int i, @RecentlyNonNull c cVar) {
        this(context, handler, g.b(context), d.f2927d, i, cVar, (e.a) null, (e.b) null);
    }

    @Deprecated
    public f(Context context, Handler handler, g gVar, d dVar, int i, c cVar, e.a aVar, e.b bVar) {
        this(context, handler, gVar, dVar, i, cVar, (c.b.a.a.d.k.o.f) null, (l) null);
    }

    @Deprecated
    public f(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull int i, @RecentlyNonNull c cVar, @RecentlyNonNull e.a aVar, @RecentlyNonNull e.b bVar) {
        this(context, looper, i, cVar, (c.b.a.a.d.k.o.f) aVar, (l) bVar);
    }

    public f(Context context, Looper looper, g gVar, d dVar, int i, c cVar, e.a aVar, e.b bVar) {
        this(context, looper, gVar, dVar, i, cVar, (c.b.a.a.d.k.o.f) null, (l) null);
    }

    public static b.a zaa(c.b.a.a.d.k.o.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new t(fVar);
    }

    public static b.AbstractC0066b zaa(l lVar) {
        if (lVar == null) {
            return null;
        }
        return new u(lVar);
    }

    private final Set<Scope> zaa(Set<Scope> set) {
        Set<Scope> validateScopes = validateScopes(set);
        for (Scope scope : validateScopes) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    @Override // c.b.a.a.d.m.b
    @RecentlyNullable
    public final Account getAccount() {
        return this.zac;
    }

    @RecentlyNonNull
    public final c getClientSettings() {
        return this.zaa;
    }

    @RecentlyNonNull
    public c[] getRequiredFeatures() {
        return new c[0];
    }

    @Override // c.b.a.a.d.m.b
    @RecentlyNonNull
    public final Set<Scope> getScopes() {
        return this.zab;
    }

    @Override // c.b.a.a.d.k.a.f
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zab : Collections.emptySet();
    }

    public Set<Scope> validateScopes(@RecentlyNonNull Set<Scope> set) {
        return set;
    }

    public f(Context context, Handler handler, g gVar, d dVar, int i, c cVar, c.b.a.a.d.k.o.f fVar, l lVar) {
        super(context, handler, gVar, dVar, i, zaa((c.b.a.a.d.k.o.f) null), zaa((l) null));
        t.C(cVar);
        this.zaa = cVar;
        this.zac = cVar.f3086a;
        this.zab = zaa(cVar.f3088c);
    }

    public f(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull int i, @RecentlyNonNull c cVar) {
        this(context, looper, g.b(context), d.f2927d, i, cVar, (e.a) null, (e.b) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public f(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull int i, @RecentlyNonNull c cVar, @RecentlyNonNull c.b.a.a.d.k.o.f fVar, @RecentlyNonNull l lVar) {
        this(context, looper, r3, r4, i, cVar, fVar, lVar);
        g b2 = g.b(context);
        d dVar = d.f2927d;
        t.C(fVar);
        t.C(lVar);
    }

    public f(Context context, Looper looper, g gVar, d dVar, int i, c cVar, c.b.a.a.d.k.o.f fVar, l lVar) {
        super(context, looper, gVar, dVar, i, zaa(fVar), zaa(lVar), cVar.f3091f);
        this.zaa = cVar;
        this.zac = cVar.f3086a;
        this.zab = zaa(cVar.f3088c);
    }
}
