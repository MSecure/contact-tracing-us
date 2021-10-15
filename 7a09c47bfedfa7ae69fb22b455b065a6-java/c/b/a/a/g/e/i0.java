package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class i0 extends a {
    public static final Parcelable.Creator<i0> CREATOR = new m0();

    /* renamed from: b  reason: collision with root package name */
    public x1 f3603b;

    /* renamed from: c  reason: collision with root package name */
    public r1 f3604c;

    /* renamed from: d  reason: collision with root package name */
    public String f3605d;

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
        this.f3603b = x1Var;
        this.f3604c = r1Var;
        this.f3605d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i0) {
            i0 i0Var = (i0) obj;
            return t.j1(this.f3603b, i0Var.f3603b) && t.j1(this.f3604c, i0Var.f3604c) && t.j1(this.f3605d, i0Var.f3605d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3603b, this.f3604c, this.f3605d});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        x1 x1Var = this.f3603b;
        t.p3(parcel, 1, x1Var == null ? null : x1Var.asBinder(), false);
        t.p3(parcel, 2, this.f3604c.asBinder(), false);
        t.w3(parcel, 3, this.f3605d, false);
        t.w4(parcel, m);
    }

    public i0(k0 k0Var) {
    }
}
