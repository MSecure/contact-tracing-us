package c.b.c.a.e0;

import c.b.c.a.p;
import c.b.c.a.q;

public class e implements q<c.b.c.a.e> {

    public static class a implements c.b.c.a.e {
        public a(p<c.b.c.a.e> pVar) {
        }
    }

    @Override // c.b.c.a.q
    public Class<c.b.c.a.e> a() {
        return c.b.c.a.e.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.p] */
    @Override // c.b.c.a.q
    public c.b.c.a.e b(p<c.b.c.a.e> pVar) {
        return new a(pVar);
    }
}
