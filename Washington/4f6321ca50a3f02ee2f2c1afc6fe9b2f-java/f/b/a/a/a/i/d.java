package f.b.a.a.a.i;

import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.b.a.m;
import e.p.r;
import gov.wa.doh.exposurenotifications.R;

public final /* synthetic */ class d implements r {
    public final /* synthetic */ l a;

    public /* synthetic */ d(l lVar) {
        this.a = lVar;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        l lVar = this.a;
        ExposureNotificationViewModel.a aVar = (ExposureNotificationViewModel.a) obj;
        int i2 = l.b0;
        View view = lVar.F;
        if (view != null) {
            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(R.id.exposures_banner_flipper);
            ViewFlipper viewFlipper2 = (ViewFlipper) view.findViewById(R.id.edge_case_flipper);
            Button button = (Button) view.findViewById(R.id.manage_storage_button);
            int ordinal = aVar.ordinal();
            int i3 = 1;
            int i4 = 8;
            if (ordinal != 1) {
                if (ordinal != 2) {
                    i3 = 3;
                    if (ordinal == 3) {
                        viewFlipper2.setDisplayedChild(2);
                    } else if (ordinal != 4) {
                        if (ordinal != 5) {
                            viewFlipper2.setDisplayedChild(0);
                        } else {
                            viewFlipper2.setDisplayedChild(4);
                            if (m.h.x0(lVar.W)) {
                                i4 = 0;
                            }
                            button.setVisibility(i4);
                        }
                    }
                    viewFlipper2.setVisibility(0);
                    viewFlipper.setDisplayedChild(0);
                    viewFlipper.setVisibility(0);
                }
                viewFlipper2.setDisplayedChild(i3);
                viewFlipper2.setVisibility(0);
                viewFlipper.setDisplayedChild(0);
                viewFlipper.setVisibility(0);
            } else {
                viewFlipper2.setVisibility(8);
                viewFlipper.setVisibility(8);
            }
            lVar.A0(lVar.a0.c.c(), Boolean.valueOf(lVar.a0.c.a.getBoolean("ExposureNotificationSharedPreferences.EXPOSURE_CLASSIFICATION_IS_REVOKED_KEY", false)).booleanValue());
        }
    }
}
