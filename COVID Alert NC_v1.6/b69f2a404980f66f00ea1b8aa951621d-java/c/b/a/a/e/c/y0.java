package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class y0 extends a {
    public static final Parcelable.Creator<y0> CREATOR = new c1();

    /* renamed from: b  reason: collision with root package name */
    public q2 f2809b;

    /* renamed from: c  reason: collision with root package name */
    public s2 f2810c;

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
        this.f2809b = q2Var;
        this.f2810c = s2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y0) {
            y0 y0Var = (y0) obj;
            return i.j.X(this.f2809b, y0Var.f2809b) && i.j.X(this.f2810c, y0Var.f2810c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2809b, this.f2810c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        q2 q2Var = this.f2809b;
        i.j.t1(parcel, 1, q2Var == null ? null : q2Var.asBinder(), false);
        i.j.t1(parcel, 2, this.f2810c.asBinder(), false);
        i.j.F1(parcel, e2);
    }

    public y0(a1 a1Var) {
    }
}
