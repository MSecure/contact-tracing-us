package e.f;

import e.f.g;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes.dex */
public final class c<E> implements Collection<E>, Set<E> {

    /* renamed from: f */
    public static final int[] f1292f = new int[0];

    /* renamed from: g */
    public static final Object[] f1293g = new Object[0];

    /* renamed from: h */
    public static Object[] f1294h;

    /* renamed from: i */
    public static int f1295i;

    /* renamed from: j */
    public static Object[] f1296j;

    /* renamed from: k */
    public static int f1297k;
    public int[] b;
    public Object[] c;

    /* renamed from: d */
    public int f1298d;

    /* renamed from: e */
    public g<E, E> f1299e;

    public c() {
        this(0);
    }

    public c(int i2) {
        if (i2 == 0) {
            this.b = f1292f;
            this.c = f1293g;
        } else {
            h(i2);
        }
        this.f1298d = 0;
    }

    public static void i(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (f1297k < 10) {
                    objArr[0] = f1296j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1296j = objArr;
                    f1297k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (c.class) {
                if (f1295i < 10) {
                    objArr[0] = f1294h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1294h = objArr;
                    f1295i++;
                }
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = k();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i3 = j(e2, hashCode);
            i2 = hashCode;
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = ~i3;
        int i5 = this.f1298d;
        int[] iArr = this.b;
        if (i5 >= iArr.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.c;
            h(i6);
            int[] iArr2 = this.b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.c, 0, objArr.length);
            }
            i(iArr, objArr, this.f1298d);
        }
        int i7 = this.f1298d;
        if (i4 < i7) {
            int[] iArr3 = this.b;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.c;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f1298d - i4);
        }
        this.b[i4] = i2;
        this.c[i4] = e2;
        this.f1298d++;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.f1298d;
        int[] iArr = this.b;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.c;
            h(size);
            int i2 = this.f1298d;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.b, 0, i2);
                System.arraycopy(objArr, 0, this.c, 0, this.f1298d);
            }
            i(iArr, objArr, this.f1298d);
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.f1298d;
        if (i2 != 0) {
            i(this.b, this.c, i2);
            this.b = f1292f;
            this.c = f1293g;
            this.f1298d = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f1298d != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1298d; i2++) {
                try {
                    if (!set.contains(this.c[i2])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final void h(int i2) {
        if (i2 == 8) {
            synchronized (c.class) {
                Object[] objArr = f1296j;
                if (objArr != null) {
                    this.c = objArr;
                    f1296j = (Object[]) objArr[0];
                    this.b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1297k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (c.class) {
                Object[] objArr2 = f1294h;
                if (objArr2 != null) {
                    this.c = objArr2;
                    f1294h = (Object[]) objArr2[0];
                    this.b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1295i--;
                    return;
                }
            }
        }
        this.b = new int[i2];
        this.c = new Object[i2];
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        int[] iArr = this.b;
        int i2 = this.f1298d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? k() : j(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1298d <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        if (this.f1299e == null) {
            this.f1299e = new b(this);
        }
        g<E, E> gVar = this.f1299e;
        if (gVar.b == null) {
            gVar.b = new g.c();
        }
        return gVar.b.iterator();
    }

    public final int j(Object obj, int i2) {
        int i3 = this.f1298d;
        if (i3 == 0) {
            return -1;
        }
        int a = d.a(this.b, i3, i2);
        if (a < 0 || obj.equals(this.c[a])) {
            return a;
        }
        int i4 = a + 1;
        while (i4 < i3 && this.b[i4] == i2) {
            if (obj.equals(this.c[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a - 1;
        while (i5 >= 0 && this.b[i5] == i2) {
            if (obj.equals(this.c[i5])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    public final int k() {
        int i2 = this.f1298d;
        if (i2 == 0) {
            return -1;
        }
        int a = d.a(this.b, i2, 0);
        if (a < 0 || this.c[a] == null) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.b[i3] == 0) {
            if (this.c[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a - 1;
        while (i4 >= 0 && this.b[i4] == 0) {
            if (this.c[i4] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public E l(int i2) {
        Object[] objArr = this.c;
        E e2 = (E) objArr[i2];
        int i3 = this.f1298d;
        if (i3 <= 1) {
            i(this.b, objArr, i3);
            this.b = f1292f;
            this.c = f1293g;
            this.f1298d = 0;
        } else {
            int[] iArr = this.b;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = i3 - 1;
                this.f1298d = i5;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr, i6, iArr, i2, i5 - i2);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i6, objArr2, i2, this.f1298d - i2);
                }
                this.c[this.f1298d] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                h(i4);
                this.f1298d--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.b, 0, i2);
                    System.arraycopy(objArr, 0, this.c, 0, i2);
                }
                int i7 = this.f1298d;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr, i8, this.b, i2, i7 - i2);
                    System.arraycopy(objArr, i8, this.c, i2, this.f1298d - i2);
                }
            }
        }
        return e2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        l(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.f1298d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.c[i2])) {
                l(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f1298d;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.f1298d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.c, 0, objArr, 0, i2);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1298d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1298d));
        }
        System.arraycopy(this.c, 0, tArr, 0, this.f1298d);
        int length = tArr.length;
        int i2 = this.f1298d;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    @Override // java.lang.Object
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1298d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1298d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.c[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
