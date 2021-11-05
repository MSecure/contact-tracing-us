package c.b.a.a.e.c;

import java.util.NoSuchElementException;

public final class sa extends xa<T> {

    /* renamed from: b  reason: collision with root package name */
    public boolean f2726b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f2727c;

    public sa(Object obj) {
        this.f2727c = obj;
    }

    public final boolean hasNext() {
        return !this.f2726b;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!this.f2726b) {
            this.f2726b = true;
            return (T) this.f2727c;
        }
        throw new NoSuchElementException();
    }
}
