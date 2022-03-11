package e.e.a;

import e.e.a.a;
/* loaded from: classes.dex */
public class b implements d {
    public final e a(c cVar) {
        return (e) ((a.C0027a) cVar).a;
    }

    public void b(c cVar, float f2) {
        e a = a(cVar);
        a.C0027a aVar = (a.C0027a) cVar;
        boolean useCompatPadding = a.this.getUseCompatPadding();
        boolean a2 = aVar.a();
        if (!(f2 == a.f1282e && a.f1283f == useCompatPadding && a.f1284g == a2)) {
            a.f1282e = f2;
            a.f1283f = useCompatPadding;
            a.f1284g = a2;
            a.c(null);
            a.invalidateSelf();
        }
        c(cVar);
    }

    public void c(c cVar) {
        a.C0027a aVar = (a.C0027a) cVar;
        if (!a.this.getUseCompatPadding()) {
            aVar.b(0, 0, 0, 0);
            return;
        }
        float f2 = a(cVar).f1282e;
        float f3 = a(cVar).a;
        int ceil = (int) Math.ceil((double) f.a(f2, f3, aVar.a()));
        int ceil2 = (int) Math.ceil((double) f.b(f2, f3, aVar.a()));
        aVar.b(ceil, ceil2, ceil, ceil2);
    }
}
