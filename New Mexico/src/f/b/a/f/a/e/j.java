package f.b.a.f.a.e;
/* loaded from: classes.dex */
public final class j extends b {
    public final /* synthetic */ k c;

    public j(k kVar) {
        this.c = kVar;
    }

    @Override // f.b.a.f.a.e.b
    public final void a() {
        l lVar = this.c.a;
        lVar.b.d("unlinkToDeath", new Object[0]);
        lVar.n.asBinder().unlinkToDeath(lVar.f3365k, 0);
        l lVar2 = this.c.a;
        lVar2.n = null;
        lVar2.f3361g = false;
    }
}
