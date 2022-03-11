package h.a.j1;

import h.a.c;
import h.a.f;
import h.a.g;
import h.a.j1.o2;
import h.a.j1.s0;
import h.a.j1.x1;
import h.a.o0;
import h.a.r;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class r2 implements g {

    /* renamed from: d  reason: collision with root package name */
    public static final c.a<o2.a> f4327d = c.a.a("internal-retry-policy");

    /* renamed from: e  reason: collision with root package name */
    public static final c.a<s0.a> f4328e = c.a.a("internal-hedging-policy");
    public final AtomicReference<x1> a = new AtomicReference<>();
    public final boolean b;
    public volatile boolean c;

    /* loaded from: classes.dex */
    public final class a implements s0.a {
        public final /* synthetic */ o0 a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(o0 o0Var) {
            this.a = o0Var;
        }

        @Override // h.a.j1.s0.a
        public s0 get() {
            if (!r2.this.c) {
                return s0.f4329d;
            }
            x1.a b = r2.this.b(this.a);
            s0 s0Var = b == null ? s0.f4329d : b.f4351f;
            f.b.a.c.b.o.b.x1(s0Var.equals(s0.f4329d) || r2.this.c(this.a).equals(o2.f4268f), "Can not apply both retry and hedging policy for the method '%s'", this.a);
            return s0Var;
        }
    }

    /* loaded from: classes.dex */
    public final class b implements o2.a {
        public final /* synthetic */ o0 a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b(o0 o0Var) {
            this.a = o0Var;
        }

        @Override // h.a.j1.o2.a
        public o2 get() {
            return !r2.this.c ? o2.f4268f : r2.this.c(this.a);
        }
    }

    /* loaded from: classes.dex */
    public final class c implements s0.a {
        public final /* synthetic */ s0 a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public c(r2 r2Var, s0 s0Var) {
            this.a = s0Var;
        }

        @Override // h.a.j1.s0.a
        public s0 get() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public final class d implements o2.a {
        public final /* synthetic */ o2 a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d(r2 r2Var, o2 o2Var) {
            this.a = o2Var;
        }

        @Override // h.a.j1.o2.a
        public o2 get() {
            return this.a;
        }
    }

    public r2(boolean z) {
        this.b = z;
    }

    @Override // h.a.g
    public <ReqT, RespT> f<ReqT, RespT> a(o0<ReqT, RespT> o0Var, h.a.c cVar, h.a.d dVar) {
        h.a.c cVar2;
        if (this.b) {
            if (this.c) {
                x1.a b2 = b(o0Var);
                o2 o2Var = b2 == null ? o2.f4268f : b2.f4350e;
                x1.a b3 = b(o0Var);
                s0 s0Var = b3 == null ? s0.f4329d : b3.f4351f;
                f.b.a.c.b.o.b.x1(o2Var.equals(o2.f4268f) || s0Var.equals(s0.f4329d), "Can not apply both retry and hedging policy for the method '%s'", o0Var);
                cVar = cVar.e(f4327d, new d(this, o2Var)).e(f4328e, new c(this, s0Var));
            } else {
                cVar = cVar.e(f4327d, new b(o0Var)).e(f4328e, new a(o0Var));
            }
        }
        x1.a b4 = b(o0Var);
        if (b4 == null) {
            return dVar.h(o0Var, cVar);
        }
        Long l2 = b4.a;
        if (l2 != null) {
            long longValue = l2.longValue();
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            r.b bVar = r.f4551e;
            Objects.requireNonNull(timeUnit, "units");
            r rVar = new r(bVar, timeUnit.toNanos(longValue), true);
            r rVar2 = cVar.a;
            if (rVar2 == null || rVar.compareTo(rVar2) < 0) {
                h.a.c cVar3 = new h.a.c(cVar);
                cVar3.a = rVar;
                cVar = cVar3;
            }
        }
        Boolean bool = b4.b;
        if (bool != null) {
            if (bool.booleanValue()) {
                Objects.requireNonNull(cVar);
                cVar2 = new h.a.c(cVar);
                cVar2.f4082h = Boolean.TRUE;
            } else {
                Objects.requireNonNull(cVar);
                cVar2 = new h.a.c(cVar);
                cVar2.f4082h = Boolean.FALSE;
            }
            cVar = cVar2;
        }
        Integer num = b4.c;
        if (num != null) {
            Integer num2 = cVar.f4083i;
            cVar = cVar.c(num2 != null ? Math.min(num2.intValue(), b4.c.intValue()) : num.intValue());
        }
        Integer num3 = b4.f4349d;
        if (num3 != null) {
            Integer num4 = cVar.f4084j;
            cVar = cVar.d(num4 != null ? Math.min(num4.intValue(), b4.f4349d.intValue()) : num3.intValue());
        }
        return dVar.h(o0Var, cVar);
    }

    public final x1.a b(o0<?, ?> o0Var) {
        x1 x1Var = this.a.get();
        x1.a aVar = x1Var != null ? x1Var.a.get(o0Var.b) : null;
        if (aVar != null || x1Var == null) {
            return aVar;
        }
        return x1Var.b.get(o0Var.c);
    }

    public o2 c(o0<?, ?> o0Var) {
        x1.a b2 = b(o0Var);
        return b2 == null ? o2.f4268f : b2.f4350e;
    }
}
