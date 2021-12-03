package f.b.a.a.a.s;

import android.util.Pair;
import e.p.t;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class m0 implements t {
    public final /* synthetic */ v5 a;

    public /* synthetic */ m0(v5 v5Var) {
        this.a = v5Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        v5 v5Var = this.a;
        Pair pair = (Pair) obj;
        Objects.requireNonNull(v5Var);
        v5Var.h0.p.setText(v5Var.B(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
    }
}
