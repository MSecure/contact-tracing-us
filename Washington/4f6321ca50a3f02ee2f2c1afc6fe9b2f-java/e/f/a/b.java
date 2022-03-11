package e.f.a;

import f.a.a.a.a;

public final class b<T> {
    public Object a;
    public e<T> b;
    public f<Void> c = new f<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f1211d;

    public boolean a(T t) {
        boolean z = true;
        this.f1211d = true;
        e<T> eVar = this.b;
        if (eVar == null || !eVar.c.i(t)) {
            z = false;
        }
        if (z) {
            b();
        }
        return z;
    }

    public final void b() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public boolean c(Throwable th) {
        boolean z = true;
        this.f1211d = true;
        e<T> eVar = this.b;
        if (eVar == null || !eVar.c.j(th)) {
            z = false;
        }
        if (z) {
            b();
        }
        return z;
    }

    public void finalize() {
        f<Void> fVar;
        e<T> eVar = this.b;
        if (eVar != null && !eVar.isDone()) {
            StringBuilder h2 = a.h("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
            h2.append(this.a);
            eVar.c.j(new c(h2.toString()));
        }
        if (!this.f1211d && (fVar = this.c) != null) {
            fVar.i(null);
        }
    }
}
