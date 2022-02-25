package h.a.j1;

import h.a.c1;
import h.a.f;
import h.a.n0;

public class q extends b0 {
    public final /* synthetic */ f.a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ c1 f3707d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p f3708e;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(p pVar, f.a aVar, c1 c1Var) {
        super(pVar.f3694e);
        this.f3708e = pVar;
        this.c = aVar;
        this.f3707d = c1Var;
    }

    @Override // h.a.j1.b0
    public void a() {
        p pVar = this.f3708e;
        f.a aVar = this.c;
        c1 c1Var = this.f3707d;
        n0 n0Var = new n0();
        if (!pVar.t) {
            pVar.t = true;
            aVar.a(c1Var, n0Var);
        }
    }
}
