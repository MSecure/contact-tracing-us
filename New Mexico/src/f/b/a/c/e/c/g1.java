package f.b.a.c.e.c;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.f.b.e;
/* loaded from: classes.dex */
public abstract class g1 extends w implements h1 {
    public g1() {
        super("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
    }

    @Override // f.b.a.c.e.c.w
    public final boolean p(int i2, Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 1) {
            return false;
        }
        m.e.S1((Status) j0.a(parcel, Status.CREATOR), parcel.createTypedArrayList(e.CREATOR), ((u) this).a);
        return true;
    }
}
