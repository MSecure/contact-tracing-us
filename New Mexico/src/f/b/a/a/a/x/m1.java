package f.b.a.a.a.x;

import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.o.a.m;
import e.r.l;
import e.r.q;
import f.b.a.a.a.f0.m0;
import f.b.a.a.a.f0.o0;
import f.b.a.a.a.f0.q0;
import f.b.a.a.a.f0.s0;
import f.b.a.a.a.f0.u0;
/* loaded from: classes.dex */
public class m1 extends q<m> {
    public boolean m = false;
    public ExposureNotificationViewModel.b n = ExposureNotificationViewModel.b.DISABLED;
    public boolean o = false;
    public boolean p = false;
    public boolean q = false;
    public boolean r = false;

    public final void n() {
        l s0Var;
        if (this.o) {
            s0Var = this.r ? this.m ? new s0() : new q0() : (!this.q || this.p || !this.m) ? new g1() : new u0();
        } else if (this.m) {
            s0Var = new s0();
        } else {
            ExposureNotificationViewModel.b bVar = this.n;
            s0Var = bVar == ExposureNotificationViewModel.b.PAUSED_EN_NOT_SUPPORT ? new o0() : bVar == ExposureNotificationViewModel.b.PAUSED_NOT_IN_ALLOWLIST ? new m0() : new q0();
        }
        l(s0Var);
    }
}
