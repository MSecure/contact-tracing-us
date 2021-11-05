package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class o0 extends a {
    public static final Parcelable.Creator<o0> CREATOR = new s0();

    /* renamed from: b  reason: collision with root package name */
    public c2 f2678b;

    /* renamed from: c  reason: collision with root package name */
    public String f2679c;

    public o0() {
    }

    public o0(IBinder iBinder, String str) {
        c2 c2Var;
        if (iBinder == null) {
            c2Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
            c2Var = queryLocalInterface instanceof c2 ? (c2) queryLocalInterface : new e2(iBinder);
        }
        this.f2678b = c2Var;
        this.f2679c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o0) {
            o0 o0Var = (o0) obj;
            return i.j.X(this.f2678b, o0Var.f2678b) && i.j.X(this.f2679c, o0Var.f2679c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2678b, this.f2679c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 1, this.f2678b.asBinder(), false);
        i.j.z1(parcel, 2, this.f2679c, false);
        i.j.F1(parcel, e2);
    }

    public o0(q0 q0Var) {
    }
}
