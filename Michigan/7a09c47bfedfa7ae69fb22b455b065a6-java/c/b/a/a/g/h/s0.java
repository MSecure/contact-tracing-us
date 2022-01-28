package c.b.a.a.g.h;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class s0 implements Iterator {

    /* renamed from: b  reason: collision with root package name */
    public int f4024b = 0;

    /* renamed from: c  reason: collision with root package name */
    public final int f4025c = this.f4026d.size();

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ q0 f4026d;

    public s0(q0 q0Var) {
        this.f4026d = q0Var;
    }

    public final byte a() {
        int i = this.f4024b;
        if (i < this.f4025c) {
            this.f4024b = i + 1;
            return this.f4026d.e(i);
        }
        throw new NoSuchElementException();
    }

    public final boolean hasNext() {
        return this.f4024b < this.f4025c;
    }

    @Override // java.util.Iterator
    public /* synthetic */ Object next() {
        return Byte.valueOf(a());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
