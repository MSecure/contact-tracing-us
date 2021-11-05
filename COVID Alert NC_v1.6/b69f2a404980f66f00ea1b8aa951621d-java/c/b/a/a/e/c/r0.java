package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class r0 extends a {
    public static final Parcelable.Creator<r0> CREATOR = new w0();

    /* renamed from: b  reason: collision with root package name */
    public p2 f2707b;

    public r0() {
    }

    public r0(IBinder iBinder) {
        p2 p2Var;
        if (iBinder == null) {
            p2Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
            p2Var = queryLocalInterface instanceof p2 ? (p2) queryLocalInterface : new r2(iBinder);
        }
        this.f2707b = p2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r0) {
            return i.j.X(this.f2707b, ((r0) obj).f2707b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2707b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 1, this.f2707b.asBinder(), false);
        i.j.F1(parcel, e2);
    }

    public r0(t0 t0Var) {
    }
}
