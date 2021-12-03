package f.b.a.a.a.d0;

import e.q.t;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class y1 implements t {
    public final /* synthetic */ i6 a;

    public /* synthetic */ y1(i6 i6Var) {
        this.a = i6Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        boolean z;
        i6 i6Var = this.a;
        Objects.requireNonNull(i6Var);
        if (((Boolean) obj).booleanValue()) {
            i6Var.h0.f2387h.setText("");
            z = false;
            i6Var.h0.f2387h.setEnabled(false);
            i6Var.h0.f2390k.setVisibility(0);
        } else {
            z = true;
            i6Var.h0.f2387h.setEnabled(true);
            i6Var.h0.f2387h.setText(R.string.btn_share);
            i6Var.h0.f2390k.setVisibility(4);
        }
        i6Var.h0.f2383d.setEnabled(z);
        i6Var.h0.n.setEnabled(z);
        i6Var.h0.q.setEnabled(z);
        i6Var.h0.f2386g.setEnabled(z);
        i6Var.h0.o.setEnabled(z);
    }
}
