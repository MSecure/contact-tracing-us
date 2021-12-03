package f.b.a.a.a.k;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.c0.a;
import f.b.a.a.a.c0.b;
import f.b.a.a.a.i.b0;
import f.b.a.a.a.j.k;
import f.b.a.a.a.v.n;
import gov.co.cdphe.exposurenotifications.R;

public class j extends m {
    public k b0;

    @Override // f.b.a.a.a.k.l
    public void E0(View view, View view2, ExposureNotificationViewModel.b bVar, boolean z) {
        n.c cVar;
        a aVar;
        String str;
        String str2;
        k kVar = this.b0;
        TextView textView = kVar.f2197d;
        TextView textView2 = kVar.c;
        Button button = kVar.b;
        button.setEnabled(true);
        switch (bVar.ordinal()) {
            case 0:
            case 1:
            case 7:
                H0(view2, false);
                return;
            case 2:
                H0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.ble_off_warning);
                button.setText(R.string.device_settings);
                C0(button);
                cVar = n.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
                F0(cVar);
                return;
            case 3:
                H0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.location_off_warning);
                button.setText(R.string.device_settings);
                C0(button);
                cVar = n.c.LOCATION_PERMISSION_WARNING_SHOWN;
                F0(cVar);
                return;
            case 4:
                H0(view2, true);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.location_ble_off_warning);
                button.setText(R.string.device_settings);
                C0(button);
                F0(n.c.LOCATION_PERMISSION_WARNING_SHOWN);
                cVar = n.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
                F0(cVar);
                return;
            case 5:
                H0(view2, true);
                view2.setVisibility(0);
                textView.setText(R.string.exposure_notifications_are_inactive);
                textView2.setText(R.string.storage_low_warning);
                button.setText(R.string.manage_storage);
                B0(button);
                cVar = n.c.LOW_STORAGE_WARNING_SHOWN;
                F0(cVar);
                return;
            case 6:
                str = A(R.string.learn_more);
                H0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                String A = A(R.string.en_info_main_page_link);
                f.b.a.a.a.i.e0.a aVar2 = b.a;
                aVar = new a(A);
                str2 = B(R.string.en_not_supported_warning, str);
                textView2.setText(b0.b(aVar, str2, str));
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                button.setVisibility(8);
                return;
            case 8:
                str = A(R.string.device_requirements_link_text);
                H0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                String A2 = A(R.string.device_requirements_link);
                f.b.a.a.a.i.e0.a aVar3 = b.a;
                aVar = new a(A2);
                str2 = B(R.string.hw_not_supported_warning, str);
                textView2.setText(b0.b(aVar, str2, str));
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                button.setVisibility(8);
                return;
            case 9:
                H0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                textView2.setText(R.string.not_in_allowlist_warning);
                textView2.setMovementMethod(LinkMovementMethod.getInstance());
                button.setVisibility(8);
                return;
            case 10:
                H0(view2, true);
                textView.setText(R.string.exposure_notifications_are_turned_off);
                textView2.setText(R.string.user_profile_not_supported_warning);
                button.setVisibility(8);
                return;
            default:
                return;
        }
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                    this.b0 = new k(linearLayout, button, textView, textView2);
                    return linearLayout;
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
