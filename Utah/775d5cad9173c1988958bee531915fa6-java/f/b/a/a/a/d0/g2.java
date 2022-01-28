package f.b.a.a.a.d0;

import android.util.Pair;
import e.q.t;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class g2 implements t {
    public final /* synthetic */ i6 a;

    public /* synthetic */ g2(i6 i6Var) {
        this.a = i6Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        i6 i6Var = this.a;
        Pair pair = (Pair) obj;
        Objects.requireNonNull(i6Var);
        i6Var.h0.p.setText(i6Var.F(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
    }
}
