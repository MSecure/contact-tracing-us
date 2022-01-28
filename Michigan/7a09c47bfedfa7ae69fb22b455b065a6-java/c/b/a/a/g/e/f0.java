package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class f0 extends a {
    public static final Parcelable.Creator<f0> CREATOR = new j0();

    /* renamed from: b  reason: collision with root package name */
    public q1 f3555b;

    public f0() {
    }

    public f0(IBinder iBinder) {
        q1 q1Var;
        if (iBinder == null) {
            q1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
            q1Var = queryLocalInterface instanceof q1 ? (q1) queryLocalInterface : new t1(iBinder);
        }
        this.f3555b = q1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f0) {
            return t.j1(this.f3555b, ((f0) obj).f3555b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3555b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.p3(parcel, 1, this.f3555b.asBinder(), false);
        t.w4(parcel, m);
    }

    public f0(h0 h0Var) {
    }
}
