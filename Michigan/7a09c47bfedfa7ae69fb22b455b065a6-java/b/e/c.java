package b.e;

import b.e.g;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class c<E> implements Collection<E>, Set<E> {

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f1372f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public static final Object[] f1373g = new Object[0];
    public static Object[] h;
    public static int i;
    public static Object[] j;
    public static int k;

    /* renamed from: b  reason: collision with root package name */
    public int[] f1374b = f1372f;

    /* renamed from: c  reason: collision with root package name */
    public Object[] f1375c = f1373g;

    /* renamed from: d  reason: collision with root package name */
    public int f1376d = 0;

    /* renamed from: e  reason: collision with root package name */
    public g<E, E> f1377e;

    public static void c(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (k < 10) {
                    objArr[0] = j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    j = objArr;
                    k++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (c.class) {
                if (i < 10) {
                    objArr[0] = h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    h = objArr;
                    i++;
                }
            }
        }
    }

    public final void a(int i2) {
        if (i2 == 8) {
            synchronized (c.class) {
                if (j != null) {
                    Object[] objArr = j;
                    this.f1375c = objArr;
                    j = (Object[]) objArr[0];
                    this.f1374b = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (c.class) {
                if (h != null) {
                    Object[] objArr2 = h;
                    this.f1375c = objArr2;
                    h = (Object[]) objArr2[0];
                    this.f1374b = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    i--;
                    return;
                }
            }
        }
        this.f1374b = new int[i2];
        this.f1375c = new Object[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = g();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = e(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = ~i3;
        int i5 = this.f1376d;
        if (i5 >= this.f1374b.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            int[] iArr = this.f1374b;
            Object[] objArr = this.f1375c;
            a(i6);
            int[] iArr2 = this.f1374b;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1375c, 0, objArr.length);
            }
            c(iArr, objArr, this.f1376d);
        }
        int i7 = this.f1376d;
        if (i4 < i7) {
            int[] iArr3 = this.f1374b;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.f1375c;
            System.arraycopy(objArr2, i4, objArr2, i8, this.f1376d - i4);
        }
        this.f1374b[i4] = i2;
        this.f1375c[i4] = e2;
        this.f1376d++;
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: b.e.c<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size() + this.f1376d;
        int[] iArr = this.f1374b;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.f1375c;
            a(size);
            int i2 = this.f1376d;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f1374b, 0, i2);
                System.arraycopy(objArr, 0, this.f1375c, 0, this.f1376d);
            }
            c(iArr, objArr, this.f1376d);
        }
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    public void clear() {
        int i2 = this.f1376d;
        if (i2 != 0) {
            c(this.f1374b, this.f1375c, i2);
            this.f1374b = f1372f;
            this.f1375c = f1373g;
            this.f1376d = 0;
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

    public final int e(Object obj, int i2) {
        int i3 = this.f1376d;
        if (i3 == 0) {
            return -1;
        }
        int a2 = d.a(this.f1374b, i3, i2);
        if (a2 < 0 || obj.equals(this.f1375c[a2])) {
            return a2;
        }
        int i4 = a2 + 1;
        while (i4 < i3 && this.f1374b[i4] == i2) {
            if (obj.equals(this.f1375c[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = a2 - 1;
        while (i5 >= 0 && this.f1374b[i5] == i2) {
            if (obj.equals(this.f1375c[i5])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (this.f1376d != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f1376d; i2++) {
                try {
                    if (!set.contains(this.f1375c[i2])) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        int i2 = this.f1376d;
        if (i2 == 0) {
            return -1;
        }
        int a2 = d.a(this.f1374b, i2, 0);
        if (a2 < 0 || this.f1375c[a2] == null) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f1374b[i3] == 0) {
            if (this.f1375c[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = a2 - 1;
        while (i4 >= 0 && this.f1374b[i4] == 0) {
            if (this.f1375c[i4] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public E h(int i2) {
        Object[] objArr = this.f1375c;
        E e2 = (E) objArr[i2];
        int i3 = this.f1376d;
        if (i3 <= 1) {
            c(this.f1374b, objArr, i3);
            this.f1374b = f1372f;
            this.f1375c = f1373g;
            this.f1376d = 0;
        } else {
            int[] iArr = this.f1374b;
            int i4 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i5 = this.f1376d - 1;
                this.f1376d = i5;
                if (i2 < i5) {
                    int[] iArr2 = this.f1374b;
                    int i6 = i2 + 1;
                    System.arraycopy(iArr2, i6, iArr2, i2, i5 - i2);
                    Object[] objArr2 = this.f1375c;
                    System.arraycopy(objArr2, i6, objArr2, i2, this.f1376d - i2);
                }
                this.f1375c[this.f1376d] = null;
            } else {
                if (i3 > 8) {
                    i4 = i3 + (i3 >> 1);
                }
                int[] iArr3 = this.f1374b;
                Object[] objArr3 = this.f1375c;
                a(i4);
                this.f1376d--;
                if (i2 > 0) {
                    System.arraycopy(iArr3, 0, this.f1374b, 0, i2);
                    System.arraycopy(objArr3, 0, this.f1375c, 0, i2);
                }
                int i7 = this.f1376d;
                if (i2 < i7) {
                    int i8 = i2 + 1;
                    System.arraycopy(iArr3, i8, this.f1374b, i2, i7 - i2);
                    System.arraycopy(objArr3, i8, this.f1375c, i2, this.f1376d - i2);
                }
            }
        }
        return e2;
    }

    public int hashCode() {
        int[] iArr = this.f1374b;
        int i2 = this.f1376d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.f1376d <= 0;
    }

    @Override // java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<E> iterator() {
        if (this.f1377e == null) {
            this.f1377e = new b(this);
        }
        g<E, E> gVar = this.f1377e;
        if (gVar.f1394b == null) {
            gVar.f1394b = new g.c();
        }
        return gVar.f1394b.iterator();
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        h(indexOf);
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
        for (int i2 = this.f1376d - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.f1375c[i2])) {
                h(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.f1376d;
    }

    public Object[] toArray() {
        int i2 = this.f1376d;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.f1375c, 0, objArr, 0, i2);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f1376d) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f1376d));
        }
        System.arraycopy(this.f1375c, 0, tArr, 0, this.f1376d);
        int length = tArr.length;
        int i2 = this.f1376d;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1376d * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1376d; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.f1375c[i2];
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
