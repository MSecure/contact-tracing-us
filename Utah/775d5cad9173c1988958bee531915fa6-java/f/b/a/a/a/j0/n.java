package f.b.a.a.a.j0;

import com.google.android.material.snackbar.Snackbar;
import e.q.t;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class n implements t {
    public final /* synthetic */ o0 a;

    public /* synthetic */ n(o0 o0Var) {
        this.a = o0Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        o0 o0Var = this.a;
        Void r3 = (Void) obj;
        Snackbar.j(o0Var.u0(), o0Var.E(R.string.generic_error_message), 0).l();
    }
}
