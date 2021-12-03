package l.b.a.v;

import g.b.a.c.c.d;
import java.util.Locale;
import l.b.a.q;
import l.b.a.r;
import l.b.a.u.b;
import l.b.a.u.m;
import l.b.a.x.a;
import l.b.a.x.e;
import l.b.a.x.j;
import l.b.a.x.k;
import l.b.a.x.l;
import l.b.a.y.f;
import l.b.a.y.g;

public final class h {
    public e a;
    public Locale b;
    public j c;

    /* renamed from: d  reason: collision with root package name */
    public int f4481d;

    public h(e eVar, c cVar) {
        r rVar;
        l.b.a.u.h hVar = cVar.f4443f;
        q qVar = cVar.f4444g;
        if (!(hVar == null && qVar == null)) {
            l.b.a.u.h hVar2 = (l.b.a.u.h) eVar.c(k.b);
            q qVar2 = (q) eVar.c(k.a);
            b bVar = null;
            hVar = d.h(hVar2, hVar) ? null : hVar;
            qVar = d.h(qVar2, qVar) ? null : qVar;
            if (!(hVar == null && qVar == null)) {
                l.b.a.u.h hVar3 = hVar != null ? hVar : hVar2;
                qVar2 = qVar != null ? qVar : qVar2;
                if (qVar != null) {
                    if (eVar.f(a.INSTANT_SECONDS)) {
                        eVar = (hVar3 == null ? m.f4408d : hVar3).s(l.b.a.e.s(eVar), qVar);
                    } else {
                        try {
                            f s = qVar.s();
                            if (s.e()) {
                                rVar = s.a(l.b.a.e.f4356d);
                                r rVar2 = (r) eVar.c(k.f4523e);
                                if ((rVar instanceof r) && rVar2 != null && !rVar.equals(rVar2)) {
                                    throw new l.b.a.b("Invalid override zone for temporal: " + qVar + " " + eVar);
                                }
                            }
                        } catch (g unused) {
                        }
                        rVar = qVar;
                        r rVar22 = (r) eVar.c(k.f4523e);
                        throw new l.b.a.b("Invalid override zone for temporal: " + qVar + " " + eVar);
                    }
                }
                if (hVar != null) {
                    if (eVar.f(a.EPOCH_DAY)) {
                        bVar = hVar3.c(eVar);
                    } else if (!(hVar == m.f4408d && hVar2 == null)) {
                        a[] values = a.values();
                        for (int i2 = 0; i2 < 30; i2++) {
                            a aVar = values[i2];
                            if (aVar.a() && eVar.f(aVar)) {
                                throw new l.b.a.b("Invalid override chronology for temporal: " + hVar + " " + eVar);
                            }
                        }
                    }
                }
                eVar = new g(bVar, eVar, hVar3, qVar2);
            }
        }
        this.a = eVar;
        this.b = cVar.b;
        this.c = cVar.c;
    }

    public void a() {
        this.f4481d--;
    }

    public Long b(j jVar) {
        try {
            return Long.valueOf(this.a.i(jVar));
        } catch (l.b.a.b e2) {
            if (this.f4481d > 0) {
                return null;
            }
            throw e2;
        }
    }

    public <R> R c(l<R> lVar) {
        R r = (R) this.a.c(lVar);
        if (r != null || this.f4481d != 0) {
            return r;
        }
        StringBuilder h2 = f.a.a.a.a.h("Unable to extract value: ");
        h2.append(this.a.getClass());
        throw new l.b.a.b(h2.toString());
    }

    public String toString() {
        return this.a.toString();
    }
}
