package f.b.a.a.a.u;

import f.b.a.a.a.p.r;
import f.b.a.a.a.v.d;
import f.b.a.a.a.v.p;
import f.b.a.d.a.b0;

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
