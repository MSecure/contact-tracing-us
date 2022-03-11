package h.a;

import f.b.a.c.b.o.b;
import java.util.List;
/* loaded from: classes.dex */
public class i {

    /* loaded from: classes.dex */
    public static class a extends d {
        public final d a;
        public final g b;

        public a(d dVar, g gVar, h hVar) {
            this.a = dVar;
            b.A(gVar, "interceptor");
            this.b = gVar;
        }

        @Override // h.a.d
        public String b() {
            return this.a.b();
        }

        @Override // h.a.d
        public <ReqT, RespT> f<ReqT, RespT> h(o0<ReqT, RespT> o0Var, c cVar) {
            return this.b.a(o0Var, cVar, this.a);
        }
    }

    public static d a(d dVar, List<? extends g> list) {
        b.A(dVar, "channel");
        for (g gVar : list) {
            dVar = new a(dVar, gVar, null);
        }
        return dVar;
    }
}
