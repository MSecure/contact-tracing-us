package f.b.a.a.a.m;

import e.p.t;
import f.b.a.a.a.b0.q0;
import f.b.a.a.a.i.b0;
import gov.co.cdphe.exposurenotifications.R;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class d0 implements t {
    public final /* synthetic */ f1 a;

    public /* synthetic */ d0(f1 f1Var) {
        this.a = f1Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        f1 f1Var = this.a;
        List list = (List) obj;
        Objects.requireNonNull(f1Var);
        if (!list.isEmpty()) {
            String a2 = b0.a(((q0) list.get(0)).a().G(), f1Var.f0.c(), f1Var.f0.b(), f1Var.p0());
            f1Var.a0.f2219j.c.setText(f1Var.B(R.string.no_recent_exposure_card_content, a2));
            f1Var.a0.f2220k.c.setText(f1Var.B(R.string.no_recent_exposure_card_content, a2));
            return;
        }
        f1Var.a0.f2219j.c.setText(f1Var.A(R.string.no_recent_exposure_card_content_no_checks));
        f1Var.a0.f2220k.c.setText(f1Var.A(R.string.no_recent_exposure_card_content_no_checks));
    }
}
