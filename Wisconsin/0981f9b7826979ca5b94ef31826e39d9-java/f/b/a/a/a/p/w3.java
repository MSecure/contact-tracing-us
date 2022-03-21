package f.b.a.a.a.p;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.b0;
import gov.wi.covid19.exposurenotifications.R;

public class w3 extends d3 {
    public ShareDiagnosisViewModel Z;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_travel_status, viewGroup, false);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.share_travel_title);
        this.Z = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        Button button = (Button) view.findViewById(R.id.share_next_button);
        View findViewById = view.findViewById(16908332);
        button.setEnabled(false);
        this.Z.e().f(B(), new k1(this, button, (Button) view.findViewById(R.id.share_previous_button), view));
        ((RadioGroup) view.findViewById(R.id.hasTraveledRadioGroup)).setOnCheckedChangeListener(new h1(this));
        findViewById.setContentDescription(z(R.string.navigate_up));
        findViewById.setOnClickListener(new l1(this));
    }
}
