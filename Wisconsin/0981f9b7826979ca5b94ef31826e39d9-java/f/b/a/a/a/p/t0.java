package f.b.a.a.a.p;

import android.widget.Button;
import android.widget.ProgressBar;
import e.p.r;
import gov.wi.covid19.exposurenotifications.R;
import l.b.a.u.c;

public final /* synthetic */ class t0 implements r {
    public final /* synthetic */ Button a;
    public final /* synthetic */ ProgressBar b;

    public /* synthetic */ t0(Button button, ProgressBar progressBar) {
        this.a = button;
        this.b = progressBar;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        int i2;
        Button button = this.a;
        ProgressBar progressBar = this.b;
        c cVar = s3.b0;
        if (((Boolean) obj).booleanValue()) {
            i2 = 0;
            button.setEnabled(false);
            button.setText("");
        } else {
            button.setEnabled(true);
            button.setText(R.string.btn_share_positive);
            i2 = 4;
        }
        progressBar.setVisibility(i2);
    }
}
