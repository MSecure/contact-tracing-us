package f.b.a.a.a.d0;

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
import f.b.a.a.a.s.w;
import f.b.a.a.a.t.f;
import f.b.a.a.a.t.h0;
import f.b.b.a.l;
import gov.ut.covid19.exposurenotifications.R;

public class e6 extends q5 {
    public h0 f0;

    @Override // f.b.a.a.a.w.z0, f.b.a.a.a.d0.q5
    public boolean F0() {
        I0();
        return true;
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                            this.f0 = new h0(linearLayout, new f((MaterialCardView) findViewById, button, button2, textView, button3));
                            return linearLayout;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.pre_auth_layout)));
    }

    public final void T0(l<ShareDiagnosisViewModel.b> lVar) {
        if (lVar.b()) {
            this.b0.k(lVar.a());
        } else {
            I0();
        }
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.f0 = null;
    }

    @Override // f.b.a.a.a.w.z0, f.b.a.a.a.d0.q5, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.share_confirm_title);
        this.f0.b.f2375d.setText(F(R.string.notify_others_if_result_updated_content, E(R.string.health_authority_name)));
        this.f0.b.b.setOnClickListener(new r1(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.PRE_AUTH;
        LiveData R0 = m.e.R0(shareDiagnosisViewModel.f(), new t3(shareDiagnosisViewModel, bVar));
        u3 u3Var = u3.a;
        m.e.R0(R0, u3Var).f(G(), new s1(this));
        this.f0.b.f2376e.setOnClickListener(new n1(this));
        c r0 = r0(new d(), new m1(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.b0;
        new w(m.e.R0(m.e.R0(shareDiagnosisViewModel2.f(), new t3(shareDiagnosisViewModel2, bVar)), u3Var), this.b0.v).n(G(), new p1(this));
        this.b0.s.f(G(), new o1(this, r0));
    }
}
