package f.b.a.f.a.b;

import android.os.RemoteException;
import f.b.a.f.a.e.b;
import f.b.a.f.a.h.n;
import java.util.Map;
/* loaded from: classes.dex */
public final class e extends b {
    public final /* synthetic */ Map c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ n f3213d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s f3214e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(s sVar, n nVar, Map map, n nVar2) {
        super(nVar);
        this.f3214e = sVar;
        this.c = map;
        this.f3213d = nVar2;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        try {
            s sVar = this.f3214e;
            sVar.f3289d.n.N(sVar.a, s.l(this.c), new n(this.f3214e, this.f3213d));
        } catch (RemoteException e2) {
            s.f3287g.c(e2, "syncPacks", new Object[0]);
            this.f3213d.a(new RuntimeException(e2));
        }
    }
}
