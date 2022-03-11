package f.b.a.f.a.e;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public final class j0 extends v implements IInterface {
    public j0(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    public final void B(Bundle bundle) {
        Parcel p = p();
        int i2 = x.a;
        p.writeInt(1);
        bundle.writeToParcel(p, 0);
        z(3, p);
    }
}
