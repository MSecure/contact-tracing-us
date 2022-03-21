package f.b.a.a.a.q;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.p.r;
import gov.wi.covid19.exposurenotifications.R;

public final /* synthetic */ class a implements r {
    public final /* synthetic */ y a;

    public /* synthetic */ a(y yVar) {
        this.a = yVar;
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
