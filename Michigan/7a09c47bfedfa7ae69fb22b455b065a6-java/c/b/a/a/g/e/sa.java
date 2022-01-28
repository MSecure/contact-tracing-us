package c.b.a.a.g.e;

import java.util.NoSuchElementException;

public final class sa extends xa<T> {

    /* renamed from: b  reason: collision with root package name */
    public boolean f3722b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f3723c;

    public sa(Object obj) {
        this.f3723c = obj;
    }

    public final boolean hasNext() {
        return !this.f3722b;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!this.f3722b) {
            this.f3722b = true;
            return (T) this.f3723c;
        }
        throw new NoSuchElementException();
    }
}
