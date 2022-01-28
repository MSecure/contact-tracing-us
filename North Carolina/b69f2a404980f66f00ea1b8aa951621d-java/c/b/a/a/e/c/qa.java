package c.b.a.a.e.c;

import c.b.a.a.c.n.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public abstract class qa<E> extends ma<E> implements Set<E> {

    /* renamed from: c  reason: collision with root package name */
    public transient na<E> f2705c;

    public static int p(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        if (z) {
            return 1073741824;
        }
        throw new IllegalArgumentException("collection too large");
    }

    public static qa q(int i, Object[] objArr) {
        while (i != 0) {
            if (i == 1) {
                return new va(objArr[0]);
            }
            int p = p(i);
            Object[] objArr2 = new Object[p];
            int i2 = p - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object obj = objArr[i5];
                c.I2(obj, i5);
                int hashCode = obj.hashCode();
                int E2 = c.E2(hashCode);
                while (true) {
                    int i6 = E2 & i2;
                    Object obj2 = objArr2[i6];
                    if (obj2 == null) {
                        objArr[i4] = obj;
                        objArr2[i6] = obj;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                    if (obj2.equals(obj)) {
                        break;
                    }
                    E2++;
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new va(objArr[0], i3);
            }
            if (p(i4) < p / 2) {
                i = i4;
            } else {
                int length = objArr.length;
                if (i4 < (length >> 1) + (length >> 2)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new ta(objArr, i3, objArr2, i2, i4);
            }
        }
        return ta.i;
    }

    public static <E> qa<E> r(E e2) {
        return new va(e2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof qa) && s() && ((qa) obj).s() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            E next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    @Override // c.b.a.a.e.c.ma, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // c.b.a.a.e.c.ma
    public final na<E> m() {
        na<E> naVar = this.f2705c;
        if (naVar != null) {
            return naVar;
        }
        na<E> t = t();
        this.f2705c = t;
        return t;
    }

    public boolean s() {
        return false;
    }

    public na<E> t() {
        return na.s(toArray());
    }
}
