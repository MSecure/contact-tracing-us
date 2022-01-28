package f.b.g;

import f.b.g.c0;
import f.b.g.f0;
import f.b.g.t0;
import f.b.g.v.a;
import f.b.g.z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public final class v<T extends a<T>> {

    /* renamed from: d  reason: collision with root package name */
    public static final v f3622d = new v(true);
    public final n1<T, Object> a = new m1(16);
    public boolean b;
    public boolean c;

    public interface a<T extends a<T>> extends Comparable<T> {
        boolean d();

        y1 g();

        int getNumber();

        z1 j();

        boolean k();

        t0.a p(t0.a aVar, t0 t0Var);
    }

    public v() {
        int i2 = n1.f3608h;
    }

    public static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int d(y1 y1Var, int i2, Object obj) {
        int y = m.y(i2);
        if (y1Var == y1.GROUP) {
            y *= 2;
        }
        return e(y1Var, obj) + y;
    }

    public static int e(y1 y1Var, Object obj) {
        switch (y1Var.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                Logger logger = m.b;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                Logger logger2 = m.b;
                return 4;
            case 2:
                return m.C(((Long) obj).longValue());
            case 3:
                return m.C(((Long) obj).longValue());
            case 4:
                return m.m(((Integer) obj).intValue());
            case 5:
            case 15:
                ((Long) obj).longValue();
                Logger logger3 = m.b;
                return 8;
            case 6:
            case 14:
                ((Integer) obj).intValue();
                Logger logger22 = m.b;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                Logger logger4 = m.b;
                return 1;
            case 8:
                return obj instanceof j ? m.e((j) obj) : m.x((String) obj);
            case 9:
                Logger logger5 = m.b;
                return ((t0) obj).getSerializedSize();
            case 10:
                if (obj instanceof f0) {
                    return m.o((f0) obj);
                }
                Logger logger6 = m.b;
                return m.p(((t0) obj).getSerializedSize());
            case 11:
                if (obj instanceof j) {
                    return m.e((j) obj);
                }
                Logger logger7 = m.b;
                return m.p(((byte[]) obj).length);
            case 12:
                return m.A(((Integer) obj).intValue());
            case 13:
                if (obj instanceof c0.c) {
                    return m.m(((c0.c) obj).getNumber());
                }
                return m.m(((Integer) obj).intValue());
            case 16:
                return m.t(((Integer) obj).intValue());
            case 17:
                return m.v(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(a<?> aVar, Object obj) {
        y1 g2 = aVar.g();
        int number = aVar.getNumber();
        if (!aVar.d()) {
            return d(g2, number, obj);
        }
        int i2 = 0;
        List<Object> list = (List) obj;
        if (aVar.k()) {
            for (Object obj2 : list) {
                i2 += e(g2, obj2);
            }
            return m.y(number) + i2 + m.A(i2);
        }
        for (Object obj3 : list) {
            i2 += d(g2, number, obj3);
        }
        return i2;
    }

    public static <T extends a<T>> boolean k(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.j() == z1.MESSAGE) {
            boolean d2 = key.d();
            Object value = entry.getValue();
            if (d2) {
                for (t0 t0Var : (List) value) {
                    if (!t0Var.isInitialized()) {
                        return false;
                    }
                }
            } else if (value instanceof t0) {
                if (!((t0) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof f0) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    public static void q(m mVar, y1 y1Var, int i2, Object obj) {
        if (y1Var == y1.GROUP) {
            mVar.Y(i2, 3);
            ((t0) obj).writeTo(mVar);
            mVar.Y(i2, 4);
            return;
        }
        mVar.Y(i2, y1Var.c);
        switch (y1Var.ordinal()) {
            case 0:
                mVar.P(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                return;
            case 1:
                mVar.N(Float.floatToRawIntBits(((Float) obj).floatValue()));
                return;
            case 2:
                mVar.c0(((Long) obj).longValue());
                return;
            case 3:
                mVar.c0(((Long) obj).longValue());
                return;
            case 4:
                mVar.R(((Integer) obj).intValue());
                return;
            case 5:
                mVar.P(((Long) obj).longValue());
                return;
            case 6:
                mVar.N(((Integer) obj).intValue());
                return;
            case 7:
                mVar.H(((Boolean) obj).booleanValue() ? (byte) 1 : 0);
                return;
            case 8:
                if (!(obj instanceof j)) {
                    mVar.X((String) obj);
                    return;
                }
                break;
            case 9:
                ((t0) obj).writeTo(mVar);
                return;
            case 10:
                mVar.T((t0) obj);
                return;
            case 11:
                if (!(obj instanceof j)) {
                    byte[] bArr = (byte[]) obj;
                    mVar.J(bArr, 0, bArr.length);
                    return;
                }
                break;
            case 12:
                mVar.a0(((Integer) obj).intValue());
                return;
            case 13:
                mVar.R(obj instanceof c0.c ? ((c0.c) obj).getNumber() : ((Integer) obj).intValue());
                return;
            case 14:
                mVar.N(((Integer) obj).intValue());
                return;
            case 15:
                mVar.P(((Long) obj).longValue());
                return;
            case 16:
                mVar.a0(m.D(((Integer) obj).intValue()));
                return;
            case 17:
                mVar.c0(m.E(((Long) obj).longValue()));
                return;
            default:
                return;
        }
        mVar.L((j) obj);
    }

    public void a(T t, Object obj) {
        List list;
        if (((z.d) t).f3666e) {
            p(((z.d) t).f3665d, obj);
            Object g2 = g(t);
            if (g2 == null) {
                list = new ArrayList();
                this.a.put(t, list);
            } else {
                list = (List) g2;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b */
    public v<T> clone() {
        v<T> vVar = new v<>();
        for (int i2 = 0; i2 < this.a.d(); i2++) {
            Map.Entry<T, Object> c2 = this.a.c(i2);
            vVar.o(c2.getKey(), c2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.a.e()) {
            vVar.o(entry.getKey(), entry.getValue());
        }
        vVar.c = this.c;
        return vVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return this.a.equals(((v) obj).a);
    }

    public Object g(T t) {
        Object obj = this.a.get(t);
        return obj instanceof f0 ? ((f0) obj).c() : obj;
    }

    public final int h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.j() != z1.MESSAGE || key.d() || key.k()) {
            return f(key, value);
        }
        boolean z = value instanceof f0;
        int number = entry.getKey().getNumber();
        if (z) {
            return m.o((f0) value) + m.y(3) + m.z(2, number) + (m.y(1) * 2);
        }
        return m.p(((t0) value).getSerializedSize()) + m.y(3) + m.z(2, number) + (m.y(1) * 2);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i() {
        return this.a.isEmpty();
    }

    public boolean j() {
        for (int i2 = 0; i2 < this.a.d(); i2++) {
            if (!k(this.a.c(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.a.e()) {
            if (!k(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> l() {
        return this.c ? new f0.c(this.a.entrySet().iterator()) : this.a.entrySet().iterator();
    }

    public void m() {
        if (!this.b) {
            this.a.g();
            this.b = true;
        }
    }

    public final void n(Map.Entry<T, Object> entry) {
        Object obj;
        n1<T, Object> n1Var;
        Object g2;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof f0) {
            value = ((f0) value).c();
        }
        if (key.d()) {
            Object g3 = g(key);
            if (g3 == null) {
                g3 = new ArrayList();
            }
            for (Object obj2 : (List) value) {
                ((List) g3).add(c(obj2));
            }
            this.a.put(key, g3);
            return;
        }
        if (key.j() != z1.MESSAGE || (g2 = g(key)) == null) {
            n1Var = this.a;
            obj = c(value);
        } else {
            obj = key.p(((t0) g2).toBuilder(), (t0) value).build();
            n1Var = this.a;
        }
        n1Var.put(key, obj);
    }

    public void o(T t, Object obj) {
        if (!t.d()) {
            p(t.g(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                p(t.g(), it.next());
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof f0) {
            this.c = true;
        }
        this.a.put(t, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if ((r4 instanceof byte[]) == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if ((r4 instanceof f.b.g.f0) == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r4 instanceof f.b.g.c0.c) == false) goto L_0x002c;
     */
    public final void p(y1 y1Var, Object obj) {
        Charset charset = c0.a;
        Objects.requireNonNull(obj);
        boolean z = true;
        boolean z2 = false;
        switch (y1Var.b.ordinal()) {
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
                if (!(obj instanceof j)) {
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
                if (!(obj instanceof t0)) {
                    break;
                }
                z2 = z;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public v(boolean z) {
        int i2 = n1.f3608h;
        m();
        m();
    }
}
