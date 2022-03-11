package h.a.j1;

import h.a.j1.t2;
/* loaded from: classes.dex */
public final class v2<T> implements d2<T> {
    public final t2.c<T> a;

    public v2(t2.c<T> cVar) {
        this.a = cVar;
    }

    @Override // h.a.j1.d2
    public T a() {
        return (T) t2.a(this.a);
    }

    @Override // h.a.j1.d2
    public T b(Object obj) {
        t2.b(this.a, obj);
        return null;
    }
}
