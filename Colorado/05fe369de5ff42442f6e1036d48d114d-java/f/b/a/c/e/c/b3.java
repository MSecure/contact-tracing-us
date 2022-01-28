package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public abstract class b3<E> extends x2<E> implements Set<E> {
    public transient a3<E> c;

    public static int o(int i2) {
        int max = Math.max(i2, 2);
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1);
            do {
                highestOneBit += highestOneBit;
            } while (((double) highestOneBit) * 0.7d < ((double) max));
            return highestOneBit;
        } else if (max < 1073741824) {
            return 1073741824;
        } else {
            throw new IllegalArgumentException("collection too large");
        }
    }

    public static <E> b3<E> r(int i2, Object... objArr) {
        if (i2 == 0) {
            return e3.f2671j;
        }
        if (i2 != 1) {
            int o = o(i2);
            Object[] objArr2 = new Object[o];
            int i3 = o - 1;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                Object obj = objArr[i6];
                b.y1(obj, i6);
                int hashCode = obj.hashCode();
                int u1 = b.u1(hashCode);
                while (true) {
                    int i7 = u1 & i3;
                    Object obj2 = objArr2[i7];
                    if (obj2 == null) {
                        objArr[i5] = obj;
                        objArr2[i7] = obj;
                        i4 += hashCode;
                        i5++;
                        break;
                    } else if (obj2.equals(obj)) {
                        break;
                    } else {
                        u1++;
                    }
                }
            }
            Arrays.fill(objArr, i5, i2, (Object) null);
            if (i5 == 1) {
                Object obj3 = objArr[0];
                obj3.getClass();
                return new f3(obj3, i4);
            } else if (o(i5) < o / 2) {
                return r(i5, objArr);
            } else {
                int length = objArr.length;
                if (i5 < (length >> 1) + (length >> 2)) {
                    objArr = Arrays.copyOf(objArr, i5);
                }
                return new e3(objArr, i4, objArr2, i3, i5);
            }
        } else {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new f3(obj4);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof b3) && q() && ((b3) obj).q() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                return size() == set.size() && containsAll(set);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    public int hashCode() {
        Iterator<E> it = iterator();
        int i2 = 0;
        while (it.hasNext()) {
            E next = it.next();
            i2 += next != null ? next.hashCode() : 0;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable, f.b.a.c.e.c.x2
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // f.b.a.c.e.c.x2
    public final a3<E> k() {
        a3<E> a3Var = this.c;
        if (a3Var != null) {
            return a3Var;
        }
        a3<E> p = p();
        this.c = p;
        return p;
    }

    public a3<E> p() {
        throw null;
    }

    public boolean q() {
        throw null;
    }
}
