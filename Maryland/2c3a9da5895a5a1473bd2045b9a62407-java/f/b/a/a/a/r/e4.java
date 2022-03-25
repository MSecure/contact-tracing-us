package f.b.a.a.a.r;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.snackbar.Snackbar;
import e.b.a.m;
import e.p.b0;
import f.b.a.a.a.i.x;
import f.b.a.a.a.q.b;
import f.b.a.a.a.y.c0;
import gov.md.covid19.exposurenotifications.R;
import l.b.a.u.c;
import l.b.a.u.k;

public class e4 extends m3 {
    public static final c d0 = c.c(k.MEDIUM);
    public x a0;
    public ShareDiagnosisViewModel b0;
    public b c0;

    public final void A0(String str) {
        View view = this.F;
        if (view != null) {
            Snackbar.j(view, str, 0).k();
        }
    }

    @Override // e.m.a.l
    public void I(int i2, int i3, Intent intent) {
        if (i2 != 2222) {
            return;
        }
        if (i3 == -1) {
            this.b0.l();
            return;
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        shareDiagnosisViewModel.j(new w2(shareDiagnosisViewModel, c0.c.NOT_ATTEMPTED));
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_review, viewGroup, false);
        int i2 = 16908332;
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            i2 = R.id.share_previous_button;
            Button button = (Button) inflate.findViewById(R.id.share_previous_button);
            if (button != null) {
                i2 = R.id.share_progress_bar;
                ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.share_progress_bar);
                if (progressBar != null) {
                    i2 = R.id.share_review_date;
                    TextView textView = (TextView) inflate.findViewById(R.id.share_review_date);
                    if (textView != null) {
                        i2 = R.id.share_review_delete;
                        ImageButton imageButton2 = (ImageButton) inflate.findViewById(R.id.share_review_delete);
                        if (imageButton2 != null) {
                            i2 = R.id.share_review_status;
                            TextView textView2 = (TextView) inflate.findViewById(R.id.share_review_status);
                            if (textView2 != null) {
                                i2 = R.id.share_review_travel;
                                TextView textView3 = (TextView) inflate.findViewById(R.id.share_review_travel);
                                if (textView3 != null) {
                                    i2 = R.id.share_review_travel_subtitle;
                                    TextView textView4 = (TextView) inflate.findViewById(R.id.share_review_travel_subtitle);
                                    if (textView4 != null) {
                                        i2 = R.id.share_share_button;
                                        Button button2 = (Button) inflate.findViewById(R.id.share_share_button);
                                        if (button2 != null) {
                                            LinearLayout linearLayout = (LinearLayout) inflate;
                                            this.a0 = new x(linearLayout, imageButton, button, progressBar, textView, imageButton2, textView2, textView3, textView4, button2);
                                            return linearLayout;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.share_review_title);
        this.b0 = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        this.a0.b.setContentDescription(z(R.string.navigate_up));
        this.a0.b.setOnClickListener(new c1(this));
        this.a0.f2153f.setOnClickListener(new e1(this));
        this.b0.e().f(B(), new d1(this));
        this.b0.f392k.f(B(), new t0(this));
        this.b0.n.f(B(), new h1(this));
        this.b0.o.f(B(), new f1(this));
        this.b0.m.f(B(), new x0(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        m.h.A0(shareDiagnosisViewModel.e(), new z2(shareDiagnosisViewModel, ShareDiagnosisViewModel.d.REVIEW)).f(B(), new w0(this));
        this.b0.f393l.f(B(), new z0(this));
    }

    public final void z0(c0 c0Var) {
        this.b0.y = true;
        f.b.a.d.m.b bVar = new f.b.a.d.m.b(n0());
        bVar.f(R.string.delete_test_result_title);
        bVar.c(R.string.delete_test_result_detail);
        bVar.a.f34k = true;
        bVar.e(R.string.btn_delete, new v0(this, c0Var));
        bVar.d(R.string.btn_cancel, new b1(this));
        g1 g1Var = new g1(this);
        AlertController.b bVar2 = bVar.a;
        bVar2.m = g1Var;
        bVar2.f35l = new y0(this);
        bVar.b();
    }
}
