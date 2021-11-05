package c.b.a.a.d.k.o;

import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.i;
import c.b.a.a.d.k.o.d;
import c.b.a.a.d.k.o.g;
import com.google.android.gms.common.api.Status;

public final class s0<A extends d<? extends i, a.b>> extends g0 {

    /* renamed from: b  reason: collision with root package name */
    public final A f3047b;

    public s0(int i, A a2) {
        super(i);
        t.D(a2, "Null methods are not runnable.");
        this.f3047b = a2;
    }

    @Override // c.b.a.a.d.k.o.g0
    public final void b(Status status) {
        try {
            this.f3047b.setFailedResult(status);
        } catch (IllegalStateException unused) {
        }
    }

    @Override // c.b.a.a.d.k.o.g0
    public final void c(e1 e1Var, boolean z) {
        A a2 = this.f3047b;
        e1Var.f2973a.put(a2, Boolean.valueOf(z));
        a2.addStatusListener(new d1(e1Var, a2));
    }

    @Override // c.b.a.a.d.k.o.g0
    public final void d(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(localizedMessage).length() + simpleName.length() + 2);
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        try {
            this.f3047b.setFailedResult(new Status(10, sb.toString()));
        } catch (IllegalStateException unused) {
        }
    }

    @Override // c.b.a.a.d.k.o.g0
    public final void e(g.a<?> aVar) {
        try {
            this.f3047b.run(aVar.f2984b);
        } catch (RuntimeException e2) {
            d(e2);
        }
    }
}
