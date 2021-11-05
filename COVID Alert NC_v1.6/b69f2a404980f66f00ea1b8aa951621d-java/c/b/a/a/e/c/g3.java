package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.k.o.h;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import java.util.Arrays;

public final class g3 extends a {
    public static final Parcelable.Creator<g3> CREATOR = new h3();

    /* renamed from: b  reason: collision with root package name */
    public h f2589b;

    /* renamed from: c  reason: collision with root package name */
    public ExposureConfiguration f2590c;

    public g3() {
    }

    public g3(IBinder iBinder, ExposureConfiguration exposureConfiguration) {
        this.f2589b = h.a.i0(iBinder);
        this.f2590c = exposureConfiguration;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g3) {
            g3 g3Var = (g3) obj;
            return i.j.X(this.f2589b, g3Var.f2589b) && i.j.X(this.f2590c, g3Var.f2590c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2589b, this.f2590c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.t1(parcel, 3, this.f2589b.asBinder(), false);
        i.j.y1(parcel, 4, this.f2590c, i, false);
        i.j.F1(parcel, e2);
    }

    public g3(f3 f3Var) {
    }
}
