package e.f;

import java.util.Map;
/* loaded from: classes.dex */
public class b extends g<E, E> {

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c f1291d;

    public b(c cVar) {
        this.f1291d = cVar;
    }

    @Override // e.f.g
    public void a() {
        this.f1291d.clear();
    }

    @Override // e.f.g
    public Object b(int i2, int i3) {
        return this.f1291d.c[i2];
    }

    @Override // e.f.g
    public Map<E, E> c() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // e.f.g
    public int d() {
        return this.f1291d.f1298d;
    }

    @Override // e.f.g
    public int e(Object obj) {
        return this.f1291d.indexOf(obj);
    }

    @Override // e.f.g
    public int f(Object obj) {
        return this.f1291d.indexOf(obj);
    }

    @Override // e.f.g
    public void g(E e2, E e3) {
        this.f1291d.add(e2);
    }

    @Override // e.f.g
    public void h(int i2) {
        this.f1291d.l(i2);
    }

    @Override // e.f.g
    public E i(int i2, E e2) {
        throw new UnsupportedOperationException("not a map");
    }
}
