package c.b.b.b;

import c.b.b.b.b;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class c<E> extends b<E> implements List<E>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public static final e<Object> f3345c = new b(d.f, 0);

    public static final class a<E> extends b.a<E> {
        public a() {
            super(4);
        }

        public a<E> a(E e2) {
            if (e2 != null) {
                int i = this.f3343b + 1;
                Object[] objArr = this.f3342a;
                if (objArr.length < i) {
                    int length = objArr.length;
                    if (i >= 0) {
                        int i2 = length + (length >> 1) + 1;
                        if (i2 < i) {
                            i2 = Integer.highestOneBit(i - 1) << 1;
                        }
                        if (i2 < 0) {
                            i2 = Integer.MAX_VALUE;
                        }
                        this.f3342a = Arrays.copyOf(objArr, i2);
                    } else {
                        throw new AssertionError("cannot store more than MAX_VALUE elements");
                    }
                } else {
                    if (this.f3344c) {
                        this.f3342a = (Object[]) objArr.clone();
                    }
                    Object[] objArr2 = this.f3342a;
                    int i3 = this.f3343b;
                    this.f3343b = i3 + 1;
                    objArr2[i3] = e2;
                    return this;
                }
                this.f3344c = false;
                Object[] objArr22 = this.f3342a;
                int i32 = this.f3343b;
                this.f3343b = i32 + 1;
                objArr22[i32] = e2;
                return this;
            }
            throw null;
        }

        public c<E> b() {
            this.f3344c = true;
            return c.o(this.f3342a, this.f3343b);
        }
    }

    public static class b<E> extends a<E> {

        /* renamed from: d  reason: collision with root package name */
        public final c<E> f3346d;

        public b(c<E> cVar, int i) {
            super(cVar.size(), i);
            this.f3346d = cVar;
        }
    }

    /* renamed from: c.b.b.b.c$c  reason: collision with other inner class name */
    public class C0077c extends c<E> {

        /* renamed from: d  reason: collision with root package name */
        public final transient int f3347d;

        /* renamed from: e  reason: collision with root package name */
        public final transient int f3348e;

        public C0077c(int i, int i2) {
            this.f3347d = i;
            this.f3348e = i2;
        }

        @Override // c.b.b.b.b
        public Object[] c() {
            return c.this.c();
        }

        @Override // c.b.b.b.b
        public int e() {
            return c.this.h() + this.f3347d + this.f3348e;
        }

        @Override // java.util.List
        public E get(int i) {
            c.b.a.a.c.n.c.r(i, this.f3348e);
            return (E) c.this.get(i + this.f3347d);
        }

        @Override // c.b.b.b.b
        public int h() {
            return c.this.h() + this.f3347d;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, c.b.b.b.b, c.b.b.b.c, java.lang.Iterable
        public Iterator iterator() {
            return listIterator();
        }

        @Override // c.b.b.b.b
        public boolean j() {
            return true;
        }

        @Override // java.util.List, c.b.b.b.c
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return c.super.listIterator();
        }

        @Override // java.util.List, c.b.b.b.c
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return c.super.listIterator(i);
        }

        public int size() {
            return this.f3348e;
        }

        @Override // c.b.b.b.c
        /* renamed from: y */
        public c<E> subList(int i, int i2) {
            c.b.a.a.c.n.c.w(i, i2, this.f3348e);
            c cVar = c.this;
            int i3 = this.f3347d;
            return cVar.subList(i + i3, i2 + i3);
        }
    }

    public static <E> c<E> m(Object[] objArr) {
        int length = objArr.length;
        return length == 0 ? (c<E>) d.f : new d(objArr, length);
    }

    public static <E> c<E> o(Object[] objArr, int i) {
        return i == 0 ? (c<E>) d.f : new d(objArr, i);
    }

    public static <E> a<E> p() {
        return new a<>();
    }

    public static <E> c<E> q(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(c.a.a.a.a.l("at index ", i));
            }
        }
        return m(objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: c.b.b.b.c$a */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> c<E> r(Iterable<? extends E> iterable) {
        if (iterable == null) {
            throw null;
        } else if (iterable instanceof Collection) {
            return s((Collection) iterable);
        } else {
            Iterator<? extends E> it = iterable.iterator();
            if (!it.hasNext()) {
                return (c<E>) d.f;
            }
            Object next = it.next();
            if (!it.hasNext()) {
                return x(next);
            }
            a aVar = new a();
            aVar.a(next);
            while (it.hasNext()) {
                aVar.a(it.next());
            }
            return aVar.b();
        }
    }

    public static <E> c<E> s(Collection<? extends E> collection) {
        if (!(collection instanceof b)) {
            return q(collection.toArray());
        }
        c<E> cVar = (c) ((b) collection);
        if (cVar != null) {
            return cVar.j() ? m(cVar.toArray()) : cVar;
        }
        throw null;
    }

    public static <E> c<E> t(E[] eArr) {
        return eArr.length == 0 ? (c<E>) d.f : q((Object[]) eArr.clone());
    }

    public static <E> c<E> w() {
        return (c<E>) d.f;
    }

    public static <E> c<E> x(E e2) {
        return q(e2);
    }

    @Override // c.b.b.b.b
    public int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (c.b.a.a.c.n.c.J0(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = list.iterator();
                for (E e2 : this) {
                    if (it.hasNext()) {
                        if (!c.b.a.a.c.n.c.J0(e2, it.next())) {
                        }
                    }
                }
                return !it.hasNext();
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~(get(i2).hashCode() + (i * 31)));
        }
        return i;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, c.b.b.b.b, java.lang.Iterable
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

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: u */
    public e<E> listIterator() {
        return listIterator(0);
    }

    /* renamed from: v */
    public e<E> listIterator(int i) {
        int size = size();
        if (i >= 0 && i <= size) {
            return isEmpty() ? (e<E>) f3345c : new b(this, i);
        }
        throw new IndexOutOfBoundsException(c.b.a.a.c.n.c.l(i, size, "index"));
    }

    /* renamed from: y */
    public c<E> subList(int i, int i2) {
        c.b.a.a.c.n.c.w(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? (c<E>) d.f : new C0077c(i, i3);
    }
}
