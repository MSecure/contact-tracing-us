package f.b.b.b;

import f.b.b.b.b;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

public abstract class e<E> extends b<E> implements Set<E> {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f2977d = 0;
    public transient c<E> c;

    public static class a<E> extends b.a<E> {
        public a() {
            super(4);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.b.b.b.AbstractC0104b
        public /* bridge */ /* synthetic */ b.AbstractC0104b a(Object obj) {
            f(obj);
            return this;
        }

        public a<E> f(E e2) {
            Objects.requireNonNull(e2);
            c(e2);
            return this;
        }
    }

    public static int o(int i2) {
        int max = Math.max(i2, 2);
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
        f.b.a.c.b.o.b.o(z, "collection too large");
        return 1073741824;
    }

    public static <E> e<E> p(int i2, Object... objArr) {
        if (i2 == 0) {
            return i.f2995j;
        }
        boolean z = false;
        if (i2 == 1) {
            return new j(objArr[0]);
        }
        int o = o(i2);
        Object[] objArr2 = new Object[o];
        int i3 = o - 1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            Object obj = objArr[i6];
            f.b.a.c.b.o.b.x(obj, i6);
            int hashCode = obj.hashCode();
            int Q1 = f.b.a.c.b.o.b.Q1(hashCode);
            while (true) {
                int i7 = Q1 & i3;
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
                    Q1++;
                }
            }
        }
        Arrays.fill(objArr, i5, i2, (Object) null);
        if (i5 == 1) {
            return new j(objArr[0], i4);
        }
        if (o(i5) < o / 2) {
            return p(i5, objArr);
        }
        int length = objArr.length;
        if (i5 < (length >> 1) + (length >> 2)) {
            z = true;
        }
        if (z) {
            objArr = Arrays.copyOf(objArr, i5);
        }
        return new i(objArr, i4, objArr2, i3, i5);
    }

    public static <E> e<E> q(Collection<? extends E> collection) {
        if ((collection instanceof e) && !(collection instanceof SortedSet)) {
            e<E> eVar = (e) collection;
            if (!eVar.m()) {
                return eVar;
            }
        }
        Object[] array = collection.toArray();
        return p(array.length, array);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof e) && s() && ((e) obj).s() && hashCode() != obj.hashCode()) {
            return false;
        }
        if (this == obj) {
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

    @Override // f.b.b.b.b
    public c<E> h() {
        c<E> cVar = this.c;
        if (cVar != null) {
            return cVar;
        }
        c<E> r = r();
        this.c = r;
        return r;
    }

    public int hashCode() {
        return f.b.a.c.b.o.b.c1(this);
    }

    @Override // f.b.b.b.b, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public c<E> r() {
        return c.o(toArray());
    }

    public boolean s() {
        return false;
    }
}
