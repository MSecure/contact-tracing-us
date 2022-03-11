package f.b.a.a.a.l;

import android.util.Log;
import e.b.a.m;
import e.f.a.b;
import f.a.b.p;
import f.a.b.u;
import f.b.a.a.a.l.u;
import f.b.a.a.a.s.i;

public final /* synthetic */ class e implements p.a {
    public final /* synthetic */ r a;
    public final /* synthetic */ b b;

    public /* synthetic */ e(r rVar, b bVar) {
        this.a = rVar;
        this.b = bVar;
    }

    @Override // f.a.b.p.a
    public final void a(u uVar) {
        r rVar = this.a;
        b bVar = this.b;
        rVar.f2118f.e(i.d.RPC_TYPE_VERIFICATION, uVar);
        Log.e("DiagnosisAttestor", String.format("Verification code submission error: [%s]", m.h.e0(uVar)));
        bVar.c(m.h.h0(uVar) >= 500 ? new u.e(uVar) : new u.d(uVar));
    }
}
