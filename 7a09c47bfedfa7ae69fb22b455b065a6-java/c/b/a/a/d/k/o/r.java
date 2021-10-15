package c.b.a.a.d.k.o;

import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import b.x.t;
import c.b.a.a.d.c;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.a.b;
import c.b.a.a.j.j;

public abstract class r<A extends a.b, ResultT> {
    public final c[] zaa;
    public final boolean zab;
    public final int zac;

    public static class a<A extends a.b, ResultT> {

        /* renamed from: a  reason: collision with root package name */
        public o<A, j<ResultT>> f3043a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3044b = true;

        /* renamed from: c  reason: collision with root package name */
        public c[] f3045c;

        /* renamed from: d  reason: collision with root package name */
        public int f3046d = 0;

        public a(m0 m0Var) {
        }

        @RecentlyNonNull
        public r<A, ResultT> a() {
            t.r(this.f3043a != null, "execute parameter required");
            return new n0(this, this.f3045c, this.f3044b, this.f3046d);
        }

        @RecentlyNonNull
        public a<A, ResultT> b(@RecentlyNonNull int i) {
            t.q(i != 0);
            this.f3046d = i;
            return this;
        }
    }

    @Deprecated
    public r() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    public r(c[] cVarArr, boolean z, int i) {
        this.zaa = cVarArr;
        this.zab = z;
        this.zac = i;
    }

    @RecentlyNonNull
    public static <A extends a.b, ResultT> a<A, ResultT> builder() {
        return new a<>(null);
    }

    public abstract void doExecute(@RecentlyNonNull A a2, @RecentlyNonNull j<ResultT> jVar);

    @RecentlyNonNull
    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    @RecentlyNullable
    public final c[] zaa() {
        return this.zaa;
    }
}
