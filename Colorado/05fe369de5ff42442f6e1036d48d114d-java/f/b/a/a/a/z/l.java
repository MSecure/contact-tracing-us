package f.b.a.a.a.z;

import android.widget.FrameLayout;
import com.google.android.material.snackbar.Snackbar;
import e.b.a.m;
import e.p.t;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class l implements t {
    public final /* synthetic */ p0 a;

    public /* synthetic */ l(p0 p0Var) {
        this.a = p0Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        p0 p0Var = this.a;
        Void r5 = (Void) obj;
        FrameLayout frameLayout = p0Var.a0.a;
        if (frameLayout != null) {
            Snackbar H = m.h.H(frameLayout, R.string.gms_unavailable_error);
            H.k(R.string.learn_more, new k(p0Var, frameLayout));
            H.l();
        }
    }
}
