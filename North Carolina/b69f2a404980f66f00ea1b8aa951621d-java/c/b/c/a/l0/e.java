package c.b.c.a.l0;

import c.b.c.a.p;
import c.b.c.a.q;
import c.b.c.a.z;

public class e implements q<z> {
    @Override // c.b.c.a.q
    public Class<z> a() {
        return z.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.p] */
    @Override // c.b.c.a.q
    public z b(p<z> pVar) {
        return new d(pVar);
    }
}
