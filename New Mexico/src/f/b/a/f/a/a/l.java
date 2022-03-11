package f.b.a.f.a.a;

import android.os.IBinder;
import android.os.IInterface;
import f.b.a.f.a.e.a0;
import f.b.a.f.a.e.h;
import f.b.a.f.a.e.y;
import f.b.a.f.a.e.z;
/* loaded from: classes.dex */
public final /* synthetic */ class l implements h {
    public static final /* synthetic */ l a = new l();

    @Override // f.b.a.f.a.e.h
    public final Object a(IBinder iBinder) {
        int i2 = z.a;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof a0 ? (a0) queryLocalInterface : new y(iBinder);
    }
}
