package f.b.a.a.a.u;

import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.q.f0;
import f.b.a.a.a.g0.n;
import f.b.a.a.a.m0.a;
import f.b.a.a.a.m0.b;
import f.b.a.a.a.s.a0;
import f.b.a.a.a.s.c;
import f.b.a.a.a.s.w;
import f.b.a.a.a.t.m;
import gov.ut.covid19.exposurenotifications.R;

public class r extends o {
    public m c0;

    @Override // f.b.a.a.a.u.l
    public void J0(View view, View view2, ExposureNotificationViewModel.b bVar, boolean z) {
        int i2;
        a aVar;
        String str;
        String str2;
        new w(((ShareDiagnosisViewModel) new f0(this.v).a(ShareDiagnosisViewModel.class)).f(), this.W.f341f).f(this, new c(new i(this, view2)));
        m mVar = this.c0;
        TextView textView = mVar.f2400d;
        TextView textView2 = mVar.c;
        Button button = mVar.b;
        button.setEnabled(true);
        int ordinal = bVar.ordinal();
        if (ordinal != 0) {
            switch (ordinal) {
                case 5:
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    textView2.setText(R.string.storage_low_warning);
                    button.setText(R.string.manage_storage);
                    G0(button);
                    K0(n.c.LOW_STORAGE_WARNING_SHOWN);
                    return;
                case 6:
                    str = E(R.string.learn_more);
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    String E = E(R.string.en_info_main_page_link);
                    f.b.a.a.a.s.d0.a aVar2 = b.a;
                    aVar = new a(E);
                    str2 = F(R.string.en_not_supported_warning, str);
                    textView2.setText(a0.b(aVar, str2, str));
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    break;
                case 7:
                    textView.setText(R.string.switch_app_for_exposure_notifications);
                    Context t0 = t0();
                    f.b.a.a.a.s.d0.a aVar3 = a0.a;
                    textView2.setText(F(R.string.focus_lost_warning, t0.getString(R.string.app_title)));
                    i2 = R.string.switch_app_for_exposure_notifications_action;
                    break;
                case 8:
                    str = E(R.string.device_requirements_link_text);
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    String E2 = E(R.string.device_requirements_link);
                    f.b.a.a.a.s.d0.a aVar4 = b.a;
                    aVar = new a(E2);
                    str2 = F(R.string.hw_not_supported_warning, str);
                    textView2.setText(a0.b(aVar, str2, str));
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    break;
                case 9:
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    textView2.setText(R.string.not_in_allowlist_warning);
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    break;
                case 10:
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    textView2.setText(R.string.user_profile_not_supported_warning);
                    break;
                default:
                    return;
            }
            button.setVisibility(8);
            return;
        }
        textView.setText(R.string.exposure_notifications_are_turned_off);
        textView2.setText(F(R.string.notify_turn_on_exposure_notifications_header, E(R.string.using_en_helps_even_if_vaccinated)));
        i2 = R.string.turn_on_exposure_notifications_action;
        button.setText(i2);
        I0(button, z);
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                        this.c0 = new m(linearLayout, button, textView, textView2, imageButton);
                        return linearLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.c0 = null;
    }
}
