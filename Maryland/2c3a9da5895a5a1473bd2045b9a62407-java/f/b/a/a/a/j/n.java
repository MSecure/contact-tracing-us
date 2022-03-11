package f.b.a.a.a.j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.i.j;
import f.b.a.a.a.u.s;
import gov.md.covid19.exposurenotifications.R;

public class n extends l {
    public j c0;

    @Override // f.b.a.a.a.j.j
    public void A0(View view, View view2, ExposureNotificationViewModel.a aVar, boolean z) {
        s.c cVar;
        j jVar = this.c0;
        TextView textView = jVar.f2103d;
        TextView textView2 = jVar.c;
        Button button = jVar.b;
        button.setEnabled(true);
        int ordinal = aVar.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    D0(view2, true);
                    textView.setText(R.string.exposure_notifications_are_inactive);
                    textView2.setText(R.string.location_off_warning);
                    button.setText(R.string.device_settings);
                    z0(button);
                    cVar = s.c.LOCATION_PERMISSION_WARNING_SHOWN;
                } else if (ordinal != 4) {
                    D0(view2, true);
                    if (ordinal != 5) {
                        textView.setText(R.string.exposure_notifications_are_turned_off);
                        textView2.setText(R.string.notify_turn_on_exposure_notifications_header);
                        button.setText(R.string.turn_on_exposure_notifications_action);
                        button.setVisibility(0);
                        button.setEnabled(!z);
                        button.setOnClickListener(new c(this));
                        return;
                    }
                    textView.setText(R.string.exposure_notifications_are_inactive);
                    textView2.setText(R.string.storage_low_warning);
                    button.setText(R.string.manage_storage);
                    y0(button);
                    cVar = s.c.LOW_STORAGE_WARNING_SHOWN;
                } else {
                    D0(view2, true);
                    textView.setText(R.string.exposure_notifications_are_inactive);
                    textView2.setText(R.string.location_ble_off_warning);
                    button.setText(R.string.device_settings);
                    z0(button);
                    B0(s.c.LOCATION_PERMISSION_WARNING_SHOWN);
                }
                B0(cVar);
                return;
            }
            D0(view2, true);
            textView.setText(R.string.exposure_notifications_are_inactive);
            textView2.setText(R.string.ble_off_warning);
            button.setText(R.string.device_settings);
            z0(button);
            cVar = s.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
            B0(cVar);
            return;
        }
        D0(view2, false);
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edge_cases_main, viewGroup, false);
        int i2 = R.id.edgecase_main_button;
        Button button = (Button) inflate.findViewById(R.id.edgecase_main_button);
        if (button != null) {
            i2 = R.id.edgecase_main_text;
            TextView textView = (TextView) inflate.findViewById(R.id.edgecase_main_text);
            if (textView != null) {
                i2 = R.id.edgecase_main_title;
                TextView textView2 = (TextView) inflate.findViewById(R.id.edgecase_main_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) inflate;
                    this.c0 = new j(linearLayout, button, textView, textView2);
                    return linearLayout;
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
