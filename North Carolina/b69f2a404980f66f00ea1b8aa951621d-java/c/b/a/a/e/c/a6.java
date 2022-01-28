package c.b.a.a.e.c;

import c.b.a.a.c.k.b;
import c.b.a.a.c.k.o.e;
import c.b.a.a.g.i;
import com.google.android.gms.common.api.Status;

public final class a6<T> implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    public final i<Void> f2519a;

    public a6(i<Void> iVar) {
        this.f2519a = iVar;
    }

    @Override // c.b.a.a.c.k.o.e
    public final void setFailedResult(Status status) {
        i<Void> iVar = this.f2519a;
        iVar.f2856a.h(new b(status));
    }

    @Override // c.b.a.a.c.k.o.e
    public final void setResult(T t) {
        this.f2519a.f2856a.i(null);
    }
}
