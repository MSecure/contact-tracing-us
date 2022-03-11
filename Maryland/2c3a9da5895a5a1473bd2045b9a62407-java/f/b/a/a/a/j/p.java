package f.b.a.a.a.j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.b0;
import f.b.a.a.a.i.k;
import gov.md.covid19.exposurenotifications.R;

public class p extends m {
    public k c0;

    @Override // f.b.a.a.a.j.j
    public void A0(View view, View view2, ExposureNotificationViewModel.a aVar, boolean z) {
        ShareDiagnosisViewModel shareDiagnosisViewModel = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        shareDiagnosisViewModel.e().f(B(), new f(this, shareDiagnosisViewModel));
        this.c0.f2105e.setContentDescription(z(R.string.btn_cancel));
        k kVar = this.c0;
        TextView textView = kVar.f2104d;
        TextView textView2 = kVar.c;
        Button button = kVar.b;
        button.setEnabled(true);
        if (aVar.ordinal() != 0) {
            D0(view2, false);
            return;
        }
        D0(view2, true);
        textView.setText(R.string.exposure_notifications_are_turned_off);
        textView2.setText(R.string.notify_turn_on_exposure_notifications_header);
        button.setText(R.string.turn_on_exposure_notifications_action);
        button.setVisibility(0);
        button.setEnabled(!z);
        button.setOnClickListener(new c(this));
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edge_cases_verification, viewGroup, false);
        int i2 = R.id.edgecase_main_button;
        Button button = (Button) inflate.findViewById(R.id.edgecase_main_button);
        if (button != null) {
            i2 = R.id.edgecase_main_text;
            TextView textView = (TextView) inflate.findViewById(R.id.edgecase_main_text);
            if (textView != null) {
                i2 = R.id.edgecase_main_title;
                TextView textView2 = (TextView) inflate.findViewById(R.id.edgecase_main_title);
                if (textView2 != null) {
                    i2 = 16908332;
                    ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                    if (imageButton != null) {
                        LinearLayout linearLayout = (LinearLayout) inflate;
                        this.c0 = new k(linearLayout, button, textView, textView2, imageButton);
                        return linearLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.c0 = null;
    }
}
