package f.b.a.a.a.u;

import android.content.Context;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.g0.n;
import f.b.a.a.a.m0.a;
import f.b.a.a.a.m0.b;
import f.b.a.a.a.s.a0;
import f.b.a.a.a.t.l;
import gov.ut.covid19.exposurenotifications.R;

public class p extends n {
    public l c0;

    @Override // f.b.a.a.a.u.l
    public void J0(View view, View view2, ExposureNotificationViewModel.b bVar, boolean z) {
        int i2;
        n.c cVar;
        a aVar;
        String str;
        String str2;
        int i3;
        l lVar = this.c0;
        TextView textView = lVar.f2397d;
        TextView textView2 = lVar.c;
        Button button = lVar.b;
        button.setEnabled(true);
        switch (bVar.ordinal()) {
            case 1:
                M0(view2, false);
                return;
            case 2:
                M0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.ble_off_warning);
                button.setText(R.string.device_settings);
                H0(button);
                cVar = n.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
                K0(cVar);
                return;
            case 3:
                M0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.location_off_warning);
                button.setText(R.string.device_settings);
                H0(button);
                cVar = n.c.LOCATION_PERMISSION_WARNING_SHOWN;
                K0(cVar);
                return;
            case 4:
                M0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.location_ble_off_warning);
                button.setText(R.string.device_settings);
                H0(button);
                K0(n.c.LOCATION_PERMISSION_WARNING_SHOWN);
                cVar = n.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
                K0(cVar);
                return;
            case 5:
                M0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.storage_low_warning);
                button.setText(R.string.manage_storage);
                G0(button);
                cVar = n.c.LOW_STORAGE_WARNING_SHOWN;
                K0(cVar);
                return;
            case 6:
                str = E(R.string.learn_more);
                M0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                String E = E(R.string.en_info_main_page_link);
                f.b.a.a.a.s.d0.a aVar2 = b.a;
                aVar = new a(E);
                str2 = F(R.string.en_not_supported_warning, str);
                textView2.setText(a0.b(aVar, str2, str));
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                button.setVisibility(8);
                return;
            case 7:
                M0(view2, true);
                textView.setText(R.string.switch_app_for_exposure_notifications);
                Context t0 = t0();
                f.b.a.a.a.s.d0.a aVar3 = a0.a;
                textView2.setText(F(R.string.focus_lost_warning, t0.getString(R.string.app_title)));
                i2 = R.string.switch_app_for_exposure_notifications_action;
                button.setText(i2);
                I0(button, z);
                return;
            case 8:
                str = E(R.string.device_requirements_link_text);
                M0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                String E2 = E(R.string.device_requirements_link);
                f.b.a.a.a.s.d0.a aVar4 = b.a;
                aVar = new a(E2);
                str2 = F(R.string.hw_not_supported_warning, str);
                textView2.setText(a0.b(aVar, str2, str));
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                button.setVisibility(8);
                return;
            case 9:
                M0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                i3 = R.string.not_in_allowlist_warning;
                textView2.setText(i3);
                button.setVisibility(8);
                return;
            case 10:
                M0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                i3 = R.string.user_profile_not_supported_warning;
                textView2.setText(i3);
                button.setVisibility(8);
                return;
            default:
                M0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                textView2.setText(F(R.string.notify_turn_on_exposure_notifications_header, E(R.string.using_en_helps_even_if_vaccinated)));
                i2 = R.string.turn_on_exposure_notifications_action;
                button.setText(i2);
                I0(button, z);
                return;
        }
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edge_cases_home_single_page, viewGroup, false);
        int i2 = R.id.edge_case_action_button;
        Button button = (Button) inflate.findViewById(R.id.edge_case_action_button);
        if (button != null) {
            i2 = R.id.edge_case_content;
            TextView textView = (TextView) inflate.findViewById(R.id.edge_case_content);
            if (textView != null) {
                i2 = R.id.edge_case_title;
                TextView textView2 = (TextView) inflate.findViewById(R.id.edge_case_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) inflate;
                    this.c0 = new l(linearLayout, button, textView, textView2);
                    return linearLayout;
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
