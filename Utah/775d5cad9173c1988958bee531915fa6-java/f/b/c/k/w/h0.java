package f.b.c.k.w;

import f.b.c.k.s.c0;
import f.b.c.k.s.i;
import f.b.c.k.s.w;
import f.b.c.k.u.b;
import f.b.c.k.u.f;
import f.b.c.k.u.h;
import f.b.c.k.u.l;
import f.b.c.k.u.p.a;
import f.b.c.k.u.p.c;
import f.b.c.k.u.p.d;
import f.b.c.k.u.p.e;
import f.b.c.k.u.p.j;
import f.b.c.k.u.p.k;
import f.b.c.k.u.p.m;
import f.b.c.k.u.p.n;
import f.b.c.k.u.p.p;
import f.b.d.a.a;
import f.b.d.a.c;
import f.b.d.a.d;
import f.b.d.a.g;
import f.b.d.a.i;
import f.b.d.a.o;
import f.b.d.a.p;
import f.b.d.a.q;
import f.b.d.a.s;
import f.b.d.a.t;
import f.b.g.a0;
import f.b.g.n0;
import f.b.g.p1;
import f.b.g.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class h0 {
    public final b a;
    public final String b;

    public h0(b bVar) {
        this.a = bVar;
        this.b = q(bVar).c();
    }

    public static l q(b bVar) {
        return l.r(Arrays.asList("projects", bVar.b, "databases", bVar.c));
    }

    public static l r(l lVar) {
        f.b.a.c.b.o.b.O0(lVar.n() > 4 && lVar.i(4).equals("documents"), "Tried to deserialize invalid key %s", lVar);
        return (l) lVar.o(5);
    }

    public f a(String str) {
        l d2 = d(str);
        f.b.a.c.b.o.b.O0(d2.i(1).equals(this.a.b), "Tried to deserialize key from different project.", new Object[0]);
        f.b.a.c.b.o.b.O0(d2.i(3).equals(this.a.c), "Tried to deserialize key from different database.", new Object[0]);
        return new f(r(d2));
    }

    public e b(t tVar) {
        k kVar;
        d dVar;
        boolean z = true;
        if (tVar.p()) {
            o i2 = tVar.i();
            int ordinal = i2.e().ordinal();
            if (ordinal == 0) {
                kVar = k.a(i2.g());
            } else if (ordinal == 1) {
                kVar = new k(e(i2.h()), null);
            } else if (ordinal == 2) {
                kVar = k.c;
            } else {
                f.b.a.c.b.o.b.q0("Unknown precondition", new Object[0]);
                throw null;
            }
        } else {
            kVar = k.c;
        }
        int ordinal2 = tVar.k().ordinal();
        if (ordinal2 != 0) {
            if (ordinal2 == 1) {
                return new f.b.c.k.u.p.b(a(tVar.j()), kVar);
            }
            if (ordinal2 == 2) {
                return new p(a(tVar.o()), kVar);
            }
            if (ordinal2 == 3) {
                ArrayList arrayList = new ArrayList();
                for (i.c cVar : tVar.l().g()) {
                    int ordinal3 = cVar.m().ordinal();
                    if (ordinal3 == 0) {
                        f.b.a.c.b.o.b.O0(cVar.l() == i.c.b.REQUEST_TIME, "Unknown transform setToServerValue: %s", cVar.l());
                        dVar = new d(h.r(cVar.i()), f.b.c.k.u.p.l.a);
                    } else if (ordinal3 == 1) {
                        dVar = new d(h.r(cVar.i()), new f.b.c.k.u.p.i(cVar.j()));
                    } else if (ordinal3 == 4) {
                        dVar = new d(h.r(cVar.i()), new a.b(cVar.h().a()));
                    } else if (ordinal3 == 5) {
                        dVar = new d(h.r(cVar.i()), new a.C0115a(cVar.k().a()));
                    } else {
                        f.b.a.c.b.o.b.q0("Unknown FieldTransform proto: %s", cVar);
                        throw null;
                    }
                    arrayList.add(dVar);
                }
                Boolean bool = kVar.b;
                if (bool == null || !bool.booleanValue()) {
                    z = false;
                }
                f.b.a.c.b.o.b.O0(z, "Transforms only support precondition \"exists == true\"", new Object[0]);
                return new n(a(tVar.l().f()), arrayList);
            }
            f.b.a.c.b.o.b.q0("Unknown mutation operation: %d", tVar.k());
            throw null;
        } else if (!tVar.q()) {
            return new m(a(tVar.m().h()), f.b.c.k.u.k.b(tVar.m().g()), kVar);
        } else {
            f a2 = a(tVar.m().h());
            f.b.c.k.u.k b2 = f.b.c.k.u.k.b(tVar.m().g());
            g n = tVar.n();
            int f2 = n.f();
            HashSet hashSet = new HashSet(f2);
            for (int i3 = 0; i3 < f2; i3++) {
                hashSet.add(h.r(n.e(i3)));
            }
            return new j(a2, b2, new c(hashSet), kVar);
        }
    }

    public final l c(String str) {
        l d2 = d(str);
        return d2.n() == 4 ? l.c : r(d2);
    }

    public final l d(String str) {
        l s = l.s(str);
        f.b.a.c.b.o.b.O0(s.n() >= 4 && s.i(0).equals("projects") && s.i(2).equals("databases"), "Tried to deserialize invalid key %s", s);
        return s;
    }

    public f.b.c.k.u.m e(p1 p1Var) {
        if (p1Var.g() == 0 && p1Var.f() == 0) {
            return f.b.c.k.u.m.c;
        }
        return new f.b.c.k.u.m(new f.b.c.d(p1Var.g(), p1Var.f()));
    }

    public final f.b.d.a.c f(f.b.c.k.s.c cVar) {
        c.b g2 = f.b.d.a.c.g();
        List<s> list = cVar.b;
        g2.copyOnWrite();
        f.b.d.a.c.c((f.b.d.a.c) g2.instance, list);
        boolean z = cVar.a;
        g2.copyOnWrite();
        f.b.d.a.c.d((f.b.d.a.c) g2.instance, z);
        return (f.b.d.a.c) g2.build();
    }

    public f.b.d.a.d g(f fVar, f.b.c.k.u.k kVar) {
        d.b j2 = f.b.d.a.d.j();
        String n = n(this.a, fVar.b);
        j2.copyOnWrite();
        f.b.d.a.d.c((f.b.d.a.d) j2.instance, n);
        Map<String, s> f2 = kVar.a.u().f();
        j2.copyOnWrite();
        ((n0) f.b.d.a.d.d((f.b.d.a.d) j2.instance)).putAll(f2);
        return (f.b.d.a.d) j2.build();
    }

    public q.c h(c0 c0Var) {
        q.c.a g2 = q.c.g();
        String l2 = l(c0Var.f3270d);
        g2.copyOnWrite();
        q.c.c((q.c) g2.instance, l2);
        return (q.c) g2.build();
    }

    public final p.g i(h hVar) {
        p.g.a f2 = p.g.f();
        String c = hVar.c();
        f2.copyOnWrite();
        p.g.c((p.g) f2.instance, c);
        return (p.g) f2.build();
    }

    public String j(f fVar) {
        return n(this.a, fVar.b);
    }

    public t k(e eVar) {
        z zVar;
        i.c.a aVar;
        t.b r = t.r();
        if (eVar instanceof m) {
            f.b.d.a.d g2 = g(eVar.a, ((m) eVar).c);
            r.copyOnWrite();
            t.f((t) r.instance, g2);
        } else if (eVar instanceof j) {
            j jVar = (j) eVar;
            f.b.d.a.d g3 = g(eVar.a, jVar.c);
            r.copyOnWrite();
            t.f((t) r.instance, g3);
            f.b.c.k.u.p.c cVar = jVar.f3376d;
            g.b g4 = g.g();
            for (h hVar : cVar.a) {
                String c = hVar.c();
                g4.copyOnWrite();
                g.c((g) g4.instance, c);
            }
            r.copyOnWrite();
            t.d((t) r.instance, (g) g4.build());
        } else if (eVar instanceof n) {
            n nVar = (n) eVar;
            i.b h2 = i.h();
            String j2 = j(nVar.a);
            h2.copyOnWrite();
            i.c((i) h2.instance, j2);
            for (f.b.c.k.u.p.d dVar : nVar.c) {
                f.b.c.k.u.p.o oVar = dVar.b;
                if (oVar instanceof f.b.c.k.u.p.l) {
                    i.c.a n = i.c.n();
                    n.b(dVar.a.c());
                    i.c.b bVar = i.c.b.REQUEST_TIME;
                    n.copyOnWrite();
                    i.c.f((i.c) n.instance, bVar);
                    zVar = n.build();
                } else {
                    if (oVar instanceof a.b) {
                        aVar = i.c.n();
                        aVar.b(dVar.a.c());
                        a.b j3 = f.b.d.a.a.j();
                        List<s> list = ((a.b) oVar).a;
                        j3.copyOnWrite();
                        f.b.d.a.a.d((f.b.d.a.a) j3.instance, list);
                        aVar.copyOnWrite();
                        i.c.c((i.c) aVar.instance, (f.b.d.a.a) j3.build());
                    } else if (oVar instanceof a.C0115a) {
                        aVar = i.c.n();
                        aVar.b(dVar.a.c());
                        a.b j4 = f.b.d.a.a.j();
                        List<s> list2 = ((a.C0115a) oVar).a;
                        j4.copyOnWrite();
                        f.b.d.a.a.d((f.b.d.a.a) j4.instance, list2);
                        aVar.copyOnWrite();
                        i.c.e((i.c) aVar.instance, (f.b.d.a.a) j4.build());
                    } else if (oVar instanceof f.b.c.k.u.p.i) {
                        aVar = i.c.n();
                        aVar.b(dVar.a.c());
                        s sVar = ((f.b.c.k.u.p.i) oVar).a;
                        aVar.copyOnWrite();
                        i.c.g((i.c) aVar.instance, sVar);
                    } else {
                        f.b.a.c.b.o.b.q0("Unknown transform: %s", oVar);
                        throw null;
                    }
                    zVar = aVar.build();
                }
                h2.copyOnWrite();
                i.d((i) h2.instance, (i.c) zVar);
            }
            r.copyOnWrite();
            t.c((t) r.instance, (i) h2.build());
        } else if (eVar instanceof f.b.c.k.u.p.b) {
            String j5 = j(eVar.a);
            r.copyOnWrite();
            t.g((t) r.instance, j5);
        } else if (eVar instanceof f.b.c.k.u.p.p) {
            String j6 = j(eVar.a);
            r.copyOnWrite();
            t.h((t) r.instance, j6);
        } else {
            f.b.a.c.b.o.b.q0("unknown mutation type %s", eVar.getClass());
            throw null;
        }
        if (!eVar.b.b()) {
            k kVar = eVar.b;
            f.b.a.c.b.o.b.O0(!kVar.b(), "Can't serialize an empty precondition", new Object[0]);
            o.b i2 = o.i();
            f.b.c.k.u.m mVar = kVar.a;
            if (mVar != null) {
                p1 p = p(mVar);
                i2.copyOnWrite();
                o.d((o) i2.instance, p);
            } else {
                Boolean bool = kVar.b;
                if (bool != null) {
                    boolean booleanValue = bool.booleanValue();
                    i2.copyOnWrite();
                    o.c((o) i2.instance, booleanValue);
                } else {
                    f.b.a.c.b.o.b.q0("Unknown Precondition", new Object[0]);
                    throw null;
                }
            }
            r.copyOnWrite();
            t.e((t) r.instance, (o) i2.build());
        }
        return (t) r.build();
    }

    public final String l(l lVar) {
        return n(this.a, lVar);
    }

    public q.d m(c0 c0Var) {
        Object obj;
        p.h.a aVar;
        p.f.b bVar;
        p.k.b bVar2;
        q.d.a h2 = q.d.h();
        p.b v = f.b.d.a.p.v();
        l lVar = c0Var.f3270d;
        if (c0Var.f3271e != null) {
            f.b.a.c.b.o.b.O0(lVar.n() % 2 == 0, "Collection Group queries should be within a document path or root.", new Object[0]);
            String n = n(this.a, lVar);
            h2.copyOnWrite();
            q.d.d((q.d) h2.instance, n);
            p.c.a g2 = p.c.g();
            String str = c0Var.f3271e;
            g2.copyOnWrite();
            p.c.c((p.c) g2.instance, str);
            g2.copyOnWrite();
            p.c.d((p.c) g2.instance, true);
            v.copyOnWrite();
            f.b.d.a.p.c((f.b.d.a.p) v.instance, (p.c) g2.build());
        } else {
            f.b.a.c.b.o.b.O0(lVar.n() % 2 != 0, "Document queries with filters are not supported.", new Object[0]);
            String l2 = l((l) lVar.q());
            h2.copyOnWrite();
            q.d.d((q.d) h2.instance, l2);
            p.c.a g3 = p.c.g();
            String h3 = lVar.h();
            g3.copyOnWrite();
            p.c.c((p.c) g3.instance, h3);
            v.copyOnWrite();
            f.b.d.a.p.c((f.b.d.a.p) v.instance, (p.c) g3.build());
        }
        if (c0Var.c.size() > 0) {
            List<f.b.c.k.s.i> list = c0Var.c;
            ArrayList arrayList = new ArrayList(list.size());
            for (f.b.c.k.s.i iVar : list) {
                if (iVar instanceof f.b.c.k.s.h) {
                    f.b.c.k.s.h hVar = (f.b.c.k.s.h) iVar;
                    i.a aVar2 = hVar.a;
                    i.a aVar3 = i.a.EQUAL;
                    if (aVar2 == aVar3 || aVar2 == i.a.NOT_EQUAL) {
                        p.k.a h4 = p.k.h();
                        p.g i2 = i(hVar.c);
                        h4.copyOnWrite();
                        p.k.d((p.k) h4.instance, i2);
                        s sVar = hVar.b;
                        s sVar2 = f.b.c.k.u.o.a;
                        if (sVar != null && Double.isNaN(sVar.r())) {
                            bVar2 = hVar.a == aVar3 ? p.k.b.IS_NAN : p.k.b.IS_NOT_NAN;
                        } else {
                            s sVar3 = hVar.b;
                            if (sVar3 != null && sVar3.y() == s.c.NULL_VALUE) {
                                bVar2 = hVar.a == aVar3 ? p.k.b.IS_NULL : p.k.b.IS_NOT_NULL;
                            }
                        }
                        h4.copyOnWrite();
                        p.k.c((p.k) h4.instance, bVar2);
                        aVar = p.h.k();
                        aVar.copyOnWrite();
                        p.h.c((p.h) aVar.instance, (p.k) h4.build());
                        arrayList.add((p.h) aVar.build());
                    }
                    p.f.a j2 = p.f.j();
                    p.g i3 = i(hVar.c);
                    j2.copyOnWrite();
                    p.f.c((p.f) j2.instance, i3);
                    i.a aVar4 = hVar.a;
                    switch (aVar4.ordinal()) {
                        case 0:
                            bVar = p.f.b.LESS_THAN;
                            break;
                        case 1:
                            bVar = p.f.b.LESS_THAN_OR_EQUAL;
                            break;
                        case 2:
                            bVar = p.f.b.EQUAL;
                            break;
                        case 3:
                            bVar = p.f.b.NOT_EQUAL;
                            break;
                        case 4:
                            bVar = p.f.b.GREATER_THAN;
                            break;
                        case 5:
                            bVar = p.f.b.GREATER_THAN_OR_EQUAL;
                            break;
                        case 6:
                            bVar = p.f.b.ARRAY_CONTAINS;
                            break;
                        case 7:
                            bVar = p.f.b.ARRAY_CONTAINS_ANY;
                            break;
                        case 8:
                            bVar = p.f.b.IN;
                            break;
                        case 9:
                            bVar = p.f.b.NOT_IN;
                            break;
                        default:
                            f.b.a.c.b.o.b.q0("Unknown operator %d", aVar4);
                            throw null;
                    }
                    j2.copyOnWrite();
                    p.f.d((p.f) j2.instance, bVar);
                    s sVar4 = hVar.b;
                    j2.copyOnWrite();
                    p.f.e((p.f) j2.instance, sVar4);
                    aVar = p.h.k();
                    aVar.copyOnWrite();
                    p.h.b((p.h) aVar.instance, (p.f) j2.build());
                    arrayList.add((p.h) aVar.build());
                }
            }
            if (list.size() == 1) {
                obj = arrayList.get(0);
            } else {
                p.d.a h5 = p.d.h();
                p.d.b bVar3 = p.d.b.AND;
                h5.copyOnWrite();
                p.d.c((p.d) h5.instance, bVar3);
                h5.copyOnWrite();
                p.d.d((p.d) h5.instance, arrayList);
                p.h.a k2 = p.h.k();
                k2.copyOnWrite();
                p.h.e((p.h) k2.instance, (p.d) h5.build());
                obj = k2.build();
            }
            v.copyOnWrite();
            f.b.d.a.p.d((f.b.d.a.p) v.instance, (p.h) obj);
        }
        for (w wVar : c0Var.b) {
            p.i.a g4 = p.i.g();
            p.e eVar = wVar.a.equals(w.a.ASCENDING) ? p.e.ASCENDING : p.e.DESCENDING;
            g4.copyOnWrite();
            p.i.d((p.i) g4.instance, eVar);
            p.g i4 = i(wVar.b);
            g4.copyOnWrite();
            p.i.c((p.i) g4.instance, i4);
            v.copyOnWrite();
            f.b.d.a.p.e((f.b.d.a.p) v.instance, (p.i) g4.build());
        }
        if (c0Var.b()) {
            a0.b f2 = a0.f();
            f.b.a.c.b.o.b.O0(c0Var.b(), "Called getLimit when no limit was set", new Object[0]);
            int i5 = (int) c0Var.f3272f;
            f2.copyOnWrite();
            a0.c((a0) f2.instance, i5);
            v.copyOnWrite();
            f.b.d.a.p.h((f.b.d.a.p) v.instance, (a0) f2.build());
        }
        f.b.c.k.s.c cVar = c0Var.f3273g;
        if (cVar != null) {
            f.b.d.a.c f3 = f(cVar);
            v.copyOnWrite();
            f.b.d.a.p.f((f.b.d.a.p) v.instance, f3);
        }
        f.b.c.k.s.c cVar2 = c0Var.f3274h;
        if (cVar2 != null) {
            f.b.d.a.c f4 = f(cVar2);
            v.copyOnWrite();
            f.b.d.a.p.g((f.b.d.a.p) v.instance, f4);
        }
        h2.copyOnWrite();
        q.d.b((q.d) h2.instance, (f.b.d.a.p) v.build());
        return (q.d) h2.build();
    }

    public final String n(b bVar, l lVar) {
        return ((l) ((l) q(bVar).b("documents")).a(lVar)).c();
    }

    public p1 o(f.b.c.d dVar) {
        p1.b h2 = p1.h();
        h2.c(dVar.b);
        h2.b(dVar.c);
        return (p1) h2.build();
    }

    public p1 p(f.b.c.k.u.m mVar) {
        return o(mVar.b);
    }
}
