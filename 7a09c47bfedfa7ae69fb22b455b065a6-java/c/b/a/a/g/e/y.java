package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class y extends a {
    public static final Parcelable.Creator<y> CREATOR = new d0();

    /* renamed from: b  reason: collision with root package name */
    public h2 f3815b;

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
        this.f3815b = h2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return t.j1(this.f3815b, ((y) obj).f3815b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3815b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.p3(parcel, 1, this.f3815b.asBinder(), false);
        t.w4(parcel, m);
    }

    public y(b0 b0Var) {
    }
}
