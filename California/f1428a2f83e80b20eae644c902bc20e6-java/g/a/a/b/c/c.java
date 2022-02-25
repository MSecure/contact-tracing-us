package g.a.a.b.c;

import f.b.a.a.a.g;
import g.a.b.b;

public final class c implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final d f3490d;

    public c(d dVar) {
        this.f3490d = dVar;
    }

    @Override // g.a.b.b
    public Object d() {
        if (this.b == null) {
            synchronized (this.c) {
                if (this.b == null) {
                    this.b = ((g.a) this.f3490d).a();
                }
            }
        }
        return this.b;
    }
}
