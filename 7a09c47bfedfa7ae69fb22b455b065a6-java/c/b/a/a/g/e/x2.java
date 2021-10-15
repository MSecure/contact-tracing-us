package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class x2 extends a {
    public static final Parcelable.Creator<x2> CREATOR = new y2();

    /* renamed from: b  reason: collision with root package name */
    public j1 f3805b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f3806c;

    public x2() {
    }

    public x2(IBinder iBinder, IBinder iBinder2) {
        j1 j1Var;
        e1 e1Var = null;
        if (iBinder == null) {
            j1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanResultListener");
            j1Var = queryLocalInterface instanceof j1 ? (j1) queryLocalInterface : new i1(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
            e1Var = queryLocalInterface2 instanceof e1 ? (e1) queryLocalInterface2 : new g1(iBinder2);
        }
        this.f3805b = j1Var;
        this.f3806c = e1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x2) {
            x2 x2Var = (x2) obj;
            return t.j1(this.f3805b, x2Var.f3805b) && t.j1(this.f3806c, x2Var.f3806c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3805b, this.f3806c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        j1 j1Var = this.f3805b;
        t.p3(parcel, 1, j1Var == null ? null : j1Var.asBinder(), false);
        t.p3(parcel, 2, this.f3806c.asBinder(), false);
        t.w4(parcel, m);
    }

    public x2(w2 w2Var) {
    }
}
