package f.b.a.a.a.u;

import android.view.View;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.s.w;

public final /* synthetic */ class g implements w.a {
    public final /* synthetic */ l a;

    public /* synthetic */ g(l lVar) {
        this.a = lVar;
    }

    @Override // f.b.a.a.a.s.w.a
    public final void a(Object obj, Object obj2) {
        l lVar = this.a;
        ExposureNotificationViewModel.b bVar = (ExposureNotificationViewModel.b) obj;
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        a aVar = l.X;
        View view = lVar.F;
        if (view != null && bVar != null) {
            lVar.J0(view, (View) view.getParent(), bVar, booleanValue);
        }
    }
}
