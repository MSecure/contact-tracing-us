package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class i0 extends a {
    public static final Parcelable.Creator<i0> CREATOR = new m0();

    /* renamed from: b  reason: collision with root package name */
    public x1 f2615b;

    /* renamed from: c  reason: collision with root package name */
    public r1 f2616c;

    /* renamed from: d  reason: collision with root package name */
    public String f2617d;

    public i0() {
    }

    public i0(IBinder iBinder, IBinder iBinder2, String str) {
        x1 x1Var;
        r1 r1Var = null;
        if (iBinder == null) {
            x1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationResultListener");
            x1Var = queryLocalInterface instanceof x1 ? (x1) queryLocalInterface : new w1(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationListCallback");
            r1Var = queryLocalInterface2 instanceof r1 ? (r1) queryLocalInterface2 : new u1(iBinder2);
        }
        this.f2615b = x1Var;
        this.f2616c = r1Var;
        this.f2617d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i0) {
            i0 i0Var = (i0) obj;
            return i.j.X(this.f2615b, i0Var.f2615b) && i.j.X(this.f2616c, i0Var.f2616c) && i.j.X(this.f2617d, i0Var.f2617d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2615b, this.f2616c, this.f2617d});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        x1 x1Var = this.f2615b;
        i.j.t1(parcel, 1, x1Var == null ? null : x1Var.asBinder(), false);
        i.j.t1(parcel, 2, this.f2616c.asBinder(), false);
        i.j.z1(parcel, 3, this.f2617d, false);
        i.j.F1(parcel, e2);
    }

    public i0(k0 k0Var) {
    }
}
