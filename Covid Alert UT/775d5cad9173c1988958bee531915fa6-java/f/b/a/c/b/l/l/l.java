package f.b.a.c.b.l.l;

import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.c;
import f.b.a.c.i.i;

public abstract class l<A, ResultT> {
    public final c[] a;
    public final boolean b;

    public static class a<A, ResultT> {
        public k<A, i<ResultT>> a;
        public c[] b;

        public a(b0 b0Var) {
        }

        @RecentlyNonNull
        public l<A, ResultT> a() {
            m.e.k(this.a != null, "execute parameter required");
            return new c0(this, this.b, true, 0);
        }
    }

    public l(c[] cVarArr, boolean z, int i2, b0 b0Var) {
        this.a = cVarArr;
        this.b = z;
    }

    @RecentlyNonNull
    public static <A, ResultT> a<A, ResultT> a() {
        return new a<>(null);
    }
}
