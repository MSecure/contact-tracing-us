package f.b.a.f.a.b;

import android.os.RemoteException;
import f.b.a.f.a.e.b;
import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class j extends b {
    public final /* synthetic */ n c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ s f3244d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(s sVar, n nVar, n nVar2) {
        super(nVar);
        this.f3244d = sVar;
        this.c = nVar2;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        try {
            s sVar = this.f3244d;
            sVar.f3290e.n.o(sVar.a, s.h(), new o(this.f3244d, this.c));
        } catch (RemoteException e2) {
            s.f3287g.c(e2, "keepAlive", new Object[0]);
        }
    }
}
