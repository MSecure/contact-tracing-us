package g.b.a.u;

import b.x.t;
import g.b.a.d;
import g.b.a.p;
import g.b.a.q;
import g.b.a.t.b;
import g.b.a.t.m;
import g.b.a.w.a;
import g.b.a.w.e;
import g.b.a.w.j;
import g.b.a.w.k;
import g.b.a.w.l;
import g.b.a.x.f;
import g.b.a.x.g;
import java.util.Locale;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public e f6591a;

    /* renamed from: b  reason: collision with root package name */
    public Locale f6592b;

    /* renamed from: c  reason: collision with root package name */
    public j f6593c;

    /* renamed from: d  reason: collision with root package name */
    public int f6594d;

    public h(e eVar, c cVar) {
        q qVar;
        g.b.a.t.h hVar = cVar.f6520f;
        p pVar = cVar.f6521g;
        if (!(hVar == null && pVar == null)) {
            g.b.a.t.h hVar2 = (g.b.a.t.h) eVar.f(k.f6657b);
            p pVar2 = (p) eVar.f(k.f6656a);
            b bVar = null;
            hVar = t.n1(hVar2, hVar) ? null : hVar;
            pVar = t.n1(pVar2, pVar) ? null : pVar;
            if (!(hVar == null && pVar == null)) {
                g.b.a.t.h hVar3 = hVar != null ? hVar : hVar2;
                pVar2 = pVar != null ? pVar : pVar2;
                if (pVar != null) {
                    if (eVar.k(a.INSTANT_SECONDS)) {
                        eVar = (hVar3 == null ? m.f6476d : hVar3).B(d.B(eVar), pVar);
                    } else {
                        try {
                            f B = pVar.B();
                            if (B.e()) {
                                qVar = B.a(d.f6403d);
                                q qVar2 = (q) eVar.f(k.f6660e);
                                if ((qVar instanceof q) && qVar2 != null && !qVar.equals(qVar2)) {
                                    throw new g.b.a.a("Invalid override zone for temporal: " + pVar + " " + eVar);
                                }
                            }
                        } catch (g unused) {
                        }
                        qVar = pVar;
                        q qVar22 = (q) eVar.f(k.f6660e);
                        throw new g.b.a.a("Invalid override zone for temporal: " + pVar + " " + eVar);
                    }
                }
                if (hVar != null) {
                    if (eVar.k(a.EPOCH_DAY)) {
                        bVar = hVar3.f(eVar);
                    } else if (!(hVar == m.f6476d && hVar2 == null)) {
                        a[] values = a.values();
                        for (a aVar : values) {
                            if (aVar.b() && eVar.k(aVar)) {
                                throw new g.b.a.a("Invalid override chronology for temporal: " + hVar + " " + eVar);
                            }
                        }
                    }
                }
                eVar = new g(bVar, eVar, hVar3, pVar2);
            }
        }
        this.f6591a = eVar;
        this.f6592b = cVar.f6516b;
        this.f6593c = cVar.f6517c;
    }

    public void a() {
        this.f6594d--;
    }

    public Long b(j jVar) {
        try {
            return Long.valueOf(this.f6591a.n(jVar));
        } catch (g.b.a.a e2) {
            if (this.f6594d > 0) {
                return null;
            }
            throw e2;
        }
    }

    public <R> R c(l<R> lVar) {
        R r = (R) this.f6591a.f(lVar);
        if (r != null || this.f6594d != 0) {
            return r;
        }
        StringBuilder h = c.a.a.a.a.h("Unable to extract value: ");
        h.append(this.f6591a.getClass());
        throw new g.b.a.a(h.toString());
    }

    public String toString() {
        return this.f6591a.toString();
    }
}
