package c.b.a.a.g.b;

import java.util.ListIterator;

public final class l3 implements ListIterator<String> {

    /* renamed from: b  reason: collision with root package name */
    public ListIterator<String> f3341b = this.f3343d.f3333b.listIterator(this.f3342c);

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3342c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k3 f3343d;

    public l3(k3 k3Var, int i) {
        this.f3343d = k3Var;
        this.f3342c = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f3341b.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f3341b.hasPrevious();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ String next() {
        return this.f3341b.next();
    }

    public final int nextIndex() {
        return this.f3341b.nextIndex();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f3341b.previous();
    }

    public final int previousIndex() {
        return this.f3341b.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
