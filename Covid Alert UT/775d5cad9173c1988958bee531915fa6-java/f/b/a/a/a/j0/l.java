package f.b.a.a.a.j0;

import android.widget.FrameLayout;
import com.google.android.material.snackbar.Snackbar;
import e.b.a.m;
import e.q.t;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class l implements t {
    public final /* synthetic */ o0 a;

    public /* synthetic */ l(o0 o0Var) {
        this.a = o0Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        o0 o0Var = this.a;
        Void r5 = (Void) obj;
        FrameLayout frameLayout = o0Var.b0.a;
        if (frameLayout != null) {
            Snackbar J = m.e.J(frameLayout, R.string.gms_unavailable_error);
            J.k(R.string.learn_more, new k(o0Var, frameLayout));
            J.l();
        }
    }
}
