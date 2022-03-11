package f.b.a.f.a.e;
/* loaded from: classes.dex */
public final class f extends b {
    public final /* synthetic */ l c;

    public f(l lVar) {
        this.c = lVar;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        l lVar = this.c;
        if (lVar.n != 0) {
            lVar.b.d("Unbind from service.", new Object[0]);
            l lVar2 = this.c;
            lVar2.a.unbindService(lVar2.m);
            l lVar3 = this.c;
            lVar3.f3361g = false;
            lVar3.n = null;
            lVar3.m = null;
        }
        this.c.d();
    }
}
