package e.d.a;

import e.d.a.a;

public class b implements d {
    public final e a(c cVar) {
        return (e) ((a.C0024a) cVar).a;
    }

    public void b(c cVar, float f2) {
        e a = a(cVar);
        a.C0024a aVar = (a.C0024a) cVar;
        boolean useCompatPadding = a.this.getUseCompatPadding();
        boolean a2 = aVar.a();
        if (!(f2 == a.f1164e && a.f1165f == useCompatPadding && a.f1166g == a2)) {
            a.f1164e = f2;
            a.f1165f = useCompatPadding;
            a.f1166g = a2;
            a.c(null);
            a.invalidateSelf();
        }
        c(cVar);
    }

    public void c(c cVar) {
        a.C0024a aVar = (a.C0024a) cVar;
        if (!a.this.getUseCompatPadding()) {
            aVar.b(0, 0, 0, 0);
            return;
        }
        float f2 = a(cVar).f1164e;
        float f3 = a(cVar).a;
        int ceil = (int) Math.ceil((double) f.a(f2, f3, aVar.a()));
        int ceil2 = (int) Math.ceil((double) f.b(f2, f3, aVar.a()));
        aVar.b(ceil, ceil2, ceil, ceil2);
    }
}
