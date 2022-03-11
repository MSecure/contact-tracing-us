package f.b.a.a.a.g0;

import f.b.a.a.a.a0.r;
import f.b.a.a.a.h0.d;
import f.b.a.a.a.h0.p;
import f.b.a.d.a.b0;
/* loaded from: classes.dex */
public class p implements b0 {
    public final /* synthetic */ r a;

    public p(r rVar, r rVar2) {
        this.a = rVar2;
    }

    @Override // f.b.a.d.a.b0
    public void a(int i2) {
        this.a.c(d.EnumC0076d.RPC_TYPE_ENPA_REMOTE_CONFIG_FETCH, i2);
    }

    @Override // f.b.a.d.a.b0
    public void b(Exception exc) {
        this.a.e(d.EnumC0076d.RPC_TYPE_ENPA_REMOTE_CONFIG_FETCH, exc);
    }

    @Override // f.b.a.d.a.b0
    public void c() {
        this.a.i(p.d.TASK_SUBMIT_PRIVATE_ANALYTICS);
    }
}
