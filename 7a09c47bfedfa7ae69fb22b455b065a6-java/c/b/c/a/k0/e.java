package c.b.c.a.k0;

import c.b.c.a.p;
import c.b.c.a.q;
import c.b.c.a.t;

public class e implements q<t> {

    public static class a implements t {
        public a(p<t> pVar) {
        }
    }

    @Override // c.b.c.a.q
    public Class<t> a() {
        return t.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.p] */
    @Override // c.b.c.a.q
    public t b(p<t> pVar) {
        return new a(pVar);
    }
}
