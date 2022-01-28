package f.b.a.a.a.s;

import android.util.Pair;
import e.p.t;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class f1 implements t {
    public final /* synthetic */ a6 a;

    public /* synthetic */ f1(a6 a6Var) {
        this.a = a6Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        a6 a6Var = this.a;
        Pair pair = (Pair) obj;
        Objects.requireNonNull(a6Var);
        a6Var.g0.f2179l.setText(a6Var.B(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
    }
}
