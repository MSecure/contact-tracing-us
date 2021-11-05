package e.c.a.u;

import c.b.a.a.c.n.c;
import e.c.a.d;
import e.c.a.p;
import e.c.a.q;
import e.c.a.t.b;
import e.c.a.t.m;
import e.c.a.w.a;
import e.c.a.w.e;
import e.c.a.w.j;
import e.c.a.w.k;
import e.c.a.w.l;
import e.c.a.x.f;
import e.c.a.x.g;
import java.util.Locale;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public e f5123a;

    /* renamed from: b  reason: collision with root package name */
    public Locale f5124b;

    /* renamed from: c  reason: collision with root package name */
    public j f5125c;

    /* renamed from: d  reason: collision with root package name */
    public int f5126d;

    public h(e eVar, c cVar) {
        q qVar;
        e.c.a.t.h hVar = cVar.f;
        p pVar = cVar.g;
        if (!(hVar == null && pVar == null)) {
            e.c.a.t.h hVar2 = (e.c.a.t.h) eVar.f(k.f5178b);
            p pVar2 = (p) eVar.f(k.f5177a);
            b bVar = null;
            hVar = c.L0(hVar2, hVar) ? null : hVar;
            pVar = c.L0(pVar2, pVar) ? null : pVar;
            if (!(hVar == null && pVar == null)) {
                e.c.a.t.h hVar3 = hVar != null ? hVar : hVar2;
                pVar2 = pVar != null ? pVar : pVar2;
                if (pVar != null) {
                    if (eVar.i(a.INSTANT_SECONDS)) {
                        eVar = (hVar3 == null ? m.f5027d : hVar3).v(d.t(eVar), pVar);
                    } else {
                        try {
                            f v = pVar.v();
                            if (v.e()) {
                                qVar = v.a(d.f4966d);
                                q qVar2 = (q) eVar.f(k.f5181e);
                                if ((qVar instanceof q) && qVar2 != null && !qVar.equals(qVar2)) {
                                    throw new e.c.a.a("Invalid override zone for temporal: " + pVar + " " + eVar);
                                }
                            }
                        } catch (g unused) {
                        }
                        qVar = pVar;
                        q qVar22 = (q) eVar.f(k.f5181e);
                        throw new e.c.a.a("Invalid override zone for temporal: " + pVar + " " + eVar);
                    }
                }
                if (hVar != null) {
                    if (eVar.i(a.EPOCH_DAY)) {
                        bVar = hVar3.f(eVar);
                    } else if (!(hVar == m.f5027d && hVar2 == null)) {
                        a[] values = a.values();
                        for (a aVar : values) {
                            if (aVar.b() && eVar.i(aVar)) {
                                throw new e.c.a.a("Invalid override chronology for temporal: " + hVar + " " + eVar);
                            }
                        }
                    }
                }
                eVar = new g(bVar, eVar, hVar3, pVar2);
            }
        }
        this.f5123a = eVar;
        this.f5124b = cVar.f5059b;
        this.f5125c = cVar.f5060c;
    }

    public void a() {
        this.f5126d--;
    }

    public Long b(j jVar) {
        try {
            return Long.valueOf(this.f5123a.l(jVar));
        } catch (e.c.a.a e2) {
            if (this.f5126d > 0) {
                return null;
            }
            throw e2;
        }
    }

    public <R> R c(l<R> lVar) {
        R r = (R) this.f5123a.f(lVar);
        if (r != null || this.f5126d != 0) {
            return r;
        }
        StringBuilder g = c.a.a.a.a.g("Unable to extract value: ");
        g.append(this.f5123a.getClass());
        throw new e.c.a.a(g.toString());
    }

    public String toString() {
        return this.f5123a.toString();
    }
}
