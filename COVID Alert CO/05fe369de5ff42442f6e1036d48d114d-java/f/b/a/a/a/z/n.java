package f.b.a.a.a.z;

import com.google.android.material.snackbar.Snackbar;
import e.p.t;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class n implements t {
    public final /* synthetic */ p0 a;

    public /* synthetic */ n(p0 p0Var) {
        this.a = p0Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        p0 p0Var = this.a;
        Void r3 = (Void) obj;
        Snackbar.j(p0Var.q0(), p0Var.A(R.string.generic_error_message), 0).l();
    }
}
