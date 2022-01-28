package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class b1 extends a {
    public static final Parcelable.Creator<b1> CREATOR = new f1();

    /* renamed from: b  reason: collision with root package name */
    public i2 f2525b;

    public b1() {
    }

    public b1(IBinder iBinder) {
        i2 i2Var;
        if (iBinder == null) {
            i2Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
            i2Var = queryLocalInterface instanceof i2 ? (i2) queryLocalInterface : new k2(iBinder);
        }
        this.f2525b = i2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b1) {
            return i.j.X(this.f2525b, ((b1) obj).f2525b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2525b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 1, this.f2525b.asBinder(), false);
        i.j.F1(parcel, e2);
    }

    public b1(d1 d1Var) {
    }
}
