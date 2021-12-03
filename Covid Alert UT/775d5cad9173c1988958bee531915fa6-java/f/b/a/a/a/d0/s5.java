package f.b.a.a.a.d0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.s.a0;
import f.b.a.a.a.s.c;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.s.w;
import f.b.a.a.a.t.b0;
import gov.ut.covid19.exposurenotifications.R;

public class s5 extends d5 {
    public b0 h0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_begin, viewGroup, false);
        int i2 = R.id.button_container;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.button_container);
        if (relativeLayout != null) {
            i2 = 16908332;
            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
            if (imageButton != null) {
                i2 = R.id.share_diagnosis_scroll_view;
                NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                if (nestedScrollView != null) {
                    i2 = R.id.share_next_button;
                    Button button = (Button) inflate.findViewById(R.id.share_next_button);
                    if (button != null) {
                        i2 = R.id.share_test_result_title_text_view;
                        TextView textView = (TextView) inflate.findViewById(R.id.share_test_result_title_text_view);
                        if (textView != null) {
                            LinearLayout linearLayout = (LinearLayout) inflate;
                            this.h0 = new b0(linearLayout, relativeLayout, imageButton, nestedScrollView, button, textView);
                            return linearLayout;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.h0 = null;
    }

    @Override // f.b.a.a.a.d0.q5, e.n.a.m, f.b.a.a.a.w.z0
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.share_begin_title);
        TextView textView = this.h0.f2349f;
        Context t0 = t0();
        a aVar = a0.a;
        textView.setText(F(R.string.share_diagnosis_share_test_result_title, t0.getString(R.string.app_title)));
        b0 b0Var = this.h0;
        P0(b0Var.f2347d, b0Var.b);
        this.b0.f().f(G(), new q(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        new w(m.e.R0(shareDiagnosisViewModel.f(), new t3(shareDiagnosisViewModel, ShareDiagnosisViewModel.b.BEGIN)), this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", Boolean.FALSE)).f(this, new c(new u(this)));
    }
}
