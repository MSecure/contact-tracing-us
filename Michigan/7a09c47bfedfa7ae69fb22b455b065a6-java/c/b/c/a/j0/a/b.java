package c.b.c.a.j0.a;

import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.r0;

public abstract class b<MessageType extends r0> implements y0<MessageType> {
    static {
        q.a();
    }

    @Override // c.b.c.a.j0.a.y0
    public Object a(i iVar, q qVar) {
        k1 k1Var;
        try {
            i.g gVar = (i.g) iVar;
            j f2 = j.f(gVar.f4940e, gVar.w(), gVar.size(), true);
            r0 r0Var = (r0) b(f2, null);
            try {
                f2.a(0);
                if (r0Var == null || r0Var.isInitialized()) {
                    return r0Var;
                }
                if (r0Var instanceof a) {
                    a aVar = (a) r0Var;
                    k1Var = new k1();
                } else {
                    k1Var = new k1();
                }
                throw new b0(k1Var.getMessage());
            } catch (b0 e2) {
                throw e2;
            }
        } catch (b0 e3) {
            throw e3;
        }
    }
}
