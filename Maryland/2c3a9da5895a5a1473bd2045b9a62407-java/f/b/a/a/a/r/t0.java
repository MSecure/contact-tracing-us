package f.b.a.a.a.r;

import android.widget.ProgressBar;
import e.p.r;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class t0 implements r {
    public final /* synthetic */ e4 a;

    public /* synthetic */ t0(e4 e4Var) {
        this.a = e4Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ProgressBar progressBar;
        int i2;
        e4 e4Var = this.a;
        Objects.requireNonNull(e4Var);
        if (((Boolean) obj).booleanValue()) {
            i2 = 0;
            e4Var.a0.f2153f.setEnabled(false);
            e4Var.a0.f2153f.setText("");
            progressBar = e4Var.a0.f2151d;
        } else {
            e4Var.a0.f2153f.setEnabled(true);
            e4Var.a0.f2153f.setText(R.string.btn_share_positive);
            progressBar = e4Var.a0.f2151d;
            i2 = 4;
        }
        progressBar.setVisibility(i2);
    }
}
