package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class l0 extends a {
    public static final Parcelable.Creator<l0> CREATOR = new p0();

    /* renamed from: b  reason: collision with root package name */
    public a2 f2642b;

    /* renamed from: c  reason: collision with root package name */
    public z1 f2643c;

    /* renamed from: d  reason: collision with root package name */
    public String f2644d;

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
        this.f2642b = a2Var;
        this.f2643c = z1Var;
        this.f2644d = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l0) {
            l0 l0Var = (l0) obj;
            return i.j.X(this.f2642b, l0Var.f2642b) && i.j.X(this.f2643c, l0Var.f2643c) && i.j.X(this.f2644d, l0Var.f2644d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2642b, this.f2643c, this.f2644d});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        a2 a2Var = this.f2642b;
        i.j.t1(parcel, 1, a2Var == null ? null : a2Var.asBinder(), false);
        i.j.t1(parcel, 2, this.f2643c.asBinder(), false);
        i.j.z1(parcel, 3, this.f2644d, false);
        i.j.F1(parcel, e2);
    }

    public l0(n0 n0Var) {
    }
}
