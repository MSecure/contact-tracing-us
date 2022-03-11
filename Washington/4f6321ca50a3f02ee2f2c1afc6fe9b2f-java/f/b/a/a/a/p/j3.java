package f.b.a.a.a.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.b0;
import gov.wa.doh.exposurenotifications.R;

public class j3 extends x2 {
    public static final /* synthetic */ int a0 = 0;
    public ExposureNotificationViewModel Z;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_begin, viewGroup, false);
    }

    @Override // e.m.a.l
    public void c0() {
        this.D = true;
        this.Z.d();
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.share_begin_title);
        this.Z = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        Button button = (Button) view.findViewById(R.id.start_api_button);
        button.setOnClickListener(new t(this));
        this.Z.f331d.f(B(), new x(button));
        this.Z.f335h.f(B(), new u(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        View findViewById = view.findViewById(16908332);
        Button button2 = (Button) view.findViewById(R.id.share_next_button);
        shareDiagnosisViewModel.e().f(B(), new s(this, button2, shareDiagnosisViewModel, findViewById));
        findViewById.setContentDescription(z(R.string.btn_cancel));
        this.Z.f333f.f(B(), new w((ViewFlipper) view.findViewById(R.id.en_enabled_flipper), button2));
    }
}
