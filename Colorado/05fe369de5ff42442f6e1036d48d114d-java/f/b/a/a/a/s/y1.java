package f.b.a.a.a.s;

import e.p.t;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class y1 implements t {
    public final /* synthetic */ j6 a;

    public /* synthetic */ y1(j6 j6Var) {
        this.a = j6Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        boolean z;
        j6 j6Var = this.a;
        Objects.requireNonNull(j6Var);
        if (((Boolean) obj).booleanValue()) {
            j6Var.g0.f2192h.setText("");
            z = false;
            j6Var.g0.f2192h.setEnabled(false);
            j6Var.g0.f2195k.setVisibility(0);
        } else {
            z = true;
            j6Var.g0.f2192h.setEnabled(true);
            j6Var.g0.f2192h.setText(R.string.btn_share);
            j6Var.g0.f2195k.setVisibility(4);
        }
        j6Var.g0.f2188d.setEnabled(z);
        j6Var.g0.n.setEnabled(z);
        j6Var.g0.q.setEnabled(z);
        j6Var.g0.f2191g.setEnabled(z);
        j6Var.g0.o.setEnabled(z);
    }
}
