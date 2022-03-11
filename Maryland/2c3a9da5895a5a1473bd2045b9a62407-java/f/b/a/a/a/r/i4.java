package f.b.a.a.a.r;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.radiobutton.MaterialRadioButton;
import e.b.a.m;
import e.p.b0;
import f.b.a.a.a.i.z;
import gov.md.covid19.exposurenotifications.R;

public class i4 extends o3 {
    public z a0;
    public ShareDiagnosisViewModel b0;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_travel_status, viewGroup, false);
        int i2 = R.id.hasTraveledConfirmed;
        MaterialRadioButton materialRadioButton = (MaterialRadioButton) inflate.findViewById(R.id.hasTraveledConfirmed);
        if (materialRadioButton != null) {
            i2 = R.id.hasTraveledNoAnswer;
            MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) inflate.findViewById(R.id.hasTraveledNoAnswer);
            if (materialRadioButton2 != null) {
                i2 = R.id.hasTraveledNoTravel;
                MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) inflate.findViewById(R.id.hasTraveledNoTravel);
                if (materialRadioButton3 != null) {
                    i2 = R.id.hasTraveledRadioGroup;
                    RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.hasTraveledRadioGroup);
                    if (radioGroup != null) {
                        i2 = 16908332;
                        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                        if (imageButton != null) {
                            i2 = R.id.share_next_button;
                            Button button = (Button) inflate.findViewById(R.id.share_next_button);
                            if (button != null) {
                                i2 = R.id.share_previous_button;
                                Button button2 = (Button) inflate.findViewById(R.id.share_previous_button);
                                if (button2 != null) {
                                    LinearLayout linearLayout = (LinearLayout) inflate;
                                    this.a0 = new z(linearLayout, materialRadioButton, materialRadioButton2, materialRadioButton3, radioGroup, imageButton, button, button2);
                                    return linearLayout;
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
        g().setTitle(R.string.share_travel_title);
        this.b0 = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        this.a0.f2154d.setEnabled(false);
        this.b0.e().f(B(), new k1(this));
        this.a0.b.setOnCheckedChangeListener(new o1(this));
        this.a0.c.setContentDescription(z(R.string.navigate_up));
        this.a0.c.setOnClickListener(new n1(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        ShareDiagnosisViewModel.d dVar = ShareDiagnosisViewModel.d.TRAVEL_STATUS;
        m.h.A0(shareDiagnosisViewModel.e(), new b3(shareDiagnosisViewModel, dVar)).f(B(), new l1(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.b0;
        m.h.A0(shareDiagnosisViewModel2.e(), new z2(shareDiagnosisViewModel2, dVar)).f(B(), new p1(this, view));
    }
}
