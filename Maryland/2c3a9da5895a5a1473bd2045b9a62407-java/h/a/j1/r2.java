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

public final class r2 implements g {

    /* renamed from: d  reason: collision with root package name */
    public static final c.a<o2.a> f3853d = c.a.a("internal-retry-policy");

    /* renamed from: e  reason: collision with root package name */
    public static final c.a<s0.a> f3854e = c.a.a("internal-hedging-policy");
    public final AtomicReference<x1> a = new AtomicReference<>();
    public final boolean b;
    public volatile boolean c;

    public final class a implements s0.a {
        public final /* synthetic */ o0 a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(o0 o0Var) {
            this.a = o0Var;
        }

        @Override // h.a.j1.s0.a
        public s0 get() {
            if (!r2.this.c) {
                return s0.f3855d;
            }
            x1.a b2 = r2.this.b(this.a);
            s0 s0Var = b2 == null ? s0.f3855d : b2.f3877f;
            f.b.a.c.b.o.b.W1(s0Var.equals(s0.f3855d) || r2.this.c(this.a).equals(o2.f3794f), "Can not apply both retry and hedging policy for the method '%s'", this.a);
            return s0Var;
        }
    }

    public final class b implements o2.a {
        public final /* synthetic */ o0 a;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b(o0 o0Var) {
            this.a = o0Var;
        }

        @Override // h.a.j1.o2.a
        public o2 get() {
            return !r2.this.c ? o2.f3794f : r2.this.c(this.a);
        }
    }

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
                o2 o2Var = b2 == null ? o2.f3794f : b2.f3876e;
                x1.a b3 = b(o0Var);
                s0 s0Var = b3 == null ? s0.f3855d : b3.f3877f;
                f.b.a.c.b.o.b.W1(o2Var.equals(o2.f3794f) || s0Var.equals(s0.f3855d), "Can not apply both retry and hedging policy for the method '%s'", o0Var);
                cVar = cVar.e(f3853d, new d(this, o2Var)).e(f3854e, new c(this, s0Var));
            } else {
                cVar = cVar.e(f3853d, new b(o0Var)).e(f3854e, new a(o0Var));
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
            r.b bVar = r.f4077e;
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
                cVar2.f3608h = Boolean.TRUE;
            } else {
                Objects.requireNonNull(cVar);
                cVar2 = new h.a.c(cVar);
                cVar2.f3608h = Boolean.FALSE;
            }
            cVar = cVar2;
        }
        Integer num = b4.c;
        if (num != null) {
            Integer num2 = cVar.f3609i;
            cVar = cVar.c(num2 != null ? Math.min(num2.intValue(), b4.c.intValue()) : num.intValue());
        }
        Integer num3 = b4.f3875d;
        if (num3 != null) {
            Integer num4 = cVar.f3610j;
            cVar = cVar.d(num4 != null ? Math.min(num4.intValue(), b4.f3875d.intValue()) : num3.intValue());
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
        return b2 == null ? o2.f3794f : b2.f3876e;
    }
}
