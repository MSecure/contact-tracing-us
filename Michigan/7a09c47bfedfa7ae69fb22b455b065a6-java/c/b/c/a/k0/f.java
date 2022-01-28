package c.b.c.a.k0;

import c.b.c.a.p;
import c.b.c.a.q;
import c.b.c.a.u;
import java.util.logging.Logger;

public class f implements q<u> {

    public static class a implements u {
        public a(p<u> pVar) {
        }
    }

    static {
        Logger.getLogger(f.class.getName());
    }

    @Override // c.b.c.a.q
    public Class<u> a() {
        return u.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.p] */
    @Override // c.b.c.a.q
    public u b(p<u> pVar) {
        return new a(pVar);
    }
}
