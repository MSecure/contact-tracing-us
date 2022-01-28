package c.b.d;

import c.a.a.a.a;
import c.b.d.l0;
import c.b.d.s;
import c.b.d.x;
import c.b.d.x2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b0 extends a0<s.g> {

    /* renamed from: a  reason: collision with root package name */
    public static final long f5233a = v2.r(l0.e.class.getDeclaredField("b"));

    static {
        try {
        } catch (Throwable unused) {
            throw new IllegalStateException("Unable to lookup extension field offset");
        }
    }

    @Override // c.b.d.a0
    public int a(Map.Entry<?, ?> entry) {
        return ((s.g) entry.getKey()).f5819c.f5594d;
    }

    @Override // c.b.d.a0
    public Object b(z zVar, i1 i1Var, int i) {
        return ((x) zVar).f5907d.get(new x.a(((f1) i1Var).getDescriptorForType(), i));
    }

    @Override // c.b.d.a0
    public f0<s.g> c(Object obj) {
        return (f0) v2.p(obj, f5233a);
    }

    @Override // c.b.d.a0
    public f0<s.g> d(Object obj) {
        f0<s.g> c2 = c(obj);
        if (!c2.f5263b) {
            return c2;
        }
        f0<s.g> c3 = c2.clone();
        v2.f5899f.t(obj, f5233a, c3);
        return c3;
    }

    @Override // c.b.d.a0
    public boolean e(i1 i1Var) {
        return i1Var instanceof l0.e;
    }

    @Override // c.b.d.a0
    public void f(Object obj) {
        c(obj).x();
    }

    @Override // c.b.d.a0
    public <UT, UB> UB g(b2 b2Var, Object obj, z zVar, f0<s.g> f0Var, UB ub, p2<UT, UB> p2Var) {
        Object k;
        long j;
        int i;
        ArrayList arrayList;
        List<Long> list;
        x.b bVar = (x.b) obj;
        s.g gVar = bVar.f5910a;
        int i2 = gVar.f5819c.f5594d;
        if (!gVar.e() || !bVar.f5910a.l()) {
            Object obj2 = null;
            if (bVar.f5910a.g() != x2.b.ENUM) {
                switch (bVar.f5910a.g().ordinal()) {
                    case 0:
                        obj2 = Double.valueOf(b2Var.readDouble());
                        break;
                    case 1:
                        obj2 = Float.valueOf(b2Var.readFloat());
                        break;
                    case 2:
                        j = b2Var.z();
                        obj2 = Long.valueOf(j);
                        break;
                    case 3:
                        j = b2Var.j();
                        obj2 = Long.valueOf(j);
                        break;
                    case 4:
                        i = b2Var.h();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 5:
                        j = b2Var.l();
                        obj2 = Long.valueOf(j);
                        break;
                    case 6:
                        i = b2Var.B();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 7:
                        obj2 = Boolean.valueOf(b2Var.E());
                        break;
                    case 8:
                        obj2 = b2Var.y();
                        break;
                    case 9:
                        obj2 = b2Var.O(bVar.f5911b.getClass(), zVar);
                        break;
                    case 10:
                        obj2 = b2Var.N(bVar.f5911b.getClass(), zVar);
                        break;
                    case 11:
                        obj2 = b2Var.c();
                        break;
                    case 12:
                        i = b2Var.g();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 13:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 14:
                        i = b2Var.r();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 15:
                        j = b2Var.I();
                        obj2 = Long.valueOf(j);
                        break;
                    case 16:
                        i = b2Var.o();
                        obj2 = Integer.valueOf(i);
                        break;
                    case 17:
                        j = b2Var.q();
                        obj2 = Long.valueOf(j);
                        break;
                }
            } else {
                int h = b2Var.h();
                obj2 = bVar.f5910a.n().k(h);
                if (obj2 == null) {
                    return (UB) f2.G(i2, h, ub, p2Var);
                }
            }
            if (bVar.f5910a.e()) {
                f0Var.a(bVar.f5910a, obj2);
            } else {
                int ordinal = bVar.f5910a.g().ordinal();
                if ((ordinal == 9 || ordinal == 10) && (k = f0Var.k(bVar.f5910a)) != null) {
                    obj2 = n0.f(k, obj2);
                }
                f0Var.B(bVar.f5910a, obj2);
            }
        } else {
            switch (bVar.f5910a.g().ordinal()) {
                case 0:
                    list = new ArrayList<>();
                    b2Var.u(list);
                    arrayList = list;
                    break;
                case 1:
                    list = new ArrayList<>();
                    b2Var.f(list);
                    arrayList = list;
                    break;
                case 2:
                    list = new ArrayList<>();
                    b2Var.v(list);
                    arrayList = list;
                    break;
                case 3:
                    list = new ArrayList<>();
                    b2Var.a(list);
                    arrayList = list;
                    break;
                case 4:
                    list = new ArrayList<>();
                    b2Var.D(list);
                    arrayList = list;
                    break;
                case 5:
                    list = new ArrayList<>();
                    b2Var.C(list);
                    arrayList = list;
                    break;
                case 6:
                    list = new ArrayList<>();
                    b2Var.k(list);
                    arrayList = list;
                    break;
                case 7:
                    list = new ArrayList<>();
                    b2Var.w(list);
                    arrayList = list;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    StringBuilder h2 = a.h("Type cannot be packed: ");
                    h2.append(bVar.f5910a.g());
                    throw new IllegalStateException(h2.toString());
                case 12:
                    list = new ArrayList<>();
                    b2Var.t(list);
                    arrayList = list;
                    break;
                case 13:
                    ArrayList arrayList2 = new ArrayList();
                    b2Var.F(arrayList2);
                    arrayList = new ArrayList();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Integer) it.next()).intValue();
                        s.f k2 = bVar.f5910a.n().k(intValue);
                        if (k2 != null) {
                            arrayList.add(k2);
                        } else {
                            ub = (UB) f2.G(i2, intValue, ub, p2Var);
                        }
                    }
                    break;
                case 14:
                    list = new ArrayList<>();
                    b2Var.m(list);
                    arrayList = list;
                    break;
                case 15:
                    list = new ArrayList<>();
                    b2Var.x(list);
                    arrayList = list;
                    break;
                case 16:
                    list = new ArrayList<>();
                    b2Var.d(list);
                    arrayList = list;
                    break;
                case 17:
                    list = new ArrayList<>();
                    b2Var.p(list);
                    arrayList = list;
                    break;
            }
            f0Var.B(bVar.f5910a, arrayList);
        }
        return ub;
    }

    @Override // c.b.d.a0
    public void h(b2 b2Var, Object obj, z zVar, f0<s.g> f0Var) {
        x.b bVar = (x.b) obj;
        z.b();
        f0Var.B(bVar.f5910a, new q0(bVar.f5911b, zVar, b2Var.c()));
    }

    @Override // c.b.d.a0
    public void i(j jVar, Object obj, z zVar, f0<s.g> f0Var) {
        x.b bVar = (x.b) obj;
        bVar.f5911b.newBuilderForType().buildPartial();
        z.b();
        f0Var.B(bVar.f5910a, new q0(bVar.f5911b, zVar, jVar));
    }

    @Override // c.b.d.a0
    public void j(y2 y2Var, Map.Entry<?, ?> entry) {
        int i;
        int i2;
        s.g gVar = (s.g) entry.getKey();
        if (gVar.e()) {
            switch (gVar.g().ordinal()) {
                case 0:
                    f2.J(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 1:
                    f2.N(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 2:
                    f2.R(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 3:
                    f2.a0(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 4:
                    f2.Q(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 5:
                    f2.M(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 6:
                    f2.L(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 7:
                    f2.H(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 8:
                    f2.Y(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var);
                    return;
                case 9:
                    f2.O(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var);
                    return;
                case 10:
                    f2.S(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var);
                    return;
                case 11:
                    f2.I(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var);
                    return;
                case 12:
                    f2.Z(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 13:
                    ArrayList arrayList = new ArrayList();
                    for (s.f fVar : (List) entry.getValue()) {
                        arrayList.add(Integer.valueOf(fVar.f5814b.f5568d));
                    }
                    f2.Q(gVar.f5819c.f5594d, arrayList, y2Var, gVar.l());
                    return;
                case 14:
                    f2.U(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 15:
                    f2.V(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 16:
                    f2.W(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                case 17:
                    f2.X(gVar.f5819c.f5594d, (List) entry.getValue(), y2Var, gVar.l());
                    return;
                default:
                    return;
            }
        } else {
            switch (gVar.g().ordinal()) {
                case 0:
                    ((n) y2Var).f5437a.c0(gVar.f5819c.f5594d, ((Double) entry.getValue()).doubleValue());
                    return;
                case 1:
                    ((n) y2Var).e(gVar.f5819c.f5594d, ((Float) entry.getValue()).floatValue());
                    return;
                case 2:
                    ((n) y2Var).f5437a.u0(gVar.f5819c.f5594d, ((Long) entry.getValue()).longValue());
                    return;
                case 3:
                    ((n) y2Var).f5437a.u0(gVar.f5819c.f5594d, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    i2 = gVar.f5819c.f5594d;
                    i = ((Integer) entry.getValue()).intValue();
                    break;
                case 5:
                    ((n) y2Var).f5437a.f0(gVar.f5819c.f5594d, ((Long) entry.getValue()).longValue());
                    return;
                case 6:
                    ((n) y2Var).f5437a.d0(gVar.f5819c.f5594d, ((Integer) entry.getValue()).intValue());
                    return;
                case 7:
                    ((n) y2Var).f5437a.Y(gVar.f5819c.f5594d, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 8:
                    ((n) y2Var).f5437a.p0(gVar.f5819c.f5594d, (String) entry.getValue());
                    return;
                case 9:
                    ((n) y2Var).f5437a.h0(gVar.f5819c.f5594d, (i1) entry.getValue());
                    return;
                case 10:
                    ((n) y2Var).f5437a.k0(gVar.f5819c.f5594d, (i1) entry.getValue());
                    return;
                case 11:
                    ((n) y2Var).f5437a.a0(gVar.f5819c.f5594d, (j) entry.getValue());
                    return;
                case 12:
                    ((n) y2Var).f5437a.s0(gVar.f5819c.f5594d, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    i2 = gVar.f5819c.f5594d;
                    i = ((s.f) entry.getValue()).f5814b.f5568d;
                    break;
                case 14:
                    ((n) y2Var).f5437a.d0(gVar.f5819c.f5594d, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    ((n) y2Var).f5437a.f0(gVar.f5819c.f5594d, ((Long) entry.getValue()).longValue());
                    return;
                case 16:
                    ((n) y2Var).j(gVar.f5819c.f5594d, ((Integer) entry.getValue()).intValue());
                    return;
                case 17:
                    ((n) y2Var).k(gVar.f5819c.f5594d, ((Long) entry.getValue()).longValue());
                    return;
                default:
                    return;
            }
            ((n) y2Var).f5437a.i0(i2, i);
        }
    }
}
