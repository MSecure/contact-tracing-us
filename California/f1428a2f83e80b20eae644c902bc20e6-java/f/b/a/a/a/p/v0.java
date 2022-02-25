package f.b.a.a.a.p;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import e.p.r;
import f.b.a.a.a.w.b0;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class v0 implements r {
    public final /* synthetic */ s3 a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Button c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f2192d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f2193e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ TextView f2194f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextView f2195g;

    public /* synthetic */ v0(s3 s3Var, View view, Button button, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.a = s3Var;
        this.b = view;
        this.c = button;
        this.f2192d = textView;
        this.f2193e = textView2;
        this.f2194f = textView3;
        this.f2195g = textView4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
    @Override // e.p.r
    public final void a(Object obj) {
        int ordinal;
        int i2;
        int i3;
        s3 s3Var = this.a;
        View view = this.b;
        Button button = this.c;
        TextView textView = this.f2192d;
        TextView textView2 = this.f2193e;
        TextView textView3 = this.f2194f;
        TextView textView4 = this.f2195g;
        b0 b0Var = (b0) obj;
        Objects.requireNonNull(s3Var);
        if (b0Var != null) {
            view.setOnClickListener(new d1(s3Var, b0Var));
            if (s3Var.Z.w) {
                s3Var.z0(b0Var);
            }
            button.setOnClickListener(new w0(s3Var, b0Var));
            if (b0Var.l() != null) {
                int ordinal2 = b0Var.l().ordinal();
                if (ordinal2 == 1) {
                    i3 = R.string.share_review_status_likely;
                } else if (ordinal2 == 2) {
                    i3 = R.string.share_review_status_negative;
                }
                textView.setText(i3);
                if (!n3.d(s3Var.W)) {
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
                    return;
                } else {
                    textView4.setText(s3Var.n0().getString(R.string.share_review_onset_date, s3.b0.g(s3Var.v().getConfiguration().locale).b(b0Var.i())));
                    return;
                }
            }
            textView.setText(R.string.share_review_status_confirmed);
            if (!n3.d(s3Var.W)) {
            }
            ordinal = b0Var.d().ordinal();
            if (ordinal == 1) {
            }
        }
    }
}
