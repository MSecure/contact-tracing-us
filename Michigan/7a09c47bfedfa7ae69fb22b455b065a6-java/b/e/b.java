package b.e;

import java.util.Map;

public class b extends g<E, E> {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1371d;

    public b(c cVar) {
        this.f1371d = cVar;
    }

    @Override // b.e.g
    public void a() {
        this.f1371d.clear();
    }

    @Override // b.e.g
    public Object b(int i, int i2) {
        return this.f1371d.f1375c[i];
    }

    @Override // b.e.g
    public Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // b.e.g
    public int d() {
        return this.f1371d.f1376d;
    }

    @Override // b.e.g
    public int e(Object obj) {
        return this.f1371d.indexOf(obj);
    }

    @Override // b.e.g
    public int f(Object obj) {
        return this.f1371d.indexOf(obj);
    }

    @Override // b.e.g
    public void g(E e2, E e3) {
        this.f1371d.add(e2);
    }

    @Override // b.e.g
    public void h(int i) {
        this.f1371d.h(i);
    }

    @Override // b.e.g
    public E i(int i, E e2) {
        throw new UnsupportedOperationException("not a map");
    }
}
