package e.e;

import e.e.g;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class c<E> implements Collection<E>, Set<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f1208f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f1209g = new Object[0];

    /* renamed from: h  reason: collision with root package name */
    public static Object[] f1210h;

    /* renamed from: i  reason: collision with root package name */
    public static int f1211i;

    /* renamed from: j  reason: collision with root package name */
    public static Object[] f1212j;

    /* renamed from: k  reason: collision with root package name */
    public static int f1213k;
    public int[] b;
    public Object[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f1214d;

    /* renamed from: e  reason: collision with root package name */
    public g<E, E> f1215e;

    public c() {
        this(0);
    }

    public c(int i2) {
        if (i2 == 0) {
            this.b = f1208f;
            this.c = f1209g;
        } else {
            h(i2);
        }
        this.f1214d = 0;
    }

    public static void i(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (f1213k < 10) {
                    objArr[0] = f1212j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f1212j = objArr;
                    f1213k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (c.class) {
                if (f1211i < 10) {
                    objArr[0] = f1210h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f1210h = objArr;
                    f1211i++;
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
            i2 = hashCode;
            i3 = j(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = ~i3;
        int i5 = this.f1214d;
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
            i(iArr, objArr, this.f1214d);
        }
        int i7 = this.f1214d;
        if (i4 < i7) {
            int[] iArr3 = this.b;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.c;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f1214d - i4);
        }
        this.b[i4] = i2;
        this.c[i4] = e2;
        this.f1214d++;
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: e.e.c<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.f1214d;
        int[] iArr = this.b;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.c;
            h(size);
            int i2 = this.f1214d;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.b, 0, i2);
                System.arraycopy(objArr, 0, this.c, 0, this.f1214d);
            }
            i(iArr, objArr, this.f1214d);
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public void clear() {
        int i2 = this.f1214d;
        if (i2 != 0) {
            i(this.b, this.c, i2);
            this.b = f1208f;
            this.c = f1209g;
            this.f1214d = 0;
        }
    }

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

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f1214d != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1214d; i2++) {
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
                Object[] objArr = f1212j;
                if (objArr != null) {
                    this.c = objArr;
                    f1212j = (Object[]) objArr[0];
                    this.b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1213k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (c.class) {
                Object[] objArr2 = f1210h;
                if (objArr2 != null) {
                    this.c = objArr2;
                    f1210h = (Object[]) objArr2[0];
                    this.b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1211i--;
                    return;
                }
            }
        }
        this.b = new int[i2];
        this.c = new Object[i2];
    }

    public int hashCode() {
        int[] iArr = this.b;
        int i2 = this.f1214d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? k() : j(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f1214d <= 0;
    }

    @Override // java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.f1215e == null) {
            this.f1215e = new b(this);
        }
        g<E, E> gVar = this.f1215e;
        if (gVar.b == null) {
            gVar.b = new g.c();
        }
        return gVar.b.iterator();
    }

    public final int j(Object obj, int i2) {
        int i3 = this.f1214d;
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
        int i2 = this.f1214d;
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
        int i3 = this.f1214d;
        if (i3 <= 1) {
            i(this.b, objArr, i3);
            this.b = f1208f;
            this.c = f1209g;
            this.f1214d = 0;
        } else {
            int[] iArr = this.b;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = i3 - 1;
                this.f1214d = i5;
                if (i2 < i5) {
                    int i6 = i2 + 1;
                    System.arraycopy(iArr, i6, iArr, i2, i5 - i2);
                    Object[] objArr2 = this.c;
                    System.arraycopy(objArr2, i6, objArr2, i2, this.f1214d - i2);
                }
                this.c[this.f1214d] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                h(i4);
                this.f1214d--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.b, 0, i2);
                    System.arraycopy(objArr, 0, this.c, 0, i2);
                }
                int i7 = this.f1214d;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr, i8, this.b, i2, i7 - i2);
                    System.arraycopy(objArr, i8, this.c, i2, this.f1214d - i2);
                }
            }
        }
        return e2;
    }

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
        for (int i2 = this.f1214d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.c[i2])) {
                l(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f1214d;
    }

    public Object[] toArray() {
        int i2 = this.f1214d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.c, 0, objArr, 0, i2);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1214d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1214d));
        }
        System.arraycopy(this.c, 0, tArr, 0, this.f1214d);
        int length = tArr.length;
        int i2 = this.f1214d;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1214d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1214d; i2++) {
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
