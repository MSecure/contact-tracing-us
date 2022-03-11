package f.b.a.f.a.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
/* loaded from: classes.dex */
public final class i extends b {
    public final /* synthetic */ IBinder c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f3357d;

    public i(k kVar, IBinder iBinder) {
        this.f3357d = kVar;
        this.c = iBinder;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T extends android.os.IInterface, android.os.IInterface] */
    @Override // f.b.a.f.a.e.b
    public final void a() {
        l lVar = this.f3357d.a;
        lVar.n = (IInterface) lVar.f3363i.a(this.c);
        l lVar2 = this.f3357d.a;
        lVar2.b.d("linkToDeath", new Object[0]);
        try {
            lVar2.n.asBinder().linkToDeath(lVar2.f3365k, 0);
        } catch (RemoteException e2) {
            lVar2.b.c(e2, "linkToDeath failed", new Object[0]);
        }
        l lVar3 = this.f3357d.a;
        lVar3.f3361g = false;
        for (b bVar : lVar3.f3358d) {
            bVar.run();
        }
        this.f3357d.a.f3358d.clear();
    }
}
