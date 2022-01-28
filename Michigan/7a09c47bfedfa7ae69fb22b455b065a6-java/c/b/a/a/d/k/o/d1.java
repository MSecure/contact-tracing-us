package c.b.a.a.d.k.o;

import c.b.a.a.d.k.f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

public final class d1 implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f2968a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e1 f2969b;

    public d1(e1 e1Var, BasePendingResult basePendingResult) {
        this.f2969b = e1Var;
        this.f2968a = basePendingResult;
    }

    @Override // c.b.a.a.d.k.f.a
    public final void a(Status status) {
        this.f2969b.f2973a.remove(this.f2968a);
    }
}
