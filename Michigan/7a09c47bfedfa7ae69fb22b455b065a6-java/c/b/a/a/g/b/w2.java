package c.b.a.a.g.b;

import c.b.a.a.g.b.z0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

public final class w2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3455a;

    /* renamed from: b  reason: collision with root package name */
    public static final h3<?, ?> f3456b = w(false);

    /* renamed from: c  reason: collision with root package name */
    public static final h3<?, ?> f3457c = w(true);

    /* renamed from: d  reason: collision with root package name */
    public static final h3<?, ?> f3458d = new j3();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("c.b.d.i0");
        } catch (Throwable unused) {
            cls = null;
        }
        f3455a = cls;
    }

    public static void A(int i, List<Long> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += g0.T(list.get(i4).longValue());
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.w(g0.b0(list.get(i2).longValue()));
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.g(i, g0.b0(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static int B(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            i = 0;
            while (i2 < size) {
                i += g0.j0(a1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += g0.j0(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void C(int i, List<Long> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.M(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.H(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void D(Class<?> cls) {
        Class<?> cls2;
        if (!z0.class.isAssignableFrom(cls) && (cls2 = f3455a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static int E(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            i = 0;
            while (i2 < size) {
                i += g0.k0(a1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += g0.k0(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void F(int i, List<Long> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.M(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.H(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static int G(List<?> list) {
        return list.size() << 2;
    }

    public static void H(int i, List<Integer> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += g0.i0(list.get(i4).intValue());
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.e0(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.G(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static int I(List<?> list) {
        return list.size() << 3;
    }

    public static void J(int i, List<Integer> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += g0.j0(list.get(i4).intValue());
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.f0(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.L(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static int K(List<?> list) {
        return list.size();
    }

    public static void L(int i, List<Integer> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += g0.k0(list.get(i4).intValue());
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.f0(g0.n0(list.get(i2).intValue()));
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.L(i, g0.n0(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void M(int i, List<Integer> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.g0(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.Q(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void N(int i, List<Integer> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.g0(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.Q(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void O(int i, List<Integer> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += g0.i0(list.get(i4).intValue());
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.e0(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.G(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void P(int i, List<Boolean> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).booleanValue();
                        i3++;
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.f(list.get(i2).booleanValue() ? (byte) 1 : 0);
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.v(i, list.get(i2).booleanValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int Q(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (g0.h0(i) * list.size()) + a(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int R(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (g0.h0(i) * size) + j(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int S(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (g0.h0(i) * size) + q(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int T(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (g0.h0(i) * size) + v(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int U(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (g0.h0(i) * size) + z(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int V(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (g0.h0(i) * size) + B(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int W(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (g0.h0(i) * size) + E(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int X(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g0.a0(i) * size;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int Y(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g0.R(i) * size;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int Z(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g0.A(i) * size;
    }

    public static int a(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t1) {
            t1 t1Var = (t1) list;
            i = 0;
            while (i2 < size) {
                i += g0.P(t1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += g0.P(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static <UT, UB> UB b(int i, int i2, UB ub, h3<UT, UB> h3Var) {
        if (ub == null) {
            if (((j3) h3Var) != null) {
                ub = (UB) i3.e();
            } else {
                throw null;
            }
        }
        long j = (long) i2;
        if (((j3) h3Var) != null) {
            ub.b(i << 3, Long.valueOf(j));
            return ub;
        }
        throw null;
    }

    public static <UT, UB> UB c(int i, List<Integer> list, d1<?> d1Var, UB ub, h3<UT, UB> h3Var) {
        if (d1Var == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (d1Var.a(intValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) b(i, intValue, ub, h3Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (d1Var.a(intValue2) == null) {
                    ub = (UB) b(i, intValue2, ub, h3Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static void d(int i, List<String> list, b4 b4Var) {
        if (list != null && !list.isEmpty()) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (list instanceof o1) {
                    o1 o1Var = (o1) list;
                    while (i2 < list.size()) {
                        Object b2 = o1Var.b(i2);
                        if (b2 instanceof String) {
                            i0Var.f3309a.k(i, (String) b2);
                        } else {
                            i0Var.f3309a.h(i, (y) b2);
                        }
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.k(i, list.get(i2));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void e(int i, List<?> list, b4 b4Var, u2 u2Var) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    i0Var.f3309a.j(i, (e2) list.get(i2), u2Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void f(int i, List<Double> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).doubleValue();
                        i3 += 8;
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        g0 g0Var = i0Var.f3309a;
                        double doubleValue = list.get(i2).doubleValue();
                        if (g0Var != null) {
                            g0Var.M(Double.doubleToRawLongBits(doubleValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    g0 g0Var2 = i0Var.f3309a;
                    double doubleValue2 = list.get(i2).doubleValue();
                    if (g0Var2 != null) {
                        g0Var2.H(i, Double.doubleToRawLongBits(doubleValue2));
                        i2++;
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static <T, FT extends t0<FT>> void g(m0<FT> m0Var, T t, T t2) {
        if (((n0) m0Var) != null) {
            q0<z0.d> q0Var = t2.zzjv;
            if (!q0Var.a()) {
                T t3 = t;
                q0<z0.d> q0Var2 = t3.zzjv;
                if (q0Var2.f3396b) {
                    q0Var2 = (q0) q0Var2.clone();
                    t3.zzjv = q0Var2;
                }
                for (int i = 0; i < q0Var.f3395a.f(); i++) {
                    q0Var2.j(q0Var.f3395a.d(i));
                }
                for (Object obj : q0Var.f3395a.g()) {
                    q0Var2.j((Map.Entry) obj);
                }
                return;
            }
            return;
        }
        throw null;
    }

    public static <T> void h(z1 z1Var, T t, T t2, long j) {
        n3.f(t, j, z1Var.h(n3.t(t, j), n3.t(t2, j)));
    }

    public static <T, UT, UB> void i(h3<UT, UB> h3Var, T t, T t2) {
        if (((j3) h3Var) != null) {
            T t3 = t;
            i3 i3Var = t3.zzjp;
            i3 i3Var2 = t2.zzjp;
            if (!i3Var2.equals(i3.f3314f)) {
                int i = i3Var.f3315a + i3Var2.f3315a;
                int[] copyOf = Arrays.copyOf(i3Var.f3316b, i);
                System.arraycopy(i3Var2.f3316b, 0, copyOf, i3Var.f3315a, i3Var2.f3315a);
                Object[] copyOf2 = Arrays.copyOf(i3Var.f3317c, i);
                System.arraycopy(i3Var2.f3317c, 0, copyOf2, i3Var.f3315a, i3Var2.f3315a);
                i3Var = new i3(i, copyOf, copyOf2, true);
            }
            t3.zzjp = i3Var;
            return;
        }
        throw null;
    }

    public static int j(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t1) {
            t1 t1Var = (t1) list;
            i = 0;
            while (i2 < size) {
                i += g0.P(t1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += g0.P(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void k(int i, List<y> list, b4 b4Var) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    i0Var.f3309a.h(i, list.get(i2));
                }
                return;
            }
            throw null;
        }
    }

    public static void l(int i, List<?> list, b4 b4Var, u2 u2Var) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    i0Var.f(i, list.get(i2), u2Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void m(int i, List<Float> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).floatValue();
                        i3 += 4;
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        g0 g0Var = i0Var.f3309a;
                        float floatValue = list.get(i2).floatValue();
                        if (g0Var != null) {
                            g0Var.g0(Float.floatToRawIntBits(floatValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    g0 g0Var2 = i0Var.f3309a;
                    float floatValue2 = list.get(i2).floatValue();
                    if (g0Var2 != null) {
                        g0Var2.Q(i, Float.floatToRawIntBits(floatValue2));
                        i2++;
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static int n(int i, Object obj, u2 u2Var) {
        if (obj instanceof m1) {
            int h0 = g0.h0(i);
            int a2 = ((m1) obj).a();
            return g0.j0(a2) + a2 + h0;
        }
        return g0.r((e2) obj, u2Var) + g0.h0(i);
    }

    public static int o(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int h0 = g0.h0(i) * size;
        if (list instanceof o1) {
            o1 o1Var = (o1) list;
            while (i2 < size) {
                Object b2 = o1Var.b(i2);
                h0 = (b2 instanceof y ? g0.q((y) b2) : g0.X((String) b2)) + h0;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                h0 = (obj instanceof y ? g0.q((y) obj) : g0.X((String) obj)) + h0;
                i2++;
            }
        }
        return h0;
    }

    public static int p(int i, List<?> list, u2 u2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int h0 = g0.h0(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            h0 += obj instanceof m1 ? g0.d((m1) obj) : g0.r((e2) obj, u2Var);
        }
        return h0;
    }

    public static int q(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof t1) {
            t1 t1Var = (t1) list;
            i = 0;
            while (i2 < size) {
                i += g0.T(t1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += g0.T(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void r(int i, List<Long> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += g0.P(list.get(i4).longValue());
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.w(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.g(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static boolean s(int i, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        long j = (long) i3;
        return ((((long) i2) - ((long) i)) + 1) + 9 <= ((j + 3) * 3) + ((2 * j) + 3);
    }

    public static int t(int i, List<y> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int h0 = g0.h0(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            h0 += g0.q(list.get(i2));
        }
        return h0;
    }

    public static int u(int i, List<e2> list, u2 u2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += g0.D(i, list.get(i3), u2Var);
        }
        return i2;
    }

    public static int v(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            i = 0;
            while (i2 < size) {
                i += g0.i0(a1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += g0.i0(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static h3<?, ?> w(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("c.b.d.t2");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (h3) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void x(int i, List<Long> list, b4 b4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                int i2 = 0;
                if (z) {
                    i0Var.f3309a.s(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += g0.P(list.get(i4).longValue());
                    }
                    i0Var.f3309a.f0(i3);
                    while (i2 < list.size()) {
                        i0Var.f3309a.w(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    i0Var.f3309a.g(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static boolean y(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int z(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            i = 0;
            while (i2 < size) {
                i += g0.i0(a1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += g0.i0(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }
}
