package c.b.c.a.j0.a;

import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.l;
import c.b.c.a.j0.a.u;
import c.b.c.a.j0.a.y;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

public final class h1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f4929a;

    /* renamed from: b  reason: collision with root package name */
    public static final l1<?, ?> f4930b = A(false);

    /* renamed from: c  reason: collision with root package name */
    public static final l1<?, ?> f4931c = A(true);

    /* renamed from: d  reason: collision with root package name */
    public static final l1<?, ?> f4932d = new n1();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        f4929a = cls;
    }

    public static l1<?, ?> A(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (l1) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static <T, FT extends u.a<FT>> void B(r<FT> rVar, T t, T t2) {
        if (((s) rVar) != null) {
            u<y.d> uVar = t2.extensions;
            if (!uVar.h()) {
                u<FT> c2 = rVar.c(t);
                if (c2 != null) {
                    for (int i = 0; i < uVar.f5037a.e(); i++) {
                        c2.m(uVar.f5037a.d(i));
                    }
                    for (Object obj : uVar.f5037a.f()) {
                        c2.m((Map.Entry) obj);
                    }
                    return;
                }
                throw null;
            }
            return;
        }
        throw null;
    }

    public static <T> void C(m0 m0Var, T t, T t2, long j) {
        p1.f5006f.q(t, j, m0Var.a(p1.n(t, j), p1.n(t2, j)));
    }

    public static <T, UT, UB> void D(l1<UT, UB> l1Var, T t, T t2) {
        if (((n1) l1Var) != null) {
            T t3 = t;
            m1 m1Var = t3.unknownFields;
            m1 m1Var2 = t2.unknownFields;
            if (!m1Var2.equals(m1.f4983f)) {
                int i = m1Var.f4984a + m1Var2.f4984a;
                int[] copyOf = Arrays.copyOf(m1Var.f4985b, i);
                System.arraycopy(m1Var2.f4985b, 0, copyOf, m1Var.f4984a, m1Var2.f4984a);
                Object[] copyOf2 = Arrays.copyOf(m1Var.f4986c, i);
                System.arraycopy(m1Var2.f4986c, 0, copyOf2, m1Var.f4984a, m1Var2.f4984a);
                m1Var = new m1(i, copyOf, copyOf2, true);
            }
            t3.unknownFields = m1Var;
            return;
        }
        throw null;
    }

    public static void E(Class<?> cls) {
        Class<?> cls2;
        if (!y.class.isAssignableFrom(cls) && (cls2 = f4929a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean F(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB G(int i, int i2, UB ub, l1<UT, UB> l1Var) {
        if (ub == null) {
            if (((n1) l1Var) != null) {
                ub = (UB) m1.b();
            } else {
                throw null;
            }
        }
        long j = (long) i2;
        if (((n1) l1Var) != null) {
            ub.c((i << 3) | 0, Long.valueOf(j));
            return ub;
        }
        throw null;
    }

    public static void H(int i, List<Boolean> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        list.get(i3).booleanValue();
                        i2++;
                    }
                    mVar.f4982a.V(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        mVar.f4982a.P(list.get(i4).booleanValue() ? (byte) 1 : 0);
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    l lVar = mVar.f4982a;
                    boolean booleanValue = list.get(i5).booleanValue();
                    l.b bVar = (l.b) lVar;
                    bVar.V((i << 3) | 0);
                    bVar.P(booleanValue ? (byte) 1 : 0);
                }
                return;
            }
            throw null;
        }
    }

    public static void I(int i, List<i> list, u1 u1Var) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    l.b bVar = (l.b) mVar.f4982a;
                    bVar.V((i << 3) | 2);
                    bVar.Z(list.get(i2));
                }
                return;
            }
            throw null;
        }
    }

    public static void J(int i, List<Double> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                int i2 = 0;
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).doubleValue();
                        i3 += 8;
                    }
                    mVar.f4982a.V(i3);
                    while (i2 < list.size()) {
                        l lVar = mVar.f4982a;
                        double doubleValue = list.get(i2).doubleValue();
                        if (lVar != null) {
                            lVar.S(Double.doubleToRawLongBits(doubleValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    l lVar2 = mVar.f4982a;
                    double doubleValue2 = list.get(i2).doubleValue();
                    if (lVar2 != null) {
                        long doubleToRawLongBits = Double.doubleToRawLongBits(doubleValue2);
                        l.b bVar = (l.b) lVar2;
                        bVar.V((i << 3) | 1);
                        bVar.S(doubleToRawLongBits);
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

    public static void K(int i, List<Integer> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                int i2 = 0;
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += l.r(list.get(i4).intValue());
                    }
                    mVar.f4982a.V(i3);
                    while (i2 < list.size()) {
                        mVar.f4982a.Q(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    mVar.f4982a.T(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void L(int i, List<Integer> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                int i2 = 0;
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    mVar.f4982a.V(i3);
                    while (i2 < list.size()) {
                        mVar.f4982a.R(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    l lVar = mVar.f4982a;
                    int intValue = list.get(i2).intValue();
                    l.b bVar = (l.b) lVar;
                    bVar.V((i << 3) | 5);
                    bVar.R(intValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void M(int i, List<Long> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                int i2 = 0;
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    mVar.f4982a.V(i3);
                    while (i2 < list.size()) {
                        mVar.f4982a.S(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    l lVar = mVar.f4982a;
                    long longValue = list.get(i2).longValue();
                    l.b bVar = (l.b) lVar;
                    bVar.V((i << 3) | 1);
                    bVar.S(longValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void N(int i, List<Float> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                int i2 = 0;
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).floatValue();
                        i3 += 4;
                    }
                    mVar.f4982a.V(i3);
                    while (i2 < list.size()) {
                        l lVar = mVar.f4982a;
                        float floatValue = list.get(i2).floatValue();
                        if (lVar != null) {
                            lVar.R(Float.floatToRawIntBits(floatValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    l lVar2 = mVar.f4982a;
                    float floatValue2 = list.get(i2).floatValue();
                    if (lVar2 != null) {
                        int floatToRawIntBits = Float.floatToRawIntBits(floatValue2);
                        l.b bVar = (l.b) lVar2;
                        bVar.V((i << 3) | 5);
                        bVar.R(floatToRawIntBits);
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

    public static void O(int i, List<?> list, u1 u1Var, f1 f1Var) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    mVar.g(i, list.get(i2), f1Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void P(int i, List<Integer> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                int i2 = 0;
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += l.r(list.get(i4).intValue());
                    }
                    mVar.f4982a.V(i3);
                    while (i2 < list.size()) {
                        mVar.f4982a.U(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    mVar.f4982a.T(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void Q(int i, List<Long> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += l.K(list.get(i3).longValue());
                    }
                    mVar.f4982a.V(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        mVar.f4982a.W(list.get(i4).longValue());
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    l lVar = mVar.f4982a;
                    long longValue = list.get(i5).longValue();
                    if (lVar != null) {
                        l.b bVar = (l.b) lVar;
                        bVar.V((i << 3) | 0);
                        bVar.W(longValue);
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static void R(int i, List<?> list, u1 u1Var, f1 f1Var) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    mVar.i(i, list.get(i2), f1Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void S(int i, List<Integer> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                int i2 = 0;
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    mVar.f4982a.V(i3);
                    while (i2 < list.size()) {
                        mVar.f4982a.R(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    l lVar = mVar.f4982a;
                    int intValue = list.get(i2).intValue();
                    if (lVar != null) {
                        l.b bVar = (l.b) lVar;
                        bVar.V((i << 3) | 5);
                        bVar.R(intValue);
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

    public static void T(int i, List<Long> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                int i2 = 0;
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    mVar.f4982a.V(i3);
                    while (i2 < list.size()) {
                        mVar.f4982a.S(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    l lVar = mVar.f4982a;
                    long longValue = list.get(i2).longValue();
                    if (lVar != null) {
                        l.b bVar = (l.b) lVar;
                        bVar.V((i << 3) | 1);
                        bVar.S(longValue);
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

    public static void U(int i, List<Integer> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += l.B(list.get(i3).intValue());
                    }
                    mVar.f4982a.V(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        mVar.f4982a.V(l.L(list.get(i4).intValue()));
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    l lVar = mVar.f4982a;
                    int intValue = list.get(i5).intValue();
                    if (lVar != null) {
                        int L = l.L(intValue);
                        l.b bVar = (l.b) lVar;
                        bVar.V((i << 3) | 0);
                        bVar.V(L);
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static void V(int i, List<Long> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += l.D(list.get(i3).longValue());
                    }
                    mVar.f4982a.V(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        mVar.f4982a.W(l.M(list.get(i4).longValue()));
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    l lVar = mVar.f4982a;
                    long longValue = list.get(i5).longValue();
                    if (lVar != null) {
                        long M = l.M(longValue);
                        l.b bVar = (l.b) lVar;
                        bVar.V((i << 3) | 0);
                        bVar.W(M);
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static void W(int i, List<String> list, u1 u1Var) {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                int i2 = 0;
                if (list instanceof g0) {
                    g0 g0Var = (g0) list;
                    while (i2 < list.size()) {
                        Object b2 = g0Var.b(i2);
                        if (b2 instanceof String) {
                            l.b bVar = (l.b) mVar.f4982a;
                            bVar.V((i << 3) | 2);
                            bVar.a0((String) b2);
                        } else {
                            l.b bVar2 = (l.b) mVar.f4982a;
                            bVar2.V((i << 3) | 2);
                            bVar2.Z((i) b2);
                        }
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    l.b bVar3 = (l.b) mVar.f4982a;
                    bVar3.V((i << 3) | 2);
                    bVar3.a0(list.get(i2));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void X(int i, List<Integer> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += l.I(list.get(i3).intValue());
                    }
                    mVar.f4982a.V(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        mVar.f4982a.V(list.get(i4).intValue());
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    l lVar = mVar.f4982a;
                    int intValue = list.get(i5).intValue();
                    l.b bVar = (l.b) lVar;
                    bVar.V((i << 3) | 0);
                    bVar.V(intValue);
                }
                return;
            }
            throw null;
        }
    }

    public static void Y(int i, List<Long> list, u1 u1Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            m mVar = (m) u1Var;
            if (mVar != null) {
                if (z) {
                    ((l.b) mVar.f4982a).V((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += l.K(list.get(i3).longValue());
                    }
                    mVar.f4982a.V(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        mVar.f4982a.W(list.get(i4).longValue());
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    l lVar = mVar.f4982a;
                    long longValue = list.get(i5).longValue();
                    l.b bVar = (l.b) lVar;
                    bVar.V((i << 3) | 0);
                    bVar.W(longValue);
                }
                return;
            }
            throw null;
        }
    }

    public static int a(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return l.a(i, true) * size;
        }
        return l.u(size) + l.G(i);
    }

    public static int b(List<?> list) {
        return list.size();
    }

    public static int c(int i, List<i> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int G = l.G(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            G += l.e(list.get(i2));
        }
        return G;
    }

    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = e(list);
        int G = l.G(i);
        return z ? l.u(e2) + G : (G * size) + e2;
    }

    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            i = 0;
            while (i2 < size) {
                i += l.r(zVar.g(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += l.r(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int f(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return l.i(i, 0) * size;
        }
        return l.u(size * 4) + l.G(i);
    }

    public static int g(List<?> list) {
        return list.size() * 4;
    }

    public static int h(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return l.k(i, 0) * size;
        }
        return l.u(size * 8) + l.G(i);
    }

    public static int i(List<?> list) {
        return list.size() * 8;
    }

    public static int j(int i, List<r0> list, f1 f1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += l.o(i, list.get(i3), f1Var);
        }
        return i2;
    }

    public static int k(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = l(list);
        int G = l.G(i);
        return z ? l.u(l) + G : (G * size) + l;
    }

    public static int l(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            i = 0;
            while (i2 < size) {
                i += l.r(zVar.g(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += l.r(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int m(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int n = n(list);
        if (z) {
            return l.u(n) + l.G(i);
        }
        return (l.G(i) * list.size()) + n;
    }

    public static int n(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            i = 0;
            while (i2 < size) {
                i += l.K(i0Var.g(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += l.K(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int o(int i, Object obj, f1 f1Var) {
        int G;
        int u;
        if (obj instanceof e0) {
            G = l.G(i);
            u = l.t((e0) obj);
        } else {
            G = l.G(i);
            u = l.u(((a) ((r0) obj)).b(f1Var));
        }
        return u + G;
    }

    public static int p(int i, List<?> list, f1 f1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int G = l.G(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            G = obj instanceof e0 ? l.t((e0) obj) + G : G + l.u(((a) ((r0) obj)).b(f1Var));
        }
        return G;
    }

    public static int q(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r = r(list);
        int G = l.G(i);
        return z ? l.u(r) + G : (G * size) + r;
    }

    public static int r(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            i = 0;
            while (i2 < size) {
                i += l.B(zVar.g(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += l.B(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int s(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t = t(list);
        int G = l.G(i);
        return z ? l.u(t) + G : (G * size) + t;
    }

    public static int t(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            i = 0;
            while (i2 < size) {
                i += l.D(i0Var.g(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += l.D(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int u(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int G = l.G(i) * size;
        if (list instanceof g0) {
            g0 g0Var = (g0) list;
            while (i2 < size) {
                Object b2 = g0Var.b(i2);
                G = (b2 instanceof i ? l.e((i) b2) : l.F((String) b2)) + G;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                G = (obj instanceof i ? l.e((i) obj) : l.F((String) obj)) + G;
                i2++;
            }
        }
        return G;
    }

    public static int v(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w = w(list);
        int G = l.G(i);
        return z ? l.u(w) + G : (G * size) + w;
    }

    public static int w(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof z) {
            z zVar = (z) list;
            i = 0;
            while (i2 < size) {
                i += l.I(zVar.g(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += l.I(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int x(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y = y(list);
        int G = l.G(i);
        return z ? l.u(y) + G : (G * size) + y;
    }

    public static int y(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof i0) {
            i0 i0Var = (i0) list;
            i = 0;
            while (i2 < size) {
                i += l.K(i0Var.g(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += l.K(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static <UT, UB> UB z(int i, List<Integer> list, a0.b bVar, UB ub, l1<UT, UB> l1Var) {
        if (bVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (bVar.a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) G(i, intValue, ub, l1Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!bVar.a(intValue2)) {
                    ub = (UB) G(i, intValue2, ub, l1Var);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
