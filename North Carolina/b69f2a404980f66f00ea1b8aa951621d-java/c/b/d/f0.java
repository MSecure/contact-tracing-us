package c.b.d;

import c.b.d.f0.c;
import c.b.d.h1;
import c.b.d.m0;
import c.b.d.p0;
import c.b.d.w2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f0<T extends c<T>> {

    /* renamed from: d  reason: collision with root package name */
    public static final f0 f3858d = new f0(true);

    /* renamed from: a  reason: collision with root package name */
    public final g2<T, Object> f3859a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3860b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3861c;

    public static final class b<T extends c<T>> {

        /* renamed from: a  reason: collision with root package name */
        public g2<T, Object> f3862a = g2.i(16);

        /* renamed from: b  reason: collision with root package name */
        public boolean f3863b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3864c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3865d;

        public b(a aVar) {
        }

        public static Object e(Object obj) {
            return obj instanceof h1.a ? ((h1.a) obj).build() : obj;
        }

        public static <T extends c<T>> Object f(T t, Object obj) {
            if (obj == null || t.h() != w2.c.MESSAGE) {
                return obj;
            }
            if (!t.c()) {
                return e(obj);
            }
            if (obj instanceof List) {
                List list = (List) obj;
                for (int i = 0; i < list.size(); i++) {
                    Object obj2 = list.get(i);
                    Object e2 = e(obj2);
                    if (e2 != obj2) {
                        if (list == obj) {
                            list = new ArrayList(list);
                        }
                        list.set(i, e2);
                    }
                }
                return list;
            }
            StringBuilder g = c.a.a.a.a.g("Repeated field should contains a List but actually contains type: ");
            g.append(obj.getClass());
            throw new IllegalStateException(g.toString());
        }

        public static <T extends c<T>> void g(g2<T, Object> g2Var) {
            for (int i = 0; i < g2Var.e(); i++) {
                Map.Entry<T, Object> d2 = g2Var.d(i);
                d2.setValue(f(d2.getKey(), d2.getValue()));
            }
            for (Map.Entry<T, Object> entry : g2Var.f()) {
                entry.setValue(f(entry.getKey(), entry.getValue()));
            }
        }

        public static void j(w2.b bVar, Object obj) {
            if (f0.v(bVar, obj)) {
                return;
            }
            if (bVar.f4373b != w2.c.MESSAGE || !(obj instanceof h1.a)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }

        public final void a() {
            if (!this.f3864c) {
                this.f3862a = f0.d(this.f3862a, true);
                this.f3864c = true;
            }
        }

        public Object b(T t) {
            Object obj = this.f3862a.get(t);
            return obj instanceof p0 ? ((p0) obj).c() : obj;
        }

        public Object c(T t, int i) {
            if (t.c()) {
                Object b2 = b(t);
                if (b2 != null) {
                    return ((List) b2).get(i);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }

        public final void d(Map.Entry<T, Object> entry) {
            Object obj;
            g2<T, Object> g2Var;
            T key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof p0) {
                value = ((p0) value).c();
            }
            if (key.c()) {
                Object f = f(key, b(key));
                if (f == null) {
                    f = new ArrayList();
                }
                for (Object obj2 : (List) value) {
                    ((List) f).add(f0.f(obj2));
                }
                this.f3862a.put(key, f);
                return;
            }
            if (key.h() == w2.c.MESSAGE) {
                Object f2 = f(key, b(key));
                if (f2 == null) {
                    g2Var = this.f3862a;
                } else if (f2 instanceof h1.a) {
                    key.r((h1.a) f2, (h1) value);
                    return;
                } else {
                    obj = key.r(((h1) f2).toBuilder(), (h1) value).build();
                    g2Var = this.f3862a;
                    g2Var.put(key, obj);
                }
            } else {
                g2Var = this.f3862a;
            }
            obj = f0.f(value);
            g2Var.put(key, obj);
        }

        public void h(T t, Object obj) {
            a();
            boolean z = false;
            if (!t.c()) {
                j(t.e(), obj);
            } else if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    j(t.e(), next);
                    this.f3865d = this.f3865d || (next instanceof h1.a);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            if (obj instanceof p0) {
                this.f3863b = true;
            }
            if (this.f3865d || (obj instanceof h1.a)) {
                z = true;
            }
            this.f3865d = z;
            this.f3862a.put(t, obj);
        }

        public void i(T t, int i, Object obj) {
            a();
            if (t.c()) {
                this.f3865d = this.f3865d || (obj instanceof h1.a);
                Object f = f(t, b(t));
                if (f != null) {
                    j(t.e(), obj);
                    ((List) f).set(i, obj);
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }

    public interface c<T extends c<T>> extends Comparable<T> {
        int a();

        boolean c();

        w2.b e();

        w2.c h();

        boolean j();

        h1.a r(h1.a aVar, h1 h1Var);
    }

    public f0() {
        this.f3859a = g2.i(16);
    }

    public f0(g2 g2Var, a aVar) {
        this.f3859a = g2Var;
        x();
    }

    public static <T extends c<T>> b<T> A() {
        return new b<>(null);
    }

    public static void D(m mVar, w2.b bVar, int i, Object obj) {
        if (bVar == w2.b.GROUP) {
            mVar.r0(i, 3);
            ((h1) obj).writeTo(mVar);
            mVar.r0(i, 4);
            return;
        }
        mVar.r0(i, q(bVar, false));
        E(mVar, bVar, obj);
    }

    public static void E(m mVar, w2.b bVar, Object obj) {
        int i;
        switch (bVar.ordinal()) {
            case 0:
                mVar.g0(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                mVar.e0(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                mVar.v0(((Long) obj).longValue());
                return;
            case 3:
                mVar.v0(((Long) obj).longValue());
                return;
            case 4:
                mVar.j0(((Integer) obj).intValue());
                return;
            case 5:
                mVar.g0(((Long) obj).longValue());
                return;
            case 6:
                mVar.e0(((Integer) obj).intValue());
                return;
            case 7:
                mVar.X(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                return;
            case 8:
                if (!(obj instanceof j)) {
                    mVar.q0((String) obj);
                    return;
                }
                break;
            case 9:
                ((h1) obj).writeTo(mVar);
                return;
            case 10:
                mVar.m0((h1) obj);
                return;
            case 11:
                if (!(obj instanceof j)) {
                    byte[] bArr = (byte[]) obj;
                    mVar.Z(bArr, 0, bArr.length);
                    return;
                }
                break;
            case 12:
                mVar.t0(((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof m0.c) {
                    i = ((m0.c) obj).a();
                } else {
                    i = ((Integer) obj).intValue();
                }
                mVar.j0(i);
                return;
            case 14:
                mVar.e0(((Integer) obj).intValue());
                return;
            case 15:
                mVar.g0(((Long) obj).longValue());
                return;
            case 16:
                mVar.t0(m.S(((Integer) obj).intValue()));
                return;
            case 17:
                mVar.v0(m.T(((Long) obj).longValue()));
                return;
            default:
                return;
        }
        mVar.b0((j) obj);
    }

    public static void F(c<?> cVar, Object obj, m mVar) {
        w2.b e2 = cVar.e();
        int a2 = cVar.a();
        if (cVar.c()) {
            List<Object> list = (List) obj;
            if (cVar.j()) {
                mVar.r0(a2, 2);
                int i = 0;
                for (Object obj2 : list) {
                    i += h(e2, obj2);
                }
                mVar.t0(i);
                for (Object obj3 : list) {
                    E(mVar, e2, obj3);
                }
                return;
            }
            for (Object obj4 : list) {
                D(mVar, e2, a2, obj4);
            }
        } else if (obj instanceof p0) {
            D(mVar, e2, a2, ((p0) obj).c());
        } else {
            D(mVar, e2, a2, obj);
        }
    }

    public static <T extends c<T>> g2<T, Object> d(g2<T, Object> g2Var, boolean z) {
        g2<T, Object> i = g2.i(16);
        for (int i2 = 0; i2 < g2Var.e(); i2++) {
            e(i, g2Var.d(i2), z);
        }
        for (Map.Entry<T, Object> entry : g2Var.f()) {
            e(i, entry, z);
        }
        return i;
    }

    public static <T extends c<T>> void e(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof p0) {
            value = ((p0) value).c();
        } else if (z && (value instanceof List)) {
            map.put(key, new ArrayList((List) value));
            return;
        }
        map.put(key, value);
    }

    public static Object f(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int g(w2.b bVar, int i, Object obj) {
        int N = m.N(i);
        if (bVar == w2.b.GROUP) {
            N *= 2;
        }
        return h(bVar, obj) + N;
    }

    public static int h(w2.b bVar, Object obj) {
        switch (bVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                m.i();
                return 8;
            case 1:
                ((Float) obj).floatValue();
                m.p();
                return 4;
            case 2:
                return m.R(((Long) obj).longValue());
            case 3:
                return m.R(((Long) obj).longValue());
            case 4:
                return m.t(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                m.n();
                return 8;
            case 6:
                ((Integer) obj).intValue();
                m.l();
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                m.d();
                return 1;
            case 8:
                return obj instanceof j ? m.g((j) obj) : m.M((String) obj);
            case 9:
                return m.r((h1) obj);
            case 10:
                return obj instanceof p0 ? m.w((p0) obj) : m.A((h1) obj);
            case 11:
                return obj instanceof j ? m.g((j) obj) : m.e((byte[]) obj);
            case 12:
                return m.P(((Integer) obj).intValue());
            case 13:
                if (obj instanceof m0.c) {
                    return m.t(((m0.c) obj).a());
                }
                return m.t(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                m.E();
                return 4;
            case 15:
                ((Long) obj).longValue();
                m.G();
                return 8;
            case 16:
                return m.I(((Integer) obj).intValue());
            case 17:
                return m.K(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int i(c<?> cVar, Object obj) {
        w2.b e2 = cVar.e();
        int a2 = cVar.a();
        if (!cVar.c()) {
            return g(e2, a2, obj);
        }
        int i = 0;
        List<Object> list = (List) obj;
        if (cVar.j()) {
            for (Object obj2 : list) {
                i += h(e2, obj2);
            }
            return m.N(a2) + i + m.P(i);
        }
        for (Object obj3 : list) {
            i += g(e2, a2, obj3);
        }
        return i;
    }

    public static int q(w2.b bVar, boolean z) {
        if (z) {
            return 2;
        }
        return bVar.f4374c;
    }

    public static <T extends c<T>> boolean u(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.h() == w2.c.MESSAGE) {
            boolean c2 = key.c();
            Object value = entry.getValue();
            if (c2) {
                for (h1 h1Var : (List) value) {
                    if (!h1Var.isInitialized()) {
                        return false;
                    }
                }
            } else if (value instanceof h1) {
                if (!((h1) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof p0) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    public static boolean v(w2.b bVar, Object obj) {
        m0.a(obj);
        switch (bVar.f4373b.ordinal()) {
            case 0:
                return obj instanceof Integer;
            case 1:
                return obj instanceof Long;
            case 2:
                return obj instanceof Float;
            case 3:
                return obj instanceof Double;
            case 4:
                return obj instanceof Boolean;
            case 5:
                return obj instanceof String;
            case 6:
                return (obj instanceof j) || (obj instanceof byte[]);
            case 7:
                return (obj instanceof Integer) || (obj instanceof m0.c);
            case 8:
                return (obj instanceof h1) || (obj instanceof p0);
            default:
                return false;
        }
    }

    public void B(T t, Object obj) {
        if (!t.c()) {
            C(t.e(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C(t.e(), it.next());
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof p0) {
            this.f3861c = true;
        }
        this.f3859a.put(t, obj);
    }

    public final void C(w2.b bVar, Object obj) {
        if (!v(bVar, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final void G(Map.Entry<T, Object> entry, m mVar) {
        T key = entry.getKey();
        if (key.h() != w2.c.MESSAGE || key.c() || key.j()) {
            F(key, entry.getValue(), mVar);
            return;
        }
        Object value = entry.getValue();
        if (value instanceof p0) {
            value = ((p0) value).c();
        }
        mVar.n0(entry.getKey().a(), (h1) value);
    }

    public void a(T t, Object obj) {
        List list;
        if (t.c()) {
            C(t.e(), obj);
            Object k = k(t);
            if (k == null) {
                list = new ArrayList();
                this.f3859a.put(t, list);
            } else {
                list = (List) k;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void b(T t) {
        this.f3859a.remove(t);
        if (this.f3859a.isEmpty()) {
            this.f3861c = false;
        }
    }

    /* renamed from: c */
    public f0<T> clone() {
        f0<T> f0Var = new f0<>();
        for (int i = 0; i < this.f3859a.e(); i++) {
            Map.Entry<T, Object> d2 = this.f3859a.d(i);
            f0Var.B(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f3859a.f()) {
            f0Var.B(entry.getKey(), entry.getValue());
        }
        f0Var.f3861c = this.f3861c;
        return f0Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        return this.f3859a.equals(((f0) obj).f3859a);
    }

    public int hashCode() {
        return this.f3859a.hashCode();
    }

    public Map<T, Object> j() {
        if (this.f3861c) {
            g2 d2 = d(this.f3859a, false);
            if (this.f3859a.f3884e) {
                d2.h();
            }
            return d2;
        }
        g2<T, Object> g2Var = this.f3859a;
        return g2Var.f3884e ? g2Var : Collections.unmodifiableMap(g2Var);
    }

    public Object k(T t) {
        Object obj = this.f3859a.get(t);
        return obj instanceof p0 ? ((p0) obj).c() : obj;
    }

    public int l() {
        int i = 0;
        for (int i2 = 0; i2 < this.f3859a.e(); i2++) {
            i += m(this.f3859a.d(i2));
        }
        for (Map.Entry<T, Object> entry : this.f3859a.f()) {
            i += m(entry);
        }
        return i;
    }

    public final int m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.h() != w2.c.MESSAGE || key.c() || key.j()) {
            return i(key, value);
        }
        boolean z = value instanceof p0;
        int a2 = entry.getKey().a();
        if (!z) {
            return m.y(a2, (h1) value);
        }
        return m.w((p0) value) + m.N(3) + m.O(2, a2) + (m.N(1) * 2);
    }

    public Object n(T t, int i) {
        if (t.c()) {
            Object k = k(t);
            if (k != null) {
                return ((List) k).get(i);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int o(T t) {
        if (t.c()) {
            Object k = k(t);
            if (k == null) {
                return 0;
            }
            return ((List) k).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int p() {
        int i = 0;
        for (int i2 = 0; i2 < this.f3859a.e(); i2++) {
            Map.Entry<T, Object> d2 = this.f3859a.d(i2);
            i += i(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f3859a.f()) {
            i += i(entry.getKey(), entry.getValue());
        }
        return i;
    }

    public boolean r(T t) {
        if (!t.c()) {
            return this.f3859a.get(t) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public boolean s() {
        return this.f3859a.isEmpty();
    }

    public boolean t() {
        for (int i = 0; i < this.f3859a.e(); i++) {
            if (!u(this.f3859a.d(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f3859a.f()) {
            if (!u(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> w() {
        return this.f3861c ? new p0.c(this.f3859a.entrySet().iterator()) : this.f3859a.entrySet().iterator();
    }

    public void x() {
        if (!this.f3860b) {
            this.f3859a.h();
            this.f3860b = true;
        }
    }

    public void y(f0<T> f0Var) {
        for (int i = 0; i < f0Var.f3859a.e(); i++) {
            z(f0Var.f3859a.d(i));
        }
        for (Map.Entry<T, Object> entry : f0Var.f3859a.f()) {
            z(entry);
        }
    }

    public final void z(Map.Entry<T, Object> entry) {
        Object obj;
        g2<T, Object> g2Var;
        Object k;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof p0) {
            value = ((p0) value).c();
        }
        if (key.c()) {
            Object k2 = k(key);
            if (k2 == null) {
                k2 = new ArrayList();
            }
            for (Object obj2 : (List) value) {
                ((List) k2).add(f(obj2));
            }
            this.f3859a.put(key, k2);
            return;
        }
        if (key.h() != w2.c.MESSAGE || (k = k(key)) == null) {
            g2Var = this.f3859a;
            obj = f(value);
        } else {
            obj = key.r(((h1) k).toBuilder(), (h1) value).build();
            g2Var = this.f3859a;
        }
        g2Var.put(key, obj);
    }

    public f0(boolean z) {
        this.f3859a = g2.i(0);
        x();
        x();
    }
}
