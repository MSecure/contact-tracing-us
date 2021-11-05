package c.b.c.a.j0.a;

import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.d0;
import c.b.c.a.j0.a.r0;
import c.b.c.a.j0.a.u.a;
import c.b.c.a.j0.a.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class u<T extends a<T>> {

    /* renamed from: d  reason: collision with root package name */
    public static final u f3651d = new u(true);

    /* renamed from: a  reason: collision with root package name */
    public final i1<T, Object> f3652a = i1.i(16);

    /* renamed from: b  reason: collision with root package name */
    public boolean f3653b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3654c;

    public interface a<T extends a<T>> extends Comparable<T> {
        int a();

        boolean c();

        s1 e();

        t1 h();

        boolean j();

        r0.a m(r0.a aVar, r0 r0Var);
    }

    public u() {
    }

    public u(boolean z) {
        l();
        l();
    }

    public static Object b(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int c(s1 s1Var, int i, Object obj) {
        int G = l.G(i);
        if (s1Var == s1.GROUP) {
            G *= 2;
        }
        return d(s1Var, obj) + G;
    }

    public static int d(s1 s1Var, Object obj) {
        switch (s1Var.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                l.g();
                return 8;
            case 1:
                ((Float) obj).floatValue();
                l.n();
                return 4;
            case 2:
                return l.K(((Long) obj).longValue());
            case 3:
                return l.K(((Long) obj).longValue());
            case 4:
                return l.r(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                l.l();
                return 8;
            case 6:
                ((Integer) obj).intValue();
                l.j();
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                l.b();
                return 1;
            case 8:
                return obj instanceof i ? l.e((i) obj) : l.F((String) obj);
            case 9:
                return l.p((r0) obj);
            case 10:
                return obj instanceof d0 ? l.t((d0) obj) : l.v((r0) obj);
            case 11:
                return obj instanceof i ? l.e((i) obj) : l.c((byte[]) obj);
            case 12:
                return l.I(((Integer) obj).intValue());
            case 13:
                if (obj instanceof a0.a) {
                    return l.r(((a0.a) obj).a());
                }
                return l.r(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                l.x();
                return 4;
            case 15:
                ((Long) obj).longValue();
                l.z();
                return 8;
            case 16:
                return l.B(((Integer) obj).intValue());
            case 17:
                return l.D(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int e(a<?> aVar, Object obj) {
        s1 e2 = aVar.e();
        int a2 = aVar.a();
        if (!aVar.c()) {
            return c(e2, a2, obj);
        }
        int i = 0;
        List<Object> list = (List) obj;
        if (aVar.j()) {
            for (Object obj2 : list) {
                i += d(e2, obj2);
            }
            return l.G(a2) + i + l.I(i);
        }
        for (Object obj3 : list) {
            i += c(e2, a2, obj3);
        }
        return i;
    }

    public static <T extends a<T>> boolean j(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.h() == t1.MESSAGE) {
            boolean c2 = key.c();
            Object value = entry.getValue();
            if (c2) {
                for (r0 r0Var : (List) value) {
                    if (!r0Var.isInitialized()) {
                        return false;
                    }
                }
            } else if (value instanceof r0) {
                if (!((r0) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof d0) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    /* renamed from: a */
    public u<T> clone() {
        u<T> uVar = new u<>();
        for (int i = 0; i < this.f3652a.e(); i++) {
            Map.Entry<T, Object> d2 = this.f3652a.d(i);
            uVar.n(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f3652a.f()) {
            uVar.n(entry.getKey(), entry.getValue());
        }
        uVar.f3654c = this.f3654c;
        return uVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        return this.f3652a.equals(((u) obj).f3652a);
    }

    public Object f(T t) {
        Object obj = this.f3652a.get(t);
        return obj instanceof d0 ? ((d0) obj).c() : obj;
    }

    public final int g(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.h() != t1.MESSAGE || key.c() || key.j()) {
            return e(key, value);
        }
        boolean z = value instanceof d0;
        int a2 = entry.getKey().a();
        if (z) {
            return l.t((d0) value) + l.G(3) + l.H(2, a2) + (l.G(1) * 2);
        }
        return l.u(((r0) value).getSerializedSize()) + l.G(3) + l.H(2, a2) + (l.G(1) * 2);
    }

    public boolean h() {
        return this.f3652a.isEmpty();
    }

    public int hashCode() {
        return this.f3652a.hashCode();
    }

    public boolean i() {
        for (int i = 0; i < this.f3652a.e(); i++) {
            if (!j(this.f3652a.d(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f3652a.f()) {
            if (!j(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> k() {
        return this.f3654c ? new d0.c(this.f3652a.entrySet().iterator()) : this.f3652a.entrySet().iterator();
    }

    public void l() {
        if (!this.f3653b) {
            this.f3652a.h();
            this.f3653b = true;
        }
    }

    public final void m(Map.Entry<T, Object> entry) {
        Object obj;
        i1<T, Object> i1Var;
        Object f;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof d0) {
            value = ((d0) value).c();
        }
        if (key.c()) {
            Object f2 = f(key);
            if (f2 == null) {
                f2 = new ArrayList();
            }
            for (Object obj2 : (List) value) {
                ((List) f2).add(b(obj2));
            }
            this.f3652a.put(key, f2);
            return;
        }
        if (key.h() != t1.MESSAGE || (f = f(key)) == null) {
            i1Var = this.f3652a;
            obj = b(value);
        } else {
            obj = ((y.a) key.m(((r0) f).toBuilder(), (r0) value)).b();
            i1Var = this.f3652a;
        }
        i1Var.put(key, obj);
    }

    public void n(T t, Object obj) {
        if (!t.c()) {
            o(t.e(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                o(t.e(), it.next());
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof d0) {
            this.f3654c = true;
        }
        this.f3652a.put(t, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if ((r4 instanceof byte[]) == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0015, code lost:
        if ((r4 instanceof c.b.c.a.j0.a.d0) == false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        if ((r4 instanceof c.b.c.a.j0.a.a0.a) == false) goto L_0x002a;
     */
    public final void o(s1 s1Var, Object obj) {
        a0.a(obj);
        boolean z = true;
        boolean z2 = false;
        switch (s1Var.f3638b.ordinal()) {
            case 0:
                z2 = obj instanceof Integer;
                break;
            case 1:
                z2 = obj instanceof Long;
                break;
            case 2:
                z2 = obj instanceof Float;
                break;
            case 3:
                z2 = obj instanceof Double;
                break;
            case 4:
                z2 = obj instanceof Boolean;
                break;
            case 5:
                z2 = obj instanceof String;
                break;
            case 6:
                if (!(obj instanceof i)) {
                    break;
                }
                z2 = z;
                break;
            case 7:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z2 = z;
                break;
            case 8:
                if (!(obj instanceof r0)) {
                    break;
                }
                z2 = z;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }
}
