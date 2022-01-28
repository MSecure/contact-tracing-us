package c.b.a.a.c.k.o;

import b.b.k.i;
import c.b.a.a.c.c;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.a.b;
import c.b.a.a.g.i;

public abstract class q<A extends a.b, ResultT> {
    public final c[] zakj;
    public final boolean zakq;

    public static class a<A extends a.b, ResultT> {

        /* renamed from: a  reason: collision with root package name */
        public o<A, i<ResultT>> f2389a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2390b = true;

        /* renamed from: c  reason: collision with root package name */
        public c[] f2391c;

        public a(p0 p0Var) {
        }

        public q<A, ResultT> a() {
            i.j.k(this.f2389a != null, "execute parameter required");
            return new q0(this, this.f2391c, this.f2390b);
        }
    }

    @Deprecated
    public q() {
        this.zakj = null;
        this.zakq = false;
    }

    public q(c[] cVarArr, boolean z) {
        this.zakj = cVarArr;
        this.zakq = z;
    }

    public static <A extends a.b, ResultT> a<A, ResultT> builder() {
        return new a<>(null);
    }

    public abstract void doExecute(A a2, c.b.a.a.g.i<ResultT> iVar);

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zakq;
    }

    public final c[] zabr() {
        return this.zakj;
    }
}
