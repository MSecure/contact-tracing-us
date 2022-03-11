package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class o0 extends a {
    public static final Parcelable.Creator<o0> CREATOR = new p0();
    public t1 b;
    public q1 c;

    public o0() {
    }

    public o0(IBinder iBinder, IBinder iBinder2) {
        q1 q1Var;
        t1 t1Var = null;
        if (iBinder == null) {
            q1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyHistoryResultListener");
            q1Var = queryLocalInterface instanceof q1 ? (q1) queryLocalInterface : new q1(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
            t1Var = queryLocalInterface2 instanceof t1 ? (t1) queryLocalInterface2 : new r1(iBinder2);
        }
        this.c = q1Var;
        this.b = t1Var;
    }

    public /* synthetic */ o0(n0 n0Var) {
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o0) {
            o0 o0Var = (o0) obj;
            if (m.e.X(this.c, o0Var.c) && m.e.X(this.b, o0Var.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.b});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder iBinder;
        int j2 = m.e.j2(parcel, 20293);
        q1 q1Var = this.c;
        if (q1Var == null) {
            iBinder = null;
        } else {
            iBinder = q1Var.a;
        }
        m.e.c2(parcel, 1, iBinder, false);
        m.e.c2(parcel, 2, this.b.asBinder(), false);
        m.e.o2(parcel, j2);
    }
}
