package f.b.a.a.a.s;

import android.util.Pair;
import e.p.t;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class g2 implements t {
    public final /* synthetic */ j6 a;

    public /* synthetic */ g2(j6 j6Var) {
        this.a = j6Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        j6 j6Var = this.a;
        Pair pair = (Pair) obj;
        Objects.requireNonNull(j6Var);
        j6Var.g0.p.setText(j6Var.B(R.string.share_diagnosis_progress_tracker, pair.first, pair.second));
    }
}
