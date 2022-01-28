package c.b.a.a.g.b;

import c.b.a.a.g.b.t0;
import c.b.a.a.g.b.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class q0<FieldDescriptorType extends t0<FieldDescriptorType>> {

    /* renamed from: d  reason: collision with root package name */
    public static final q0 f3394d = new q0(true);

    /* renamed from: a  reason: collision with root package name */
    public final x2<FieldDescriptorType, Object> f3395a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3396b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3397c;

    public q0() {
        this.f3397c = false;
        this.f3395a = new y2(16);
    }

    public static int d(v3 v3Var, int i, Object obj) {
        int h0 = g0.h0(i);
        if (v3Var == v3.GROUP) {
            e2 e2Var = (e2) obj;
            h0 <<= 1;
        }
        return h(v3Var, obj) + h0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        if ((r3 instanceof c.b.a.a.g.b.c1) == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0019, code lost:
        if ((r3 instanceof c.b.a.a.g.b.i1) == false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    public static void f(v3 v3Var, Object obj) {
        b1.a(obj);
        boolean z = true;
        boolean z2 = false;
        switch (r0.f3400a[v3Var.f3446b.ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                z2 = z;
                if (z2) {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                return;
            case 2:
                z = obj instanceof Long;
                z2 = z;
                if (z2) {
                }
                break;
            case 3:
                z = obj instanceof Float;
                z2 = z;
                if (z2) {
                }
                break;
            case 4:
                z = obj instanceof Double;
                z2 = z;
                if (z2) {
                }
                break;
            case 5:
                z = obj instanceof Boolean;
                z2 = z;
                if (z2) {
                }
                break;
            case 6:
                z = obj instanceof String;
                z2 = z;
                if (z2) {
                }
                break;
            case 7:
                if (!(obj instanceof y)) {
                    break;
                }
                z2 = z;
                if (z2) {
                }
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z2 = z;
                if (z2) {
                }
                break;
            case 9:
                if (!(obj instanceof e2)) {
                    break;
                }
                z2 = z;
                if (z2) {
                }
                break;
            default:
                if (z2) {
                }
                break;
        }
    }

    public static int g(t0<?> t0Var, Object obj) {
        v3 I = t0Var.I();
        int c2 = t0Var.c();
        if (!t0Var.M()) {
            return d(I, c2, obj);
        }
        int i = 0;
        List<Object> list = (List) obj;
        if (t0Var.z()) {
            for (Object obj2 : list) {
                i += h(I, obj2);
            }
            return g0.h0(c2) + i + g0.j0(i);
        }
        for (Object obj3 : list) {
            i += d(I, c2, obj3);
        }
        return i;
    }

    public static int h(v3 v3Var, Object obj) {
        switch (r0.f3401b[v3Var.ordinal()]) {
            case 1:
                ((Double) obj).doubleValue();
                g0.x();
                return 8;
            case 2:
                ((Float) obj).floatValue();
                g0.n();
                return 4;
            case 3:
                return g0.P(((Long) obj).longValue());
            case 4:
                return g0.P(((Long) obj).longValue());
            case 5:
                return g0.i0(((Integer) obj).intValue());
            case 6:
                ((Long) obj).longValue();
                g0.U();
                return 8;
            case 7:
                ((Integer) obj).intValue();
                g0.l0();
                return 4;
            case 8:
                ((Boolean) obj).booleanValue();
                g0.z();
                return 1;
            case 9:
                return g0.J((e2) obj);
            case 10:
                return obj instanceof i1 ? g0.d((i1) obj) : g0.E((e2) obj);
            case 11:
                return obj instanceof y ? g0.q((y) obj) : g0.X((String) obj);
            case 12:
                return obj instanceof y ? g0.q((y) obj) : g0.K((byte[]) obj);
            case 13:
                return g0.j0(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                g0.m0();
                return 4;
            case 15:
                ((Long) obj).longValue();
                g0.Y();
                return 8;
            case 16:
                return g0.k0(((Integer) obj).intValue());
            case 17:
                return g0.T(((Long) obj).longValue());
            case 18:
                if (obj instanceof c1) {
                    return g0.i0(((c1) obj).c());
                }
                return g0.i0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static boolean i(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.v() == a4.MESSAGE) {
            boolean M = key.M();
            Object value = entry.getValue();
            if (M) {
                for (e2 e2Var : (List) value) {
                    if (!e2Var.isInitialized()) {
                        return false;
                    }
                }
            } else if (value instanceof e2) {
                if (!((e2) value).isInitialized()) {
                    return false;
                }
            } else if (value instanceof i1) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    public static int k(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.v() != a4.MESSAGE || key.M() || key.z()) {
            return g(key, value);
        }
        boolean z = value instanceof i1;
        int c2 = entry.getKey().c();
        if (z) {
            int W = g0.W(2, c2) + (g0.h0(1) << 1);
            int h0 = g0.h0(3);
            int a2 = ((i1) value).a();
            return g0.j0(a2) + a2 + h0 + W;
        }
        return g0.C(3, (e2) value) + g0.W(2, c2) + (g0.h0(1) << 1);
    }

    public static Object l(Object obj) {
        if (obj instanceof j2) {
            return ((j2) obj).x();
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
        return this.f3395a.isEmpty();
    }

    public final boolean b() {
        for (int i = 0; i < this.f3395a.f(); i++) {
            if (!i(this.f3395a.d(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f3395a.g()) {
            if (!i(entry)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> c() {
        return this.f3397c ? new l1(this.f3395a.entrySet().iterator()) : this.f3395a.entrySet().iterator();
    }

    public final /* synthetic */ Object clone() {
        q0 q0Var = new q0();
        for (int i = 0; i < this.f3395a.f(); i++) {
            Map.Entry<FieldDescriptorType, Object> d2 = this.f3395a.d(i);
            q0Var.e(d2.getKey(), d2.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f3395a.g()) {
            q0Var.e(entry.getKey(), entry.getValue());
        }
        q0Var.f3397c = this.f3397c;
        return q0Var;
    }

    public final void e(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.M()) {
            f(fielddescriptortype.I(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                f(fielddescriptortype.I(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof i1) {
            this.f3397c = true;
        }
        this.f3395a.put(fielddescriptortype, obj);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        return this.f3395a.equals(((q0) obj).f3395a);
    }

    public final int hashCode() {
        return this.f3395a.hashCode();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x00af */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v8, types: [c.b.a.a.g.b.z0, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v11, types: [c.b.a.a.g.b.j2] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final void j(Map.Entry<FieldDescriptorType, Object> entry) {
        ?? r6;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof i1) {
            i1.d();
            throw null;
        } else if (key.M()) {
            Object obj = this.f3395a.get(key);
            if (!(obj instanceof i1)) {
                if (obj == null) {
                    obj = new ArrayList();
                }
                for (Object obj2 : (List) value) {
                    ((List) obj).add(l(obj2));
                }
                this.f3395a.put(key, obj);
                return;
            }
            i1.d();
            throw null;
        } else if (key.v() == a4.MESSAGE) {
            Object obj3 = this.f3395a.get(key);
            if (obj3 instanceof i1) {
                i1.d();
                throw null;
            } else if (obj3 == null) {
                this.f3395a.put(key, l(value));
            } else {
                if (obj3 instanceof j2) {
                    r6 = key.J((j2) obj3, (j2) value);
                } else {
                    r6 = (z0) ((z0.a) key.q(((e2) obj3).c(), (e2) value)).i();
                    boolean z = true;
                    byte byteValue = ((Byte) r6.g(1, null, null)).byteValue();
                    if (byteValue != 1) {
                        if (byteValue == 0) {
                            z = false;
                        } else {
                            z = p2.f3390c.b(r6).f(r6);
                            r6.g(2, z ? r6 : null, null);
                        }
                    }
                    if (!z) {
                        throw new g3();
                    }
                }
                this.f3395a.put(key, r6 == true ? 1 : 0);
            }
        } else {
            this.f3395a.put(key, l(value));
        }
    }

    public q0(boolean z) {
        this.f3397c = false;
        y2 y2Var = new y2(0);
        this.f3395a = y2Var;
        if (!this.f3396b) {
            y2Var.j();
            this.f3396b = true;
        }
    }
}
