package f.b.a.a.a.p;

import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.b.a.m;
import e.p.r;
import f.b.a.a.a.s.s;
import gov.wi.covid19.exposurenotifications.R;

public final /* synthetic */ class d implements r {
    public final /* synthetic */ f3 a;

    public /* synthetic */ d(f3 f3Var) {
        this.a = f3Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        ExposureNotificationViewModel exposureNotificationViewModel;
        s.c cVar;
        f3 f3Var = this.a;
        ExposureNotificationViewModel.a aVar = (ExposureNotificationViewModel.a) obj;
        int i2 = f3.b0;
        View view = f3Var.F;
        if (view != null) {
            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(R.id.notify_header_banner);
            ViewFlipper viewFlipper2 = (ViewFlipper) view.findViewById(R.id.notify_header_flipper);
            Button button = (Button) view.findViewById(R.id.manage_storage_button);
            int ordinal = aVar.ordinal();
            if (ordinal != 1) {
                int i3 = 0;
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        viewFlipper.setDisplayedChild(0);
                        viewFlipper2.setDisplayedChild(2);
                        exposureNotificationViewModel = f3Var.Z;
                        cVar = s.c.LOCATION_PERMISSION_WARNING_SHOWN;
                    } else if (ordinal == 4) {
                        viewFlipper.setDisplayedChild(0);
                        viewFlipper2.setDisplayedChild(3);
                        ExposureNotificationViewModel exposureNotificationViewModel2 = f3Var.Z;
                        exposureNotificationViewModel2.m.a(s.c.LOCATION_PERMISSION_WARNING_SHOWN);
                    } else if (ordinal != 5) {
                        viewFlipper.setDisplayedChild(0);
                        viewFlipper2.setDisplayedChild(0);
                        return;
                    } else {
                        viewFlipper2.setDisplayedChild(4);
                        viewFlipper.setDisplayedChild(0);
                        if (!m.h.w0(f3Var.W)) {
                            i3 = 8;
                        }
                        button.setVisibility(i3);
                        exposureNotificationViewModel = f3Var.Z;
                        cVar = s.c.LOW_STORAGE_WARNING_SHOWN;
                    }
                    exposureNotificationViewModel.m.a(cVar);
                    return;
                }
                viewFlipper.setDisplayedChild(0);
                viewFlipper2.setDisplayedChild(1);
                exposureNotificationViewModel = f3Var.Z;
                cVar = s.c.BLUETOOTH_DISABLED_WARNING_SHOWN;
                exposureNotificationViewModel.m.a(cVar);
                return;
            }
            viewFlipper.setDisplayedChild(1);
            viewFlipper2.setDisplayedChild(5);
        }
    }
}
