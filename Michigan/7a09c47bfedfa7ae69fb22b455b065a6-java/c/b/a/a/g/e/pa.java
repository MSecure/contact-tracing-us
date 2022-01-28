package c.b.a.a.g.e;

import b.x.t;
import java.util.NoSuchElementException;

/* JADX WARN: Incorrect class signature, class is equals to this class: <E:Ljava/lang/Object;>Lc/b/a/a/g/e/pa<TE;>; */
public final class pa<E> extends wa {

    /* renamed from: b  reason: collision with root package name */
    public final int f3688b;

    /* renamed from: c  reason: collision with root package name */
    public int f3689c;

    /* renamed from: d  reason: collision with root package name */
    public final na<E> f3690d;

    public pa(na<E> naVar, int i) {
        int size = naVar.size();
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(t.c4(i, size, "index"));
        }
        this.f3688b = size;
        this.f3689c = i;
        this.f3690d = naVar;
    }

    public final boolean hasNext() {
        return this.f3689c < this.f3688b;
    }

    public final boolean hasPrevious() {
        return this.f3689c > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (this.f3689c < this.f3688b) {
            int i = this.f3689c;
            this.f3689c = i + 1;
            return this.f3690d.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f3689c;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (this.f3689c > 0) {
            int i = this.f3689c - 1;
            this.f3689c = i;
            return this.f3690d.get(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f3689c - 1;
    }
}
