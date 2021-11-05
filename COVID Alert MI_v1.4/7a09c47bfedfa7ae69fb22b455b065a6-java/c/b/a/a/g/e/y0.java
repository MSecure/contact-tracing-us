package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class y0 extends a {
    public static final Parcelable.Creator<y0> CREATOR = new c1();

    /* renamed from: b  reason: collision with root package name */
    public q2 f3816b;

    /* renamed from: c  reason: collision with root package name */
    public s2 f3817c;

    public y0() {
    }

    public y0(IBinder iBinder, IBinder iBinder2) {
        q2 q2Var;
        s2 s2Var = null;
        if (iBinder == null) {
            q2Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyHistoryResultListener");
            q2Var = queryLocalInterface instanceof q2 ? (q2) queryLocalInterface : new t2(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
            s2Var = queryLocalInterface2 instanceof s2 ? (s2) queryLocalInterface2 : new u2(iBinder2);
        }
        this.f3816b = q2Var;
        this.f3817c = s2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y0) {
            y0 y0Var = (y0) obj;
            return t.j1(this.f3816b, y0Var.f3816b) && t.j1(this.f3817c, y0Var.f3817c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3816b, this.f3817c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        q2 q2Var = this.f3816b;
        t.p3(parcel, 1, q2Var == null ? null : q2Var.asBinder(), false);
        t.p3(parcel, 2, this.f3817c.asBinder(), false);
        t.w4(parcel, m);
    }

    public y0(a1 a1Var) {
    }
}
