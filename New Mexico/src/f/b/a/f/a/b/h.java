package f.b.a.f.a.b;

import android.os.Bundle;
import android.os.RemoteException;
import f.b.a.f.a.e.b;
import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class h extends b {
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f3227d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f3228e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(s sVar, n nVar, int i2, n nVar2) {
        super(nVar);
        this.f3228e = sVar;
        this.c = i2;
        this.f3227d = nVar2;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        try {
            s sVar = this.f3228e;
            String str = sVar.a;
            int i2 = this.c;
            Bundle bundle = new Bundle();
            bundle.putInt("session_id", i2);
            sVar.f3289d.n.t(str, bundle, s.h(), new r(this.f3228e, this.f3227d));
        } catch (RemoteException e2) {
            s.f3287g.c(e2, "notifySessionFailed", new Object[0]);
        }
    }
}
