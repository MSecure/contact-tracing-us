package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public abstract class t2<E> extends o2<E> implements Set<E> {
    public transient r2<E> c;

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

    public static <E> t2<E> r(int i2, Object... objArr) {
        if (i2 == 0) {
            return w2.f2603i;
        }
        if (i2 == 1) {
            return new x2(objArr[0]);
        }
        int o = o(i2);
        Object[] objArr2 = new Object[o];
        int i3 = o - 1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            Object obj = objArr[i6];
            b.d2(obj, i6);
            int hashCode = obj.hashCode();
            int X1 = b.X1(hashCode);
            while (true) {
                int i7 = X1 & i3;
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
                    X1++;
                }
            }
        }
        Arrays.fill(objArr, i5, i2, (Object) null);
        if (i5 == 1) {
            return new x2(objArr[0], i4);
        }
        if (o(i5) < o / 2) {
            return r(i5, objArr);
        }
        int length = objArr.length;
        if (i5 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i5);
        }
        return new w2(objArr, i4, objArr2, i3, i5);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof t2) && p() && ((t2) obj).p() && hashCode() != obj.hashCode()) {
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

    @Override // java.util.AbstractCollection, f.b.a.c.e.c.o2, java.util.Collection, java.util.Set, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // f.b.a.c.e.c.o2
    public final r2<E> l() {
        r2<E> r2Var = this.c;
        if (r2Var != null) {
            return r2Var;
        }
        r2<E> q = q();
        this.c = q;
        return q;
    }

    public boolean p() {
        throw null;
    }

    public r2<E> q() {
        throw null;
    }
}
