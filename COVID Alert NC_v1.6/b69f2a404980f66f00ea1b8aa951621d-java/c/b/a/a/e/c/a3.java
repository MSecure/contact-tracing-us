package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.k.o.h;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.Arrays;
import java.util.List;

public final class a3 extends a {
    public static final Parcelable.Creator<a3> CREATOR = new b3();

    /* renamed from: b  reason: collision with root package name */
    public List<TemporaryExposureKey> f2513b;

    /* renamed from: c  reason: collision with root package name */
    public h f2514c;

    /* renamed from: d  reason: collision with root package name */
    public List<ParcelFileDescriptor> f2515d;

    /* renamed from: e  reason: collision with root package name */
    public ExposureConfiguration f2516e;
    public String f;
    public m1 g;

    public a3() {
    }

    public a3(z2 z2Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a3) {
            a3 a3Var = (a3) obj;
            return i.j.X(this.f2513b, a3Var.f2513b) && i.j.X(this.f2514c, a3Var.f2514c) && i.j.X(this.f2515d, a3Var.f2515d) && i.j.X(this.f2516e, a3Var.f2516e) && i.j.X(this.f, a3Var.f) && i.j.X(this.g, a3Var.g);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2513b, this.f2514c, this.f2515d, this.f2516e, this.f, this.g});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.B1(parcel, 1, this.f2513b, false);
        i.j.t1(parcel, 2, this.f2514c.asBinder(), false);
        i.j.B1(parcel, 3, this.f2515d, false);
        i.j.y1(parcel, 4, this.f2516e, i, false);
        i.j.z1(parcel, 5, this.f, false);
        m1 m1Var = this.g;
        i.j.t1(parcel, 6, m1Var == null ? null : m1Var.asBinder(), false);
        i.j.F1(parcel, e2);
    }

    public a3(List<TemporaryExposureKey> list, IBinder iBinder, List<ParcelFileDescriptor> list2, ExposureConfiguration exposureConfiguration, String str, IBinder iBinder2) {
        m1 m1Var;
        h i0 = h.a.i0(iBinder);
        if (iBinder2 == null) {
            m1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
            m1Var = queryLocalInterface instanceof m1 ? (m1) queryLocalInterface : new o1(iBinder2);
        }
        this.f2513b = list;
        this.f2514c = i0;
        this.f2515d = list2;
        this.f2516e = exposureConfiguration;
        this.f = str;
        this.g = m1Var;
    }
}
