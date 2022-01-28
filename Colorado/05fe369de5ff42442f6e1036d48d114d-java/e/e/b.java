package e.e;

import java.util.Map;

public class b extends g<E, E> {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f997d;

    public b(c cVar) {
        this.f997d = cVar;
    }

    @Override // e.e.g
    public void a() {
        this.f997d.clear();
    }

    @Override // e.e.g
    public Object b(int i2, int i3) {
        return this.f997d.c[i2];
    }

    @Override // e.e.g
    public Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // e.e.g
    public int d() {
        return this.f997d.f1004d;
    }

    @Override // e.e.g
    public int e(Object obj) {
        return this.f997d.indexOf(obj);
    }

    @Override // e.e.g
    public int f(Object obj) {
        return this.f997d.indexOf(obj);
    }

    @Override // e.e.g
    public void g(E e2, E e3) {
        this.f997d.add(e2);
    }

    @Override // e.e.g
    public void h(int i2) {
        this.f997d.l(i2);
    }

    @Override // e.e.g
    public E i(int i2, E e2) {
        throw new UnsupportedOperationException("not a map");
    }
}
