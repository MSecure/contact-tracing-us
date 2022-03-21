package f.b.b.b;

import f.b.b.b.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

public abstract class c<E> extends b<E> implements List<E>, RandomAccess {
    public static final a<Object> c = new b(g.f2882f, 0);

    public static final class a<E> extends b.a<E> {
        public a() {
            super(4);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.b.b.b.AbstractC0100b
        public b.AbstractC0100b a(Object obj) {
            c(obj);
            return this;
        }

        public c<E> f() {
            this.c = true;
            return c.p(this.a, this.b);
        }
    }

    public static class b<E> extends a<E> {

        /* renamed from: d  reason: collision with root package name */
        public final c<E> f2876d;

        public b(c<E> cVar, int i2) {
            super(cVar.size(), i2);
            this.f2876d = cVar;
        }
    }

    /* renamed from: f.b.b.b.c$c  reason: collision with other inner class name */
    public class C0101c extends c<E> {

        /* renamed from: d  reason: collision with root package name */
        public final transient int f2877d;

        /* renamed from: e  reason: collision with root package name */
        public final transient int f2878e;

        public C0101c(int i2, int i3) {
            this.f2877d = i2;
            this.f2878e = i3;
        }

        @Override // java.util.List
        public E get(int i2) {
            f.b.a.c.b.o.b.w(i2, this.f2878e);
            return (E) c.this.get(i2 + this.f2877d);
        }

        @Override // f.b.b.b.c, f.b.b.b.b, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return listIterator();
        }

        @Override // f.b.b.b.b
        public Object[] j() {
            return c.this.j();
        }

        @Override // f.b.b.b.b
        public int k() {
            return c.this.l() + this.f2877d + this.f2878e;
        }

        @Override // f.b.b.b.b
        public int l() {
            return c.this.l() + this.f2877d;
        }

        @Override // f.b.b.b.c, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return listIterator();
        }

        @Override // f.b.b.b.c, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return listIterator(i2);
        }

        @Override // f.b.b.b.b
        public boolean m() {
            return true;
        }

        public int size() {
            return this.f2878e;
        }

        @Override // f.b.b.b.c
        /* renamed from: x */
        public c<E> subList(int i2, int i3) {
            f.b.a.c.b.o.b.E(i2, i3, this.f2878e);
            c cVar = c.this;
            int i4 = this.f2877d;
            return cVar.subList(i2 + i4, i3 + i4);
        }
    }

    public static <E> c<E> o(Object[] objArr) {
        return p(objArr, objArr.length);
    }

    public static <E> c<E> p(Object[] objArr, int i2) {
        return i2 == 0 ? (c<E>) g.f2882f : new g(objArr, i2);
    }

    public static <E> c<E> q(Object... objArr) {
        int length = objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            f.b.a.c.b.o.b.x(objArr[i2], i2);
        }
        return p(objArr, objArr.length);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: f.b.b.b.c$a */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> c<E> r(Iterable<? extends E> iterable) {
        Objects.requireNonNull(iterable);
        if (iterable instanceof Collection) {
            return s((Collection) iterable);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return (c<E>) g.f2882f;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return q(next);
        }
        a aVar = new a();
        aVar.c(next);
        while (it.hasNext()) {
            aVar.a(it.next());
        }
        return aVar.f();
    }

    public static <E> c<E> s(Collection<? extends E> collection) {
        if (!(collection instanceof b)) {
            return q(collection.toArray());
        }
        c<E> h2 = ((b) collection).h();
        return h2.m() ? o(h2.toArray()) : h2;
    }

    public static <E> c<E> v(E e2, E e3, E e4, E e5, E e6, E e7) {
        return q(e2, e3, e4, e5, e6, e7);
    }

    public static <E> c<E> w(E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return q(e2, e3, e4, e5, e6, e7, e8);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // f.b.b.b.b
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            int size = size();
            if (size != list.size()) {
                return false;
            }
            if (list instanceof RandomAccess) {
                for (int i2 = 0; i2 < size; i2++) {
                    if (!f.b.a.c.b.o.b.t0(get(i2), list.get(i2))) {
                        return false;
                    }
                }
            } else {
                Iterator<E> it = list.iterator();
                for (E e2 : this) {
                    if (!it.hasNext() || !f.b.a.c.b.o.b.t0(e2, it.next())) {
                        return false;
                    }
                    while (r2.hasNext()) {
                    }
                }
                return !it.hasNext();
            }
        }
        return true;
    }

    @Override // f.b.b.b.b
    public final c<E> h() {
        return this;
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = ~(~(get(i3).hashCode() + (i2 * 31)));
        }
        return i2;
    }

    @Override // f.b.b.b.b
    public int i(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i2 + i3] = get(i3);
        }
        return i2 + size;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj.equals(get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // f.b.b.b.b, java.util.AbstractCollection, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator();
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // f.b.b.b.b
    public k<E> n() {
        return listIterator();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: t */
    public a<E> listIterator() {
        return listIterator(0);
    }

    /* renamed from: u */
    public a<E> listIterator(int i2) {
        f.b.a.c.b.o.b.D(i2, size());
        return isEmpty() ? (a<E>) c : new b(this, i2);
    }

    /* renamed from: x */
    public c<E> subList(int i2, int i3) {
        f.b.a.c.b.o.b.E(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        return i4 == 0 ? (c<E>) g.f2882f : new C0101c(i2, i4);
    }
}
