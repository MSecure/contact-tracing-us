package f.b.a.a.a.x;

import android.util.Pair;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.c.a.c.a;
import f.b.b.a.l;
/* loaded from: classes.dex */
public final /* synthetic */ class n implements a {
    public static final /* synthetic */ n a = new n();

    @Override // e.c.a.c.a
    public final Object a(Object obj) {
        Pair pair = (Pair) obj;
        f.b.a.a.a.t.p0.a aVar = ExposureNotificationViewModel.y;
        return ((Boolean) pair.first).booleanValue() ? l.c(Boolean.TRUE) : (l) pair.second;
    }
}
