package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class y extends a {
    public static final Parcelable.Creator<y> CREATOR = new d0();

    /* renamed from: b  reason: collision with root package name */
    public h2 f2808b;

    public y() {
    }

    public y(IBinder iBinder) {
        h2 h2Var;
        if (iBinder == null) {
            h2Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IIntCallback");
            h2Var = queryLocalInterface instanceof h2 ? (h2) queryLocalInterface : new j2(iBinder);
        }
        this.f2808b = h2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return i.j.X(this.f2808b, ((y) obj).f2808b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2808b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 1, this.f2808b.asBinder(), false);
        i.j.F1(parcel, e2);
    }

    public y(b0 b0Var) {
    }
}
