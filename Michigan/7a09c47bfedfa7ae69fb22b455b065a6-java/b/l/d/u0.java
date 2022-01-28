package b.l.d;

import b.o.f;
import b.o.j;
import b.t.b;
import b.t.c;
import b.t.d;

public class u0 implements d {

    /* renamed from: b  reason: collision with root package name */
    public j f2137b = null;

    /* renamed from: c  reason: collision with root package name */
    public c f2138c = null;

    public void a(f.a aVar) {
        j jVar = this.f2137b;
        jVar.d("handleLifecycleEvent");
        jVar.g(aVar.b());
    }

    @Override // b.o.i
    public f getLifecycle() {
        if (this.f2137b == null) {
            this.f2137b = new j(this);
            this.f2138c = new c(this);
        }
        return this.f2137b;
    }

    @Override // b.t.d
    public b getSavedStateRegistry() {
        return this.f2138c.f2585b;
    }
}
