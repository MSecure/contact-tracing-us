package f.b.a.a.a.j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.i.i;
import f.b.a.a.a.u.s;
import gov.md.covid19.exposurenotifications.R;

public class h extends k {
    public i c0;

    @Override // f.b.a.a.a.j.j
    public void A0(View view, View view2, ExposureNotificationViewModel.a aVar, boolean z) {
        s.c cVar;
        i iVar = this.c0;
        TextView textView = iVar.f2102d;
        TextView textView2 = iVar.c;
        Button button = iVar.b;
        button.setEnabled(true);
        int ordinal = aVar.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            D0(view2, false);
            return;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                D0(view2, true);
                textView.setText(R.string.exposure_notifications_currently_inactive);
                textView2.setText(R.string.location_off_warning);
                button.setText(R.string.device_settings);
                z0(button);
                cVar = s.c.LOCATION_PERMISSION_WARNING_SHOWN;
            } else if (ordinal == 4) {
                D0(view2, true);
                textView.setText(R.string.exposure_notifications_currently_inactive);
                textView2.setText(R.string.location_ble_off_warning);
                button.setText(R.string.device_settings);
                z0(button);
                B0(s.c.LOCATION_PERMISSION_WARNING_SHOWN);
            } else if (ordinal == 5) {
                D0(view2, true);
                view2.setVisibility(0);
                textView.setText(R.string.exposure_notifications_currently_inactive);
                textView2.setText(R.string.storage_low_warning);
                button.setText(R.string.manage_storage);
                y0(button);
                cVar = s.c.LOW_STORAGE_WARNING_SHOWN;
            } else {
                return;
            }
            B0(cVar);
        }
        D0(view2, true);
        textView.setText(R.string.exposure_notifications_currently_inactive);
        textView2.setText(R.string.ble_off_warning);
        button.setText(R.string.device_settings);
        z0(button);
        cVar = s.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
        B0(cVar);
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_edge_cases_about, viewGroup, false);
        int i2 = R.id.edgecase_about_button;
        Button button = (Button) inflate.findViewById(R.id.edgecase_about_button);
        if (button != null) {
            i2 = R.id.edgecase_about_text;
            TextView textView = (TextView) inflate.findViewById(R.id.edgecase_about_text);
            if (textView != null) {
                i2 = R.id.edgecase_about_title;
                TextView textView2 = (TextView) inflate.findViewById(R.id.edgecase_about_title);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) inflate;
                    this.c0 = new i(linearLayout, button, textView, textView2);
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
