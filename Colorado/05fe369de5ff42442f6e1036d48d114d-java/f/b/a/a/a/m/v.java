package f.b.a.a.a.m;

import android.util.Pair;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.c.a.c.a;
import f.b.b.a.l;

public final /* synthetic */ class v implements a {
    public static final /* synthetic */ v a = new v();

    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        Pair pair = (Pair) obj;
        f.b.a.a.a.i.e0.a aVar = ExposureNotificationViewModel.y;
        if (((Boolean) pair.first).booleanValue()) {
            l lVar = (l) pair.second;
            if (lVar.b()) {
                return Boolean.valueOf(!((Boolean) lVar.a()).booleanValue());
            }
        }
        return Boolean.FALSE;
    }
}
