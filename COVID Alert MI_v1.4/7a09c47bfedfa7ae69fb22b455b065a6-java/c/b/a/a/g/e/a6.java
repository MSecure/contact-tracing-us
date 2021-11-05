package c.b.a.a.g.e;

import c.b.a.a.d.k.b;
import c.b.a.a.d.k.o.e;
import c.b.a.a.j.j;
import com.google.android.gms.common.api.Status;

public final class a6<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    public final j<Void> f3502a;

    public a6(j<Void> jVar) {
        this.f3502a = jVar;
    }

    @Override // c.b.a.a.d.k.o.e
    public final void setFailedResult(Status status) {
        j<Void> jVar = this.f3502a;
        jVar.f4109a.h(new b(status));
    }

    @Override // c.b.a.a.d.k.o.e
    public final void setResult(T t) {
        this.f3502a.f4109a.i(null);
    }
}
