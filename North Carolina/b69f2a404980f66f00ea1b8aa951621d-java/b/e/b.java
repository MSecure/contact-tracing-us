package b.e;

import java.util.Map;

public class b extends g<E, E> {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f795d;

    public b(c cVar) {
        this.f795d = cVar;
    }

    @Override // b.e.g
    public void a() {
        this.f795d.clear();
    }

    @Override // b.e.g
    public Object b(int i, int i2) {
        return this.f795d.f797c[i];
    }

    @Override // b.e.g
    public Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // b.e.g
    public int d() {
        return this.f795d.f798d;
    }

    @Override // b.e.g
    public int e(Object obj) {
        return this.f795d.indexOf(obj);
    }

    @Override // b.e.g
    public int f(Object obj) {
        return this.f795d.indexOf(obj);
    }

    @Override // b.e.g
    public void g(E e2, E e3) {
        this.f795d.add(e2);
    }

    @Override // b.e.g
    public void h(int i) {
        this.f795d.j(i);
    }

    @Override // b.e.g
    public E i(int i, E e2) {
        throw new UnsupportedOperationException("not a map");
    }
}
