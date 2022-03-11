package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class e0 extends a {
    public static final Parcelable.Creator<e0> CREATOR = new f0();
    public h1 b;
    public String c;

    public e0() {
    }

    public e0(IBinder iBinder, String str) {
        h1 h1Var;
        if (iBinder == null) {
            h1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
            h1Var = queryLocalInterface instanceof h1 ? (h1) queryLocalInterface : new f1(iBinder);
        }
        this.b = h1Var;
        this.c = str;
    }

    public /* synthetic */ e0(d0 d0Var) {
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e0) {
            e0 e0Var = (e0) obj;
            if (m.e.X(this.b, e0Var.b) && m.e.X(this.c, e0Var.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.c2(parcel, 1, this.b.asBinder(), false);
        m.e.g2(parcel, 2, this.c, false);
        m.e.o2(parcel, j2);
    }
}
