package f.b.a.a.a.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.b0;
import f.b.a.d.m.b;
import gov.ca.covid19.exposurenotifications.R;
import l.b.a.u.c;
import l.b.a.u.k;

public class y3 extends e3 {
    public final c Z = c.c(k.MEDIUM);
    public ShareDiagnosisViewModel a0;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_view, viewGroup, false);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.a0 = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        TextView textView = (TextView) view.findViewById(R.id.share_review_status);
        TextView textView2 = (TextView) view.findViewById(R.id.share_review_travel_subtitle);
        TextView textView3 = (TextView) view.findViewById(R.id.share_review_travel);
        TextView textView4 = (TextView) view.findViewById(R.id.share_review_date);
        Button button = (Button) view.findViewById(R.id.positive_diagnosis_delete_button);
        View findViewById = view.findViewById(16908332);
        g().setTitle(R.string.status_shared_detail_title);
        this.a0.e().f(B(), new n1(this, textView, textView2, textView3, textView4, button));
        this.a0.f377j.f(B(), new r1(this));
        findViewById.setContentDescription(z(R.string.navigate_up));
        findViewById.setOnClickListener(new s1(this));
    }

    public final void z0(f.b.a.a.a.w.b0 b0Var) {
        this.a0.w = true;
        b bVar = new b(n0());
        bVar.f(R.string.delete_test_result_title);
        bVar.c(R.string.delete_test_result_detail);
        bVar.e(R.string.btn_delete, new p1(this, b0Var));
        bVar.d(R.string.btn_cancel, new o1(this));
        q1 q1Var = new q1(this);
        AlertController.b bVar2 = bVar.a;
        bVar2.m = q1Var;
        bVar2.f27l = new m1(this);
        bVar.b();
    }
}
