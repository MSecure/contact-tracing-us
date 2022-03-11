package f.b.c.k.t;

import f.b.c.k.s.c0;
import f.b.c.k.s.i;
import f.b.c.k.s.w;
import f.b.c.k.s.x;
import f.b.c.k.u.c;
import f.b.c.k.u.i;
import f.b.c.k.u.j;
import f.b.c.k.u.k;
import f.b.c.k.u.l;
import f.b.c.k.u.m;
import f.b.c.k.u.n;
import f.b.c.k.u.o;
import f.b.c.k.u.p.f;
import f.b.c.k.v.a;
import f.b.c.k.v.b;
import f.b.c.k.v.e;
import f.b.c.k.w.h0;
import f.b.d.a.d;
import f.b.d.a.p;
import f.b.d.a.q;
import f.b.d.a.s;
import f.b.g.p1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public final class h {
    public final h0 a;

    public h(h0 h0Var) {
        this.a = h0Var;
    }

    public i a(a aVar) {
        int ordinal = aVar.h().ordinal();
        if (ordinal == 0) {
            b j2 = aVar.j();
            return new j(this.a.a(j2.f()), this.a.e(j2.g()), aVar.i());
        } else if (ordinal == 1) {
            d g2 = aVar.g();
            return new c(this.a.a(g2.h()), this.a.e(g2.i()), k.b(g2.g()), aVar.i() ? c.a.COMMITTED_MUTATIONS : c.a.SYNCED);
        } else if (ordinal == 2) {
            f.b.c.k.v.d k2 = aVar.k();
            return new n(this.a.a(k2.f()), this.a.e(k2.g()));
        } else {
            f.b.a.c.b.o.b.r0("Unknown MaybeDocument %s", aVar);
            throw null;
        }
    }

    public f b(e eVar) {
        int i2 = eVar.i();
        h0 h0Var = this.a;
        p1 j2 = eVar.j();
        Objects.requireNonNull(h0Var);
        f.b.c.d dVar = new f.b.c.d(j2.g(), j2.f());
        int h2 = eVar.h();
        ArrayList arrayList = new ArrayList(h2);
        for (int i3 = 0; i3 < h2; i3++) {
            arrayList.add(this.a.b(eVar.g(i3)));
        }
        int l2 = eVar.l();
        ArrayList arrayList2 = new ArrayList(l2);
        for (int i4 = 0; i4 < l2; i4++) {
            arrayList2.add(this.a.b(eVar.k(i4)));
        }
        return new f(i2, dVar, arrayList, arrayList2);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x027c  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public d1 c(f.b.c.k.v.c cVar) {
        f.b.g.j jVar;
        c0 c0Var;
        String str;
        l lVar;
        List list;
        int o;
        f.b.c.k.s.c cVar2;
        List list2;
        f.b.c.k.s.c cVar3;
        f.b.c.k.s.c cVar4;
        w.a aVar;
        List<p.h> list3;
        f.b.g.j jVar2;
        Iterator<p.h> it;
        f.b.c.k.s.h hVar;
        i.a aVar2;
        s sVar;
        s sVar2;
        int q = cVar.q();
        m e2 = this.a.e(cVar.p());
        m e3 = this.a.e(cVar.l());
        f.b.g.j o2 = cVar.o();
        long m = cVar.m();
        int ordinal = cVar.r().ordinal();
        if (ordinal == 0) {
            h0 h0Var = this.a;
            q.d n = cVar.n();
            Objects.requireNonNull(h0Var);
            l c = h0Var.c(n.f());
            p g2 = n.g();
            int l2 = g2.l();
            if (l2 > 0) {
                f.b.a.c.b.o.b.P0(l2 == 1, "StructuredQuery.from with more than one collection is not supported.", new Object[0]);
                p.c k2 = g2.k(0);
                boolean e4 = k2.e();
                String f2 = k2.f();
                if (e4) {
                    lVar = c;
                    str = f2;
                    if (!g2.u()) {
                        p.h q2 = g2.q();
                        i.a aVar3 = i.a.NOT_EQUAL;
                        i.a aVar4 = i.a.EQUAL;
                        if (q2.i() == p.h.b.COMPOSITE_FILTER) {
                            f.b.a.c.b.o.b.P0(q2.f().g() == p.d.b.AND, "Only AND-type composite filters are supported, got %d", q2.f().g());
                            list3 = q2.f().f();
                        } else {
                            list3 = Collections.singletonList(q2);
                        }
                        ArrayList arrayList = new ArrayList(list3.size());
                        Iterator<p.h> it2 = list3.iterator();
                        while (it2.hasNext()) {
                            p.h next = it2.next();
                            int ordinal2 = next.i().ordinal();
                            if (ordinal2 != 0) {
                                if (ordinal2 == 1) {
                                    it = it2;
                                    jVar2 = o2;
                                    p.f h2 = next.h();
                                    f.b.c.k.u.h r = f.b.c.k.u.h.r(h2.g().e());
                                    p.f.b h3 = h2.h();
                                    switch (h3.ordinal()) {
                                        case 1:
                                            aVar2 = i.a.LESS_THAN;
                                            break;
                                        case 2:
                                            aVar2 = i.a.LESS_THAN_OR_EQUAL;
                                            break;
                                        case 3:
                                            aVar2 = i.a.GREATER_THAN;
                                            break;
                                        case 4:
                                            aVar2 = i.a.GREATER_THAN_OR_EQUAL;
                                            break;
                                        case 5:
                                            aVar2 = aVar4;
                                            break;
                                        case 6:
                                            aVar2 = aVar3;
                                            break;
                                        case 7:
                                            aVar2 = i.a.ARRAY_CONTAINS;
                                            break;
                                        case 8:
                                            aVar2 = i.a.IN;
                                            break;
                                        case 9:
                                            aVar2 = i.a.ARRAY_CONTAINS_ANY;
                                            break;
                                        case 10:
                                            aVar2 = i.a.NOT_IN;
                                            break;
                                        default:
                                            f.b.a.c.b.o.b.r0("Unhandled FieldFilter.operator %d", h3);
                                            throw null;
                                    }
                                    hVar = f.b.c.k.s.h.b(r, aVar2, h2.i());
                                } else if (ordinal2 == 2) {
                                    p.k j2 = next.j();
                                    f.b.c.k.u.h r2 = f.b.c.k.u.h.r(j2.f().e());
                                    it = it2;
                                    int ordinal3 = j2.g().ordinal();
                                    jVar2 = o2;
                                    if (ordinal3 == 1) {
                                        sVar = o.a;
                                    } else if (ordinal3 != 2) {
                                        if (ordinal3 == 3) {
                                            sVar2 = o.a;
                                        } else if (ordinal3 == 4) {
                                            sVar2 = o.b;
                                        } else {
                                            f.b.a.c.b.o.b.r0("Unrecognized UnaryFilter.operator %d", j2.g());
                                            throw null;
                                        }
                                        hVar = f.b.c.k.s.h.b(r2, aVar3, sVar2);
                                    } else {
                                        sVar = o.b;
                                    }
                                    hVar = f.b.c.k.s.h.b(r2, aVar4, sVar);
                                } else {
                                    f.b.a.c.b.o.b.r0("Unrecognized Filter.filterType %d", next.i());
                                    throw null;
                                }
                                arrayList.add(hVar);
                                it2 = it;
                                o2 = jVar2;
                            } else {
                                f.b.a.c.b.o.b.r0("Nested composite filters are not supported.", new Object[0]);
                                throw null;
                            }
                        }
                        jVar = o2;
                        list = arrayList;
                    } else {
                        jVar = o2;
                        list = Collections.emptyList();
                    }
                    o = g2.o();
                    if (o <= 0) {
                        ArrayList arrayList2 = new ArrayList(o);
                        for (int i2 = 0; i2 < o; i2++) {
                            p.i n2 = g2.n(i2);
                            f.b.c.k.u.h r3 = f.b.c.k.u.h.r(n2.f().e());
                            int ordinal4 = n2.e().ordinal();
                            if (ordinal4 == 1) {
                                aVar = w.a.ASCENDING;
                            } else if (ordinal4 == 2) {
                                aVar = w.a.DESCENDING;
                            } else {
                                f.b.a.c.b.o.b.r0("Unrecognized direction %d", n2.e());
                                throw null;
                            }
                            arrayList2.add(new w(aVar, r3));
                        }
                        cVar2 = null;
                        list2 = arrayList2;
                    } else {
                        cVar2 = null;
                        list2 = Collections.emptyList();
                    }
                    long j3 = -1;
                    if (g2.s()) {
                        j3 = (long) g2.m().e();
                    }
                    if (!g2.t()) {
                        f.b.d.a.c p = g2.p();
                        cVar3 = new f.b.c.k.s.c(p.a(), p.e());
                    } else {
                        cVar3 = cVar2;
                    }
                    if (!g2.r()) {
                        f.b.d.a.c j4 = g2.j();
                        cVar4 = new f.b.c.k.s.c(j4.a(), j4.e());
                    } else {
                        cVar4 = cVar2;
                    }
                    c0Var = new x(lVar, str, list, list2, j3, x.a.LIMIT_TO_FIRST, cVar3, cVar4).d();
                } else {
                    c = c.b(f2);
                }
            }
            lVar = c;
            str = null;
            if (!g2.u()) {
            }
            o = g2.o();
            if (o <= 0) {
            }
            long j32 = -1;
            if (g2.s()) {
            }
            if (!g2.t()) {
            }
            if (!g2.r()) {
            }
            c0Var = new x(lVar, str, list, list2, j32, x.a.LIMIT_TO_FIRST, cVar3, cVar4).d();
        } else if (ordinal == 1) {
            h0 h0Var2 = this.a;
            q.c k3 = cVar.k();
            Objects.requireNonNull(h0Var2);
            int f3 = k3.f();
            f.b.a.c.b.o.b.P0(f3 == 1, "DocumentsTarget contained other than 1 document %d", Integer.valueOf(f3));
            c0Var = x.a(h0Var2.c(k3.e(0))).d();
            jVar = o2;
        } else {
            f.b.a.c.b.o.b.r0("Unknown targetType %d", cVar.r());
            throw null;
        }
        return new d1(c0Var, q, m, h0.LISTEN, e2, e3, jVar);
    }
}
