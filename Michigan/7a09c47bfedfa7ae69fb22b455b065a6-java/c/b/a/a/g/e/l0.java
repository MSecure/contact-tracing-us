package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class l0 extends a {
    public static final Parcelable.Creator<l0> CREATOR = new p0();

    /* renamed from: b  reason: collision with root package name */
    public a2 f3632b;

    /* renamed from: c  reason: collision with root package name */
    public z1 f3633c;

    /* renamed from: d  reason: collision with root package name */
    public String f3634d;

    public l0() {
    }

    public l0(IBinder iBinder, IBinder iBinder2, String str) {
        a2 a2Var;
        z1 z1Var = null;
        if (iBinder == null) {
            a2Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryResultListener");
            a2Var = queryLocalInterface instanceof a2 ? (a2) queryLocalInterface : new d2(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
            z1Var = queryLocalInterface2 instanceof z1 ? (z1) queryLocalInterface2 : new b2(iBinder2);
        }
        this.f3632b = a2Var;
        this.f3633c = z1Var;
        this.f3634d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l0) {
            l0 l0Var = (l0) obj;
            return t.j1(this.f3632b, l0Var.f3632b) && t.j1(this.f3633c, l0Var.f3633c) && t.j1(this.f3634d, l0Var.f3634d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3632b, this.f3633c, this.f3634d});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        a2 a2Var = this.f3632b;
        t.p3(parcel, 1, a2Var == null ? null : a2Var.asBinder(), false);
        t.p3(parcel, 2, this.f3633c.asBinder(), false);
        t.w3(parcel, 3, this.f3634d, false);
        t.w4(parcel, m);
    }

    public l0(n0 n0Var) {
    }
}
