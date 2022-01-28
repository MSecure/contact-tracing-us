package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.k.o.h;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import java.util.Arrays;

public final class d3 extends a {
    public static final Parcelable.Creator<d3> CREATOR = new e3();

    /* renamed from: b  reason: collision with root package name */
    public h f2544b;

    /* renamed from: c  reason: collision with root package name */
    public DiagnosisKeysDataMapping f2545c;

    public d3() {
    }

    public d3(IBinder iBinder, DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        this.f2544b = h.a.i0(iBinder);
        this.f2545c = diagnosisKeysDataMapping;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d3) {
            d3 d3Var = (d3) obj;
            return i.j.X(this.f2544b, d3Var.f2544b) && i.j.X(this.f2545c, d3Var.f2545c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2544b, this.f2545c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 1, this.f2544b.asBinder(), false);
        i.j.y1(parcel, 2, this.f2545c, i, false);
        i.j.F1(parcel, e2);
    }

    public d3(c3 c3Var) {
    }
}
