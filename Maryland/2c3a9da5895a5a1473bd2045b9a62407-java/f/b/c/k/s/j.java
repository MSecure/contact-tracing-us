package f.b.c.k.s;

import f.b.a.c.i.i;
import f.b.c.d;
import f.b.c.k.t.k;
import f.b.c.k.t.r;
import f.b.c.k.t.t;
import f.b.c.k.u.p.e;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final /* synthetic */ class j implements Runnable {
    public final n b;
    public final List c;

    /* renamed from: d  reason: collision with root package name */
    public final i f3141d;

    public j(n nVar, List list, i iVar) {
        this.b = nVar;
        this.c = list;
        this.f3141d = iVar;
    }

    public void run() {
        n nVar = this.b;
        List<e> list = this.c;
        i<Void> iVar = this.f3141d;
        b0 b0Var = nVar.f3150d;
        b0Var.g("writeMutations");
        r rVar = b0Var.a;
        Objects.requireNonNull(rVar);
        d dVar = new d(new Date());
        HashSet hashSet = new HashSet();
        for (e eVar : list) {
            hashSet.add(eVar.a);
        }
        t tVar = (t) rVar.a.g("Locally write mutations", new k(rVar, hashSet, list, dVar));
        int i2 = tVar.a;
        Map<Integer, i<Void>> map = b0Var.f3109j.get(b0Var.m);
        if (map == null) {
            map = new HashMap<>();
            b0Var.f3109j.put(b0Var.m, map);
        }
        map.put(Integer.valueOf(i2), iVar);
        b0Var.h(tVar.b, null);
        b0Var.b.c();
    }
}
