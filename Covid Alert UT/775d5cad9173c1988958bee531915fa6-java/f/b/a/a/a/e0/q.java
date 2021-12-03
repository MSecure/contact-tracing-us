package f.b.a.a.a.e0;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.b.a.m;
import e.q.t;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class q implements t {
    public final /* synthetic */ i0 a;

    public /* synthetic */ q(i0 i0Var) {
        this.a = i0Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        i0 i0Var = this.a;
        Void r5 = (Void) obj;
        View view = i0Var.F;
        if (view != null) {
            Snackbar J = m.e.J(view, R.string.gms_unavailable_error);
            J.k(R.string.learn_more, new n(i0Var, view));
            J.l();
        }
    }
}
