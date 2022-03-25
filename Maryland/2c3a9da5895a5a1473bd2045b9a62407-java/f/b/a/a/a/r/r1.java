package f.b.a.a.a.r;

import e.b.a.m;
import e.p.r;
import f.b.a.a.a.y.c0;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class r1 implements r {
    public final /* synthetic */ k4 a;

    public /* synthetic */ r1(k4 k4Var) {
        this.a = k4Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        String str;
        k4 k4Var = this.a;
        c0 c0Var = (c0) obj;
        Objects.requireNonNull(k4Var);
        if (c0Var != null) {
            k4Var.b0.b.setOnClickListener(new w1(k4Var, c0Var));
            if (k4Var.c0.y) {
                k4Var.z0(c0Var);
            }
            if (c0Var.i() != null) {
                str = k4Var.n0().getString(R.string.share_review_onset_date, k4Var.a0.g(k4Var.v().getConfiguration().locale).b(c0Var.i()));
            } else {
                str = "";
            }
            m.h.K0(k4Var.b0, c0Var, str, z3.c(k4Var.c0.x));
        }
    }
}
