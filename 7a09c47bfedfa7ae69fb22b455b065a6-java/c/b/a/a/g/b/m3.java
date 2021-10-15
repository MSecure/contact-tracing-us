package c.b.a.a.g.b;

import java.util.Iterator;

public final class m3 implements Iterator<String> {

    /* renamed from: b  reason: collision with root package name */
    public Iterator<String> f3348b = this.f3349c.f3333b.iterator();

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k3 f3349c;

    public m3(k3 k3Var) {
        this.f3349c = k3Var;
    }

    public final boolean hasNext() {
        return this.f3348b.hasNext();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f3348b.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
