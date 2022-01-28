package b.f.a;

import c.a.a.a.a;

public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public Object f857a;

    /* renamed from: b  reason: collision with root package name */
    public e<T> f858b;

    /* renamed from: c  reason: collision with root package name */
    public f<Void> f859c = new f<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f860d;

    public boolean a(T t) {
        boolean z = true;
        this.f860d = true;
        e<T> eVar = this.f858b;
        if (eVar == null || !eVar.f862c.k(t)) {
            z = false;
        }
        if (z) {
            c();
        }
        return z;
    }

    public boolean b() {
        boolean z = true;
        this.f860d = true;
        e<T> eVar = this.f858b;
        if (eVar == null || !eVar.f862c.cancel(true)) {
            z = false;
        }
        if (z) {
            c();
        }
        return z;
    }

    public final void c() {
        this.f857a = null;
        this.f858b = null;
        this.f859c = null;
    }

    public boolean d(Throwable th) {
        boolean z = true;
        this.f860d = true;
        e<T> eVar = this.f858b;
        if (eVar == null || !eVar.f862c.l(th)) {
            z = false;
        }
        if (z) {
            c();
        }
        return z;
    }

    public void finalize() {
        f<Void> fVar;
        e<T> eVar = this.f858b;
        if (eVar != null && !eVar.isDone()) {
            StringBuilder g = a.g("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
            g.append(this.f857a);
            eVar.f862c.l(new c(g.toString()));
        }
        if (!this.f860d && (fVar = this.f859c) != null) {
            fVar.k(null);
        }
    }
}
