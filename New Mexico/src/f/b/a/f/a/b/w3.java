package f.b.a.f.a.b;

import android.os.IBinder;
import android.os.IInterface;
import f.b.a.f.a.e.d0;
import f.b.a.f.a.e.e0;
import f.b.a.f.a.e.f0;
import f.b.a.f.a.e.h;
/* loaded from: classes.dex */
public final /* synthetic */ class w3 implements h {
    public static final /* synthetic */ w3 a = new w3();

    @Override // f.b.a.f.a.e.h
    public final Object a(IBinder iBinder) {
        int i2 = e0.a;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
        return queryLocalInterface instanceof f0 ? (f0) queryLocalInterface : new d0(iBinder);
    }
}
