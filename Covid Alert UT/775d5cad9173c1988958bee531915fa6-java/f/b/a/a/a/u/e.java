package f.b.a.a.a.u;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import e.b.a.m;
import e.q.t;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class e implements t {
    public final /* synthetic */ l a;
    public final /* synthetic */ View b;

    public /* synthetic */ e(l lVar, View view) {
        this.a = lVar;
        this.b = view;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        l lVar = this.a;
        View view = this.b;
        Void r5 = (Void) obj;
        View view2 = lVar.F;
        if (view2 != null) {
            Snackbar J = m.e.J(view2, R.string.gms_unavailable_error);
            J.k(R.string.learn_more, new c(lVar, view));
            J.l();
        }
    }
}
