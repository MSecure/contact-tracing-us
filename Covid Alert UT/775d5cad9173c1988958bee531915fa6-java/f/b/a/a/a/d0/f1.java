package f.b.a.a.a.d0;

import android.util.Pair;
import e.q.t;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class f1 implements t {
    public final /* synthetic */ z5 a;

    public /* synthetic */ f1(z5 z5Var) {
        this.a = z5Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        z5 z5Var = this.a;
        Pair pair = (Pair) obj;
        Objects.requireNonNull(z5Var);
        z5Var.h0.f2374l.setText(z5Var.F(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
    }
}
