package c.b.d;

import c.a.a.a.a;
import c.b.d.k0;
import c.b.d.s;
import c.b.d.w2;
import c.b.d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b0 extends a0<s.g> {

    /* renamed from: a  reason: collision with root package name */
    public static final long f3830a = u2.r(k0.e.class.getDeclaredField("b"));

    static {
        try {
        } catch (Throwable unused) {
            throw new IllegalStateException("Unable to lookup extension field offset");
        }
    }

    @Override // c.b.d.a0
    public int a(Map.Entry<?, ?> entry) {
        return ((s.g) entry.getKey()).f4293c.f4132d;
    }

    @Override // c.b.d.a0
    public Object b(z zVar, h1 h1Var, int i) {
        return ((x) zVar).f4384d.get(new x.a(((e1) h1Var).getDescriptorForType(), i));
    }

    @Override // c.b.d.a0
    public f0<s.g> c(Object obj) {
        return (f0) u2.p(obj, f3830a);
    }

    @Override // c.b.d.a0
    public f0<s.g> d(Object obj) {
        f0<s.g> c2 = c(obj);
        if (!c2.f3860b) {
            return c2;
        }
        f0<s.g> c3 = c2.clone();
        u2.f.t(obj, f3830a, c3);
        return c3;
    }

    @Override // c.b.d.a0
    public boolean e(h1 h1Var) {
        return h1Var instanceof k0.e;
    }

    @Override // c.b.d.a0
    public void f(Object obj) {
        c(obj).x();
    }

    @Override // c.b.d.a0
    public <UT, UB> UB g(a2 a2Var, Object obj, z zVar, f0<s.g> f0Var, UB ub, o2<UT, UB> o2Var) {
        Object k;
        long j;
        int i;
        ArrayList arrayList;
        List<Long> list;
        x.b bVar = (x.b) obj;
        s.g gVar = bVar.f4387a;
        int i2 = gVar.f4293c.f4132d;
        if (!gVar.c() || !bVar.f4387a.j()) {
            Object obj2 = null;
            if (bVar.f4387a.e() != w2.b.ENUM) {
                switch (bVar.f4387a.e().ordinal()) {
                    case 0:
                        obj2 = Double.valueOf(a2Var.m());
                        break;
                    case 1:
                        obj2 = Float.valueOf(a2Var.r());
                        break;
                    case 2:
                        j = a2Var.B();
                        obj2 = Long.valueOf(j);
                        break;
                    case 3:
                        j = a2Var.j();
                        obj2 = Long.valueOf(j);
                        break;
                    case 4:
                        i = a2Var.h();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 5:
                        j = a2Var.l();
                        obj2 = Long.valueOf(j);
                        break;
                    case 6:
                        i = a2Var.D();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 7:
                        obj2 = Boolean.valueOf(a2Var.G());
                        break;
                    case 8:
                        obj2 = a2Var.A();
                        break;
                    case 9:
                        obj2 = a2Var.Q(bVar.f4388b.getClass(), zVar);
                        break;
                    case 10:
                        obj2 = a2Var.P(bVar.f4388b.getClass(), zVar);
                        break;
                    case 11:
                        obj2 = a2Var.c();
                        break;
                    case 12:
                        i = a2Var.g();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 13:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 14:
                        i = a2Var.t();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 15:
                        j = a2Var.K();
                        obj2 = Long.valueOf(j);
                        break;
                    case 16:
                        i = a2Var.p();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 17:
                        j = a2Var.s();
                        obj2 = Long.valueOf(j);
                        break;
                }
            } else {
                int h = a2Var.h();
                obj2 = bVar.f4387a.l().i(h);
                if (obj2 == null) {
                    return (UB) e2.G(i2, h, ub, o2Var);
                }
            }
            if (bVar.f4387a.c()) {
                f0Var.a(bVar.f4387a, obj2);
            } else {
                int ordinal = bVar.f4387a.e().ordinal();
                if ((ordinal == 9 || ordinal == 10) && (k = f0Var.k(bVar.f4387a)) != null) {
                    obj2 = m0.f(k, obj2);
                }
                f0Var.B(bVar.f4387a, obj2);
            }
        } else {
            switch (bVar.f4387a.e().ordinal()) {
                case 0:
                    list = new ArrayList<>();
                    a2Var.w(list);
                    arrayList = list;
                    break;
                case 1:
                    list = new ArrayList<>();
                    a2Var.f(list);
                    arrayList = list;
                    break;
                case 2:
                    list = new ArrayList<>();
                    a2Var.x(list);
                    arrayList = list;
                    break;
                case 3:
                    list = new ArrayList<>();
                    a2Var.a(list);
                    arrayList = list;
                    break;
                case 4:
                    list = new ArrayList<>();
                    a2Var.F(list);
                    arrayList = list;
                    break;
                case 5:
                    list = new ArrayList<>();
                    a2Var.E(list);
                    arrayList = list;
                    break;
                case 6:
                    list = new ArrayList<>();
                    a2Var.k(list);
                    arrayList = list;
                    break;
                case 7:
                    list = new ArrayList<>();
                    a2Var.y(list);
                    arrayList = list;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    StringBuilder g = a.g("Type cannot be packed: ");
                    g.append(bVar.f4387a.e());
                    throw new IllegalStateException(g.toString());
                case 12:
                    list = new ArrayList<>();
                    a2Var.v(list);
                    arrayList = list;
                    break;
                case 13:
                    ArrayList arrayList2 = new ArrayList();
                    a2Var.H(arrayList2);
                    arrayList = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Integer) it.next()).intValue();
                        s.f i3 = bVar.f4387a.l().i(intValue);
                        if (i3 != null) {
                            arrayList.add(i3);
                        } else {
                            ub = (UB) e2.G(i2, intValue, ub, o2Var);
                        }
                    }
                    break;
                case 14:
                    list = new ArrayList<>();
                    a2Var.n(list);
                    arrayList = list;
                    break;
                case 15:
                    list = new ArrayList<>();
                    a2Var.z(list);
                    arrayList = list;
                    break;
                case 16:
                    list = new ArrayList<>();
                    a2Var.d(list);
                    arrayList = list;
                    break;
                case 17:
                    list = new ArrayList<>();
                    a2Var.q(list);
                    arrayList = list;
                    break;
            }
            f0Var.B(bVar.f4387a, arrayList);
        }
        return ub;
    }

    @Override // c.b.d.a0
    public void h(a2 a2Var, Object obj, z zVar, f0<s.g> f0Var) {
        x.b bVar = (x.b) obj;
        z.b();
        f0Var.B(bVar.f4387a, new p0(bVar.f4388b, zVar, a2Var.c()));
    }

    @Override // c.b.d.a0
    public void i(j jVar, Object obj, z zVar, f0<s.g> f0Var) {
        x.b bVar = (x.b) obj;
        bVar.f4388b.newBuilderForType().buildPartial();
        z.b();
        f0Var.B(bVar.f4387a, new p0(bVar.f4388b, zVar, jVar));
    }

    @Override // c.b.d.a0
    public void j(x2 x2Var, Map.Entry<?, ?> entry) {
        int i;
        int i2;
        s.g gVar = (s.g) entry.getKey();
        if (gVar.c()) {
            switch (gVar.e().ordinal()) {
                case 0:
                    e2.J(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 1:
                    e2.N(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 2:
                    e2.R(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 3:
                    e2.a0(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 4:
                    e2.Q(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 5:
                    e2.M(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 6:
                    e2.L(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 7:
                    e2.H(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 8:
                    e2.Y(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var);
                    return;
                case 9:
                    e2.O(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var);
                    return;
                case 10:
                    e2.S(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var);
                    return;
                case 11:
                    e2.I(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var);
                    return;
                case 12:
                    e2.Z(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 13:
                    ArrayList arrayList = new ArrayList();
                    for (s.f fVar : (List) entry.getValue()) {
                        arrayList.add(Integer.valueOf(fVar.f4288b.f4112d));
                    }
                    e2.Q(gVar.f4293c.f4132d, arrayList, x2Var, gVar.j());
                    return;
                case 14:
                    e2.U(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 15:
                    e2.V(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 16:
                    e2.W(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                case 17:
                    e2.X(gVar.f4293c.f4132d, (List) entry.getValue(), x2Var, gVar.j());
                    return;
                default:
                    return;
            }
        } else {
            switch (gVar.e().ordinal()) {
                case 0:
                    ((n) x2Var).f4006a.c0(gVar.f4293c.f4132d, ((Double) entry.getValue()).doubleValue());
                    return;
                case 1:
                    ((n) x2Var).e(gVar.f4293c.f4132d, ((Float) entry.getValue()).floatValue());
                    return;
                case 2:
                    ((n) x2Var).f4006a.u0(gVar.f4293c.f4132d, ((Long) entry.getValue()).longValue());
                    return;
                case 3:
                    ((n) x2Var).f4006a.u0(gVar.f4293c.f4132d, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    i2 = gVar.f4293c.f4132d;
                    i = ((Integer) entry.getValue()).intValue();
                    break;
                case 5:
                    ((n) x2Var).f4006a.f0(gVar.f4293c.f4132d, ((Long) entry.getValue()).longValue());
                    return;
                case 6:
                    ((n) x2Var).f4006a.d0(gVar.f4293c.f4132d, ((Integer) entry.getValue()).intValue());
                    return;
                case 7:
                    ((n) x2Var).f4006a.Y(gVar.f4293c.f4132d, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 8:
                    ((n) x2Var).f4006a.p0(gVar.f4293c.f4132d, (String) entry.getValue());
                    return;
                case 9:
                    ((n) x2Var).f4006a.h0(gVar.f4293c.f4132d, (h1) entry.getValue());
                    return;
                case 10:
                    ((n) x2Var).f4006a.k0(gVar.f4293c.f4132d, (h1) entry.getValue());
                    return;
                case 11:
                    ((n) x2Var).f4006a.a0(gVar.f4293c.f4132d, (j) entry.getValue());
                    return;
                case 12:
                    ((n) x2Var).f4006a.s0(gVar.f4293c.f4132d, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    i2 = gVar.f4293c.f4132d;
                    i = ((s.f) entry.getValue()).f4288b.f4112d;
                    break;
                case 14:
                    ((n) x2Var).f4006a.d0(gVar.f4293c.f4132d, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    ((n) x2Var).f4006a.f0(gVar.f4293c.f4132d, ((Long) entry.getValue()).longValue());
                    return;
                case 16:
                    ((n) x2Var).j(gVar.f4293c.f4132d, ((Integer) entry.getValue()).intValue());
                    return;
                case 17:
                    ((n) x2Var).k(gVar.f4293c.f4132d, ((Long) entry.getValue()).longValue());
                    return;
                default:
                    return;
            }
            ((n) x2Var).f4006a.i0(i2, i);
        }
    }
}
