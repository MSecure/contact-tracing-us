package f.b.a.a.a.p;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.snackbar.Snackbar;
import f.b.a.a.a.o.b;
import f.b.a.a.a.w.b0;
import gov.ca.covid19.exposurenotifications.R;
import l.b.a.u.c;
import l.b.a.u.k;

public class s3 extends b3 {
    public static final c b0 = c.c(k.MEDIUM);
    public ShareDiagnosisViewModel Z;
    public b a0;

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
            this.Z.l();
            return;
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.Z;
        shareDiagnosisViewModel.j(new g2(shareDiagnosisViewModel, b0.c.NOT_ATTEMPTED));
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_review, viewGroup, false);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.share_review_title);
        this.Z = (ShareDiagnosisViewModel) new e.p.b0(g()).a(ShareDiagnosisViewModel.class);
        TextView textView = (TextView) view.findViewById(R.id.share_review_status);
        TextView textView2 = (TextView) view.findViewById(R.id.share_review_travel_subtitle);
        TextView textView3 = (TextView) view.findViewById(R.id.share_review_travel);
        TextView textView4 = (TextView) view.findViewById(R.id.share_review_date);
        Button button = (Button) view.findViewById(R.id.share_share_button);
        Button button2 = (Button) view.findViewById(R.id.share_previous_button);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.share_progress_bar);
        View findViewById = view.findViewById(16908332);
        this.Z.e().f(B(), new v0(this, view.findViewById(R.id.share_review_delete), button2, textView, textView2, textView3, textView4));
        button.setOnClickListener(new z0(this));
        this.Z.f376i.f(B(), new t0(button, progressBar));
        this.Z.f379l.f(B(), new f1(this));
        this.Z.m.f(B(), new e1(this));
        this.Z.f377j.f(B(), new a1(this));
        this.Z.f378k.f(B(), new y0(this));
        findViewById.setContentDescription(z(R.string.navigate_up));
        findViewById.setOnClickListener(new u0(this));
    }

    public final void z0(b0 b0Var) {
        this.Z.w = true;
        f.b.a.d.m.b bVar = new f.b.a.d.m.b(n0());
        bVar.f(R.string.delete_test_result_title);
        bVar.c(R.string.delete_test_result_detail);
        bVar.a.f26k = true;
        bVar.e(R.string.btn_delete, new b1(this, b0Var));
        bVar.d(R.string.btn_cancel, new x0(this));
        bVar.a.f27l = new c1(this);
        bVar.b();
    }
}
