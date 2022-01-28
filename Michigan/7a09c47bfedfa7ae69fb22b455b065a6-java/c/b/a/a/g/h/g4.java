package c.b.a.a.g.h;

import java.util.Iterator;

public final class g4 implements Iterator<String> {

    /* renamed from: b  reason: collision with root package name */
    public Iterator<String> f3899b = this.f3900c.f3886b.iterator();

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ e4 f3900c;

    public g4(e4 e4Var) {
        this.f3900c = e4Var;
    }

    public final boolean hasNext() {
        return this.f3899b.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f3899b.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
