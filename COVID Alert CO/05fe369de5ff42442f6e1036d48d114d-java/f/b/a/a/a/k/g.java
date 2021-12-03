package f.b.a.a.a.k;

import android.view.View;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.i.x;

public final /* synthetic */ class g implements x.a {
    public final /* synthetic */ l a;

    public /* synthetic */ g(l lVar) {
        this.a = lVar;
    }

    @Override // f.b.a.a.a.i.x.a
    public final void a(Object obj, Object obj2) {
        l lVar = this.a;
        ExposureNotificationViewModel.b bVar = (ExposureNotificationViewModel.b) obj;
        boolean booleanValue = ((Boolean) obj2).booleanValue();
        a aVar = l.X;
        View view = lVar.F;
        if (view != null && bVar != null) {
            lVar.E0(view, (View) view.getParent(), bVar, booleanValue);
        }
    }
}
