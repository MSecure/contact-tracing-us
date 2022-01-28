package f.b.a.a.a.d0;

import android.util.Pair;
import e.q.t;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class m0 implements t {
    public final /* synthetic */ u5 a;

    public /* synthetic */ m0(u5 u5Var) {
        this.a = u5Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        u5 u5Var = this.a;
        Pair pair = (Pair) obj;
        Objects.requireNonNull(u5Var);
        u5Var.i0.p.setText(u5Var.F(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
    }
}
