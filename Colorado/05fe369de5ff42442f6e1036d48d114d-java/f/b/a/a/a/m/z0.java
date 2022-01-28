package f.b.a.a.a.m;

import android.os.Bundle;
import android.view.View;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.m.a.m;
import e.p.f0;

public abstract class z0 extends m {
    public ExposureNotificationViewModel W;

    public boolean A0() {
        return false;
    }

    @Override // e.m.a.m
    public void g0(View view, Bundle bundle) {
        this.W = (ExposureNotificationViewModel) new f0(o0()).a(ExposureNotificationViewModel.class);
    }
}
