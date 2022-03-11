package h.a;

import f.b.b.a.k;
/* loaded from: classes.dex */
public abstract class j extends f1 {

    /* loaded from: classes.dex */
    public static abstract class a {
        public j a(b bVar, n0 n0Var) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public final a a;
        public final c b;

        public b(a aVar, c cVar) {
            f.b.a.c.b.o.b.A(aVar, "transportAttrs");
            this.a = aVar;
            f.b.a.c.b.o.b.A(cVar, "callOptions");
            this.b = cVar;
        }

        public String toString() {
            k u1 = f.b.a.c.b.o.b.u1(this);
            u1.d("transportAttrs", this.a);
            u1.d("callOptions", this.b);
            return u1.toString();
        }
    }
}
