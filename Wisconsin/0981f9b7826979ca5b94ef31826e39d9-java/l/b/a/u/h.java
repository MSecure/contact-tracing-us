package l.b.a.u;

import java.util.Locale;
import l.b.a.d;
import l.b.a.p;
import l.b.a.q;
import l.b.a.t.b;
import l.b.a.t.m;
import l.b.a.w.a;
import l.b.a.w.e;
import l.b.a.w.j;
import l.b.a.w.k;
import l.b.a.w.l;
import l.b.a.x.f;
import l.b.a.x.g;

public final class h {
    public e a;
    public Locale b;
    public j c;

    /* renamed from: d  reason: collision with root package name */
    public int f4165d;

    public h(e eVar, c cVar) {
        q qVar;
        l.b.a.t.h hVar = cVar.f4127f;
        p pVar = cVar.f4128g;
        if (!(hVar == null && pVar == null)) {
            l.b.a.t.h hVar2 = (l.b.a.t.h) eVar.c(k.b);
            p pVar2 = (p) eVar.c(k.a);
            b bVar = null;
            hVar = f.b.a.c.b.o.b.v0(hVar2, hVar) ? null : hVar;
            pVar = f.b.a.c.b.o.b.v0(pVar2, pVar) ? null : pVar;
            if (!(hVar == null && pVar == null)) {
                l.b.a.t.h hVar3 = hVar != null ? hVar : hVar2;
                pVar2 = pVar != null ? pVar : pVar2;
                if (pVar != null) {
                    if (eVar.f(a.INSTANT_SECONDS)) {
                        eVar = (hVar3 == null ? m.f4092d : hVar3).s(d.s(eVar), pVar);
                    } else {
                        try {
                            f s = pVar.s();
                            if (s.e()) {
                                qVar = s.a(d.f4040d);
                                q qVar2 = (q) eVar.c(k.f4207e);
                                if ((qVar instanceof q) && qVar2 != null && !qVar.equals(qVar2)) {
                                    throw new l.b.a.a("Invalid override zone for temporal: " + pVar + " " + eVar);
                                }
                            }
                        } catch (g unused) {
                        }
                        qVar = pVar;
                        q qVar22 = (q) eVar.c(k.f4207e);
                        throw new l.b.a.a("Invalid override zone for temporal: " + pVar + " " + eVar);
                    }
                }
                if (hVar != null) {
                    if (eVar.f(a.EPOCH_DAY)) {
                        bVar = hVar3.c(eVar);
                    } else if (!(hVar == m.f4092d && hVar2 == null)) {
                        a[] values = a.values();
                        for (int i2 = 0; i2 < 30; i2++) {
                            a aVar = values[i2];
                            if (aVar.a() && eVar.f(aVar)) {
                                throw new l.b.a.a("Invalid override chronology for temporal: " + hVar + " " + eVar);
                            }
                        }
                    }
                }
                eVar = new g(bVar, eVar, hVar3, pVar2);
            }
        }
        this.a = eVar;
        this.b = cVar.b;
        this.c = cVar.c;
    }

    public void a() {
        this.f4165d--;
    }

    public Long b(j jVar) {
        try {
            return Long.valueOf(this.a.i(jVar));
        } catch (l.b.a.a e2) {
            if (this.f4165d > 0) {
                return null;
            }
            throw e2;
        }
    }

    public <R> R c(l<R> lVar) {
        R r = (R) this.a.c(lVar);
        if (r != null || this.f4165d != 0) {
            return r;
        }
        StringBuilder h2 = f.a.a.a.a.h("Unable to extract value: ");
        h2.append(this.a.getClass());
        throw new l.b.a.a(h2.toString());
    }

    public String toString() {
        return this.a.toString();
    }
}
