package f.b.a.a.a.t;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.b.a.m;
import e.p.t;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class q implements t {
    public final /* synthetic */ g0 a;

    public /* synthetic */ q(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        g0 g0Var = this.a;
        Void r5 = (Void) obj;
        View view = g0Var.F;
        if (view != null) {
            Snackbar H = m.h.H(view, R.string.gms_unavailable_error);
            H.k(R.string.learn_more, new n(g0Var, view));
            H.l();
        }
    }
}
