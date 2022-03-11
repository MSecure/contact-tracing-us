package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.g.a.f;
import f.b.c.k.u.l;
import f.b.c.k.u.p.e;
import f.b.c.k.u.p.f;
import f.b.c.k.w.t0;
import f.b.c.k.x.r;
import f.b.f.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class a0 implements e0 {
    public final List<f> a = new ArrayList();
    public f.b.c.g.a.f<c> b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public j f3074d;

    /* renamed from: e  reason: collision with root package name */
    public final b0 f3075e;

    public a0(b0 b0Var) {
        this.f3075e = b0Var;
        List emptyList = Collections.emptyList();
        int i2 = c.c;
        this.b = new f.b.c.g.a.f<>(emptyList, a.a);
        this.c = 1;
        this.f3074d = t0.s;
    }

    @Override // f.b.c.k.t.e0
    public j a() {
        return this.f3074d;
    }

    @Override // f.b.c.k.t.e0
    public void b(f fVar, j jVar) {
        int i2 = fVar.a;
        int l2 = l(i2, "acknowledged");
        b.a1(l2 == 0, "Can only acknowledge the first batch in the mutation queue", new Object[0]);
        f fVar2 = this.a.get(l2);
        b.a1(i2 == fVar2.a, "Queue ordering failure: expected batch %d, got batch %d", Integer.valueOf(i2), Integer.valueOf(fVar2.a));
        Objects.requireNonNull(jVar);
        this.f3074d = jVar;
    }

    @Override // f.b.c.k.t.e0
    public void c() {
        if (this.a.isEmpty()) {
            b.a1(this.b.b.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty.", new Object[0]);
        }
    }

    @Override // f.b.c.k.t.e0
    public f d(int i2) {
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
    public List<f> e(Iterable<f.b.c.k.u.f> iterable) {
        f.b.c.g.a.f<Integer> fVar = new f.b.c.g.a.f<>(Collections.emptyList(), r.a);
        for (f.b.c.k.u.f fVar2 : iterable) {
            Iterator<Map.Entry<T, Void>> m = this.b.b.m(new c(fVar2, 0));
            while (m.hasNext()) {
                T key = m.next().getKey();
                if (!fVar2.equals(key.a)) {
                    break;
                }
                fVar = fVar.h(Integer.valueOf(key.b));
            }
        }
        return m(fVar);
    }

    @Override // f.b.c.k.t.e0
    public f f(d dVar, List<e> list, List<e> list2) {
        boolean z = true;
        b.a1(!list2.isEmpty(), "Mutation batches should not be empty", new Object[0]);
        int i2 = this.c;
        this.c = i2 + 1;
        int size = this.a.size();
        if (size > 0) {
            if (this.a.get(size - 1).a >= i2) {
                z = false;
            }
            b.a1(z, "Mutation batchIds must be monotonically increasing order", new Object[0]);
        }
        f fVar = new f(i2, dVar, list, list2);
        this.a.add(fVar);
        for (e eVar : list2) {
            f.b.c.g.a.f<c> fVar2 = this.b;
            this.b = new f.b.c.g.a.f<>(fVar2.b.l(new c(eVar.a, i2), null));
            this.f3075e.c.a.a((l) eVar.a.b.q());
        }
        return fVar;
    }

    @Override // f.b.c.k.t.e0
    public void g(j jVar) {
        Objects.requireNonNull(jVar);
        this.f3074d = jVar;
    }

    @Override // f.b.c.k.t.e0
    public List<f> h() {
        return Collections.unmodifiableList(this.a);
    }

    @Override // f.b.c.k.t.e0
    public f i(int i2) {
        int k2 = k(i2);
        if (k2 < 0 || k2 >= this.a.size()) {
            return null;
        }
        f fVar = this.a.get(k2);
        b.a1(fVar.a == i2, "If found batch must match", new Object[0]);
        return fVar;
    }

    @Override // f.b.c.k.t.e0
    public void j(f fVar) {
        b.a1(l(fVar.a, "removed") == 0, "Can only remove the first entry of the mutation queue", new Object[0]);
        this.a.remove(0);
        f.b.c.g.a.f<c> fVar2 = this.b;
        for (e eVar : fVar.f3119d) {
            f.b.c.k.u.f fVar3 = eVar.a;
            this.f3075e.f3078f.h(fVar3);
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
        b.a1(k2 >= 0 && k2 < this.a.size(), "Batches must exist to be %s", str);
        return k2;
    }

    public final List<f> m(f.b.c.g.a.f<Integer> fVar) {
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
