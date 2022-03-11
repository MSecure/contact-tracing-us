package f.b.a.a.a.j;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.p.r;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class e implements r {
    public final /* synthetic */ j a;

    public /* synthetic */ e(j jVar) {
        this.a = jVar;
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
