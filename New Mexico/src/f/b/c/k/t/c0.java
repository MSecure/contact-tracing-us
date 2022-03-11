package f.b.c.k.t;

import android.util.Pair;
import f.b.c.g.a.b;
import f.b.c.g.a.d;
import f.b.c.k.u.e;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.m;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class c0 implements k0 {
    public d<f, Pair<i, m>> a;
    public final b0 b;

    public c0(b0 b0Var) {
        f.b.c.g.a.f<f> fVar = f.c;
        e eVar = e.a;
        int i2 = d.a.a;
        this.a = new b(eVar);
        this.b = b0Var;
    }

    @Override // f.b.c.k.t.k0
    public void a(i iVar, m mVar) {
        f.b.a.c.b.o.b.P0(!mVar.equals(m.c), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        this.a = this.a.l(iVar.a, new Pair<>(iVar, mVar));
        this.b.c.a.a(iVar.a.b.q());
    }

    @Override // f.b.c.k.t.k0
    public i b(f fVar) {
        Pair<i, m> i2 = this.a.i(fVar);
        if (i2 != null) {
            return (i) i2.first;
        }
        return null;
    }

    @Override // f.b.c.k.t.k0
    public void c(f fVar) {
        this.a = this.a.n(fVar);
    }

    @Override // f.b.c.k.t.k0
    public Map<f, i> d(Iterable<f> iterable) {
        HashMap hashMap = new HashMap();
        for (f fVar : iterable) {
            hashMap.put(fVar, b(fVar));
        }
        return hashMap;
    }
}
