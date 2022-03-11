package f.b.a.a.a.t;

import f.b.a.c.b.o.b;
import f.b.c.a;
import f.b.c.k.f;
import f.b.c.k.i;

public class w {
    public f a(a aVar) {
        f fVar;
        if (aVar == null) {
            return null;
        }
        a b = a.b();
        b.C(b, "Provided FirebaseApp must not be null.");
        b.a();
        i iVar = (i) b.f3051d.a(i.class);
        b.C(iVar, "Firestore component is not present.");
        synchronized (iVar) {
            fVar = iVar.a.get("(default)");
            if (fVar == null) {
                fVar = f.a(iVar.c, iVar.b, iVar.f3100d, "(default)", iVar, iVar.f3101e);
                iVar.a.put("(default)", fVar);
            }
        }
        return fVar;
    }
}
