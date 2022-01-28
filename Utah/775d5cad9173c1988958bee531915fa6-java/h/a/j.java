package h.a;

import f.b.b.a.k;

public abstract class j extends f1 {

    public static abstract class a {
        public j a(b bVar, n0 n0Var) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    public static final class b {
        public final a a;
        public final c b;

        public b(a aVar, c cVar) {
            f.b.a.c.b.o.b.z(aVar, "transportAttrs");
            this.a = aVar;
            f.b.a.c.b.o.b.z(cVar, "callOptions");
            this.b = cVar;
        }

        public String toString() {
            k t1 = f.b.a.c.b.o.b.t1(this);
            t1.d("transportAttrs", this.a);
            t1.d("callOptions", this.b);
            return t1.toString();
        }
    }
}
