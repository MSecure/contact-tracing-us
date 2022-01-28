package c.b.a.a.c.k.o;

import c.b.a.a.c.k.f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public final class s implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f2398a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f2399b;

    public s(t tVar, BasePendingResult basePendingResult) {
        this.f2399b = tVar;
        this.f2398a = basePendingResult;
    }

    @Override // c.b.a.a.c.k.f.a
    public final void a(Status status) {
        this.f2399b.f2401a.remove(this.f2398a);
    }
}
