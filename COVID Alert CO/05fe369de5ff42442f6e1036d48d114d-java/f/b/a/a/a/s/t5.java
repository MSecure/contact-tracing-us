package f.b.a.a.a.s;

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
import f.b.a.a.a.i.c;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.i.x;
import f.b.a.a.a.j.b0;
import gov.co.cdphe.exposurenotifications.R;

public class t5 extends d5 {
    public b0 g0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                            this.g0 = new b0(linearLayout, relativeLayout, imageButton, nestedScrollView, button, textView);
                            return linearLayout;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.g0 = null;
    }

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.share_begin_title);
        TextView textView = this.g0.f2154f;
        Context p0 = p0();
        a aVar = f.b.a.a.a.i.b0.a;
        textView.setText(B(R.string.share_diagnosis_share_test_result_title, p0.getString(R.string.app_title)));
        b0 b0Var = this.g0;
        J0(b0Var.f2152d, b0Var.b);
        this.a0.f().f(C(), new q(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a0;
        new x(m.h.G0(shareDiagnosisViewModel.f(), new t3(shareDiagnosisViewModel, ShareDiagnosisViewModel.b.BEGIN)), this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", Boolean.FALSE)).f(this, new c(new u(this)));
    }
}
