package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.k.o.h;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import java.util.Arrays;

public final class d3 extends a {
    public static final Parcelable.Creator<d3> CREATOR = new e3();

    /* renamed from: b  reason: collision with root package name */
    public h f3529b;

    /* renamed from: c  reason: collision with root package name */
    public DiagnosisKeysDataMapping f3530c;

    public d3() {
    }

    public d3(IBinder iBinder, DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        this.f3529b = h.a.f0(iBinder);
        this.f3530c = diagnosisKeysDataMapping;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d3) {
            d3 d3Var = (d3) obj;
            return t.j1(this.f3529b, d3Var.f3529b) && t.j1(this.f3530c, d3Var.f3530c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3529b, this.f3530c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.p3(parcel, 1, this.f3529b.asBinder(), false);
        t.v3(parcel, 2, this.f3530c, i, false);
        t.w4(parcel, m);
    }

    public d3(c3 c3Var) {
    }
}
