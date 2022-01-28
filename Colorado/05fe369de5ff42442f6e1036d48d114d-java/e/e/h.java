package e.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class h<K, V> {

    /* renamed from: e  reason: collision with root package name */
    public static Object[] f1018e;

    /* renamed from: f  reason: collision with root package name */
    public static int f1019f;

    /* renamed from: g  reason: collision with root package name */
    public static Object[] f1020g;

    /* renamed from: h  reason: collision with root package name */
    public static int f1021h;
    public int[] b;
    public Object[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f1022d;

    public h() {
        this.b = d.a;
        this.c = d.c;
        this.f1022d = 0;
    }

    public h(int i2) {
        if (i2 == 0) {
            this.b = d.a;
            this.c = d.c;
        } else {
            a(i2);
        }
        this.f1022d = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (h.class) {
                if (f1021h < 10) {
                    objArr[0] = f1020g;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1020g = objArr;
                    f1021h++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (h.class) {
                if (f1019f < 10) {
                    objArr[0] = f1018e;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1018e = objArr;
                    f1019f++;
                }
            }
        }
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (h.class) {
                Object[] objArr = f1020g;
                if (objArr != null) {
                    this.c = objArr;
                    f1020g = (Object[]) objArr[0];
                    this.b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1021h--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (h.class) {
                Object[] objArr2 = f1018e;
                if (objArr2 != null) {
                    this.c = objArr2;
                    f1018e = (Object[]) objArr2[0];
                    this.b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1019f--;
                    return;
                }
            }
        }
        this.b = new int[i2];
        this.c = new Object[(i2 << 1)];
    }

    public void b(int i2) {
        int i3 = this.f1022d;
        int[] iArr = this.b;
        if (iArr.length < i2) {
            Object[] objArr = this.c;
            a(i2);
            if (this.f1022d > 0) {
                System.arraycopy(iArr, 0, this.b, 0, i3);
                System.arraycopy(objArr, 0, this.c, 0, i3 << 1);
            }
            c(iArr, objArr, i3);
        }
        if (this.f1022d != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.f1022d;
        if (i2 > 0) {
            int[] iArr = this.b;
            Object[] objArr = this.c;
            this.b = d.a;
            this.c = d.c;
            this.f1022d = 0;
            c(iArr, objArr, i2);
        }
        if (this.f1022d > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public int d(Object obj, int i2) {
        int i3 = this.f1022d;
        if (i3 == 0) {
            return -1;
        }
        try {
            int a = d.a(this.b, i3, i2);
            if (a < 0 || obj.equals(this.c[a << 1])) {
                return a;
            }
            int i4 = a + 1;
            while (i4 < i3 && this.b[i4] == i2) {
                if (obj.equals(this.c[i4 << 1])) {
                    return i4;
                }
                i4++;
            }
            int i5 = a - 1;
            while (i5 >= 0 && this.b[i5] == i2) {
                if (obj.equals(this.c[i5 << 1])) {
                    return i5;
                }
                i5--;
            }
            return ~i4;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int e(Object obj) {
        return obj == null ? f() : d(obj, obj.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f1022d != hVar.f1022d) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1022d; i2++) {
                try {
                    K h2 = h(i2);
                    V k2 = k(i2);
                    Object obj2 = hVar.get(h2);
                    if (k2 == null) {
                        if (obj2 != null || !hVar.containsKey(h2)) {
                            return false;
                        }
                    } else if (!k2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this.f1022d != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.f1022d; i3++) {
                try {
                    K h3 = h(i3);
                    V k3 = k(i3);
                    Object obj3 = map.get(h3);
                    if (k3 == null) {
                        if (obj3 != null || !map.containsKey(h3)) {
                            return false;
                        }
                    } else if (!k3.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f() {
        int i2 = this.f1022d;
        if (i2 == 0) {
            return -1;
        }
        try {
            int a = d.a(this.b, i2, 0);
            if (a < 0 || this.c[a << 1] == null) {
                return a;
            }
            int i3 = a + 1;
            while (i3 < i2 && this.b[i3] == 0) {
                if (this.c[i3 << 1] == null) {
                    return i3;
                }
                i3++;
            }
            int i4 = a - 1;
            while (i4 >= 0 && this.b[i4] == 0) {
                if (this.c[i4 << 1] == null) {
                    return i4;
                }
                i4--;
            }
            return ~i3;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public int g(Object obj) {
        int i2 = this.f1022d * 2;
        Object[] objArr = this.c;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int e2 = e(obj);
        return e2 >= 0 ? (V) this.c[(e2 << 1) + 1] : v;
    }

    public K h(int i2) {
        return (K) this.c[i2 << 1];
    }

    public int hashCode() {
        int[] iArr = this.b;
        Object[] objArr = this.c;
        int i2 = this.f1022d;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public V i(int i2) {
        Object[] objArr = this.c;
        int i3 = i2 << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.f1022d;
        int i5 = 0;
        if (i4 <= 1) {
            c(this.b, objArr, i4);
            this.b = d.a;
            this.c = d.c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.b;
            int i7 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i8 = i2 + 1;
                    int i9 = i6 - i2;
                    System.arraycopy(iArr, i8, iArr, i2, i9);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i8 << 1, objArr2, i3, i9 << 1);
                }
                Object[] objArr3 = this.c;
                int i10 = i6 << 1;
                objArr3[i10] = null;
                objArr3[i10 + 1] = null;
            } else {
                if (i4 > 8) {
                    i7 = i4 + (i4 >> 1);
                }
                a(i7);
                if (i4 == this.f1022d) {
                    if (i2 > 0) {
                        System.arraycopy(iArr, 0, this.b, 0, i2);
                        System.arraycopy(objArr, 0, this.c, 0, i3);
                    }
                    if (i2 < i6) {
                        int i11 = i2 + 1;
                        int i12 = i6 - i2;
                        System.arraycopy(iArr, i11, this.b, i2, i12);
                        System.arraycopy(objArr, i11 << 1, this.c, i3, i12 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            i5 = i6;
        }
        if (i4 == this.f1022d) {
            this.f1022d = i5;
            return v;
        }
        throw new ConcurrentModificationException();
    }

    public boolean isEmpty() {
        return this.f1022d <= 0;
    }

    public V j(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.c;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    public V k(int i2) {
        return (V) this.c[(i2 << 1) + 1];
    }

    public V put(K k2, V v) {
        int i2;
        int i3;
        int i4 = this.f1022d;
        if (k2 == null) {
            i3 = f();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            i3 = d(k2, hashCode);
        }
        if (i3 >= 0) {
            int i5 = (i3 << 1) + 1;
            Object[] objArr = this.c;
            V v2 = (V) objArr[i5];
            objArr[i5] = v;
            return v2;
        }
        int i6 = ~i3;
        int[] iArr = this.b;
        if (i4 >= iArr.length) {
            int i7 = 4;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 >= 4) {
                i7 = 8;
            }
            Object[] objArr2 = this.c;
            a(i7);
            if (i4 == this.f1022d) {
                int[] iArr2 = this.b;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr2, 0, this.c, 0, objArr2.length);
                }
                c(iArr, objArr2, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr3 = this.b;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr3 = this.c;
            System.arraycopy(objArr3, i6 << 1, objArr3, i8 << 1, (this.f1022d - i6) << 1);
        }
        int i9 = this.f1022d;
        if (i4 == i9) {
            int[] iArr4 = this.b;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr4 = this.c;
                int i10 = i6 << 1;
                objArr4[i10] = k2;
                objArr4[i10 + 1] = v;
                this.f1022d = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v) {
        V orDefault = getOrDefault(k2, null);
        return orDefault == null ? put(k2, v) : orDefault;
    }

    public V remove(Object obj) {
        int e2 = e(obj);
        if (e2 >= 0) {
            return i(e2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int e2 = e(obj);
        if (e2 < 0) {
            return false;
        }
        V k2 = k(e2);
        if (obj2 != k2 && (obj2 == null || !obj2.equals(k2))) {
            return false;
        }
        i(e2);
        return true;
    }

    public V replace(K k2, V v) {
        int e2 = e(k2);
        if (e2 >= 0) {
            return j(e2, v);
        }
        return null;
    }

    public boolean replace(K k2, V v, V v2) {
        int e2 = e(k2);
        if (e2 < 0) {
            return false;
        }
        V k3 = k(e2);
        if (k3 != v && (v == null || !v.equals(k3))) {
            return false;
        }
        j(e2, v2);
        return true;
    }

    public int size() {
        return this.f1022d;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1022d * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1022d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K h2 = h(i2);
            if (h2 != this) {
                sb.append((Object) h2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V k2 = k(i2);
            if (k2 != this) {
                sb.append((Object) k2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
