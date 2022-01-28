package b.f.a;

import c.a.a.a.a;

public final class b<T> {

    /* renamed from: a  reason: collision with root package name */
    public Object f1444a;

    /* renamed from: b  reason: collision with root package name */
    public e<T> f1445b;

    /* renamed from: c  reason: collision with root package name */
    public f<Void> f1446c = new f<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f1447d;

    public boolean a(T t) {
        boolean z = true;
        this.f1447d = true;
        e<T> eVar = this.f1445b;
        if (eVar == null || !eVar.f1449c.k(t)) {
            z = false;
        }
        if (z) {
            c();
        }
        return z;
    }

    public boolean b() {
        boolean z = true;
        this.f1447d = true;
        e<T> eVar = this.f1445b;
        if (eVar == null || !eVar.f1449c.cancel(true)) {
            z = false;
        }
        if (z) {
            c();
        }
        return z;
    }

    public final void c() {
        this.f1444a = null;
        this.f1445b = null;
        this.f1446c = null;
    }

    public boolean d(Throwable th) {
        boolean z = true;
        this.f1447d = true;
        e<T> eVar = this.f1445b;
        if (eVar == null || !eVar.f1449c.l(th)) {
            z = false;
        }
        if (z) {
            c();
        }
        return z;
    }

    public void finalize() {
        f<Void> fVar;
        e<T> eVar = this.f1445b;
        if (eVar != null && !eVar.isDone()) {
            StringBuilder h = a.h("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
            h.append(this.f1444a);
            eVar.f1449c.l(new c(h.toString()));
        }
        if (!this.f1447d && (fVar = this.f1446c) != null) {
            fVar.k(null);
        }
    }
}
