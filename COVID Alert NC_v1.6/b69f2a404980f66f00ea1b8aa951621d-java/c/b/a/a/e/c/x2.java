package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class x2 extends a {
    public static final Parcelable.Creator<x2> CREATOR = new y2();

    /* renamed from: b  reason: collision with root package name */
    public j1 f2798b;

    /* renamed from: c  reason: collision with root package name */
    public e1 f2799c;

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
        this.f2798b = j1Var;
        this.f2799c = e1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x2) {
            x2 x2Var = (x2) obj;
            return i.j.X(this.f2798b, x2Var.f2798b) && i.j.X(this.f2799c, x2Var.f2799c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2798b, this.f2799c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        j1 j1Var = this.f2798b;
        i.j.t1(parcel, 1, j1Var == null ? null : j1Var.asBinder(), false);
        i.j.t1(parcel, 2, this.f2799c.asBinder(), false);
        i.j.F1(parcel, e2);
    }

    public x2(w2 w2Var) {
    }
}
