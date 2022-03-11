package f.b.a.a.a.r;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.p.b0;
import f.b.a.a.a.i.t;
import gov.md.covid19.exposurenotifications.R;

public class v3 extends i3 {
    public static final /* synthetic */ int c0 = 0;
    public t a0;
    public ExposureNotificationViewModel b0;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_begin, viewGroup, false);
        int i2 = 16908332;
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            i2 = R.id.share_next_button;
            Button button = (Button) inflate.findViewById(R.id.share_next_button);
            if (button != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                this.a0 = new t(linearLayout, imageButton, button);
                return linearLayout;
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
    public void c0() {
        this.D = true;
        this.b0.d();
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.share_begin_title);
        this.b0 = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        ShareDiagnosisViewModel shareDiagnosisViewModel = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        shareDiagnosisViewModel.e().f(B(), new q(this, shareDiagnosisViewModel));
        this.a0.b.setContentDescription(z(R.string.btn_cancel));
        m.h.A0(shareDiagnosisViewModel.e(), new b3(shareDiagnosisViewModel, ShareDiagnosisViewModel.d.BEGIN)).f(B(), new s(this, shareDiagnosisViewModel));
    }
}
