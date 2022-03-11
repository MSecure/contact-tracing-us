package f.b.a.a.a.p;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.p.r;
import gov.wa.doh.exposurenotifications.R;

public final /* synthetic */ class u implements r {
    public final /* synthetic */ j3 a;

    public /* synthetic */ u(j3 j3Var) {
        this.a = j3Var;
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
