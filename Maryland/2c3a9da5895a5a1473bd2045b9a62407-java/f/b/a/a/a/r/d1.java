package f.b.a.a.a.r;

import e.b.a.m;
import e.p.r;
import f.b.a.a.a.y.c0;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class d1 implements r {
    public final /* synthetic */ e4 a;

    public /* synthetic */ d1(e4 e4Var) {
        this.a = e4Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        String str;
        e4 e4Var = this.a;
        c0 c0Var = (c0) obj;
        Objects.requireNonNull(e4Var);
        if (c0Var != null) {
            e4Var.a0.f2152e.setOnClickListener(new u0(e4Var, c0Var));
            if (e4Var.b0.y) {
                e4Var.z0(c0Var);
            }
            if (c0Var.i() != null) {
                str = e4Var.n0().getString(R.string.share_review_onset_date, e4.d0.g(e4Var.v().getConfiguration().locale).b(c0Var.i()));
            } else {
                str = "";
            }
            m.h.K0(e4Var.a0, c0Var, str, z3.c(e4Var.b0.x));
        }
    }
}
