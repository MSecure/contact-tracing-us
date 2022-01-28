package c.b.a.a.g.h;

import c.b.a.a.g.h.b1;
import c.b.a.a.g.h.t1;
import java.util.List;
import java.util.Map;

public final class i1 extends g1<t1.c> {
    @Override // c.b.a.a.g.h.g1
    public final int a(Map.Entry<?, ?> entry) {
        return ((t1.c) entry.getKey()).f4036b;
    }

    @Override // c.b.a.a.g.h.g1
    public final void b(v4 v4Var, Map.Entry<?, ?> entry) {
        t1.c cVar = (t1.c) entry.getKey();
        if (cVar.f4038d) {
            switch (h1.f3902a[cVar.f4037c.ordinal()]) {
                case 1:
                    s3.e(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 2:
                    s3.k(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 3:
                    s3.o(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 4:
                    s3.r(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 5:
                    s3.x(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 6:
                    s3.u(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 7:
                    s3.A(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 8:
                    s3.E(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 9:
                    s3.y(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 10:
                    s3.B(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 11:
                    s3.v(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 12:
                    s3.z(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 13:
                    s3.s(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 14:
                    s3.x(cVar.f4036b, (List) entry.getValue(), v4Var, false);
                    return;
                case 15:
                    s3.i(cVar.f4036b, (List) entry.getValue(), v4Var);
                    return;
                case 16:
                    s3.c(cVar.f4036b, (List) entry.getValue(), v4Var);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        s3.j(cVar.f4036b, (List) entry.getValue(), v4Var, n3.f3973c.a(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        s3.d(cVar.f4036b, (List) entry.getValue(), v4Var, n3.f3973c.a(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (h1.f3902a[cVar.f4037c.ordinal()]) {
                case 1:
                    ((d1) v4Var).a(cVar.f4036b, ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    ((d1) v4Var).b(cVar.f4036b, ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    ((d1) v4Var).k(cVar.f4036b, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    ((d1) v4Var).c(cVar.f4036b, ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                    ((d1) v4Var).f3864a.G(cVar.f4036b, ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    ((d1) v4Var).j(cVar.f4036b, ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    ((d1) v4Var).o(cVar.f4036b, ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    ((d1) v4Var).g(cVar.f4036b, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 9:
                    ((d1) v4Var).m(cVar.f4036b, ((Integer) entry.getValue()).intValue());
                    return;
                case 10:
                    ((d1) v4Var).p(cVar.f4036b, ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    ((d1) v4Var).l(cVar.f4036b, ((Long) entry.getValue()).longValue());
                    return;
                case 12:
                    ((d1) v4Var).n(cVar.f4036b, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    ((d1) v4Var).h(cVar.f4036b, ((Long) entry.getValue()).longValue());
                    return;
                case 14:
                    ((d1) v4Var).f3864a.G(cVar.f4036b, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    ((d1) v4Var).d(cVar.f4036b, (q0) entry.getValue());
                    return;
                case 16:
                    int i = cVar.f4036b;
                    b1.b bVar = (b1.b) ((d1) v4Var).f3864a;
                    bVar.k((i << 3) | 2);
                    bVar.c0((String) entry.getValue());
                    return;
                case 17:
                    ((d1) v4Var).i(cVar.f4036b, entry.getValue(), n3.f3973c.a(entry.getValue().getClass()));
                    return;
                case 18:
                    ((d1) v4Var).f(cVar.f4036b, entry.getValue(), n3.f3973c.a(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }
}
