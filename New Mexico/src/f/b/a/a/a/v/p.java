package f.b.a.a.a.v;

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
import f.b.a.a.a.h0.n;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.m0;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.u.m;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class p extends n {
    public m c0;

    @Override // f.b.a.a.a.v.l
    public void M0(View view, View view2, ExposureNotificationViewModel.b bVar, boolean z) {
        int i2;
        n.c cVar;
        int i3;
        m mVar = this.c0;
        TextView textView = mVar.f2441d;
        TextView textView2 = mVar.c;
        Button button = mVar.b;
        button.setEnabled(true);
        switch (bVar.ordinal()) {
            case 1:
                P0(view2, false);
                return;
            case 2:
                P0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.ble_off_warning);
                button.setText(R.string.device_settings);
                K0(button);
                cVar = n.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
                N0(cVar);
                return;
            case 3:
                P0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.location_off_warning);
                button.setText(R.string.device_settings);
                K0(button);
                cVar = n.c.LOCATION_PERMISSION_WARNING_SHOWN;
                N0(cVar);
                return;
            case 4:
                P0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.location_ble_off_warning);
                button.setText(R.string.device_settings);
                K0(button);
                N0(n.c.LOCATION_PERMISSION_WARNING_SHOWN);
                cVar = n.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
                N0(cVar);
                return;
            case 5:
                P0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.storage_low_warning);
                button.setText(R.string.manage_storage);
                J0(button);
                cVar = n.c.LOW_STORAGE_WARNING_SHOWN;
                N0(cVar);
                return;
            case 6:
                P0(view2, true);
                textView.setText(R.string.en_turndown_title);
                i3 = R.string.en_turndown_contents;
                textView2.setText(i3);
                button.setVisibility(8);
                return;
            case 7:
                P0(view2, true);
                textView.setText(R.string.switch_app_for_exposure_notifications);
                Context v0 = v0();
                a aVar = m0.a;
                textView2.setText(G(R.string.focus_lost_warning, v0.getString(R.string.app_title)));
                i2 = R.string.switch_app_for_exposure_notifications_action;
                button.setText(i2);
                L0(button, z);
                return;
            case 8:
                String F = F(R.string.device_requirements_link_text);
                P0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                String F2 = F(R.string.device_requirements_link);
                a aVar2 = b.a;
                textView2.setText(m0.b(new f.b.a.a.a.o0.a(F2), G(R.string.hw_not_supported_warning, F), F));
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                button.setVisibility(8);
                return;
            case 9:
                P0(view2, true);
                textView.setText(R.string.en_turndown_for_area_title);
                i3 = R.string.en_turndown_for_area_contents;
                textView2.setText(i3);
                button.setVisibility(8);
                return;
            case 10:
                P0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                i3 = R.string.user_profile_not_supported_warning;
                textView2.setText(i3);
                button.setVisibility(8);
                return;
            default:
                P0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                textView2.setText(G(R.string.notify_turn_on_exposure_notifications_header, F(R.string.using_en_helps_even_if_vaccinated)));
                i2 = R.string.turn_on_exposure_notifications_action;
                button.setText(i2);
                L0(button, z);
                return;
        }
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    this.c0 = new m(linearLayout, button, textView, textView2);
                    return linearLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.c0 = null;
    }
}
