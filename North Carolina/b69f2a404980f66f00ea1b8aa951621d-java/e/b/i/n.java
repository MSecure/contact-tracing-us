package e.b.i;

import c.a.a.a.a;
import e.b.h.b;
import e.b.h.c;
import e.b.h.d;
import e.b.h.f;
import e.b.h.g;
import e.b.h.i;
import e.b.h.o;
import e.b.h.p;
import e.b.i.i;
import java.io.Reader;

public class n extends m {
    @Override // e.b.i.m
    public f b() {
        return f.f4883d;
    }

    @Override // e.b.i.m
    public void c(Reader reader, String str, g gVar) {
        super.c(reader, str, gVar);
        this.f4925e.add(this.f4924d);
        this.f4924d.j.i = f.a.EnumC0115a.xml;
    }

    @Override // e.b.i.m
    public boolean e(i iVar) {
        i iVar2;
        p D;
        int ordinal = iVar.f4893a.ordinal();
        if (ordinal != 0) {
            i iVar3 = null;
            if (ordinal == 1) {
                i.h hVar = (i.h) iVar;
                h a2 = h.a(hVar.p(), this.h);
                b bVar = hVar.j;
                if (bVar != null) {
                    bVar.m(this.h);
                }
                f fVar = this.h;
                b bVar2 = hVar.j;
                fVar.a(bVar2);
                e.b.h.i iVar4 = new e.b.h.i(a2, null, bVar2);
                a().B(iVar4);
                if (!hVar.i) {
                    this.f4925e.add(iVar4);
                } else if (!h.k.containsKey(a2.f4889b)) {
                    a2.g = true;
                }
            } else if (ordinal == 2) {
                String b2 = this.h.b(((i.g) iVar).f4902b);
                int size = this.f4925e.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    e.b.h.i iVar5 = this.f4925e.get(size);
                    if (iVar5.s().equals(b2)) {
                        iVar3 = iVar5;
                        break;
                    }
                }
                if (iVar3 != null) {
                    int size2 = this.f4925e.size();
                    do {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        iVar2 = this.f4925e.get(size2);
                        this.f4925e.remove(size2);
                    } while (iVar2 != iVar3);
                }
            } else if (ordinal == 3) {
                i.d dVar = (i.d) iVar;
                d dVar2 = new d(dVar.k());
                if (dVar.f4897d && dVar2.E() && (D = dVar2.D()) != null) {
                    dVar2 = D;
                }
                a().B(dVar2);
            } else if (ordinal == 4) {
                i.c cVar = (i.c) iVar;
                String str = cVar.f4894b;
                a().B(cVar instanceof i.b ? new c(str) : new o(str));
            } else if (ordinal != 5) {
                StringBuilder g = a.g("Unexpected token type: ");
                g.append(iVar.f4893a);
                throw new IllegalArgumentException(g.toString());
            }
        } else {
            i.e eVar = (i.e) iVar;
            g gVar = new g(this.h.b(eVar.f4898b.toString()), eVar.f4900d.toString(), eVar.f4901e.toString());
            String str2 = eVar.f4899c;
            if (str2 != null) {
                gVar.d("pubSysKey", str2);
            }
            a().B(gVar);
        }
        return true;
    }
}
