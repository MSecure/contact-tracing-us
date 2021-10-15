package c.b.c.a.e0;

import c.b.c.a.p;
import c.b.c.a.q;
import java.util.logging.Logger;

public class d implements q<c.b.c.a.d> {

    public static class a implements c.b.c.a.d {
        public a(p<c.b.c.a.d> pVar) {
        }
    }

    static {
        Logger.getLogger(d.class.getName());
    }

    @Override // c.b.c.a.q
    public Class<c.b.c.a.d> a() {
        return c.b.c.a.d.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.p] */
    @Override // c.b.c.a.q
    public c.b.c.a.d b(p<c.b.c.a.d> pVar) {
        return new a(pVar);
    }
}
