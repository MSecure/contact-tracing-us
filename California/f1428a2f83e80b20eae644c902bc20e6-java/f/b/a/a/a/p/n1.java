package f.b.a.a.a.p;

import android.widget.Button;
import android.widget.TextView;
import e.p.r;
import f.b.a.a.a.w.b0;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class n1 implements r {
    public final /* synthetic */ y3 a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ TextView c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f2183d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f2184e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Button f2185f;

    public /* synthetic */ n1(y3 y3Var, TextView textView, TextView textView2, TextView textView3, TextView textView4, Button button) {
        this.a = y3Var;
        this.b = textView;
        this.c = textView2;
        this.f2183d = textView3;
        this.f2184e = textView4;
        this.f2185f = button;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // e.p.r
    public final void a(Object obj) {
        int ordinal;
        int i2;
        int i3;
        y3 y3Var = this.a;
        TextView textView = this.b;
        TextView textView2 = this.c;
        TextView textView3 = this.f2183d;
        TextView textView4 = this.f2184e;
        Button button = this.f2185f;
        b0 b0Var = (b0) obj;
        Objects.requireNonNull(y3Var);
        if (b0Var != null) {
            if (b0Var.l() != null) {
                int ordinal2 = b0Var.l().ordinal();
                if (ordinal2 == 1) {
                    i3 = R.string.share_review_status_likely;
                } else if (ordinal2 == 2) {
                    i3 = R.string.share_review_status_negative;
                }
                textView.setText(i3);
                if (!n3.d(y3Var.W)) {
                    textView2.setVisibility(0);
                    textView3.setVisibility(0);
                    if (b0Var.m() != null) {
                        int ordinal3 = b0Var.m().ordinal();
                        if (ordinal3 == 1) {
                            i2 = R.string.share_review_travel_confirmed;
                        } else if (ordinal3 == 2) {
                            i2 = R.string.share_review_travel_no_travel;
                        }
                        textView3.setText(i2);
                    }
                    textView3.setText(R.string.share_review_travel_no_answer);
                }
                ordinal = b0Var.d().ordinal();
                if (ordinal == 1) {
                    textView4.setText(ordinal != 2 ? R.string.share_review_onset_no_answer : R.string.share_review_onset_no_symptoms);
                } else {
                    textView4.setText(y3Var.n0().getString(R.string.share_review_onset_date, y3Var.Z.g(y3Var.v().getConfiguration().locale).b(b0Var.i())));
                }
                button.setOnClickListener(new t1(y3Var, b0Var));
                if (!y3Var.a0.w) {
                    y3Var.z0(b0Var);
                    return;
                }
                return;
            }
            textView.setText(R.string.share_review_status_confirmed);
            if (!n3.d(y3Var.W)) {
            }
            ordinal = b0Var.d().ordinal();
            if (ordinal == 1) {
            }
            button.setOnClickListener(new t1(y3Var, b0Var));
            if (!y3Var.a0.w) {
            }
        }
    }
}
