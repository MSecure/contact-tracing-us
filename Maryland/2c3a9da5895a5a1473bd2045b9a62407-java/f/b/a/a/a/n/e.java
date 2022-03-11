package f.b.a.a.a.n;

import android.util.Log;
import e.b.a.m;
import e.f.a.b;
import f.a.b.p;
import f.a.b.u;
import f.b.a.a.a.n.v;
import f.b.a.a.a.u.i;

public final /* synthetic */ class e implements p.a {
    public final /* synthetic */ s a;
    public final /* synthetic */ b b;

    public /* synthetic */ e(s sVar, b bVar) {
        this.a = sVar;
        this.b = bVar;
    }

    @Override // f.a.b.p.a
    public final void a(u uVar) {
        s sVar = this.a;
        b bVar = this.b;
        sVar.f2198f.e(i.d.RPC_TYPE_VERIFICATION, uVar);
        Log.e("DiagnosisAttestor", String.format("Verification code submission error: [%s]", m.h.e0(uVar)));
        bVar.c(m.h.h0(uVar) >= 500 ? new v.e(uVar) : new v.d(uVar));
    }
}
