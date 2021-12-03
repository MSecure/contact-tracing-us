package f.b.a.a.a.u;

import f.b.a.c.b.o.b;
import f.b.c.a;
import f.b.c.k.f;
import f.b.c.k.i;

public class m {
    public f a(a aVar) {
        f fVar;
        if (aVar == null) {
            return null;
        }
        a b = a.b();
        b.B(b, "Provided FirebaseApp must not be null.");
        b.a();
        i iVar = (i) b.f3146d.a(i.class);
        b.B(iVar, "Firestore component is not present.");
        synchronized (iVar) {
            fVar = iVar.a.get("(default)");
            if (fVar == null) {
                fVar = f.a(iVar.c, iVar.b, iVar.f3195d, "(default)", iVar, iVar.f3196e);
                iVar.a.put("(default)", fVar);
            }
        }
        return fVar;
    }
}
