package f.b.a.a.a.k;

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
import e.p.f0;
import f.b.a.a.a.c0.a;
import f.b.a.a.a.c0.b;
import f.b.a.a.a.i.b0;
import f.b.a.a.a.i.c;
import f.b.a.a.a.i.x;
import f.b.a.a.a.j.m;
import f.b.a.a.a.v.n;
import gov.co.cdphe.exposurenotifications.R;

public class r extends o {
    public m b0;

    @Override // f.b.a.a.a.k.l
    public void E0(View view, View view2, ExposureNotificationViewModel.b bVar, boolean z) {
        int i2;
        a aVar;
        String str;
        String str2;
        new x(((ShareDiagnosisViewModel) new f0(this.v).a(ShareDiagnosisViewModel.class)).f(), this.W.f336f).f(this, new c(new i(this, view2)));
        m mVar = this.b0;
        TextView textView = mVar.f2205d;
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
                    B0(button);
                    F0(n.c.LOW_STORAGE_WARNING_SHOWN);
                    return;
                case 6:
                    str = A(R.string.learn_more);
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    String A = A(R.string.en_info_main_page_link);
                    f.b.a.a.a.i.e0.a aVar2 = b.a;
                    aVar = new a(A);
                    str2 = B(R.string.en_not_supported_warning, str);
                    textView2.setText(b0.b(aVar, str2, str));
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    break;
                case 7:
                    textView.setText(R.string.switch_app_for_exposure_notifications);
                    Context p0 = p0();
                    f.b.a.a.a.i.e0.a aVar3 = b0.a;
                    textView2.setText(B(R.string.focus_lost_warning, p0.getString(R.string.app_title)));
                    i2 = R.string.switch_app_for_exposure_notifications_action;
                    break;
                case 8:
                    str = A(R.string.device_requirements_link_text);
                    textView.setText(R.string.exposure_notifications_are_turned_off);
                    String A2 = A(R.string.device_requirements_link);
                    f.b.a.a.a.i.e0.a aVar4 = b.a;
                    aVar = new a(A2);
                    str2 = B(R.string.hw_not_supported_warning, str);
                    textView2.setText(b0.b(aVar, str2, str));
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
        textView2.setText(B(R.string.notify_turn_on_exposure_notifications_header, A(R.string.using_en_helps_even_if_vaccinated)));
        i2 = R.string.turn_on_exposure_notifications_action;
        button.setText(i2);
        D0(button, z);
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                        this.b0 = new m(linearLayout, button, textView, textView2, imageButton);
                        return linearLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.b0 = null;
    }
}
