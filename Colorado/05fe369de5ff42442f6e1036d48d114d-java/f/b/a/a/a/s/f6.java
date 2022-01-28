package f.b.a.a.a.s;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.card.MaterialCardView;
import e.a.e.c;
import e.a.e.f.d;
import e.b.a.m;
import f.b.a.a.a.i.x;
import f.b.a.a.a.j.f;
import f.b.a.a.a.j.h0;
import f.b.b.a.l;
import gov.co.cdphe.exposurenotifications.R;

public class f6 extends r5 {
    public h0 e0;

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5
    public boolean A0() {
        C0();
        return true;
    }

    public final void N0(l<ShareDiagnosisViewModel.b> lVar) {
        if (lVar.b()) {
            this.a0.k(lVar.a());
        } else {
            C0();
        }
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_pre_auth, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.pre_auth_layout);
        if (findViewById != null) {
            int i2 = R.id.learn_more_button;
            Button button = (Button) findViewById.findViewById(R.id.learn_more_button);
            if (button != null) {
                i2 = R.id.no_thanks_button;
                Button button2 = (Button) findViewById.findViewById(R.id.no_thanks_button);
                if (button2 != null) {
                    i2 = R.id.pre_auth_card_content;
                    TextView textView = (TextView) findViewById.findViewById(R.id.pre_auth_card_content);
                    if (textView != null) {
                        i2 = R.id.yes_button;
                        Button button3 = (Button) findViewById.findViewById(R.id.yes_button);
                        if (button3 != null) {
                            LinearLayout linearLayout = (LinearLayout) inflate;
                            this.e0 = new h0(linearLayout, new f((MaterialCardView) findViewById, button, button2, textView, button3));
                            return linearLayout;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.pre_auth_layout)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.e0 = null;
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m, f.b.a.a.a.s.r5
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.share_confirm_title);
        this.e0.b.f2180d.setText(B(R.string.notify_others_if_result_updated_content, A(R.string.health_authority_name)));
        this.e0.b.b.setOnClickListener(new r1(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a0;
        ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.PRE_AUTH;
        LiveData G0 = m.h.G0(shareDiagnosisViewModel.f(), new t3(shareDiagnosisViewModel, bVar));
        u3 u3Var = u3.a;
        m.h.G0(G0, u3Var).f(C(), new s1(this));
        this.e0.b.f2181e.setOnClickListener(new n1(this));
        c n0 = n0(new d(), new m1(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.a0;
        new x(m.h.G0(m.h.G0(shareDiagnosisViewModel2.f(), new t3(shareDiagnosisViewModel2, bVar)), u3Var), this.a0.v).n(C(), new p1(this));
        this.a0.s.f(C(), new o1(this, n0));
    }
}
