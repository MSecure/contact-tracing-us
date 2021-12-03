package f.b.b.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public abstract class b<E> extends AbstractCollection<E> implements Serializable {
    public static final Object[] b = new Object[0];

    public static abstract class a<E> extends AbstractC0103b<E> {
        public Object[] a;
        public int b = 0;
        public boolean c;

        public a(int i2) {
            f.b.a.c.b.o.b.y(i2, "initialCapacity");
            this.a = new Object[i2];
        }

        public a<E> c(E e2) {
            Objects.requireNonNull(e2);
            e(this.b + 1);
            Object[] objArr = this.a;
            int i2 = this.b;
            this.b = i2 + 1;
            objArr[i2] = e2;
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: f.b.b.b.b$a<E> */
        /* JADX WARN: Multi-variable type inference failed */
        public AbstractC0103b<E> d(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                e(collection.size() + this.b);
                if (collection instanceof b) {
                    this.b = ((b) collection).i(this.a, this.b);
                    return this;
                }
            }
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public final void e(int i2) {
            Object[] objArr = this.a;
            if (objArr.length < i2) {
                this.a = Arrays.copyOf(objArr, AbstractC0103b.b(objArr.length, i2));
            } else if (this.c) {
                this.a = (Object[]) objArr.clone();
            } else {
                return;
            }
            this.c = false;
        }
    }

    /* renamed from: f.b.b.b.b$b  reason: collision with other inner class name */
    public static abstract class AbstractC0103b<E> {
        public static int b(int i2, int i3) {
            if (i3 >= 0) {
                int i4 = i2 + (i2 >> 1) + 1;
                if (i4 < i3) {
                    i4 = Integer.highestOneBit(i3 - 1) << 1;
                }
                if (i4 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i4;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public abstract AbstractC0103b<E> a(E e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean contains(Object obj);

    public c<E> h() {
        if (!isEmpty()) {
            return c.o(toArray());
        }
        a<Object> aVar = c.c;
        return (c<E>) g.f3135f;
    }

    public int i(Object[] objArr, int i2) {
        k<E> n = iterator();
        while (n.hasNext()) {
            objArr[i2] = n.next();
            i2++;
        }
        return i2;
    }

    public Object[] j() {
        return null;
    }

    public int k() {
        throw new UnsupportedOperationException();
    }

    public int l() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean m();

    /* renamed from: n */
    public abstract k<E> iterator();

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        return toArray(b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        Objects.requireNonNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] j2 = j();
            if (j2 != null) {
                return (T[]) Arrays.copyOfRange(j2, l(), k(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        i(tArr, 0);
        return tArr;
    }
}
