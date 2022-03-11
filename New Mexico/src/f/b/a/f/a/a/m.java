package f.b.a.f.a.a;

import android.os.RemoteException;
import f.b.a.f.a.e.b;
import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class m extends b {
    public final /* synthetic */ String c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f3168d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ o f3169e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(o oVar, n nVar, String str, n nVar2) {
        super(nVar);
        this.f3169e = oVar;
        this.c = str;
        this.f3168d = nVar2;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        try {
            o oVar = this.f3169e;
            oVar.a.n.j(oVar.b, o.a(oVar, this.c), new n(this.f3169e, this.f3168d, this.c));
        } catch (RemoteException e2) {
            o.f3172e.c(e2, "requestUpdateInfo(%s)", this.c);
            this.f3168d.a(new RuntimeException(e2));
        }
    }
}
