package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class f0 extends a {
    public static final Parcelable.Creator<f0> CREATOR = new j0();

    /* renamed from: b  reason: collision with root package name */
    public q1 f2570b;

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
        this.f2570b = q1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f0) {
            return i.j.X(this.f2570b, ((f0) obj).f2570b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2570b});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 1, this.f2570b.asBinder(), false);
        i.j.F1(parcel, e2);
    }

    public f0(h0 h0Var) {
    }
}
