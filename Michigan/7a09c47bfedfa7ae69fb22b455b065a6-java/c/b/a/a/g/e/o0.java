package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class o0 extends a {
    public static final Parcelable.Creator<o0> CREATOR = new s0();

    /* renamed from: b  reason: collision with root package name */
    public c2 f3670b;

    /* renamed from: c  reason: collision with root package name */
    public String f3671c;

    public o0() {
    }

    public o0(IBinder iBinder, String str) {
        c2 c2Var;
        if (iBinder == null) {
            c2Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureWindowListCallback");
            c2Var = queryLocalInterface instanceof c2 ? (c2) queryLocalInterface : new e2(iBinder);
        }
        this.f3670b = c2Var;
        this.f3671c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o0) {
            o0 o0Var = (o0) obj;
            return t.j1(this.f3670b, o0Var.f3670b) && t.j1(this.f3671c, o0Var.f3671c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3670b, this.f3671c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.p3(parcel, 1, this.f3670b.asBinder(), false);
        t.w3(parcel, 2, this.f3671c, false);
        t.w4(parcel, m);
    }

    public o0(q0 q0Var) {
    }
}
