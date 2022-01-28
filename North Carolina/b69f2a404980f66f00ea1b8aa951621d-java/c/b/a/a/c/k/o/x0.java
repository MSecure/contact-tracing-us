package c.b.a.a.c.k.o;

import c.b.a.a.c.k.a;
import c.b.a.a.c.k.i;
import c.b.a.a.c.k.o.d;
import c.b.a.a.c.k.o.g;
import com.google.android.gms.common.api.Status;

public final class x0<A extends d<? extends i, a.b>> extends y {

    /* renamed from: b  reason: collision with root package name */
    public final A f2409b;

    public x0(int i, A a2) {
        super(i);
        this.f2409b = a2;
    }

    @Override // c.b.a.a.c.k.o.y
    public final void a(Status status) {
        this.f2409b.setFailedResult(status);
    }

    @Override // c.b.a.a.c.k.o.y
    public final void b(g.a<?> aVar) {
        try {
            this.f2409b.run(aVar.f2342b);
        } catch (RuntimeException e2) {
            d(e2);
        }
    }

    @Override // c.b.a.a.c.k.o.y
    public final void c(t tVar, boolean z) {
        A a2 = this.f2409b;
        tVar.f2401a.put(a2, Boolean.valueOf(z));
        a2.addStatusListener(new s(tVar, a2));
    }

    @Override // c.b.a.a.c.k.o.y
    public final void d(Exception exc) {
        String simpleName = exc.getClass().getSimpleName();
        String localizedMessage = exc.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(localizedMessage).length() + simpleName.length() + 2);
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.f2409b.setFailedResult(new Status(10, sb.toString()));
    }
}
