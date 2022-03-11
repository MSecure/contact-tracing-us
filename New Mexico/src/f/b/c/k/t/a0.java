package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.g.a.f;
import f.b.c.k.u.p.e;
import f.b.c.k.w.t0;
import f.b.c.k.x.r;
import f.b.g.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public final class a0 implements e0 {
    public f<c> b;

    /* renamed from: e */
    public final b0 f3584e;
    public final List<f.b.c.k.u.p.f> a = new ArrayList();
    public int c = 1;

    /* renamed from: d */
    public j f3583d = t0.s;

    public a0(b0 b0Var) {
        this.f3584e = b0Var;
        List emptyList = Collections.emptyList();
        int i2 = c.c;
        this.b = new f<>(emptyList, a.a);
    }

    @Override // f.b.c.k.t.e0
    public j a() {
        return this.f3583d;
    }

    @Override // f.b.c.k.t.e0
    public void b(f.b.c.k.u.p.f fVar, j jVar) {
        int i2 = fVar.a;
        int l2 = l(i2, "acknowledged");
        b.P0(l2 == 0, "Can only acknowledge the first batch in the mutation queue", new Object[0]);
        f.b.c.k.u.p.f fVar2 = this.a.get(l2);
        b.P0(i2 == fVar2.a, "Queue ordering failure: expected batch %d, got batch %d", Integer.valueOf(i2), Integer.valueOf(fVar2.a));
        Objects.requireNonNull(jVar);
        this.f3583d = jVar;
    }

    @Override // f.b.c.k.t.e0
    public void c() {
        if (this.a.isEmpty()) {
            b.P0(this.b.b.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty.", new Object[0]);
        }
    }

    @Override // f.b.c.k.t.e0
    public f.b.c.k.u.p.f d(int i2) {
        int k2 = k(i2 + 1);
        if (k2 < 0) {
            k2 = 0;
        }
        if (this.a.size() > k2) {
            return this.a.get(k2);
        }
        return null;
    }

    @Override // f.b.c.k.t.e0
    public List<f.b.c.k.u.p.f> e(Iterable<f.b.c.k.u.f> iterable) {
        f<Integer> fVar = new f<>(Collections.emptyList(), r.a);
        for (f.b.c.k.u.f fVar2 : iterable) {
            Iterator<Map.Entry<c, Void>> m = this.b.b.m(new c(fVar2, 0));
            while (m.hasNext()) {
                c key = m.next().getKey();
                if (!fVar2.equals(key.a)) {
                    break;
                }
                fVar = fVar.h(Integer.valueOf(key.b));
            }
        }
        return m(fVar);
    }

    @Override // f.b.c.k.t.e0
    public f.b.c.k.u.p.f f(d dVar, List<e> list, List<e> list2) {
        boolean z = true;
        b.P0(!list2.isEmpty(), "Mutation batches should not be empty", new Object[0]);
        int i2 = this.c;
        this.c = i2 + 1;
        int size = this.a.size();
        if (size > 0) {
            if (this.a.get(size - 1).a >= i2) {
                z = false;
            }
            b.P0(z, "Mutation batchIds must be monotonically increasing order", new Object[0]);
        }
        f.b.c.k.u.p.f fVar = new f.b.c.k.u.p.f(i2, dVar, list, list2);
        this.a.add(fVar);
        for (e eVar : list2) {
            f<c> fVar2 = this.b;
            this.b = new f<>(fVar2.b.l(new c(eVar.a, i2), null));
            this.f3584e.c.a.a(eVar.a.b.q());
        }
        return fVar;
    }

    @Override // f.b.c.k.t.e0
    public void g(j jVar) {
        Objects.requireNonNull(jVar);
        this.f3583d = jVar;
    }

    @Override // f.b.c.k.t.e0
    public List<f.b.c.k.u.p.f> h() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // f.b.c.k.t.e0
    public f.b.c.k.u.p.f i(int i2) {
        int k2 = k(i2);
        if (k2 < 0 || k2 >= this.a.size()) {
            return null;
        }
        f.b.c.k.u.p.f fVar = this.a.get(k2);
        b.P0(fVar.a == i2, "If found batch must match", new Object[0]);
        return fVar;
    }

    @Override // f.b.c.k.t.e0
    public void j(f.b.c.k.u.p.f fVar) {
        b.P0(l(fVar.a, "removed") == 0, "Can only remove the first entry of the mutation queue", new Object[0]);
        this.a.remove(0);
        f<c> fVar2 = this.b;
        for (e eVar : fVar.f3628d) {
            f.b.c.k.u.f fVar3 = eVar.a;
            this.f3584e.f3587f.h(fVar3);
            fVar2 = fVar2.i(new c(fVar3, fVar.a));
        }
        this.b = fVar2;
    }

    public final int k(int i2) {
        if (this.a.isEmpty()) {
            return 0;
        }
        return i2 - this.a.get(0).a;
    }

    public final int l(int i2, String str) {
        int k2 = k(i2);
        b.P0(k2 >= 0 && k2 < this.a.size(), "Batches must exist to be %s", str);
        return k2;
    }

    public final List<f.b.c.k.u.p.f> m(f<Integer> fVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = fVar.iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (!aVar.hasNext()) {
                return arrayList;
            }
            f.b.c.k.u.p.f i2 = i(((Integer) aVar.next()).intValue());
            if (i2 != null) {
                arrayList.add(i2);
            }
        }
    }

    @Override // f.b.c.k.t.e0
    public void start() {
        if (this.a.isEmpty()) {
            this.c = 1;
        }
    }
}
