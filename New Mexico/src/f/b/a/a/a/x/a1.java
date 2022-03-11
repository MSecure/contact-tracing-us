package f.b.a.a.a.x;

import android.os.Bundle;
import android.view.View;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.o.a.m;
import e.r.f0;
/* loaded from: classes.dex */
public abstract class a1 extends m {
    public ExposureNotificationViewModel W;

    public void H0() {
        u0().finishAndRemoveTask();
    }

    public boolean I0() {
        return false;
    }

    @Override // e.o.a.m
    public void m0(View view, Bundle bundle) {
        this.W = (ExposureNotificationViewModel) new f0(u0()).a(ExposureNotificationViewModel.class);
    }
}
