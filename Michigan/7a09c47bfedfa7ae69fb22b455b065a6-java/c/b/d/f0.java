package c.b.d;

import c.b.d.f0.c;
import c.b.d.i1;
import c.b.d.n0;
import c.b.d.q0;
import c.b.d.x2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class f0<T extends c<T>> {

    /* renamed from: d  reason: collision with root package name */
    public static final f0 f5261d = new f0(true);

    /* renamed from: a  reason: collision with root package name */
    public final h2<T, Object> f5262a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5263b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5264c;

    public static final class b<T extends c<T>> {

        /* renamed from: a  reason: collision with root package name */
        public h2<T, Object> f5265a = h2.i(16);

        /* renamed from: b  reason: collision with root package name */
        public boolean f5266b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5267c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5268d;

        public b(a aVar) {
        }

        public static Object e(Object obj) {
            return obj instanceof i1.a ? ((i1.a) obj).build() : obj;
        }

        public static <T extends c<T>> Object f(T t, Object obj) {
            if (obj == null || t.j() != x2.c.MESSAGE) {
                return obj;
            }
            if (!t.e()) {
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
            StringBuilder h = c.a.a.a.a.h("Repeated field should contains a List but actually contains type: ");
            h.append(obj.getClass());
            throw new IllegalStateException(h.toString());
        }

        public static <T extends c<T>> void g(h2<T, Object> h2Var) {
            for (int i = 0; i < h2Var.e(); i++) {
                Map.Entry<T, Object> d2 = h2Var.d(i);
                d2.setValue(f(d2.getKey(), d2.getValue()));
            }
            for (Map.Entry<T, Object> entry : h2Var.f()) {
                entry.setValue(f(entry.getKey(), entry.getValue()));
            }
        }

        public static void j(x2.b bVar, Object obj) {
            if (f0.v(bVar, obj)) {
                return;
            }
            if (bVar.f5925b != x2.c.MESSAGE || !(obj instanceof i1.a)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }

        public final void a() {
            if (!this.f5267c) {
                this.f5265a = f0.d(this.f5265a, true);
                this.f5267c = true;
            }
        }

        public Object b(T t) {
            Object obj = this.f5265a.get(t);
            return obj instanceof q0 ? ((q0) obj).c() : obj;
        }

        public Object c(T t, int i) {
            if (t.e()) {
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
            h2<T, Object> h2Var;
            T key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof q0) {
                value = ((q0) value).c();
            }
            if (key.e()) {
                Object f2 = f(key, b(key));
                if (f2 == null) {
                    f2 = new ArrayList();
                }
                for (Object obj2 : (List) value) {
                    ((List) f2).add(f0.f(obj2));
                }
                this.f5265a.put(key, f2);
                return;
            }
            if (key.j() == x2.c.MESSAGE) {
                Object f3 = f(key, b(key));
                if (f3 == null) {
                    h2Var = this.f5265a;
                } else if (f3 instanceof i1.a) {
                    key.O((i1.a) f3, (i1) value);
                    return;
                } else {
                    obj = key.O(((i1) f3).toBuilder(), (i1) value).build();
                    h2Var = this.f5265a;
                    h2Var.put(key, obj);
                }
            } else {
                h2Var = this.f5265a;
            }
            obj = f0.f(value);
            h2Var.put(key, obj);
        }

        public void h(T t, Object obj) {
            a();
            boolean z = false;
            if (!t.e()) {
                j(t.g(), obj);
            } else if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    j(t.g(), next);
                    this.f5268d = this.f5268d || (next instanceof i1.a);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            if (obj instanceof q0) {
                this.f5266b = true;
            }
            if (this.f5268d || (obj instanceof i1.a)) {
                z = true;
            }
            this.f5268d = z;
            this.f5265a.put(t, obj);
        }

        public void i(T t, int i, Object obj) {
            a();
            if (t.e()) {
                this.f5268d = this.f5268d || (obj instanceof i1.a);
                Object f2 = f(t, b(t));
                if (f2 != null) {
                    j(t.g(), obj);
                    ((List) f2).set(i, obj);
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }

    public interface c<T extends c<T>> extends Comparable<T> {
        i1.a O(i1.a aVar, i1 i1Var);

        int a();

        boolean e();

        x2.b g();

        x2.c j();

        boolean l();
    }

    public f0() {
        this.f5262a = h2.i(16);
    }

    public f0(h2 h2Var, a aVar) {
        this.f5262a = h2Var;
        x();
    }

    public static <T extends c<T>> b<T> A() {
        return new b<>(null);
    }

    public static void D(m mVar, x2.b bVar, int i, Object obj) {
        if (bVar == x2.b.GROUP) {
            mVar.r0(i, 3);
            ((i1) obj).writeTo(mVar);
            mVar.r0(i, 4);
            return;
        }
        mVar.r0(i, q(bVar, false));
        E(mVar, bVar, obj);
    }

    public static void E(m mVar, x2.b bVar, Object obj) {
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
                ((i1) obj).writeTo(mVar);
                return;
            case 10:
                mVar.m0((i1) obj);
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
                if (obj instanceof n0.c) {
                    i = ((n0.c) obj).a();
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
        x2.b g2 = cVar.g();
        int a2 = cVar.a();
        if (cVar.e()) {
            List<Object> list = (List) obj;
            if (cVar.l()) {
                mVar.r0(a2, 2);
                int i = 0;
                for (Object obj2 : list) {
                    i += h(g2, obj2);
                }
                mVar.t0(i);
                for (Object obj3 : list) {
                    E(mVar, g2, obj3);
                }
                return;
            }
            for (Object obj4 : list) {
                D(mVar, g2, a2, obj4);
            }
        } else if (obj instanceof q0) {
            D(mVar, g2, a2, ((q0) obj).c());
        } else {
            D(mVar, g2, a2, obj);
        }
    }

    public static <T extends c<T>> h2<T, Object> d(h2<T, Object> h2Var, boolean z) {
        h2<T, Object> i = h2.i(16);
        for (int i2 = 0; i2 < h2Var.e(); i2++) {
            e(i, h2Var.d(i2), z);
        }
        for (Map.Entry<T, Object> entry : h2Var.f()) {
            e(i, entry, z);
        }
        return i;
    }

    public static <T extends c<T>> void e(Map<T, Object> map, Map.Entry<T, Object> entry, boolean z) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof q0) {
            value = ((q0) value).c();
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

    public static int g(x2.b bVar, int i, Object obj) {
        int N = m.N(i);
        if (bVar == x2.b.GROUP) {
            N *= 2;
        }
        return h(bVar, obj) + N;
    }

    public static int h(x2.b bVar, Object obj) {
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
                return m.r((i1) obj);
            case 10:
                return obj instanceof q0 ? m.w((q0) obj) : m.A((i1) obj);
            case 11:
                return obj instanceof j ? m.g((j) obj) : m.e((byte[]) obj);
            case 12:
                return m.P(((Integer) obj).intValue());
            case 13:
                if (obj instanceof n0.c) {
                    return m.t(((n0.c) obj).a());
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
        x2.b g2 = cVar.g();
        int a2 = cVar.a();
        if (!cVar.e()) {
            return g(g2, a2, obj);
        }
        int i = 0;
        List<Object> list = (List) obj;
        if (cVar.l()) {
            for (Object obj2 : list) {
                i += h(g2, obj2);
            }
            return m.N(a2) + i + m.P(i);
        }
        for (Object obj3 : list) {
            i += g(g2, a2, obj3);
        }
        return i;
    }

    public static int q(x2.b bVar, boolean z) {
        if (z) {
            return 2;
        }
        return bVar.f5926c;
    }

    public static <T extends c<T>> boolean u(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.j() == x2.c.MESSAGE) {
            boolean e2 = key.e();
            Object value = entry.getValue();
            if (e2) {
                for (i1 i1Var : (List) value) {
                    if (!i1Var.isInitialized()) {
                        return false;
                    }
                }
            } else if (value instanceof i1) {
                if (!((i1) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof q0) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    public static boolean v(x2.b bVar, Object obj) {
        n0.a(obj);
        switch (bVar.f5925b.ordinal()) {
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
                return (obj instanceof Integer) || (obj instanceof n0.c);
            case 8:
                return (obj instanceof i1) || (obj instanceof q0);
            default:
                return false;
        }
    }

    public void B(T t, Object obj) {
        if (!t.e()) {
            C(t.g(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C(t.g(), it.next());
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof q0) {
            this.f5264c = true;
        }
        this.f5262a.put(t, obj);
    }

    public final void C(x2.b bVar, Object obj) {
        if (!v(bVar, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public final void G(Map.Entry<T, Object> entry, m mVar) {
        T key = entry.getKey();
        if (key.j() != x2.c.MESSAGE || key.e() || key.l()) {
            F(key, entry.getValue(), mVar);
            return;
        }
        Object value = entry.getValue();
        if (value instanceof q0) {
            value = ((q0) value).c();
        }
        mVar.n0(entry.getKey().a(), (i1) value);
    }

    public void a(T t, Object obj) {
        List list;
        if (t.e()) {
            C(t.g(), obj);
            Object k = k(t);
            if (k == null) {
                list = new ArrayList();
                this.f5262a.put(t, list);
            } else {
                list = (List) k;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public void b(T t) {
        this.f5262a.remove(t);
        if (this.f5262a.isEmpty()) {
            this.f5264c = false;
        }
    }

    /* renamed from: c */
    public f0<T> clone() {
        f0<T> f0Var = new f0<>();
        for (int i = 0; i < this.f5262a.e(); i++) {
            Map.Entry<T, Object> d2 = this.f5262a.d(i);
            f0Var.B(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f5262a.f()) {
            f0Var.B(entry.getKey(), entry.getValue());
        }
        f0Var.f5264c = this.f5264c;
        return f0Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        return this.f5262a.equals(((f0) obj).f5262a);
    }

    public int hashCode() {
        return this.f5262a.hashCode();
    }

    public Map<T, Object> j() {
        if (this.f5264c) {
            h2 d2 = d(this.f5262a, false);
            if (this.f5262a.f5298e) {
                d2.h();
            }
            return d2;
        }
        h2<T, Object> h2Var = this.f5262a;
        return h2Var.f5298e ? h2Var : Collections.unmodifiableMap(h2Var);
    }

    public Object k(T t) {
        Object obj = this.f5262a.get(t);
        return obj instanceof q0 ? ((q0) obj).c() : obj;
    }

    public int l() {
        int i = 0;
        for (int i2 = 0; i2 < this.f5262a.e(); i2++) {
            i += m(this.f5262a.d(i2));
        }
        for (Map.Entry<T, Object> entry : this.f5262a.f()) {
            i += m(entry);
        }
        return i;
    }

    public final int m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.j() != x2.c.MESSAGE || key.e() || key.l()) {
            return i(key, value);
        }
        boolean z = value instanceof q0;
        int a2 = entry.getKey().a();
        if (!z) {
            return m.y(a2, (i1) value);
        }
        return m.w((q0) value) + m.N(3) + m.O(2, a2) + (m.N(1) * 2);
    }

    public Object n(T t, int i) {
        if (t.e()) {
            Object k = k(t);
            if (k != null) {
                return ((List) k).get(i);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int o(T t) {
        if (t.e()) {
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
        for (int i2 = 0; i2 < this.f5262a.e(); i2++) {
            Map.Entry<T, Object> d2 = this.f5262a.d(i2);
            i += i(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f5262a.f()) {
            i += i(entry.getKey(), entry.getValue());
        }
        return i;
    }

    public boolean r(T t) {
        if (!t.e()) {
            return this.f5262a.get(t) != null;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    public boolean s() {
        return this.f5262a.isEmpty();
    }

    public boolean t() {
        for (int i = 0; i < this.f5262a.e(); i++) {
            if (!u(this.f5262a.d(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f5262a.f()) {
            if (!u(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> w() {
        return this.f5264c ? new q0.c(this.f5262a.entrySet().iterator()) : this.f5262a.entrySet().iterator();
    }

    public void x() {
        if (!this.f5263b) {
            this.f5262a.h();
            this.f5263b = true;
        }
    }

    public void y(f0<T> f0Var) {
        for (int i = 0; i < f0Var.f5262a.e(); i++) {
            z(f0Var.f5262a.d(i));
        }
        for (Map.Entry<T, Object> entry : f0Var.f5262a.f()) {
            z(entry);
        }
    }

    public final void z(Map.Entry<T, Object> entry) {
        Object obj;
        h2<T, Object> h2Var;
        Object k;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof q0) {
            value = ((q0) value).c();
        }
        if (key.e()) {
            Object k2 = k(key);
            if (k2 == null) {
                k2 = new ArrayList();
            }
            for (Object obj2 : (List) value) {
                ((List) k2).add(f(obj2));
            }
            this.f5262a.put(key, k2);
            return;
        }
        if (key.j() != x2.c.MESSAGE || (k = k(key)) == null) {
            h2Var = this.f5262a;
            obj = f(value);
        } else {
            obj = key.O(((i1) k).toBuilder(), (i1) value).build();
            h2Var = this.f5262a;
        }
        h2Var.put(key, obj);
    }

    public f0(boolean z) {
        this.f5262a = h2.i(0);
        x();
        x();
    }
}
