package f.b.f;

import f.a.a.a.a;
import f.b.f.g;
import f.b.f.r;
import f.b.f.z;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class t extends s<z.d> {
    @Override // f.b.f.s
    public int a(Map.Entry<?, ?> entry) {
        return ((z.d) entry.getKey()).c;
    }

    @Override // f.b.f.s
    public Object b(r rVar, t0 t0Var, int i2) {
        return rVar.a.get(new r.a(t0Var, i2));
    }

    @Override // f.b.f.s
    public v<z.d> c(Object obj) {
        return ((z.c) obj).extensions;
    }

    @Override // f.b.f.s
    public v<z.d> d(Object obj) {
        return ((z.c) obj).b();
    }

    @Override // f.b.f.s
    public boolean e(t0 t0Var) {
        return t0Var instanceof z.c;
    }

    @Override // f.b.f.s
    public void f(Object obj) {
        ((z.c) obj).extensions.m();
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0170  */
    @Override // f.b.f.s
    public <UT, UB> UB g(h1 h1Var, Object obj, r rVar, v<z.d> vVar, UB ub, r1<UT, UB> r1Var) {
        z.d dVar;
        Object g2;
        int i2;
        long j2;
        ArrayList arrayList;
        z.e eVar = (z.e) obj;
        z.d dVar2 = eVar.f3410d;
        int i3 = dVar2.c;
        if (!dVar2.f3408e || !dVar2.f3409f) {
            Object obj2 = null;
            y1 y1Var = dVar2.f3407d;
            if (y1Var == y1.ENUM) {
                i2 = h1Var.j();
                if (eVar.f3410d.b.findValueByNumber(i2) == null) {
                    Class<?> cls = l1.a;
                    if (ub == null) {
                        ub = r1Var.m();
                    }
                    r1Var.e(ub, i3, (long) i2);
                    return ub;
                }
            } else {
                switch (y1Var.ordinal()) {
                    case 0:
                        obj2 = Double.valueOf(h1Var.o());
                        break;
                    case 1:
                        obj2 = Float.valueOf(h1Var.u());
                        break;
                    case 2:
                        j2 = h1Var.F();
                        obj2 = Long.valueOf(j2);
                        break;
                    case 3:
                        j2 = h1Var.l();
                        obj2 = Long.valueOf(j2);
                        break;
                    case 4:
                        i2 = h1Var.j();
                        break;
                    case 5:
                        j2 = h1Var.n();
                        obj2 = Long.valueOf(j2);
                        break;
                    case 6:
                        i2 = h1Var.H();
                        break;
                    case 7:
                        obj2 = Boolean.valueOf(h1Var.L());
                        break;
                    case 8:
                        obj2 = h1Var.E();
                        break;
                    case 9:
                        obj2 = h1Var.K(eVar.c.getClass(), rVar);
                        break;
                    case 10:
                        obj2 = h1Var.A(eVar.c.getClass(), rVar);
                        break;
                    case 11:
                        obj2 = h1Var.e();
                        break;
                    case 12:
                        i2 = h1Var.i();
                        break;
                    case 13:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 14:
                        i2 = h1Var.w();
                        break;
                    case 15:
                        j2 = h1Var.Q();
                        obj2 = Long.valueOf(j2);
                        break;
                    case 16:
                        i2 = h1Var.r();
                        break;
                    case 17:
                        j2 = h1Var.v();
                        obj2 = Long.valueOf(j2);
                        break;
                }
                dVar = eVar.f3410d;
                if (!dVar.f3408e) {
                    vVar.a(dVar, obj2);
                } else {
                    int ordinal = dVar.f3407d.ordinal();
                    if ((ordinal == 9 || ordinal == 10) && (g2 = vVar.g(eVar.f3410d)) != null) {
                        obj2 = c0.c(g2, obj2);
                    }
                    vVar.o(eVar.f3410d, obj2);
                }
            }
            obj2 = Integer.valueOf(i2);
            dVar = eVar.f3410d;
            if (!dVar.f3408e) {
            }
        } else {
            switch (dVar2.f3407d.ordinal()) {
                case 0:
                    arrayList = new ArrayList();
                    h1Var.z(arrayList);
                    break;
                case 1:
                    arrayList = new ArrayList();
                    h1Var.h(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    h1Var.B(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    h1Var.b(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    h1Var.J(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    h1Var.I(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    h1Var.m(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    h1Var.C(arrayList);
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    StringBuilder h2 = a.h("Type cannot be packed: ");
                    h2.append(eVar.f3410d.f3407d);
                    throw new IllegalStateException(h2.toString());
                case 12:
                    arrayList = new ArrayList();
                    h1Var.y(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    h1Var.N(arrayList);
                    ub = (UB) l1.y(i3, arrayList, eVar.f3410d.b, ub, r1Var);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    h1Var.p(arrayList);
                    break;
                case 15:
                    arrayList = new ArrayList();
                    h1Var.D(arrayList);
                    break;
                case 16:
                    arrayList = new ArrayList();
                    h1Var.f(arrayList);
                    break;
                case 17:
                    arrayList = new ArrayList();
                    h1Var.s(arrayList);
                    break;
            }
            vVar.o(eVar.f3410d, arrayList);
        }
        return ub;
    }

    @Override // f.b.f.s
    public void h(h1 h1Var, Object obj, r rVar, v<z.d> vVar) {
        z.e eVar = (z.e) obj;
        vVar.o(eVar.f3410d, h1Var.A(eVar.c.getClass(), rVar));
    }

    @Override // f.b.f.s
    public void i(j jVar, Object obj, r rVar, v<z.d> vVar) {
        z.e eVar = (z.e) obj;
        t0 buildPartial = eVar.c.newBuilderForType().buildPartial();
        ByteBuffer wrap = ByteBuffer.wrap(jVar.z());
        if (wrap.hasArray()) {
            g.b bVar = new g.b(wrap, true);
            e1.c.b(buildPartial).c(buildPartial, bVar, rVar);
            vVar.o(eVar.f3410d, buildPartial);
            if (bVar.O() != Integer.MAX_VALUE) {
                throw d0.a();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    @Override // f.b.f.s
    public void j(a2 a2Var, Map.Entry<?, ?> entry) {
        z.d dVar = (z.d) entry.getKey();
        if (dVar.f3408e) {
            switch (dVar.f3407d.ordinal()) {
                case 0:
                    l1.G(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 1:
                    l1.K(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 2:
                    l1.N(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 3:
                    l1.V(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 4:
                case 13:
                    l1.M(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 5:
                    l1.J(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 6:
                    l1.I(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 7:
                    l1.E(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 8:
                    l1.T(dVar.c, (List) entry.getValue(), a2Var);
                    return;
                case 9:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        l1.L(dVar.c, (List) entry.getValue(), a2Var, e1.c.a(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 10:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        l1.O(dVar.c, (List) entry.getValue(), a2Var, e1.c.a(list2.get(0).getClass()));
                        return;
                    }
                    return;
                case 11:
                    l1.F(dVar.c, (List) entry.getValue(), a2Var);
                    return;
                case 12:
                    l1.U(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 14:
                    l1.P(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 15:
                    l1.Q(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 16:
                    l1.R(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                case 17:
                    l1.S(dVar.c, (List) entry.getValue(), a2Var, dVar.f3409f);
                    return;
                default:
                    return;
            }
        } else {
            switch (dVar.f3407d.ordinal()) {
                case 0:
                    ((n) a2Var).a(dVar.c, ((Double) entry.getValue()).doubleValue());
                    return;
                case 1:
                    ((n) a2Var).b(dVar.c, ((Float) entry.getValue()).floatValue());
                    return;
                case 2:
                    ((n) a2Var).a.b0(dVar.c, ((Long) entry.getValue()).longValue());
                    return;
                case 3:
                    ((n) a2Var).a.b0(dVar.c, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                case 13:
                    ((n) a2Var).a.Q(dVar.c, ((Integer) entry.getValue()).intValue());
                    return;
                case 5:
                    ((n) a2Var).a.O(dVar.c, ((Long) entry.getValue()).longValue());
                    return;
                case 6:
                    ((n) a2Var).a.M(dVar.c, ((Integer) entry.getValue()).intValue());
                    return;
                case 7:
                    ((n) a2Var).a.I(dVar.c, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 8:
                    ((n) a2Var).a.W(dVar.c, (String) entry.getValue());
                    return;
                case 9:
                    ((n) a2Var).c(dVar.c, entry.getValue(), e1.c.a(entry.getValue().getClass()));
                    return;
                case 10:
                    ((n) a2Var).d(dVar.c, entry.getValue(), e1.c.a(entry.getValue().getClass()));
                    return;
                case 11:
                    ((n) a2Var).a.K(dVar.c, (j) entry.getValue());
                    return;
                case 12:
                    ((n) a2Var).a.Z(dVar.c, ((Integer) entry.getValue()).intValue());
                    return;
                case 14:
                    ((n) a2Var).a.M(dVar.c, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    ((n) a2Var).a.O(dVar.c, ((Long) entry.getValue()).longValue());
                    return;
                case 16:
                    ((n) a2Var).f(dVar.c, ((Integer) entry.getValue()).intValue());
                    return;
                case 17:
                    ((n) a2Var).g(dVar.c, ((Long) entry.getValue()).longValue());
                    return;
                default:
                    return;
            }
        }
    }
}
