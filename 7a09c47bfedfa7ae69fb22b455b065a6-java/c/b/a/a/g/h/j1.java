package c.b.a.a.g.h;

import c.b.a.a.g.h.l1;
import c.b.a.a.g.h.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class j1<T extends l1<T>> {

    /* renamed from: d  reason: collision with root package name */
    public static final j1 f3909d = new j1(true);

    /* renamed from: a  reason: collision with root package name */
    public final r3<T, Object> f3910a = r3.d(16);

    /* renamed from: b  reason: collision with root package name */
    public boolean f3911b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3912c;

    public j1() {
    }

    public j1(boolean z) {
        l();
        l();
    }

    public static int c(p4 p4Var, int i, Object obj) {
        int m = b1.m(i);
        if (p4Var == p4.GROUP) {
            c3 c3Var = (c3) obj;
            if (c3Var instanceof i0) {
                i0 i0Var = (i0) c3Var;
            }
            m <<= 1;
        }
        return g(p4Var, obj) + m;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if ((r3 instanceof c.b.a.a.g.h.w1) == false) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if ((r3 instanceof c.b.a.a.g.h.d2) == false) goto L_0x0012;
     */
    public static void f(p4 p4Var, Object obj) {
        u1.a(obj);
        boolean z = true;
        switch (m1.f3943a[p4Var.f3998b.ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof q0)) {
                    break;
                }
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                break;
            case 9:
                if (!(obj instanceof c3)) {
                    break;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static int g(p4 p4Var, Object obj) {
        switch (m1.f3944b[p4Var.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                b1.d();
                return 8;
            case 2:
                ((Float) obj).floatValue();
                b1.P();
                return 4;
            case 3:
                return b1.R(((Long) obj).longValue());
            case 4:
                return b1.R(((Long) obj).longValue());
            case 5:
                return b1.n(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                b1.U();
                return 8;
            case 7:
                ((Integer) obj).intValue();
                b1.q();
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                b1.H();
                return 1;
            case 9:
                return b1.y((c3) obj);
            case 10:
                return obj instanceof d2 ? b1.a((d2) obj) : b1.v((c3) obj);
            case 11:
                return obj instanceof q0 ? b1.g((q0) obj) : b1.T((String) obj);
            case 12:
                return obj instanceof q0 ? b1.g((q0) obj) : b1.C((byte[]) obj);
            case 13:
                return b1.o(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                b1.r();
                return 4;
            case 15:
                ((Long) obj).longValue();
                b1.V();
                return 8;
            case 16:
                return b1.p(((Integer) obj).intValue());
            case 17:
                return b1.S(((Long) obj).longValue());
            case 18:
                if (obj instanceof w1) {
                    return b1.n(((w1) obj).h());
                }
                return b1.n(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static <T extends l1<T>> boolean h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.K() == w4.MESSAGE) {
            boolean w = key.w();
            Object value = entry.getValue();
            if (w) {
                for (c3 c3Var : (List) value) {
                    if (!c3Var.isInitialized()) {
                        return false;
                    }
                }
            } else if (value instanceof c3) {
                if (!((c3) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof d2) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    public static int i(l1<?> l1Var, Object obj) {
        p4 u = l1Var.u();
        int h = l1Var.h();
        if (!l1Var.w()) {
            return c(u, h, obj);
        }
        int i = 0;
        List<Object> list = (List) obj;
        if (l1Var.N()) {
            for (Object obj2 : list) {
                i += g(u, obj2);
            }
            return b1.m(h) + i + b1.o(i);
        }
        for (Object obj3 : list) {
            i += c(u, h, obj3);
        }
        return i;
    }

    public static int k(Map.Entry<T, Object> entry) {
        int J;
        int o;
        int d2;
        int o2;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.K() != w4.MESSAGE || key.w() || key.N()) {
            return i(key, value);
        }
        boolean z = value instanceof d2;
        int h = entry.getKey().h();
        if (z) {
            J = b1.J(2, h) + (b1.o(8) << 1);
            o = b1.o(24);
            d2 = ((d2) value).b();
            o2 = b1.o(d2);
        } else {
            J = b1.J(2, h) + (b1.o(8) << 1);
            o = b1.o(24);
            d2 = ((c3) value).d();
            o2 = b1.o(d2);
        }
        return o2 + d2 + o + J;
    }

    public static Object m(Object obj) {
        if (obj instanceof f3) {
            return ((f3) obj).p();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final boolean a() {
        for (int i = 0; i < this.f3910a.h(); i++) {
            if (!h(this.f3910a.e(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f3910a.i()) {
            if (!h(entry)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<T, Object>> b() {
        return this.f3912c ? new i2(this.f3910a.entrySet().iterator()) : this.f3910a.entrySet().iterator();
    }

    public final /* synthetic */ Object clone() {
        j1 j1Var = new j1();
        for (int i = 0; i < this.f3910a.h(); i++) {
            Map.Entry<T, Object> e2 = this.f3910a.e(i);
            j1Var.e(e2.getKey(), e2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f3910a.i()) {
            j1Var.e(entry.getKey(), entry.getValue());
        }
        j1Var.f3912c = this.f3912c;
        return j1Var;
    }

    public final Object d(T t) {
        Object obj = this.f3910a.get(t);
        if (!(obj instanceof d2)) {
            return obj;
        }
        d2 d2Var = (d2) obj;
        d2.d();
        throw null;
    }

    public final void e(T t, Object obj) {
        if (!t.w()) {
            f(t.u(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                f(t.u(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof d2) {
            this.f3912c = true;
        }
        this.f3910a.put(t, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j1)) {
            return false;
        }
        return this.f3910a.equals(((j1) obj).f3910a);
    }

    public final int hashCode() {
        return this.f3910a.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v10, resolved type: c.b.a.a.g.h.t1 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j(Map.Entry<T, Object> entry) {
        f3 f3Var;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof d2) {
            d2 d2Var = (d2) value;
            d2.d();
            throw null;
        } else if (key.w()) {
            Object d2 = d(key);
            if (d2 == null) {
                d2 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) d2).add(m(obj));
            }
            this.f3910a.put(key, d2);
        } else if (key.K() == w4.MESSAGE) {
            Object d3 = d(key);
            if (d3 == null) {
                this.f3910a.put(key, m(value));
                return;
            }
            if (d3 instanceof f3) {
                f3Var = key.E((f3) d3, (f3) value);
            } else {
                t1 t1Var = (t1) ((t1.a) key.o(((c3) d3).e(), (c3) value)).j();
                boolean isInitialized = t1Var.isInitialized();
                f3Var = t1Var;
                if (!isInitialized) {
                    throw new b4();
                }
            }
            this.f3910a.put(key, f3Var == 1 ? 1 : 0);
        } else {
            this.f3910a.put(key, m(value));
        }
    }

    public final void l() {
        if (!this.f3911b) {
            this.f3910a.g();
            this.f3911b = true;
        }
    }
}
