package f.b.a.a.a.d0;

import android.view.View;
import android.widget.TextView;
import e.q.t;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.t.l0;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class o2 implements t {
    public final /* synthetic */ l6 a;

    public /* synthetic */ o2(l6 l6Var) {
        this.a = l6Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ec  */
    @Override // e.q.t
    public final void a(Object obj) {
        int ordinal;
        int i2;
        int i3;
        l6 l6Var = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(l6Var);
        if (h0Var != null) {
            l6Var.i0.c.setOnClickListener(new q2(l6Var, h0Var));
            if (l6Var.b0.J) {
                l6Var.R0(h0Var);
            }
            String string = h0Var.k() != null ? l6Var.t0().getString(R.string.share_review_onset_date, l6Var.h0.g(l6Var.A().getConfiguration().locale).b(h0Var.k())) : "";
            boolean h2 = l6Var.b0.h();
            l0 l0Var = l6Var.i0;
            a aVar = a5.a;
            View a2 = l0Var.a();
            TextView textView = (TextView) a2.findViewById(R.id.share_review_status);
            TextView textView2 = (TextView) a2.findViewById(R.id.share_review_date);
            TextView textView3 = (TextView) a2.findViewById(R.id.share_review_travel);
            TextView textView4 = (TextView) a2.findViewById(R.id.share_review_travel_subtitle);
            if (h0Var.n() != null) {
                int ordinal2 = h0Var.n().ordinal();
                if (ordinal2 == 1) {
                    i3 = R.string.share_review_status_likely;
                } else if (ordinal2 == 2) {
                    i3 = R.string.share_review_status_negative;
                }
                textView.setText(i3);
                if (!h2) {
                    textView3.setVisibility(0);
                    textView4.setVisibility(0);
                    if (h0Var.o() != null) {
                        int ordinal3 = h0Var.o().ordinal();
                        if (ordinal3 == 1) {
                            i2 = R.string.share_review_travel_confirmed;
                        } else if (ordinal3 == 2) {
                            i2 = R.string.share_review_travel_no_travel;
                        }
                        textView3.setText(i2);
                    }
                    textView3.setText(R.string.share_review_travel_no_answer);
                }
                ordinal = h0Var.d().ordinal();
                if (ordinal == 1) {
                    textView2.setText(ordinal != 2 ? R.string.share_review_onset_no_answer : R.string.share_review_onset_no_symptoms);
                    return;
                } else {
                    textView2.setText(string);
                    return;
                }
            }
            textView.setText(R.string.share_review_status_confirmed);
            if (!h2) {
            }
            ordinal = h0Var.d().ordinal();
            if (ordinal == 1) {
            }
        }
    }
}
