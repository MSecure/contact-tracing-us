package f.b.a.f.a.e;

import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class e extends b {
    public final /* synthetic */ b c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l f3356d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(l lVar, n nVar, b bVar) {
        super(nVar);
        this.f3356d = lVar;
        this.c = bVar;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        l lVar = this.f3356d;
        b bVar = this.c;
        if (lVar.n == 0 && !lVar.f3361g) {
            lVar.b.d("Initiate binding to the service.", new Object[0]);
            lVar.f3358d.add(bVar);
            k kVar = new k(lVar);
            lVar.m = kVar;
            lVar.f3361g = true;
            if (!lVar.a.bindService(lVar.f3362h, kVar, 1)) {
                lVar.b.d("Failed to bind to the service.", new Object[0]);
                lVar.f3361g = false;
                for (b bVar2 : lVar.f3358d) {
                    m mVar = new m();
                    n<?> nVar = bVar2.b;
                    if (nVar != null) {
                        nVar.a(mVar);
                    }
                }
                lVar.f3358d.clear();
            }
        } else if (lVar.f3361g) {
            lVar.b.d("Waiting to bind to the service.", new Object[0]);
            lVar.f3358d.add(bVar);
        } else {
            bVar.run();
        }
    }
}
