package c.b.a.a.g.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class z implements Iterator {

    /* renamed from: b  reason: collision with root package name */
    public int f3481b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f3482c = this.f3483d.size();

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ y f3483d;

    public z(y yVar) {
        this.f3483d = yVar;
    }

    public final boolean hasNext() {
        return this.f3481b < this.f3482c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        try {
            y yVar = this.f3483d;
            int i = this.f3481b;
            this.f3481b = i + 1;
            return Byte.valueOf(yVar.e(i));
        } catch (IndexOutOfBoundsException e2) {
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
