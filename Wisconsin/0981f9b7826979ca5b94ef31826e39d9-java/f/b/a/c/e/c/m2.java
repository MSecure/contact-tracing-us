package f.b.a.c.e.c;

import f.b.a.c.b.o.b;
import java.util.NoSuchElementException;

/* JADX WARN: Incorrect class signature, class is equals to this class: <E:Ljava/lang/Object;>Lf/b/a/c/e/c/m2<TE;>; */
public final class m2<E> extends o2 {
    public final int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public final k2<E> f2512d;

    public m2(k2<E> k2Var, int i2) {
        int size = k2Var.size();
        if (i2 < 0 || i2 > size) {
            throw new IndexOutOfBoundsException(b.Z1(i2, size, "index"));
        }
        this.b = size;
        this.c = i2;
        this.f2512d = k2Var;
    }

    public final boolean hasNext() {
        return this.c < this.b;
    }

    public final boolean hasPrevious() {
        return this.c > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (hasNext()) {
            int i2 = this.c;
            this.c = i2 + 1;
            return this.f2512d.get(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.c;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i2 = this.c - 1;
            this.c = i2;
            return this.f2512d.get(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.c - 1;
    }
}
