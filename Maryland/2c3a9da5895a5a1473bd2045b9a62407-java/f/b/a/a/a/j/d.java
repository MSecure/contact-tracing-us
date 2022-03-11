package f.b.a.a.a.j;

import android.view.View;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.p.r;

public final /* synthetic */ class d implements r {
    public final /* synthetic */ j a;

    public /* synthetic */ d(j jVar) {
        this.a = jVar;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        j jVar = this.a;
        ExposureNotificationViewModel.b bVar = (ExposureNotificationViewModel.b) obj;
        int i2 = j.Y;
        View view = jVar.F;
        if (view != null && bVar.a != null) {
            jVar.A0(view, (View) view.getParent(), bVar.a, bVar.b);
        }
    }
}
