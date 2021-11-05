package c.b.d;

import c.b.d.m0;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class e2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f3850a;

    /* renamed from: b  reason: collision with root package name */
    public static final o2<?, ?> f3851b = B(false);

    /* renamed from: c  reason: collision with root package name */
    public static final o2<?, ?> f3852c = B(true);

    /* renamed from: d  reason: collision with root package name */
    public static final o2<?, ?> f3853d = new r2();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("c.b.d.k0");
        } catch (Throwable unused) {
            cls = null;
        }
        f3850a = cls;
    }

    public static Object A(Class<?> cls, String str) {
        int i;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(cls.getName());
            sb.append("$");
            StringBuilder sb2 = new StringBuilder();
            boolean z = true;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if ('a' <= charAt && charAt <= 'z') {
                    if (z) {
                        i = charAt - ' ';
                    }
                    sb2.append(charAt);
                    z = false;
                } else if ('A' > charAt || charAt > 'Z') {
                    if ('0' <= charAt && charAt <= '9') {
                        sb2.append(charAt);
                    }
                    z = true;
                } else {
                    if (i2 == 0 && !z) {
                        i = charAt + ' ';
                    }
                    sb2.append(charAt);
                    z = false;
                }
                sb2.append((char) i);
                z = false;
            }
            sb.append(sb2.toString());
            sb.append("DefaultEntryHolder");
            Field[] declaredFields = Class.forName(sb.toString()).getDeclaredFields();
            if (declaredFields.length == 1) {
                return u2.f.l(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static o2<?, ?> B(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("c.b.d.s2");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (o2) cls.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static <T> void C(a1 a1Var, T t, T t2, long j) {
        u2.f.t(t, j, a1Var.a(u2.p(t, j), u2.p(t2, j)));
    }

    public static <T, UT, UB> void D(o2<UT, UB> o2Var, T t, T t2) {
        o2Var.o(t, o2Var.k(o2Var.g(t), o2Var.g(t2)));
    }

    public static void E(Class<?> cls) {
        Class<?> cls2;
        if (!j0.class.isAssignableFrom(cls) && (cls2 = f3850a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean F(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB G(int i, int i2, UB ub, o2<UT, UB> o2Var) {
        if (ub == null) {
            ub = o2Var.m();
        }
        o2Var.e(ub, i, (long) i2);
        return ub;
    }

    public static void H(int i, List<Boolean> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).booleanValue();
                        i3++;
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        nVar.f4006a.X(list.get(i2).booleanValue() ? (byte) 1 : 0);
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.Y(i, list.get(i2).booleanValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void I(int i, List<j> list, x2 x2Var) {
        if (list != null && !list.isEmpty()) {
            ((n) x2Var).a(i, list);
        }
    }

    public static void J(int i, List<Double> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).doubleValue();
                        i3 += 8;
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        m mVar = nVar.f4006a;
                        double doubleValue = list.get(i2).doubleValue();
                        if (mVar != null) {
                            mVar.g0(Double.doubleToRawLongBits(doubleValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.c0(i, list.get(i2).doubleValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void K(int i, List<Integer> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += m.t(list.get(i4).intValue());
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        nVar.f4006a.j0(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.i0(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void L(int i, List<Integer> list, x2 x2Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            ((n) x2Var).c(i, list, z);
        }
    }

    public static void M(int i, List<Long> list, x2 x2Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            ((n) x2Var).d(i, list, z);
        }
    }

    public static void N(int i, List<Float> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).floatValue();
                        i3 += 4;
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        m mVar = nVar.f4006a;
                        float floatValue = list.get(i2).floatValue();
                        if (mVar != null) {
                            mVar.e0(Float.floatToRawIntBits(floatValue));
                            i2++;
                        } else {
                            throw null;
                        }
                    }
                    return;
                }
                while (i2 < list.size()) {
                    m mVar2 = nVar.f4006a;
                    float floatValue2 = list.get(i2).floatValue();
                    if (mVar2 != null) {
                        mVar2.d0(i, Float.floatToRawIntBits(floatValue2));
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

    public static void O(int i, List<?> list, x2 x2Var) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    nVar.f4006a.h0(i, (h1) list.get(i2));
                }
                return;
            }
            throw null;
        }
    }

    public static void P(int i, List<?> list, x2 x2Var, c2 c2Var) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    nVar.f(i, list.get(i2), c2Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void Q(int i, List<Integer> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += m.t(list.get(i4).intValue());
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        nVar.f4006a.j0(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.i0(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void R(int i, List<Long> list, x2 x2Var, boolean z) {
        if (list != null && !list.isEmpty()) {
            ((n) x2Var).g(i, list, z);
        }
    }

    public static void S(int i, List<?> list, x2 x2Var) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    nVar.f4006a.k0(i, (h1) list.get(i2));
                }
                return;
            }
            throw null;
        }
    }

    public static void T(int i, List<?> list, x2 x2Var, c2 c2Var) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    nVar.f4006a.l0(i, (h1) list.get(i2), c2Var);
                }
                return;
            }
            throw null;
        }
    }

    public static void U(int i, List<Integer> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).intValue();
                        i3 += 4;
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        nVar.f4006a.e0(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.d0(i, list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void V(int i, List<Long> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        list.get(i4).longValue();
                        i3 += 8;
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        nVar.f4006a.g0(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.f0(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void W(int i, List<Integer> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += m.I(list.get(i4).intValue());
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        nVar.f4006a.t0(m.S(list.get(i2).intValue()));
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.s0(i, m.S(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void X(int i, List<Long> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += m.K(list.get(i4).longValue());
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        nVar.f4006a.v0(m.T(list.get(i2).longValue()));
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.u0(i, m.T(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void Y(int i, List<String> list, x2 x2Var) {
        if (list != null && !list.isEmpty()) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (list instanceof s0) {
                    s0 s0Var = (s0) list;
                    while (i2 < list.size()) {
                        Object f = s0Var.f(i2);
                        if (f instanceof String) {
                            nVar.f4006a.p0(i, (String) f);
                        } else {
                            nVar.f4006a.a0(i, (j) f);
                        }
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.p0(i, list.get(i2));
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static void Z(int i, List<Integer> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += m.P(list.get(i4).intValue());
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        nVar.f4006a.t0(list.get(i2).intValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.s0(i, list.get(i2).intValue());
                    i2++;
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
            return m.c(i, true) * size;
        }
        return m.x(size) + m.N(i);
    }

    public static void a0(int i, List<Long> list, x2 x2Var, boolean z) {
        if (!(list == null || list.isEmpty())) {
            n nVar = (n) x2Var;
            if (nVar != null) {
                int i2 = 0;
                if (z) {
                    nVar.f4006a.r0(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        i3 += m.R(list.get(i4).longValue());
                    }
                    nVar.f4006a.t0(i3);
                    while (i2 < list.size()) {
                        nVar.f4006a.v0(list.get(i2).longValue());
                        i2++;
                    }
                    return;
                }
                while (i2 < list.size()) {
                    nVar.f4006a.u0(i, list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            throw null;
        }
    }

    public static int b(List<?> list) {
        return list.size();
    }

    public static int c(int i, List<j> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int N = m.N(i) * size;
        for (int i2 = 0; i2 < list.size(); i2++) {
            N += m.g(list.get(i2));
        }
        return N;
    }

    public static int d(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e2 = e(list);
        int N = m.N(i);
        return z ? m.x(e2) + N : (N * size) + e2;
    }

    public static int e(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            i = 0;
            while (i2 < size) {
                i += m.t(l0Var.h(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += m.t(list.get(i2).intValue());
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
            return m.k(i, 0) * size;
        }
        return m.x(size * 4) + m.N(i);
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
            return m.m(i, 0) * size;
        }
        return m.x(size * 8) + m.N(i);
    }

    public static int i(List<?> list) {
        return list.size() * 8;
    }

    public static int j(int i, List<h1> list, c2 c2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += m.q(i, list.get(i3), c2Var);
        }
        return i2;
    }

    public static int k(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = l(list);
        int N = m.N(i);
        return z ? m.x(l) + N : (N * size) + l;
    }

    public static int l(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            i = 0;
            while (i2 < size) {
                i += m.t(l0Var.h(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += m.t(list.get(i2).intValue());
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
            return m.x(n) + m.N(i);
        }
        return (m.N(i) * list.size()) + n;
    }

    public static int n(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof u0) {
            u0 u0Var = (u0) list;
            i = 0;
            while (i2 < size) {
                i += m.R(u0Var.h(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += m.R(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int o(int i, Object obj, c2 c2Var) {
        if (obj instanceof q0) {
            return m.v(i, (q0) obj);
        }
        return m.x(((b) ((h1) obj)).getSerializedSize(c2Var)) + m.N(i);
    }

    public static int p(int i, List<?> list, c2 c2Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int N = m.N(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            N = obj instanceof q0 ? m.w((q0) obj) + N : N + m.x(((b) ((h1) obj)).getSerializedSize(c2Var));
        }
        return N;
    }

    public static int q(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r = r(list);
        int N = m.N(i);
        return z ? m.x(r) + N : (N * size) + r;
    }

    public static int r(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            i = 0;
            while (i2 < size) {
                i += m.I(l0Var.h(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += m.I(list.get(i2).intValue());
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
        int N = m.N(i);
        return z ? m.x(t) + N : (N * size) + t;
    }

    public static int t(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof u0) {
            u0 u0Var = (u0) list;
            i = 0;
            while (i2 < size) {
                i += m.K(u0Var.h(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += m.K(list.get(i2).longValue());
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
        int N = m.N(i) * size;
        if (list instanceof s0) {
            s0 s0Var = (s0) list;
            while (i2 < size) {
                Object f = s0Var.f(i2);
                N = (f instanceof j ? m.g((j) f) : m.M((String) f)) + N;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                N = (obj instanceof j ? m.g((j) obj) : m.M((String) obj)) + N;
                i2++;
            }
        }
        return N;
    }

    public static int v(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w = w(list);
        int N = m.N(i);
        return z ? m.x(w) + N : (N * size) + w;
    }

    public static int w(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            i = 0;
            while (i2 < size) {
                i += m.P(l0Var.h(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += m.P(list.get(i2).intValue());
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
        int N = m.N(i);
        return z ? m.x(y) + N : (N * size) + y;
    }

    public static int y(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof u0) {
            u0 u0Var = (u0) list;
            i = 0;
            while (i2 < size) {
                i += m.R(u0Var.h(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += m.R(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static <UT, UB> UB z(int i, List<Integer> list, m0.d dVar, UB ub, o2<UT, UB> o2Var) {
        if (dVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (dVar.a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    if (ub == null) {
                        ub = o2Var.m();
                    }
                    o2Var.e(ub, i, (long) intValue);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!dVar.a(intValue2)) {
                    if (ub == null) {
                        ub = o2Var.m();
                    }
                    o2Var.e(ub, i, (long) intValue2);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
