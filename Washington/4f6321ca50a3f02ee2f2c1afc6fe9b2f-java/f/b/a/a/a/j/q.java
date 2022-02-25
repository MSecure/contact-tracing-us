package f.b.a.a.a.j;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.p.r;
import gov.wa.doh.exposurenotifications.R;

public final /* synthetic */ class q implements r {
    public final /* synthetic */ e0 a;

    public /* synthetic */ q(e0 e0Var) {
        this.a = e0Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        Void r4 = (Void) obj;
        View view = this.a.F;
        if (view != null) {
            int[] iArr = Snackbar.s;
            Snackbar.j(view, view.getResources().getText(R.string.generic_error_message), 0).k();
        }
    }
}
