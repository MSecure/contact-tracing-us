package f.b.c.k.x;

import f.b.a.c.i.a;
import f.b.a.c.i.h;
import f.b.c.k.g;
import h.a.c1;
import h.a.d1;
import h.a.e1;
import java.util.Comparator;
/* loaded from: classes.dex */
public final /* synthetic */ class q implements a {
    public static final q a = new q();

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    @Override // f.b.a.c.i.a
    /* Code decompiled incorrectly, please refer to instructions dump */
    public Object a(h hVar) {
        c1 c1Var;
        Comparator comparator = r.a;
        if (hVar.o()) {
            return (Void) hVar.l();
        }
        Exception k2 = hVar.k();
        if (k2 instanceof d1) {
            c1Var = ((d1) k2).b;
        } else {
            if (k2 instanceof e1) {
                c1Var = ((e1) k2).b;
            }
            if (!(k2 instanceof g)) {
                throw k2;
            }
            throw new g(k2.getMessage(), g.a.UNKNOWN, k2);
        }
        k2 = r.b(c1Var);
        if (!(k2 instanceof g)) {
        }
    }
}
