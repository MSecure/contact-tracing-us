package e.f.a;

import f.a.a.a.a;

public final class b<T> {
    public Object a;
    public e<T> b;
    public f<Void> c = new f<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f1035d;

    public boolean a(T t) {
        boolean z = true;
        this.f1035d = true;
        e<T> eVar = this.b;
        if (eVar == null || !eVar.c.i(t)) {
            z = false;
        }
        if (z) {
            c();
        }
        return z;
    }

    public boolean b() {
        boolean z = true;
        this.f1035d = true;
        e<T> eVar = this.b;
        if (eVar == null || !eVar.c.cancel(true)) {
            z = false;
        }
        if (z) {
            c();
        }
        return z;
    }

    public final void c() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public boolean d(Throwable th) {
        boolean z = true;
        this.f1035d = true;
        e<T> eVar = this.b;
        if (eVar == null || !eVar.c.j(th)) {
            z = false;
        }
        if (z) {
            c();
        }
        return z;
    }

    public void finalize() {
        f<Void> fVar;
        e<T> eVar = this.b;
        if (eVar != null && !eVar.isDone()) {
            StringBuilder i2 = a.i("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
            i2.append(this.a);
            eVar.c.j(new c(i2.toString()));
        }
        if (!this.f1035d && (fVar = this.c) != null) {
            fVar.i(null);
        }
    }
}
