package c.b.a.a.c.l;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import b.b.k.i;
import c.b.a.a.c.c;
import c.b.a.a.c.d;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.o.f;
import c.b.a.a.c.k.o.l;
import c.b.a.a.c.l.b;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Set;

public abstract class g<T extends IInterface> extends b<T> implements a.f {
    public final Set<Scope> mScopes;
    public final c zaex;
    public final Account zax;

    public g(Context context, Handler handler, int i, c cVar) {
        this(context, handler, h.b(context), d.f2290d, i, cVar, (e.a) null, (e.b) null);
    }

    @Deprecated
    public g(Context context, Handler handler, h hVar, d dVar, int i, c cVar, e.a aVar, e.b bVar) {
        this(context, handler, hVar, dVar, i, cVar, (f) aVar, (l) bVar);
    }

    @Deprecated
    public g(Context context, Looper looper, int i, c cVar, e.a aVar, e.b bVar) {
        this(context, looper, i, cVar, (f) aVar, (l) bVar);
    }

    public g(Context context, Looper looper, h hVar, d dVar, int i, c cVar, e.a aVar, e.b bVar) {
        this(context, looper, hVar, dVar, i, cVar, (f) aVar, (l) bVar);
    }

    public static b.a zaa(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new w(fVar);
    }

    public static b.AbstractC0059b zaa(l lVar) {
        if (lVar == null) {
            return null;
        }
        return new v(lVar);
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

    @Override // c.b.a.a.c.l.b
    public final Account getAccount() {
        return this.zax;
    }

    public final c getClientSettings() {
        return this.zaex;
    }

    @Override // c.b.a.a.c.l.b, c.b.a.a.c.k.a.f
    public int getMinApkVersion() {
        return super.getMinApkVersion();
    }

    public c[] getRequiredFeatures() {
        return new c[0];
    }

    @Override // c.b.a.a.c.l.b
    public final Set<Scope> getScopes() {
        return this.mScopes;
    }

    @Override // c.b.a.a.c.k.a.f
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.mScopes : Collections.emptySet();
    }

    public Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }

    public g(Context context, Handler handler, h hVar, d dVar, int i, c cVar, f fVar, l lVar) {
        super(context, handler, hVar, dVar, i, zaa(fVar), zaa(lVar));
        i.j.s(cVar);
        this.zaex = cVar;
        this.zax = cVar.f2431a;
        this.mScopes = zaa(cVar.f2433c);
    }

    public g(Context context, Looper looper, int i, c cVar) {
        this(context, looper, h.b(context), d.f2290d, i, cVar, (e.a) null, (e.b) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public g(Context context, Looper looper, int i, c cVar, f fVar, l lVar) {
        this(context, looper, r3, r4, i, cVar, fVar, lVar);
        h b2 = h.b(context);
        d dVar = d.f2290d;
        i.j.s(fVar);
        i.j.s(lVar);
    }

    public g(Context context, Looper looper, h hVar, d dVar, int i, c cVar, f fVar, l lVar) {
        super(context, looper, hVar, dVar, i, zaa(fVar), zaa(lVar), cVar.f);
        this.zaex = cVar;
        this.zax = cVar.f2431a;
        this.mScopes = zaa(cVar.f2433c);
    }
}
