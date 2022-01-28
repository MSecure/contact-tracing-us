package g.b.a.c.c;

import f.b.a.a.a.h;
import g.b.b.b;

public final class d implements b<Object> {
    public volatile Object b;
    public final Object c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final e f3748d;

    public d(e eVar) {
        this.f3748d = eVar;
    }

    @Override // g.b.b.b
    public Object e() {
        if (this.b == null) {
            synchronized (this.c) {
                if (this.b == null) {
                    this.b = ((h.a) this.f3748d).a();
                }
            }
        }
        return this.b;
    }
}
