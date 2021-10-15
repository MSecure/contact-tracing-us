package c.b.b.b;

import b.x.t;
import c.b.b.b.b;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class c<E> extends b<E> implements List<E>, RandomAccess {

    /* renamed from: c  reason: collision with root package name */
    public static final e<Object> f4684c = new b(d.f4689f, 0);

    public static final class a<E> extends b.a<E> {
        public a() {
            super(4);
        }

        public a<E> a(E e2) {
            if (e2 != null) {
                int i = this.f4682b + 1;
                Object[] objArr = this.f4681a;
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
                        this.f4681a = Arrays.copyOf(objArr, i2);
                    } else {
                        throw new AssertionError("cannot store more than MAX_VALUE elements");
                    }
                } else {
                    if (this.f4683c) {
                        this.f4681a = (Object[]) objArr.clone();
                    }
                    Object[] objArr2 = this.f4681a;
                    int i3 = this.f4682b;
                    this.f4682b = i3 + 1;
                    objArr2[i3] = e2;
                    return this;
                }
                this.f4683c = false;
                Object[] objArr22 = this.f4681a;
                int i32 = this.f4682b;
                this.f4682b = i32 + 1;
                objArr22[i32] = e2;
                return this;
            }
            throw null;
        }

        public c<E> b() {
            this.f4683c = true;
            return c.l(this.f4681a, this.f4682b);
        }
    }

    public static class b<E> extends a<E> {

        /* renamed from: d  reason: collision with root package name */
        public final c<E> f4685d;

        public b(c<E> cVar, int i) {
            super(cVar.size(), i);
            this.f4685d = cVar;
        }
    }

    /* renamed from: c.b.b.b.c$c  reason: collision with other inner class name */
    public class C0086c extends c<E> {

        /* renamed from: d  reason: collision with root package name */
        public final transient int f4686d;

        /* renamed from: e  reason: collision with root package name */
        public final transient int f4687e;

        public C0086c(int i, int i2) {
            this.f4686d = i;
            this.f4687e = i2;
        }

        @Override // c.b.b.b.c
        /* renamed from: E */
        public c<E> subList(int i, int i2) {
            t.H(i, i2, this.f4687e);
            c cVar = c.this;
            int i3 = this.f4686d;
            return cVar.subList(i + i3, i2 + i3);
        }

        @Override // c.b.b.b.b
        public Object[] c() {
            return c.this.c();
        }

        @Override // c.b.b.b.b
        public int e() {
            return c.this.g() + this.f4686d + this.f4687e;
        }

        @Override // c.b.b.b.b
        public int g() {
            return c.this.g() + this.f4686d;
        }

        @Override // java.util.List
        public E get(int i) {
            t.w(i, this.f4687e);
            return (E) c.this.get(i + this.f4686d);
        }

        @Override // c.b.b.b.b
        public boolean h() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, c.b.b.b.b, c.b.b.b.c, java.lang.Iterable
        public Iterator iterator() {
            return listIterator();
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
            return this.f4687e;
        }
    }

    public static <E> c<E> C(E e2) {
        return p(e2);
    }

    public static <E> c<E> j(Object[] objArr) {
        int length = objArr.length;
        return length == 0 ? (c<E>) d.f4689f : new d(objArr, length);
    }

    public static <E> c<E> l(Object[] objArr, int i) {
        return i == 0 ? (c<E>) d.f4689f : new d(objArr, i);
    }

    public static <E> a<E> o() {
        return new a<>();
    }

    public static <E> c<E> p(Object... objArr) {
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (objArr[i] == null) {
                throw new NullPointerException(c.a.a.a.a.n("at index ", i));
            }
        }
        return j(objArr);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: c.b.b.b.c$a */
    /* JADX WARN: Multi-variable type inference failed */
    public static <E> c<E> q(Iterable<? extends E> iterable) {
        if (iterable == null) {
            throw null;
        } else if (iterable instanceof Collection) {
            return u((Collection) iterable);
        } else {
            Iterator<? extends E> it = iterable.iterator();
            if (!it.hasNext()) {
                return (c<E>) d.f4689f;
            }
            Object next = it.next();
            if (!it.hasNext()) {
                return C(next);
            }
            a aVar = new a();
            aVar.a(next);
            while (it.hasNext()) {
                aVar.a(it.next());
            }
            return aVar.b();
        }
    }

    public static <E> c<E> u(Collection<? extends E> collection) {
        if (!(collection instanceof b)) {
            return p(collection.toArray());
        }
        c<E> cVar = (c) ((b) collection);
        if (cVar != null) {
            return cVar.h() ? j(cVar.toArray()) : cVar;
        }
        throw null;
    }

    public static <E> c<E> v(E[] eArr) {
        return eArr.length == 0 ? (c<E>) d.f4689f : p((Object[]) eArr.clone());
    }

    public static <E> c<E> z() {
        return (c<E>) d.f4689f;
    }

    /* renamed from: E */
    public c<E> subList(int i, int i2) {
        t.H(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        return i3 == 0 ? (c<E>) d.f4689f : new C0086c(i, i3);
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
                        if (t.l1(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                Iterator<E> it = list.iterator();
                for (E e2 : this) {
                    if (it.hasNext()) {
                        if (!t.l1(e2, it.next())) {
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

    /* renamed from: w */
    public e<E> listIterator() {
        return listIterator(0);
    }

    /* renamed from: x */
    public e<E> listIterator(int i) {
        int size = size();
        if (i >= 0 && i <= size) {
            return isEmpty() ? (e<E>) f4684c : new b(this, i);
        }
        throw new IndexOutOfBoundsException(t.l(i, size, "index"));
    }
}
