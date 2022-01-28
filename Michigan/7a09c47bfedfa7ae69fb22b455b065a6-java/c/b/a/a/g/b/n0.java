package c.b.a.a.g.b;

import c.b.a.a.g.b.z0;
import java.util.Map;

public final class n0 extends m0<z0.d> {
    @Override // c.b.a.a.g.b.m0
    public final int a(Map.Entry<?, ?> entry) {
        return ((z0.d) entry.getKey()).f3487b;
    }

    @Override // c.b.a.a.g.b.m0
    public final void b(b4 b4Var, Map.Entry<?, ?> entry) {
        z0.d dVar = (z0.d) entry.getKey();
        switch (o0.f3384a[dVar.f3488c.ordinal()]) {
            case 1:
                ((i0) b4Var).a(dVar.f3487b, ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                ((i0) b4Var).b(dVar.f3487b, ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                ((i0) b4Var).f3309a.g(dVar.f3487b, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                ((i0) b4Var).f3309a.g(dVar.f3487b, ((Long) entry.getValue()).longValue());
                return;
            case 5:
                ((i0) b4Var).f3309a.G(dVar.f3487b, ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                ((i0) b4Var).f3309a.H(dVar.f3487b, ((Long) entry.getValue()).longValue());
                return;
            case 7:
                ((i0) b4Var).f3309a.Q(dVar.f3487b, ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                ((i0) b4Var).f3309a.v(dVar.f3487b, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                ((i0) b4Var).f3309a.L(dVar.f3487b, ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                ((i0) b4Var).f3309a.Q(dVar.f3487b, ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                ((i0) b4Var).f3309a.H(dVar.f3487b, ((Long) entry.getValue()).longValue());
                return;
            case 12:
                ((i0) b4Var).g(dVar.f3487b, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                ((i0) b4Var).e(dVar.f3487b, ((Long) entry.getValue()).longValue());
                return;
            case 14:
                ((i0) b4Var).f3309a.G(dVar.f3487b, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                ((i0) b4Var).f3309a.h(dVar.f3487b, (y) entry.getValue());
                return;
            case 16:
                ((i0) b4Var).f3309a.k(dVar.f3487b, (String) entry.getValue());
                return;
            case 17:
                ((i0) b4Var).f(dVar.f3487b, entry.getValue(), p2.f3390c.a(entry.getValue().getClass()));
                return;
            case 18:
                ((i0) b4Var).d(dVar.f3487b, entry.getValue(), p2.f3390c.a(entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }
}
