package f.b.a.a.a.r;

import f.b.a.c.b.o.b;
import f.b.c.a;
import f.b.c.k.f;
import f.b.c.k.i;

public class v {
    public f a(a aVar) {
        f fVar;
        if (aVar == null) {
            return null;
        }
        a b = a.b();
        b.C(b, "Provided FirebaseApp must not be null.");
        b.a();
        i iVar = (i) b.f2947d.a(i.class);
        b.C(iVar, "Firestore component is not present.");
        synchronized (iVar) {
            fVar = iVar.a.get("(default)");
            if (fVar == null) {
                fVar = f.a(iVar.c, iVar.b, iVar.f2996d, "(default)", iVar, iVar.f2997e);
                iVar.a.put("(default)", fVar);
            }
        }
        return fVar;
    }
}
