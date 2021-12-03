package f.b.a.c.b.m;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Scope;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.l.d;
import f.b.a.c.b.l.l.j;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public abstract class f<T extends IInterface> extends b<T> implements a.e {
    public final Set<Scope> w;
    public final Account x;

    /* JADX WARNING: Illegal instructions before constructor call */
    public f(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull int i2, @RecentlyNonNull c cVar, @RecentlyNonNull d dVar, @RecentlyNonNull j jVar) {
        super(context, looper, r4, r5, i2, new r(dVar), new s(jVar), cVar.f2627f);
        synchronized (g.a) {
            if (g.b == null) {
                g.b = new d0(context.getApplicationContext());
            }
        }
        g gVar = g.b;
        Object obj = f.b.a.c.b.d.c;
        f.b.a.c.b.d dVar2 = f.b.a.c.b.d.f2575d;
        Objects.requireNonNull(dVar, "null reference");
        Objects.requireNonNull(jVar, "null reference");
        this.x = cVar.a;
        Set<Scope> set = cVar.c;
        for (Scope scope : set) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.w = set;
    }

    @Override // f.b.a.c.b.l.a.e
    public Set<Scope> g() {
        return l() ? this.w : Collections.emptySet();
    }
}
