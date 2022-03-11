package f.b.c.k.u.p;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.k.u.o;
import f.b.d.a.s;

public class i implements o {
    public s a;

    public i(s sVar) {
        b.b1(o.h(sVar), "NumericIncrementTransformOperation expects a NumberValue operand", new Object[0]);
        this.a = sVar;
    }

    @Override // f.b.c.k.u.p.o
    public s a(s sVar) {
        if (o.h(sVar)) {
            return sVar;
        }
        s.b z = s.z();
        z.d(0);
        return (s) z.build();
    }

    @Override // f.b.c.k.u.p.o
    public s b(s sVar, s sVar2) {
        return sVar2;
    }

    @Override // f.b.c.k.u.p.o
    public s c(s sVar, d dVar) {
        s.b bVar;
        double d2;
        long j2;
        s a2 = a(sVar);
        if (!o.f(a2) || !o.f(this.a)) {
            if (o.f(a2)) {
                d2 = (double) a2.t();
            } else {
                b.b1(o.e(a2), "Expected NumberValue to be of type DoubleValue, but was ", sVar.getClass().getCanonicalName());
                d2 = a2.r();
            }
            double d3 = d() + d2;
            bVar = s.z();
            bVar.c(d3);
        } else {
            long t = a2.t();
            if (o.e(this.a)) {
                j2 = (long) this.a.r();
            } else if (o.f(this.a)) {
                j2 = this.a.t();
            } else {
                StringBuilder h2 = a.h("Expected 'operand' to be of Number type, but was ");
                h2.append(this.a.getClass().getCanonicalName());
                b.z0(h2.toString(), new Object[0]);
                throw null;
            }
            long j3 = t + j2;
            if (((t ^ j3) & (j2 ^ j3)) < 0) {
                j3 = j3 >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            bVar = s.z();
            bVar.d(j3);
        }
        return (s) bVar.build();
    }

    public final double d() {
        if (o.e(this.a)) {
            return this.a.r();
        }
        if (o.f(this.a)) {
            return (double) this.a.t();
        }
        StringBuilder h2 = a.h("Expected 'operand' to be of Number type, but was ");
        h2.append(this.a.getClass().getCanonicalName());
        b.z0(h2.toString(), new Object[0]);
        throw null;
    }
}
