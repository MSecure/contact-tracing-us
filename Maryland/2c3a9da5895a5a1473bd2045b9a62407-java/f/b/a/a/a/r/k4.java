package f.b.a.a.a.r;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.b0;
import f.b.a.a.a.i.a0;
import f.b.a.a.a.y.c0;
import f.b.a.d.m.b;
import gov.md.covid19.exposurenotifications.R;
import l.b.a.u.c;
import l.b.a.u.k;

public class k4 extends p3 {
    public final c a0 = c.c(k.MEDIUM);
    public a0 b0;
    public ShareDiagnosisViewModel c0;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_view, viewGroup, false);
        int i2 = R.id.diagnosis_delete_button;
        Button button = (Button) inflate.findViewById(R.id.diagnosis_delete_button);
        if (button != null) {
            i2 = 16908332;
            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
            if (imageButton != null) {
                i2 = R.id.share_review_date;
                TextView textView = (TextView) inflate.findViewById(R.id.share_review_date);
                if (textView != null) {
                    i2 = R.id.share_review_status;
                    TextView textView2 = (TextView) inflate.findViewById(R.id.share_review_status);
                    if (textView2 != null) {
                        i2 = R.id.share_review_travel;
                        TextView textView3 = (TextView) inflate.findViewById(R.id.share_review_travel);
                        if (textView3 != null) {
                            i2 = R.id.share_review_travel_subtitle;
                            TextView textView4 = (TextView) inflate.findViewById(R.id.share_review_travel_subtitle);
                            if (textView4 != null) {
                                LinearLayout linearLayout = (LinearLayout) inflate;
                                this.b0 = new a0(linearLayout, button, imageButton, textView, textView2, textView3, textView4);
                                return linearLayout;
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
        this.b0 = null;
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.status_shared_detail_title);
        this.c0 = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        this.b0.c.setContentDescription(z(R.string.navigate_up));
        this.b0.c.setOnClickListener(new x1(this));
        this.c0.e().f(B(), new r1(this));
        this.c0.f393l.f(B(), new u1(this));
    }

    public final void z0(c0 c0Var) {
        this.c0.y = true;
        b bVar = new b(n0());
        bVar.f(R.string.delete_test_result_title);
        bVar.c(R.string.delete_test_result_detail);
        bVar.a.f34k = true;
        bVar.e(R.string.btn_delete, new t1(this, c0Var));
        bVar.d(R.string.btn_cancel, new s1(this));
        v1 v1Var = new v1(this);
        AlertController.b bVar2 = bVar.a;
        bVar2.m = v1Var;
        bVar2.f35l = new q1(this);
        bVar.b();
    }
}
