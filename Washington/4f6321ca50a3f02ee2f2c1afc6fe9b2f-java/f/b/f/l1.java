package f.b.f;

import f.b.f.c0;
import f.b.f.v;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.logging.Logger;

public final class l1 {
    public static final Class<?> a;
    public static final r1<?, ?> b = A(false);
    public static final r1<?, ?> c = A(true);

    /* renamed from: d  reason: collision with root package name */
    public static final r1<?, ?> f3348d = new t1();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
    }

    public static r1<?, ?> A(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (r1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static <T, FT extends v.a<FT>> void B(s<FT> sVar, T t, T t2) {
        v<FT> c2 = sVar.c(t2);
        if (!c2.i()) {
            v<FT> d2 = sVar.d(t);
            Objects.requireNonNull(d2);
            for (int i2 = 0; i2 < c2.a.d(); i2++) {
                d2.n(c2.a.c(i2));
            }
            for (Object obj : c2.a.e()) {
                d2.n((Map.Entry) obj);
            }
        }
    }

    public static boolean C(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB D(int i2, int i3, UB ub, r1<UT, UB> r1Var) {
        if (ub == null) {
            ub = r1Var.m();
        }
        r1Var.e(ub, i2, (long) i3);
        return ub;
    }

    public static void E(int i2, List<Boolean> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    list.get(i5).booleanValue();
                    Logger logger = m.b;
                    i4++;
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.H(list.get(i3).booleanValue() ? (byte) 1 : 0);
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.I(i2, list.get(i3).booleanValue());
                i3++;
            }
        }
    }

    public static void F(int i2, List<j> list, a2 a2Var) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            for (int i3 = 0; i3 < list.size(); i3++) {
                nVar.a.K(i2, list.get(i3));
            }
        }
    }

    public static void G(int i2, List<Double> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    list.get(i5).doubleValue();
                    Logger logger = m.b;
                    i4 += 8;
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    m mVar = nVar.a;
                    double doubleValue = list.get(i3).doubleValue();
                    Objects.requireNonNull(mVar);
                    mVar.P(Double.doubleToRawLongBits(doubleValue));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                m mVar2 = nVar.a;
                double doubleValue2 = list.get(i3).doubleValue();
                Objects.requireNonNull(mVar2);
                mVar2.O(i2, Double.doubleToRawLongBits(doubleValue2));
                i3++;
            }
        }
    }

    public static void H(int i2, List<Integer> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += m.m(list.get(i5).intValue());
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.R(list.get(i3).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.Q(i2, list.get(i3).intValue());
                i3++;
            }
        }
    }

    public static void I(int i2, List<Integer> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    list.get(i5).intValue();
                    Logger logger = m.b;
                    i4 += 4;
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.N(list.get(i3).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.M(i2, list.get(i3).intValue());
                i3++;
            }
        }
    }

    public static void J(int i2, List<Long> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    list.get(i5).longValue();
                    Logger logger = m.b;
                    i4 += 8;
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.P(list.get(i3).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.O(i2, list.get(i3).longValue());
                i3++;
            }
        }
    }

    public static void K(int i2, List<Float> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    list.get(i5).floatValue();
                    Logger logger = m.b;
                    i4 += 4;
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    m mVar = nVar.a;
                    float floatValue = list.get(i3).floatValue();
                    Objects.requireNonNull(mVar);
                    mVar.N(Float.floatToRawIntBits(floatValue));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                m mVar2 = nVar.a;
                float floatValue2 = list.get(i3).floatValue();
                Objects.requireNonNull(mVar2);
                mVar2.M(i2, Float.floatToRawIntBits(floatValue2));
                i3++;
            }
        }
    }

    public static void L(int i2, List<?> list, a2 a2Var, j1 j1Var) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            for (int i3 = 0; i3 < list.size(); i3++) {
                nVar.c(i2, list.get(i3), j1Var);
            }
        }
    }

    public static void M(int i2, List<Integer> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += m.m(list.get(i5).intValue());
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.R(list.get(i3).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.Q(i2, list.get(i3).intValue());
                i3++;
            }
        }
    }

    public static void N(int i2, List<Long> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += m.C(list.get(i5).longValue());
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.c0(list.get(i3).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.b0(i2, list.get(i3).longValue());
                i3++;
            }
        }
    }

    public static void O(int i2, List<?> list, a2 a2Var, j1 j1Var) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            for (int i3 = 0; i3 < list.size(); i3++) {
                nVar.a.S(i2, (t0) list.get(i3), j1Var);
            }
        }
    }

    public static void P(int i2, List<Integer> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    list.get(i5).intValue();
                    Logger logger = m.b;
                    i4 += 4;
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.N(list.get(i3).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.M(i2, list.get(i3).intValue());
                i3++;
            }
        }
    }

    public static void Q(int i2, List<Long> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    list.get(i5).longValue();
                    Logger logger = m.b;
                    i4 += 8;
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.P(list.get(i3).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.O(i2, list.get(i3).longValue());
                i3++;
            }
        }
    }

    public static void R(int i2, List<Integer> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += m.t(list.get(i5).intValue());
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.a0(m.D(list.get(i3).intValue()));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.Z(i2, m.D(list.get(i3).intValue()));
                i3++;
            }
        }
    }

    public static void S(int i2, List<Long> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += m.v(list.get(i5).longValue());
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.c0(m.E(list.get(i3).longValue()));
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.b0(i2, m.E(list.get(i3).longValue()));
                i3++;
            }
        }
    }

    public static void T(int i2, List<String> list, a2 a2Var) {
        if (list != null && !list.isEmpty()) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (list instanceof i0) {
                i0 i0Var = (i0) list;
                while (i3 < list.size()) {
                    Object c2 = i0Var.c(i3);
                    if (c2 instanceof String) {
                        nVar.a.W(i2, (String) c2);
                    } else {
                        nVar.a.K(i2, (j) c2);
                    }
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.W(i2, list.get(i3));
                i3++;
            }
        }
    }

    public static void U(int i2, List<Integer> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += m.A(list.get(i5).intValue());
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.a0(list.get(i3).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.Z(i2, list.get(i3).intValue());
                i3++;
            }
        }
    }

    public static void V(int i2, List<Long> list, a2 a2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar);
            int i3 = 0;
            if (z) {
                nVar.a.Y(i2, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += m.C(list.get(i5).longValue());
                }
                nVar.a.a0(i4);
                while (i3 < list.size()) {
                    nVar.a.c0(list.get(i3).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                nVar.a.b0(i2, list.get(i3).longValue());
                i3++;
            }
        }
    }

    public static int a(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return m.c(i2, true) * size;
        }
        return m.p(size) + m.y(i2);
    }

    public static int b(int i2, List<j> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y = m.y(i2) * size;
        for (int i3 = 0; i3 < list.size(); i3++) {
            y += m.e(list.get(i3));
        }
        return y;
    }

    public static int c(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int d2 = d(list);
        int y = m.y(i2);
        return z ? m.p(d2) + y : (y * size) + d2;
    }

    public static int d(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.m(b0Var.k(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += m.m(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int e(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return m.h(i2, 0) * size;
        }
        return m.p(size * 4) + m.y(i2);
    }

    public static int f(List<?> list) {
        return list.size() * 4;
    }

    public static int g(int i2, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return m.i(i2, 0) * size;
        }
        return m.p(size * 8) + m.y(i2);
    }

    public static int h(List<?> list) {
        return list.size() * 8;
    }

    public static int i(int i2, List<t0> list, j1 j1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += m.k(i2, list.get(i4), j1Var);
        }
        return i3;
    }

    public static int j(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int k2 = k(list);
        int y = m.y(i2);
        return z ? m.p(k2) + y : (y * size) + k2;
    }

    public static int k(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.m(b0Var.k(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += m.m(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int l(int i2, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int m = m(list);
        if (z) {
            return m.p(m) + m.y(i2);
        }
        return (m.y(i2) * list.size()) + m;
    }

    public static int m(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof k0) {
            k0 k0Var = (k0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.C(k0Var.k(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += m.C(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static int n(int i2, Object obj, j1 j1Var) {
        int y;
        int p;
        if (obj instanceof g0) {
            y = m.y(i2);
            p = m.o((g0) obj);
        } else {
            y = m.y(i2);
            p = m.p(((a) ((t0) obj)).getSerializedSize(j1Var));
        }
        return p + y;
    }

    public static int o(int i2, List<?> list, j1 j1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y = m.y(i2) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            y = obj instanceof g0 ? m.o((g0) obj) + y : y + m.p(((a) ((t0) obj)).getSerializedSize(j1Var));
        }
        return y;
    }

    public static int p(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int q = q(list);
        int y = m.y(i2);
        return z ? m.p(q) + y : (y * size) + q;
    }

    public static int q(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.t(b0Var.k(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += m.t(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int r(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int s = s(list);
        int y = m.y(i2);
        return z ? m.p(s) + y : (y * size) + s;
    }

    public static int s(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof k0) {
            k0 k0Var = (k0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.v(k0Var.k(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += m.v(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static int t(int i2, List<?> list) {
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        int y = m.y(i2) * size;
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            while (i3 < size) {
                Object c2 = i0Var.c(i3);
                y = (c2 instanceof j ? m.e((j) c2) : m.x((String) c2)) + y;
                i3++;
            }
        } else {
            while (i3 < size) {
                Object obj = list.get(i3);
                y = (obj instanceof j ? m.e((j) obj) : m.x((String) obj)) + y;
                i3++;
            }
        }
        return y;
    }

    public static int u(int i2, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int v = v(list);
        int y = m.y(i2);
        return z ? m.p(v) + y : (y * size) + v;
    }

    public static int v(List<Integer> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof b0) {
            b0 b0Var = (b0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.A(b0Var.k(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += m.A(list.get(i3).intValue());
                i3++;
            }
        }
        return i2;
    }

    public static int w(int i2, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int x = x(list);
        int y = m.y(i2);
        return z ? m.p(x) + y : (y * size) + x;
    }

    public static int x(List<Long> list) {
        int i2;
        int size = list.size();
        int i3 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof k0) {
            k0 k0Var = (k0) list;
            i2 = 0;
            while (i3 < size) {
                i2 += m.C(k0Var.k(i3));
                i3++;
            }
        } else {
            i2 = 0;
            while (i3 < size) {
                i2 += m.C(list.get(i3).longValue());
                i3++;
            }
        }
        return i2;
    }

    public static <UT, UB> UB y(int i2, List<Integer> list, c0.d<?> dVar, UB ub, r1<UT, UB> r1Var) {
        if (dVar == null) {
            return ub;
        }
        int size = list.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = list.get(i4).intValue();
            if (dVar.findValueByNumber(intValue) != null) {
                if (i4 != i3) {
                    list.set(i3, Integer.valueOf(intValue));
                }
                i3++;
            } else {
                if (ub == null) {
                    ub = r1Var.m();
                }
                r1Var.e(ub, i2, (long) intValue);
            }
        }
        if (i3 != size) {
            list.subList(i3, size).clear();
        }
        return ub;
    }

    public static <UT, UB> UB z(int i2, List<Integer> list, c0.e eVar, UB ub, r1<UT, UB> r1Var) {
        if (eVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                int intValue = list.get(i4).intValue();
                if (eVar.isInRange(intValue)) {
                    if (i4 != i3) {
                        list.set(i3, Integer.valueOf(intValue));
                    }
                    i3++;
                } else {
                    if (ub == null) {
                        ub = r1Var.m();
                    }
                    r1Var.e(ub, i2, (long) intValue);
                }
            }
            if (i3 != size) {
                list.subList(i3, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!eVar.isInRange(intValue2)) {
                    if (ub == null) {
                        ub = r1Var.m();
                    }
                    r1Var.e(ub, i2, (long) intValue2);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
