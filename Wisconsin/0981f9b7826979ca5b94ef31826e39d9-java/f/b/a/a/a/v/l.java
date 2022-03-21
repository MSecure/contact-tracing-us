package f.b.a.a.a.v;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.b.a.m;
import e.p.r;
import f.b.a.a.a.s.s;
import gov.wi.covid19.exposurenotifications.R;

public final /* synthetic */ class l implements r {
    public final /* synthetic */ ExposureAboutActivity a;

    public /* synthetic */ l(ExposureAboutActivity exposureAboutActivity) {
        this.a = exposureAboutActivity;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel;
        s.c cVar;
        ExposureAboutActivity exposureAboutActivity = this.a;
        int i2 = ExposureAboutActivity.v;
        SwitchMaterial switchMaterial = (SwitchMaterial) exposureAboutActivity.findViewById(R.id.exposure_notification_toggle);
        switchMaterial.setOnCheckedChangeListener(null);
        switchMaterial.setChecked(exposureAboutActivity.r.f333f.d().booleanValue());
        switchMaterial.setOnCheckedChangeListener(exposureAboutActivity.u);
        ViewSwitcher viewSwitcher = (ViewSwitcher) exposureAboutActivity.findViewById(R.id.exposure_about_errors);
        View findViewById = exposureAboutActivity.findViewById(R.id.exposure_about_error_divider);
        TextView textView = (TextView) exposureAboutActivity.findViewById(R.id.error_loc_ble_text);
        LinearLayout linearLayout = (LinearLayout) exposureAboutActivity.findViewById(R.id.exposure_about_detail_layout);
        int ordinal = ((ExposureNotificationViewModel.a) obj).ordinal();
        boolean z = true;
        int i3 = 8;
        if (ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    viewSwitcher.setDisplayedChild(0);
                    findViewById.setVisibility(0);
                    viewSwitcher.setVisibility(0);
                    textView.setText(R.string.location_off_warning);
                    linearLayout.setVisibility(8);
                    exposureNotificationViewModel = exposureAboutActivity.r;
                    cVar = s.c.LOCATION_PERMISSION_WARNING_SHOWN;
                } else if (ordinal == 4) {
                    viewSwitcher.setDisplayedChild(0);
                    findViewById.setVisibility(0);
                    viewSwitcher.setVisibility(0);
                    textView.setText(R.string.location_ble_off_warning);
                    linearLayout.setVisibility(8);
                    ExposureNotificationViewModel exposureNotificationViewModel2 = exposureAboutActivity.r;
                    exposureNotificationViewModel2.m.a(s.c.LOCATION_PERMISSION_WARNING_SHOWN);
                } else if (ordinal != 5) {
                    findViewById.setVisibility(8);
                    viewSwitcher.setVisibility(8);
                } else {
                    viewSwitcher.setDisplayedChild(1);
                    findViewById.setVisibility(0);
                    viewSwitcher.setVisibility(0);
                    linearLayout.setVisibility(8);
                    Button button = (Button) exposureAboutActivity.findViewById(R.id.exposure_about_manage_storage);
                    if (m.h.K(exposureAboutActivity) == null) {
                        z = false;
                    }
                    if (z) {
                        i3 = 0;
                    }
                    button.setVisibility(i3);
                    exposureNotificationViewModel = exposureAboutActivity.r;
                    cVar = s.c.LOW_STORAGE_WARNING_SHOWN;
                }
                exposureNotificationViewModel.m.a(cVar);
                return;
            }
            viewSwitcher.setDisplayedChild(0);
            findViewById.setVisibility(0);
            viewSwitcher.setVisibility(0);
            textView.setText(R.string.ble_off_warning);
            linearLayout.setVisibility(8);
            exposureNotificationViewModel = exposureAboutActivity.r;
            cVar = s.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
            exposureNotificationViewModel.m.a(cVar);
            return;
        }
        viewSwitcher.setVisibility(8);
        findViewById.setVisibility(8);
        linearLayout.setVisibility(0);
    }
}
