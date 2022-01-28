package c.b.a.a.g.h;

import c.b.a.a.g.h.b1;
import c.b.a.a.g.h.t1;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;

public final class s3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f4029a;

    /* renamed from: b  reason: collision with root package name */
    public static final d4<?, ?> f4030b = D(false);

    /* renamed from: c  reason: collision with root package name */
    public static final d4<?, ?> f4031c = D(true);

    /* renamed from: d  reason: collision with root package name */
    public static final d4<?, ?> f4032d = new f4();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("c.b.d.i0");
        } catch (Throwable unused) {
            cls = null;
        }
        f4029a = cls;
    }

    public static void A(int i, List<Integer> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                int i2 = 0;
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    d1Var.f3864a.k(i3);
                    while (i2 < list.size()) {
                        d1Var.f3864a.l(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    b1 b1Var = d1Var.f3864a;
                    int intValue = list.get(i2).intValue();
                    b1.b bVar = (b1.b) b1Var;
                    bVar.k((i << 3) | 5);
                    bVar.l(intValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void B(int i, List<Integer> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                int i2 = 0;
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    d1Var.f3864a.k(i3);
                    while (i2 < list.size()) {
                        d1Var.f3864a.l(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    b1 b1Var = d1Var.f3864a;
                    int intValue = list.get(i2).intValue();
                    b1.b bVar = (b1.b) b1Var;
                    bVar.k((i << 3) | 5);
                    bVar.l(intValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void C(int i, List<Integer> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                int i2 = 0;
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += b1.n(list.get(i4).intValue());
                    }
                    d1Var.f3864a.k(i3);
                    while (i2 < list.size()) {
                        d1Var.f3864a.j(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    d1Var.f3864a.G(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static d4<?, ?> D(boolean z) {
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
            return (d4) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void E(int i, List<Boolean> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        list.get(i3).booleanValue();
                        i2++;
                    }
                    d1Var.f3864a.k(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        d1Var.f3864a.w(list.get(i4).booleanValue() ? (byte) 1 : 0);
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    b1 b1Var = d1Var.f3864a;
                    boolean booleanValue = list.get(i5).booleanValue();
                    b1.b bVar = (b1.b) b1Var;
                    bVar.k((i << 3) | 0);
                    bVar.w(booleanValue ? (byte) 1 : 0);
                }
                return;
            }
            throw null;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int F(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return (b1.m(i) * list.size()) + I(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int G(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b1.m(i) * size) + K(list);
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Long;>;Z)I */
    public static int H(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b1.m(i) * size) + M(list);
    }

    public static int I(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q2) {
            q2 q2Var = (q2) list;
            i = 0;
            while (i2 < size) {
                i += b1.R(q2Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += b1.R(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int J(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b1.m(i) * size) + O(list);
    }

    public static int K(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q2) {
            q2 q2Var = (q2) list;
            i = 0;
            while (i2 < size) {
                i += b1.R(q2Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += b1.R(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int L(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b1.m(i) * size) + Q(list);
    }

    public static int M(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof q2) {
            q2 q2Var = (q2) list;
            i = 0;
            while (i2 < size) {
                i += b1.S(q2Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += b1.S(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int N(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b1.m(i) * size) + S(list);
    }

    public static int O(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v1) {
            v1 v1Var = (v1) list;
            i = 0;
            while (i2 < size) {
                i += b1.n(v1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += b1.n(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<Ljava/lang/Integer;>;Z)I */
    public static int P(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (b1.m(i) * size) + U(list);
    }

    public static int Q(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v1) {
            v1 v1Var = (v1) list;
            i = 0;
            while (i2 < size) {
                i += b1.n(v1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += b1.n(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int R(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b1.L(i) * size;
    }

    public static int S(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v1) {
            v1 v1Var = (v1) list;
            i = 0;
            while (i2 < size) {
                i += b1.o(v1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += b1.o(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int T(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b1.D(i) * size;
    }

    public static int U(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof v1) {
            v1 v1Var = (v1) list;
            i = 0;
            while (i2 < size) {
                i += b1.p(v1Var.c(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += b1.p(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    /* JADX WARN: Incorrect args count in method signature: (ILjava/util/List<*>;Z)I */
    public static int V(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return b1.i(i) * size;
    }

    public static int W(List<?> list) {
        return list.size() << 2;
    }

    public static int X(List<?> list) {
        return list.size() << 3;
    }

    public static int Y(List<?> list) {
        return list.size();
    }

    public static <UT, UB> UB a(int i, int i2, UB ub, d4<UT, UB> d4Var) {
        if (ub == null) {
            if (((f4) d4Var) != null) {
                ub = (UB) c4.e();
            } else {
                throw null;
            }
        }
        long j = (long) i2;
        if (((f4) d4Var) != null) {
            ub.a(i << 3, Long.valueOf(j));
            return ub;
        }
        throw null;
    }

    public static <UT, UB> UB b(int i, List<Integer> list, y1 y1Var, UB ub, d4<UT, UB> d4Var) {
        if (y1Var == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (y1Var.a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    ub = (UB) a(i, intValue, ub, d4Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!y1Var.a(intValue2)) {
                    ub = (UB) a(i, intValue2, ub, d4Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static void c(int i, List<String> list, v4 v4Var) {
        if (list != null && !list.isEmpty()) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                int i2 = 0;
                if (list instanceof j2) {
                    j2 j2Var = (j2) list;
                    while (i2 < list.size()) {
                        Object n = j2Var.n(i2);
                        if (n instanceof String) {
                            b1.b bVar = (b1.b) d1Var.f3864a;
                            bVar.k((i << 3) | 2);
                            bVar.c0((String) n);
                        } else {
                            b1.b bVar2 = (b1.b) d1Var.f3864a;
                            bVar2.k((i << 3) | 2);
                            bVar2.Z((q0) n);
                        }
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    b1.b bVar3 = (b1.b) d1Var.f3864a;
                    bVar3.k((i << 3) | 2);
                    bVar3.c0(list.get(i2));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void d(int i, List<?> list, v4 v4Var, q3 q3Var) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    d1Var.f(i, list.get(i2), q3Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void e(int i, List<Double> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                int i2 = 0;
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).doubleValue();
                        i3 += 8;
                    }
                    d1Var.f3864a.k(i3);
                    while (i2 < list.size()) {
                        b1 b1Var = d1Var.f3864a;
                        double doubleValue = list.get(i2).doubleValue();
                        if (b1Var != null) {
                            b1Var.Q(Double.doubleToRawLongBits(doubleValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    b1 b1Var2 = d1Var.f3864a;
                    double doubleValue2 = list.get(i2).doubleValue();
                    if (b1Var2 != null) {
                        long doubleToRawLongBits = Double.doubleToRawLongBits(doubleValue2);
                        b1.b bVar = (b1.b) b1Var2;
                        bVar.k((i << 3) | 1);
                        bVar.Q(doubleToRawLongBits);
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

    public static <T, FT extends l1<FT>> void f(g1<FT> g1Var, T t, T t2) {
        if (((i1) g1Var) != null) {
            j1<t1.c> j1Var = t2.zzyg;
            if (!j1Var.f3910a.isEmpty()) {
                j1<t1.c> k = t.k();
                if (k != null) {
                    for (int i = 0; i < j1Var.f3910a.h(); i++) {
                        k.j(j1Var.f3910a.e(i));
                    }
                    for (Object obj : j1Var.f3910a.i()) {
                        k.j((Map.Entry) obj);
                    }
                    return;
                }
                throw null;
            }
            return;
        }
        throw null;
    }

    public static <T> void g(v2 v2Var, T t, T t2, long j) {
        j4.e(t, j, v2Var.e(j4.s(t, j), j4.s(t2, j)));
    }

    public static <T, UT, UB> void h(d4<UT, UB> d4Var, T t, T t2) {
        if (((f4) d4Var) != null) {
            T t3 = t;
            c4 c4Var = t3.zzxz;
            c4 c4Var2 = t2.zzxz;
            if (!c4Var2.equals(c4.f3851f)) {
                int i = c4Var.f3852a + c4Var2.f3852a;
                int[] copyOf = Arrays.copyOf(c4Var.f3853b, i);
                System.arraycopy(c4Var2.f3853b, 0, copyOf, c4Var.f3852a, c4Var2.f3852a);
                Object[] copyOf2 = Arrays.copyOf(c4Var.f3854c, i);
                System.arraycopy(c4Var2.f3854c, 0, copyOf2, c4Var.f3852a, c4Var2.f3852a);
                c4Var = new c4(i, copyOf, copyOf2, true);
            }
            t3.zzxz = c4Var;
            return;
        }
        throw null;
    }

    public static void i(int i, List<q0> list, v4 v4Var) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    b1.b bVar = (b1.b) d1Var.f3864a;
                    bVar.k((i << 3) | 2);
                    bVar.Z(list.get(i2));
                }
                return;
            }
            throw null;
        }
    }

    public static void j(int i, List<?> list, v4 v4Var, q3 q3Var) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    d1Var.i(i, list.get(i2), q3Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void k(int i, List<Float> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                int i2 = 0;
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).floatValue();
                        i3 += 4;
                    }
                    d1Var.f3864a.k(i3);
                    while (i2 < list.size()) {
                        b1 b1Var = d1Var.f3864a;
                        float floatValue = list.get(i2).floatValue();
                        if (b1Var != null) {
                            b1Var.l(Float.floatToRawIntBits(floatValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    b1 b1Var2 = d1Var.f3864a;
                    float floatValue2 = list.get(i2).floatValue();
                    if (b1Var2 != null) {
                        int floatToRawIntBits = Float.floatToRawIntBits(floatValue2);
                        b1.b bVar = (b1.b) b1Var2;
                        bVar.k((i << 3) | 5);
                        bVar.l(floatToRawIntBits);
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

    public static int l(int i, Object obj, q3 q3Var) {
        if (obj instanceof h2) {
            int o = b1.o(i << 3);
            int b2 = ((h2) obj).b();
            return b1.o(b2) + b2 + o;
        }
        return b1.b((c3) obj, q3Var) + b1.o(i << 3);
    }

    public static int m(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int m = b1.m(i) * size;
        if (list instanceof j2) {
            j2 j2Var = (j2) list;
            while (i2 < size) {
                Object n = j2Var.n(i2);
                m = (n instanceof q0 ? b1.g((q0) n) : b1.T((String) n)) + m;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                m = (obj instanceof q0 ? b1.g((q0) obj) : b1.T((String) obj)) + m;
                i2++;
            }
        }
        return m;
    }

    public static int n(int i, List<?> list, q3 q3Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int m = b1.m(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            m += obj instanceof h2 ? b1.a((h2) obj) : b1.b((c3) obj, q3Var);
        }
        return m;
    }

    public static void o(int i, List<Long> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += b1.R(list.get(i3).longValue());
                    }
                    d1Var.f3864a.k(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        d1Var.f3864a.O(list.get(i4).longValue());
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    b1 b1Var = d1Var.f3864a;
                    long longValue = list.get(i5).longValue();
                    b1.b bVar = (b1.b) b1Var;
                    bVar.k((i << 3) | 0);
                    bVar.O(longValue);
                }
                return;
            }
            throw null;
        }
    }

    public static int p(int i, List<q0> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int m = b1.m(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            m += b1.g(list.get(i2));
        }
        return m;
    }

    public static int q(int i, List<c3> list, q3 q3Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += b1.u(i, list.get(i3), q3Var);
        }
        return i2;
    }

    public static void r(int i, List<Long> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += b1.R(list.get(i3).longValue());
                    }
                    d1Var.f3864a.k(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        d1Var.f3864a.O(list.get(i4).longValue());
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    b1 b1Var = d1Var.f3864a;
                    long longValue = list.get(i5).longValue();
                    b1.b bVar = (b1.b) b1Var;
                    bVar.k((i << 3) | 0);
                    bVar.O(longValue);
                }
                return;
            }
            throw null;
        }
    }

    public static void s(int i, List<Long> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += b1.S(list.get(i3).longValue());
                    }
                    d1Var.f3864a.k(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        d1Var.f3864a.O(b1.c(list.get(i4).longValue()));
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    b1 b1Var = d1Var.f3864a;
                    long longValue = list.get(i5).longValue();
                    if (b1Var != null) {
                        long c2 = b1.c(longValue);
                        b1.b bVar = (b1.b) b1Var;
                        bVar.k((i << 3) | 0);
                        bVar.O(c2);
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }

    public static boolean t(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void u(int i, List<Long> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                int i2 = 0;
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    d1Var.f3864a.k(i3);
                    while (i2 < list.size()) {
                        d1Var.f3864a.Q(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    b1 b1Var = d1Var.f3864a;
                    long longValue = list.get(i2).longValue();
                    b1.b bVar = (b1.b) b1Var;
                    bVar.k((i << 3) | 1);
                    bVar.Q(longValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void v(int i, List<Long> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                int i2 = 0;
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    d1Var.f3864a.k(i3);
                    while (i2 < list.size()) {
                        d1Var.f3864a.Q(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    b1 b1Var = d1Var.f3864a;
                    long longValue = list.get(i2).longValue();
                    b1.b bVar = (b1.b) b1Var;
                    bVar.k((i << 3) | 1);
                    bVar.Q(longValue);
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void w(Class<?> cls) {
        Class<?> cls2;
        if (!t1.class.isAssignableFrom(cls) && (cls2 = f4029a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void x(int i, List<Integer> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                int i2 = 0;
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += b1.n(list.get(i4).intValue());
                    }
                    d1Var.f3864a.k(i3);
                    while (i2 < list.size()) {
                        d1Var.f3864a.j(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    d1Var.f3864a.G(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void y(int i, List<Integer> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += b1.o(list.get(i3).intValue());
                    }
                    d1Var.f3864a.k(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        d1Var.f3864a.k(list.get(i4).intValue());
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    b1 b1Var = d1Var.f3864a;
                    int intValue = list.get(i5).intValue();
                    b1.b bVar = (b1.b) b1Var;
                    bVar.k((i << 3) | 0);
                    bVar.k(intValue);
                }
                return;
            }
            throw null;
        }
    }

    public static void z(int i, List<Integer> list, v4 v4Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                if (z) {
                    ((b1.b) d1Var.f3864a).k((i << 3) | 2);
                    int i2 = 0;
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        i2 += b1.p(list.get(i3).intValue());
                    }
                    d1Var.f3864a.k(i2);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        d1Var.f3864a.k(b1.s(list.get(i4).intValue()));
                    }
                    return;
                }
                for (int i5 = 0; i5 < list.size(); i5++) {
                    b1 b1Var = d1Var.f3864a;
                    int intValue = list.get(i5).intValue();
                    if (b1Var != null) {
                        int s = b1.s(intValue);
                        b1.b bVar = (b1.b) b1Var;
                        bVar.k((i << 3) | 0);
                        bVar.k(s);
                    } else {
                        throw null;
                    }
                }
                return;
            }
            throw null;
        }
    }
}
