package f.b.a.a.a.s;

import android.view.View;
import android.widget.TextView;
import e.p.t;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.j.l0;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class o2 implements t {
    public final /* synthetic */ m6 a;

    public /* synthetic */ o2(m6 m6Var) {
        this.a = m6Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ec  */
    @Override // e.p.t
    public final void a(Object obj) {
        int ordinal;
        int i2;
        int i3;
        m6 m6Var = this.a;
        h0 h0Var = (h0) obj;
        Objects.requireNonNull(m6Var);
        if (h0Var != null) {
            m6Var.h0.c.setOnClickListener(new q2(m6Var, h0Var));
            if (m6Var.a0.J) {
                m6Var.L0(h0Var);
            }
            String string = h0Var.k() != null ? m6Var.p0().getString(R.string.share_review_onset_date, m6Var.g0.g(m6Var.w().getConfiguration().locale).b(h0Var.k())) : "";
            boolean h2 = m6Var.a0.h();
            l0 l0Var = m6Var.h0;
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
