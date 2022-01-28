package f.b.a.a.a.w;

import e.q.t;
import f.b.a.a.a.l0.q0;
import f.b.a.a.a.s.a0;
import gov.ut.covid19.exposurenotifications.R;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class d0 implements t {
    public final /* synthetic */ f1 a;

    public /* synthetic */ d0(f1 f1Var) {
        this.a = f1Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        f1 f1Var = this.a;
        List list = (List) obj;
        Objects.requireNonNull(f1Var);
        if (!list.isEmpty()) {
            String a2 = a0.a(((q0) list.get(0)).a().G(), f1Var.g0.c(), f1Var.g0.b(), f1Var.t0());
            f1Var.b0.f2414j.c.setText(f1Var.F(R.string.no_recent_exposure_card_content, a2));
            f1Var.b0.f2415k.c.setText(f1Var.F(R.string.no_recent_exposure_card_content, a2));
            return;
        }
        f1Var.b0.f2414j.c.setText(f1Var.E(R.string.no_recent_exposure_card_content_no_checks));
        f1Var.b0.f2415k.c.setText(f1Var.E(R.string.no_recent_exposure_card_content_no_checks));
    }
}
