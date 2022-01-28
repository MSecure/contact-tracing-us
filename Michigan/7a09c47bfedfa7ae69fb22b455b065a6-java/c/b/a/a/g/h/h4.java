package c.b.a.a.g.h;

import java.util.ListIterator;

public final class h4 implements ListIterator<String> {

    /* renamed from: b  reason: collision with root package name */
    public ListIterator<String> f3905b = this.f3907d.f3886b.listIterator(this.f3906c);

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3906c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e4 f3907d;

    public h4(e4 e4Var, int i) {
        this.f3907d = e4Var;
        this.f3906c = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f3905b.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f3905b.hasPrevious();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator, java.util.ListIterator
    public final /* synthetic */ String next() {
        return this.f3905b.next();
    }

    public final int nextIndex() {
        return this.f3905b.nextIndex();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.f3905b.previous();
    }

    public final int previousIndex() {
        return this.f3905b.previousIndex();
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
