package f.b.a.f.a.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class y extends v implements a0 {
    public y(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f.b.a.f.a.e.a0
    public final void j(String str, Bundle bundle, c0 c0Var) {
        Parcel p = p();
        p.writeString(str);
        int i2 = x.a;
        p.writeInt(1);
        bundle.writeToParcel(p, 0);
        p.writeStrongBinder(c0Var);
        z(2, p);
    }
}
