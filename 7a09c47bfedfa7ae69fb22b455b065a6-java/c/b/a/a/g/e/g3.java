package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.k.o.h;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import java.util.Arrays;

public final class g3 extends a {
    public static final Parcelable.Creator<g3> CREATOR = new h3();

    /* renamed from: b  reason: collision with root package name */
    public h f3574b;

    /* renamed from: c  reason: collision with root package name */
    public ExposureConfiguration f3575c;

    public g3() {
    }

    public g3(IBinder iBinder, ExposureConfiguration exposureConfiguration) {
        this.f3574b = h.a.f0(iBinder);
        this.f3575c = exposureConfiguration;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g3) {
            g3 g3Var = (g3) obj;
            return t.j1(this.f3574b, g3Var.f3574b) && t.j1(this.f3575c, g3Var.f3575c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3574b, this.f3575c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.p3(parcel, 3, this.f3574b.asBinder(), false);
        t.v3(parcel, 4, this.f3575c, i, false);
        t.w4(parcel, m);
    }

    public g3(f3 f3Var) {
    }
}
